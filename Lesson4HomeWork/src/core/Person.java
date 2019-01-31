package core;

public class Person {

	String name;
	String surname;
	int age;
	String phone;
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setSurname (String surname) {
		this.surname = surname;
	}
	
	public void setPhone (String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	
	
	
	public void printAllInformation() {
		//Person person1 = new Person();
		System.out.println("Name:" + this.name + " Surname:" + this.surname + " Age:" + this.age + " Phone:" + this.phone);
	}
	
	public void printName() {
		System.out.println("Name:" + this.name + " Surname:" + this.surname);
	}
	
	public  boolean isAdult() {
		boolean isAdult;
		if(this.age >= 18) {
			isAdult = true;
		}else {
			isAdult = false;
		}
		return isAdult;
	}
}
