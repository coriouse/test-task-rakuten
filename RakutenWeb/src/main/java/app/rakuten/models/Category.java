package app.rakuten.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * An order.
 */
@Entity
@Table(name = "T_CATEGORY")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "id_parent")
	private Long parent;

	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryPath")
	private Collection<Product> items = new LinkedHashSet<Product>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the items
	 */
	public Collection<Product> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(Collection<Product> items) {
		this.items = items;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + "]";
	}

}
