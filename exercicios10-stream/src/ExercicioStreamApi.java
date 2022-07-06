package src;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
//import java.util.function.Consumer;
import java.util.stream.Collectors;


public class ExercicioStreamApi {
    public static void main(String[] args)  {
        List<String> numerosAleatorios = Arrays.asList("1", "0" , "4" , "1" , "2" , "3" , "9");
        
        System.out.println("Imprima todos os elementos dessa lista de String: ");
        
            //Metodo 1: Stream.ForEach//
        // numerosAleatorios.stream().forEach(new Consumer<String>() {
        //     @Override
        //     public void accept(String s ){
        //         System.out.println(s);
        //     }
        // });
            //Metodo 2: Lambda//
            // numerosAleatorios.stream().forEach(s -> System.out.println(s));
            //Metodo 3: Reference Method//
            numerosAleatorios.forEach(System.out::println);

            
        System.out.println("\nPegue os 5 primeiros números e coloque dentro de um Set: ");
           // Metodo 1: ForEach & Lambda
        // numerosAleatorios.stream()
        //     .limit(5)
        //     .collect(Collectors.toSet())
        //     .forEach(System.out::println);
           // Metodo 2: Usando a coleção Set.
        Set<String> numerosAletoriosSet = numerosAleatorios.stream()
        .limit(6)
        .collect(Collectors.toSet());
        System.out.println(numerosAletoriosSet);

        System.out.println("\nTransforme esta lista de String em uma lista de números inteiros.");
            
            //Metodo 1: + Compacto
        List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
            .map(Integer::parseInt).collect(Collectors.toList());
       
            //Metodo 2 : Mesma coisa, porem indentado.
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
            System.out.println(numerosAleatoriosInteger);
        
        System.out.println("\nPegue os números pares e maiores que 2 e coloque em uma lista: ");
            //Metodo 1: Print com forEach
        // numerosAleatorios.stream()
        //     .map(Integer::parseInt)
        //     .filter(i -> i % 2 == 0 && i > 2 )
        //     .collect(Collectors.toList())
        //     .forEach(System.out::println);
            //Metodo 2: Print com sysout
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .filter(i -> (i % 2 == 0 && i > 2))
            .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);

        System.out.println("\nMostre a média dos números: ");
        
        numerosAleatorios.stream()
        .mapToInt(Integer::parseInt)
        .average()
        .ifPresent(t -> System.out.printf("%.2f", t));
        System.out.println();
        System.out.println("\nRemova os valores ímpares: ");
           
            //Metodo 1: usando numerosaleatorios 1 
        numerosAleatorios1.removeIf(integer -> integer % 2 != 0);
        // System.out.println(numerosAleatorios1);
            //Metodo 2: usando Integer e parenteses no lambda
        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
        System.out.println(numerosAleatoriosInteger);
        
        //Para resolver:

        System.out.println("\nIgnore os 3 primeiros elementos da lista e imprima o restante: ");
        numerosAleatoriosInteger.stream()
            .skip(3)
            .forEach(System.out::print);

        long countNumerosUnicos = numerosAleatoriosInteger.stream()
            .distinct()
            .count();
        System.out.println("\nRetirando os números repetidos da lista, quantos números ficam?");
        System.out.println(countNumerosUnicos);

        System.out.println("\nMostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
            .mapToInt(Integer::intValue)
            .min()
            .ifPresent(System.out::print);
        System.out.println();

        System.out.println("\nMostre o maior valor da lista: ");
        numerosAleatoriosInteger.stream()
            .mapToInt(Integer::intValue)
            .max()
            .ifPresent(System.out::print);
        System.out.println();

        int somaDosNumerosPares = numerosAleatoriosInteger.stream()
            .filter(i -> (i % 2 == 0))
            .mapToInt(Integer::intValue)
            .sum();
            
        System.out.println("\nPegue apenas os números ímpares e some: " + somaDosNumerosPares);

        System.out.println("\nMostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);

        System.out.println("\nAgrupe os valores ímpares múltiplos de 3 ou de 5:");
        // dica: collect(Collectors.groupingBy(new Function()))
        
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3e5 = numerosAleatoriosInteger.stream()
            .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 ==0)));
        System.out.println(collectNumerosMultiplosDe3e5);
        
       

    }
}
