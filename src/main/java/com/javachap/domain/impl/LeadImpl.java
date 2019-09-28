package com.javachap.domain.impl;

import com.javachap.domain.Category;
import com.javachap.domain.Lead;
import com.javachap.domain.User;

import java.math.BigDecimal;

public class LeadImpl extends DomainImpl implements Lead {

    private static final long serialVersionUID = 4970184160256555723L;
    private String title;
    private String description;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private BigDecimal price;
    private Category category;
    private User owner;
    private String status;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LeadImpl[" +
                "category = " + category +
                " description = " + description +
                " email = " + email +
                " firstName = " + firstName +
                " lastName = " + lastName +
                " owner = " + owner +
                " phone = " + phone +
                " price = " + price +
                " status = " + status +
                " title = " + title +
                " createdDate = " + createdDate +
                " modifiedDate = " + modifiedDate +
                "]";
    }
}
