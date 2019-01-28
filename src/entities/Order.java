package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private List<Product> products;
	private Date dateOfOrder;
	private String description;
	private int id;
	private Customer customer;

	public Order(Customer customer, String description) {
		this.description = description;
		this.customer = customer;
		this.id = (int) Math.random() * 999 + 1;
//		Current date
		this.dateOfOrder = new Date();
		products = new ArrayList<Product>();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public int getId() {
		return id;
	}

	public void addProductInOrder(Product p) {

		this.products.add(p);
		System.out.println("List of Products updated:");

		for (Product product : this.products) {
			System.out.println("Product - ID: " + ", Name: " + product.getName() + ", Price: " + product.getPrice());
		}
	}

	public void removeProductFromOrder(Product p) {

		this.products.remove(p);
		System.out.println("List of Products updated:");

		for (Product product : this.products) {
			System.out.println("Product - ID: " + ", Name: " + product.getName() + ", Price: " + product.getPrice());
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		String result = "Order - ID: " + this.id + ", Date: " + this.dateOfOrder + ", Related Customer: "
				+ this.customer;

		return result;
	}

}
