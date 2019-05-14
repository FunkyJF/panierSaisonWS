package fr.afcepf.al33.serveurSoap;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;

import fr.afcepf.al33.citron.panierSaisonWS.dao.ArticleDao;
import fr.afcepf.al33.citron.panierSaisonWS.entity.ArticlePanier;

import org.junit.Assert;
import org.junit.Test;


public class AppTest 
    
{
	@EJB //
	private ArticleDao articleDao;
	
	@Test
	public void getAllArticles() {
		List<ArticlePanier> allarticles = articleDao.getAllArticles();
		Assert.assertEquals(allarticles.size(), 30);
	}
	
	@Test
	public void getArticlesByCategorie() {
		List<ArticlePanier> articlesLegumes = articleDao.getArticlesByCategorie("Légumes Frais");
		Assert.assertEquals(articlesLegumes.get(0).getCategorie(), "Légumes Frais");
	}
	
	@Test
	public void getArticles() {
		List<ArticlePanier> articlesSaison = articleDao.getArticles();
		Assert.assertTrue(articlesSaison.get(0).getDebutSaison() <= LocalDate.now().getMonthValue());
	}
}
