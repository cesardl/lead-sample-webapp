package com.javachap;

import com.javachap.web.model.LeadForm;

import java.util.UUID;

/**
 * Created on 28/09/2019.
 *
 * @author Cesardl
 */
public final class Stubs {

    public static LeadForm leadForm() {
        UUID uuid = UUID.randomUUID();
        LeadForm leadForm = new LeadForm();
        leadForm.setLeadId(0L);
        leadForm.setTitle(uuid.toString());
        leadForm.setDescription("Test Description " + uuid);
        leadForm.setFirstName("Test");
        leadForm.setLastName("test");
        leadForm.setEmail("test@javachap.com");
        leadForm.setPhone("12333");
        leadForm.setPrice("10.2");
        leadForm.setCategory("1");
        return leadForm;
    }
}
