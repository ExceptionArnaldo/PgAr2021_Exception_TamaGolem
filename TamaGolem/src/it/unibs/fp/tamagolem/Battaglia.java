package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.BelleStringhe;

public class Battaglia {

    private static Giocatore g1 = new Giocatore();
    private static Giocatore g2 = new Giocatore();

    public void setBattaglia() {
        Utente.stampa(Costante.MSG_BENVENUTI);
        Utente.stampa(BelleStringhe.stampaStringaCorniceCentrato(Costante.MSG_INTRO));

        Utente.stampa(Costante.MSG_EQUILIBRIO);
        Equilibrio.setup(); // genera un nuovo equilibrio

        Utente.nomeAlievo(g1, Costante.GIOCATORE1); // Nomi giocatori
        Utente.nomeAlievo(g2, Costante.GIOCATORE2);

        g1.evocaGolem(); // evocare i primi Golem: nome + pietre
        g2.evocaGolem();
    }

    public static void battaglia() {

        while (!g1.getSconfitto() && !g2.getSconfitto()) { // fino a quando i giocatori sono entrambi vivi

            while (g1.getGolem().getVita_attuale() > Costante.C0 && g2.getGolem().getVita_attuale() > Costante.C0) { // fino a quando i TamaGolem sono entrambi vivi

                if (danno())
                    verificaMorte();

                g1.getGolem().ruotaPietre();
                g2.getGolem().ruotaPietre();
            }

            if (g1.getGolem().isMorto()) { // creazione del nuovo TamaGolem
                // evocazione per g1
            } else {
                // evocazione per g2
            }
        }
    }

    private static boolean danno() {

        Pietra pietra1 = g1.getGolem().getPietre().element(); // lancia le due pietre
        Pietra pietra2 = g2.getGolem().getPietre().element();
        int danno = Grafo.getMat_ad()[Equilibrio.posizioneNodo(pietra1)][Equilibrio.posizioneNodo(pietra2)]; // calcola interazione fra le pietre
        if (danno == Costante.C0) { // pietre dello stesso tipo, non succede nulla
            return false;
        } else if (danno < Costante.C0) { // in base al risultato setta la vita del Golem perdente
            g1.getGolem().setVita_attuale(g1.getGolem().getVita_attuale() + danno);
        } else {
            g2.getGolem().setVita_attuale(g2.getGolem().getVita_attuale() - danno);
        }
        return true;
    }

    private static void verificaMorte() {

        if (g1.getGolem().getVita_attuale() > Costante.C0 && g2.getGolem().getVita_attuale() > Costante.C0) { // se non e' morto nessun golem si stampa il danno
            // stampa danno
        } else if (g1.getGolem().getVita_attuale() <= Costante.C0) { // altrimenti stampa chi e' morto
            // golem 1 morto
            g1.getGolem().setMorto(true);
        } else {
            // golem 2 morto
            g2.getGolem().setMorto(true);
        }
        // stampare stato attuale TamaGolem e giocatori
    }

    public void fineBattaglia() {

        if (g1.isSconfitto()) { // stampa chi ha vinto
            // g2 vince
        } else {
            // g1 vince
        }
        // stampa l'equilibrio
    }
}