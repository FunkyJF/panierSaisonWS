package fr.afcepf.al33.citron.panierSaison;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al33.citron.panierSaisonWS.entity.ArticlePanier;
import fr.afcepf.al33.citron.panierSaisonWS.entity.RefPanier;

@WebService //targetNamespace par defaut= http://panierSaison.citron.al33.afcepf.fr/
public interface PanierSaison {
	public String getHelloWorld();
	public List<ArticlePanier> getAllArticles();
	public List<RefPanier> getPanier(@WebParam(name="categorie")String categorie, 
							@WebParam(name="prix")double prix);
}
