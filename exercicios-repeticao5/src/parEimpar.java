import java.util.Scanner;

public class  parEimpar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numero;
        int contador = 0;
        int qtdeNum;
        int qtdePar = 0, qtdeImpar =0;

        System.out.println("Quantidade de números: ");
        qtdeNum = scan.nextInt();

        do {
            System.out.println("Número: ");
            numero = scan.nextInt();

            if(numero %2 ==0){ System.out.println("É par!");
            qtdePar += 1;
            }
            else{System.out.println("É ímpar!");
            qtdeImpar +=1;
            }
            contador += 1;
        } while (contador < qtdeNum);

        System.out.println("Quantidade de pares: "+ qtdePar);
        System.out.println("Quantidade de ímpares: "+ qtdeImpar);
        scan.close();
    }
}
