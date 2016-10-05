import java.util.*;

 class Main
 {
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
		//String s=obj.nextLine();
		int k=0;
		while(obj.hasNextLine())
		{
			String s=obj.nextLine(); //taking string input
		String[] st=s.split(" ");  // spliting that string into two string preorder and inorder
		int g=st[0].length(); 
         int pre[] = new int[g]; //preorder
         int in[] = new int[g]; //inorder
         for(int i=0;i<g;i++) //taking input from spliited string to array of preoder and inorder
         {
         	pre[i]=(int)st[0].charAt(i);
         	in[i]=(int)st[1].charAt(i);
         }
         int n = in.length;
         if(in.length==0)
         	break;
			//printing postoder
         printPostOrder(in,pre,n);
         System.out.println();
         k++;
     }
    }
    //method for search an item from preoder in inoder
    public static int search(int arr[], int x, int n)
    {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
            return i;
        return -1;
    }
    
    public static void printPostOrder(int in[], int pre[], int n)
    { 
		//searching of root from preorder to inorder
       int root = search(in, pre[0], n);
        
        int tempPre[] , tempIn[]; 
        
        if (root != 0){
            tempPre = Arrays.copyOfRange(pre, 1,pre.length); //copying array from index 1 to length of preoder in temporary preorder
            printPostOrder(in, tempPre, root); //recursive call
        }
        if (root != n-1)
        {   tempPre = Arrays.copyOfRange(pre,root+1,pre.length); //copying array from root+1 to length of preorder in temporary preorder
            tempIn =  Arrays.copyOfRange(in,root+1,in.length);  //copying array from root+1 to length of inoder in temporary inoder
            printPostOrder(tempIn, tempPre,n-root-1); //recursive call
        }
        System.out.print((char)pre[0]);
    }
    
    
    
}