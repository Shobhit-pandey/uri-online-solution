import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		int k=1;
		int largest_char=0;
		String largest="";
		int first=0,finall=0;
		while(k!=0)
		{
			int count=0;
			String input=obj.nextLine();
			if(input.charAt(0)=='0')
			{
				//for finding largest character		
				//System.out.println("finall="+largest+"  "+finall);
				for(int i=finall;i>=0;i--)
				{
					if (largest.charAt(i)==' ')
					{
						first=i+1;
						break;
					}

				}
				
				System.out.print("\nThe biggest word: ");
				for(int i=first;i<=finall;i++)
					System.out.print(largest.charAt(i));
				System.out.print("\n");
				break;
			}
			//for finding length of each words
			for(int i=0;i<input.length();i++)
			{
				if(i==input.length()-1)
				{
					count++;
					System.out.print(count+"\n");
					if(largest_char<=count)
					{
						largest_char=count;
						largest=input;
						finall=i;
					}
					count=0;
				}
				else if (input.charAt(i)==' ')
				{	
					System.out.print(count+"-");
					if(largest_char<=count)
					{
						largest_char=count;
						largest=input;
						finall=i;
					}
					count=0;
				}		
				else
					count++;
			}
		}

	}
}