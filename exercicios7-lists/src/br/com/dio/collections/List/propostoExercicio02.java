package src.br.com.dio.collections.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class propostoExercicio02 {
    public static void main(String[] args) {
        //fazer 6 perguntas
        Scanner scan = new Scanner(System.in);
        List<String> respostas = new ArrayList<>();
        System.out.println("Responda as perguntas com S/N\n");
        
        System.out.println("Telefonou para a vítima?");
        String resposta = scan.next();
        respostas.add(resposta.toUpperCase());
        System.out.println("\nEsteve no local do crime?");
        resposta = scan.next();
        respostas.add(resposta.toUpperCase());
        System.out.println("\nMora perto da vítima?");
        resposta = scan.next();
        respostas.add(resposta.toUpperCase());
        System.out.println("\nDevia para a vítima?");
        resposta = scan.next();
        respostas.add(resposta.toUpperCase());
        System.out.println("\nJá trabalhou para a vítima?");
        resposta = scan.next();
        respostas.add(resposta.toUpperCase());

        //Iterar a lista para adicionar as respostas positivas
        
        int count = 0;
        Iterator<String> iterator = respostas.iterator();
        while(iterator.hasNext()){
            String resp = iterator.next();
            if(resp.contains("S")){
                count +=1;
            }
        }
        //se responder positivamente a 2 questoes, deve ser classificada como suspeita, 3 e 4 como cumplice, e 5 como Assassina. Otherwise Inocente.
        switch(count){
            case 2: 
                System.out.println(">>SUSPEITA<<");          
                break;
            case 3: 
            case 4: 
                System.out.println(">>CÚMPLICE<<");
                break;
            case 5: 
                System.out.println(">>ASSASSINO<<");
                break;
            default:
                System.out.println(">>INOCENTE<<");
                break;

        }
        scan.close();
    }
}

