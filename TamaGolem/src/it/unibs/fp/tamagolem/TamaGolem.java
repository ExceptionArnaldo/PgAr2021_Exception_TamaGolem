package it.unibs.fp.tamagolem;

import it.unibs.fp.tamagolem.utility.Costante;
import it.unibs.fp.tamagolem.utility.Utente;
import java.util.*;

public class TamaGolem {

    private String nome;
    private static int numero_pietre_goelm;
    private static int vita_tamagolem;
    private int vita_attuale = vita_tamagolem;
    private boolean morto = false;
    private Queue<Pietra> pietre = new LinkedList<>();

    public void assegnaPietre() { // assegna le pietre ad un golem
        for (int i = Costante.C0; i < numero_pietre_goelm; i++) {
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

    public static int getNumero_pietre_goelm() {
        return numero_pietre_goelm;
    }

    public static int getVita_tamagolem() {
        return vita_tamagolem;
    }

    public static void setNumero_pietre_goelm(int numero_pietre_goelm) {
        TamaGolem.numero_pietre_goelm = numero_pietre_goelm;
    }

    public static void setVita_tamagolem(int vita_tamagolem) {
        TamaGolem.vita_tamagolem = vita_tamagolem;
    }
}