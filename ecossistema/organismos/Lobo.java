package ecossistema.organismos;

import ecossistema.simulacao.Grelha;

public class Lobo extends Animal {

    public Lobo(int x, int y, int idadeMax, int energiaInicial) {
        super(x, y, idadeMax, energiaInicial);
    }

    @Override
public void executarPasso(Grelha grelha) {
    envelhecer();
    gastarEnergia(1);

    if (energia <= 0) {
        morrer();
    }

    // Lógica de movimento e interação (ex: caçar ovelhas)
    for (int i = -1; i <= 1; i++) {  // Verifica células adjacentes
        for (int j = -1; j <= 1; j++) {
            int novaX = x + i;
            int novaY = y + j;
            if (grelha.dentro(novaX, novaY)) {
                Organismo vizinho = grelha.get(novaX, novaY);
                if (vizinho instanceof Ovelha) {  // Se encontrar uma ovelha
                    comerOvelha((Ovelha) vizinho);  // Come a ovelha
                    grelha.remover(novaX, novaY);  // Remove a ovelha da grelha
                    break;
                }
            }
        }
    }
}

    @Override
    public char getSimbolo() {
        return 'W';
    }

    public void comerOvelha(Ovelha ovelha) {
        ganharEnergia(10);  // O lobo ganha energia ao comer uma ovelha
    }
}
