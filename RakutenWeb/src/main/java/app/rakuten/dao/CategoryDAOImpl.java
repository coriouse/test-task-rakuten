package app.rakuten.dao;

import org.springframework.stereotype.Repository;

import app.rakuten.model.Category;

/**
 * Implementation abstract DAO for Category class, class extends Generic
 * abstract class
 * 
 * @author Sergey Ogarkov
 *
 */
@Repository
public class CategoryDAOImpl extends GenericDAOImpl<Category> implements CategoryDAO {
	public CategoryDAOImpl() {
		super();
		setClazz(Category.class);
	}

}
