package it.polimi.db2.gm.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import it.polimi.db2.gm.entities.Product;

@Stateless
public class ProductService {
	@PersistenceContext(unitName = "GamifiedMarketingEJB")
	protected EntityManager em;
	
	public ProductService() {
    }
	
	public ProductService(EntityManager em) {
        this.em = em;
    }
	public Product findByProductID(int productID){
		System.out.println("Calling em.createNamedQuery...");
		return em.createNamedQuery("Product.findByProductID",Product.class).setParameter("productid",productID).getSingleResult();
	}
}
