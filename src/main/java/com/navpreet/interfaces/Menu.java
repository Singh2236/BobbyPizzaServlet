package com.navpreet.interfaces;

import com.navpreet.enums.Category;

public class Menu {
	int id;
	String name;
	Category category;
	double price; // prices are for small pizza the rest are default

	public Menu(int id, String name, Category cat, double price) {
		this.id = id;
		this.name = name;
		this.category = cat;
		this.price = price;

	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return id + "    " + name + "    " + category + "    " + price;
	}

}
