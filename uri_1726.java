import java.util.Scanner;

class Node1
{
	int data;
	Node1 next;
}
//creating stack 
class Stack
{	
	public static Node1 push(Node1 original,int dat)
	{
		Node1 extra=new Node1();
		extra.data=dat;
		extra.next=original;
		return extra;
	}
	
	public static Node1 pop(Node1 original)
	{
		if(original!=null)
			original=original.next;
		return original;
	}
}
//creating node
class Node
{
	String oparents=null;
	String operation=null;
	Node next;
	public Node(String s)
		{
			oparents=s;
		}
		public Node(String s,String t)
		{
			oparents=s;
			operation=t;
		}
}
class Main
{
	
	public static Node StringtoNode(String original)
	{
		char c;
		int i=0;
		Node origin=null;
		Node present=null;
		while(i<original.length())
			{
				c=original.charAt(i);
				if(c=='(')
				{
					i++;
					String sub=null;
					int t=1;
					while(t>=1)
					{
						c=original.charAt(i);
						String s=Character.toString(c);
						if(c=='(')
						{
							t=t+1;	
							if(sub==null)
							{
								sub=s;
							}
							else
							{
								sub=sub+s;
							}
						}
						else if(c==')')
						{
							t=t-1;
							if(t==0)
							{ 
						        i++;
								break;
							}
							else
							{
								if(sub==null)
								{
									sub=s;
								}
								else
								{
									sub=sub+s;
								}
							}
						}
						else
						{
							if(sub==null)
							{
								sub=s;
							}
							else
							{
								sub=sub+s;
							}
						}
						i++;
					}
					origin=StringtoNode(sub);
					if(i<original.length())
						{
							origin.operation=Character.toString(original.charAt(i));
							i++;
						}
				}
				else if(c=='{')
				{
					i++;
					c=original.charAt(i);
					String curr=null;
					while(c!='}')
					{
						if(curr==null)
						{
							String s=Character.toString(c);
							curr=s;
						}
						else
						{
							String s=Character.toString(c);
							curr=curr+s;
						}
						i++;
						c=original.charAt(i);
					}
					i++;
					if(i<original.length())
					{
						String s=Character.toString(original.charAt(i));
						origin=new Node(curr,s);
						i++;
					}
					else
						origin=new Node(curr); 
				}
				else
				{
					if(i<original.length())
					{
						System.out.println("Not a perfect notation");
						System.exit(0);
					}
				}
				present=addNode(present,origin);	
			}
			present=simplify(present);
			return present;
	}
	public static Node addNode(Node original,Node curr)
	{
		Node dup=original;
		if(dup==null)
			{
				return curr;
			}
		else
			{
				while(dup.next!=null)
				{
					dup=dup.next;
				}
				
				dup.next=curr;
				return original;
			}
		
	}
	public static Node simplify(Node curr)
	{
		while(curr.next!=null)
		{
			Node next=curr.next;
			if(next.operation!=null)
				{
					if((curr.operation).equals(next.operation))
					{
						curr=operate(curr);
					}
					else if((next.operation).equals("*"))
					{
						curr.next=operate(next);
					}
					else
					{
						curr=operate(curr);
					}
				}
			else
					curr=operate(curr);
		}
		return curr;			
	}
	public static Node operate(Node curr)
	{
		if((curr.operation).equals("+"))
		{
			curr=add(curr);
		}
		else if((curr.operation).equals("-"))
		{
			curr=minus(curr);
		}
		else if((curr.operation).equals("*"))
		{
			curr=product(curr);
		}
		return curr;
	}
	public static Node add(Node curr)
	{
		Node next=curr.next;
		String s1=curr.oparents;
		String s2=next.oparents;
		String s3=s1;
		if(s1==null)
			{
				curr=next;
			}
		else if(s2==null)
			{
				next.oparents=s1;
				curr=next;
			}
		else
			{
				for(int i=0;i<s2.length();i++)
				{
					char c1=s2.charAt(i);
					int t=0;
					for(int j=0;j<s1.length();j++)
					{
						char c2=s1.charAt(j);			
						if(c1==c2)
						{
							t=0;
							break;
						}
						else
						t=t+1;
					}
					if(t==s1.length())
					{
						String s=Character.toString(c1);
						s3=s3+c1;
					}
				}
				next.oparents=s3;
				curr=next;
				
			}
			return curr;
	}
	public static Node minus(Node curr)
	{
		Node next=curr.next;
		String s1=curr.oparents;
		String s2=next.oparents;
		String s3=null;
		if(s1==null)
		{
			next.oparents=null;
			curr=next;
		}
		else if(s2==null)
		{
			next.oparents=s1;
			curr=next;
		}
		else
		{	
			for(int i=0;i<s1.length();i++)
			{
				char c1=s1.charAt(i);
				int t=0;
				for(int j=0;j<s2.length();j++)
				{
					char c2=s2.charAt(j);
					if(c1==c2)
					{
						t=0;
						break;
					}
					else
						t=t+1;	
				}
				if(t==s2.length())
				{
					String s=Character.toString(c1);	
					if(s3==null)
						s3=s;
					else
						s3=s3+s;
				}
			}
				
				next.oparents=s3;
				curr=next;
		}
			
		return curr;
	}
	
	public static Node product(Node curr)
	{
		Node next=curr.next;
		String s1=curr.oparents;
		String s2=next.oparents;
		String s3=null;
		if(s1==null)
		{
			next.oparents=null;
			curr=next;
		}
		else if(s2==null)
			curr=next;
		else
		{
			for(int i=0;i<s1.length();i++)
			{
				char c1=s1.charAt(i);
				int t=0;
				for(int j=0;j<s2.length();j++)
				{
					char c2=s2.charAt(j);					
					if(c1==c2)
					{
						t=1;
						break;
					}
				}	
				if(t==1)
				{
					String s=Character.toString(c1);	
					if(s3==null)
					{
						s3=s;
					}
					else
					{
						s3=s3+s;
					}
				}
			}
				
				next.oparents=s3;
				curr=next;
		}			
		return curr;
	}
	
	public static boolean check(String equ) //for checking eq is right or not
	{
		//stack is used
		Stack stack=new Stack();
		Node1 First=new Node1();
		First=null;
		int length=equ.length();
		char[] a=equ.toCharArray();//converting to array
		int i,o=0,c=0;
		if(a[0]!='{' && a[0]!='(')
		{
			return false;
		}
		for(i=0;i<length;i++)
		{
			if(a[i]=='{' ||  a[i]=='(')
			{
				First=stack.push(First,i);
				o++;
			}
			else if(a[i]=='}' || a[i]==')')
			{
				c++;
				Node1 clone=First;
				while(clone!=null)
				{
					if((a[i]=='}'&& a[clone.data]=='{') || (a[i]==']' && a[clone.data]=='[') || (a[i]==')'&&a[clone.data]=='('))
					{
					First=stack.pop(First);
					}
					clone=clone.next;
				}
			}
			else
			{
				if(a[i]!='+' && a[i]!='-' && a[i]!='*')
				{
					if((int)a[i]<65 || (int)a[i]>90)
					{
						return false;
					}
				}
			}
		}
		if(First==null && c==o)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static String sort(String curr)
	{
		
		char a[]=curr.toCharArray();			
        int i1, i, j, increment,number_of_elements = a.length;
		char temp;
        for (increment = number_of_elements / 2; increment > 0; increment /= 2)
	    {
			for (i = increment; i < number_of_elements; i++)
            {
            	temp = a[i];    			
				for (j = i; j >= increment; j -= increment) 
                {           
					if ((int)temp < (int)a[j - increment]) 
					{
                      	a[j] = a[j - increment];
					}
					else 
					{
						break;
                    }
              	}
                a[j] = temp;
			}
		}
		String s=new String(a);
		return s;
	}
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		boolean t=true;
		String o="{";
		String c="}";
		String res;
		do
		{
		    String source=null;
		    try
		    {
			//taking input
		    source=scan.nextLine();
		    }catch(Exception e)
		    {
		        System.exit(0);
		    }
			//check for right expression
			t=check(source);
			// if right expression then move forward
			if(t)
			{
				Node orig=StringtoNode(source); //converting string to node
				if(orig.oparents!=null)
				{
					res=sort(orig.oparents);
					res=o+res+c;
				}
				else
				{
					res=o+c;
				}
				System.out.println(res);
			}
			
		}while(t==true);
	}

}