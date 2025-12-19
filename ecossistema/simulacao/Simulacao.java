package ecossistema.simulacao;

import ecossistema.organismos.*;

public class Simulacao {

    private final Grelha grelha;

    public Simulacao(int linhas, int colunas) {
        grelha = new Grelha(linhas, colunas);
        inicializarGrelha();
    }

    private void inicializarGrelha() {
        // Preenche a grelha com organismos aleatórios
        for (int y = 0; y < grelha.getLinhas(); y++) {
            for (int x = 0; x < grelha.getColunas(); x++) {
                // 50% chance para planta
                if (Math.random() < 0.5) {
                    grelha.set(x, y, new Planta(x, y, 20));
                }
                // 30% chance para a ovelha
                else if (Math.random() < 0.8) {
                    grelha.set(x, y, new Ovelha(x, y, 30, 10));
                }
                // 20% chance para o lobo
                else {
                    grelha.set(x, y, new Lobo(x, y, 40, 15));
                }
            }
        }
    }

    public void executarPasso() {
        for (int y = 0; y < grelha.getLinhas(); y++) {
            for (int x = 0; x < grelha.getColunas(); x++) {
                Organismo org = grelha.get(x, y);
                if (org != null && org.estaVivo()) {
                    org.executarPasso(grelha);  // Passa a referência da grelha para o organismo
                }
            }
        }
        grelha.imprimir(); // Imprime a grelha após cada passo
    }
}
