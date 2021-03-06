package it.unibs.fp.tamagolem;

import it.unibs.fp.tamagolem.grafo.Grafo;
import it.unibs.fp.tamagolem.utility.Costante;

import java.util.HashMap;
import java.util.Map;

public class Pietra {

    private static int pietre_per_tipo;
    private Elemento tipo;
    private static Map<String, Integer> scorta_comune = new HashMap<>();

    public Pietra(Elemento tipo) {
        this.tipo = tipo;
    }

    public static void riempiScorta() { // Crea la scorta comune di pietre
        scorta_comune.clear();
        for (int i = Costante.C0; i < Grafo.getNodi().size(); i++) {
            scorta_comune.put(Grafo.getNodi().get(i).getNome(), pietre_per_tipo);
        }
    }

    public void usaPietra(String chiave) { // rimuove la pietra che viene utilizzata, se le pietre di un tipo esauriscono si passa ad eliminare quel tipo di pietre
        int pietre = Pietra.scorta_comune.get(chiave);
        Pietra.scorta_comune.put(chiave, pietre - Costante.C1);
        if (pietre - Costante.C1 == Costante.C0)
            Pietra.scorta_comune.remove(chiave);
    }

    public Elemento getTipo() {
        return tipo;
    }

    public static Map<String, Integer> getScorta_comune() {
        return scorta_comune;
    }

    public static void setPietre_per_tipo(int pietre_per_tipo) {
        Pietra.pietre_per_tipo = pietre_per_tipo;
    }
}