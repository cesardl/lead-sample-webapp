package com.javachap.web.controller;

import com.javachap.Stubs;
import com.javachap.domain.Lead;
import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LeadForm;
import servletunit.struts.MockStrutsTestCase;

/**
 * Created on 26/05/2018.
 *
 * @author Cesardl
 */
public class LeadActionTest extends MockStrutsTestCase {

    public LeadActionTest(String testName) {
        super(testName);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getRequest().getSession().setAttribute("user", ServiceUtils.getUserService().getUser(1L));
    }

    public void testTryingToCancel() {
        LeadForm leadForm = new LeadForm();
        leadForm.setAction("cancel");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyForward("home");
        verifyNoActionErrors();
        verifyNoActionMessages();
    }

    public void testTryingToDelete() {
        LeadForm leadForm = new LeadForm();
        leadForm.setAction("delete");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyForward("home");
        verifyNoActionErrors();
        verifyNoActionMessages();
    }

    public void testGetLeadById() {
        LeadForm leadForm = new LeadForm();
        leadForm.setLeadId(1L);

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyInputForward();

        Lead result = (Lead) getRequest().getAttribute("lead");
        assertEquals("Mi first lead", result.getTitle());
        assertEquals("Pablo Cesar", result.getFirstName());
        assertEquals("Diaz Lurita", result.getLastName());
        assertEquals("cesar.dl88@gmail.com", result.getEmail());

        verifyNoActionErrors();
        verifyNoActionMessages();
    }

    public void testCreateAndSaveLead() {
        // New
        setRequestPathInfo("/lead");
        setActionForm(new LeadForm());
        actionPerform();

        verifyForward("leadCreateEdit");
        verifyNoActionErrors();
        verifyNoActionMessages();

        // Save
        LeadForm leadForm = Stubs.leadForm();
        leadForm.setAction("save");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyForward("home");
        verifyNoActionErrors();
        verifyActionMessages(new String[]{"message.lead.insert"});
    }

    public void testEditAndSaveLead() {
        // Edit
        LeadForm leadForm = Stubs.leadForm();
        leadForm.setLeadId(1L);
        leadForm.setAction("edit");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyForward("leadCreateEdit");
        verifyNoActionErrors();
        verifyNoActionMessages();

        // save
        leadForm.setAction("save");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyForward("home");
        verifyNoActionErrors();
        verifyActionMessages(new String[]{"message.lead.update"});
    }

    public void testEditAndPublishLead() {
        // Edit
        LeadForm leadForm = Stubs.leadForm();
        leadForm.setLeadId(2L);
        leadForm.setAction("edit");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyForward("leadCreateEdit");
        verifyNoActionErrors();
        verifyNoActionMessages();

        // Publish
        leadForm.setAction("publish");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyForward("home");
        verifyNoActionErrors();
        verifyActionMessages(new String[]{"message.lead.publish"});
    }
}
