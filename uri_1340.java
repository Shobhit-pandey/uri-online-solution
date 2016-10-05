import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		Queue<Integer> Q; //queue of integer type is used 
 		Stack<Integer> S; //stack of integer type is used
		PriorityQueue<Integer> PQ;  //priority queue of type intrger is used
		boolean isQueue;  //for checking queue
		boolean isStack; // for checking stack
		boolean isPQueue; // for checking priority queue
		
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			Q = new LinkedList<Integer>(); //for queue
			S = new Stack<Integer>();   //for stack
			PQ = new PriorityQueue<Integer>(); // for priority queue
			
			isQueue = true;
			isStack = true;
			isPQueue = true;
			
			while (N-- > 0) {
				String[] parts = in.readLine().split("[ ]+");
				int command = Integer.parseInt(parts[0].trim());
				int value = Integer.parseInt(parts[1].trim());
				//checking for each data structure
				if (command == 1) {
					if (isQueue)
						Q.offer(value);
					if (isStack)
						S.push(value);
					if (isPQueue)
						PQ.offer(-value);
				} else {
					if (isQueue && (Q.isEmpty() || Q.poll() != value))
						isQueue = false;
					if (isStack && (S.isEmpty() || S.pop() != value)) 
						isStack = false;
					if (isPQueue && (PQ.isEmpty() || PQ.poll() != -value))
						isPQueue = false;
				}
			}
			if (isQueue && !isStack && !isPQueue)
				sb.append("queue\n");
			else if (!isQueue && isStack && !isPQueue)
				sb.append("stack\n");
			else if (!isQueue && !isStack && isPQueue)
				sb.append("priority queue\n");
			else if (!isQueue && !isStack && !isPQueue)
				sb.append("impossible\n");
			else 
				sb.append("not sure\n");
		}
		System.out.print(sb.toString());
		
		in.close();
		System.exit(0);
	}
}