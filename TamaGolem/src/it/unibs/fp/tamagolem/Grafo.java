package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.NumeriCasuali;

import java.util.ArrayList;

public class Grafo {

    private static ArrayList<Nodo> nodi;
    private static int[][] mat_ad;

    public Grafo(ArrayList<Nodo> nodi) {
        this.nodi = nodi;
        mat_ad = new int[nodi.size()][nodi.size()];
    }

    public static ArrayList<Nodo> getNodi() {
        return nodi;
    }

    public void setNodi(ArrayList<Nodo> nodi) {
        this.nodi = nodi;
    }

    public static int[][] getMat_ad() {
        return mat_ad;
    }

    public void setMat_ad(int[][] mat_ad) {
        this.mat_ad = mat_ad;
    }


    // metodo che setta i danni
    public void setPeso(Nodo n1, Nodo n2) {

        int i = nodi.indexOf(n1);
        int j = nodi.indexOf(n2);

        int danno_attuale = 0; // danno dell'i-esima riga
        int danno_s = 0; // danno della j-esima riga

        for (int h = 0; h < j; h++) { // calcola il danno nell'i-esima riga
            danno_attuale += mat_ad[i][h];
        }

        for (int h = 0; h < i; h++) { // calcola il danno nell'j-esima riga
            danno_s += mat_ad[j][h];
        }

        if (i == j) mat_ad[i][j] = 0; // se i == j, diagonale pricipale, il danno è nullo
        else if (j == mat_ad.length - 1) { // l'ultima colonna
            mat_ad[i][j] = -danno_attuale;
            mat_ad[j][i] = danno_attuale;
        } else {
            int danno;
            int pos_rim_a = mat_ad.length - j - 2; // posti rimanenti nella i-esima riga, cioè posti ancora nulli eccetto l'ultima
            int pos_rim_s = mat_ad.length - i - 3; // posti rimanenti nella j-esima riga, cioè posti ancora nulli eccetto l'ultima

            int valore_max_a; // valore massimo che il danno può assumere nella i-esima riga
            int valore_min_a; // valore minimo che il danno può assumere nella i-esima riga

            int valore_max_s; // valore minimo che il danno può assumere nella j-esima riga
            int valore_min_s; // valore minimo che il danno può  assumere nella j-esima riga

            valore_max_a = 10 - (-10 * pos_rim_a) - danno_attuale;  // va a calcolare il valore max della i-esima riga utilizzando "la formula" |danno_attuale| <= vita del golem ,
            // se il danno attuale supera la vita del golem allora nella matrice comparirà un danno superiore del golem
            valore_min_a = -10 - (10 * pos_rim_a) - danno_attuale;

            valore_max_s = 10 - (-10 * pos_rim_s) - danno_s; // stesso ragionamento per la j-riga
            valore_min_s = -10 - (10 * pos_rim_s) - danno_s;

            do {
                danno = NumeriCasuali.estraiIntero(-10, 10); // estrae un danno casuale, ovviamente, <= della vita del golem

            } while (danno == 0 || danno > valore_max_a || danno < valore_min_a ||                      // requisiti: 1. il danno non può essere 0
                    -danno > valore_max_s || -danno < valore_min_s ||                                   // 2. il danno dev'essere compreso tra il valore_max_a e valore_min_a, e -danno, nella parte simmetrica dev'essere compreso tra valore_max_s e valore_min_s
                    ((j == mat_ad.length - 2) && danno_attuale + danno == 0) ||                         // 3. nella penultima colonna il danno + danno_attuale non può essere zero perchè se lo fosse nell'ultima colonna comparirebbe lo 0
                    ((j == mat_ad.length - 2) && (i == mat_ad.length - 3) && danno_s - danno == 0));    // 4. stesso ragionamento nella penultima riga ma terzultima colonna perchè nella penultima colonna c'è lo 0

            mat_ad[i][j] = danno;
            mat_ad[j][i] = -danno;
        }
    }
}
