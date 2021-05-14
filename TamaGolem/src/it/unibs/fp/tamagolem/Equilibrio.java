package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.NumeriCasuali;
import it.unibs.fp.tamagolem.grafo.Grafo;
import it.unibs.fp.tamagolem.grafo.Nodo;
import it.unibs.fp.tamagolem.utility.Costante;
import it.unibs.fp.tamagolem.utility.Utente;

import java.util.ArrayList;

public class Equilibrio {

    private final static int MIN_ELEMENTI = Costante.C3;

    private static int numero_elementi;

    private static Grafo grafo;

    private static ArrayList<Nodo> nodi = new ArrayList<>();

    public static void setup() { // inizializzazione dell' equilibrio di gioco

        numero_elementi = creaNumeroElemento();
        setGrafo();
        setParametri();
        setEquilibrio();
        Pietra.riempiScorta();
    }

    // metodo pre creare il grafo
    private static void setGrafo() {

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
    private static void setEquilibrio() {
        for (int i = Costante.C0; i < Grafo.getNodi().size(); i++) {
            for (int j = i; j < Grafo.getNodi().size(); j++) {
                grafo.setPeso(Grafo.getNodi().get(i), Grafo.getNodi().get(j));
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

    private static void setParametri() {
        TamaGolem.setVita_tamagolem(10 * Grafo.getNodi().size());
        TamaGolem.setNumero_pietre_goelm((int) Math.ceil((float) (Grafo.getNodi().size() + Costante.C1) / Costante.C3 + Costante.C1));
        Giocatore.setNumero_golem((int) Math.ceil((float) (Grafo.getNodi().size() - Costante.C1) * (Grafo.getNodi().size() - Costante.C2) / (Costante.C2 * TamaGolem.getNumero_pietre_goelm())));
        Pietra.setPietre_per_tipo((int) Math.ceil((float) Costante.C2 * TamaGolem.getNumero_pietre_goelm() * Giocatore.getNumero_golem() / Grafo.getNodi().size()));
    }

    public static ArrayList<Nodo> getNodi() {
        return nodi;
    }
}