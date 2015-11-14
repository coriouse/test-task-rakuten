package app.rakuten.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import app.rakuten.model.Category;
import app.rakuten.model.Product;

/**
 * Implementation abstract DAO for Product class, class extends Generic abstract
 * class
 * 
 * @author Sergey Ogarkov
 *
 */
@Repository
public class ProductDAOImpl extends GenericDAOImpl<Product> implements ProductDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);

	public ProductDAOImpl() {
		super();
		setClazz(Product.class);
	}

	@Override
	public List<Product> findAllProductByCategoryId(Category category) {
		String query = "from Product WHERE category = :category";
		LOGGER.debug("findAllProductByCategoryId: %s", category);
		return getEntityManager().createQuery(query).setParameter("category", category).getResultList();
	}
}
