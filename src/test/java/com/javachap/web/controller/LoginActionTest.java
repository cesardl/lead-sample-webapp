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
        assertEquals(loginForm.getEmail(), result.getEmail());
        assertEquals(loginForm.getPassword(), result.getPassword());
        assertEquals("Cesar", result.getFirstName());
        assertEquals("Diaz", result.getLastName());

        verifyNoActionErrors();
    }

    public void testFailedLogin() {
        LoginForm loginForm = new LoginForm();
        loginForm.setEmail("cesar.dl88@gmail.com");
        loginForm.setPassword("xxxxxx");
        loginForm.setAction("login");

        setRequestPathInfo("/login");
        setActionForm(loginForm);
        actionPerform();

        verifyInputForward();
        verifyActionErrors(new String[]{"error.login.failed"});
        assertNull(getSession().getAttribute("user"));
    }

    public void testFromLogoutForwarding() {
        setRequestPathInfo("/login");
        actionPerform();

        verifyInputForward();
        verifyNoActionErrors();
    }
}
