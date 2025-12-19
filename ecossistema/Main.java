package ecossistema;

import ecossistema.simulacao.Simulacao;

public class Main {
    public static void main(String[] args) {
        // Cria uma simulação de tamanho 5x5
        Simulacao simulacao = new Simulacao(5, 5);

        // Executa a simulação por 10 passos
        for (int i = 0; i < 10; i++) {
            System.out.println("Passo " + (i + 1));
            simulacao.executarPasso();  // Executa um passo da simulação
            System.out.println();        // Deixa uma linha em branco entre os passos
        }
    }
}

// java ecosistema.Main
