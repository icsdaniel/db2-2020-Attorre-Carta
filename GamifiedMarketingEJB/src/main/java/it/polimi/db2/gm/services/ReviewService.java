package it.polimi.db2.gm.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.gm.entities.Review;
import java.util.List;

@Stateless
public class ReviewService {
	@PersistenceContext(unitName = "GamifiedMarketingEJB")
	protected EntityManager em;
	
	public ReviewService() {
    }
	
	public ReviewService(EntityManager em) {
        this.em = em;
    }
	
	public List<Review> findByProductID(int productID){
		return em.createNamedQuery("Review.findByProductID",Review.class).setParameter("productid",productID).getResultList();
	}

	public List<Object[]> findByProductID2(int productID){
		return em.createNamedQuery("Review.findByProductID2",Object[].class).setParameter("productid",productID).getResultList();
	}

	/*public List<User> prova(int productID){
		return em.createNamedQuery("Review.writersUsername",User.class).getResultList();
	}*/
	
}