package src;

import br.com.dio.collection.map.PropostoExercicio03.Contato;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;

public class RefatoracaoOrdenacaoMap {
    public static void main(String[] args) {
        
        System.out.println("--\t Ordem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<Integer, Contato>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(5, new Contato("Jon", 2222));
        }};
        for (Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey()+ " - " + entry.getValue().getNome());           
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(5, new Contato("Jon", 2222));
        }};

        for (Entry<Integer, Contato> entry : agenda1.entrySet()) {
            System.out.println(entry.getKey()+ " - " + entry.getValue().getNome());           
        }

        System.out.println("--\tOrdem número telefone\t--");
        //Precisamos organizar os valores. Logo:

        //      Metodo 1: Comparator Anonimo

        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Entry<Integer, Contato> o1, Entry<Integer, Contato> o2) {
                return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
            } 
        });
        for (Map.Entry<Integer, Contato> entry : set) {
            System.out.println("set 1: " + entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome());
        }

        //      Metodo 2: Comparator.comparing usando function

        Set<Map.Entry<Integer, Contato>> set2 = new TreeSet<>(Comparator.comparing(new Function<Map.Entry<Integer, Contato>,Integer>() {

            @Override
            public Integer apply(Entry<Integer, Contato> t) {
                return t.getValue().getNumero();
            }
        }));
        
        for (Map.Entry<Integer, Contato> entry : set2) {
            System.out.println("set 2: " + entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome());
        }
        
        //      Metodo 3: Comparator Comparing Usando Lambda

        Set<Map.Entry<Integer, Contato>> set3 = new TreeSet<>(Comparator.comparingInt(cont -> cont.getValue().getNumero()));
        set3.addAll(agenda.entrySet());

        for (Map.Entry<Integer, Contato> entry : set3) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome());
        }
        


        System.out.println("--\tOrdem Nome Contato\t--");
        //precisamos organizar os valores:
        Set<Map.Entry<Integer, Contato>> set4 = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNome()));
        set4.addAll(agenda.entrySet());
        set4.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().getNome()));
    }
}

//      Comparator Usual:

/*class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
    }
}*/

/*class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
    }
}*/
