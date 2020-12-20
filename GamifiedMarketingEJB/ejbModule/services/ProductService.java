package services;

import java.util.Collection;
import exceptions.QueryException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import entities.Product;
import entities.Review;
import exceptions.CredentialsException;

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
