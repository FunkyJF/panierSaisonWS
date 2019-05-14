package fr.afcepf.al33.citron.panierSaison;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.afcepf.al33.citron.panierSaisonWS.dao.ArticleDao;
import fr.afcepf.al33.citron.panierSaisonWS.entity.ArticlePanier;
import fr.afcepf.al33.citron.panierSaisonWS.entity.RefPanier;


@Stateless
@Remote
@WebService(endpointInterface="fr.afcepf.al33.citron.panierSaison.PanierSaison")
public class PanierSaisonImpl implements PanierSaison {

	@EJB // ou @Inject si META-INF/beans.xml de CDI present dans le projet ejb
	private ArticleDao articleDao;
	
	public PanierSaisonImpl() {
		super();
	}

	@Override
	public String getHelloWorld() {
		return "Hello World!";
	}

	@Override
	public List<ArticlePanier> getAllArticles() {
		return articleDao.getAllArticles();
	}

	@Override
	public List<RefPanier> getPanier(String categorie, double prix) {
		int nbElementCher=0;
		int j;
		boolean premierTour = true;
		double somme=0;
		List<ArticlePanier> articlesPanier = new ArrayList<>();
		List<RefPanier> reponse = new ArrayList<>();
		if(categorie.equals("Toutes"))
		{
			articlesPanier = articleDao.getArticles();
		}
		else
		{
			articlesPanier = articleDao.getArticlesByCategorie(categorie);
		}
		
		while(nbElementCher<articlesPanier.size())
		{
			nbElementCher=0;
			j=0;
			for (ArticlePanier articlePanier : articlesPanier) {
				
				if(premierTour && (somme+articlePanier.getPrix() < prix))
				{
					reponse.add(new RefPanier(articlePanier.getId(), 1));
					somme += articlePanier.getPrix();
				}
				else if(somme+articlePanier.getPrix()<prix)
				{	
					reponse.get(j).setQuantite(reponse.get(j).getQuantite()+1);
					somme += articlePanier.getPrix();
				}
				else
				{
					nbElementCher++;
				}
				j++;
			}
			premierTour = false;
		}
		
		return reponse;
	}

}
