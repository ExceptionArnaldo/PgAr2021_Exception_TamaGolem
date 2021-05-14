package it.unibs.fp.tamagolem.grafica;

import javax.swing.*;
import java.awt.*;

public class Componenti {

    public static JFrame creaFrame(int width, int height){
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        return frame;
    }

    public static JProgressBar creaBarraVita(int width, int height, int hp_max){
        JProgressBar vita = new JProgressBar();
        Dimension size = vita.getPreferredSize();
        vita.setForeground(Color.GREEN);
        vita.setBackground(Color.RED);
        vita.setBounds(width, height, size.width, size.height);
        vita.setMaximum(hp_max);
        vita.setValue(hp_max);

        return vita;
    }

    public static JLabel creaImageGolem(ImageIcon image_golem, int width, int height){
        JLabel label_golem = new JLabel();

        label_golem.setIcon(image_golem);
        label_golem.setText("Nome");
        label_golem.setHorizontalTextPosition(JLabel.CENTER);
        label_golem.setVerticalTextPosition(JLabel.TOP);
        Dimension size = label_golem.getPreferredSize();
        label_golem.setBounds(width, height, size.width, size.height);

        return label_golem;
    }

    /*public static Dimension getDimension(Component c){

        c.getPreferredSize();

    }*/

}
