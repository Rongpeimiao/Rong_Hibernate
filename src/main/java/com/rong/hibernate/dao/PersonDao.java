package com.rong.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.rong.hibernate.model.Person;


/** 
* @ClassName: PersonDao 
* @Description: 用户dao
* @author: 容培淼
* @email:810209659@qq.com
* 根据对象类生成mysql表
*/
public class PersonDao {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = new Person();
        person.setAge(18);
        person.setName("rong");
        session.save(person);
        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }

    public static SessionFactory createSessionFactory() {
        Configuration cfg = new Configuration().configure();
        System.out.println("cfg.getProperties():" + cfg.getProperties());
        StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        sessionFactory = cfg.buildSessionFactory(build);
        return sessionFactory;
    }

}
