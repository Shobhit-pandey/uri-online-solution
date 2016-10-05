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
while (obj.hasNextInt()	)
{
    int n=obj.nextInt();
	if (n==0)
	{
		break;
	}
	int k=n;
	int i=1;
	long ans=0;
	int m=1;
	while(k>9)
	{
		 m=k%10;
		ans+=m*fac(i);
		i++;
		k=k/10;
	}
	m=k;
	ans+=m*fac(i);
	System.out.println(ans);
    }
}
}