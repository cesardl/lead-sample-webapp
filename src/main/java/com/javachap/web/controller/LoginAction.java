package com.javachap.web.controller;

import com.javachap.domain.User;
import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LoginForm;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        LoginForm loginForm = (LoginForm) form;
        String action = loginForm.getAction();
        ActionForward forward = mapping.getInputForward();
        if ("login".equalsIgnoreCase(action)) {
            String email = loginForm.getEmail();
            String password = loginForm.getPassword();

            User user = ServiceUtils.getUserService().authenticate(email, password);

            if (user == null) {
                ActionErrors errors = new ActionErrors();
                errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.login.failed"));
                saveErrors(request, errors);
            } else {
                request.getSession(true).setAttribute("user", user);
                forward = mapping.findForward("home");
            }
        }
        return forward;
    }
}
