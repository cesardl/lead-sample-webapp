package com.javachap.web.controller;

import servletunit.struts.MockStrutsTestCase;

/**
 * Created on 26/05/2018.
 *
 * @author Cesardl
 */
public class LogoutActionTest extends MockStrutsTestCase {

    public LogoutActionTest(String testName) {
        super(testName);
    }

    public void testLogout() {
        setRequestPathInfo("/logout");
        actionPerform();

        verifyForward("login");
        verifyNoActionErrors();
        verifyNoActionMessages();
    }
}