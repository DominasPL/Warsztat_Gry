package pl.DominasPL.workshops.Lotto_app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {

        checkResults();

    }

    static void checkResults() {

        int[] sortedNumbers = sortNumbers();
        int[] randNumbers = compNumbers();
        int counter = 0; // licznik zwiekszany w przypadku trafienia przez uzytkownika liczby.

//        System.out.println("Liczby LOTTO: " + Arrays.toString(randNumbers));
        System.out.println("Twoje liczby to: " + Arrays.toString(sortedNumbers));

        for (int i = 0; i < sortedNumbers.length; i++) {
            for (int j = 0; j < randNumbers.length; j++) {
                if (sortedNumbers[i] == randNumbers[j]) {
                    counter++;
                }
            }
        }

        switch (counter) {
            case 3:
                System.out.println("Trafiłeś trójkę!");
                break;
            case 4:
                System.out.println("Trafiłeś czwórkę!");
                break;
            case 5:
                System.out.println("Trafiłeś piątkę!");
                break;
            case 6:
                System.out.println("Trafiłeś szóstkę!");
                break;
            default:
                System.out.println("Niestety nie udało Ci się wygrać! Spróbuj ponownie.");
                break;
        }

    }

    static int[] sortNumbers() {

        int[] myNumbers = userNumbers();

        Arrays.sort(myNumbers);

        return myNumbers;


    }

    static int[] compNumbers() {


        Random r = new Random();

        int[] tab = new int[6];


        for (int i = 0; i < tab.length ; i++) { // losowanie 6 liczb LOTTO
            tab[i] = 1 + r.nextInt(49);

            for (int j = 0; j < i ; j++) { // sprawdzenie czy liczba sie nie powtarza
                if (tab[j] == tab[i]) {
                    i--;
                    break;
                }
            }

        }

        return tab;

    }

    static int[] userNumbers()  {

        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[6];
        int i = 0;
        String line = " ";
        int userValue;

        while(true) { // pobieranie od uzytkownika 6 liczb

            if ( i == numbers.length) {
                break;
            }

            System.out.print("Podaj numer z zakresu od 1 do 49: ");

            if (scan.hasNextLine()) {
                line = scan.nextLine();

            }

            try {
                line = line.trim();
                userValue = Integer.parseInt(line);

                if (userValue > 0 && userValue <= 49) {
                    numbers[i] = userValue;
                    for (int j = 0; j < i; j++) { // sprawdzenie czy liczba się nie powtarza
                        if (numbers[j] == numbers[i]) {
                            System.out.println("Podałeś już tą liczbę! ");
                            i--;
                            break;
                        }

                    }

                    i++;

                } else {
                    System.out.println("Podales niepoprawną liczbę");
                }



            } catch (NumberFormatException e) {
                System.out.println(" ");
            }

        }

        return numbers;

    }


}
