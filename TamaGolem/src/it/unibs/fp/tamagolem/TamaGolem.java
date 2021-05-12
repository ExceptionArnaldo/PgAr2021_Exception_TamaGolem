package it.unibs.fp.tamagolem;

import java.util.*;

public class TamaGolem {

    private static int numero_pietre = (Grafo.getNodi().size() + Costante.C1) / Costante.C3 + Costante.C1;
    private String nome;
    private int vita_totale = Costante.VITA_TAMAGOLEM;
    private int vita_attuale = vita_totale;
    private boolean morto = false;
    private Queue<Pietra> pietre = new LinkedList<>();

    public static int getNumero_pietre() {
        return numero_pietre;
    }

    public void setNumero_pietre(int numero_pietre) {
        TamaGolem.numero_pietre = numero_pietre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVita_totale() {
        return vita_totale;
    }

    public void setVita_totale(int vita_totale) {
        this.vita_totale = vita_totale;
    }

    public Queue<Pietra> getPietre() {
        return pietre;
    }

    public void setPietre(Queue<Pietra> pietre) {
        this.pietre = pietre;
    }

    public int getVita_attuale() {
        return vita_attuale;
    }

    public void setVita_attuale(int vita_attuale) {
        this.vita_attuale = vita_attuale;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public void assegnaPietre() { // assegna le pietre ad un golem FUNZIONA!!!!!!!!!!!!!
        for (int i = 0; i < numero_pietre; i++) {
            Pietra pietra_attuale = new Pietra(Elemento.getElemento(Utente.sceltaPietra()));

            pietre.add(pietra_attuale);
            pietra_attuale.usaPietra(pietra_attuale.getTipo().toString());
        }
    }

    public void ruotaPietre() { // sfrutta la struttura della Queue per ruotare le pietre del TamaGolem
        pietre.add(pietre.element());
        pietre.remove();
    }
}
