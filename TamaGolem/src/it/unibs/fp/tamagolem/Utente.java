package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Utente {

    private static String[] voci_pietre;
    private static MyMenu menu_pietra;

    private final static String[] voci_difficolta = {Costante.MSG_FACILE, Costante.MSG_MEDIO, Costante.MSG_DIFFICILE};
    private final static MyMenu menu_difficolta = new MyMenu(Costante.MSG_SCELTA_DIFFICOLTA, voci_difficolta);

    private static void assegnaVociPietr() { // Menu delle pietre disponibili da assegnare

        // SISTEMARE, BISOGNA UTILIZZARE LA MAP!!!

        voci_pietre = new String[Grafo.getNodi().size()];
        for (int i = Costante.C0; i < Grafo.getNodi().size(); i++) {
            voci_pietre[i] = Grafo.getNodi().get(i).getNome();
        }
        menu_pietra = new MyMenu(Costante.MSG_ASSEGNA_PIETRE, voci_pietre);
    }

    private static void assegnaVociPietre() { // Menu delle pietre disponibili da assegnare

        // SISTEMARE, BISOGNA UTILIZZARE LA MAP!!!

        voci_pietre = new String[Pietra.getScorta_comune().size()];
        for (int i = Costante.C0; i < Pietra.getScorta_comune().size(); i++) {
            voci_pietre[i] = Pietra.getScorta_comune().keySet().toArray()[i].toString() + " --> " + Pietra.getScorta_comune().get(Pietra.getScorta_comune().keySet().toArray()[i]);
            //Pietra.getScorta_comune().forEach((key, value) -> voci_pietre[i] = key + " " + value);
        }
        menu_pietra = new MyMenu(Costante.MSG_ASSEGNA_PIETRE, voci_pietre);
    }


    public static String sceltaPietra() {
        assegnaVociPietre();
        int scelta = menu_pietra.scegli();

        return voci_pietre[scelta - Costante.C1];
    }

    public static int sceltaDifficolta() {

        return menu_difficolta.scegli();
    }

    public static void stampa(String msg) {
        System.out.println(msg);
    }

    public static void stampa(String msg, String parametro1) {
        System.out.printf(msg, parametro1);
    }

    public static void stampa(String msg, String parametro1, String parametro2) {
        System.out.printf(msg, parametro1, parametro2);
    }

    public static void nomeAlievo(Giocatore g, String alievo) {
        g.setNome(InputDati.leggiStringaNonVuota(String.format(Costante.MSG_SCELTA_NOME, alievo)));
    }

    // stampa la matrice delle adiacenze
    public static void stampaMatrice() {

        int[][] mat_equi = Grafo.getMat_ad();
        System.out.println();
        for (int i = Costante.C0; i < mat_equi.length; i++) {
            for (int j = Costante.C0; j < mat_equi.length; j++) {
                System.out.printf("%3d ", mat_equi[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static void stampaEquilibrio() { // sistemare
        int[][] mat_equi = Grafo.getMat_ad();

        for (int i = Costante.C0; i < mat_equi.length; i++) {
            for (int j = Costante.C0; j < mat_equi.length; j++) {
                if (i < j) {
                    if (mat_equi[i][j] < Costante.C0)
                        //System.out.printf("%s --%d--> %s\n",Equilibrio.getNodi().get(i).getNome(),Math.abs(mat_equi[i][j]),Equilibrio.getNodi().get(j).getNome());
                        System.out.print(BelleStringhe.stampaStringaCorniceCentrato(String.format("%s -- %d --> %s\n", Equilibrio.getNodi().get(i).getNome(), Math.abs(mat_equi[i][j]), Equilibrio.getNodi().get(j).getNome())));
                    else
                        //System.out.printf("%s --%d--> %s\n",Equilibrio.getNodi().get(j).getNome(),mat_equi[i][j],Equilibrio.getNodi().get(i).getNome());
                        System.out.print(BelleStringhe.stampaStringaCorniceCentrato(String.format("%s -- %d --> %s\n", Equilibrio.getNodi().get(j).getNome(), mat_equi[i][j], Equilibrio.getNodi().get(i).getNome())));
                }
            }
        }
    }
}