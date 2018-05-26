package com.javachap.web.model;

public class LeadListingForm extends BaseForm {

    private static final long serialVersionUID = -6519972467246625078L;
    /**
     * LeadId
     */
    protected Long leadId = null;
    /**
     * LeadIds
     */
    protected String[] leadIds = null;

    public Long getLeadId() {
        return this.leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    public String[] getLeadIds() {
        return this.leadIds;
    }

    public void setLeadIds(String[] leadIds) {
        this.leadIds = leadIds;
    }
}
