/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ETY
 */
@Entity
public class FilmCasting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column( name = "rolecasting" )
    @Enumerated(EnumType.STRING)
    private Role role;
    
    //Relations**************************
    @ManyToOne
    @JoinColumn(name="film")
    private Film film;    
    @ManyToOne
    @JoinColumn(name = "casting")
    private Casting casting;
    //**********************************

    public FilmCasting() {
    }

    public FilmCasting(Long id) {
        this.id = id;
    }
    
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Casting getCasting() {
        return casting;
    }

    public void setCasting(Casting casting) {
        this.casting = casting;
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
        if (!(object instanceof FilmCasting)) {
            return false;
        }
        FilmCasting other = (FilmCasting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dtastreaming.entity.FilmCasting[ id=" + id + " ]";
    }
    
}
