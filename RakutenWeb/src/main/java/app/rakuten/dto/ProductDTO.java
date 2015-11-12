package app.rakuten.dto;



import java.util.List;

import app.rakuten.models.Category;
import app.rakuten.models.Product;

public class ProductDTO {
	private Long id;	

	private String name;

	private float price;

	private String avaliable;

	private String description;
	
	private Category category;

	private List<Category> path;
	
	public ProductDTO(Product product) {
		this.id =  product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.avaliable = product.getAvaliable() == 1 ? "Yes" : "No";
		this.description = product.getDescription();
		this.category = product.getCategory();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(String avaliable) {
		this.avaliable = avaliable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getPath() {
		return path;
	}

	public void setPath(List<Category> path) {
		this.path = path;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	

}
