package Assignment20_Iterator;

import java.util.Iterator;

public class FibonacciSequence implements Sequence {
    private int previous, current; // state variables for Fibonacci sequence
    private int nth; // position of current Fibonacci number (most recent generated number)

    public FibonacciSequence() {
        this.previous = 0;
        this.current = 1;
        this.nth = 0;
    }

    public int getNth() {
        return nth;
    }

    public int generateNext() {
        nth += 1;
        if (nth > 1) {
            int next = current + previous;
            previous = current;
            current = next;
        }
        return current;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }
}
