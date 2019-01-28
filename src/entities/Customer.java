package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	
	private int id;
	private String name;
	private int cpf;
	private Date birthDate;
	private char gender;
	private List<Order> orders;
	
	public Customer(String name, int cpf, Date birthDate, char gender) {
		this.id = (int) Math.random() * 999 + 1;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.gender = gender;
		this.orders = new ArrayList<Order>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}
	
	

}
