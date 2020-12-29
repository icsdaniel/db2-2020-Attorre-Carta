package entities;

import java.io.Serializable;
import java.util.Base64;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@Table(name = "products", schema = "db_gamified_marketing")
@NamedQueries({ @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
				@NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
				@NamedQuery(name = "Product.findByProductID", query = "SELECT p FROM Product p WHERE p.idproducts = :productid")})

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproducts;

	private String name;
	@Lob
	private byte[] image;
	
	@OneToMany(mappedBy="product_reviewed")
	private List<Review> reviews;
	
	public Product() {
		super();
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getIdproducts() {
		return idproducts;
	}

	public void setIdproducts(int idproducts) {
		this.idproducts = idproducts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getImageData() {
		return Base64.getMimeEncoder().encodeToString(image);
	}
   
}
