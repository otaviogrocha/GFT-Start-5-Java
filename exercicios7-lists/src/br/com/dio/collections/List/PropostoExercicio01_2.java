package src.br.com.dio.collections.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PropostoExercicio01_2 {
    public static void main(String[] args) {
        
        //Ler informações do usuário:
        Scanner scan = new Scanner(System.in);
        List<Double> temperatura = new ArrayList<>() ;

        //Adicionar as temperaturas:\
        double soma = 0d;
        for (int i = 1; i <= 6; i++) {
            System.out.println("Digite a temperatura do mês " + i + ": ");
            Double temp = scan.nextDouble();
            temperatura.add(temp);
            soma+=temp;
        }
        System.out.println("-------------------------------");
        System.out.println("\nTodas as temperaturas: ");
        System.out.println(temperatura);

        //Fazer a média das temperaturas:
        
        double media = soma/temperatura.size();
        System.out.printf("\nMédia Temperatura Semestral: %.1f\n", media);
        System.out.println("----------------------");

        //Mostrar por extenso os meses:

        System.out.println("\nMeses das temperaturas acima da média: ");
        for (Double temp : temperatura) {
            if(temp > media){
                int index = temperatura.indexOf(temp);
                switch(index){
                    case 0:
                        System.out.println((index + 1)+ " - JANEIRO: "+ temp + "°C");
                        break;
                    case 1:
                        System.out.println((index + 1)+ " - FEVEREIRO: "+ temp + "°C");
                        break;
                    case 2:
                        System.out.println((index + 1)+ " - MARÇO: "+ temp + "°C");
                        break;
                    case 3:
                        System.out.println((index + 1)+ " - ABRIL: "+ temp + "°C");
                        break;
                    case 4:
                        System.out.println((index + 1)+ " - MAIO: "+ temp + "°C");
                        break;
                    case 5:
                        System.out.println((index + 1)+ " - JUNHO: "+ temp + "°C");
                        break;
                    default:
                        break;
                }
            }
            
        }
        scan.close();
    }
}
