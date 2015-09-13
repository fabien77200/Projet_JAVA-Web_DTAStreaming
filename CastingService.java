/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;

import dtastreaming.entity.Casting;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ETY
 */
public class CastingService {
        public Collection<Casting> lister() {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        return em.createQuery("SELECT c FROM Casting c ORDER BY c.nom").getResultList();
    }
    
    public Casting rechercher(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        return em.find(Casting.class, id);
    }
    
    public void supprimer (long id) {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();

        em.getTransaction().begin();
            em.createQuery("DELETE FROM Casting WHERE c.id=:idCasting").setParameter("idCasting", id).executeUpdate();
        em.getTransaction().commit();  
    }
    
    public void modifier (Casting c) {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();

        em.getTransaction().begin();
            em.merge(c);
        em.getTransaction().commit();  
    }
    
    public void ajouter(Casting c) {       
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        em.getTransaction().begin();
            em.persist(c);
        em.getTransaction().commit();
    }
}
