package com.bian.dao;

import com.bian.config.dataSources.TargetDataSource;
import com.bian.config.rabbitMq.Sender;
import com.bian.entity.Demo;
import com.bian.util.SpringContextUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mr.Bi on 2017/2/24.
 */
@Component
public class DemoDao {
//    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Autowired
    SpringContextUtils springContextUtils;


    @Transactional
    public List<Demo> list(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String sql = "insert into demo(id, money, name) values(2, 2.3, 'ahello');";
        entityManager.createQuery(sql).executeUpdate();
        return null;
    }


    @Transactional
    @TargetDataSource(name = "slave")
    public Object get(Long id) {
        String sql = "From Demo t where t.id = :id";
        Query query = entityManagerFactory.createEntityManager().createQuery(sql);
        query.setParameter("id", 9L);
        List a = query.getResultList();
        System.out.println(a.toString());
        return a;
    }



    public void add(Demo demo) {
        EntityManager session = entityManagerFactory.createEntityManager();
        session.getTransaction().begin();
        session.persist(demo);
        session.getTransaction().commit();
        session.close();
    }

    public void ste(){
        Sender sender = springContextUtils.getBean(Sender.class);
        sender.send("hello rabbitMq!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
