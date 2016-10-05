import java.io.IOException;
import java.math.*;
import java.util.Scanner;
public class Main {
	public static long fac(int x)
	{
		long fact=1;
		if( x==0||x==1)
			{
				long g=1;
				return g;
			}
		else
		{	
			while(x>1)
			{
				long y=(long)x;
				fact*=y;
				x-=1;
			}
			return fact;
		}
	
}
    public static void main(String[] args) throws IOException {
        Scanner obj=new Scanner(System.in);
while (obj.hasNextInt())
{
        int n=obj.nextInt();
	int m=obj.nextInt();
	long a1=fac(n);
	long a2=fac(m);
	long a=a1+a2;
	System.out.println(a);
    }
}
}