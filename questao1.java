import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class questao1 {
    public static void main(String[] args) {
        int tamanho = 5;
        String ArqCaminho = "C:\\Users\\Regiana\\IdeaProjects\\ATV03_Recursão2\\src\\dadosquestao1.txt";
        String conteudo = read(ArqCaminho);
        int[] vetor = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            vetor[i] = Integer.parseInt(conteudo.split(";") [i]);
        }

        int menor = encontrarMenor(vetor, 0,vetor.length - 1);
        System.out.println("O menor valor é "+menor);

        int posicaoMaior = encontrarMaior(vetor);
        System.out.println("O maior valor é "+vetor[posicaoMaior]);
    }

    private static int encontrarMaior(int[] vetor) {
        int maior = 0;

        for(int i = 1; i < vetor.length; i++){
            if(vetor[i] > vetor[maior]){
                maior = i;
            }
        }
        return maior;
    }

    private static int encontrarMenor(int[] vetor, int inicio, int fim) {
        if(inicio == fim) //vetor com um único elemento
            return vetor[inicio];
        else {
            int num1, num2;
            int meio;

            meio = (inicio + fim)/2;

            num1 = encontrarMenor(vetor, inicio, meio); //busca do inicio até o meio do vetor
            num2 = encontrarMenor(vetor, meio + 1, fim); //busca do meio até o fim do vetor

            if(num1 < num2) return num1;
            else return num2;

        }
    }

    public static String read(String caminho){
        String conteudo = "";
        int contador = 0;
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }
}
