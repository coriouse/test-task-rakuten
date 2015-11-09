package app.rakuten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.rakuten.dao.CategoryDAO;
import app.rakuten.dao.ProductDAO;
import app.rakuten.models.Category;
import app.rakuten.models.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	
	@Autowired 
	private CategoryDAO categoryDAO; 

	@Transactional(readOnly = true)
	public Product findOne(long id) {
		return productDAO.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Transactional
	public void create(Product entity) {
		productDAO.create(entity);
	}

	@Transactional
	public Product update(Product entity) {
		return productDAO.update(entity);
	}

	@Transactional
	public void delete(Product entity) {
		productDAO.delete(entity);
	}

	@Transactional
	public void deleteById(long entityId) {
		productDAO.deleteById(entityId);
	}
	
}
