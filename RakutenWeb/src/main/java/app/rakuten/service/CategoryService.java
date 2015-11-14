package app.rakuten.service;

import java.util.List;
import java.util.Map;

import app.rakuten.model.Category;

/**
 * Interface CategoryService has methods with definition of logic for working
 * with Category entity
 * 
 * @author Sergey Ogarkov
 *
 */
public interface CategoryService {

	/**
	 * Method return {@link Category} by Text Id.
	 * 
	 * @param id
	 *            {@link Category} sa String
	 * @return object {@link Category}
	 */
	public Category getCategoryById(String id);

	/**
	 * Method return {@link Category} by long Id.
	 * 
	 * @param id
	 *            {@link Category} sa long
	 * @return object {@link Category}
	 */
	public Category getCategoryById(long id);

	/**
	 * Method convert list of category to Map where Key = Category.getId(),
	 * Value = Category.getName() It's utility method for forms of
	 * {@link Category}, form depended on {@link Category}. Map uses element
	 * combobox.
	 * 
	 * @return Map<Long, String>
	 */
	public Map<Long, String> getMapCategorysProduct();

	/**
	 * Method return size of the pathCategory cache
	 * 
	 * @return size
	 */
	public int size();

	/**
	 * Get full path of Categories tree, example: A/AB/ABC
	 * 
	 * @param start
	 *            Category
	 * @return A/AB/ABC like List
	 */
	public List<Category> getPath(Category category);
}
