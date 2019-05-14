package fr.afcepf.al33.citron.panierSaisonWS.dao;

import java.util.List;

import fr.afcepf.al33.citron.panierSaisonWS.entity.ArticlePanier;


public interface ArticleDao {
	public List<ArticlePanier> getAllArticles();
	public List<ArticlePanier> getArticles();
	public List<ArticlePanier> getArticlesByCategorie(String categorie);
}
