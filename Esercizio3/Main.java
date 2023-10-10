package Esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> mapList = new HashMap<>();
        boolean bool = false, bool2 = false;
        Scanner input = new Scanner(System.in);
        int risp = 0;

        CicloEsterno:
        while (true) {

            try {
                System.out.println("1:Create 2:Delete by name 3:search by phone 4:search by name 5:print All 0:Exit");
                risp = Integer.parseInt(input.nextLine());
                switch (risp) {
                    case 1: {
                        while (!bool2) {
                            try {
                                System.out.println("Inserisci nome");
                                String nome = input.nextLine();
                                System.out.println("Inserisci numero di telefono");
                                int number = Integer.parseInt(input.nextLine());
                                if (number <= 0) throw new Exception("Numero di telefono non valido");
                                addNewContact(mapList, nome, number);
                                bool2 = true;
                                System.out.println(mapList.size());
                            } catch (NumberFormatException e) {
                                System.err.println("Devi inserire un numero");
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        bool2 = false;
                        break;
                    }
                    case 2: {
                        while (!bool2) {
                            try {
                                System.out.println("Inserisci nome da eliminare");
                                String nome = input.nextLine();
                                deleteByName(mapList, nome);
                                bool2 = true;

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                bool2 = true;
                            }
                        }
                        bool2 = false;
                        break;
                    }
                    case 3: {
                        while (!bool2) {
                            try {
                                System.out.println("Inserisci numero da cercare");
                                int number = Integer.parseInt(input.nextLine());
                                searchByPhone(mapList, number);
                                bool2 = true;
                            } catch (NumberFormatException e) {
                                System.err.println("Devi inserire un numero");
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                                bool2 = true;
                            }
                        }
                        bool2 = false;

                        break;
                    }
                    case 4: {
                        while (!bool2) {
                            try {
                                System.out.println("Inserisci nome da cercare");
                                String nome = input.nextLine();
                                searchByName(mapList, nome);
                                bool2 = true;

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                bool2 = true;
                            }
                        }
                        bool2 = false;
                        break;
                    }
                    case 5: {
                        print(mapList);
                        break;
                    }
                    case 0: {
                        break CicloEsterno;
                    }
                }


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        input.close();
    }

    public static void addNewContact(Map<String, Integer> mapList, String nome, int number) {
        mapList.put(nome, number);
    }

    public static void deleteByName(Map<String, Integer> mapList, String nome) {
       
        if (mapList.remove(nome) == null) System.out.println("Elemento non trovato");
    }

    public static void searchByPhone(Map<String, Integer> mapList, int number) {

        Set<String> keys = mapList.keySet();
        boolean p = false;
        for (String x : keys) {
            if (mapList.get(x) == number) {
                System.out.println("utente: " + x + " phone: " + mapList.get(x));
                p = true;
            }

        }
        if (!p) System.out.println("Utente non trovato");
    }

    public static void searchByName(Map<String, Integer> mapList, String name) {
        int number = mapList.get(name);
        System.out.println("utent: " + name + " Telefono: " + number);
    }

    public static void print(Map<String, Integer> mapList) {

        Set<String> keys = mapList.keySet();
        for (String k : keys) {
            System.out.println("User: " + k + " phone: " + mapList.get(k));
        }
    }

}
