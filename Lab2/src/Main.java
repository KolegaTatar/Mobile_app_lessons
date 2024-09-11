import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;

public class Main {

    public static  void pow_funct(int a, int b){
        double tab[] = new double[1000];
        for (int i = a; i <= 1000; i++){
            tab[i] =Math.pow(3,i);
        }
        
    }
    public static void main(String[] args) {
        File numbers = new File("C:\\Users\\student\\Videos\\Lab2\\Dane_PR2\\liczby.txt");
        try {
            Scanner scaneOfNumber = new Scanner(numbers);

            while (scaneOfNumber.hasNextInt()) {
                int number_l = scaneOfNumber.nextInt();
                if(4==4)
                    System.out.println(number_l);
                }


            } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

}
