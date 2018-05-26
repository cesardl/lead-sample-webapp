package com.javachap.service;

import com.javachap.domain.Lead;
import com.javachap.domain.User;

import java.util.List;

public interface LeadService extends Service {

    Lead getLead(Long id);

    Lead save(Lead lead);

    void delete(Lead lead);

    List<Lead> getLeadsByUser(User user);
}
