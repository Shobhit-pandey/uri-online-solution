import java.util.Scanner;
import java.util.Stack;

	
	public class Main
	{

	static Stack<Character> st = new Stack<Character>(); //defining stack of char type
		
	public static void main(String argv[]) 
	{
		String infix;
		Scanner obj=new Scanner(System.in);
		int k=1;
		while(obj.hasNext())
		{
		try
		{
		
		infix = obj.nextLine(); //taking input
		System.out.println(toPostfix(infix)); //printing output
		}
		
		catch(Exception jsd)
		{
		}
		}
	}
	
	private static String toPostfix(String infix)
	{
		char symbol;
		String postfix = "";
		int d=0;
		int f=0;
			//checking for parenthesis
			for(int i=0;i<infix.length();i++)
			{	
				if(prec(infix.charAt(i))==0)
				{
					d++;
					break;
				}
				if(infix.charAt(i)=='(')
					f++;
				else if(infix.charAt(i)==')')
					f--;
			}	
				//traversing each character of input for checking which type of character is...
			for(int i=1;i<infix.length();i++)
			{	
				int previous=prec(infix.charAt(i-1));
				int present=prec(infix.charAt(i));
				if((previous>=1&&previous<=6)&&(present>=1&&present<=6))
				{
					f++;
					break;
				}	
				if(previous==10&&present==10)
				{
					f++;
					break;
				}
			}
			//checking for lexical error and syntax error
			if(d!=0)
			{
				postfix="Lexical Error!";
			}
			else if(f!=0)
			{
					postfix="Syntax Error!";
			}
			//if all right then convert to postfix using stack...
			else if(f==0&&d==0)
			{
                for(int i=0;i<infix.length();++i)
					{
					symbol = infix.charAt(i);
					if (Character.isLetter(symbol))
						postfix = postfix + symbol;
					else if (symbol=='(')
					{
				
						st.push(symbol); //pushing element into stack
					}
					else if (symbol==')')
					{
						while (st.peek() != '(')
						{
							postfix = postfix + st.pop();
						}
						st.pop();		
					}
					else
					{
                        while (!st.isEmpty() && !(st.peek()=='(') && prec(symbol) <= prec(st.peek()))
							postfix = postfix + st.pop();
					st.push(symbol);
					}
				}
				while (!st.isEmpty())
					postfix = postfix + st.pop();
			}
		return postfix;
	}
	
	
	static int prec(char x)
	{
		if (x == '|')
			return 1;
		if (x == '.')
			return 2;
		if (x == '>' || x == '<'||x == '=' || x == '#')
			return 3;
		if (x == '+' || x == '-')
			return 4;
		if (x == '*' || x == '/')
			return 5;
		if (x == '^')
			return 6;
		if (x == '('||x==')')
			return 7;
		if(((int)x>=48 &&(int)x<=57)||((int)x>=65 &&(int)x<=90)||((int)x>=97&&(int)x<=122))
			return 10;
		return 0;
	}
}