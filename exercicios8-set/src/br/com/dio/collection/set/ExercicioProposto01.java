package src.br.com.dio.collection.Set;

import java.util.*;

/*
Crie um conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

public class ExercicioProposto01 {
    public static void main(String[] args) {
        System.out.println("--\tCrie um conjunto com as cores do arco-íris: \t--\n");
        Set<String> arcoiris = new HashSet<>();
        arcoiris.add("Violeta");
        arcoiris.add("Anil");
        arcoiris.add("Azul");
        arcoiris.add("Verde");
        arcoiris.add("Amarelo");
        arcoiris.add("Laranja");
        arcoiris.add("Vermelho");
        System.out.println(arcoiris);
        
        System.out.println("\n--\tExiba as cores do arco-íris uma abaixo da outra:\t--");
        for (String cor : arcoiris) {
            System.out.println(cor);
        }

        System.out.println("\n--\tExiba as cores em ordem alfabética: \t--");
        Set<String> arcoiris1 = new TreeSet<>(arcoiris);
        System.out.println(arcoiris1);;
        

        System.out.println("\n--\tExiba as cores na ordem inversa da que foi informada: \t--");
        Set<String> arcoiris2 = new LinkedHashSet<>(Arrays.asList("violeta", "Anil", "Azul", "Verde", "Amarelo", "Laranja", "Vermelho"));
        List<String> arcoirisList = new ArrayList<>(arcoiris2);
        Collections.reverse(arcoirisList);
        System.out.println(arcoirisList);
      
        System.out.println("\n--\tExiba todas as cores que começam com a letra V: \t--");
        
        for (String cor : arcoiris) {
            if(cor.startsWith("V")) 
            System.out.println(cor);
        }
        
        System.out.println("\n--\tRemova todas as cores que começam com a letra V: \t--");
        
        Iterator<String> iterator = arcoiris.iterator();

            while(iterator.hasNext()) {
                if(iterator.next().startsWith("V"))
                iterator.remove();
            }
        
        System.out.println(arcoiris);
        
        System.out.println("\n--\tLimpe o conjunto: \t--");
        arcoiris.clear();
        System.out.println(arcoiris);
        
        System.out.println("\n--\tConfira se o conjunto está vazio: \t--");
        System.out.println(arcoiris.isEmpty());
    }
}

