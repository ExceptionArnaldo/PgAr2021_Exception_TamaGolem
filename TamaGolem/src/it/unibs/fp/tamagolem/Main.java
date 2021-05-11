package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.NumeriCasuali;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Equilibrio.setup();

        System.out.println("Numero elementi " + Grafo.getNodi().size());
        System.out.println("Numero Golem " + Giocatore.numeroGolem());
        System.out.println("Numero pietre Golem " + TamaGolem.getNumero_pietre());

        Pietra.riempiScorta();
        System.out.println("Pietre scorta comune" + Pietra.getScorta_comune());
        System.out.println("TEST");
        Pietra.getScorta_comune().forEach((key, value) -> System.out.println(key + " " + value));

        TamaGolem g = new TamaGolem();
        g.assegnaPietre();
    }
}
