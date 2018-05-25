package com.javachap.service.impl;

import com.javachap.domain.Category;
import com.javachap.domain.Lead;
import com.javachap.domain.User;
import com.javachap.domain.impl.CategoryImpl;
import com.javachap.domain.impl.LeadImpl;
import com.javachap.domain.impl.UserImpl;
import com.javachap.service.CategoryService;
import com.javachap.service.LeadService;
import com.javachap.service.ServiceUtils;
import com.javachap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Test {

    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    public static void main(String args[]) {

        UserService userService = ServiceUtils.getUserService();
        // User Authenticate
        User user = userService.authenticate("user@javachap.com", "javachap");
        LOG.info("User:" + user);

        // User Save
        user = new UserImpl();
        user.setFirstName("java");
        user.setLastName("chap");
        user.setEmail("email" + System.currentTimeMillis() + "@github.com");
        user.setPassword("test");
        userService.save(user);

        // User Get
        user = userService.getUser(user.getId());
        LOG.info("User:" + user);

        CategoryService categoryService = ServiceUtils.getCategoryService();

        // Category Save
        Category category = new CategoryImpl();
        category.setName("Test Name_" + System.currentTimeMillis());
        category.setDescription("Test Description");
        categoryService.save(category);

        category = categoryService.getCategory("IT Services");
        LOG.info("Category {}", category);

        List<Category> categories = categoryService.getAllCategories();
        LOG.info("Categories {}", categories);

        category = categoryService.getCategory(category.getId());
        LOG.info("Category {}", category);

        LeadService leadService = ServiceUtils.getLeadService();
        Lead lead = new LeadImpl();
        lead.setTitle("Test Title");
        lead.setDescription("Test Description");
        lead.setFirstName("Test");
        lead.setLastName("test");
        lead.setEmail("test");
        lead.setPhone("12333");
        lead.setPrice(10.2f);
        lead.setStatus(Lead.Status.Published.toString());
        lead.setCategory(category);
        lead.setOwner(user);
        leadService.save(lead);

        lead = leadService.getLead(lead.getId());
        LOG.info("Lead {}", lead);
    }
}
