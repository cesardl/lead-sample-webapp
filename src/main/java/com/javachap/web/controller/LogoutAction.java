package com.javachap.web.controller;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LogoutAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        Locale display = (Locale) request.getSession().getAttribute("display");
        request.getSession().invalidate();
        request.getSession().setAttribute("display", display);
        return mapping.findForward("login");
    }
}
