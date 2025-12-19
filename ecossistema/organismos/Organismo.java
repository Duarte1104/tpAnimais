package ecossistema.organismos;

import ecossistema.simulacao.Grelha;

public abstract class Organismo {

    protected int x;
    protected int y;
    protected int idade;
    protected int idadeMax;
    protected boolean vivo;

    public Organismo(int x, int y, int idadeMax) {
        this.x = x;
        this.y = y;
        this.idadeMax = idadeMax;
        this.idade = 0;
        this.vivo = true;
    }

    public abstract void executarPasso(Grelha grelha);

    protected void envelhecer() {
        idade++;
        if (idade > idadeMax) {
            morrer();
        }
    }

    protected void morrer() {
        vivo = false;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public int getIdade() {
        return idade;
    }

    public int getIdadeMax() {
        return idadeMax;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void setPosicao(int novoX, int novoY) {
        this.x = novoX;
        this.y = novoY;
    }

    public abstract char getSimbolo();
}
