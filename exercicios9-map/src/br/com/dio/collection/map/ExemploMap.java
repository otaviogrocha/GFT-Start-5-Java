package br.com.dio.collection.map;
import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        /*
         * Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
         * modelo = gol - consumo = 14,4km/l
         * modelo = uno - consumo = 15,6 km/l
         * modelo = mobi - consumo = 16,1 km/l
         * modelo = hb20 - consumo = 14,5 km/l
         * modelo = kwid - consumo = 15,6 km/l
         */

        // Map carrosPopulares2020 = new HashMap(); //antes do java 5
        // Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk 5) -
        // Diamont Operator(jdk 7)
        // HashMap<String, Double> carrosPopulares = new HashMap<>();
        // Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6,
        // "mobi", 16.1, "hb20", 14.5, "kwid", 15.6)
        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.4);
        }};
        System.out.println(carrosPopulares);

        System.out.println("\nSubstitua o consumo do gol 15,2km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);
        
        System.out.println("\nConfira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson") );
        System.out.println("\nExiba o consumo do uno: " + carrosPopulares.get("uno"));

        //System.out.println("Exiba o terceiro modelo adicionado: ");

        System.out.println("\nExiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String,Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente
                );
            }
        }

        System.out.println("\nExiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";

        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if(entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma+= iterator.next();
        }
        System.out.printf("\nExiba a soma dos consumos: %.1f \n" , soma);
        
        System.out.printf("Exiba a média dos consumos deste dicionário de carros: %.1f\n" , soma/carrosPopulares.size());

        System.out.println("\n" + carrosPopulares);
        
        System.out.println("\nRemova os modelos com o consumo igual a 15,6km/L: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6))iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("\nExiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.4);
        }};
        System.out.println(carrosPopulares1);

        System.out.println("\nExiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        System.out.println("\nApague todo o dicionário de carros: ");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);

        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());
    }

}
