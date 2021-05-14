package it.unibs.fp.tamagolem.utility;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.EstrazioniCasuali;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.tamagolem.Equilibrio;
import it.unibs.fp.tamagolem.Giocatore;
import it.unibs.fp.tamagolem.Pietra;
import it.unibs.fp.tamagolem.grafo.Grafo;

public class Utente {

    private static String[] voci_pietre;
    private static MyMenu menu_pietra;

    private final static String[] voci_difficolta = {Costante.MSG_FACILE, Costante.MSG_MEDIO, Costante.MSG_DIFFICILE};
    private final static MyMenu menu_difficolta = new MyMenu(Costante.MSG_SCELTA_DIFFICOLTA, voci_difficolta);

    private static void assegnaVociPietre() { // Menu delle pietre disponibili da assegnare
        // SI PUO' MIGLIORARE
        voci_pietre = new String[Pietra.getScorta_comune().size()];
        for (int i = Costante.C0; i < Pietra.getScorta_comune().size(); i++) { // il menu mostra solo le piere ancora disponibili e quante ne restano per tipo
            voci_pietre[i] = Pietra.getScorta_comune().keySet().toArray()[i].toString() + Costante.FRECCIA + Pietra.getScorta_comune().get(Pietra.getScorta_comune().keySet().toArray()[i]); // si e' un po' brutto
            //Pietra.getScorta_comune().forEach((key, value) -> voci_pietre[i] = key + " " + value);
        }
        menu_pietra = new MyMenu(Costante.MSG_ASSEGNA_PIETRE, voci_pietre);
    }

    public static String sceltaPietra() { // l'utente sceglie quale pietra assegnare al suo golem
        assegnaVociPietre();
        int scelta = menu_pietra.scegli();

        return voci_pietre[scelta - Costante.C1].substring(0, voci_pietre[scelta - Costante.C1].indexOf(' ')); // bisogna restituire solo il tipo di pietra, non la quantita'
    }

            public static int sceltaDifficolta() {
        return menu_difficolta.scegli();
    }

    public static void stampa(String msg) {
        System.out.println(msg + System.lineSeparator());
    } //stampa, niente println in giro per il programma

    public static void nomeAlievo(Giocatore g, String alievo) { // scelta nel nome per l'utente
        g.setNome(InputDati.leggiStringaNonVuota(String.format(Costante.MSG_SCELTA_NOME, alievo)));
        stampa("");
    }

    // stampa la matrice delle adiacenze
    /*public static void stampaMatrice() {

        int[][] mat_equi = Grafo.getMat_ad();
        System.out.println();
        for (int i = Costante.C0; i < mat_equi.length; i++) {
            for (int j = Costante.C0; j < mat_equi.length; j++) {
                System.out.printf("%3d ", mat_equi[i][j]);
            }
            System.out.println(" ");
        }
    }*/

    public static void stampaEquilibrio() { // stampa l'equilibrio
        int[][] mat_equi = Grafo.getMat_ad();

        for (int i = Costante.C0; i < mat_equi.length; i++) {
            for (int j = Costante.C0; j < mat_equi.length; j++) {
                if (i < j) {
                    if (mat_equi[i][j] > Costante.C0)
                        System.out.print(BelleStringhe.stampaStringaCorniceCentrato(String.format(Costante.MSG_STAMPA_EQUILIBRIO, Equilibrio.getNodi().get(i).getNome(), mat_equi[i][j], Equilibrio.getNodi().get(j).getNome())));
                    else
                        System.out.print(BelleStringhe.stampaStringaCorniceCentrato(String.format(Costante.MSG_STAMPA_EQUILIBRIO, Equilibrio.getNodi().get(j).getNome(), Math.abs(mat_equi[i][j]), Equilibrio.getNodi().get(i).getNome())));
                }
            }
        }
    }

    public static void stampaGolemBrutto() { // e' un' idea carina dai...
        stampa(Costante.GOLEM[EstrazioniCasuali.estraiIntero(Costante.C0, Costante.GOLEM.length - Costante.C1)]);
    }
}