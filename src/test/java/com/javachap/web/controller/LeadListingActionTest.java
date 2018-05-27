package com.javachap.web.controller;

import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LeadListingForm;
import servletunit.struts.MockStrutsTestCase;

/**
 * Created on 26/05/2018.
 *
 * @author Cesardl
 */
public class LeadListingActionTest extends MockStrutsTestCase {

    public LeadListingActionTest(String testName) {
        super(testName);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getRequest().getSession().setAttribute("user", ServiceUtils.getUserService().getUser(2L));
    }

    public void testDeleteSingleLead() {
        LeadListingForm leadListingForm = new LeadListingForm();
        leadListingForm.setLeadId(1L);
        leadListingForm.setAction("delete");

        setRequestPathInfo("/leadListing");
        setActionForm(leadListingForm);
        actionPerform();

        verifyInputForward();
    }

    public void testDeleteAllLeads() {
        LeadListingForm leadListingForm = new LeadListingForm();
        leadListingForm.setLeadIds(new String[]{"2", "3", "4", "5"});
        leadListingForm.setAction("deleteLeads");

        setRequestPathInfo("/leadListing");
        setActionForm(leadListingForm);
        actionPerform();

        verifyInputForward();
    }

}