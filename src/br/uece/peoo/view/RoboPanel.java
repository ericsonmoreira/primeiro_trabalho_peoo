package br.uece.peoo.view;

import br.uece.peoo.exceptions.MovimentoInvalidoException;
import br.uece.peoo.model.Comida;
import br.uece.peoo.model.Entidade;
import br.uece.peoo.model.Robo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RoboPanel extends JPanel implements KeyListener {

    // Constantes
    public static final int WIDTH = 400;
    public static final int HEIGTH = 400;

    private Robo robo;

    private Comida comida;

    private String msgRofape;

    @Override
    public void keyPressed(KeyEvent event) {
        int k = event.getKeyCode();
        try {
            if (k == KeyEvent.VK_UP) {
                this.robo.mover(Robo.UP);
                this.msgRofape = robo.toString();
            }
            if (k == KeyEvent.VK_DOWN) {
                this.robo.mover(Robo.DOWN);
                this.msgRofape = robo.toString();

            }
            if (k == KeyEvent.VK_RIGHT) {
                this.robo.mover(Robo.RIGHT);
                this.msgRofape = robo.toString();
            }
            if (k == KeyEvent.VK_LEFT) {
                this.robo.mover(Robo.LEFT);
                this.msgRofape = robo.toString();
            }
        } catch (IllegalArgumentException e) { // Pegando qualquer exception
            this.msgRofape = e.getMessage();
        } catch (MovimentoInvalidoException e) {
            this.msgRofape = e.getMessage();
        } finally {
            paint(this.getGraphics());
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        // nada
    }

    @Override
    public void keyTyped(KeyEvent event) {
        // nada
    }

    private void init() {
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        setFocusable(true);
        setVisible(true);
        requestFocus();
        addKeyListener(this);

    }

    /**
     *
     * @param robo
     */
    public RoboPanel(Robo robo, Comida comida) {
        init();
        this.robo = robo;
        this.comida = comida;
        this.msgRofape = "";
    }

    public void paintEntidade(Graphics g, Entidade entidade) {
        g.setColor(entidade.getColor());
        g.fillRect(entidade.getX(), entidade.getY(), Entidade.SIZE, Entidade.SIZE);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0, WIDTH, HEIGTH); // Limpando tudo
        paintEntidade(g, robo); // Desenhando o Robo
        paintEntidade(g, comida); // Desenhando a Comida
        g.setColor(Color.DARK_GRAY);
        g.drawString(this.msgRofape, 5, HEIGTH - Entidade.SIZE);
    }
}
