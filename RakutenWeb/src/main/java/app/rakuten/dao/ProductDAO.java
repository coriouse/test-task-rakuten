package app.rakuten.dao;

import java.util.List;

import app.rakuten.models.Product;

/**
 * Interface DAO CRUD of Product interface provide base methods for control of
 * the record
 * 
 * @author Sergey Ogarkov
 *
 */
public interface ProductDAO {

	/**
	 * Found Product by Id
	 * 
	 * @param id
	 * @return Product
	 */
	public Product findOne(long id);

	/**
	 * Found all Products in table
	 * 
	 * @return List of the Products
	 */
	public List<Product> findAll();

	/**
	 * Create new Product
	 * 
	 * @param Product
	 */
	public void create(Product product);

	/**
	 * Update to change exists Product
	 * 
	 * @param Product
	 * @return Product with changing
	 */
	public Product update(Product product);

	/**
	 * Delete product by object Product
	 * 
	 * @param Product
	 */
	public void delete(Product product);

	/**
	 * Delete Product
	 * 
	 * @param id
	 *            of the Product
	 */
	public void deleteById(long id);

}
