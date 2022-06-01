import java.util.Scanner;

public class fatorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Fatorial de: ");
        int fatorial = scan.nextInt();
        int mult = 1;
        
        for ( int i = fatorial; i >= 1; i -=1) {
            mult *= i;
        }
        System.out.println(fatorial + "! = "+ " = "+mult);
        
        scan.close();
    }
}
