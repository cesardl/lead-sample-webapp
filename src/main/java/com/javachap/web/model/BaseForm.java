package com.javachap.web.model;

import org.apache.struts.action.ActionForm;

public class BaseForm extends ActionForm {

    private static final long serialVersionUID = -3298183685105683583L;
    /**
     * Action
     */
    protected String action = null;

    public String getAction() {
        return (this.action);
    }

    public void setAction(String action) {
        this.action = action;
    }
}
