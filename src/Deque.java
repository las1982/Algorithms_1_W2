import java.util.Iterator;
import java.util.NoSuchElementException;

import static edu.princeton.cs.algs4.StdOut.println;


public class Deque<Item> implements Iterable<Item> {
    // construct an empty deque
    private Item[] a;
    private int n;
    private int lastInd;
    private int firstInd;

    public Deque() {
        a = (Item[]) new Object[2];
        n = 0;
        firstInd = 1;
        lastInd = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        firstInd = (capacity - n) / 2;
        lastInd = firstInd + n - 1;
        int tempStart = firstInd;
        for (int i = 0; i < n; i++) {
            temp[tempStart++] = a[i];
        }
        a = temp;
        // a = java.util.Arrays.copyOf(a, capacity);
    }

    public void addFirst(Item item) {
        if (item == null) throw new java.lang.NullPointerException("cant add null");
        if (firstInd == 0 || lastInd == a.length - 1) resize(2 * a.length);    // double size of array if necessary
        a[--firstInd] = item;
        n++;
    }

    public void addLast(Item item) {
        if (item == null) throw new java.lang.NullPointerException("cant add null");
        if (firstInd == 0 || lastInd == a.length - 1) resize(2 * a.length);    // double size of array if necessary
        a[++lastInd] = item;
        n++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[firstInd];
        a[firstInd++] = null;                              // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[lastInd];
        a[lastInd--] = null;                              // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        Iterator a = null;
        return a;
    }

    // unit testing (optional)
    public static void main(String[] args) {
        Deque d = new Deque<>();
        println(d.size() + " of " + d.a.length);
        d.addFirst(1);
        println(d.size() + " of " + d.a.length);
        d.addFirst(1);
        println(d.size() + " of " + d.a.length);
        d.removeLast();
        println(d.size() + " of " + d.a.length);
        d.removeLast();
        println(d.size() + " of " + d.a.length);
        d.addFirst("");
        println(d.size() + " of " + d.a.length);

    }
}
