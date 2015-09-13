/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;

import dtastreaming.entity.Pays;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ETY
 */
public class PaysService {
    public Collection<Pays> lister() {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        return em.createQuery("SELECT p FROM Pays p ORDER BY p.nom").getResultList();
    }
    
    public Pays rechercher(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        return em.find(Pays.class, id);
    }
    
    public void supprimer (String id) {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();

        em.getTransaction().begin();
            em.createQuery("DELETE FROM Pays WHERE p.nom=:nomPays").setParameter("nomPays", id).executeUpdate();
        em.getTransaction().commit();  
    }
    
    public void modifier (Pays p) {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();

        em.getTransaction().begin();
            em.merge(p);
        em.getTransaction().commit();  
    }
    
    public void ajouter(Pays p) {       
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        em.getTransaction().begin();
            em.persist(p);
        em.getTransaction().commit();
    }
}
