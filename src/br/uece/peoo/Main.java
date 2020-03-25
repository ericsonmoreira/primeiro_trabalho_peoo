package br.uece.peoo;

import br.uece.peoo.view.RoboPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Robos");
        frame.setContentPane(new RoboPanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Não pode mudar o tramano do JFrame
        frame.setPreferredSize(new Dimension(RoboPanel.WIDTH, RoboPanel.WIDTH));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
