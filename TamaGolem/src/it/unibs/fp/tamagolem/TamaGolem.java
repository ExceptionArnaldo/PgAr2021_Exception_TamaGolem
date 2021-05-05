package it.unibs.fp.tamagolem;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class TamaGolem {

    private int numero_pietre; // boh

    private String nome;
    private int vita;
    private Queue<Pietra> pietre= new LinkedList<>();



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
