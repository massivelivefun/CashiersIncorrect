import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

// This project read a set of integers from a file and discovers if there is
// a difference between the Greedy and Dynamic versions of the Cashiers
// Algorithm under an amount of 1000 in change.
public class Program {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String fileName = null;
        System.out.print("Enter the input file relative to the pwd: ");
        try {
            fileName = scr.nextLine();
        } catch (IllegalStateException | NoSuchElementException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        try {
            scr = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        int size = 0;
        try {
            size = scr.nextInt();
        } catch (IllegalStateException | NoSuchElementException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        int pos = 0;
        int[] coins = new int[size];
        try {
            while (scr.hasNextInt()) {
                coins[pos++] = scr.nextInt();
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        Arrays.sort(coins);

        CashiersDynamic dynamic = new CashiersDynamic(coins);
        CashiersGreedy greedy = new CashiersGreedy(coins);

        for (int i = 1; i <= 1000; i += 1) {
            if (dynamic.getMinimumNumberOfCoins(i) !=
                    greedy.getMinimumNumberOfCoins(i)) {
                System.out.println("Cashiers incorrect for " + i);
                System.exit(0);
            }
        }
        System.out.println("NO DIFFERENCE");
    }
}
