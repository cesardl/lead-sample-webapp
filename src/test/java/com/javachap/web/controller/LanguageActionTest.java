package com.javachap.web.controller;

import com.javachap.web.model.LanguageForm;
import servletunit.struts.MockStrutsTestCase;

import java.util.Locale;

/**
 * Created on 26/05/2018.
 *
 * @author Cesardl
 */
public class LanguageActionTest extends MockStrutsTestCase {

    public LanguageActionTest(String testName) {
        super(testName);
    }

    public void testSettingFrenchLocale() {
        LanguageForm languageForm = new LanguageForm();
        languageForm.setLanguage("french");

        setRequestPathInfo("/language");
        setActionForm(languageForm);
        actionPerform();

        verifyForward("home");

        assertEquals(Locale.FRENCH, getSession().getAttribute("display"));

        verifyNoActionErrors();
    }

    public void testSettingSpanishLocale() {
        LanguageForm languageForm = new LanguageForm();
        languageForm.setLanguage("spanish");

        setRequestPathInfo("/language");
        setActionForm(languageForm);
        actionPerform();

        verifyForward("home");

        assertEquals(new Locale("es", "ES"), getSession().getAttribute("display"));

        verifyNoActionErrors();
    }

    public void testSettingEnglishLocale() {
        setRequestPathInfo("/language");
        setActionForm(new LanguageForm());
        actionPerform();

        verifyForward("home");

        assertEquals(Locale.ENGLISH, getSession().getAttribute("display"));

        verifyNoActionErrors();
    }
}