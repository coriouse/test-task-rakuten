package app.rakuten.validators;

import java.beans.PropertyEditorSupport;
import app.rakuten.service.ProductService;

/**
 * Modify bean Product, ProductEditor replace String Id Catergory to Object
 * Category, Class helper for saving of Product model in MVC processing
 * 
 * @author Sergey Ogarkov
 *
 */
public class ProductEditor extends PropertyEditorSupport {

	ProductService productService;

	public ProductEditor(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public void setAsText(String id) {
		if (!id.isEmpty())
			setValue(this.productService.getCategoryById(id));
	}
}
