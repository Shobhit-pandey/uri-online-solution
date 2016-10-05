import java.util.Scanner;
import java.math.BigInteger;
public class Main
{
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		int testcase=obj.nextInt();
		String s=obj.nextLine();
		for (int i=0;i<testcase;i++)
		{
			//String n=obj.nextLine();
			//biginteger is used
			BigInteger n=new BigInteger(obj.nextLine(),2);
			BigInteger tes=new BigInteger("1500");
			n=n.mod(tes); // taking mod with 1500 to get smaller no. of same last 3 digit no.
			System.out.println(fab(n));
		}
	}
	//for fabonacci no.
	public static String fab(BigInteger n)
	{
		BigInteger n1=new BigInteger("1");
		BigInteger y=n1;
		BigInteger x2=new BigInteger("2");
		BigInteger x3=new BigInteger("0");
		String q="001";
		int res=n.compareTo(n1);
		int res1=n.compareTo(x2);
		if(res==0||res1==0)
		{
			return q;
		}
		else
		{
			BigInteger i=new BigInteger("1");
			BigInteger[][] a=new BigInteger[2][2];
				BigInteger[][] b=new BigInteger[2][2];
				BigInteger[][] c=new BigInteger[2][2];
				a[0][0]=a[0][1]=a[1][0]=n1;
				a[1][1]=x3;
				b[0][0]=b[0][1]=b[1][0]=n1;
				b[1][1]=x3;
				//getting fanonnai no. by matrix multiplication method
			while(i.compareTo(n)==-1)
			{
				try
				{
				c[0][0]=(a[0][0].multiply(b[0][0])).add(a[0][1].multiply(b[1][0]));
				c[0][1]=(a[0][0].multiply(b[0][1])).add(a[0][1].multiply(b[1][1]));
				c[1][0]=(a[1][0].multiply(b[0][0])).add(a[1][1].multiply(b[1][0]));
				c[1][1]=(a[1][0].multiply(b[0][1])).add(a[1][1].multiply(b[1][1]));
				b[0][0]=c[0][0];
				b[1][0]=c[1][0];
				b[0][1]=c[0][1];
				b[1][1]=c[1][1];
				i=i.add(y);
				}
				catch(Exception yuew)
				{
					
				}
			}
			BigInteger n3=(b[0][1]);
			BigInteger ten=new BigInteger("10");
			BigInteger hundrend=new BigInteger("100");
			BigInteger thousand=new BigInteger("1000");
			n3=n3.mod(thousand);
			if(n3.compareTo(ten)==-1)
			{
				String ad="00";
				String w=n3.toString();
				return (ad+w);
			}
			else if(n3.compareTo(hundrend)==-1)
			{
				String ad="0";
				String w=n3.toString();
				return (ad+w);
			}
			else
			{
				n3=n3.mod(thousand);
				String we=n3.toString();
				return we;
			}
		}
	}
}