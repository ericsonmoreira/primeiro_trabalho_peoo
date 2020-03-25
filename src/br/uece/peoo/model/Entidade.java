package br.uece.peoo.model;

import java.awt.*;

/**
 * Classe abistrata para representar os presonagens.
 */
public abstract class Entidade {

    // Comprimendo de uma entidade. Considere a área fixa de um quadrado com 5 unidades de lado.
    public static final int W = 5;

    protected int x, y;

    protected Color cor;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Entidade(int x, int y, Color cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

}
