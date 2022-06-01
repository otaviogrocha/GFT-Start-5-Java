import java.util.Scanner;

public class maiorEMedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numero;
        int media = 0;
        int maior = 0;
        int contador = 0;

        do {
            System.out.println("Número: ");
            numero = scan.nextInt();
            
            if(numero > maior) maior = numero;

            contador +=1;
            media  +=numero / contador;
        } while (contador < 5);
        System.out.println("Maior: "+ maior);
        System.out.println("Média: "+ media);
        scan.close();
    }
}
