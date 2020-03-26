package br.uece.peoo;

import br.uece.peoo.model.Comida;
import br.uece.peoo.model.Entidade;
import br.uece.peoo.model.Robo;
import br.uece.peoo.view.RoboPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Crie uma classe Main que instancie um robô, peça ao usuário para determinar a posição do alimento,
 * e peça ao usuário para ficar movendo o robô até ele encontrar o alimento – não esqueça de tratar a exceção.
 */
public class Main {

    public static void main(String[] args) {

        Robo robo = new Robo(Color.BLUE);

        // Posição da Comida
        int x, y;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o x da posição da comida(0 a 79):");
        x = scanner.nextInt();

        System.out.println("Digite o y da posição da comida(0 a 79):");
        y = scanner.nextInt();

        Comida comida = new Comida(x * Entidade.SIZE, y * Entidade.SIZE);

        JFrame frame = new JFrame("Robos");
        frame.setContentPane(new RoboPanel(robo, comida));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Não pode mudar o tramano do JFrame
        frame.pack();
        frame.setPreferredSize(new Dimension(RoboPanel.WIDTH + 10, RoboPanel.WIDTH + 10));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
