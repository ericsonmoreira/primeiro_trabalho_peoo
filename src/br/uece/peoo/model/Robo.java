package br.uece.peoo.model;


import br.uece.peoo.exceptions.MovimentoInvalidoException;
import br.uece.peoo.view.RoboPanel;

import java.awt.*;

/**
 *  Classe Robo que contendo dois atributos representando sua posição no eixo cartesiano e uma cor que o identifica.
 */
public class Robo extends Entidade {

    // Constantes
    public final String UP = "up";
    public final String DOWN = "up";
    public final String RIGHT = "up";
    public final String LEFT = "up";

    /**
     * Construtor que recebe a cor do robô e o inicialize na posição (0,0)
     *
     * @param cor
     */
    public Robo(Color cor) {
        super(0, 0, cor);
    }

    /**
     * Move o robo em uma direção.
     *
     * @param direction Recebe como parâmetro uma String e altera a posição do robô.
     */
    private void mover(String direction) throws IllegalArgumentException, MovimentoInvalidoException {
        if (direction.equals(UP)) {
            up();
        } else if (direction.equals(DOWN)) {
            down();
        } else if (direction.equals(RIGHT)) {
            right();
        } else if (direction.equals(LEFT)) {
            left();
        } else {
            throw new IllegalArgumentException("Direção inválida: " + direction);
        }
    }

    /**
     * Move o robo em uma direção.
     *
     * @param direction Recebe como parâmetro um inteiro e altera a posição do robô.
     *                  1 representa “up”, 2 representa “down”, 3 representa “right” e 4 representa “left”.
     */
    private void mover(int direction) throws IllegalArgumentException, MovimentoInvalidoException {
        if (direction == 1) {
            up();
        } else if (direction == 2) {
            down();
        } else if (direction == 3) {
            right();
        } else if (direction == 4) {
            left();
        } else {
            throw new IllegalArgumentException("Direção inválida: " + direction);
        }
    }

    /**
     * Move o robô no eixo y em uma posição acima.
     */
    private void up() throws MovimentoInvalidoException {
        int y = this.y - SIZE;
        if (posicaoIsValida(this.x, y)) {
            setY(y);
        } else throw new MovimentoInvalidoException(this.x, y, this);
    }

    /**
     * Move o robô no eixo y em uma posição abaixo.
     */
    private void down() throws MovimentoInvalidoException {
        int y = this.y + SIZE;
        if (posicaoIsValida(this.x, y)) {
            setY(y);
        } else throw new MovimentoInvalidoException(this.x, y, this);
    }

    /**
     * Move o robô no eixo x em uma posição para a direita.
     */
    private void right() throws MovimentoInvalidoException {
        int x = this.x + SIZE;
        if (posicaoIsValida(x, this.y)) {
            setY(y);
        } else throw new MovimentoInvalidoException(this.x, y, this);
    }

    /**
     * Move o robô no eixo x em uma posição para a esquerda.
     */
    private void left() throws MovimentoInvalidoException {
        int y = this.y - SIZE;
        if (posicaoIsValida(x, this.y)) {
            setY(y);
        } else throw new MovimentoInvalidoException(this.x, y, this);
    }

    /**
     * Valida se o Robo pode ir para a posição (x, y).
     * @param x x destino.
     * @param y y destino.
     * @return false se a posição é inválida, true, caso contrário.
     */
    public static boolean posicaoIsValida(int x, int y) {
        if (x < 0 || x > RoboPanel.WIDTH - 5 || y < 0 || y > RoboPanel.HEIGTH)
            return false;
        else
            return true;
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
