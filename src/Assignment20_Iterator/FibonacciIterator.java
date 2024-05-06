package Assignment20_Iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private FibonacciSequence fibonacciSequence;

    public FibonacciIterator(FibonacciSequence fibonacciSequence) {
        this.fibonacciSequence = fibonacciSequence;
    }

    @Override
    public boolean hasNext() {
        return fibonacciSequence.getNth() < 10; // generate only first 10 Fibonacci numbers
        //return true; // infinite generation of Fibonacci numbers
    }

    @Override
    public Integer next() {
        return fibonacciSequence.generateNext();
    }

    public int getCurrentNth() {
        return fibonacciSequence.getNth();
    }
}
