package app.rakuten.dao;

import java.util.List;

import app.rakuten.model.Category;
import app.rakuten.model.Product;

/**
 * Interface DAO CRUD of Product interface provide base methods for control of
 * the record
 * 
 * @author Sergey Ogarkov
 *
 */
public interface ProductDAO extends GenericDAO<Product> {
	/**
	 * Find all Product by Category Id
	 * 
	 * @param id
	 *            {@link Category}
	 * 
	 * @return Products which include in Category
	 */
	public List<Product> findAllProductByCategoryId(Category category);

}
