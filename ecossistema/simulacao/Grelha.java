package ecossistema.simulacao;

import ecossistema.organismos.Organismo;

public class Grelha {

    private final int linhas;
    private final int colunas;
    private final Organismo[][] celulas;

    public Grelha(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException("Dimensões inválidas: linhas e colunas devem ser > 0.");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        this.celulas = new Organismo[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public boolean dentro(int x, int y) {
        return y >= 0 && y < linhas && x >= 0 && x < colunas;
    }

    public Organismo get(int x, int y) {
        if (!dentro(x, y)) return null;
        return celulas[y][x];
    }

    public void set(int x, int y, Organismo org) {
        if (!dentro(x, y)) {
            throw new IndexOutOfBoundsException("Posição fora da grelha: (" + x + "," + y + ")");
        }
        celulas[y][x] = org;
    }

    public void remover(int x, int y) {
        set(x, y, null);
    }

    public boolean estaVazia(int x, int y) {
        return get(x, y) == null;
    }

    public String toStringGrelha() {
    StringBuilder sb = new StringBuilder();

    sb.append("+");
    for (int i = 0; i < colunas * 2 - 1; i++) sb.append("-");
    sb.append("+\n");

    for (int y = 0; y < linhas; y++) {
        sb.append("|");
        for (int x = 0; x < colunas; x++) {
            Organismo org = celulas[y][x];
            if (org != null) {
                char simbolo = org.getSimbolo();  // Apenas o símbolo
                sb.append(" " + simbolo + " ");   // Adiciona o símbolo
            } else {
                sb.append(" . ");  // Representa células vazias
            }
        }
        sb.append("|\n");
    }

    sb.append("+");
    for (int i = 0; i < colunas * 2 - 1; i++) sb.append("-");
    sb.append("+\n");

    return sb.toString();
}


    public void imprimir() {
        System.out.print(toStringGrelha());
    }
}
