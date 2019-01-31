package core;


public class MainClass {
	public static void main(String[] args) {
		Person person1 = new Person();
		
		person1.setAge(18);
		person1.setName("Pablo");
		person1.setSurname("Escobar");
		person1.setPhone("2222");
		
		person1.printAllInformation();
		person1.printName();
		
		System.out.println(person1.isAdult());
		
		
		Massive massive1 = new Massive();
		Massive massive2 = new Massive();
		Massive massive3 = new Massive();
		
		int[] array  = {2, 4, 6};
		massive1.printMassiveAsLine(array);
		massive2.getSumOfElements(array);
		massive3.multiptyBy3(array);
	}
}
