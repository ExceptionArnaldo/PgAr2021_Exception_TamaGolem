package it.unibs.fp.tamagolem.grafica;

import it.unibs.fp.tamagolem.Giocatore;

import javax.swing.*;
import java.awt.*;

public class ScontroGUI {

    private static JFrame frame_scontro;
    private static JLabel sfondo_label;

    private static Giocatore g1;
    private static Giocatore g2;
    public static void setScontro(){

        MenuGUI.menuPrincipale();


    }

    public static void scontro(String pietre[]){
        frame_scontro = Componenti.creaFrame(1050, 540);
        frame_scontro.setLayout(null);

        sfondo_label = new JLabel("", new ImageIcon("C:\\Users\\User\\Desktop\\sfondo.jpg"), JLabel.CENTER);
        sfondo_label.setBounds(0, 0, 1050, 540);
        frame_scontro.add(sfondo_label);

        //prova
        JButton b = new JButton("prova");
        sfondo_label.add(b);
        Dimension size = b.getPreferredSize();
        b.setBounds(500, 5 , size.width, size.height);

        //immagine del golem 1
        ImageIcon image_golem1 = new ImageIcon("C:\\Users\\User\\Desktop\\image.png");
        JLabel golem1_label = Componenti.creaImageGolem(image_golem1, 200, 250);
        sfondo_label.add(golem1_label);

        //barra della vita del golem 1
        JProgressBar vita1 = Componenti.creaBarraVita(220, 470, 10);
        sfondo_label.add(vita1);

        //immagine del golem 2
        ImageIcon image_golem2 = new ImageIcon("C:\\Users\\User\\Desktop\\golem.png");
        JLabel golem2_label = Componenti.creaImageGolem(image_golem2, 600, 80);
        sfondo_label.add(golem2_label);

        //barra della vita del golem 2
        JProgressBar vita2 = Componenti.creaBarraVita(620, 310, 10);
        sfondo_label.add(vita2);

        // panel delle pietre
        JPanel panel_pietre = new JPanel();
        sfondo_label.add(panel_pietre);
        panel_pietre.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_pietre.setBounds(250, 600, 400, 100);
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
