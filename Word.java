package core; 

//реализовать замену каждого n символа для одного введенного слова

public class Word extends FillingText{
	
	@Override
	public String everyNth(String str, int n) {
		// проверка на случай, если пользователь задаст интервал меньше 0
	    if (n < 1) {
	        throw new IllegalArgumentException("n must be greater than 0");
	    }
	    StringBuilder result = new StringBuilder(str);
	    // проходим по длинне всего слова, где заменяем каждый n символ на %
	    for (int i = n - 1; i < str.length(); i += n) {
	        result.setCharAt(i, '%');
	    }
	    return result.toString();
	}

}
