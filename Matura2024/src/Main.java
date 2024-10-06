import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        ArrayList<Integer> array_in_for_3 = new ArrayList<>();
        ArrayList<Integer> array_max_index = new ArrayList<>();
        int index_of_max_number =0;

        for (int i = 0; i < lines2.size(); i++) {
            int count_c =0;
            int count_2c=0;
            int h_r=0;
            int n = lines2.get(i);
            for (int j = 2; n != 1;) {
                if (n % j == 0) {
                    if(h_r!=j){
                        h_r=j;
                        count_2c++;
                    }
                    n /= j;
                    count_c++;
                }
                else {
                    j++;
                }
            }
            array_in_for_2.add(count_c);
            array_in_for_3.add(count_2c);
        }

        index_of_max_number = array_in_for_2.stream().max(Integer::compareTo).get();
        for (int i = 0; i < array_in_for_2.size(); i++) {
            if(array_in_for_2.get(i)==index_of_max_number){
                array_max_index.add(i);
            }
        }
        System.out.println("najwiecej liczynników: "+index_of_max_number +" dla: ");
        for (int i = 0; i < array_max_index.size(); i++) {
            System.out.println(lines2.get(array_max_index.get(i)));
        }

        System.out.println("");

        int lotOfDiff = array_in_for_3.stream().max(Integer::compareTo).get();
        System.out.print("najwiecej różnych: "+lotOfDiff+" dla: ");
        for (int i = 0; i < array_in_for_3.size(); i++) {
            if(array_in_for_3.get(i)==lotOfDiff){
                System.out.println(lines2.get(i));
            }
        };
        System.out.println();
        System.out.println();
        System.out.println("Rozwiązanie zadania 4.3:");
        try {
            PrintWriter trojki= new PrintWriter("trojki.txt");
            trojki.println("Dobre trójki:");
            int count_xyz =0;
            for (int i = 0; i < lines2.size(); i++) {
                int x = lines2.get(i);
                for (int j = 0; j < lines2.size(); j++) {
                    int y = lines2.get(j);
                    for (int k=0;k< lines2.size();k++) {
                        int z = lines2.get(k);
                        if((x!=y)&&(x!=z)&&(y!=z)&&(y%x==0)&&(z%y==0)){
                            trojki.println(x+" "+y+" "+z);
                            System.out.println(x+" "+y+" "+z);
                            count_xyz++;
                        }
                    }
                }
            }
            trojki.close();
            System.out.println("a) dobrych trójek jest "+count_xyz);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int count_uwxyz=0;
        for (int i = 0; i < lines2.size(); i++) {
            int u = lines2.get(i);
            for (int j = 0; j < lines2.size(); j++) {
                int w = lines2.get(j);
                for (int k=0;k< lines2.size();k++) {
                    int x = lines2.get(k);
                    for (int l = 0; l < lines2.size(); l++) {
                        int y = lines2.get(l);
                        for (int m=0;m< lines2.size();m++) {
                            int z = lines2.get(m);
                            if((u!=w)&&(u!=x)&&(x!=w)&&(x!=y)&&(x!=z)&&(y!=z)&&(y!=u)&&(y!=w)&&(z!=w)&&(z!=u)&&(w%u==0)&&(x%w==0)&&(y%x==0)&&(z%y==0)){
                                count_uwxyz++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("b) dobrych piątek jest "+count_uwxyz);


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