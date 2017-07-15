package com.test.core.List;

public class Product {
	int id ;
	String name;
	float price;
	String dec;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getDec() {
		return dec;
	}
	public void setDec(String dec) {
		this.dec = dec;
	}
	public Product(int id, String name, float price, String dec) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dec = dec;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", dec=" + dec + "]";
	}
	
	
	
	
	
}
