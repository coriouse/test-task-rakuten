package app.rakuten.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.rakuten.cache.PathCategoryCache;
import app.rakuten.dao.CategoryDAO;
import app.rakuten.dao.ProductDAO;
import app.rakuten.dto.ProductDTO;
import app.rakuten.models.Category;
import app.rakuten.models.Product;

/**
 * Class Service of Product, service has methods with definition of logic for
 * working with Product entity
 * 
 * @author Sergey Ogarkov
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private PathCategoryCache pathCategoryCache;

	@Transactional(readOnly = true)
	public Product findOne(long id) {
		return productDAO.findOne(id);
	}

	/**
	 * Method return list of the DTO Project
	 * 
	 * @return list of the ProductDTO
	 */
	public List<ProductDTO> getListProducts() {
		List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		for (Product product : findAll()) {
			listProductDTO.add(getProductDTO(product));
		}
		return listProductDTO;
	}

	/**
	 * Method prepare DTO object from Product object
	 * 
	 * @param Product
	 * @return DTO object of Product
	 */
	private ProductDTO getProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO(product);
		productDTO.setPath(this.pathCategoryCache.getPath(product.getCategory()));
		return productDTO;
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

	/**
	 * Method convert list of category to Map where Key = Category.getId(),
	 * Value = Category.getName() It's utility method for forms of Product, form
	 * depended on Category. Map uses element combobox.
	 * 
	 * @return Map<Long, String>
	 */
	public Map<Long, String> getMapCategorysProduct() {
		Map<Long, String> mapCategorys = new HashMap<Long, String>();
		for (Category category : categoryDAO.findAll()) {
			mapCategorys.put(category.getId(), category.getName());
		}
		return mapCategorys;
	}

	/**
	 * Method return Category by Text Id. This method use utility class
	 * ProductEditor, method help get object Category when Product has save
	 * processing
	 * 
	 * @param id
	 *            Category sa String
	 * @return object Category
	 */
	public Category getCategoryById(String id) {
		return categoryDAO.findOne(Long.parseLong(id));
	}

}
