package app.rakuten.cache;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.rakuten.dao.CategoryDAO;
import app.rakuten.models.Category;

/**
 * Class handle pathCategory cache, create cache, and refresh
 * 
 * @author Sergey Ogarkov
 *
 */
@Component
public class PathCategoryCache {

	@Autowired
	private CategoryDAO categoryDAO;

	private final static Map<Category, List<Category>> CACHE_PATH = new ConcurrentHashMap<Category, List<Category>>();

	@PostConstruct
	private void init() {
		createCache();
	}

	public int size() {
		return CACHE_PATH.size();
	}

	private void put(Category key, List<Category> value) {
		CACHE_PATH.put(key, value);
	}

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
