public class Main {
    public static void main(String[] args)  {
        
        // Calculadora
        
        System.out.println("Exercício calculadora");
        operações.soma(3, 6);
        operações.subtracao(9,1.8);
        operações.multiplicacao(7, 8);
        operações.divisao(5, 2.5);

        // Mensagem

        System.out.println("Exercício Mensagem");
        mensagem.obterMensagem(9);
        mensagem.obterMensagem(14);
        mensagem.obterMensagem(1);

        // Empréstimo

        System.out.println("Exercício Empréstimo");
        emprestimo.calcular(1000, emprestimo.getDuasParcelas());
        emprestimo.calcular(1000, emprestimo.getTresParcelas());
        emprestimo.calcular(1000, 5);

    }
}
