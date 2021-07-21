package task1;

/**
 * FindNumbersInAString
 * реализует задачу, которая принимает строку с консоли и вычленяет все числа и находит
 * их сумму
 *         Пример:
 *         Входные данные: 1w4tt!7
 *         Выходные данные: 12
 */

public class FindNumbersInAString {
    private  String example = "";
    private int result = 0;
    public FindNumbersInAString(String exemple) {
        this.example = exemple;
        char[] ArrayExemple = exemple.toCharArray();
        for (int i = 0; i < ArrayExemple.length; i++) {
            if (Character.isDigit(ArrayExemple[i])){
                System.out.print(ArrayExemple[i] + " ");
                result = result + Integer.parseInt(String.valueOf(ArrayExemple[i]));
            }
        }
    }
    public int getResult() {
        return result;
    }

}
