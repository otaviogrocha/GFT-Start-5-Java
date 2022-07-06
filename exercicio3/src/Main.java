package exercicio3.src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exercício quadrilátero");
        double areaQuadrado = quadrilatero.area(3);
        System.out.println("Área é de: " + areaQuadrado);
        double areaRetangulo = quadrilatero.area(5d, 10d);
        System.out.println("Área é de: " + areaRetangulo);
        double areaTrapezio = quadrilatero.area(7, 8, 9);
        System.out.println("Área é de: " + areaTrapezio);
        double areaLosango = quadrilatero.area(5f, 7f);
        System.out.println("Área é de: " + areaLosango);
    }
}
