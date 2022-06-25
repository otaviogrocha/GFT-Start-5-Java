package br.com.dio.collection.map;
import java.util.*;

public class PropostoExercicio01 {
    public static void main(String[] args) {
        /*
         * Dada a população estimada de alguns estados do nordeste brasileiro, faça:
         * Estado = PE - população = 9.616.621
         * Estado = AL - população = 3.351.543
         * Estado = CE - população = 9.187.103
         * Estado = RN - população = 3.534.265
         */
        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> popNordeste = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
         
        System.out.println(popNordeste);

        System.out.println("\nSubstitua a população do Estado RN por : 3.534.165");
        popNordeste.put("RN", 3534165);
        System.out.println(popNordeste);

        System.out.println("\nConfira se o  estado da Paraíba (PB) está no dicionário, caso não, adicione " + "PB - 4.039.277");
        popNordeste.put("PB", 4039277);
        System.out.println(popNordeste);
        
        System.out.println("\nExiba a população do estado PE: " + popNordeste.get("PE"));

        System.out.println("\nExiba todos os estados e suas populações na ordem em que foram informados: ");
        Map<String, Integer> popNordeste1 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};

        System.out.println(popNordeste1);

        System.out.println("\nExiba todos os estados e suas populações na ordem alfabética: ");
        Map<String, Integer> popNordeste3 = new TreeMap<>(popNordeste);
        System.out.println(popNordeste3);

        System.out.println("\n\t========================================\t");

        Collection<Integer> populacao = popNordeste.values();
        String estadoMaiorPop = "";
        String estadoMenorPop = "";
        for (Map.Entry<String,Integer> entry : popNordeste.entrySet()) {
            if(entry.getValue().equals(Collections.max(populacao))) estadoMaiorPop = entry.getKey();
            if(entry.getValue().equals(Collections.min(populacao))) estadoMenorPop = entry.getKey();
        }
        System.out.printf("\nExiba o estado com a Menor população: (%s) e seus respectivo valor: (%d)\n", estadoMenorPop, Collections.min(populacao));
        System.out.printf("Exiba o estado com a Maior população: (%s) e seus respectivo valor: (%d)\n", estadoMaiorPop, Collections.max(populacao));

        int soma = 0;
        Iterator<Integer> iterator = popNordeste.values().iterator();
        
        while(iterator.hasNext()){
            soma+= iterator.next();
        }

        System.out.println("\nExiba a soma da população desses estados: " + soma);
        /*
         * OU:
         *
        int soma2 = 0;
        for(Map.Entry<String, Integer> entry : populaçãoEstadosNE.entrySet()) {
           soma2 += entry.getValue();
        }
         */

        System.out.println("\nExiba a média da população deste dicionário de estados: " + (soma/popNordeste.size()));
        System.out.println("\nRemova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator1 = popNordeste.values()
        .iterator();
        
        while (iterator1.hasNext()) {
            if(iterator1.next() <= 4000000) iterator1.remove();
        }
        System.out.println(popNordeste);

        System.out.println("\nApague o dicionário de estados com suas respectivas populações estimadas: ");
        popNordeste.clear();
        System.out.println(popNordeste);

        System.out.println("Confira se a lista está vazia: " + popNordeste.isEmpty());
    }

}
