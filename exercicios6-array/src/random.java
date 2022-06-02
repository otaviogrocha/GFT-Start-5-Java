import java.util.Random;

public class random {
    public static void main(String[] args) {
        Random random = new Random();

        int [] numRandom = new int[20];

        for (int i = 0; i < numRandom.length; i++) {
            int num = random.nextInt(100);
            numRandom[i] = num;
        }

        System.out.println("Numeros Aleatórios: ");
        for (int num : numRandom) {
            System.out.print(num + " ");
        }
        
        System.out.println("\nSucessores dos Numeros Aleatórios: ");
        for (int num : numRandom) {
            System.out.print((num +1)+ " ");
        }


    }
}
