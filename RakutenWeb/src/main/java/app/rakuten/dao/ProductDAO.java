package app.rakuten.dao;

import java.util.List;

import app.rakuten.models.Product;

public interface ProductDAO {

	Product findOne(long id);

	List<Product> findAll();

	void create(Product entity);

	Product update(Product entity);

	void delete(Product entity);

	void deleteById(long entityId);

}
