package Assignment20_Iterator;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        Iterator<Integer> iterator = fibonacciSequence.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " at position " + ((FibonacciIterator) iterator).getCurrentNth());
            String s = scanner.nextLine();
            if (s.equals("q")) {
                break;
            }
        }
    }
}
