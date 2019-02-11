package core;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		// создаем объект класса Word
		Word word1 = new Word();
		
		// задаем переменную, в которую положим  введенный с консоли текст
		String text = word1.fillTheText();
		
		// задаем переменную, в которую положим  введенный с консоли интервал
		int interval = word1.setInterval();
		
		// выводим на экран текст. К тексту применяем метод для замены каждого n символа
		System.out.println(word1.everyNth(text, interval));

	
	}
}
