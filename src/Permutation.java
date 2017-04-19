import edu.princeton.cs.algs4.StdIn;
import static edu.princeton.cs.algs4.StdOut.println;

public class Permutation {
	public static void main(String[] args){
	   int k = Integer.parseInt(args[0]);
	   RandomizedQueue rq = new RandomizedQueue();
	   //StdIn.readString();
	   while (StdIn.hasNextLine()){
		   rq.enqueue(StdIn.readString());
	   }
	   for (int i = 1; i <= k; i++){
		   println(rq.dequeue());
	   }
   }
}