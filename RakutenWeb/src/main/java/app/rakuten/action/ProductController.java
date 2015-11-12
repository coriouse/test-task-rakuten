package app.rakuten.action;

import java.beans.PropertyEditorSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.rakuten.dao.CategoryDAO;
import app.rakuten.models.Category;
import app.rakuten.models.Product;
import app.rakuten.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("listProducts", this.productService.getListProducts());
		return "products";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categorys", this.productService.getMapCategorysProduct());
		return "edit";
	}

	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Error");
			return "edit";
		}

		if (product.getId() == null) {
			this.productService.create(product);
		} else {
			this.productService.update(product);
		}
		return "redirect:/products";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") long id) {
		this.productService.deleteById(id);
		return "redirect:/products";
	}

	@RequestMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") long id, Model model) {
		model.addAttribute("person", this.productService.findOne(id));
		return "edit";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String id) {
				Category category = categoryDAO.findOne(Long.parseLong(id));
				this.setValue(category);
			}
		});
	}

}
