package app.rakuten.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.rakuten.models.Product;

/**
 * Validator of fields Product
 * 
 * @author Sergey Ogarkov
 *
 */
@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.product.name");
		ValidationUtils.rejectIfEmpty(errors, "category", "NotEmpty.product.category");
	}
}
