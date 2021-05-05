package it.unibs.fp.tamagolem;

import java.util.HashMap;
import java.util.Map;

public class Pietra {

    private Map<String, Integer> scorta_comune = new HashMap<>();

    public int calcolaPietre() {
        return (Grafo.getNodi().size() + 1) / 3 + 1;
    }

    public void riempi_scorta(Map<String, Integer> scorta_comune) {

        int totale = calcolaPietre();
        for(int i= 0; i< Grafo.getNodi().size(); i++){
            scorta_comune.put(Grafo.getNodi().get(i).getNome(), totale);
        }
    }


    public Map<String, Integer> getScorta_comune() {
        return scorta_comune;
    }

    public void setScorta_comune(Map<String, Integer> scorta_comune) {
        this.scorta_comune = scorta_comune;
    }
}
