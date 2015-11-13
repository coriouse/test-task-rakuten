package app.rakuten.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import app.rakuten.models.Product;

/**
 * Implementation abstract DAO for Product class, class extends Generic abstract
 * class
 * 
 * @author Sergey Ogarkov
 *
 */
@Repository
public class ProductDAOImpl extends GenericDAO<Product> implements ProductDAO {

	public ProductDAOImpl() {
		super();
		setClazz(Product.class);
	}

	/**
	 * Find all Product by Category Id
	 * 
	 * @param id
	 *            Category
	 * @return Products which include in Category
	 */
	public List<Product> findAllProductByCategoryId(long id) {
		return null;
	}
}
