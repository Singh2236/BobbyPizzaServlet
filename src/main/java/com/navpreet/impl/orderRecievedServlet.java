package com.navpreet.impl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderRecived.html")
public class orderRecievedServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		MenuDataService mds = new MenuDataService();
		int maxId = mds.getMenuItems().size();
		mds.addingMenuInList();
		System.out.println("Order : \n");

		for (int i = 1; i <= maxId; i++) {
			String quantity = request.getParameter("item_" + i); // Front end Item names eg. item_1..

			try {
				int q = Integer.parseInt(quantity);
				if (q > 0) {
					mds.addToOrder(mds.getItem(i), q); // getItem(i) = get item 1 - 15 according to Ids
					System.out.println(mds.getItem(i).getName() + " X " + q);
				}

			} catch (NumberFormatException e) {
				// it means that there wasn't any item for this order
			}
		}
		System.out.println();
		Double total = mds.getOrderTotal();
		System.out.println("Price: " +total);
		System.out.println();
		System.out.println();


		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("text/html");

		out.println("<html><body><h1>Bobby's Pizza</h1>");
		out.println("<h2>Order your food</h2>");

		out.println("Thank you - your order has been received. You need to pay Euro: " + total);
		out.println("Want to make a <a href = '/BobbysPizza/order.html'> New Order </a> ?" );
		
		

		out.println("</body></html>");
		out.close();

	}

}
