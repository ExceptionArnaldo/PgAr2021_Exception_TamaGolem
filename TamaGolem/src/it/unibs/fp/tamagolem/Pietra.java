package it.unibs.fp.tamagolem;

import java.util.HashMap;
import java.util.Map;

public class Pietra {

    private Elemento tipo;
    private static Map<String, Integer> scorta_comune = new HashMap<>();

    public Pietra(Elemento tipo) {
        this.tipo = tipo;
    }

    public static int calcolaPietreTipo() { // restituisce il numero di pietre per tipo

        return (int) Math.ceil((float) Costante.C2 * TamaGolem.getNumero_pietre() * Giocatore.getNumero_golem() / Grafo.getNodi().size());
    }

    public static void riempiScorta() { // Crea la scorta comune di pietre
        for (int i = Costante.C0; i < Grafo.getNodi().size(); i++) {
            scorta_comune.put(Grafo.getNodi().get(i).getNome(), calcolaPietreTipo());
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
}