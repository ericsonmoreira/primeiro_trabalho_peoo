package br.uece.peoo.exceptions;

import br.uece.peoo.model.Entidade;

public class MovimentoInvalidoException extends Exception {

    private int x, y;

    private Entidade entidade;

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

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public MovimentoInvalidoException(int x, int y, Entidade entidade) {
        this.x = x;
        this.y = y;
        this.entidade = entidade;
    }

    @Override
    public String getMessage() {
        return "Imposível mover " + entidade + " para (" + x + ", " + y + ")";
    }
}
