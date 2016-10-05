import java.util.*;
public class Main
{

	private static ArrayList<Integer> input = new ArrayList<Integer>(); //arraylist of input
	private static int counter = 0;

	private static ArrayList<Integer> merge(ArrayList<Integer> temp1, ArrayList<Integer> temp2)
	{
		int i = 0;
		int j = 0;
		int size1 = temp1.size();
		int size2 = temp2.size();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		//sorting two arraylist and adding into one arraylist with counter increament
		while (i < size1 && j < size2)
		{
			if (temp1.get(i) < temp2.get(j))
			{
				temp.add(temp1.get(i));
				i++;
			}
			else
			{
				temp.add(temp2.get(j));
				counter += (int)(temp1.size()) - i;
				j++;
			}
		}

		while (i < size1)
		{
			temp.add(temp1.get(i));
			i++;
		}

		while (j < size2)
		{
			temp.add(temp2.get(j));
			j++;
		}

		return temp;
	}

	private static ArrayList<Integer> mergeSort(int left, int right)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int middle = (left + right) / 2;

		if (left + 1 >= right)
		{
			temp.add(input.get(left));
			return temp;
		}
		//breaking arraylist into equals part
		ArrayList<Integer> temp1 = mergeSort(left, middle);
		ArrayList<Integer> temp2 = mergeSort(middle, right);
		//sorting arraylist
		temp= new ArrayList<Integer>(merge(new ArrayList(temp1), new ArrayList(temp2)));
	
		return temp;
	}

	public static void main(String[] args)
	{
		int n;
		int x=0;
		Scanner obj=new Scanner(System.in);
		while (obj.hasNextInt()) //till we get 0
		{
			n=obj.nextInt(); //size of arraylist
			if (n==0)
				break;
			counter = 0;
			input.clear();

			for (int i = 0; i < (n); ++i)
			{
			
				input.add(obj.nextInt());
			
			}
			//merge sort is used with counter increament
			mergeSort(0, n);
	
			if (counter % 2 != 0)
			{
				System.out.println("Marcelo");
			}
			else
			{
				System.out.println("Carlos");
			}
		}

	}
}
