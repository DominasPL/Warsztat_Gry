package pl.DominasPL.workshops.guess_number;

import java.util.Scanner;

public class GuessNumberApp2 {

    public static void main(String[] args) {

        compGuess();

    }

    static void compGuess() {

        int userNum = userNumber();

        int min = 0;
        int max = 1000;
        int counter = 0;

        Scanner scan = new Scanner(System.in);
        String line = "";


        while(true) {

            if (counter < 10) {
                int guess = (max - min) / 2 + min;
                counter++;
                System.out.println("Próba nr " + counter + ". Zgaduję liczbę: " + guess);

                line = scan.nextLine();

                if (line.equals("zgadłeś")) {
                    System.out.println("Wygrałem!");
                    break;
                } else if (line.equals("za dużo")) {
                    max = guess;
                } else if (line.equals("za mało")) {
                    min = guess;
                } else {
                    System.out.println("Nie oszukuj!");
                    counter--;
                }

            } else {
                System.out.println("Przegrałem.");
                break;
            }

        }


    }



    static int userNumber() {

        Scanner scan = new Scanner(System.in);
        int number;
        String line = "";


        while(true) {

            System.out.print("Podaj liczbę z zakresu od 1 do 1000. A ja zgadnę w 10 próbach: ");

            if (scan.hasNextLine()) {
                line = scan.nextLine();
            }

            try {

                line = line.trim();
                number = Integer.parseInt(line);

                if (number < 1 || number > 1000) {
                    System.out.println("Podałeś niepoprawną liczbę. Spróbuj ponownie. \n");
                } else {
                    break;
                }


            } catch (NumberFormatException e) {
                System.out.println(" ");
            }



        }


        return number;
    }


}
