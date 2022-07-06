
import java.util.*;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/
public class ExercicioProposto02 {
    public static void main(String[] args) {
        System.out.println("--\tConjunto de linguagens: \t--");
        Set<LinguagemFavorita> lingfav = new HashSet<>();
        lingfav.add(new LinguagemFavorita("Python", 1991, "Pycharm"));
        lingfav.add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
        lingfav.add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));

        System.out.println("\n --\tOrdem de inserção\t--");
        Set<LinguagemFavorita> lingfav1 = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Python", 1991, "Pycharm"));
            add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
            add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));
        }};

        for (LinguagemFavorita linguagens : lingfav1) {
            System.out.println(linguagens.getNome() + " - " + linguagens.getAnoDeCriacao() + " - " + linguagens.getIde() );
        }

        System.out.println("\n --\tOrdem natural(nome)\t--");
        Set<LinguagemFavorita> lingfav2 = new TreeSet<>(lingfav);
        
        for (LinguagemFavorita linguagens : lingfav2) {
            System.out.println(linguagens.getNome() + " - " + linguagens.getAnoDeCriacao() + " - " + linguagens.getIde() );
        }
        
        System.out.println("\nOrdem IDE");
        Set<LinguagemFavorita> lingfav3 = new TreeSet<>(new LinguagemFavorita.ComparatorIDE());
        lingfav3.addAll(lingfav);

        for (LinguagemFavorita linguagem : lingfav3) {
            System.out.println(linguagem.getNome()+ " - " + linguagem.getAnoDeCriacao()+ " - " + linguagem.getIde());    
        }

        System.out.println("\nOrdem de criação e nome");
        Set<LinguagemFavorita> lingfav4 = new TreeSet<>(new LinguagemFavorita.ComparatorOrdemNome());
        lingfav4.addAll(lingfav);

        for (LinguagemFavorita linguagem  : lingfav4) {
            System.out.println(linguagem.getNome()+" - " + linguagem.getAnoDeCriacao()+" - " + linguagem.getIde());
        }
        System.out.println("\nOrdem Nome - Ano de Criacao - IDE");
        Set<LinguagemFavorita> lingfav5 = new TreeSet<>(new LinguagemFavorita.ComparatorNomeAnoIDE());
        lingfav5.addAll(lingfav);

        for (LinguagemFavorita linguagem  : lingfav5) {
            System.out.println(linguagem.getNome()+" - " + linguagem.getAnoDeCriacao()+" - " + linguagem.getIde());
        }
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoDeCriacao;
    private String ide;
    
    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }
    
        @Override
        public int compareTo(LinguagemFavorita o) {
            return this.nome.compareTo(o.nome);
        }

    public String getNome() {
        return nome;
    }
    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }
    public String getIde() {
        return ide;
    }
   
        @Override
        public String toString() {
            return "LinguagemFavorita [Nome =" + nome + ", Ano de Criação =" + anoDeCriacao + ", ide =" + ide + "]";
        }
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LinguagemFavorita that = (LinguagemFavorita) o;
            return nome.equals(that.nome);
        }
   
        @Override
        public int hashCode() {
            return Objects.hash(nome);
        }

    static class ComparatorIDE implements Comparator<LinguagemFavorita>{
        @Override
        public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
            int ide = o1.getIde().compareTo(o2.getIde());
            return ide;
        }
    }
    static class ComparatorOrdemNome implements Comparator<LinguagemFavorita>{
        @Override
        public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
            int ordem = o1.getAnoDeCriacao().compareTo(o2.getAnoDeCriacao());
            if(ordem !=0) return ordem;
            return o1.getNome().compareTo(o2.getNome());
        }
    }
    static class ComparatorNomeAnoIDE implements Comparator<LinguagemFavorita>{
        @Override
        public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
            int nome = o1.getNome().compareTo(o2.getNome());
            int ano =  Integer.compare(o1.getAnoDeCriacao(),o2.getAnoDeCriacao());
            if(nome !=0) return nome; 
            if(ano !=0)return ano;

            return o1.getIde().compareToIgnoreCase(o2.getIde());   
        }
    }
    
    
    
}