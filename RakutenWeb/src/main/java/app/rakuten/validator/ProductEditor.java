package app.rakuten.validator;

import java.beans.PropertyEditorSupport;

import app.rakuten.model.Product;
import app.rakuten.service.CategoryService;

/**
 * Modify bean {@link Product}, ProductEditor replace String Id Category to
 * Object Category, Class helper for saving of {@link Product} model in MVC
 * processing
 * 
 * @author Sergey Ogarkov
 *
 */
public class ProductEditor extends PropertyEditorSupport {

	CategoryService categoryService;

	public ProductEditor(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public void setAsText(String id) {
		if (!id.isEmpty())
			setValue(this.categoryService.getCategoryById(id));
	}
}
