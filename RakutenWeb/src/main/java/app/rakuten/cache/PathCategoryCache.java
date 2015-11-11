package app.rakuten.cache;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.rakuten.dao.CategoryDAO;
import app.rakuten.models.Category;

@Component
public class PathCategoryCache {

	@Autowired
	private PathCategoryBuilder pathCategoryBuilder;

	@Autowired
	private CategoryDAO categoryDAO;

	private final static Map<Category, List<Category>> CACHE_PATH = new ConcurrentHashMap<Category, List<Category>>();

	@PostConstruct
	private void init() {
		createCache();
	}

	private void put(Category key, List<Category> value) {
		List<Category> path = new LinkedList<Category>();
		path.addAll(value);
		CACHE_PATH.put(key, path);
	}

	public List<Category> getPath(Category category) {
		if (CACHE_PATH.containsKey(category)) {
			return CACHE_PATH.get(category);
		} else {
			pathCategoryBuilder.build(category);
			put(category, pathCategoryBuilder.getPathCategory());
			return CACHE_PATH.get(category);
		}
	}

	public int size() {
		return CACHE_PATH.size();
	}

	private void createCache() {
		for (Category category : categoryDAO.findAll()) {
			pathCategoryBuilder.build(category);
			put(category, pathCategoryBuilder.getPathCategory());
		}
	}
}
