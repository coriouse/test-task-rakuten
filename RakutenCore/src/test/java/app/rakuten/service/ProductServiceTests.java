package app.rakuten.service;


 import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import app.rakuten.dao.CategoryDAO;
import app.rakuten.models.Category;
import app.rakuten.models.Product;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTests {

	@Autowired
	private ProductService  productService;
	
	@Autowired 
	private CategoryDAO categoryDAO; 

	@Ignore
	public void testSaveProduct() {
		Category category =  categoryDAO.findOne(6L);
		Product product = new Product();
		product.setId(2L);
		product.setName("Red t-short");
		product.setCategory(category);
		product.setPrice(3f);
		product.setAvaliable(1);		
		productService.create(product);
		assertNotNull(product.getId());
	}
	@Ignore
	public void testListProducts() {
		productService.deleteById(2L);
		assertNull(productService.findOne(2L));
		Category category =  categoryDAO.findOne(6L);
		Product product = new Product();
		product.setId(2L);
		product.setName("Red t-short");
		product.setCategory(category);
		product.setPrice(3f);
		product.setAvaliable(1);		
		productService.create(product);		
		assertEquals(2, productService.findAll().size());
		
		
	}
	
}
