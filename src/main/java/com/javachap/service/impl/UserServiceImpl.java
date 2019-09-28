package com.javachap.service.impl;

import com.javachap.domain.User;
import com.javachap.service.UserService;
import com.javachap.service.exceptions.ServiceException;
import com.javachap.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserServiceImpl extends ServiceImpl<User> implements UserService {

    private static final long serialVersionUID = 4889152297004460837L;

    private static final String AUTHENTICATION_QUERY = "from User user where user.email= :Email and user.password = :Password";

    /**
     * Singleton Instance of UserServiceImpl
     */
    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    /**
     * Creates Instance of {@link UserServiceImpl}
     */
    private UserServiceImpl() {
    }

    /***
     * Gets Instance of UserService
     * @return UserService Implementation
     */
    public static UserService getInstance() {
        return userServiceImpl;
    }

    public User authenticate(final String email, final String password) {
        User user;
        try {
            Session session = HibernateUtils.currentSession();
            Query query = session.createQuery(AUTHENTICATION_QUERY);
            query.setString("Email", email);
            query.setString("Password", password);
            user = (User) query.uniqueResult();
            HibernateUtils.closeSession();
        } catch (HibernateException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public User getUser(final Long userId) {
        User user;
        try {
            Session session = HibernateUtils.currentSession();
            user = (User) session.get(User.class, userId);
            HibernateUtils.closeSession();
        } catch (HibernateException e) {
            throw new ServiceException(e);
        }
        return user;
    }
}
