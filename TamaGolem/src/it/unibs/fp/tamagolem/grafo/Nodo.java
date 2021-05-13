package it.unibs.fp.tamagolem.grafo;

import java.util.ArrayList;

public class Nodo {

    private String nome;

    public Nodo(String nome) {
        this.nome = nome;
    }

    // metodo che controlla l'esistenza di un nodo
    public boolean esisteNodo(ArrayList<Nodo> nodi) {

        for (Nodo nodo : nodi) {
            if (nodo.getNome().equals(this.nome)) return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }
}