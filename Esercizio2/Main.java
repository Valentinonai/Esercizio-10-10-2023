package Esercizio2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean bool = false;
        int n = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (!bool) {
            try {
                System.out.println("Inserisci un numero intero");
                n = Integer.parseInt(input.nextLine());
                if (n <= 0) throw new Exception("Numero deve essere maggiore di zero");
                bool = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--------FN1-----------");
        list.addAll(fn1(n));
        for (Integer x : list) {
            System.out.println(x);
        }

        System.out.println("-------FN2----------");

        list2.addAll(fn2(list));
        for (Integer x : list2) {
            System.out.println(x);
        }

        System.out.println("--------FN3--------");

        System.out.println("Boolean true");
        fn3(list, true);
        System.out.println("Boolean false");
        fn3(list, false);

        input.close();
    }

    public static List<Integer> fn1(int n) {
        Random x = new Random();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(x.nextInt(0, 100));
        }
        Collections.sort(array);
        return array;
    }

    public static List<Integer> fn2(List<Integer> l1) {
        List<Integer> app = new ArrayList<>(l1);
        List<Integer> l2 = new ArrayList<>(l1);
        Collections.reverse(app);
        l2.addAll(app);
        return l2;
    }

    public static void fn3(List<Integer> l, boolean bool) {
        if (bool) {
            for (int i = 0; i < l.size(); i++) {
                if (i % 2 == 0) System.out.println(l.get(i));
            }
        } else {
            for (int i = 0; i < l.size(); i++) {
                if (i % 2 != 0) System.out.println(l.get(i));
            }
        }
    }
}