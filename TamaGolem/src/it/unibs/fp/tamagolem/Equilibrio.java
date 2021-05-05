package it.unibs.fp.tamagolem;


import it.unibs.fp.mylib.NumeriCasuali;

import java.util.ArrayList;

public class Equilibrio {

    private final static int MIN_ELEMENTI = 3;
    private final static int MAX_ELEMENTI = 8;

    private final static String[] ELEMENI_NOMI = {"fuoco", "erba", "acqua", "buio", "elettro", "folletto", "spettro", "yes"};

    private static int numero_elementi;

    private static Grafo grafo;

    public static void setup() {

        numero_elementi = creaNumeroElemento();
        setGrafo();
        setEquilibrio();
        stampaMatrice();
    }

    // metodo pre creare il grafo
    public static void setGrafo() {

        ArrayList<Nodo> nodi = new ArrayList<Nodo>();
        int random;
        int numero_nodi = 0;

        do { // aggiunge i nodi
            random = (int) (Math.random() * numero_elementi);
            Nodo n = new Nodo(ELEMENI_NOMI[random]); // crea un nodo con nome casuale di un elemento

            if (!n.esisteNodo(nodi)) { // se il nodo esiste non esiste lo aggiunge all'arrayList di nodi
                nodi.add(n);
                numero_nodi++;
            }

        } while (numero_nodi != numero_elementi); // fa finchè il numero di nodi non raggiunge a numero di elementi

        for (Nodo elementi : nodi) {
            System.out.println(elementi.getNome());
        }

        grafo = new Grafo(nodi); // crea il grafo con i nodi

    }

    // set l'equilibrio degli elementi
    public static void setEquilibrio() {
        for (int i = 0; i < grafo.getNodi().size(); i++) {
            for (int j = i; j < grafo.getNodi().size(); j++) {
                grafo.setPeso(grafo.getNodi().get(i), grafo.getNodi().get(j));
            }
        }
    }

    // stampa la matrice delle adiacenze
    public static void stampaMatrice() {

        int[][] mat_equi = grafo.getMat_ad();
        System.out.println("");
        for (int i = 0; i < mat_equi.length; i++) {
            for (int j = 0; j < mat_equi.length; j++) {
                System.out.print(String.format("%3d ", mat_equi[i][j]));
            }
            System.out.println(" ");
        }
    }

    // restituisce il numero di elementi
    private static int creaNumeroElemento() {
        return NumeriCasuali.estraiIntero(MIN_ELEMENTI, MAX_ELEMENTI);
    }
}