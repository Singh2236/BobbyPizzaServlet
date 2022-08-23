package com.navpreet.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.navpreet.enums.Category;
import com.navpreet.interfaces.Menu;



public class MenuDataService {
	ArrayList<Menu> menuItems;
	Map<Menu, Integer> currentOrder = new HashMap<Menu,Integer>();
	
	public void addingMenuInList() {

		menuItems = new ArrayList<Menu>();
		menuItems.add(new Menu(1, "Margreta", Category.PIZZA, 5.00));
		menuItems.add(new Menu(2, "Salami", Category.PIZZA, 5.50));
		menuItems.add(new Menu(3, "Vorderschinken", Category.PIZZA, 5.50));
		menuItems.add(new Menu(4, "Pilze", Category.PIZZA, 5.50));
		menuItems.add(new Menu(5, "Roma", Category.PIZZA, 6.00));
		menuItems.add(new Menu(6, "Elsass", Category.FLAMKUCHEN, 6.00));
		menuItems.add(new Menu(7, "Lauterburg", Category.FLAMKUCHEN, 6.00));
		menuItems.add(new Menu(8, "NiederBronn", Category.FLAMKUCHEN, 6.50));
		menuItems.add(new Menu(9, "Hawai", Category.SALAT, 6.50));
		menuItems.add(new Menu(10, "Maison", Category.SALAT, 7.50));
		menuItems.add(new Menu(11, "Italia", Category.SALAT, 6.50));
		menuItems.add(new Menu(12, "Gyross-Teller", Category.GYROS, 9.50));
		menuItems.add(new Menu(13, "Schnitzel", Category.FLEISH, 9.00));
		menuItems.add(new Menu(14, "Pommes", Category.BEILAGEN, 3.00));
		menuItems.add(new Menu(15, "Tortellini al Forno", Category.ÜBERBAKEN, 7.00));
	}
	//get Full Menu
	public ArrayList<Menu> getMenuItems() {
		return menuItems;
	}

	
	//method to search in ArrayList of menu items. 
	public ArrayList<Menu> find(String searchTerm){
		ArrayList<Menu> foodSearchList = new ArrayList<Menu>();
		for(Menu menuItem : menuItems) {
			if (menuItem.getCategory().toString().equalsIgnoreCase(searchTerm)) {
				foodSearchList.add(menuItem);
			}
		}
		return foodSearchList;
	}
	
	//get the item when id is provided
	public Menu getItem(int id) {
		return menuItems.get(id);
	}
	
	
	// addToOrder returns:nothing Parameters: Menu and Quantity
	// need to understand again
	public void addToOrder(Menu menuItem, int quantity ) {
		int currentQuantity = 0;
		if(currentOrder.get(menuItem) != null) currentQuantity = currentOrder.get(menuItem); // number of foodItem ordered
			currentOrder.put(menuItem, currentQuantity + quantity);
			
		
	}
	
	//get order Total
	public Double getOrderTotal() {
		double d = 0d;
		for (Menu menuItem : currentOrder.keySet()) {
			d += currentOrder.get(menuItem) * menuItem.getPrice();
		}
		return d;
	}

}
