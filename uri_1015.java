import java.io.IOException;
import java.math.*;
import java.util.Scanner;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner obj=new Scanner(System.in);
        double x1=obj.nextDouble();
        double y1=obj.nextDouble();
        double x2=obj.nextDouble();
        double y2=obj.nextDouble();
        double ans=((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)); 
        ans=Math.sqrt(ans); //taking square root for desired answer
        System.out.printf("%.4f\n",ans);
    }
}