package app.rakuten.service;

import java.util.List;

import app.rakuten.dto.ProductDTO;
import app.rakuten.model.Product;

/**
 * Interface Class Service of {@link Product}, service has methods with
 * definition of logic for working with Product entity
 * 
 * @author Sergey Ogarkov
 *
 */
public interface ProductService {

	/**
	 * get {@link Product} by id
	 * 
	 * @param id
	 * @return {@link Product}
	 */
	public Product getProductById(long id);

	/**
	 * Method return list of the DTO Project
	 * 
	 * @return list of the ProductDTO
	 */
	public List<ProductDTO> getListProducts();

	/**
	 * Method return list of the DTO Project by Id Category
	 * 
	 * @return list of the ProductDTO
	 */
	public List<ProductDTO> getListProductsByCategoryId(long id);

	/**
	 * Create new {@link Product}
	 * 
	 */
	public void create(Product product);

	/**
	 * Update {@link Product}
	 * 
	 * @param {@link
	 * 			Product}
	 * @return changed {@link Product}
	 */
	public Product update(Product product);

	/**
	 * Delete {@link Product} by entity
	 * 
	 * @param {@link
	 * 			Product}
	 */
	public void delete(Product product);

	/**
	 * Delete {@link Product} by id
	 * 
	 */
	public void deleteById(long id);

}
