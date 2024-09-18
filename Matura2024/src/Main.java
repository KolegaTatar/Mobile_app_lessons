import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lines = new ArrayList<>();
        ArrayList<Integer> lines2 = new ArrayList<>();

        try {
            Scanner scaner = new Scanner(new File("src/Dane_2205/liczby.txt"));
            Scanner scaner2 = new Scanner(new File("src/Dane_2205/liczby.txt"));
            while (scaner.hasNextLine()) {
                lines.add(parseInt(scaner.nextLine()));
            }
            while (scaner2.hasNextLine()) {
                lines2.add(parseInt(scaner2.nextLine()));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono  pliku");
        }

        System.out.println("Rozwiązanie zadania 4.1:");
        System.out.print(zad4_1(lines).get(zad4_1(lines).size()-1));
        System.out.print(" ");
        System.out.println(zad4_1(lines).get(0));


        System.out.println("Rozwiązanie zadania 4.2:");
        ArrayList<Integer> array_in_for_2 = new ArrayList<>();
        int index_of_max_number =0;
        for (int i = 0; i < lines2.size(); i++) {
            int count_c =0;
            int n = lines2.get(i);
            for (int j = 2; n != 1;) {
                if (n % j == 0) {
                    n /= j;
                    count_c++;
                }
                else {
                    j++;
                }

            }
            array_in_for_2.add(count_c);
        }

        System.out.println(array_in_for_2);
        index_of_max_number = array_in_for_2.stream().max(Integer::compareTo).get();
        System.out.println(array_in_for_2.indexOf(index_of_max_number));
        System.out.println(index_of_max_number);
    }

    private static ArrayList<Integer> zad4_1(ArrayList<Integer> lines) {
        ArrayList<Integer> array_in_for = new ArrayList<>();

        int cout_c = 0;
        for (int i = 0; i < lines.size(); i++) {
            int last_digit = lines.get(i)%10;
            int first_digit = firstDigit(lines.get(i));
            if(first_digit == last_digit) {
                cout_c++;
                array_in_for.add(lines.get(i));
            }
        }
        array_in_for.add(cout_c);
        return array_in_for;
    }




    private static int firstDigit(int n) {
        int x;
        do {
            x = n%10;
            n = n/10;
        }
        while(n>0);
        return x;
    }



}