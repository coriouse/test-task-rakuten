package app.rakuten.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.rakuten.dao.CategoryDAO;
import app.rakuten.model.Category;

@ContextConfiguration(locations = { "/spring/appRakutenContextTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CaegoryServiceTest {

	@Autowired
	private CategoryDAO categoryDAO;

	
	@Autowired
	private CategoryService categoryService;

	@Test
	public void testFirstCreateCache() {
		assertEquals(10, categoryService.size());
	}

	@Test
	public void testCache() {
		// add new path to cache
		List<Category> createPathCategory = categoryService.getPath(categoryService.getCategoryById(6L));
		assertEquals(3, createPathCategory.size());
		assertEquals("A", createPathCategory.get(0).getName());
		assertEquals("AB", createPathCategory.get(1).getName());
		assertEquals("ABC", createPathCategory.get(2).getName());
		// update category
		Category category = createPathCategory.get(2);
		category.setName("ABCD");
		categoryDAO.update(category);
		// get update category from cache
		List<Category> updatePathCategory = categoryService.getPath(categoryService.getCategoryById(6L));
		assertEquals("A", updatePathCategory.get(0).getName());
		assertEquals("AB", updatePathCategory.get(1).getName());
		assertEquals("ABCD", updatePathCategory.get(2).getName());
	}

}
