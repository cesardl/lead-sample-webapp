package com.javachap.service.impl;

import com.javachap.domain.Category;
import com.javachap.service.CategoryService;
import com.javachap.service.exceptions.ServiceException;
import com.javachap.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author Varma
 */
public class CategoryServiceImpl extends ServiceImpl<Category> implements CategoryService {

    private static final long serialVersionUID = 380026904541710183L;
    private static final String ALL_CATEGORIES_QUERY = "from Category category";
    private static final String CATEGORY_BY_NAME_QUERY = "from Category category where category.name = :CategoryName";

    /**
     * Singleton Instance of CategoryServiceImpl
     */
    private static CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();

    /**
     * Creates Instance of {@link CategoryServiceImpl}
     */
    private CategoryServiceImpl() {
    }

    /***
     * Gets Instance of CategoryService
     * @return CategoryService Implementation
     */
    public static CategoryService getInstance() {
        return categoryServiceImpl;
    }

    /* (non-Javadoc)
     * @see com.javachap.service.CategoryService#getAllCategories()
     */
    @SuppressWarnings("unchecked")
    public List<Category> getAllCategories() {
        List<Category> categories;
        try {
            Session session = HibernateUtils.currentSession();
            Query query = session.createQuery(ALL_CATEGORIES_QUERY);
            categories = (List<Category>) query.list();
            HibernateUtils.closeSession();
        } catch (HibernateException e) {
            throw new ServiceException(e);
        }
        return categories;
    }

    /* (non-Javadoc)
     * @see com.javachap.service.CategoryService#getCategory(java.lang.Long)
     */
    public Category getCategory(Long categoryId) {
        Category category;
        try {
            Session session = HibernateUtils.currentSession();
            category = (Category) session.get(Category.class, categoryId);
            HibernateUtils.closeSession();
        } catch (HibernateException e) {
            throw new ServiceException(e);
        }
        return category;
    }

    /* (non-Javadoc)
     * @see com.javachap.service.CategoryService#getCategory(java.lang.String)
     */
    public Category getCategory(String categoryName) {
        Category category = null;
        try {
            Session session = HibernateUtils.currentSession();
            Query query = session.createQuery(CATEGORY_BY_NAME_QUERY);
            query.setString("CategoryName", categoryName);
            @SuppressWarnings("unchecked")
            List<Category> list = (List<Category>) query.list();
            if (list.size() == 1) {
                category = list.get(0);
            }
            HibernateUtils.closeSession();
        } catch (HibernateException e) {
            throw new ServiceException(e);
        }
        return category;
    }
}
