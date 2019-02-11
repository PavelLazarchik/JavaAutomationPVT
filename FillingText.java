package core;
// для решения задачи планируется создать классы Word, Sentence and Paragraph - выделить типы воможных вариантов ввода текста
// для всех трех классов понадобится вводить текст и определять размер интервала, поэтому создаю класс с "общими" методами один раз, которые потребуются для всех остальных классов, чтобы не перегружать Word, Sentence and Paragraph

import java.util.Scanner;

public abstract class FillingText {

	//создал метод ввода текста с консоли. Так как параметр enteredText будем использовать в main class метод д.б. возвращаемым
	public String fillTheText() {
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Fill in any text");
		String enteredText = scanner1.nextLine();
		return enteredText;
	}
	
	//создал метод по определению интервала . Так как параметр interval будем использовать в main class метод д.б. возвращаемым
	public int setInterval() {
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Fill in an interval");
		int interval = scanner1.nextInt();
		return interval;
	}
	
	//создать метод, который определит введеный текст как слово, предложение или абзац
	public boolean checkTextType() {
		return true;
	}
	
	
	//создать  абстрактный метод, который заменит каждый n символ. Метод абстрактный, так как для каждого класса будет своя особенность
	public abstract String everyNth(String str, int n);	
}