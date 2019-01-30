package util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.*;

public class Factory {
	public static List<Order> orderFactory;
	public static List<Customer> customerFactory;
	public static List<Product> productFactory;

	public Order getOrderByID(int id) {
		
		Order order = orderFactory.parallelStream().filter(x-> x.getId() == id).findFirst().orElse(null);
		
		return order;
	}

	public Product getProductByID(int id) {

		Product product = productFactory.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		return product;
	}

	public Customer getCustomerByID(int id) {

		Customer customer = customerFactory.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		return customer;
	}

	public Product getProductByName(String name) {

		Product product = productFactory.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);

		return product;
	}

	public Customer getCustomerByName(String name) {

		Customer customer = customerFactory.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);

		return customer;
	}

	public List<Product> productsWithPriceMoreThan(double price) {

		List<Product> result = productFactory.stream().filter(x -> x.getPrice() >= price).collect(Collectors.toList());

		if (result != null)
			return result;
		else
			return null;
	}

	public List<Product> productsWithPriceLessThan(double price) {

		List<Product> result = productFactory.stream().filter(x -> x.getPrice() <= price).collect(Collectors.toList());

		if (result != null)
			return result;
		else
			return null;
	}

	public List<Product> removeProductsWithPriceMoreThan(double price) {
//		Convert List type to Stream Type with .stream() method which accepts predicate with .filter(predicate) method
//		and, after filtered, convert from Stream.class type to List again with operation .collect(Collectors.toList()) 
//		result = List >> Stream >> List
		List<Product> removedProducts = productFactory.stream().filter(x -> x.getPrice() >= price)
				.collect(Collectors.toList());

//		Remove products whose price is more than "price"
		boolean removedProductsFlag = productFactory.removeIf(x -> x.getPrice() >= price);

		if (removedProductsFlag)
			return removedProducts;
		else
			return null;
	}

	public List<Product> removeProductsWithPriceLessThan(double price) {

		List<Product> removedProducts = productFactory.stream().filter(x -> x.getPrice() >= price)
				.collect(Collectors.toList());

//		Remove products whose price is less than "price"
		boolean removedProductsFlag = productFactory.removeIf(x -> x.getPrice() <= price);

		if (removedProductsFlag)
			return removedProducts;
		else
			return null;
	}
	
}
