package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.MyMenu;

public class Utente {

    private static String [] voci_pietre;
    private static MyMenu menu_pietra;

    private static void assegnaVociPietre(){

        voci_pietre = new String[Grafo.getNodi().size()];
        for(int i = 0; i < Grafo.getNodi().size(); i++){
            voci_pietre[i] = Grafo.getNodi().get(i).getNome();
        }
        menu_pietra = new MyMenu("Assegna Pietre", voci_pietre);
    }

    public static int sceltaPietra(){
        assegnaVociPietre();

        return menu_pietra.scegli();
    }
}
