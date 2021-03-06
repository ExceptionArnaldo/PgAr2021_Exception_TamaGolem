package it.unibs.fp.tamagolem.grafo;

import it.unibs.fp.mylib.NumeriCasuali;
import it.unibs.fp.tamagolem.TamaGolem;
import it.unibs.fp.tamagolem.utility.Costante;
import it.unibs.fp.tamagolem.utility.Utente;

import java.util.ArrayList;

public class Grafo {

    private static ArrayList<Nodo> nodi;
    private static int[][] mat_ad;

    public Grafo(ArrayList<Nodo> nodi) {
        Grafo.nodi = nodi;
        mat_ad = new int[nodi.size()][nodi.size()];
    }

    public static ArrayList<Nodo> getNodi() {
        return nodi;
    }

    public static int[][] getMat_ad() {
        return mat_ad;
    }

    // metodo che setta i danni
    public void setPeso(Nodo n1, Nodo n2) {

        int i = nodi.indexOf(n1);
        int j = nodi.indexOf(n2);

        int danno_attuale = Costante.C0; // danno dell'i-esima riga
        int danno_s = Costante.C0; // danno della j-esima riga

        for (int h = Costante.C0; h < j; h++) { // calcola il danno nell'i-esima riga
            danno_attuale += mat_ad[i][h];
        }

        for (int h = Costante.C0; h < i; h++) { // calcola il danno nell'j-esima riga
            danno_s += mat_ad[j][h];
        }

        if (i == j) mat_ad[i][j] = Costante.C0; // se i == j, diagonale pricipale, il danno è nullo
        else if (j == mat_ad.length - Costante.C1) { // l'ultima colonna
            mat_ad[i][j] = -danno_attuale;
            mat_ad[j][i] = danno_attuale;
        } else {
            int danno;
            int pos_rim_a = mat_ad.length - j - Costante.C2; // posti rimanenti nella i-esima riga, cioè posti ancora nulli eccetto l'ultima
            int pos_rim_s = mat_ad.length - i - Costante.C3; // posti rimanenti nella j-esima riga, cioè posti ancora nulli eccetto l'ultima

            int valore_max_a; // valore massimo che il danno può assumere nella i-esima riga
            int valore_min_a; // valore minimo che il danno può assumere nella i-esima riga

            int valore_max_s; // valore minimo che il danno può assumere nella j-esima riga
            int valore_min_s; // valore minimo che il danno può  assumere nella j-esima riga

            valore_max_a = TamaGolem.getVita_tamagolem() - (-TamaGolem.getVita_tamagolem() * pos_rim_a) - danno_attuale;    // va a calcolare il valore max della i-esima riga utilizzando "la formula" |danno_attuale| <= vita del golem,
            valore_min_a = -TamaGolem.getVita_tamagolem() - (TamaGolem.getVita_tamagolem() * pos_rim_a) - danno_attuale;    // se il danno attuale supera la vita del golem allora nella matrice comparirà un danno superiore del golem

            valore_max_s = TamaGolem.getVita_tamagolem() - (-TamaGolem.getVita_tamagolem() * pos_rim_s) - danno_s;          // stesso ragionamento per la j-riga
            valore_min_s = -TamaGolem.getVita_tamagolem() - (TamaGolem.getVita_tamagolem() * pos_rim_s) - danno_s;

            int count = Costante.C0;
            do {
                danno = NumeriCasuali.estraiIntero(-TamaGolem.getVita_tamagolem(), TamaGolem.getVita_tamagolem());                              // estrae un danno casuale, ovviamente, <= della vita del golem

                count++;
                if (count > Costante.LIMITE)
                    Utente.easterEgg();

            } while (danno == Costante.C0 || danno > valore_max_a || danno < valore_min_a ||                                        // requisiti: 1. il danno non può essere 0
                    -danno > valore_max_s || -danno < valore_min_s ||                                                               // 2. il danno dev'essere compreso tra il valore_max_a e valore_min_a, e -danno, nella parte simmetrica dev'essere compreso tra valore_max_s e valore_min_s
                    ((j == mat_ad.length - Costante.C2) && danno_attuale + danno == Costante.C0) ||                                 // 3. nella penultima colonna il danno + danno_attuale non può essere zero perchè se lo fosse nell'ultima colonna comparirebbe lo 0
                    ((j == mat_ad.length - Costante.C2) && (i == mat_ad.length - Costante.C3) && danno_s - danno == Costante.C0));  // 4. stesso ragionamento nella penultima riga ma terzultima colonna perchè nella penultima colonna c'è lo 0


            mat_ad[i][j] = danno;
            mat_ad[j][i] = -danno;
        }
    }
}