package com.javachap.web.model;

public class LeadForm extends BaseForm {

    private static final long serialVersionUID = -5441178284947594508L;
    private String category;
    private String title;
    private String description;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String price;
    private Long leadId;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getLeadId() {
        return (this.leadId);
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }
}

