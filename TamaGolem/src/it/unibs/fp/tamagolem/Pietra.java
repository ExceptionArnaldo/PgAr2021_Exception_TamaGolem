package it.unibs.fp.tamagolem;

import java.util.HashMap;
import java.util.Map;

public class Pietra {

    private static Map<String, Integer> scorta_comune = new HashMap<>();

    public static int calcolaPietreTipo() {
        return 2 * TamaGolem.getNumero_pietre() * Giocatore.numeroGolem() / Grafo.getNodi().size();
    }

    public static void riempiScorta() {
        int totale = calcolaPietreTipo();
        for (int i = 0; i < Grafo.getNodi().size(); i++) {
            scorta_comune.put(Grafo.getNodi().get(i).getNome(), totale);
        }
    }

    public static Map<String, Integer> getScorta_comune() {
        return scorta_comune;
    }

    public void setScorta_comune(Map<String, Integer> scorta_comune) {
        Pietra.scorta_comune = scorta_comune;
    }

    public void usa_pietra(String chiave) { // rimuove la pietra che viene utilizzata, se le pietre di un tipo esauriscono si passa ad eliminare quel tipo di pietre
        int pietre = Pietra.scorta_comune.get(chiave);
        Pietra.scorta_comune.put(chiave, pietre - 1);
        if (pietre - 1 == 0)
            Pietra.scorta_comune.remove(chiave);
    }
}
