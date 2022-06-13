package src.br.com.dio.collections.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PropostoExercicio01_1 {
    /* Faça um programa que receba a temperatura média dos 6 primeiros meses
    do ano e armazene-as em uma lista.
    Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média, e em que mês elas ocorreram(mostrar o mês por extenso: 1 - Janeiro, 2 - Fevereiro e etc.)
    */
    public static void main(String[] args) {
        //Receber as temperaturas
        Scanner scan = new Scanner(System.in);
        List <Double> temperaturas = new ArrayList<>();

        //Adicionar temperaturas na lista
        int count = 0;
        while(true){
            if (count ==6) break;

            System.out.print("Digite a temperatura: ");
            Double temp = scan.nextDouble();
            temperaturas.add(temp);
            count+=1;
        }
        System.out.println("---------------");
        System.out.print("Todas as Temperaturas: ");
        temperaturas.forEach(t -> System.out.print(t + " "));

        //Fazer média das temperaturas 
        Double media = temperaturas.stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0);
        System.out.printf("\nMédia das temperaturas: %.1f\n", media);

        //Mostras temperaturas acima da média e seu respectivo mês
        System.out.print("\nTemperaturas acima da média: ");
        temperaturas.stream()
            .filter(t -> t > media)
            .forEach(t -> System.out.printf("%.1f ", t) );
        //Exibir o mês das temperaturas acima da média por extenso:
        System.out.println("\nMeses das temperaturas acima da média: ");
        Iterator<Double> iterator = temperaturas.iterator();

        count = 0;
        while(iterator.hasNext()){
            Double temp = iterator.next();
            if(temp > media){
                switch(count){
                    case(0):
                        System.out.printf("1 - janeiro: %.1f\n", temp);
                        break;
                    case(1):
                        System.out.printf("2 - fevereiro: %.1f\n", temp);
                        break;
                    case(2):
                        System.out.printf("3 - março: %.1f\n", temp);
                        break;
                    case(3):
                        System.out.printf("4 - abril: %.1f\n", temp);
                        break;
                    case(4):
                        System.out.printf("5 - maio: %.1f\n", temp);
                        break;
                    case(5):
                        System.out.printf("6 - junho: %.1f\n", temp);
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da média.");
                }
            }
            count+=1;
        }
        scan.close();
    }
}
