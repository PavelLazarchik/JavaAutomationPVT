package planets;

public class Earth extends Planet {

	String namePlanet;
	String sputnikName;

	public void printInfoAboutName() {
		System.out.println(namePlanet);
	}

	public void printInfoAboutCountOfSputnik() {
		System.out.println(sputnikName);
	}

	// Один из классов на выбор должен содержать перегруженные связанные друг с
	// другом конструкторы (используя this) и создаваться с их помощью.
	public Earth(String namePlanet, String sputnikName) {
		this.namePlanet = namePlanet;
		this.sputnikName = sputnikName;
	}

	public Earth(String naming) {
		this(naming, naming);
	}
}
