import java.io.IOException;
import java.math.*;
import java.util.Scanner;
public class Main {
	public static void fab(int x)
	{
		long n1=0;
		long n2=1;
		long n3=-1;
		if(x==0)
			System.out.print("Fib(0) = 0");
		else if(x==1)
			System.out.print("Fib(1) = 1");
		else
		{
			for (int i=0;i<x-2;i++)
			{
				n3=n1+n2;
				n1=n2;
				n2=n3;
			}
			n3=n1+n2;
			System.out.print("Fib("+x+") = "+n3);
		}
		System.out.print("\n");
	}
	public static void main(String[] args) throws IOException 
	{
		Scanner obj=new Scanner(System.in);
		int t=obj.nextInt();
		for (int i=0;i<t;i++)
		{
			int n=obj.nextInt();
			//for getting fabonacci no.
			fab(n);
		}
	}
}