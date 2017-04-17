import java.util.Iterator;

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
        return n ==0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
    }

    // add the item to the end
    public void addLast(Item item) {
    }

    // remove and return the item from the front
    public Item removeFirst() {
    }

    // remove and return the item from the end
    public Item removeLast() {
        return a;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
    }

    // unit testing (optional)
    public static void main(String[] args) {
    }
}