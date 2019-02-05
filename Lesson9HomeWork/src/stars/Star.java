package stars;

import core.StarSystem;

public class Star extends StarSystem {
	String starType;
	String  constellation;

	public void printInfoAboutStarType() {
		System.out.println(starType);
	}
	
	public void printInfoAboutConstellation() {
		System.out.println(constellation);
	}

	@Override
	public void printInfoAboutSize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printInfoAboutAges() {
		// TODO Auto-generated method stub
		
	}
}
