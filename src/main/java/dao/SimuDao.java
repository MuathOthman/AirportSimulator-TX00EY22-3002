package dao;

import entity.*;
import jakarta.persistence.EntityManager;

public class SimuDao {

    public void persist(SimuE emp) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    public SimuE find(int id) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        SimuE emp = em.find(SimuE.class, id);
        return emp;
    }

    public void update(SimuE emp) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
    }

    public void delete(SimuE emp) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }
}
