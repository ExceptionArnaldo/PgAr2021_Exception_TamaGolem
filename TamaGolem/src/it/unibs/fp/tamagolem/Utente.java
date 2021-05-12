package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Utente {

    private static String[] voci_pietre;
    private static MyMenu menu_pietra;

    private final static String[] voci_difficolta = {Costante.MSG_FACILE, Costante.MSG_MEDIO, Costante.MSG_DIFFICILE};
    private final static MyMenu menu_difficolta = new MyMenu(Costante.MSG_SCELTA_DIFFICOLTA, voci_difficolta);

    private static void assegnaVociPietre() { // Menu delle pietre disponibili da assegnare

        voci_pietre = new String[Grafo.getNodi().size()];
        for (int i = 0; i < Grafo.getNodi().size(); i++) {
            voci_pietre[i] = Grafo.getNodi().get(i).getNome();
        }
        menu_pietra = new MyMenu("Assegna Pietre", voci_pietre);
    }

    public static String sceltaPietra() {
        assegnaVociPietre();
        int scelta = menu_pietra.scegli();

        return voci_pietre[scelta - Costante.C1];
    }

    public static int sceltaDifficolta() {

        return menu_difficolta.scegli();
    }

    public static String nomeGolem() {
        return InputDati.leggiStringaNonVuota("Inserisci un nome: ");
    }
}
