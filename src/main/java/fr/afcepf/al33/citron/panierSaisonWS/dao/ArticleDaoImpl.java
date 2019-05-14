package fr.afcepf.al33.citron.panierSaisonWS.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import fr.afcepf.al33.citron.panierSaisonWS.entity.ArticlePanier;


@Local
@Stateless
public class ArticleDaoImpl implements ArticleDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public ArticleDaoImpl() {
		
	}
	
	@Override
	public List<ArticlePanier> getAllArticles() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ArticlePanier> cq = cb.createQuery(ArticlePanier.class);
        Root<ArticlePanier> rootEntry = cq.from(ArticlePanier.class);
        CriteriaQuery<ArticlePanier> all = cq.select(rootEntry);
        TypedQuery<ArticlePanier> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();

		//return entityManager.createQuery("Select m from Article m").getResultList();
	}

	@Override
	public List<ArticlePanier> getArticles() {
		LocalDate date = LocalDate.now();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ArticlePanier> cq = cb.createQuery(ArticlePanier.class);
		Root<ArticlePanier> c = cq.from(ArticlePanier.class);
		cq.select(c).where(cb.or(
				cb.and(cb.and(cb.le(c.get("debutSaison"), c.get("finSaison")), cb.le(c.get("debutSaison"), date.getMonthValue())), cb.ge(c.get("finSaison"), date.getMonthValue())),
				cb.and(cb.and(cb.ge(c.get("debutSaison"), c.get("finSaison")), cb.ge(c.get("debutSaison"), date.getMonthValue())), cb.ge(c.get("finSaison"), date.getMonthValue()))
				));
		return entityManager.createQuery(cq).getResultList();
		
	}

	@Override
	public List<ArticlePanier> getArticlesByCategorie(String categorie) {
		LocalDate date = LocalDate.now();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ArticlePanier> cq = cb.createQuery(ArticlePanier.class);
		Root<ArticlePanier> c = cq.from(ArticlePanier.class);
		ParameterExpression<String> param1 = cb.parameter(String.class, "categorie");
		cq.select(c).where(cb.and(
				cb.like(c.get("categorie"), param1), 
				cb.or(
						cb.and(cb.and(cb.le(c.get("debutSaison"), c.get("finSaison")), cb.le(c.get("debutSaison"), date.getMonthValue())), cb.ge(c.get("finSaison"), date.getMonthValue())),
						cb.and(cb.and(cb.ge(c.get("debutSaison"), c.get("finSaison")), cb.ge(c.get("debutSaison"), date.getMonthValue())), cb.ge(c.get("finSaison"), date.getMonthValue()))
						)
				));
		return entityManager.createQuery(cq).setParameter("categorie", categorie).getResultList();
	}

}
