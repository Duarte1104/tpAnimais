package ecossistema.organismos;
import ecossistema.simulacao.Grelha;

public class Planta extends Organismo {

    public Planta(int x, int y, int idadeMax) {
        super(x, y, idadeMax);
    }

    @Override
    public void executarPasso(Grelha grelha) {
        envelhecer();  // A planta envelhece
    }

    @Override
    public char getSimbolo() {
        return '*';
    }
}
