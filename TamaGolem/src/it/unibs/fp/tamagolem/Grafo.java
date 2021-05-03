package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.NumeriCasuali;

import java.util.ArrayList;

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

        for (int h = 0; h < j; h++) { // calcola il danno attuale
            danno_attuale += mat_ad[i][h];
        }

        int danno = 0;
        int eff = NumeriCasuali.estraiIntero(0, 1); // efficienza del danno, se è 1 il danno è positivo, 0 il danno è negativo

        if (i == j) mat_ad[i][j] = 0;
        else {
            if (i < j)
                danno = NumeriCasuali.estraiIntero(1, 10 - Math.abs(danno_attuale) - (mat_ad.length - j - 1)); // crea un danno casuale
            if (i > j)
                danno = NumeriCasuali.estraiIntero(1, 10 - Math.abs(danno_attuale) - (mat_ad.length - j - 2));

            if (j == mat_ad.length - 1) { // se arriva all'ultima colonna
                mat_ad[i][j] = -danno_attuale;
                mat_ad[j][i] = danno_attuale;
            }
            else {
                if (eff == 0) {
                    mat_ad[i][j] = -danno;
                    mat_ad[j][i] = danno;
                } else {
                    mat_ad[j][i] = -danno;
                    mat_ad[i][j] = danno;
                }
            }
        }
    }
}
