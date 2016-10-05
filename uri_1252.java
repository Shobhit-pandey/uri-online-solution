import java.util.*;
import java.io.*;

public class Main {
	
	static int m;
	//this class is for comparing value after taking mod
	static class Item implements Comparable<Item> 
	{
		int num;
		
		public Item(int num) 
		{
			this.num = num;
		}

		public int compareTo(Item i) 
		{
			//getting mod
			int mod1 = (Math.abs(this.num) % m) * (this.num < 0 ? -1 : 1);
			int mod2 = (Math.abs(i.num) % m) * (i.num < 0 ? -1 : 1);
			//comparing mod and return value 
			if (mod1 != mod2)
				return mod1 - mod2;
			
			int mod21 = Math.abs(this.num) % 2;
			int mod22 = Math.abs(i.num) % 2;
			if (mod21 == 0 && mod22 == 1)
				return 1;
			if (mod21 == 1 && mod22 == 0)
				return -1;
			if (mod21 == 1 && mod22 == 1 && i.num <= this.num)
				return -1;
			if (mod21 == 1 && mod22 == 1 && i.num > this.num)
				return 1;
			if (mod21 == 0 && mod22 == 0 && i.num <= this.num)
				return 1;
			if (mod21 == 0 && mod22 == 0 && i.num > this.num)
				return -1;
			return 1;
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner obj=new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (obj.hasNextInt()&&obj.hasNextInt()) 
		{
			int n=obj.nextInt();
			m=obj.nextInt();
			//adding n and m in string builder 
			sb.append(n + " " + m + "\n");
			if (n == 0 && m == 0)
				break;
			Item[] items = new Item[n];
			//taking input
			for (int i = 0; i < n; ++i) 
			{
				int x = obj.nextInt();
				items[i] = new Item(x);
			}
			//sorting array 
			Arrays.sort(items);
			//adding each num in string builder after new line 
			for (int i = 0; i < n; ++i)
				sb.append(items[i].num + "\n");
		}
		System.out.print(sb);
	}
}