package anotherCorePackage;

import core.Tester;

/*
 * 7а. Повторить вышеописанные действия, однако класс с методом main вынести в другой пакет.
 */

public class SecondMainClass {
	public static void main(String[] args) {
		Tester tester1 = new Tester("Pavel", "Lazarchik", 3, "Advanced", 500.0);
		
				//tester1.increaseSalaryInTwo(); - падает ошибка, так как метод increaseSalaryInTwo имеет модификатор доступа private 
				// tester1.expirienceInformation(); - падает ошибка, так как метод expirienceInformation имеет модификатор доступа friendly 
				//tester1.printNameSurname();  - падает ошибка, так как метод printNameSurname имеет модификатор доступа friendly 
				tester1.printAllInformation();
	}
}
