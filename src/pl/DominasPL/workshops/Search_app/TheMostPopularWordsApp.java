package pl.DominasPL.workshops.Search_app;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Scanner;

public class TheMostPopularWordsApp {

    public static void main(String[] args) {

        int counter = countFileLines();
        String[] exludedElements = {"się", "bez", "ponieważ", "oraz"};

        String[] popWords = createPopWordsArray(counter);

        saveFilteredPopularWords(popWords, exludedElements);


    }

    public static int countFileLines() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/dominik/Pierwszy_Dzien/Warsztat_Gry/src/pl/DominasPL/workshops/Search_app/popular_words.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            return lines;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return -1;
    }

    public static String[] createPopWordsArray(int counter) {

        String[] popWords = new String[counter];

        File file = new File("/home/dominik/Pierwszy_Dzien/Warsztat_Gry/src/pl/DominasPL/workshops/Search_app/popular_words.txt");
        try {
            int i = 0;
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                popWords[i] = scan.nextLine();
                i++;

            }

            return popWords;

        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }

        return popWords;
    }

    public static void saveFilteredPopularWords (String[] popWords, String[] exludedElements) {

        try {
            PrintWriter printWriter = new PrintWriter("filtered_popular_words.txt");
            Connection connect = Jsoup.connect("http://www.onet.pl/");
            try {
                String line;
                Document document = connect.get();
                Elements links = document.select("span.title");
                for (Element elem : links) {
                    line = elem.toString();
                    for (int i = 0; i < popWords.length; i++) {
                        if (line.contains(popWords[i]) && !popWords[i].equals(exludedElements[0]) && !popWords[i].equals(exludedElements[1]) && !popWords[i].equals(exludedElements[2]) && !popWords[i].equals(exludedElements[3])) {
                            printWriter.println(popWords[i]);
                        }

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            printWriter.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Błąd zapisu do pliku.");
        }

    }



}
