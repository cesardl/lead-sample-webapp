package com.javachap.web.controller;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class SecuredAction extends Action {

    @Override
    public final ActionForward execute(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request, HttpServletResponse response) {

        ActionForward forward = null;
        if (request.getSession().getAttribute("user") != null) {
            forward = lmsExecute(mapping, form, request, response);
        } else {
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_MESSAGE,
                    new ActionMessage("error.label.authRequired"));
            saveErrors(request, errors);
            forward = mapping.findForward("login");
        }
        return forward;
    }

    public abstract ActionForward lmsExecute(ActionMapping mapping, ActionForm form,
                                             HttpServletRequest request, HttpServletResponse response);
}

