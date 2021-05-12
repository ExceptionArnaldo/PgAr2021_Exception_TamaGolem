package it.unibs.fp.tamagolem;

import javax.swing.*;
import java.awt.*;

public class EvocaGolemG {

    public static void evocazioneGolem(int numero_elementi){

        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel label_nome = new JLabel("Nome del golem : ");

        JTextField field_nome = new JTextField(15);

        JButton button_conferma = new JButton("Conferma");

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

        frame.add(panel);

        frame.setVisible(true);

    }

}
