package services;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import entities.Review;
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
	
}