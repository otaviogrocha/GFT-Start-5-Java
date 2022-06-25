package br.com.dio.collection.map.PropostoExercicio03;

import java.util.*;
//import java.util.function.Function;

public class PropostoExercicio03 {
    public static void main(String[] args) {
        /*
         * Dadas as seguintes informações de id e contato, crie um dicionário e
         * ordene este dicionário exibindo (Nome id - Nome contato);
         * id = 1 - Contato = nome: Simba, numero: 2222;
         * id = 4 - Contato = nome: Cami, numero: 5555;
         * id = 3 - Contato = nome: Jon, numero: 1111;
         */

        System.out.println("--\tOrdem Aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};

        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda1);
        for (Map.Entry<Integer, Contato> entry : agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        
        }
        System.out.println("--\tOrdem ID\t--");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for (Map.Entry<Integer,Contato> Entry : agenda2.entrySet()) {
            System.out.println(Entry.getKey() + " - " + Entry.getValue().getNome());
        }
        System.out.println("--\tOrdem número de telefone\t--");
        //precisamos organizar os valores. 
                //-Modo 1: Classe Anonima-//
        
        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Entry<Integer, Contato> o1, Entry<Integer, Contato> o2) {
                return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
            }
        });*/
        
                // Modo 2: New Function//
        //Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(new Function<Map.Entry<Integer, Contato>, Integer>() {
        //     @Override
        //     public Integer apply(Map.Entry<Integer, Contato> cont) {
        //         return cont.getValue().getNumero();
        //     }
        // }));

                //Modo 3: Lambda//
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
            cont -> cont.getValue().getNumero()));
        
        
        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato>  entry : set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero()+ ": " + entry.getValue().getNome());
        }
        System.out.println("--\tOrdem nome contato\t--");
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new ComparatorOrdemNomeContato());
        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : set1) {
            System.out.println(entry.getKey()+" - " + entry.getValue().getNome());
        }
    }
}

// class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {

//     @Override
//     public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
//         return Integer.compare(o1.getValue().getNumero(),o2.getValue().getNumero());
//     }
// }

class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}