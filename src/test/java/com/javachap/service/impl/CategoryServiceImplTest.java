package com.javachap.service.impl;

import com.javachap.domain.Category;
import com.javachap.service.CategoryService;
import com.javachap.service.ServiceUtils;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created on 28/09/2019.
 *
 * @author Cesardl
 */
public class CategoryServiceImplTest {

    @Test
    public void getCategoryByNameTest() {
        CategoryService service = ServiceUtils.getCategoryService();

        Category result = service.getCategory("Insurance");

        assertNotNull(result.getDescription());
    }

}
