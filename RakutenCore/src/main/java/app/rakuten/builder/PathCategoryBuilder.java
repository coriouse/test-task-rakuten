package app.rakuten.builder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import app.rakuten.dao.CategoryDAO;
import app.rakuten.models.Category;

@Component
@Scope("prototype")
public class PathCategoryBuilder {

	@Autowired
	private CategoryDAO categoryDAO;

	private List<Category> pathCategory = new LinkedList<Category>();

	public void build(Category category) {
		pathCategory.add(category);
		buildPathCategory(category);
	}

	private Category buildPathCategory(Category category) {
		if (category.getParent() == null) {			
			return category;
		} else {
			Category next = categoryDAO.findOne(category.getParent());
			pathCategory.add(next);
			return buildPathCategory(next);
		}
	}

	public List<Category> getPathCategory() {
		Collections.reverse(this.pathCategory);
		return this.pathCategory;
	}
	
	
	public void clean() {
		this.pathCategory.clear();
	}

}
