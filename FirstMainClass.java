package core;
/**
 * 7. В методе main другого класса (любого), лежащего в том же пакете что и Tester, создать объект класса Tester, используя любой из перегруженных конструкторов. 
 * продемонстрировать последовательный вызов всех методов класса Tester, если это возможно. 
 * если невозможно - написать комментарий почему. 
 */

public class FirstMainClass {
	public static void main(String[] args) {
		Tester tester1 = new Tester("Pavel", "Lazarchik", 3, "Advanced", 500.0);
		
		//tester1.increaseSalaryInTwo(); - падает ошибка, так как метод increaseSalaryInTwo имеет модификатор доступа private 
		tester1.expirienceInformation();
		tester1.printNameSurname();
		tester1.printAllInformation();
	}
}

