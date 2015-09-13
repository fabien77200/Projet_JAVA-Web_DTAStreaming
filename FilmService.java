/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;

import dtastreaming.entity.Film;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ETY
 */

public class FilmService {

    
    public Collection<Film> lister(){
        
    EntityManager em =Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
    return em.createQuery("SELECT f FROM Film f ORDER BY f.titre LIMIT 10").getResultList();
   
    }
    
    public Film rechercher(long id){
        
     EntityManager em =Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
     return em.find(Film.class, id);
        
    }

    
    public void supprimer(long id){
    
     EntityManager em =Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        
        em.getTransaction().begin();
    
//        {
//        Film f = new Film();
//        f.setId(id);
//        em.remove(f);
//        }

        em.createQuery("DELETE FROM Film f WHERE f.id=:idFilm").setParameter("idFilm", id).executeUpdate();
        
        em.getTransaction().commit();
        
    }
    
    public void modifier(Film f){
    
     EntityManager em =Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
        
        em.getTransaction().begin();
    
   
        em.merge(f);
        
        
        em.getTransaction().commit();
        
    }
    
    
    
    public void ajouter(Film f){
        
        EntityManager em =Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        
            
        em.getTransaction().begin();
    
        
        em.persist(f);
        
        
        em.getTransaction().commit();
    
    }
    
}
