package app.rakuten.cache;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.rakuten.dao.CategoryDAO;
import app.rakuten.models.Category;

@Component
public class PathCategoryBuilder {

	@Autowired
	private CategoryDAO categoryDAO;

	private final static List<Category> PATH_CATEGORY = new LinkedList<Category>();

	public void build(Category category) {
		clean();
		PATH_CATEGORY.add(category);
		buildPathCategory(category);
		Collections.reverse(this.PATH_CATEGORY);
	}

	private Category buildPathCategory(Category category) {
		if (category.getParent() == null) {
			return category;
		} else {
			Category next = categoryDAO.findOne(category.getParent());
			PATH_CATEGORY.add(next);
			return buildPathCategory(next);
		}
	}

	public List<Category> getPathCategory() {
		return this.PATH_CATEGORY;
	}

	private void clean() {
		this.PATH_CATEGORY.clear();
	}

}
