package ecossistema.organismos;

import ecossistema.simulacao.Grelha;

public class Ovelha extends Animal {

    public Ovelha(int x, int y, int idadeMax, int energiaInicial) {
        super(x, y, idadeMax, energiaInicial);
    }

    @Override
    public void executarPasso(Grelha grelha) {
        envelhecer();
        gastarEnergia(1);

        if (energia <= 0) {
            morrer();
        }

        // A ovelha tenta mover-se para uma célula vazia
        if (Math.random() < 0.5) {
            int novaX = x + (Math.random() < 0.5 ? -1 : 1);
            int novaY = y + (Math.random() < 0.5 ? -1 : 1);
            if (grelha.dentro(novaX, novaY) && grelha.estaVazia(novaX, novaY)) {
                setPosicao(novaX, novaY);
            }
        }

        // Se encontrar uma planta, come e ganha energia
        if (grelha.get(x, y) instanceof Planta) {
            comerPlanta();
        }
    }

    @Override
    public char getSimbolo() {
        return 'O';
    }

    public void comerPlanta() {
        ganharEnergia(5);  // Aumenta a energia da ovelha
    }
}
