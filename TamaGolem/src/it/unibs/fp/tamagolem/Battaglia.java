package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;

public class Battaglia {

    private static Giocatore g1;
    private static Giocatore g2;

    public static void setBattaglia() {
        Utente.stampa(Costante.MSG_BENVENUTI);
        Utente.stampa(BelleStringhe.stampaStringaCorniceCentrato(Costante.MSG_INTRO));

        Utente.stampa(Costante.MSG_EQUILIBRIO);
        Equilibrio.setup(); // genera un nuovo equilibrio

        g1 = new Giocatore();
        g2 = new Giocatore();

        Utente.nomeAlievo(g1, Costante.GIOCATORE1); // Nomi giocatori
        Utente.nomeAlievo(g2, Costante.GIOCATORE2);

        g1.evocaGolem(); // evocare i primi Golem: nome + pietre
        g2.evocaGolem();

        battaglia(); // inizia lo scontro
    }

    public static void battaglia() {

        while (!g1.getSconfitto() && !g2.getSconfitto()) { // fino a quando i giocatori sono entrambi vivi
            Utente.stampa(Costante.MSG_INIZIO_BATTAGLIA, g1.getGolem().getNome(), g2.getGolem().getNome());

            while (g1.getGolem().getVita_attuale() > Costante.C0 && g2.getGolem().getVita_attuale() > Costante.C0) { // fino a quando i TamaGolem sono entrambi vivi

                if (danno())
                    verificaMorte();
                else {
                    Utente.stampa(Costante.MSG_RUOTA_PIETRA);
                    g1.getGolem().ruotaPietre();
                    g2.getGolem().ruotaPietre();
                }
            }

            if (g1.getGolem().isMorto()) { // creazione del nuovo TamaGolem
                g1.evocaGolem();
            } else {
                g2.evocaGolem();
            }
        }
        fineBattaglia();
    }

    private static boolean danno() {


        Pietra pietra1 = lancioPietra(g1); // lancia le due pietre
        Pietra pietra2 = lancioPietra(g2);
        int danno = Grafo.getMat_ad()[Equilibrio.posizioneNodo(pietra1)][Equilibrio.posizioneNodo(pietra2)]; // calcola interazione fra le pietre
        if (danno == Costante.C0) { // pietre dello stesso tipo, non succede nulla
            Utente.stampa(Costante.MSG_PIETRA_UGUALE);
            return false;
        } else if (danno < Costante.C0) { // in base al risultato setta la vita del Golem perdente
            infliggiDanno(g2, g1, danno);
        } else {
            infliggiDanno(g1, g2, danno);
        }
        return true;
    }

    private static void verificaMorte() {

        if (g1.getGolem().getVita_attuale() > Costante.C0 && g2.getGolem().getVita_attuale() > Costante.C0) { // se non e' morto nessun golem si stampa il danno
            Utente.stampa(Costante.MSG_VITA_RIMANENTE, g1.getGolem().getNome(), String.valueOf(g1.getGolem().getVita_attuale()));
            Utente.stampa(Costante.MSG_VITA_RIMANENTE, g2.getGolem().getNome(), String.valueOf(g2.getGolem().getVita_attuale()));
        } else if (g1.getGolem().getVita_attuale() <= Costante.C0) { // altrimenti stampa chi e' morto
            ruotaPietraNonMorto(g2, g1);
        } else {
            ruotaPietraNonMorto(g1, g2);
        }
    }

    public static Pietra lancioPietra(Giocatore g) {
        Utente.stampa(Costante.MSG_PIETRA_SCAGLIATA, g.getGolem().getNome(), g.getGolem().getPietre().element().toString());
        return g.getGolem().getPietre().element();
    }

    public static void infliggiDanno(Giocatore vincente, Giocatore perdente, int danno) {
        Utente.stampa(Costante.MSG_PIETRA_SUPEREFFICACE, vincente.getGolem().getPietre().element().toString(), perdente.getGolem().getPietre().element().toString());
        perdente.getGolem().setVita_attuale(perdente.getGolem().getVita_attuale() - Math.abs(danno));
    }

    public static void ruotaPietraNonMorto(Giocatore vincente, Giocatore perdente) {
        Utente.stampa(Costante.MSG_MORTE_GOLEM, perdente.getGolem().getNome(), vincente.getGolem().getNome());
        vincente.getGolem().ruotaPietre();
        perdente.getGolem().setMorto(true);
    }

    public static void fineBattaglia() {

        if (g1.isSconfitto()) { // stampa chi ha vinto, stampa equilibrio e chiedi rivincita
            StampaVincitoreChiedeRivincita(g2, g1);
        } else {
            StampaVincitoreChiedeRivincita(g1, g2);
        }
    }

    public static void StampaVincitoreChiedeRivincita(Giocatore vincente, Giocatore perdente) {
        Utente.stampa(Costante.MSG_VINCITORE, vincente.getNome());
        Utente.stampa(Costante.MSG_RIVINDITA, perdente.getNome());

        Utente.stampaEquilibrio();

        if (InputDati.yesOrNo(Costante.RIVINDITA))
            setBattaglia();
        else
            Utente.stampa(Costante.MSG_SALUTO_FINALE);
    }
}