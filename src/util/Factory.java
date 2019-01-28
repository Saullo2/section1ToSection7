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
}
