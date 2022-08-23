package com.navpreet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.navpreet.impl.MenuDataService;
import com.navpreet.interfaces.Menu;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class ViewMenuServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		writer.println("<html><body>");
		writer.println("<h1>Menu Bobby's Pizza</h1>");
		writer.println("<h3></h3>");
		writer.println("<a href ='/BobbysPizza/searchResults.html?searchTerm=pizza' > PIZZA </a>");
		writer.println("&nbsp");
		writer.println("<a href ='/BobbysPizza/searchResults.html?searchTerm=flamkuchen' > FLAMKUCHEN </a>");
		writer.println("&nbsp");
		writer.println("<a href ='/BobbysPizza/searchResults.html?searchTerm=SALAT' > SALAT </a>");
		writer.println("&nbsp");
		writer.println("<a href ='/BobbysPizza/searchResults.html?searchTerm=GYROS' > GYROS </a>");
		writer.println("&nbsp");
		writer.println("<a href ='/BobbysPizza/searchResults.html?searchTerm=ÜBERBAKEN' > ÜBERBAKEN </a>");
		writer.println("&nbsp");
		writer.println("<a href ='/BobbysPizza/searchResults.html?searchTerm=FLEISH' > FLEISH </a>");
		writer.println("&nbsp");
		writer.println("<a href ='/BobbysPizza/order.html' > Place Order </a>");
		
		writer.println("<ul>");

		MenuDataService menuData = new MenuDataService();
		menuData.addingMenuInList();

		for (Menu items : menuData.getMenuItems()) {
			writer.println(items.getId());
			writer.println("&nbsp&nbsp");
			writer.println(items.getName());
			writer.println("&nbsp&nbsp");
			writer.println(items.getCategory());
			writer.println("&nbsp&nbsp");
			writer.println(items.getPrice() + " €");
			writer.println("<br>");
		}

		writer.println("</ul>");
		
		
		writer.println("</body></html>");
		writer.close();
	}

}
