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
        Locale locale = null;

        if (("french").equals(languageForm.getLanguage())) {
            locale = Locale.FRENCH;
        } else {
            locale = Locale.ENGLISH;
        }
        request.getSession().setAttribute("display", locale);
        ActionForward forward = mapping.findForward("leadListing");
        return forward;
    }
}
