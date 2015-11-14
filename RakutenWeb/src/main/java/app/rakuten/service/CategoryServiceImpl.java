package app.rakuten.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.rakuten.dao.CategoryDAO;
import app.rakuten.model.Category;

/**
 * Implementation {@link CategoryService}
 * 
 * @author Sergey Ogarkov
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private final static Map<Category, List<Category>> CACHE_PATH = new ConcurrentHashMap<Category, List<Category>>();

	@Autowired
	private CategoryDAO categoryDAO;

	@PostConstruct
	private void init() {
		createCache();
	}

	/**
	 * {@link app.rakuten.service.CategoryService#getCategoryById(String)}
	 */
	@Override
	public Category getCategoryById(String id) {
		return categoryDAO.findOne(Long.parseLong(id));
	}

	/**
	 * {@link app.rakuten.service.CategoryService#getMapCategorysProduct()}
	 */
	@Override
	public Map<Long, String> getMapCategorysProduct() {
		Map<Long, String> mapCategorys = new HashMap<Long, String>();
		for (Category category : categoryDAO.findAll()) {
			mapCategorys.put(category.getId(), category.getName());
		}
		return mapCategorys;
	}

	/**
	 * {@link app.rakuten.service.CategoryService#getCategoryById(long)}
	 */
	@Override
	public Category getCategoryById(long id) {
		return categoryDAO.findOne(id);
	}

	/**
	 * {@link app.rakuten.service.CategoryService#size()}
	 */
	@Override
	public int size() {
		return CACHE_PATH.size();
	}

	/**
	 * {@link app.rakuten.service.CategoryService#getPath(Category category)}
	 */
	@Override
	public List<Category> getPath(Category category) {
		if (CACHE_PATH.containsKey(category)) {
			return CACHE_PATH.get(category);
		} else {
			put(category, build(category));
			return CACHE_PATH.get(category);
		}
	}

	private void createCache() {
		for (Category category : categoryDAO.findAll()) {
			put(category, build(category));
		}
	}

	private void put(Category key, List<Category> value) {
		CACHE_PATH.put(key, value);
	}

	private List<Category> build(Category category) {
		List<Category> pathCategory = new LinkedList<Category>();
		pathCategory.add(category);
		buildPathCategory(category, pathCategory);
		Collections.reverse(pathCategory);
		return pathCategory;
	}

	private void buildPathCategory(Category category, List<Category> pathCategory) {
		if (category.getParent() != null) {
			Category next = categoryDAO.findOne(category.getParent());
			pathCategory.add(next);
			buildPathCategory(next, pathCategory);
		}
	}

}
