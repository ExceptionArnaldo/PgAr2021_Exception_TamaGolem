package it.unibs.fp.tamagolem;

import java.util.ArrayList;

public class Nodo {

    private String nome;

    public Nodo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // metodo che controlla l'esistenza di un nodo
    public boolean esisteNodo(ArrayList<Nodo> nodi) {

        for (int i = 0; i < nodi.size(); i++) {
            if (nodi.get(i).getNome().equals(this.nome)) return true;
        }
        return false;
    }
}