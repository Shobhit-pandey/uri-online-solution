import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		int t=obj.nextInt();
		for(int l=0;l<t;l++)
		{
			int m=obj.nextInt();
			int n=obj.nextInt();
			Hashtable<Integer,int[]> ht=new Hashtable<Integer,int[]>();  //defining hashtable of key value is integer type and value in array type
			int[][] a=new int[m][n];
			for(int i=0;i<n;i++) //storing each no. in definite row of row no equal to mod of that with given another no.
			{
				int b=obj.nextInt();
				a[b%m][i]=b;
			}
			//putting each row of 2D array in hashtable having key value mod value
			for(int i=0;i<m;i++)
			{
				ht.put(i,a[i]);
			}
			//printing that hashtable
			for(int i=0;i<m;i++)
			{
				System.out.print(i+" -> ");
				for(int j=0;j<n;j++)
					if(a[i][j]!=0)
				System.out.print((ht.get(i))[j]+" -> ");
				System.out.println("\\");
			}
			if(l<t-1)
			System.out.println();
		}
	}
	
}
