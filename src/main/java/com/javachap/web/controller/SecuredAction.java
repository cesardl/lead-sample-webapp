package com.javachap.web.controller;

import org.apache.struts.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class SecuredAction extends Action {

    private static final Logger LOG = LoggerFactory.getLogger(SecuredAction.class);

    @Override
    public final ActionForward execute(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request, HttpServletResponse response) {

        ActionForward forward;
        Object user = request.getSession().getAttribute("user");
        LOG.info("Logged user: {}", user);
        if (user == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_MESSAGE,
                    new ActionMessage("error.label.authRequired"));
            saveErrors(request, errors);
            forward = mapping.findForward("login");
        } else {
            forward = lmsExecute(mapping, form, request, response);
        }
        return forward;
    }

    public abstract ActionForward lmsExecute(ActionMapping mapping, ActionForm form,
                                             HttpServletRequest request, HttpServletResponse response);
}

