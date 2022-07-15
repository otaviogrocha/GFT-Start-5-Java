package src.br.com.dio.collection.Set;

import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--\n");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("GOT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("Castlevania", "Anime", 25));            
        }};

       for (Serie serie : minhasSeries) {
        System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
       }

        System.out.println("\n--\tOrdem de inserção\t--\n");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("GOT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("Castlevania", "Anime", 25));     
       }};

        for (Serie serie : minhasSeries1) {
        System.out.println(serie.getNome()+ " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
       }
       
        System.out.println("\n--\tOrdem Natural(Tempo Episódio)\t--\n");
        Set<Serie> minhasSeries2 = new TreeSet<>(new Serie.ComparatorTempo()){{
            add(new Serie("GOT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("Castlevania", "Anime", 25));     
       }};

        for (Serie serie : minhasSeries2) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
       }
        System.out.println("\n--\tOrdem Nome\t--\n");
        Set<Serie> minhasSeries20 = new TreeSet<>(new Serie.ComparatorNome()){{
            add(new Serie("GOT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("Castlevania", "Anime", 25));     
       }};

        for (Serie serie : minhasSeries20) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
       }

        System.out.println("\n--\tOrdem Nome/Gênero/TempoEpisódio\t--\n");
        Set<Serie> minhasSeries3 = new TreeSet<>(new Serie.ComparatorNomeGeneroeTempo());
        minhasSeries3.addAll(minhasSeries);

        for (Serie serie : minhasSeries3) {
            System.out.println(serie.getNome() + " - " + serie.getGenero()+ " - "+ serie.getTempoEpisodio());
        }
       
        //Faça ordenação por gênero e por Tempo Episódio:

        System.out.println("\n--\tOrdem Gênero\t--\n");
        Set<Serie> minhasSeries4 = new TreeSet<>(new Serie.ComparatorGeneroeTempo());
        minhasSeries4.addAll(minhasSeries);

        for (Serie serie : minhasSeries4) {
            System.out.println(serie.getNome()+ " - " + serie.getGenero()+" - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--\tOrdem TempoEpisódio\t--\n");
        Set<Serie> minhasSeries5 = new TreeSet<>(new Serie.ComparatorTempo());
        minhasSeries5.addAll(minhasSeries);

        for (Serie serie : minhasSeries5) {
            System.out.println(serie.getNome()+ " - " + serie.getGenero() + " - "+ serie.getTempoEpisodio());
        }
    }
}





class Serie {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;
   
    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

        @Override
        public String toString() {
            return "Serie [genero=" + genero + ", nome=" + nome + ", tempoEpisodio=" + tempoEpisodio + "]";
        }

        
        @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Serie serie = (Serie) o;
                return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
        }
        
        
        @Override
        public int hashCode() {
            return Objects.hash(nome, genero, tempoEpisodio);

        }

        static class ComparatorTempo implements Comparator<Serie>{
            @Override
            public int compare(Serie s1, Serie s2) {
                int tempo = s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());
                if(tempo !=0) return tempo;
                
                return s1.getGenero().compareTo(s2.getGenero());
            }
        }    
        static class ComparatorNome implements Comparator<Serie>{
            @Override
            public int compare(Serie s1, Serie s2) {
                int nome = s1.getNome().compareTo(s2.getNome());
                if(nome !=0) return nome;
                
                return s1.getGenero().compareTo(s2.getGenero());
            }
        }    
       
        static class ComparatorNomeGeneroeTempo implements Comparator<Serie>{
            @Override
            public int compare(Serie s1, Serie s2) {
                
            int nome = s1.getNome().compareTo(s2.getNome());
            if(nome !=0)return nome;

            int genero = s1.getGenero().compareTo(s2.getGenero());
            if(genero!=0)return genero;

            return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());

            }   
        
        }

        static class ComparatorGeneroeTempo implements Comparator<Serie>{
            @Override
            public int compare(Serie s1, Serie s2) {
                int genero = s1.getGenero().compareTo(s2.getGenero());
                if(genero != 0) return genero;

                return s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());
            }

        }


    

    
}






