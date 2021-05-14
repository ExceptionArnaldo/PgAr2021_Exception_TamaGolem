package it.unibs.fp.tamagolem.grafica;


import it.unibs.fp.tamagolem.Equilibrio;
import it.unibs.fp.tamagolem.Giocatore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI {

    private static JFrame frame_principale;
    private static JPanel panel_principale;

    private static JFrame frame_difficolta;
    private static JPanel panel_difficolta;

    private static JFrame frame_giocatore;
    private static JPanel panel_giocatore;
    private static JTextField nome_g1;
    private static JTextField nome_g2;

    private static Giocatore g1;
    private static Giocatore g2;

    public static void menuPrincipale(){

        frame_principale = Componenti.creaFrame(400, 400);

        panel_principale = new JPanel();
        panel_principale.setLayout(new GridLayout(5, 1, 20, 5));

        JLabel benvenuto_label = new JLabel("Benvenuti in TAMAGOLEM! ");
        benvenuto_label.setHorizontalAlignment(JLabel.CENTER);

        JButton inizia_btn = new JButton("Inizio partita");
        JButton regola_btn = new JButton("Regole");

        inizia_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickInizia(e);}});

        panel_principale.add(benvenuto_label);
        panel_principale.add(inizia_btn);
        panel_principale.add(regola_btn);

        frame_principale.add(panel_principale);

        frame_principale.setVisible(true);
    }

    public static void clickInizia(ActionEvent e){
        frame_principale.dispose();
        menuDifficolta();
    }

    public static void menuDifficolta(){

        frame_difficolta = Componenti.creaFrame(400, 400);

        panel_difficolta = new JPanel();
        panel_difficolta.setLayout(new GridLayout(5, 5, 10, 10));

        JLabel titolo_label = new JLabel("Scegliere la difficoltà");
        titolo_label.setHorizontalAlignment(JLabel.CENTER);

        JButton button_facile = new JButton("Facile");
        button_facile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickDifficolta(button_facile.getText());}});

        JButton button_medio = new JButton("Medio");
        button_medio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickDifficolta(button_medio.getText());}});

        JButton button_difficile = new JButton("Difficile");
        button_difficile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickDifficolta(button_difficile.getText());}});

        panel_difficolta.add(titolo_label);
        panel_difficolta.add(button_facile);
        panel_difficolta.add(button_medio);
        panel_difficolta.add(button_difficile);

        frame_difficolta.add(panel_difficolta);

        frame_difficolta.setVisible(true);
    }

    public static void clickDifficolta(String difficolta){

        if(difficolta.equalsIgnoreCase("facile")) Equilibrio.setup(1);
        else if(difficolta.equalsIgnoreCase("medio")) Equilibrio.setup(2);
        else Equilibrio.setup(3);

        frame_difficolta.dispose();
        menuGiocatore();
    }

    public static void menuGiocatore(){

        frame_giocatore = Componenti.creaFrame(400, 400);

        panel_giocatore = new JPanel();
        panel_giocatore.setLayout(new GridLayout(6, 1, 10 ,10));

        JLabel giocatore1 = new JLabel("Nome del giocatore 1 : ");
        JLabel giocatore2 = new JLabel("Nome del giocatore 2 : ");

        giocatore1.setHorizontalAlignment(JLabel.CENTER);
        giocatore1.setForeground(Color.red);
        giocatore2.setHorizontalAlignment(JLabel.CENTER);
        giocatore2.setForeground(Color.blue);

        nome_g1 = new JTextField(15);
        nome_g2 = new JTextField(15);

        JButton button_avanti = new JButton("Avanti");

        button_avanti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickAvanti();
            }
        });

        panel_giocatore.add(giocatore1);
        panel_giocatore.add(nome_g1);
        panel_giocatore.add(giocatore2);
        panel_giocatore.add(nome_g2);
        panel_giocatore.add(button_avanti, 4);

        frame_giocatore.add(panel_giocatore);
        frame_giocatore.setVisible(true);
    }

    public static void clickAvanti(){
        //if(controlloNome()){
            g1 = new Giocatore();
            g1.setNome(nome_g1.getText());
            g2 = new Giocatore();
            g2.setNome(nome_g2.getText());

            frame_giocatore.dispose();
            g1.evocaGolem();
            //g1.evocaGolem();
            //g2.evocaGolem();
        //}
    }

    public static  boolean controlloNome(){

        if(nome_g1.getText().trim().isEmpty()) nome_g1.setBackground(Color.red);
        else nome_g1.setBackground(Color.white);

        if(nome_g2.getText().trim().isEmpty()) nome_g2.setBackground(Color.red);
        else nome_g2.setBackground(Color.white);

        if(!nome_g1.getText().trim().isEmpty() && !nome_g2.getText().trim().isEmpty()) return true;

        return false;

    }
}
