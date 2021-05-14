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

    private static JLabel [] pietre_rimanenti;

    private static JTextField nome_golem_text;
    private static JComboBox [] scelta_elementi;

    // crea la finestra per la creazione di un golem
    public static void sceltaGolem(Giocatore g){

        int numero_elementi = Grafo.getNodi().size();

        frame_golem = Componenti.creaFrame(700, 700);

        panel_golem = new JPanel();
        panel_golem.setLayout(new GridLayout(9, 2, 10, 10));

        JLabel label_nome = new JLabel(g.getNome() + " , dai un nome al tuo golem (" + g.getGolem_evocati() + " golem): ");
        label_nome.setHorizontalAlignment(JLabel.CENTER);

        nome_golem_text = new JTextField();

        JButton button_conferma = new JButton("Conferma");
        button_conferma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickConferma(g);}});

        scelta_elementi = new JComboBox[TamaGolem.getNumero_pietre()];

        panel_golem.add(label_nome);
        panel_golem.add(nome_golem_text);

        // aggiunge i comboBox in base al numero di elementi e numero di pietre per golem
        for(int i = 0; i < TamaGolem.getNumero_pietre(); i++){
            scelta_elementi[i] = new JComboBox();
            for(int j = 0; j < Grafo.getNodi().size(); j++){
                scelta_elementi[i].addItem(Grafo.getNodi().get(j).getNome());
            }
            panel_golem.add(scelta_elementi[i]);
        }

        panel_golem.add(button_conferma);

        pietre_rimanenti = new JLabel[numero_elementi];

        // aggiunge una tabella per le pietre rimanenti
        for(int i = 0; i < numero_elementi; i++){
            pietre_rimanenti[i] = new JLabel();
            String tipo = Grafo.getNodi().get(i).getNome();
            pietre_rimanenti[i].setText(tipo + " x " + Pietra.getScorta_comune().get(tipo));
            panel_golem.add(pietre_rimanenti[i]);
        }

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

            ScontroGUI.scontro();
        }
    }

    // controlla che il nome del golem non sia vuoto
    public static boolean controlloNome(){
        if(nome_golem_text.getText().trim().isEmpty()) {
            nome_golem_text.setBackground(Color.red);
            return false;
        }
        return true;
    }

    // controlla che le pietre prese sono ancora disponibili o no
    public static boolean controlloPietre(){
        ArrayList<String> pietra = new ArrayList<>();

        /*for(int i = 0; i < Grafo.getNodi().size(); i++){
            if(!pietra.contains(scelta_elementi[i].toString())){
                pietra.add(scelta_elementi[i].toString());
            }
        }*/

        return true;
    }

    // creazione di un golem
    public static TamaGolem creaGolem(){
        TamaGolem golem = new TamaGolem();

        String nome = getNomeGolem();
        Queue<Pietra> pietre = new LinkedList<>();

        golem.setNome(getNomeGolem());
        //golem.setPietre(getPietre());
        return golem;

    }

    public static String getNomeGolem(){
        return nome_golem_text.getText();
    }

    /*public static Queue<Pietra> getPietre(){
        Queue<Pietra> pietre = new LinkedList<>();

        for(int i = 0; i < Grafo.getNodi().size(); i++){
            pietre.add(new Pietra(Elemento.getElemento(scelta_elementi[i].getSelectedItem().toString())));
        }
        return pietre;
    }*/

}
