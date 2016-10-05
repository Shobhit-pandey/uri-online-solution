import java.util.*;
public class Main 
{
    public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		int testcase=obj.nextInt();
		for (int k=1;k<testcase+1;k++)
		{
			int n = obj.nextInt();
			int m = obj.nextInt();
			Queue<Integer> queue = new LinkedList<Integer>(); //queue of integer type used
			for (int i = 1; i <= n; i++)
				queue.add(i); //adding value to queue
			int a=0;
			while (!queue.isEmpty())  // removing particular element untill queue become empty
			{
				for (int i = 0; i < m-1; i++)
					queue.add(queue.remove());
				a=queue.remove();
			} 
        System.out.println("Case "+k+": "+a);
		}
	}
}

