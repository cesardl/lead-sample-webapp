package com.javachap.web.controller;

import com.javachap.domain.User;
import com.javachap.web.model.LoginForm;
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

        LoginForm loginForm = new LoginForm();
        loginForm.setEmail("cesar.dl88@gmail.com");
        loginForm.setPassword("123456");
        loginForm.setAction("login");

        setRequestPathInfo("/login");
        setActionForm(loginForm);
        actionPerform();
        verifyForward("home");

        User result = (User) getSession().getAttribute("user");

        assertEquals("Cesar", result.getFirstName());
        assertEquals("Diaz", result.getLastName());

        verifyNoActionErrors();
    }
}