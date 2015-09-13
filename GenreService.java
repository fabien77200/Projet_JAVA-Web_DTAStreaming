/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;

import dtastreaming.entity.Genre;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ETY
 */
public class GenreService {
    public Collection<Genre> lister() {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        return em.createQuery("SELECT g FROM Genre g ORDER BY g.id").getResultList();
    }
    
    public Genre rechercher(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        return em.find(Genre.class, id);
    }
    
    public void supprimer (String id) {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();

        em.getTransaction().begin();
            em.createQuery("DELETE FROM Genre WHERE g.id=:idGenre").setParameter("idGenre", id).executeUpdate();
        em.getTransaction().commit();  
    }
    
    public void modifier (Genre g) {
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();

        em.getTransaction().begin();
            em.merge(g);
        em.getTransaction().commit();  
    }
    
    public void ajouter(Genre g) {       
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        em.getTransaction().begin();
            em.persist(g);
        em.getTransaction().commit();
    }
}
