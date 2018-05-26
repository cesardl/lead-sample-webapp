package com.javachap.web.model;

public class LoginForm extends BaseForm {

    private static final long serialVersionUID = -4231585109166535780L;
    /**
     * Email
     */
    protected String email = null;
    /**
     * Password
     */
    protected String password = null;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
