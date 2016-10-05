import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		int testcase=obj.nextInt(); //no. of testcases
		String s=obj.nextLine();
		int v=0;
		for (int o=0;o<testcase;o++)
		{
			s=obj.nextLine();
			if (v!=0)
			s=obj.nextLine();
			int n=obj.nextInt();
			char[] a=new char[s.length()];
			// changing input to desired output
			for (int i=0;i<s.length();i++)
			{
				int z=((int)s.charAt(i)-n);
				if(z<65)
				{
					z=z+26	;
				}
				a[i]=(char)z;
				System.out.print(a[i]);	
			}
			System.out.print("\n");
			v++;
		}
	}
}