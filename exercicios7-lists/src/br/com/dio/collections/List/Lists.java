package src.br.com.dio.collections.List;
import java.util.*;



class Lists {
    public static void main(String[] args)  {
        System.out.println("Crie uma lista e adicione as sete notas: ");
        
        List<Double> notas = new ArrayList<>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0d);
        notas.add(3.6);
        System.out.println(notas);

        System.out.println("\nExiba a posição da nota 5.0: " + notas.indexOf(5d));

        System.out.println("\nAdicione na lista a nota 8.0 na posição 4: ");notas.add(4,8d);
        System.out.println(notas);

        System.out.println("\nSubstitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d), 6.0);
        System.out.println(notas);

        System.out.println("\nConfira se a nota 5.0 está na lista: " + notas.contains(5d));

        System.out.println("\nExiba todas as notas na ordem em que foram informadas: ");
        for (Double nota : notas) System.out.println(nota);

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
        System.out.println(notas);

        System.out.println("\nExiba a menor nota: " + Collections.min(notas));
        System.out.println("Exiba a maior nota: " + Collections.max(notas));
        
        System.out.println("\nExiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);

        System.out.println("\nExiba a média das notas: " + (soma/notas.size()));

        System.out.println("\nRemova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("\nRemova as notas menores que 7 e exiba a lista: ");
        Iterator <Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if (next <7) iterator1.remove();
        }
        System.out.println(notas);
        
        //System.out.println("\nApague toda a lista.");
        //notas.clear();
        //System.out.println(notas);
        

        System.out.println("\nConfira se a lista está vazia: " + notas.isEmpty());
         
        //Exercicios utilizando os métodos da implementação LinkedList:

        System.out.println("\nCrie uma lista chamada notas2: " );
        
        List<Double> notas2 = new ArrayList<>();
        notas2.addAll(notas);
        System.out.println(notas2);
        
        System.out.println("\nMostre a primeira nota da nova lista sem removê-lo: " + notas2.get(0));
        System.out.println(notas2);
        
        System.out.println("\nMostre a primeira nota da nova lista removendo-a: "+ notas2.get(0));
        notas2.remove(0);
        System.out.println(notas2);
        

    }

}
