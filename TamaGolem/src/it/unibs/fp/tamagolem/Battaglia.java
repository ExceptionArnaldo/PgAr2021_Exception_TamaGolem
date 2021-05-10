package it.unibs.fp.tamagolem;

public class Battaglia {

    private static Giocatore g1 = new Giocatore();
    private static Giocatore g2 = new Giocatore();

    public void setBattaglia() {
        // stampa intro alla battaglia

        // genera un nuovo equilibrio

        // impostare i valori generali

        g1.setNome("gg1");
        g2.setNome("gg2");

        // evocare i primi Golem: nome + pietre
        g1.creaGolem("");

        g2.creaGolem("");

    }

    public static void battaglia() {

        while (!g1.isSconfitto() && !g2.isSconfitto()) { // fino a quando i giocatori sono entrambi vivi

            while (g1.getGolem().getVita_attuale() != 0 && g2.getGolem().getVita_attuale() != 0) { // fino a quando i TamaGolem sono entrambi vivi

                Pietra pietra1 = g1.getGolem().getPietre().element(); // lancia le due pietre
                Pietra pietra2 = g2.getGolem().getPietre().element();
                int danno = Grafo.getMat_ad()[Equilibrio.posizioneNodo(pietra1)][Equilibrio.posizioneNodo(pietra2)]; // calcola interazione fra le pietre
                if (danno == 0) { // pietre dello stesso tipo, non succede nulla
                    g1.getGolem().ruotaPietre();
                    g2.getGolem().ruotaPietre();
                    continue;
                } else if (danno < 0) { // in base al risultato setta la vita del Golem perdente
                    g1.getGolem().setVita_attuale(g1.getGolem().getVita_attuale() + danno);
                } else {
                    g2.getGolem().setVita_attuale(g2.getGolem().getVita_attuale() - danno);
                }

                if (g1.getGolem().getVita_attuale() > 0 && g2.getGolem().getVita_attuale() > 0) { // se non e' morto nessun golem si stampa il danno
                    // stampa danno
                } else if (g1.getGolem().getVita_attuale() <= 0) { // altrimenti stampa chi e' morto
                    // golem 1 morto
                    g1.getGolem().setMorto(true);
                } else {
                    // golem 2 morto
                    g2.getGolem().setMorto(true);
                }
                // stampare stato attuale TamaGolem e giocatori
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

    public void fineBattaglia() {

        if (g1.isSconfitto()) { // stampa chi ha vinto
            // g2 vince
        } else {
            // g1 vince
        }
        // stampa l'equilibrio
    }
}