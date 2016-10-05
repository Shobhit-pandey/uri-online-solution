import java.util.Scanner;
public class Main
{
	public static int swap=0;
	public static void main(String[] args)
	{	
		Scanner obj=new Scanner(System.in);
		int testcase=obj.nextInt();
		for (int i=0;i<testcase;i++)
		{
			int n=obj.nextInt();
			int[] arr=new int[n];
			//taking input
			for(int j=0;j<n;j++)
			{
				arr[j]=obj.nextInt();

			}
			//bubble sort is used
			bubblesort(arr);
		}
	}
	public static void bubblesort(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for (int j=i+1;j<arr.length;j++)
			{
				if (arr[i]>arr[j])
				{
					swap++;
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;	
				}
			}
		}
		System.out.println("Optimal train swapping takes "+swap+" swaps.");
		swap=0;
	}
}