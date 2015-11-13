package app.rakuten.dao;

import java.util.List;

import app.rakuten.models.Category;

/**
 * Interface DAO CRUD of Category interface provide base method for control of the record
 * 
 * @author Sergey Ogarkov
 *
 */
public interface CategoryDAO {
	/**
	 * Found Category by Id
	 * 
	 * @param id
	 * @return Category
	 */
	public Category findOne(long id);

	/**
	 * Found all Categoryes in table
	 * 
	 * @return List of the Categoryes
	 */
	public List<Category> findAll();

	/**
	 * Create new Category
	 * 
	 * @param Category
	 */
	public void create(Category category);

	/**
	 * Update to change exists Category
	 * 
	 * @param Category
	 * @return Category with changing
	 */
	public Category update(Category category);

	/**
	 * Delete category by object Category
	 * 
	 * @param Category
	 */
	public void delete(Category category);

	/**
	 * Delete Category
	 * 
	 * @param id
	 *            of the Category
	 */
	public void deleteById(long id);

}
