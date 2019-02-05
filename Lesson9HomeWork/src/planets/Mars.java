package planets;

public class Mars extends Planet {
	
	String name;
	int countOfsputnik;
	
	public void printInfoAboutName() {
		System.out.println(name);
	}
	
	public void printInfoAboutCountOfSputnik() {
		System.out.println(countOfsputnik);
	}
	
	// Другой - систему сеттеров и геттеров и инициализироваться при помощи их.
	String getName() {
		return name;
	}
	
	int getCountOfsputnik() {
		return countOfsputnik;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setCountOfsputnik(int countOfsputnik) {
		this.countOfsputnik = countOfsputnik;
	}

}
