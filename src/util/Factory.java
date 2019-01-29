package util;

import java.util.List;

import entities.*;

public class Factory {
	public static List<Order> orderFactory;
	public static List<Customer> customerFactory;
	public static List<Product> productFactory;

	public Order getOrderByID(int id) {
		
		return new Order();
	}

	public Product getProductByID(int id) {

		return new Product();
	}

	public Customer getCustomerByID(int id) {

		return new Customer();
	}
}
