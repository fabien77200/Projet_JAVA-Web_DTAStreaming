/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ETY
 */
@Entity
public class Casting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    
    //Relations***********************************
    @OneToMany(mappedBy = "casting")
    private Collection<FilmCasting> filmCasting=new ArrayList<>();
    //********************************************

    public Casting() {
    }

    public Casting(Long id) {
        this.id = id;
    }

    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<FilmCasting> getFilmCasting() {
        return filmCasting;
    }

    public void setFilmCasting(Collection<FilmCasting> filmCasting) {
        this.filmCasting = filmCasting;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casting)) {
            return false;
        }
        Casting other = (Casting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dtastreaming.entity.Casting[ id=" + id + " ]";
    }
    
}
