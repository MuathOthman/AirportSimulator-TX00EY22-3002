package dao;

import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class SimuDao {

    public void persist(simulaatio emp) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    public simulaatio find(int id) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        simulaatio emp = em.find(simulaatio.class, id);
        return emp;
    }

    public void update(simulaatio emp) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
    }

    public void delete(simulaatio emp) {
        EntityManager em = datasource.MariaDbJpaConnector.getInstance();
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }


    public List<String> getNames() {
        try {
            EntityManager em = datasource.MariaDbJpaConnector.getInstance();
            Query query = em.createQuery("SELECT c.name FROM simulaatio c");
            List<String> names = query.getResultList();
            return names;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
