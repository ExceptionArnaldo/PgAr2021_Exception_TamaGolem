package it.unibs.fp.tamagolem;


import it.unibs.fp.mylib.NumeriCasuali;

import java.util.ArrayList;

public class Equilibrio {

    private final static int MIN_ELEMENTI = Costante.C3;

    private static int numero_elementi;

    private static Grafo grafo;

    private static ArrayList<Nodo> nodi = new ArrayList<>();

    public static void setup() { // inizializzazione dell' equilibrio di gioco

        numero_elementi = creaNumeroElemento();
        setGrafo();
        setEquilibrio();
        Pietra.riempiScorta();
    }

    // metodo pre creare il grafo
    public static void setGrafo() {

        int random;
        int numero_nodi = Costante.C0;
        nodi.clear();

        do { // aggiunge i nodi
            random = (int) (Math.random() * numero_elementi);

            Nodo n = new Nodo(Elemento.elementoPerId(random)); // crea un nodo con nome casuale di un elemento

            if (!n.esisteNodo(nodi)) { // se il nodo esiste non esiste lo aggiunge all'arrayList di nodi
                nodi.add(n);
                numero_nodi++;
            }

        } while (numero_nodi != numero_elementi); // fa finchè il numero di nodi non raggiunge a numero di elementi

        grafo = new Grafo(nodi); // crea il grafo con i nodi
    }

    // set l'equilibrio degli elementi
    public static void setEquilibrio() {
        for (int i = Costante.C0; i < grafo.getNodi().size(); i++) {
            for (int j = i; j < grafo.getNodi().size(); j++) {
                grafo.setPeso(grafo.getNodi().get(i), grafo.getNodi().get(j));
            }
        }
    }

    // restituisce il numero di nodi in base alla difficolta'
    private static int creaNumeroElemento() {
        int difficolta = Utente.sceltaDifficolta();

        if (difficolta == Costante.C1) return NumeriCasuali.estraiIntero(MIN_ELEMENTI, Costante.MAX_FACILE);
        else if (difficolta == Costante.C2)
            return NumeriCasuali.estraiIntero(Costante.MAX_FACILE + Costante.C1, Costante.MAX_MEDIO);
        else return NumeriCasuali.estraiIntero(Costante.MAX_MEDIO + Costante.C1, Elemento.values().length);
    }

    // restituisce la posizione del nodo cercato
    public static int posizioneNodo(Pietra pietra) {
        for (int i = Costante.C0; i < nodi.size(); i++)
            if (nodi.get(i).getNome().equals(pietra.getTipo().toString()))
                return i;

        return -Costante.C1;
    }

    public static ArrayList<Nodo> getNodi() {
        return nodi;
    }
}