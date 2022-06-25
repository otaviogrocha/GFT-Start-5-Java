package br.com.dio.collection.map;
import java.util.*;
import java.util.Map.Entry;
   
    /*Dadas as seguintes informações sobre meus livros favoritos e seus autores,
    crie um dicionário e ordene este dicionário:
    exibindo (Nome Autor - Nome Livro);
    Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo. páginas: 256
    Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, paginas: 408
    Autor = Harari, Yuval Noah  - Livro = 21 Lições Para o Século 21, páginas: 432
    */

public class OrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<String, Livro> meuslivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};

        for (Map.Entry<String, Livro> livro : meuslivros.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }
        System.out.println("\n--\tOrdem Inserção\t--");
        Map<String, Livro> meuslivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};

        for (Map.Entry<String, Livro> livro : meuslivros1.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\n--\tOrdem alfabética autores\t--");
        Map<String, Livro> meuslivros2 = new TreeMap<>(meuslivros1);
        for (Map.Entry<String, Livro> livro : meuslivros2.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\n--\tOrdem alfabética nomes dos livros\t--");
        Set<Map.Entry<String, Livro>> meuslivros3 = new TreeSet<>(new Livro.ComparatorNome());
        meuslivros3.addAll(meuslivros.entrySet());
        for (Map.Entry<String, Livro> entry : meuslivros3) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\n--\tOrdem número de página\t--");
        Set<Map.Entry<String, Livro>> meuslivros4 = new TreeSet<>(new Livro.ComparatorPagina());
        meuslivros4.addAll(meuslivros.entrySet());
        for (Map.Entry<String, Livro> livro : meuslivros4) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getPaginas());
        }

    }
}

class Livro{
    private String nome;
    private Integer paginas;
    
    

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }



    @Override
    public String toString() {
        return "Livro [nome=" + nome + ", paginas=" + paginas + "]";
    }

    static class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{
        @Override
        public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
            return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
        }
    }
    
    static class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{
        @Override
        public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
            return o1.getValue().getPaginas().compareTo(o2.getValue().getPaginas());
        }
    }

}