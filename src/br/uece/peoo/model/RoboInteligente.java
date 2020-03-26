package br.uece.peoo.model;

import br.uece.peoo.exceptions.MovimentoInvalidoException;

import java.awt.*;

public class RoboInteligente extends Robo{

    /**
     * Construtor que recebe a cor do robô e o inicialize na posição (0,0)
     *
     * @param cor
     */
    public RoboInteligente(Color cor) {
        super(cor);
    }

    /**
     * Tenta mover. Caso aconteça um erro, tenta novamente recursicamente.
     * Uma hora vai acertar o movimento.
     * @param direction Recebe como parâmetro uma String e altera a posição do robô.
     */
    @Override
    public void mover(String direction) throws MovimentoInvalidoException {
        try {
            super.mover(direction); // mover da classe mãe.
        } catch (MovimentoInvalidoException e) {
            moverRandom(); // mover do Robo Inteligente. Chamada recursiva.
        }
    }

    @Override
    public String toString() {
        return "RoboInteligente{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
