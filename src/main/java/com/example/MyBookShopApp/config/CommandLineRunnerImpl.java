package com.example.MyBookShopApp.config;

import com.example.MyBookShopApp.data.TestEntity;
import com.example.MyBookShopApp.data.TestEntityDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.logging.Logger;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    EntityManagerFactory entityManagerFactory;
    TestEntityDao testEntityDao;

    @Autowired
    public CommandLineRunnerImpl(EntityManagerFactory entityManagerFactory, TestEntityDao testEntityDao) {
        this.entityManagerFactory = entityManagerFactory;
        this.testEntityDao = testEntityDao;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i <5 ; i++) {
            createTestEntity(new TestEntity());
        }

        TestEntity readTestEntity =testEntityDao.findOne(3L);//readTestEntityById(3L);
        if (readTestEntity!=null) {
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("read "+readTestEntity.toString());
        } else {
            throw new NullPointerException();
        }

        TestEntity updateTestEntity = updataTestEntityById(5L);
        if (updateTestEntity!=null) {
            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update "+updateTestEntity.toString());
        } else {
            throw new NullPointerException();
        }

        deleteTestEntityById(4L);
    }

    private void deleteTestEntityById(Long id) {
        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
        Transaction tx = null;

        try{
            tx=session.beginTransaction();
            TestEntity findEntity = readTestEntityById(id);
            TestEntity mergeTestEmtity = (TestEntity) session.merge(findEntity);
            session.remove(mergeTestEmtity);
            tx.commit();
        }catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            } else {
                hex.printStackTrace();
            }
        } finally {
            session.close();
        }
    }

    private TestEntity updataTestEntityById(Long id) {
        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
        Transaction tx = null;
        TestEntity result = null;

        try{
            tx=session.beginTransaction();
            TestEntity findEntity = readTestEntityById(id);
            findEntity.setData("NEW DATA UPDATE");
            result = (TestEntity) session.merge(findEntity);
            tx.commit();
        }catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            } else {
                hex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return result;
    }

    private TestEntity readTestEntityById(Long id) {
        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
        Transaction tx = null;
        TestEntity result = null;

        try{
            tx=session.beginTransaction();
            result = session.find(TestEntity.class,id);
            tx.commit();
        }catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            } else {
                hex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return result;

    }

    private void createTestEntity(TestEntity entity) {
        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
        Transaction tx = null;

        try{
            tx=session.beginTransaction();
            entity.setData(entity.getClass().getSimpleName()+entity.hashCode());
            session.save(entity);
            tx.commit();
        }catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            } else {
                hex.printStackTrace();
            }
        } finally {
                session.close();
        }
    }
}
