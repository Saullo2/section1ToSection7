package entities;

import java.util.Random;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private Order order;
	
	public Product(Order order, String name, double price) {
		this.name = name;
		this.id = new Random().nextInt(999) + 1;
//		Same thing as
//		this.id = (int) (Math.random() * 50 + 1);
		this.order = order;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public Order getOrder() {
		return order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String result = "Order - ID: "+ this.id + ", Name: " + this.name + ", Price: " + this.price + ", Order ID: " + this.order.getId();
		
		return result;
	}

}
