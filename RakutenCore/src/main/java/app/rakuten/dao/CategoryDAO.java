package app.rakuten.dao;

import java.util.List;

import app.rakuten.models.Category;

public interface CategoryDAO {
	Category findOne(long id);

	List<Category> findAll();

	void create(Category entity);

	Category update(Category entity);

	void delete(Category entity);

	void deleteById(long entityId);

}
