package it.unibs.fp.tamagolem.grafica;

import it.unibs.fp.tamagolem.*;
import it.unibs.fp.tamagolem.grafo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GolemGUI {

    private static JFrame frame_golem;
    private static JPanel panel_golem;

    private static JTextField nome_golem_text;
    private static JComboBox [] scelta_elementi;

    public static void sceltaGolem(Giocatore g){

        int numero_elementi = Grafo.getNodi().size();

        frame_golem = Componenti.creaFrame(700, 700);

        panel_golem = new JPanel();
        panel_golem.setLayout(new GridLayout(9, 2, 10, 10));

        JLabel label_nome = new JLabel(g.getNome() + " , dai un nome al tuo golem ( " + g.getGolem_evocati() + "golem): ");
        label_nome.setHorizontalAlignment(JLabel.CENTER);

        nome_golem_text = new JTextField();

        JButton button_conferma = new JButton("Conferma");
        button_conferma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickConferma(g);}});

        scelta_elementi = new JComboBox[numero_elementi];

        panel_golem.add(label_nome);
        panel_golem.add(nome_golem_text);
        for(int i = 0; i < numero_elementi; i++){
            scelta_elementi[i] = new JComboBox();
            for(int j = 0; j < Grafo.getNodi().size(); j++){
                scelta_elementi[i].addItem(Grafo.getNodi().get(j).getNome());
            }
            panel_golem.add(scelta_elementi[i]);
        }

        panel_golem.add(button_conferma);

        frame_golem.add(panel_golem);

        frame_golem.setVisible(true);

    }

    public static void clickConferma(Giocatore g){
        if(controlloNome() && controlloPietre()) {
            String [] pietre = new String[scelta_elementi.length];
            for(int i = 0; i < scelta_elementi.length; i++){
                pietre[i] = scelta_elementi[i].getSelectedItem().toString();
            }
            frame_golem.dispose();
            g.setGolem(creaGolem());

            ScontroGUI.scontro(pietre);
        }
    }

    public static boolean controlloNome(){
        if(nome_golem_text.getText().trim().isEmpty()) {
            nome_golem_text.setBackground(Color.red);
            return false;
        }
        return true;
    }

    public static boolean controlloPietre(){
        ArrayList<String> pietra = new ArrayList<>();

        /*for(int i = 0; i < Grafo.getNodi().size(); i++){
            if(!pietra.contains(scelta_elementi[i].toString())){
                pietra.add(scelta_elementi[i].toString());
            }
        }*/

        return true;
    }

    public static TamaGolem creaGolem(){
        TamaGolem golem = new TamaGolem();

        String nome = getNomeGolem();
        Queue<Pietra> pietre = new LinkedList<>();

        golem.setNome(getNomeGolem());
        golem.setPietre(getPietre());
        return golem;

    }

    public static String getNomeGolem(){
        return nome_golem_text.getText();
    }

    public static Queue<Pietra> getPietre(){
        Queue<Pietra> pietre = new LinkedList<>();

        for(int i = 0; i < Grafo.getNodi().size(); i++){
            pietre.add(new Pietra(Elemento.getElemento(scelta_elementi[i].getSelectedItem().toString())));
        }
        return pietre;
    }

}
