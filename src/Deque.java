import java.util.Iterator;
import java.util.NoSuchElementException;
import static edu.princeton.cs.algs4.StdOut.println;


public class Deque<Item> implements Iterable<Item> {
    // construct an empty deque
    private Item[] a;
    private int n;

    public Deque() {
        n = 0;
        a = (Item[]) new Object[n];
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
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

    // add the item to the front
    public void addFirst(Item item) {
        if (n == a.length) resize(2 * a.length);    // double size of array if necessary
        a[n++] = item;                            // add item

    }

    // add the item to the end
    public void addLast(Item item) {
        if (n == a.length) resize(2 * a.length);    // double size of array if necessary
        a[n++] = item;                            // add item

    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n - 1];
        a[n - 1] = null;                              // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n - 1];
        a[n - 1] = null;                              // to avoid loitering
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
        println(d.isEmpty());
        println(d.size());
    }
}
