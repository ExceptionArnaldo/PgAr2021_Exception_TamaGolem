package it.unibs.fp.tamagolem;

import it.unibs.fp.tamagolem.grafo.Grafo;
import it.unibs.fp.tamagolem.utility.Costante;
import it.unibs.fp.tamagolem.utility.Utente;

import java.util.*;

public class TamaGolem {

    private static int numero_pietre = (int) Math.ceil((float) (Grafo.getNodi().size() + Costante.C1) / Costante.C3 + Costante.C1);
    private String nome;
    private int vita_totale = Costante.VITA_TAMAGOLEM;
    private int vita_attuale = vita_totale;
    private boolean morto = false;
    private Queue<Pietra> pietre = new LinkedList<>();

    public void assegnaPietre() { // assegna le pietre ad un golem
        for (int i = Costante.C0; i < numero_pietre; i++) {
            Pietra pietra_attuale = new Pietra(Elemento.getElemento(Utente.sceltaPietra()));

            pietre.add(pietra_attuale);
            pietra_attuale.usaPietra(pietra_attuale.getTipo().toString());
        }
    }

    public void ruotaPietre() { // sfrutta la struttura della Queue per ruotare le pietre del TamaGolem
        pietre.add(pietre.element());
        pietre.remove();
    }

    public static int getNumero_pietre() {
        return numero_pietre;
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

    public Queue<Pietra> getPietre() {
        return pietre;
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
}