import java.util.Scanner;

public class consoantes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] consoantes = new String[6];
        int qtdeConsoantes = 0;
        
        int count = 0;
        do {
            System.out.println("Letra: ");
            String letra = scan.next();

            if(!(letra.equalsIgnoreCase("a") |
                letra.equalsIgnoreCase("e") |
                letra.equalsIgnoreCase("i") |
                letra.equalsIgnoreCase("o") |
                letra.equalsIgnoreCase("u"))){
                    consoantes[count] = letra;
                    qtdeConsoantes +=1;
                }
            
            count++;

        } while (count < consoantes.length);
        
        System.out.print("\nConsoantes: ");
        for (String consoante : consoantes) {
            if(consoante != null)
                System.out.print(consoante + " ");
        }
        System.out.print("\nQuantidade de Consoantes: " + qtdeConsoantes);
       
        scan.close();
    }
}
