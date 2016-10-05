import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		int[] a=new int[3];
			int[] b=new int[3];
			//taking input
		for(int i=0;i<3;i++)
		{
			a[i]=obj.nextInt();
			b[i]=a[i];
		}
		// sorting input
		for(int i=0;i<2;i++)
		{
			for(int j=i+1;j<3;j++)
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		//printing desired input...
		for(int i=0;i<7;i++)
		{
			if(i<3)
				System.out.println(a[i]);
			else if (i==3)
				System.out.println("");
			else
				System.out.println(b[i-4]);
		}
	}
}
