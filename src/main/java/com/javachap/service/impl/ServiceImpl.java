package com.javachap.service.impl;

import com.javachap.service.Service;
import com.javachap.service.exceptions.ServiceException;
import com.javachap.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Varma
 */
public abstract class ServiceImpl<T> implements Service {

    private static final long serialVersionUID = 7599134799116366251L;

    /* (non-Javadoc)
     * @see com.javachap.service.CategoryService#save(com.javachap.domain.Category)
     */
    public T save(T category) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(category);
            tx.commit();
            rollback = false;
        } catch (HibernateException e) {
            throw new ServiceException(e);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
        return category;
    }
}
