package core;

//Сделать класс Звездная система абстрактным.

public abstract class StarSystem {
	protected int size = 10000;
	protected int age = 3000;
	
	//Добавить к нему абстрактные методы (любые)
	public abstract void printInfoAboutSize();
	public abstract void printInfoAboutAges();

}
