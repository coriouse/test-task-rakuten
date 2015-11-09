package app.rakuten.builder;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.rakuten.builder.PathCategoryBuilder;
import app.rakuten.dao.CategoryDAO;
import app.rakuten.models.Category;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PathCategoryBuilderTest {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	PathCategoryBuilder pathCategoryBuilder;

	@Test
	public void testPathCategoryBuilder() {
		pathCategoryBuilder.build(categoryDAO.findOne(6L));
		assertEquals(3, pathCategoryBuilder.getPathCategory().size());
		assertEquals("A", pathCategoryBuilder.getPathCategory().get(0));
		assertEquals("AB", pathCategoryBuilder.getPathCategory().get(1));
		assertEquals("ABC", pathCategoryBuilder.getPathCategory().get(2));
	}

}
