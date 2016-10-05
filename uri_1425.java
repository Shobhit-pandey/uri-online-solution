import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner obj =new Scanner(System.in);
		while(obj.hasNextInt())
		{
			int n=obj.nextInt(); //no. of rocks
			int m=obj.nextInt(); // no. on which gift is kept
			if(n==0 && m==0)
				break;
			int i=2;	
			int a=1;
			int d=0;
			//if rock on which gift is kept is larger than 34 then frog is always able to catch that rock 
			if(m>34)
			{
				System.out.println("Let me try!");
			}
			//otherwise we have to calculate
			else
			{
			while(a>0 && a<n+1)
			{
				if(a==m) // if we get that rock on  which gift is kept
				{
					d++;
					break;
				}
				// if we r lagging that rock  then we have to move forward by this eq until either we get that rock or no possible move is there
				else if(a<m)
				{
					if(a+(2*i-1)<n+1)
					a+=2*i-1;
					else
					a-=2*i-1;
					i++;
				}
				// if we r leading that rock on which gift is kept we have to move backward until either we got that rock or no another move is possible
				else
				{
					if(a-(2*i-1)>0)
					a-=2*i-1;
					else
					a+=2*i-1;
					i++;
				}
			}
			//if we reaced that rock on which gift is kept then print let me try else print dont make fun of me
			
			if(d!=0)
			System.out.println("Let me try!");
			else
			System.out.println("Don't make fun of me!");
			}
		}
	}
}