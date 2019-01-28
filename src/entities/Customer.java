package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import util.Factory;

public class Customer {

	private int id;
	private String name;
	private int cpf;
	private Date birthDate;
	private char gender;
	private List<Order> orders;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, int cpf, Date birthDate, char gender) {
		this.id = (int) Math.random() * 999 + 1;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.gender = gender;
		this.orders = new ArrayList<Order>();
		Factory.customerFactory.add(this);
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

	public String getBirthDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(birthDate);
	}

	// example: 25/10/1993
	public void setBirthDate(String birthDate) {

		TimeZone tz = TimeZone.getTimeZone("GMT");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(tz);

		try {

			this.birthDate = sdf.parse(birthDate);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
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
