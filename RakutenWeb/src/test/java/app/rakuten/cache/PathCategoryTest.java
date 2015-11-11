package app.rakuten.cache;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.plaf.synth.SynthScrollPaneUI;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.rakuten.cache.PathCategoryBuilder;
import app.rakuten.cache.PathCategoryCache;
import app.rakuten.dao.CategoryDAO;
import app.rakuten.models.Category;

@ContextConfiguration(locations = { "/spring/appRakutenContextTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class PathCategoryTest {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private PathCategoryBuilder pathCategoryBuilder;

	@Autowired
	private PathCategoryCache pathCategoryCache;

	@Test
	public void testFirstCreateCache() {
		assertEquals(10, pathCategoryCache.size());
	}

	@Test
	public void testPathCategoryBuilder() {
		pathCategoryBuilder.build(categoryDAO.findOne(6L));
		assertEquals(3, pathCategoryBuilder.getPathCategory().size());
		assertEquals("A", pathCategoryBuilder.getPathCategory().get(0).getName());
		assertEquals("AB", pathCategoryBuilder.getPathCategory().get(1).getName());
		assertEquals("ABC", pathCategoryBuilder.getPathCategory().get(2).getName());

		pathCategoryBuilder.build(categoryDAO.findOne(8L));
		assertEquals(1, pathCategoryBuilder.getPathCategory().size());
		assertEquals("A1", pathCategoryBuilder.getPathCategory().get(0).getName());

		pathCategoryBuilder.build(categoryDAO.findOne(10L));
		assertEquals(2, pathCategoryBuilder.getPathCategory().size());
		assertEquals("A2", pathCategoryBuilder.getPathCategory().get(0).getName());
		assertEquals("A2B2", pathCategoryBuilder.getPathCategory().get(1).getName());
	}

	@Test
	public void testCache() {
		// add new path to cache
		List<Category> createPathCategory = pathCategoryCache.getPath(categoryDAO.findOne(6L));
		assertEquals(3, createPathCategory.size());
		assertEquals("A", createPathCategory.get(0).getName());
		assertEquals("AB", createPathCategory.get(1).getName());
		assertEquals("ABC", createPathCategory.get(2).getName());
		// update category
		Category category = createPathCategory.get(2);
		category.setName("ABCD");
		categoryDAO.update(category);
		// get update category from cache
		List<Category> updatePathCategory = pathCategoryCache.getPath(categoryDAO.findOne(6L));
		assertEquals("A", updatePathCategory.get(0).getName());
		assertEquals("AB", updatePathCategory.get(1).getName());
		assertEquals("ABCD", updatePathCategory.get(2).getName());
	}

}
