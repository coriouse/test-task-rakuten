package app.rakuten.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import app.rakuten.models.Product;

@Repository
public class ProductDAOImpl extends GenericDAO<Product> implements ProductDAO {
	public ProductDAOImpl() {
		super();
		setClazz(Product.class);
	}
}
