import java.util.*;
public class Main
{
    static long calls=0;
    
    public static long fib(int n)
    {
        calls++;
        if(n==0)
        return 0L;
        else if(n==1)
        return 1L;
        else
        return (long)(fib(n-1) + fib(n-2));
    }
    
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int num;
        int n=scan.nextInt();
        int count=1;
        int i=1;
        long sum;
        while(i<=n)
        {
            num=scan.nextInt();
            sum=(long)(fib(num-1)+fib(num-2));
            System.out.println("fib("+num+") = "+calls+" calls = "+(long)sum);
            calls=0L;
            i++;
        }
    }
    
}