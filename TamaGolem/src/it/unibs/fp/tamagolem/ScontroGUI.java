package it.unibs.fp.tamagolem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScontroGUI {

    private static JProgressBar vita1 = new JProgressBar();
    private static JProgressBar vita2 = new JProgressBar();

    public static void setScontro(){

    }

    public static void scontro(String pietre[]){
        JFrame frame = new JFrame();
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

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
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVita1(10);
                setVita2(10);
            }
        });

        //primo del golem
        JLabel golem = new JLabel("YES", new ImageIcon("C:\\Users\\User\\Desktop\\image.png"), JLabel.CENTER);
        panel.add(golem);
        size = golem.getPreferredSize();
        golem.setBounds(5 + insets.left, 400 + insets.top,
                size.width, size.height);

        //barra della vita

        panel.add(vita1);
        size = vita1.getPreferredSize();
        vita1.setBounds(5 + insets.left, 650 + insets.top,
                size.width, size.height);
        vita1.setMaximum(Costante.VITA_TAMAGOLEM);
        vita1.setValue(Costante.VITA_TAMAGOLEM);
        vita1.setBackground(Color.RED);
        vita1.setStringPainted(true);
        vita1.setForeground(Color.GREEN);

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

        //secondo golem
        JLabel golem2 = new JLabel("YES", new ImageIcon("C:\\Users\\User\\Desktop\\golem.png"), JLabel.CENTER);
        panel.add(golem2);
        size = golem2.getPreferredSize();
        golem2.setBounds(1000 + insets.left, 150 + insets.top,
                size.width, size.height);

        //barra della vita
        panel.add(vita2);
        size = vita2.getPreferredSize();
        vita2.setBounds(1000 + insets.left, 100 + insets.top,
                size.width, size.height);
        vita2.setMaximum(Costante.VITA_TAMAGOLEM);
        vita2.setValue(Costante.VITA_TAMAGOLEM);
        vita2.setBackground(Color.RED);
        vita2.setStringPainted(true);
        vita2.setForeground(Color.GREEN);

        /*String path = "C:\\Users\\User\\Desktop\\sfondo.jpg";
        Image img = Toolkit.getDefaultToolkit().createImage(path);*/
        panel.setBackground(Color.GRAY);
    }

    public static void setVita1(int danno){
        vita1.setValue(vita1.getValue() - danno);
        if(vita1.getValue() <= 0) EvocaGolemG.evocazioneGolem();
    }

    public static void setVita2(int danno){
        vita2.setValue(vita2.getValue() - danno);
        if(vita2.getValue() <= 0) EvocaGolemG.evocazioneGolem();
    }


}
