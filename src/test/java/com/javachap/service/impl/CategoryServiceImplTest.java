package com.javachap.service.impl;

import com.javachap.domain.Category;
import com.javachap.service.CategoryService;
import com.javachap.service.ServiceUtils;
import junit.framework.TestCase;

/**
 * Created on 28/09/2019.
 *
 * @author Cesardl
 */
public class CategoryServiceImplTest extends TestCase {

    public void testGetCategoryByName() {
        CategoryService service = ServiceUtils.getCategoryService();

        Category result = service.getCategory("Insurance");

        assertNotNull(result.getDescription());
    }

}
