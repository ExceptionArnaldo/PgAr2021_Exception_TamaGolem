package it.unibs.fp.tamagolem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvocaGolemG {

    public static void evocazioneGolem(int numero_elementi){

        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));
        JLabel label_nome = new JLabel("Nome del golem : ");
        label_nome.setHorizontalAlignment(JLabel.CENTER);

        JTextField field_nome = new JTextField(15);

        JButton button_conferma = new JButton("Conferma");
        button_conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScontroGUI.scontro(new String[] {"1", "2"});
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

        frame.add(panel);

        frame.setVisible(true);

    }

}
