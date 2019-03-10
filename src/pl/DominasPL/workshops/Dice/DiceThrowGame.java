package pl.DominasPL.workshops.Dice;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DiceThrowGame {

    public static void main(String[] args) {

        int sum = returnResult("2D100+20");
        System.out.println(sum);
    }

    public static int returnResult(String str) {

        int sum = 0;
        int multiplier = 1;
        String diceType = "D";
        char sign = ' ';
        int zOptional = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(str, "D+-", true);
        String[] elements = new String[stringTokenizer.countTokens()];

        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            elements[i] = stringTokenizer.nextToken();
            i++;
        }

        for (int j = 0; j < elements.length; j++) {
            if (elements[j].equals("D")) {
                diceType += elements[j + 1];

            } else if (elements[j].equals("-")) {
                sign = '-';
                zOptional = Integer.parseInt(elements[j+1]);
            } else if (elements[j].equals("+")) {
                sign = '+';
                zOptional = Integer.parseInt(elements[j+1]);
            }
        }

        try {
            multiplier = Integer.parseInt(elements[0]);

        } catch (NumberFormatException e) {
            System.out.print("");
        }

        Random rnd = new Random();
        int rndNumber = 0;

        for (int j = 0; j < multiplier; j++) {
            if (diceType.equals("D3")) {
                rndNumber = (1 + rnd.nextInt(2));
                System.out.println("Rzut nr: " + (j + 1) + ": " + rndNumber + ".");
                sum += rndNumber;

            } else if (diceType.equals("D4")) {
                rndNumber = (1 + rnd.nextInt(3));
                System.out.println("Rzut nr: " + (j + 1) + ": " + rndNumber + ".");
                sum += rndNumber;

            } else if (diceType.equals("D6")) {
                rndNumber = (1 + rnd.nextInt(5));
                System.out.println("Rzut nr: " + (j + 1) + ": " + rndNumber + ".");
                sum += rndNumber;

            } else if (diceType.equals("D8")) {
                rndNumber = (1 + rnd.nextInt(7));
                System.out.println("Rzut nr: " + (j + 1) + ": " + rndNumber + ".");
                sum += rndNumber;

            } else if (diceType.equals("D10")) {
                rndNumber = (1 + rnd.nextInt(9));
                System.out.println("Rzut nr: " + (j + 1) + ": " + rndNumber + ".");
                sum += rndNumber;

            } else if (diceType.equals("D12")) {
                rndNumber = (1 + rnd.nextInt(11));
                System.out.println("Rzut nr: " + (j + 1) + ": " + rndNumber + ".");
                sum += rndNumber;

            } else if (diceType.equals("D20")) {
                rndNumber = (1 + rnd.nextInt(19));
                System.out.println("Rzut nr: " + (j + 1) + ": " + rndNumber + ".");
                sum += rndNumber;

            } else if (diceType.equals("D100")) {
                rndNumber = (1 + rnd.nextInt(99));
                System.out.println("Rzut nr: " + (j + 1) + ": " + rndNumber + ".");
                sum += rndNumber;

            }


        }

        if (zOptional != 0 && sign == '+') {
            sum += zOptional;
        } else if (zOptional != 0 && sign == '-') {
            sum -= zOptional;
        }


        return sum;
    }
}
