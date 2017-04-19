import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
//import static edu.princeton.cs.algs4.StdOut.println;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a; // array of items
    private int n; // number of elements on stack

    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the queue
    public int size() {
        return n;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;

        // textbook implementation
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;

        // alternative implementation
        // a = java.util.Arrays.copyOf(a, capacity);
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new java.lang.NullPointerException("Can't add null");
        if (n == a.length)
            resize(2 * a.length); // double size of array if necessary
        a[n++] = item;
    }

    private void shuffle() {
        Item[] temp = (Item[]) new Object[n];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        StdRandom.shuffle(temp);
        for (int i = 0; i < n; i++) {
            a[i] = temp[i];
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");
        shuffle();
        Item item = a[n - 1];
        a[n - 1] = null; // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");
        shuffle();
        Item item = a[n - 1];
        return item;
    }

    public Iterator<Item> iterator() {
        return new RandomeArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class RandomeArrayIterator implements Iterator<Item> {
        private int i;
        Item[] temp = (Item[]) new Object[n];

        public RandomeArrayIterator() {
            shuffle();
            for (int i = 0; i < n; i++) {
                temp[i] = a[i];
            }
            i = 0;
        }

        public boolean hasNext() {
            return i < n;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return temp[i++];
        }

//        public String toString() {
//            String str = "";
//            while (hasNext()) {
//                str = str + next() + " ";
//            }
//            return str;
//        }
    }

    // unit testing (optional)
    public static void main(String[] args) {
//        RandomizedQueue rq = new RandomizedQueue();
//        rq.enqueue(1);
//        println(rq.iterator().toString());
//
//        rq.enqueue(2);
//        println(rq.iterator().toString());
//
//        rq.enqueue(3);
//        println(rq.iterator().toString());
//
//        rq.enqueue(4);
//        println(rq.iterator().toString());
//
//        rq.enqueue(5);
//        println(rq.iterator().toString());
//
//        rq.enqueue(6);
//        println(rq.iterator().toString());
//
//        rq.enqueue(7);
//        println(rq.iterator().toString());
//
//        rq.enqueue(8);
//        println(rq.iterator().toString());
//
//        rq.enqueue(9);
//        println(rq.iterator().toString());
//
//        rq.enqueue(10);
//        println(rq.iterator().toString());
//        // *****************************************************
//
//        rq.dequeue();
//        println(rq.iterator().toString());
//
//        rq.dequeue();
//        println(rq.iterator().toString());
//
//        rq.dequeue();
//        println(rq.iterator().toString());
//
//        println(rq.sample());
//        println(rq.iterator().toString());
//
//        println(rq.sample());
//        println(rq.iterator().toString());
//
//        println(rq.sample());
//        println(rq.iterator().toString());
//
//        println(rq.sample());
//        println(rq.iterator().toString());
    }
}