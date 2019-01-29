package entities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import util.Factory;

public class Order {

	private List<Product> products;
	private Date dateOfOrder;
	private String description;
	private int id;
	private Customer customer;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Customer customer, String description) {
		this.description = description;
		this.customer = customer;
		this.id = (int) Math.random() * 999 + 1;
//		Current date
		this.dateOfOrder = new Date();
		products = new ArrayList<Product>();
		Factory.orderFactory.add(this);
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

	public String timeSinceOrdered() {

		Date today2 = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today2);
		c.add(Calendar.DAY_OF_MONTH, -dateOfOrder.getDay());
		c.add(Calendar.MONTH, -dateOfOrder.getMonth());
		c.add(Calendar.YEAR, -dateOfOrder.getYear());

		Date difference = c.getTime();

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
//		
//		
//		return sdf2.format(difference);

		Date today = new Date();

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(today);
		c2.setTime(dateOfOrder);

		Calendar c3 = Calendar.getInstance();
		c3.setTime(new Date(Duration.between(c1.toInstant(), c2.toInstant()).toMillis()));
		int days = c3.DAY_OF_MONTH;
		int months = c3.MONTH;
		int years = c3.YEAR;

		String result = "";
		result += (days >= 1) ? days + " days " : "";
		result += (months >= 1) ? months + " months " : "";
		result += (years >= 1) ? years + " years " : "";
		result += " since the date you ordered the product.";

		return result;
	}

}
