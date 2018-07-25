package com.psychological.cxks.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.psychological.cxks.bean.MessageBean;
import com.psychological.cxks.bean.TestBean;

import com.psychological.cxks.dao.MessageBeanDao;
import com.psychological.cxks.dao.TestBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig messageBeanDaoConfig;
    private final DaoConfig testBeanDaoConfig;

    private final MessageBeanDao messageBeanDao;
    private final TestBeanDao testBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        messageBeanDaoConfig = daoConfigMap.get(MessageBeanDao.class).clone();
        messageBeanDaoConfig.initIdentityScope(type);

        testBeanDaoConfig = daoConfigMap.get(TestBeanDao.class).clone();
        testBeanDaoConfig.initIdentityScope(type);

        messageBeanDao = new MessageBeanDao(messageBeanDaoConfig, this);
        testBeanDao = new TestBeanDao(testBeanDaoConfig, this);

        registerDao(MessageBean.class, messageBeanDao);
        registerDao(TestBean.class, testBeanDao);
    }
    
    public void clear() {
        messageBeanDaoConfig.clearIdentityScope();
        testBeanDaoConfig.clearIdentityScope();
    }

    public MessageBeanDao getMessageBeanDao() {
        return messageBeanDao;
    }

    public TestBeanDao getTestBeanDao() {
        return testBeanDao;
    }

}
