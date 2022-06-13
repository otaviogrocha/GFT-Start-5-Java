package src.br.com.dio.collections.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import src.br.com.dio.collections.List.Gato.ComparatorCor;
import src.br.com.dio.collections.List.Gato.ComparatorIdade;
import src.br.com.dio.collections.List.Gato.ComparatorNomeCorIdade;

public class ordenacaoList {
    public static void main(String[] args) {
       
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 8, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println("--\tOrdem de inserção\t--");
        System.out.println(meusGatos);
        
        System.out.println("\n--\tOrdem Aleatória\t--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);
        
        System.out.println("\n--\tOrdem Natural(nome)\t--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);
        
        System.out.println("\n--\tOrdem Idade\t--");
        Collections.sort(meusGatos, new ComparatorIdade());
        System.out.println(meusGatos);
        
        System.out.println("\n--\tOrdem Cor\t--");
        Collections.sort(meusGatos, new ComparatorCor());
        System.out.println(meusGatos);
        
        System.out.println("\n--\tOrdem Nome/Cor/Idade\t--");
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);
    }
}

class Gato implements Comparable<Gato>{
    private String nome;
    private int idade;
    private String cor;
    
    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

        @Override
        public String toString() {
            return "Gato [nome=" + nome + ", idade=" + idade + ", cor=" + cor + "]";
        }
    
        @Override
        public int compareTo(Gato gato) {
            return this.getNome().compareToIgnoreCase(gato.getNome());
        }

    static class ComparatorIdade implements Comparator<Gato>{
        @Override
        public int compare(Gato g1, Gato g2) {
            return Integer.compare(g1.getIdade(), g2.getIdade());
        }
    }
    static class ComparatorCor implements Comparator<Gato>{
        @Override
        public int compare(Gato g1, Gato g2) {
            return g1.getCor().compareToIgnoreCase(g2.getCor());
        }
    }
    
    static class ComparatorNomeCorIdade implements Comparator<Gato>{
        @Override
        public int compare(Gato g1, Gato g2) {
            int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
            if (nome != 0) return nome;

            int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
            if (cor != 0) return cor;
            
            return Integer.compare(g1.getIdade(), g2.getIdade());
        }
    }
    
}