package com.ss.item.response;

import java.util.List;

import com.ss.item.request.Order;

public class OrderResponse {
	List<Order> orders;
	private float total;
	private float discount;
	private float finalAmount;
	private String discountPercentage;

	public List<Order> getOrders() {
		return orders;
	}

	public OrderResponse(List<Order> orders, float total, float discount, float finalAmount,
			String discountPercentage) {
		this.orders = orders;
		this.total = total;
		this.discount = discount;
		this.finalAmount = finalAmount;
		this.discountPercentage = discountPercentage;
	}

	public float getTotal() {
		return total;
	}

	public float getDiscount() {
		return discount;
	}

	public float getFinalAmount() {
		return finalAmount;
	}

	public String getDiscountPercentage() {
		return discountPercentage;
	}

	public void display() {
		String leftAlignFormat = "%-25s  %-10s %-15s %n";
		System.out.format(leftAlignFormat, "Item Name", "Count", "Price (INR)");
		for (Order order : orders) {
			System.out.format(leftAlignFormat, order.getItem(), order.getQuantity(), order.getPrice());
		}
		System.out.format(leftAlignFormat, "Total", "", total);
		System.out.format(leftAlignFormat, "Discount - " + discountPercentage, "", discount);
		System.out.format(leftAlignFormat, "Final Amount", "", finalAmount);
	}

	public String toHtml() {
		StringBuilder buf = new StringBuilder();
		buf.append("<html>" + "<body>" + "<table>" + "<tr>" + "<th>Item Name</th>" + "<th>Count</th>"
				+ "<th>Price (INR)</th>" + "</tr>");
		for (Order order : orders) {
			buf.append("<tr><td>").append(order.getItem()).append("</td><td>").append(order.getQuantity())
					.append("</td><td>").append(order.getPrice()).append("</td></tr>");
		}
		buf.append("</table>" + "</body>" + "</html>");
		return buf.toString();
	}
}
