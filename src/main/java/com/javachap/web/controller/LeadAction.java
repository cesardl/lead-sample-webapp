package com.javachap.web.controller;

import com.javachap.domain.Category;
import com.javachap.domain.Lead;
import com.javachap.domain.User;
import com.javachap.domain.impl.LeadImpl;
import com.javachap.service.LeadService;
import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LeadForm;
import org.apache.struts.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeadAction extends SecuredAction {

    private static final Logger LOG = LoggerFactory.getLogger(LeadAction.class);

    // Form property
    private static final String FORM_PROPERTY_PRICE = "price";

    // Forwards
    private static final String FORWARD_EDIT_LEAD = "leadCreateEdit";
    private static final String FORWARD_HOME = "home";

    // Messages
    private static final String ERROR_LABEL_MANDATORY = "error.label.mandatory";

    public ActionForward lmsExecute(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response) {

        LeadForm leadForm = (LeadForm) form;
        ActionForward forward;

        List<Category> categoryList = ServiceUtils.getCategoryService().getAllCategories();
        request.setAttribute("categoryList", categoryList);

        String leadFormAction = leadForm.getAction();
        LOG.info("Form action '{}'", leadFormAction);

        if ("save".equalsIgnoreCase(leadFormAction)) {
            forward = saveLead(mapping, leadForm, request);

        } else if ("cancel".equalsIgnoreCase(leadFormAction)) {
            forward = mapping.findForward(FORWARD_HOME);

        } else if ("edit".equalsIgnoreCase(leadFormAction)) {
            Long leadId = leadForm.getLeadId();
            Lead lead = ServiceUtils.getLeadService().getLead(leadId);
            LOG.debug("Lead to edit {}", lead);
            String id = String.valueOf(ServiceUtils.getCategoryService().getCategory(lead.getCategory().getId()).getId());
            leadForm.setCategory(id);
            leadForm.setTitle(lead.getTitle());
            leadForm.setDescription(lead.getDescription());
            leadForm.setFirstName(lead.getFirstName());
            leadForm.setLastName(lead.getLastName());
            leadForm.setEmail(lead.getEmail());
            leadForm.setPhone(lead.getPhone());
            leadForm.setPrice(String.valueOf(lead.getPrice()));
            leadForm.setLeadId(leadId);

            LOG.info("Preparing to edit lead {}", lead.getTitle());
            forward = mapping.findForward(FORWARD_EDIT_LEAD);

        } else if ("delete".equalsIgnoreCase(leadFormAction)) {
            leadForm.setAction(leadFormAction);
            leadForm.setLeadId(leadForm.getLeadId());
            forward = mapping.findForward(FORWARD_HOME);

        } else if ("publish".equalsIgnoreCase(leadFormAction)) {
            LeadService leadService = ServiceUtils.getLeadService();
            Lead lead = leadService.getLead(leadForm.getLeadId());
            LOG.debug("Lead to publish {}", lead);
            lead.setStatus(Lead.Status.PUBLISHED.toString());
            lead = leadService.save(lead);
            LOG.info("Published lead: {}", lead);
            ActionMessages messages = new ActionMessages();
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("message.lead.publish"));
            saveMessages(request, messages);
            forward = mapping.findForward(FORWARD_HOME);

        } else if (leadForm.getLeadId() != null) {
            LOG.info("Showing lead detail for {}", leadForm.getLeadId());
            Lead lead = ServiceUtils.getLeadService().getLead(leadForm.getLeadId());
            LOG.debug("Lead obtained {}", lead);
            request.setAttribute("lead", lead);
            forward = mapping.getInputForward();
        } else {
            LOG.info("Preparing to create new lead");
            forward = mapping.findForward(FORWARD_EDIT_LEAD);
        }
        return forward;
    }

    private ActionForward saveLead(final ActionMapping mapping, final LeadForm leadForm, final HttpServletRequest request) {
        ActionErrors errors = validForm(leadForm);

        if (errors.isEmpty()) {
            User user = (User) request.getSession().getAttribute("user");
            Lead lead;
            LeadService leadService = ServiceUtils.getLeadService();
            Long leadId = leadForm.getLeadId();
            if (leadId <= 0) {
                lead = new LeadImpl();
                lead.setStatus(Lead.Status.NEW.toString());
                lead.setCreatedDate(new Date());

                ActionMessages messages = new ActionMessages();
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("message.lead.insert"));
                saveMessages(request, messages);
            } else {
                lead = leadService.getLead(leadId);
                lead.setModifiedDate(new Date());

                ActionMessages messages = new ActionMessages();
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("message.lead.update"));
                saveMessages(request, messages);
            }
            Long categoryId = Long.parseLong(leadForm.getCategory());
            LOG.info("Category Id to find: {}", categoryId);
            Category category = ServiceUtils.getCategoryService().getCategory(categoryId);
            LOG.info("Category Id to obtained: {}", category.getId());
            lead.setCategory(category);
            lead.setTitle(leadForm.getTitle());
            lead.setDescription(leadForm.getDescription());
            lead.setFirstName(leadForm.getFirstName());
            lead.setLastName(leadForm.getLastName());
            lead.setEmail(leadForm.getEmail());
            lead.setPhone(leadForm.getPhone());
            lead.setPrice(new BigDecimal(leadForm.getPrice()));
            lead.setOwner(user);
            lead = leadService.save(lead);
            LOG.info("Saved lead: {}", lead);
            return mapping.findForward(FORWARD_HOME);
        } else {
            saveErrors(request, errors);
            return mapping.findForward(FORWARD_EDIT_LEAD);
        }
    }

    private ActionErrors validForm(final LeadForm leadForm) {
        ActionErrors errors = new ActionErrors();
        if (Integer.parseInt(leadForm.getCategory()) == 0) {
            errors.add("category", new ActionMessage(ERROR_LABEL_MANDATORY));
        }
        if (leadForm.getTitle().trim().isEmpty()) {
            errors.add("title", new ActionMessage(ERROR_LABEL_MANDATORY));
        }
        if (leadForm.getDescription().trim().isEmpty()) {
            errors.add("description", new ActionMessage(ERROR_LABEL_MANDATORY));
        }
        if (leadForm.getFirstName().trim().isEmpty()) {
            errors.add("firstName", new ActionMessage(ERROR_LABEL_MANDATORY));
        }
        if (leadForm.getLastName().trim().isEmpty()) {
            errors.add("lastName", new ActionMessage(ERROR_LABEL_MANDATORY));
        }
        if (leadForm.getEmail().trim().isEmpty()) {
            errors.add("email", new ActionMessage(ERROR_LABEL_MANDATORY));
        }
        if (leadForm.getPrice().trim().isEmpty()) {
            errors.add(FORM_PROPERTY_PRICE, new ActionMessage(ERROR_LABEL_MANDATORY));
        } else {
            try {
                float priceValue = Float.parseFloat(leadForm.getPrice());
                if (priceValue < 0) {
                    errors.add(FORM_PROPERTY_PRICE, new ActionMessage("error.label.greaterThanZero"));
                }
            } catch (NumberFormatException numberFormatException) {
                errors.add(FORM_PROPERTY_PRICE, new ActionMessage("error.label.numberOnly"));
            }
        }
        return errors;
    }
}
