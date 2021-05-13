package it.unibs.fp.tamagolem;

public class Main {

    public static void main(String[] args) {

        //Battaglia.setBattaglia();


        Equilibrio.setup();

        /*System.out.println("Numero elementi " + Grafo.getNodi().size());
        System.out.println("Numero Golem " + Giocatore.getNumero_golem());
        System.out.println("Numero pietre Golem " + TamaGolem.getNumero_pietre());

        Pietra.riempiScorta();
        System.out.println("Pietre scorta comune" + Pietra.getScorta_comune());
        System.out.println("TEST");
        Pietra.getScorta_comune().forEach((key, value) -> System.out.println(key + " " + value));*/


        /*Giocatore g = new Giocatore();
        g.evocaGolem();*/

        //System.out.println("Pietre scorta comune" + Pietra.getScorta_comune());

        MenuG.menuPrincipale();
        //Utente.stampaEquilibrio();

        /*Giocatore g = new Giocatore();
        g.evocaGolem();

        System.out.println("Pietre scorta comune" + Pietra.getScorta_comune());
         */
    }
}