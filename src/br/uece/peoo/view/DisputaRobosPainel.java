package br.uece.peoo.view;

import br.uece.peoo.exceptions.MovimentoInvalidoException;
import br.uece.peoo.model.Comida;
import br.uece.peoo.model.Entidade;
import br.uece.peoo.model.Robo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DisputaRobosPainel extends JPanel implements KeyListener {

    // Constantes
    public static final int WIDTH = 400;
    public static final int HEIGTH = 400;

    private Robo roboA;
    private Robo roboB;

    private Comida comida;

    private String msgRofapeA; // mostra a informações do robo A
    private String msgRofapeB; // mostra a informações do robo B

    private void init() {
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        setFocusable(true);
        setVisible(true);
        requestFocus();
        addKeyListener(this);
    }

    public DisputaRobosPainel(Robo roboA, Robo roboB, Comida comida) {
        init();
        this.roboA = roboA;
        this.roboB = roboB;
        this.comida = comida;
        this.msgRofapeA = "Aperte ENTER para iniciar";
        this.msgRofapeB = "Aperte ENTER para iniciar";
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0, WIDTH, HEIGTH); // Limpando tudo
        paintEntidade(g, roboA); // Desenhando o Robo
        paintEntidade(g, roboB); // Desenhando o Robo
        paintEntidade(g, comida); // Desenhando a Comida
        g.setColor(Color.BLUE);
        g.drawString(this.msgRofapeA, 5, HEIGTH - Entidade.SIZE - 15);
        g.setColor(Color.GREEN);
        g.drawString(this.msgRofapeB, 5, HEIGTH - Entidade.SIZE);
    }

    public void paintEntidade(Graphics g, Entidade entidade) {
        g.setColor(entidade.getColor());
        g.fillRect(entidade.getX(), entidade.getY(), Entidade.SIZE, Entidade.SIZE);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int k = event.getKeyCode();

        System.out.println(k);

        if (k == KeyEvent.VK_ENTER) {
            // Bandeira para sinalizar se a comida foi encontrada.
            // Atomic é usado quando mais de uma thread pode mudar o valor de uma variável.

            AtomicBoolean flag = new AtomicBoolean(true);

            AtomicInteger countA = new AtomicInteger();
            AtomicInteger countB = new AtomicInteger();

            new Thread(() -> {
                while (flag.get()) {
                    try {
                        roboA.moverRandom();
                        countA.getAndIncrement();
                        this.msgRofapeA = roboA.toString();
                    } catch (MovimentoInvalidoException e) {
                        this.msgRofapeA = e.getMessage();
                    } if (roboA.achoComida(comida)) {
                        flag.set(false);
                        this.msgRofapeA = this.roboA + " Robo Azul achou a Comida.";
                        this.msgRofapeA = "Movimentos: roboAzul=" + countA + ", roboVerde=" + countB;
                        paint(this.getGraphics());
                        this.setEnabled(false);
                    } else {
                        paint(this.getGraphics());
                    }
                }
            }).start();

            new Thread(() -> {
                while (flag.get()) {
                    try {
                        roboB.moverRandom();
                        countB.getAndIncrement();
                        this.msgRofapeB = roboB.toString();
                    } catch (MovimentoInvalidoException e) {
                        this.msgRofapeB = e.getMessage();
                    } if (roboB.achoComida(comida)) {
                        flag.set(false);
                        this.msgRofapeB = this.roboB + " Robo Verde achou a Comida.";
                        this.msgRofapeA = "Movimentos: roboAzul=" + countA + ", roboVerde=" + countB;
                        paint(this.getGraphics());
                        this.setEnabled(false);
                    } else {
                        paint(this.getGraphics());
                    }
                }
            }).start();

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nada
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // nada
    }
}
