package ac2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int numPlay;
	int primeiro = 0;
	String atual;
	String opt = "n";

        System.out.print("Digite a quantidade de jogadores: ");
        numPlay = input.nextInt();
        int pontos[] = new int[numPlay];
        String nome[] = new String[numPlay];
        System.out.println("Digite o nome dos jogadores: ");
        for(int i = 0; i < numPlay;i++){
            System.out.print("Player"+ (i+1) + ": ");
            nome[i] = input.next();
        }
        Random rand = new Random();
        int first = rand.nextInt(numPlay);
        System.out.println("Primeiro a jogar : " + nome[first]);
        atual = nome[first];
        while(primeiro < 3){
            System.out.print("Digite uma palavra: ");
            String palavra = input.next();
            System.out.print("Digite uma dica: ");
            String dica = input.next();
            int erro = 0;
            System.out.println("Dica: " + dica);
            char secreto[] = new char[palavra.length()];
            for(int i = 0; i < palavra.length(); i++){
                secreto[i] = '_';
            }
            boolean fim = true;
            while(erro < 6){
                for(int i = 0; i < palavra.length(); i++){
                    System.out.print(secreto[i]);
                }
                for(int i = 0; i < numPlay; i++){
                    if(atual.equals((nome[i]))){
                        i++;
                    }
                    System.out.println("\nVez de: " + nome[i]);
                    System.out.println("Digite uma letra: ");
                    char letra = input.next().charAt(0);
                    boolean contem = false;
                    for(int j = 0; j < palavra.length(); j++){
                        if((palavra.charAt(j) == letra)){
                           secreto[j] = letra;
                           contem = true;
                        }
                        }
                    if(contem) {

                        System.out.println("Letra correta!");
                        for (int j = 0; j < palavra.length(); j++) {
                            if ((secreto[j] == '_')) {
                                fim = false;
                                break;
                            }
                            else{
                                fim = true;
                            }
                        }
                        if(fim){
                            System.out.println(nome[i] + " acertou!");
                            System.out.println("A palavra era " + palavra);
                            pontos[i]++;
                            if(pontos[i] > primeiro){
                                primeiro = pontos[i];
                            }
                        }
                    }
                    else{
                        System.out.println("Letra errada!");
                        erro++;
                    }
                    if(fim){
                        break;
                    }
                }
            }
        }


    }
}
