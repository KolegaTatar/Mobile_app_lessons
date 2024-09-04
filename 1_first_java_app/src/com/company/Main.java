    package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Podaj liczbe a: ");
        int a = myObj.nextInt();
        System.out.print("Podaj liczbe b: ");
        int b = myObj.nextInt();
        System.out.print("Podaj dzialanie: ");
        String wybor = myObj.nextLine();
        int wynik;


        if (wybor == "*") {
            wynik = a * b;
            System.out.print("wynik mnozenia: " + wynik);
        }
        else if (wybor == "/") {
            wynik = a / b;
            System.out.print("wynik dzielenia: " + wynik);
        }
        else if (wybor == "+") {
            wynik = a + b;
            System.out.print("wynik dodawania: " + wynik);
        }
        else {
            wynik = a - b;
            System.out.print("wynik odejmowania: " + wynik);
        }
    }
}
