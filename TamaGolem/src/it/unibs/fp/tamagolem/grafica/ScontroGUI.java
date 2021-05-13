package it.unibs.fp.tamagolem.grafica;

import javax.swing.*;
import java.awt.*;

public class ScontroGUI {

    public static void scontro(String pietre[]){
        JFrame frame = new JFrame();
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        Insets insets = panel.getInsets();

        //prova
        JButton b = new JButton("prova");
        panel.add(b);
        Dimension size = b.getPreferredSize();
        b.setBounds(500 + insets.left, 5 + insets.top,
                size.width, size.height);

        //immagine del golem
        JLabel golem = new JLabel("YES", new ImageIcon("C:\\Users\\User\\Desktop\\image.png"), JLabel.CENTER);
        panel.add(golem);
        size = golem.getPreferredSize();
        golem.setBounds(5 + insets.left, 400 + insets.top,
                size.width, size.height);

        //barra della vita
        JProgressBar vita1 = new JProgressBar();
        panel.add(vita1);
        size = vita1.getPreferredSize();
        vita1.setBounds(5 + insets.left, 650 + insets.top,
                size.width, size.height);
        vita1.setValue(50);

        // panel delle pietre
        JPanel panel_pietre = new JPanel();
        panel.add(panel_pietre);
        panel_pietre.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_pietre.setBounds(250 + insets.left, 600 + insets.top,
                400, 100);
        panel_pietre.setLayout(new GridLayout(1, 3));

        //pietre
        JLabel pietre_image[] = new JLabel[pietre.length];

        for(int i = 0; i < pietre.length; i++){
            pietre_image[i] = new JLabel(pietre[i]);
            pietre_image[i].setHorizontalAlignment(JLabel.CENTER);
            panel_pietre.add(pietre_image[i]);
        }
    }
}
