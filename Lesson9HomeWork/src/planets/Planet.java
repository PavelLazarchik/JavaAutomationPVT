package planets;

import core.StarSystem;

public class Planet extends StarSystem {
	int countOfPlanets;
	String nameOfSystem;
	
	public void printInfoAboutCountOfPlanets() {
		System.out.println(countOfPlanets);
	}
	
	public void printInfoAboutNameofSystem() {
		System.out.println(nameOfSystem);
	}
	
	//Реализовать эти методы в классах-наследниках. Продемонстрировать работы этих методов для каждого из наследников.


	@Override
	public void printInfoAboutSize() {
		System.out.println(size);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printInfoAboutAges() {
		// TODO Auto-generated method stub
		System.out.println(age);
		
	}

}
