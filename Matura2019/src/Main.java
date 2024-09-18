import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lines = new ArrayList<>();

        try {
            Scanner scaner = new Scanner(new File("src/Dane_PR2/przyklad.txt"));
            while (scaner.hasNextLine()) {
                lines.add(parseInt(scaner.nextLine()));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono  pliku");
        }

        System.out.println("Rozwiązanie zadania 4.1:");
        System.out.println(zad4_1(lines));

        System.out.println("Rozwiązanie zadania 4.2:");
        zad4_2(lines).forEach(System.out::println);

        System.out.println("Rozwiązanie zadania 4.3:");
        List<Integer> results43 = zad4_3(lines);
        System.out.printf("pierwsza liczba ciągu:"+lines.get(results43.get(2))+" długość: "+results43.get(0)+" największy wspólny dzielnik: "+results43.get(1));
    }

    private static long zad4_1(ArrayList<Integer> lines) {
        ArrayList<Integer> array_in_for = new ArrayList<>();

        for (int i = 0; Math.pow(3, i) <= 100000; i++) {
            array_in_for.add((int) Math.pow(3, i));
        }
        return lines.stream().filter(array_in_for::contains).count();
    }

    private static List<Integer> zad4_2(ArrayList<Integer> lines) {
        return lines.stream().filter((n) -> {
            int l = 0, c = n;

            for (int m = c % 10; c > 0; c = c / 10, m = c % 10) {
                l += pierwsza(m);
            }

            return l == n;
        }).toList();
    }

    private static List<Integer> zad4_3(ArrayList<Integer> lines) {
        int max_l = 0, max_nwd = 0, max_i = 0;

        for (int i = 0; i < lines.size(); i++) {
            int line_nwd = lines.get(i), j = i + 1;

            for (; j < lines.size() && nwd(line_nwd, lines.get(j)) > 1; j++) {
                line_nwd = nwd(line_nwd, lines.get(j));
            }

            if (j - i > max_l) {
                max_l = j - i;
                max_nwd = line_nwd;
                max_i = i;
            }
        }
        return List.of(max_l, max_nwd, max_i);
    }

    private static int pierwsza(int n) {
        if(n<=1){
            return 1;
        }
        else{
            return n*pierwsza(n-1);
        }
    }

    private static int nwd(int a, int b) {
        if(b==0){
            return a;
        }
        else {
            return nwd(b,a%b);
        }
    }
}