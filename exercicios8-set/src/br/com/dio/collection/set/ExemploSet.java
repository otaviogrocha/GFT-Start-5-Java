import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {
    public static void main(String[] args)  {
        
        //Dada um a lista com 7 notas de um aluno[7, 8.5, 9.3, 5, 7, 0, 3.6] faça:
       
        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);
        System.out.println(notas);

        //Não FUNCIONAM NO SET porque precisa do index.
        /*System.out.println("Exiba a posição da nota 5.0: ");
        System.out.println("Adicione a lista a nota 8.0 na posição 4: ");
        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");*/

        System.out.println("\nConfira se a nota 5.0 está no conjunto: " + notas.contains(5d));

        //System.out.println("Exiba a terceira nota adicionada: ");- não funciona

        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma+=next;
        }
        System.out.println("\nExiba a soma dos valores: " + soma);
       
        System.out.println("\nExiba a média dos valores: " + soma/notas.size());
       
        System.out.println("\nRemova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);


        //System.out.println("Remova a nota da posição 0: "); - Não funciona

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        while(iterator.hasNext()){
            Double next = iterator.next();
            if(next < 7 ) iterator.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem que foram informados: ");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("\nExiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto: ");
        notas.clear();

        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());
    }
}
