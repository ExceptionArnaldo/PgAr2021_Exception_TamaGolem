package it.unibs.fp.tamagolem.grafica;


import it.unibs.fp.tamagolem.TamaGolem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuG {

    public static void menuPrincipale(){

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();

        JLabel benvenuto = new JLabel("Benvenuti in TAMAGOLEM! ");

        benvenuto.setHorizontalAlignment(JLabel.CENTER);

        JButton inizia = new JButton("Inizio partita");
        JButton regola = new JButton("Regole");

        panel.setLayout(new GridLayout(5, 1, 20, 5));

        inizia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                menuDifficolta();
            }
        });
        panel.add(benvenuto);
        panel.add(inizia);
        panel.add(regola);

        frame.add(panel);

        frame.setVisible(true);

    }

    public static void menuDifficolta(){
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JButton button_facile = new JButton("Facile");
        JButton button_medio = new JButton("Medio");
        JButton button_difficile = new JButton("Difficile");

        button_facile.setSize(new Dimension(100, 20));

        JLabel titolo = new JLabel("Scegliere la difficoltà");
        titolo.setHorizontalAlignment(JLabel.CENTER);

        panel.setLayout(new GridLayout(5, 5, 10, 10));
        panel.add(titolo);
        panel.add(button_facile);
        panel.add(button_medio);
        panel.add(button_difficile);

        frame.add(panel);

        frame.setVisible(true);

        button_facile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sceltaNomiGiocatori(TamaGolem.getNumero_pietre());
                frame.dispose();
            }
        });
    }

    public static void sceltaNomiGiocatori(int numero_elementi){
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel giocatore1 = new JLabel("Nome del giocatore 1 : ");
        JLabel giocatore2 = new JLabel("Nome del giocatore 2 : ");

        giocatore1.setHorizontalAlignment(JLabel.CENTER);
        giocatore1.setForeground(Color.red);
        giocatore2.setHorizontalAlignment(JLabel.CENTER);
        giocatore2.setForeground(Color.blue);

        JTextField nomeG1 = new JTextField(15);
        JTextField nomeG2 = new JTextField(15);

        JButton button_avanti = new JButton("Avanti");

        button_avanti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EvocaGolemG.evocazioneGolem(numero_elementi);
                frame.dispose();
            }
        });

        panel.setLayout(new GridLayout(6, 1, 10 ,10));

        panel.add(giocatore1);
        panel.add(nomeG1);
        panel.add(giocatore2);
        panel.add(nomeG2);
        panel.add(button_avanti, 4);

        frame.add(panel);

        frame.setVisible(true);

    }
}
