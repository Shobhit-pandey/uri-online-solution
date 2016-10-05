import java.io.IOException;
import java.math.*;
import java.util.Scanner;
public class Main {
	public static void fab(int x)
	{
		long n1=0;
		long n2=1;
		long n3=-1;
	if(x==1)
	System.out.print(n1);
	else if(x==2)
	System.out.print(n1+" "+n2);
	else
{
		System.out.print(n1+" "+n2+" ");
		for (int i=0;i<x-3;i++)
		{
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(""+n3+" ");
		}
		n3=n1+n2;
		System.out.print(""+n3);
	}
System.out.print("\n");
}
    public static void main(String[] args) throws IOException {
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
		fab(n);
    }
}