package Esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<String> str = new HashSet<>();
        boolean bool = false;
        int n = 0;

        while (!bool) {
            try {
                System.out.println("Inserisci un numero intero");
                n = Integer.parseInt(input.nextLine());
                if (n <= 0) throw new Exception("Numero deve essere maggionre di zero");
                bool = true;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String[] app = new String[n];
        int cont = 0;
        for (int i = 0; i < n; i++) {
            bool = false;
            while (!bool) {
                try {
                    System.out.println("Inserisci parola n° " + (i + 1) + ":");
                    String word = input.nextLine();
                    if (str.contains(word)) {
                        app[cont] = word;
                        cont++;
                    } else str.add(word);
                    bool = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }


        printDuplicate(app);
        printNumberOfWords(str);
        printWords(str);

        input.close();

    }

    public static void printDuplicate(String[] app) {
        System.out.println("Parole duplicate");
        for (String x : app) {
            if (x != null)
                System.out.println(x);
        }
    }

    public static void printNumberOfWords(Set<String> str) {
        System.out.println("Hai inserito " + str.size() + " parole distinte");
    }

    public static void printWords(Set<String> str) {
        System.out.println("Le parole distinte inserite sono:");
        for (String x : str) {
            System.out.println(x);
        }
    }

}
