package app.rakuten.dao;

import org.springframework.stereotype.Repository;

import app.rakuten.models.Category;
/**
 * Implementation abstract DAO for Category class, class extends Generic abstract class
 * 
 * @author Sergey Ogarkov
 *
 */
@Repository
public class CategoryDAOImpl extends GenericDAO<Category> implements CategoryDAO {

	public CategoryDAOImpl() {
		super();
		setClazz(Category.class);
	}

}
