package ecossistema.organismos;

public abstract class Animal extends Organismo {

    protected int energia;

    public Animal(int x, int y, int idadeMax, int energiaInicial) {
        super(x, y, idadeMax);
        this.energia = energiaInicial;
    }

    protected void gastarEnergia(int custo) {
        energia -= custo;
        if (energia <= 0) {
            morrer();
        }
    }

    protected void ganharEnergia(int valor) {
        energia += valor;
    }

    public int getEnergia() {
        return energia;
    }
}
