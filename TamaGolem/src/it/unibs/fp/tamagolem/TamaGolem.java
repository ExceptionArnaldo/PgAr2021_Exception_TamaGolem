package it.unibs.fp.tamagolem;

import java.util.*;

public class TamaGolem {

    private String nome;
    private int vita_attuale = Costante.VITA_TAMAGOLEM;
    private boolean morto = false;
    private Queue<Pietra> pietre = new LinkedList<>();

    public void assegnaPietre() { // assegna le pietre ad un golem
        for (int i = Costante.C0; i < Costante.NUMERO_PIETRE_GOLEM; i++) {
            Pietra pietra_attuale = new Pietra(Elemento.getElemento(Utente.sceltaPietra()));

            pietre.add(pietra_attuale);
            pietra_attuale.usaPietra(pietra_attuale.getTipo().toString());
        }
    }

    public void ruotaPietre() { // sfrutta la struttura della Queue per ruotare le pietre del TamaGolem
        pietre.add(pietre.element());
        pietre.remove();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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