package lab.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product {
	Integer id;
	String name;
	//String categoryId;//no use this attribute and change this FK to Entity combination like below
	
	/**
	 * use category entity instead of categoryId attribute 
	 * to use all of attribute of category entity.
	 * */
	@ManyToOne
	@JoinColumn(name="categoryId")
	Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
