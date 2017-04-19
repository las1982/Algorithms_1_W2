import java.util.Iterator;
import java.util.NoSuchElementException;
//import static edu.princeton.cs.algs4.StdOut.println;

public class Deque<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;
    private int lastInd;
    private int firstInd;

    public Deque() {
        a = (Item[]) new Object[3];
        n = 0;
        resetIndeces();
    }

    private void resetIndeces() {
        firstInd = 1;
        lastInd = 1;

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
        int newFirst = (capacity - n) / 2;
        int tempStart = newFirst;
        for (int i = firstInd; i <= lastInd; i++) {
            temp[tempStart++] = a[i];
        }
        firstInd = newFirst;
        lastInd = firstInd + n - 1;
//        StdOut.println("Resized from " + a.length + " to " + capacity);
        a = temp;

        // a = java.util.Arrays.copyOf(a, capacity);
    }

    public void addFirst(Item item) {
        if (item == null)
            throw new java.lang.NullPointerException("cant add null");
        if (firstInd == 0 || lastInd == a.length - 1)
            resize(2 * a.length); // double size of array if necessary
        if (n == 0) {
            a[firstInd] = item;
        }
        else {
            a[--firstInd] = item;
        }
        n++;
//        StdOut.println("Added first");
//        StdOut.println(size() + " of " + a.length);
//        StdOut.println("firstInd = " + firstInd + ", lastInd = " + lastInd);
    }

    public void addLast(Item item) {
        if (item == null)
            throw new java.lang.NullPointerException("cant add null");
        if (firstInd == 0 || lastInd == a.length - 1)
            resize(2 * a.length); // double size of array if necessary
        if (n == 0) {
            a[lastInd] = item;
        }
        else {
            a[++lastInd] = item;
        }
        n++;
//        StdOut.println("Added last");
//        StdOut.println(size() + " of " + a.length);
//        StdOut.println("firstInd = " + firstInd + ", lastInd = " + lastInd);
    }

    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item item = a[firstInd];
        if (n == 1) {
            a[firstInd] = null; // to avoid loitering
            resetIndeces();
        }
        else {
            a[firstInd++] = null; // to avoid loitering
        }
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
//        StdOut.println("Removed first");
//        StdOut.println(size() + " of " + a.length);
//        StdOut.println("firstInd = " + firstInd + ", lastInd = " + lastInd);
        return item;
    }

    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");
        Item item = a[lastInd];
        if (n == 1) {
            a[lastInd] = null; // to avoid loitering
            resetIndeces();
        }
        else {
            a[lastInd--] = null; // to avoid loitering
        }
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
//        StdOut.println("Removed last");
//        StdOut.println(size() + " of " + a.length);
//        StdOut.println("firstInd = " + firstInd + ", lastInd = " + lastInd);
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i;

        public ArrayIterator() {
            i = firstInd;
        }

        public boolean hasNext() {
            return i <= lastInd && n > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation isn't supported");
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("There isn't next element");
            return a[i++];
        }

//        public String toString() {
//            String str = "";
//            while (hasNext()) {
//                str = str + next() + " ";
//                str = str.concat(next()).concat(" ");
//            }
//            return str;
//        }
    }

    // unit testing (optional)
    public static void main(String[] args) {
//        Deque d = new Deque();
//        println(d.size() + " of " + d.a.length);
//        println("firstInd = " + d.firstInd + ", lastInd = " + d.lastInd);
//
//        d.addFirst(1);
//        println(d.iterator().toString());
//
//        d.addFirst(2);
//        println(d.iterator().toString());
//
//        d.removeLast();
//        println(d.iterator().toString());
//
//        d.removeLast();
//        println(d.iterator().toString());
//
//        d.addFirst(3);
//        println(d.iterator().toString());
//
//        d.removeFirst();
//        println(d.iterator().toString());
//
//        d.addFirst(4);
//        println(d.iterator().toString());
//
//        d.addFirst(5);
//        println(d.iterator().toString());
//
//        d.addFirst(6);
//        println(d.iterator().toString());
//
//        d.addFirst(7);
//        println(d.iterator().toString());
//
//        d.removeLast();
//        println(d.iterator().toString());
//
//        d.removeLast();
//        println(d.iterator().toString());
//
//        d.removeLast();
//        println(d.iterator().toString());
//
//        // ************************************************
//        d.addLast(8);
//        println(d.iterator().toString());
//
//        d.addLast(9);
//        println(d.iterator().toString());
//
//        d.addLast(10);
//        println(d.iterator().toString());
//
//        d.removeFirst();
//        println(d.iterator().toString());
//
//        d.removeFirst();
//        println(d.iterator().toString());
//
//        d.removeFirst();
//        println(d.iterator().toString());
//
//        d.removeFirst();
//        println(d.iterator().toString());
//
//
    }
}