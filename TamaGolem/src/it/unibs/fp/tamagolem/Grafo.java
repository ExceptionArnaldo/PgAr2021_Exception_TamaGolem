package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.NumeriCasuali;

import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {

    private ArrayList<Nodo> nodi;
    private int mat_ad[][];

    public Grafo(ArrayList<Nodo> nodi) {
        this.nodi = nodi;
        mat_ad = new int[nodi.size()][nodi.size()];
    }

    public ArrayList<Nodo> getNodi() {
        return nodi;
    }

    public void setNodi(ArrayList<Nodo> nodi) {
        this.nodi = nodi;
    }

    public int[][] getMat_ad() {
        return mat_ad;
    }

    public void setMat_ad(int[][] mat_ad) {
        this.mat_ad = mat_ad;
    }


    // metodo che setta i danni
    public void setPeso(Nodo n1, Nodo n2) {

        int i = nodi.indexOf(n1);
        int j = nodi.indexOf(n2);

        int danno_attuale = 0;
        int danno_s = 0;

        for (int h = 0; h < j; h++) { // calcola il danno attuale
            danno_attuale += mat_ad[i][h];
        }

        for(int h = 0; h < i; h++){
            danno_s += mat_ad[j][h];
        }

        if (i == j) mat_ad[i][j] = 0;
        else if (j == mat_ad.length - 1) {
            mat_ad[i][j] = -danno_attuale;
            mat_ad[j][i] = danno_attuale;
        }
        else {
            int danno;
            /*int min, max;

            int min_a, max_a;
            int min_s, max_s;

            min_a = -((10 * (mat_ad.length - j - 1)) + danno_attuale);
            max_a = (10 * (mat_ad.length - j - 1)) - danno_attuale;

            min_s = -((10 * (mat_ad.length - i - 2)) + danno_s);
            max_s = (10 * (mat_ad.length - i - 2)) - danno_s;

            if(min_a >= min_s) min = min_a;
            else min = min_s;

            if(max_a <= max_s) max = max_a;
            else max = max_s;

            if (min < -10) min = -10;
            else if(min > 10) min = 10;
            if (max > 10) max = 10;
            else if(max < -10) max = -10;*/

            int pos_rim_a = mat_ad.length - j - 2;
            int pos_rim_s = mat_ad.length - i - 3;

            int valore_max_a;
            int valore_min_a;

            int valore_max_s;
            int valore_min_s;

            int valore_max;
            int valore_min;

            int valore = 0;

            valore_max_a = 10 - (-10 * pos_rim_a) - danno_attuale;
            valore_min_a = -10 - (10 * pos_rim_a) - danno_attuale;

            valore_max_s = 10 - (-10 * pos_rim_s) - danno_s;
            valore_min_s = -10 - (10 * pos_rim_s) - danno_s;

            if(valore_min_a >= valore_min_s) valore_min = valore_min_a;
            else valore_min = valore_min_s;
            if(valore_max_a <= valore_max_s) valore_max = valore_max_a;
            else valore_max = valore_max_s;


            do {
                int danno_temp = 0;
                danno = NumeriCasuali.estraiIntero(-10, 10);

            } /*while (danno == 0 || ((j == mat_ad.length - 2) && danno_attuale + danno == 0) ||
                    ((j == mat_ad.length - 3) && (i == mat_ad.length - 2) && danno_attuale + danno == 0));*/
            while(danno == 0 ||  danno > valore_max_a || danno < valore_min_a ||
                    -danno > valore_max_s || -danno < valore_min_s ||
                    ((j == mat_ad.length - 2) && danno_attuale + danno == 0) ||
                    ((j == mat_ad.length - 2) && (i == mat_ad.length - 3) && danno_s - danno == 0));

            mat_ad[i][j] = danno;
            mat_ad[j][i] = -danno;
        }
    }

}
