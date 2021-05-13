package it.unibs.fp.tamagolem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvocaGolemG {

    private static boolean prima_volta = true;

    public static void evocazioneGolem(){

        int numero_elementi = Grafo.getNodi().size();

        JFrame frame = new JFrame();
        frame.setSize(700, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(15, 1, 10, 10));
        JLabel label_nome = new JLabel("Nome del golem : ");
        label_nome.setHorizontalAlignment(JLabel.CENTER);

        JTextField field_nome = new JTextField(15);

        JButton button_conferma = new JButton("Conferma");
        button_conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(prima_volta) {
                    evocazioneGolem();
                    prima_volta = false;
                }
                else ScontroGUI.scontro(new String[] {"1", "2"});
                frame.dispose();
            }
        });

        JComboBox [] scelta_elementi = new JComboBox[numero_elementi];

        //panel.setLayout(new GridLayout(3, 2));

        panel.add(label_nome);
        panel.add(field_nome);

        for(int i = 0; i < numero_elementi; i++){
            scelta_elementi[i] = new JComboBox();
            for(int j = 0; j < Grafo.getNodi().size(); j++){
                scelta_elementi[i].addItem(Grafo.getNodi().get(j).getNome());
            }

            panel.add(scelta_elementi[i]);
        }

        panel.add(button_conferma);

        // tabella delle pietre rimanenti
        JLabel pietre_rimaste[] = new JLabel[Grafo.getNodi().size()];

        for(int i = 0; i < Grafo.getNodi().size(); i++){
            String tipo = Grafo.getNodi().get(i).getNome();
            pietre_rimaste[i] = new JLabel(tipo + " x " + Pietra.getScorta_comune().get(tipo));
            panel.add(pietre_rimaste[i]);
        }

        frame.add(panel);

        frame.setVisible(true);

    }

}
