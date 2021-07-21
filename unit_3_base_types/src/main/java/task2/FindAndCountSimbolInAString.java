package task2;

import myColors.MyColors;

import java.util.Arrays;

/**
 * FindAndCountSimbolInAString
 * реализует задачу, которая принимает строку с консоли и вычленяет все символы
 * латиницы/кириллицы и сортирует их, указывая количество вхождений каждого символа
 * Пример:
 * Входные данные: 1w4tt!7
 * Выходные данные:
 * 1. t - 2
 * 2. w - 1
 */

public class FindAndCountSimbolInAString {
    private  String example = "";
    int countLetter = 0;

    public FindAndCountSimbolInAString(String example) {
        MyColors myColors = new MyColors();
        this.example = example;


        String result = "";
        for (int i = 0; i < example.length(); i++) {
            if (Character .isLetterOrDigit(example.charAt(i)))
                result = result + (example.charAt(i));
        }
        example = result.toUpperCase();
        char[] ArrayExample = example.toCharArray();
        char[] ArrayOfSymbol;
        String bufer = "";
        Character buferC = '1';
        int count = 0;
        for (int i = 0; i < ArrayExample.length; i++) {
            if (!Character.isDigit(ArrayExample[i])){
                bufer = bufer + ArrayExample[i];
                countLetter++;
            }
        }
        ArrayOfSymbol = bufer.toCharArray();
        Arrays.sort(ArrayOfSymbol);
        if (ArrayOfSymbol.length == 0){
            System.out.println("text have only numbers");
            return;
        }
        buferC = ArrayOfSymbol[0];

        System.out.println(myColors.ANSI_BLUE + "ANSWER : " +myColors.ANSI_RED + countLetter + " total characters");
        for (int i = 0; i < ArrayOfSymbol.length; i++) {
            if ((ArrayOfSymbol[i] == buferC)){
                count++;
            }else {
                System.out.print( buferC + " - " + count + " | ");
                buferC = ArrayOfSymbol[i];
                count = 1;
            }

        }
        System.out.print( buferC + " - " + count + " | "  + myColors.ANSI_RESET);
    }
    public FindAndCountSimbolInAString() {
    }

}
