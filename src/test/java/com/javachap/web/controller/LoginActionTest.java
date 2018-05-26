package com.javachap.web.controller;

import com.javachap.web.model.LoginForm;
import org.apache.struts.action.ActionForm;
import servletunit.struts.MockStrutsTestCase;

/**
 * Created on 26/05/2018.
 *
 * @author Cesardl
 */
public class LoginActionTest extends MockStrutsTestCase {

    public LoginActionTest(String testName) {
        super(testName);
    }

    public void testSuccessfulLogin() {
        setRequestPathInfo("/login");
        LoginForm loginForm = new LoginForm();
        loginForm.setEmail("cesar.dl88@gmail.com");
        loginForm.setPassword("123456");
        loginForm.setAction("login");
        setActionForm(loginForm);
//        addRequestParameter("email","cesar.dl88@gmail.com");
//        addRequestParameter("password","123456");
        actionPerform();
        verifyForward("home");
    }
}