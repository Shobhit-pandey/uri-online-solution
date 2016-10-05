import java.util.Scanner;
public class Main
{
public static void main(String[] args)
{
	Scanner obj=new Scanner(System.in);
	int testcase=obj.nextInt();
	String s=obj.nextLine(); //taking input
	for (int o=0;o<testcase;o++)
	{
		s=obj.nextLine(); 
		int k=0;
		while(k<s.length())
		{
		//escaping space  of string in starting
		while( k<s.length()&&s.charAt(k)==' ')
		{
			k++;
		}
		if(k<s.length())
		System.out.print(s.charAt(k)); //printing first letter of each word
		// escaping other letter of string after space
		while(k<s.length()&&s.charAt(k)!=' ')
		{
			k++;
		}
		}
		System.out.print("\n");
	}
}
}