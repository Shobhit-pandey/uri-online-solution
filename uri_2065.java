import java.util.Scanner;
import java.util.Arrays;
public class Main
{
	public static void main(String[] args)
	{
		Scanner obj=new Scanner (System.in);
		int n=obj.nextInt();
		int m=obj.nextInt();
		int[] a=new int[n]; //cashier list
		int[] b=new int[m];  //customer list
		//cashier input
		for(int i=0;i<n;i++)
			a[i]=obj.nextInt();
		// customer input	
		for(int i=0;i<m;i++)
			b[i]=obj.nextInt();
		
		int[] temp=new int[n]; //time taken by each cashier list
		int t=0;
		int time=0;
		while(t<m)  // recording time taken by each cashier
		{
			if(t<n)
			{
				temp[t]=b[t]*a[t];
				//System.out.println(temp[t]);
				t++;
			}
			else
			{
				int index=temp[0];
				int z=0;
				for(int i=0;i<n;i++)
					if(index>temp[i])
					{
						index=temp[i];
						z=i;
					}
				temp[z]+=b[t]*a[z];
				//System.out.println(z);
				z=0;
				t++;	
			}
			
			
		}
		int index=temp[0];
		//calculating maximum time taken by a cashier from time list
		for(int i=0;i<n;i++)
			if(index<temp[i])
				index=temp[i];
		System.out.println(index);			
	}
}