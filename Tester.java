package core;

/**
 * Создать класс Tester со следующими полями: -name -surname -expirienceInYears
 * -englishLevel -salary Самостоятельно решить, какое модификатор доступа будет
 * иметь каждое из полей, при этом использовать все изученные модификаторы.
 */

public class Tester {

	public String name;
	public String surname;
	int expirienceInYears;
	protected String englishLevel;
	private double salary;

	// 1. Перегрузить в этом классе 3 конструктора, каждый из которых будет
	// последовательно вызывать другой используя this(...); Конструктор с наибольшим
	// числом параметров сделать с уровнем доступа отовсюду.

	// Создаем конструктор
	public Tester() {
	}

	// Перегружаем конструктор первый раз
	protected Tester(String name) {
		this.name = name;
	}

	// Перегружаем конструктор второй раз
	private Tester(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public Tester(String name, String surname, int expirienceInYears, String englishLevel, double salary) {
		this.name = name;
		this.surname = surname;
		this.expirienceInYears = expirienceInYears;
		this.englishLevel = englishLevel;
		this.salary = salary;
	}

	// 2. Написать для каждого поля get- и set- методы с уровнем доступа только
	// внутри пакета.

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}
	
	String getSurname() {
		return surname;
	}
	
	void setSurname(String surname) {
		this.surname = surname;
	}
	
	int getExpirienceInYears() {
		return expirienceInYears;
	}
	
	void setExpirienceInYears(int expirienceInYears) {
		this.expirienceInYears = expirienceInYears;
	}
	
	String getEnglishLevel() {
		return englishLevel;
	}
	
	void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}
	
	double getSalary() {
		return salary;
	}
	
	void setSalary(double salary) {
		this.salary = salary;
	}
	
	// 3. Написать метод с уровнем доступа только внутри класса, который будет возвращать salary*2;
	private double increaseSalaryInTwo() {
		double increasedSalary = salary * 2;
		System.out.println(increasedSalary);
		return increasedSalary;
	}
	
	// 4. Написать метод с уровнем доступа только внутри пакета, который будет возвращать количество опыта в месяцах;
	void expirienceInformation() {
		double expirienceInMonth = expirienceInYears * 12;
		System.out.println(expirienceInMonth);
	}
	
	// 5. Написать метод с уровнем доступа внутри пакета и для наследников в других пакетах, который выводит на экран имя и фамилию;
	protected void printNameSurname() {
		System.out.println("Name: " + name + " Surname: " + surname);
	}
	
	// 6. Написать метод с уровнем доступа отовсюду, который в одну строку будет выводить всю информацию о пользователе.
	public void printAllInformation() {
		System.out.println("Name: " + name + " Surname: " + surname + " Expirience in years: " + expirienceInYears + " English level: " + englishLevel + " Salary: " + salary);
	}
}
