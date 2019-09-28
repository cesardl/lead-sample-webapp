package com.javachap.web.controller;

import com.javachap.Stubs;
import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LeadForm;
import servletunit.struts.MockStrutsTestCase;

/**
 * Created on 28/09/2019.
 *
 * @author Cesardl
 */
public class LeadActionCreateEditTest extends MockStrutsTestCase {

    public LeadActionCreateEditTest(String testName) {
        super(testName);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getRequest().getSession().setAttribute("user", ServiceUtils.getUserService().getUser(1L));
    }

    public void testMandatoryErrorsOnLead() {
        // Save
        LeadForm leadForm = new LeadForm();
        leadForm.setCategory("0");
        leadForm.setTitle("");
        leadForm.setDescription("");
        leadForm.setFirstName("");
        leadForm.setLastName("");
        leadForm.setEmail("");
        leadForm.setPrice("");
        leadForm.setAction("save");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        String[] errors = new String[7];
        for (int i = 0; i < 7; i++) {
            errors[i] = "error.label.mandatory";
        }
        verifyActionErrors(errors);
        verifyForward("leadCreateEdit");
    }

    public void testPriceShouldBeGreaterThenZero() {
        LeadForm leadForm = Stubs.leadForm();
        leadForm.setPrice("-1");
        leadForm.setAction("save");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyActionErrors(new String[]{"error.label.greaterThanZero"});
        verifyForward("leadCreateEdit");
    }

    public void testPriceShouldBeNumberOnly() {
        LeadForm leadForm = Stubs.leadForm();
        leadForm.setPrice("a");
        leadForm.setAction("save");

        setRequestPathInfo("/lead");
        setActionForm(leadForm);
        actionPerform();

        verifyActionErrors(new String[]{"error.label.numberOnly"});
        verifyForward("leadCreateEdit");
    }
}
