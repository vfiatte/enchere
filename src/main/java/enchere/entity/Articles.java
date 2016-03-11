/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.entity;

import enchere.enumeration.StatutEnumeration;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Articles implements Serializable {

    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID")
    private Utilisateur utilisateur;
    
    @OneToMany(mappedBy = "articles")
    List<Enchere> listeEnchere = new ArrayList<>();
   
    @ManyToOne
    @JoinColumn(name = "CATEGORIE_ID")
    private Categorie categorie;
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVente;
    
    private StatutEnumeration statut;
    
    private Long prixDepart;
    
    private Long prixActuel = prixDepart;
    private String nom;
    private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date finDeVente;
    

    
    
    public Articles() {
    }

    public Articles(Long id, Date dateVente, StatutEnumeration statut, Long prixDepart, String nom) {
        this.id = id;
        this.dateVente = dateVente;
        this.statut = statut;
        this.prixDepart = prixDepart;
        this.nom = nom;
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    public Date getFinDeVente() {
        return finDeVente;
    }

    public void setFinDeVente(Date finDeVente) {
        this.finDeVente = finDeVente;
    }

    
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public double getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Long prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Long getPrixActuel() {
        return prixActuel;
    }

    public void setPrixActuel(Long prixActuel) {
        this.prixActuel = prixActuel;
    }

    

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Enchere> getListeEnchere() {
        return listeEnchere;
    }

    public void setListeEnchere(List<Enchere> listeEnchere) {
        this.listeEnchere = listeEnchere;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public StatutEnumeration getStatut() {
        return statut;
    }

    public void setStatut(StatutEnumeration statut) {
        this.statut = statut;
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
        if (!(object instanceof Articles)) {
            return false;
        }
        Articles other = (Articles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Categorie[ id=" + id + " ]";
    }
    
}
