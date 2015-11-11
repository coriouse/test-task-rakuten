package app.rakuten.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.rakuten.models.Category;

@Repository
public class CategoryDAOImpl extends GenericDAO<Category> implements CategoryDAO {

	public CategoryDAOImpl() {
		super();
		setClazz(Category.class);
	}
	
	

}
