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
	boolean acerto = false;

        do{
            System.out.print("Digite a quantidade de jogadores: ");
            numPlay = input.nextInt();
        }while(numPlay < 2);
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
            if(opt.equals("S")|| opt.equals("s")){
                System.out.println("Lider da rodada: " + atual);
            }
            System.out.print("Digite uma palavra: ");
            String palavra = input.next();
            String PALAVRA = palavra.toUpperCase();
            String minusculo = palavra.toLowerCase();
            System.out.print("Digite uma dica: ");
            String dica = input.next();
            int erro = 0;
            char secreto[] = new char[palavra.length()];
            for(int i = 0; i < palavra.length(); i++){
                secreto[i] = '_';
            }
            boolean falta = false;
            boolean fim = false;
            while(erro < 6){
                System.out.println("Dica: " + dica);
                for(int i = 0; i < palavra.length(); i++){
                    System.out.print(secreto[i]);
                }
                for(int i = 0; i < numPlay; i++){
                    if(atual.equals((nome[i]))){
                            i++;
                    }
                    if(numPlay == 2 && atual.equals(nome[0])){
                        System.out.println("\nVez de: " + nome[1]);
                    }
                    else if (numPlay == 2 && atual.equals(nome[1])){
                        System.out.println("\nVez de: " + nome[0]);
                    }
                    else{
                            System.out.println("\nVez de: " + nome[i]);
                    }
                    falta = false;
                    System.out.println("Digite uma letra: ");
                    char letra = input.next().charAt(0);
                    boolean contem = false;
                    for(int j = 0; j < palavra.length(); j++){
                        if((palavra.charAt(j) == letra || PALAVRA.charAt(j) == letra || minusculo.charAt(j) == letra)){
                           secreto[j] = letra;
                           contem = true;
                        }
                        }
                    if(contem) {
                        System.out.println("Letra correta!");
                        acerto = true;
                        for (int j = 0; j < palavra.length(); j++) {
                            if (secreto[j] == '_' || falta) {
                                fim = false;
                                falta = true;
                            }
                            else if(!falta){
                                    fim = true;
                            }
                        }
                        if(fim){
                            if(numPlay == 2 && atual.equals(nome[0])){
                                System.out.println(nome[1] + " acertou!");
                            }
                            else if (numPlay == 2 && atual.equals(nome[1])){
                                System.out.println(nome[0] + " acertou!");
                            }
                            else{
                                System.out.println(nome[i] + " acertou!");
                            }

                            System.out.println("A palavra era " + palavra);
                            atual = nome[i];
                            falta = false;
                        }
                    }
                    else{
                        System.out.println("Letra errada!");
                        acerto = false;
                        erro++;
                        falta = true;
                    }
                    if(falta || fim){
                        break;
                    }
                }
                if(!falta){
                    System.out.println("Deseja jogar novamente? (S/n): ");
                    opt = input.next();
                    if(fim && opt.equals("S") || fim && opt.equals("s")){
                        break;
                    }
                }
                }
            if(erro > 5){
                System.out.println(atual + " venceu\nA palavra era " + palavra);
                System.out.println("Deseja jogar novamente? (S/n): ");
                opt = input.next();
                if(fim && opt.equals("N") || fim && opt.equals("n")){
                    System.out.println("Ate a proxima!");
                    System.exit(1);
                }
            }
        }
    }
}
