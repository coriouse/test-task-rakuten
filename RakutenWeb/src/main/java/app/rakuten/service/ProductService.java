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

	
	
	public List<ProductDTO> getListProducts() {
		List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		for(Product product : findAll()) {
			listProductDTO.add(getProductDTO(product));
		}
		return listProductDTO;
	}
	
	private ProductDTO getProductDTO(Product product) {
		ProductDTO  productDTO = new ProductDTO(product);
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
	
	public Map<Long, String> getMapCategorysProduct() {
		Map<Long, String> mapCategorys = new HashMap<Long, String>();
		for(Category category : categoryDAO.findAll()) {
			mapCategorys.put(category.getId(), category.getName());
		}
		return mapCategorys;
	}
	
	 

}
