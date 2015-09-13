/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author ETY
 */
@Entity
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column( length = 64, nullable = false)
    private String titre;
    
    private String resume;
    
    private Integer annee;

    private Integer duree;
    
    @ManyToMany
    @JoinTable(name = "genre_film")
    private Collection<Genre>genre=new ArrayList<>();
    
//    private Genre genre;
    
    
    //RELATIONS********************************
    @OneToMany(mappedBy = "film", cascade ={CascadeType.REMOVE, CascadeType.PERSIST})
    @CascadeOnDelete
    private Collection<Lien> liens=new ArrayList<>();
    
    @OneToMany(mappedBy = "film")
    private Collection<FilmCasting> filmCasting=new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;
    //********************************
    
    public Film() {
    }

    public Film(Long id, String titre, Integer annee, Integer duree) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;

    }
    
    public Film(String titre, Integer annee, Integer duree) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;

    }

    public Collection<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Collection<Genre> genre) {
        this.genre = genre;
    }

    
    
    public Collection<FilmCasting> getFilmCasting() {
        return filmCasting;
    }

    public void setFilmCasting(Collection<FilmCasting> filmCasting) {
        this.filmCasting = filmCasting;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Collection<Lien> getLiens() {
        return liens;
    }

    public void setLiens(Collection<Lien> liens) {
        this.liens = liens;
    }
    
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
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
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dtastreaming.entity.Film[ id=" + id + " ]";
    }
    
}
