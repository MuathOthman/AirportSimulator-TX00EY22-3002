package dao;

import entity.*;
import jakarta.persistence.EntityManager;

public class AsiakasDao {

    public void persist(AsiakasE emp) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    public AsiakasE find(int id) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        AsiakasE emp = em.find(AsiakasE.class, id);
        return emp;
    }

    public void update(AsiakasE emp) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
    }

    public void delete(AsiakasE emp) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }
}
