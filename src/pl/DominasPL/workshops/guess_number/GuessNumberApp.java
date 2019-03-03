package pl.DominasPL.workshops.guess_number;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberApp {

    public static void main(String[] args) {
        guessNumber();
    }

    static void guessNumber() {

        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        int numberToGuess;
        int userNumber;
        int counter = 0;

        numberToGuess = 1 + r.nextInt(100);

        while (true) {

            System.out.print("Zgadnij liczbę: ");

            while(!scan.hasNextInt()) {
                scan.nextLine();
                System.out.print("To nie jest liczba! ");
            }

            userNumber = scan.nextInt();
            counter++;

            if (userNumber == numberToGuess) {
                System.out.println("Zgadłeś.");
                System.out.println("Liczba prób: " + counter);
                break;
            } else if (userNumber < numberToGuess) {
                System.out.println("Za mało! ");
            } else  {
                System.out.println("Za dużo! ");
            }


        }

    }


}
