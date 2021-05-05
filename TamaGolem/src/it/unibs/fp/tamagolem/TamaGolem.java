package it.unibs.fp.tamagolem;

import java.util.*;

public class TamaGolem {

    private static int numero_pietre = (Grafo.getNodi().size() + 1) / 3 + 1;
    private String nome;
    private int vita;
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

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public Queue<Pietra> getPietre() {
        return pietre;
    }

    public void setPietre(Queue<Pietra> pietre) {
        this.pietre = pietre;
    }
}
