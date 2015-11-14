package app.rakuten.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.rakuten.dao.ProductDAO;
import app.rakuten.dto.ProductDTO;
import app.rakuten.model.Product;

/**
 * Implementation ProductService
 * 
 * @author Sergey Ogarkov
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryService categoryService;

	/**
	 * {@link app.rakuten.service.ProductService#getListProducts()}
	 */
	@Override
	public List<ProductDTO> getListProducts() {
		List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		for (Product product : findAll()) {
			listProductDTO.add(createProductDTO(product, this.categoryService));
		}
		return listProductDTO;
	}

	@Transactional(readOnly = true)
	private List<Product> findAll() {
		return productDAO.findAll();
	}

	/**
	 * {@link app.rakuten.service.ProductService#getListProductsByCategoryId(long)}
	 */
	@Override
	public List<ProductDTO> getListProductsByCategoryId(long id) {
		List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		for (Product product : findAllProductByCategoryId(id)) {
			listProductDTO.add(createProductDTO(product, this.categoryService));
		}
		return listProductDTO;
	}

	@Transactional(readOnly = true)
	private List<Product> findAllProductByCategoryId(long id) {
		// TODO Search product including all sub categories
		return productDAO.findAllProductByCategoryId(categoryService.getCategoryById(id));
	}

	/**
	 * Method prepare DTO object from {@link Product} object
	 * 
	 * @param {@link
	 * 			Product}
	 * @return DTO object of {@link Product}
	 */
	private static ProductDTO createProductDTO(Product product, CategoryService categoryService) {
		ProductDTO productDTO = new ProductDTO(product);
		productDTO.setPath(categoryService.getPath(product.getCategory()));
		LOGGER.debug("ProducDTO : ", productDTO);
		return productDTO;
	}

	/**
	 * {@link app.rakuten.service.ProductService#getProductById(long)}
	 */
	@Override
	@Transactional(readOnly = true)
	public Product getProductById(long id) {
		return productDAO.findOne(id);
	}

	/**
	 * {@link app.rakuten.service.ProductService#create(Product)}
	 */
	@Override
	@Transactional
	public void create(Product entity) {
		productDAO.create(entity);
	}

	/**
	 * {@link app.rakuten.service.ProductService#update(Product)}
	 */
	@Override
	@Transactional
	public Product update(Product entity) {
		return productDAO.update(entity);
	}

	/**
	 * {@link app.rakuten.service.ProductService#delete(Product)}
	 */
	@Override
	@Transactional
	public void delete(Product entity) {
		productDAO.delete(entity);
	}

	/**
	 * {@link app.rakuten.service.ProductService#deleteById(long)}
	 */
	@Override
	@Transactional
	public void deleteById(long entityId) {
		productDAO.deleteById(entityId);
	}
}
