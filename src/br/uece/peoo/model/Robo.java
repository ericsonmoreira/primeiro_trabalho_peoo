package br.uece.peoo.model;


import java.awt.*;

/**
 *
 */
public class Robo extends Entidade {

    public final String UP = "up";

    /**
     * Construtor que recebe a cor do robô e o inicialize na posição (0,0)
     * @param cor
     */
    public Robo(Color cor) {
        super(0, 0, cor);
    }

    /**
     * Move o robo em uma direção recebe como parâmetro uma String e altera a posição do robô.
     * @param direction
     */
    private void mover(String direction) {

    }

    /**
     * Move o robô no eixo y em uma posição acima.
     */
    private void up(){

    }

    /**
     * Move o robô no eixo y em uma posição abaixo.
     */
    private void down(){

    }

    /**
     * Move o robô no eixo x em uma posição para a direita.
     */
    private void right(){

    }

    /**
     * Move o robô no eixo x em uma posição para a esquerda.
     */
    private void left(){

    }

    @Override
    public String toString() {
        return "Robo{" +
                "x=" + x +
                ", y=" + y +
                ", cor=" + cor +
                '}';
    }
}
