package com.navpreet.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.navpreet.impl.MenuDataService;
import com.navpreet.interfaces.Menu;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchResults.html")
public class MenuSearchServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<html><body>");
		writer.println("<h1>Menu Bobby's Pizza</h1>");

		MenuDataService menuData = new MenuDataService();
		menuData.addingMenuInList();
		// ArrayList<Menu> menuItems = menuData.getMenuItems(); //replace get menu items
		// with the required menu
		String userSearchterm = request.getParameter("searchTerm");
		ArrayList<Menu> searchedItems = menuData.find(userSearchterm);
		writer.println("<h2>Search Results for " + userSearchterm + "  are : </h2>");
		writer.println("<ul>");

		if (!searchedItems.isEmpty()) {
			for (Menu items : searchedItems) {
				writer.println(items.getId());
				writer.println("&nbsp&nbsp");
				writer.println(items.getName());
				writer.println("&nbsp&nbsp");
				writer.println(items.getCategory());
				writer.println("&nbsp&nbsp");
				writer.println(items.getPrice() + " €");
				writer.println("<br>");
			}
		}else {
			writer.println("Found nothing for this search. Try Again! ");
			
		}

		writer.println("</ul>");
		writer.println("</body></html>");
		writer.close();
	}

}
