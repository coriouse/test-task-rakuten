package app.rakuten.action;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.rakuten.model.Category;
import app.rakuten.model.Product;
import app.rakuten.service.CategoryService;
import app.rakuten.service.ProductService;
import app.rakuten.validator.ProductEditor;
import app.rakuten.validator.ProductValidator;

/**
 * 
 * Controller handle of of the CRUD Product
 * 
 * @author Sergey Ogarkov
 *
 */
@Controller
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductValidator productValidator;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		String message = "Open page show all products";
		LOGGER.debug(message);
		model.addAttribute("listProducts", this.productService.getListProducts());
		return "products";
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public String listProductsByCategotyId(Model model, @PathVariable("id") long id) {
		model.addAttribute("listProducts", this.productService.getListProductsByCategoryId(id));
		return "products";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") long id) {
		LOGGER.debug("Delete product by %s", id);
		this.productService.deleteById(id);
		return "redirect:/products";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createProduct(Model model) {
		model.addAttribute("product", new Product());
		fillCategoryComboboxList(model);
		return "edit";
	}

	@RequestMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") long id, Model model) {
		LOGGER.debug("Edit product by %s", id);
		model.addAttribute("product", this.productService.getProductById(id));
		fillCategoryComboboxList(model);
		return "edit";
	}

	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		productValidator.validate(product, result);
		if (result.hasErrors()) {
			fillCategoryComboboxList(model);
			return "edit";
		}
		save(product);
		return "redirect:/products";
	}

	private void save(Product product) {
		if (product.getId() == null) {
			this.productService.create(product);
		} else {
			this.productService.update(product);
		}
	}

	private void fillCategoryComboboxList(Model model) {
		model.addAttribute("categories", this.categoryService.getMapCategorysProduct());
	}

	@InitBinder
	private void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Category.class, new ProductEditor(categoryService));
	}

}
