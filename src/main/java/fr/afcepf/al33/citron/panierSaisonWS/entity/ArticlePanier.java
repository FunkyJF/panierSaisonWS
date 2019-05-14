package fr.afcepf.al33.citron.panierSaisonWS.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArticlePanier {
	@Id
	private Integer id;
	
	private String nom;
	
	private Double quantiteVendue;
	
	private Double prix;
	
	private Double prixKilo;
	
	private String categorie;
	
	private Integer debutSaison;
	
	private Integer finSaison;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getQuantiteVendue() {
		return quantiteVendue;
	}

	public void setQuantiteVendue(Double quantiteVendue) {
		this.quantiteVendue = quantiteVendue;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Double getPrixKilo() {
		return prixKilo;
	}

	public void setPrixKilo(Double prixKilo) {
		this.prixKilo = prixKilo;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Integer getDebutSaison() {
		return debutSaison;
	}

	public void setDebutSaison(Integer debutSaison) {
		this.debutSaison = debutSaison;
	}

	public Integer getFinSaison() {
		return finSaison;
	}

	public void setFinSaison(Integer finSaison) {
		this.finSaison = finSaison;
	}
	
}
