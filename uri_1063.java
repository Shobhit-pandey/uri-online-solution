import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		while(obj.hasNextInt())
		{
			Stack<Character> st=new Stack<Character>(); //definig stack of char type
			int n=obj.nextInt();
			if (n==0)
				break;
			ArrayList<Character> in =new ArrayList<Character>(); //definig arraylist of incoming train
			ArrayList<Character> out =new ArrayList<Character>(); //definig arraylist of outcoming train
			for(int i=0;i<n;i++) //adding input of incoming
			{
				in.add(obj.next().charAt(0));
			}
			for(int i=0;i<n;i++) //adding input of outgoing
			{
				out.add(obj.next().charAt(0));
			}
		int tmp = 0;
		 //stack is used
		for(int i=0;i<n;i++)
		{
		
			st.push(in.get(i)); //push value of incoming into stack
			System.out.print("I");

			while (st.size() > 0 && out.get(tmp) == st.peek())
			{
				tmp++;
				st.pop();
				System.out.print("R");
			}
		}
		//after poping if size is not equal to zero then outgoing is notpossible series
		if (st.size() != 0)
			System.out.print(" Impossible");
			System.out.println();
		}
	}
}