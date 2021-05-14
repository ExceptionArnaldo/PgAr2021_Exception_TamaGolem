package it.unibs.fp.tamagolem.grafica;

import it.unibs.fp.mylib.MyTime;
import it.unibs.fp.tamagolem.Giocatore;
import it.unibs.fp.tamagolem.utility.Costante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScontroGUI {

    private static JFrame frame_scontro;
    private static JLabel sfondo_label;

    private static Giocatore g1;
    private static Giocatore g2;

    private static JProgressBar vita1;
    private static JProgressBar vita2;

    public static void setScontro(){

        MenuGUI.menuPrincipale();


    }

    public static void scontro(){
        frame_scontro = Componenti.creaFrame(1050, 540);
        frame_scontro.setLayout(null);

        sfondo_label = new JLabel("", new ImageIcon("C:\\Users\\User\\Desktop\\sfondo.jpg"), JLabel.CENTER);
        sfondo_label.setBounds(0, 0, 1050, 540);
        frame_scontro.add(sfondo_label);

        // bottone prova
        JButton prova_button = new JButton("prova");
        sfondo_label.add(prova_button);
        Dimension size = prova_button.getPreferredSize();
        prova_button.setBounds(500, 5 , size.width, size.height);
        prova_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickProva();
            }});

        //immagine del golem 1
        ImageIcon image_golem1 = new ImageIcon("C:\\Users\\User\\Desktop\\image.png");
        JLabel golem1_label = Componenti.creaImageGolem(image_golem1, 200, 250);
        sfondo_label.add(golem1_label);

        //barra della vita del golem 1
        vita1 = Componenti.creaBarraVita(220, 470, 50);
        sfondo_label.add(vita1);

        //immagine del golem 2
        ImageIcon image_golem2 = new ImageIcon("C:\\Users\\User\\Desktop\\golem.png");
        JLabel golem2_label = Componenti.creaImageGolem(image_golem2, 600, 80);
        sfondo_label.add(golem2_label);

        //barra della vita del golem 2
        vita2 = Componenti.creaBarraVita(620, 310, 50);
        sfondo_label.add(vita2);

        // panel delle pietre
        JPanel panel_pietre = new JPanel();
        sfondo_label.add(panel_pietre);
        panel_pietre.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_pietre.setBounds(250, 600, 400, 100);
        panel_pietre.setLayout(new GridLayout(1, 3));

        /*
        //pietre
        JLabel pietre_image[] = new JLabel[pietre.length];

        for(int i = 0; i < pietre.length; i++){
            pietre_image[i] = new JLabel(pietre[i]);
            pietre_image[i].setHorizontalAlignment(JLabel.CENTER);
            panel_pietre.add(pietre_image[i]);
        }
*/

    }

    public static void clickProva(){
        setBarraVita(10);
    }

    public static void setBarraVita(int danno){
        vita1.setValue(vita1.getValue() - (int)(Math.random() * danno));
        vita2.setValue(vita2.getValue() - (int)(Math.random() * danno));
        controlloVita();
    }

    public static void controlloVita(){
        if(vita1.getValue() <= 0 || vita2.getValue() <= 0){
            frame_scontro.dispose();
            JFrame ultima_schermata = Componenti.creaFrame(400, 100);
            JLabel arriverdeci = new JLabel("La bozza della grafica finisce qui!! XD");

            ultima_schermata.add(arriverdeci);
        }
    }
}
