package com.javachap.web.controller;

import com.javachap.web.model.LanguageForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LanguageAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        LanguageForm languageForm = (LanguageForm) form;
        Locale locale;

        if ("french".equals(languageForm.getLanguage())) {
            locale = Locale.FRENCH;
        } else if ("spanish".equals(languageForm.getLanguage())) {
            locale = new Locale("es", "ES");
        } else {
            locale = Locale.ENGLISH;
        }

        request.getSession().setAttribute("display", locale);
        return mapping.findForward("leadListing");
    }
}
