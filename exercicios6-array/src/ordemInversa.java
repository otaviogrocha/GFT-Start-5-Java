
public class ordemInversa {
    public static void main(String[] args)  {
        

        int[] vetor = {0, -5, 20, 30, 2};

        System.out.println("Vetor: ");
        int count = 0;
        while(count < (vetor.length)){
                System.out.print(vetor[count] + " ");
                count+=1;
        }

        System.out.println("\nVetor: ");
        for(int i = (vetor.length -1); i >= 0; i--){
            System.out.print(vetor[i] + " ");
        }
    }
}
