package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyTime;
import it.unibs.fp.tamagolem.grafo.Grafo;
import it.unibs.fp.tamagolem.utility.Costante;
import it.unibs.fp.tamagolem.utility.Utente;

public class Battaglia {

    private static Giocatore g1;
    private static Giocatore g2;
    static int count = Costante.C0;

    public static void setBattaglia() {
        Utente.stampa(BelleStringhe.stampaStringaCorniceCentrato(Costante.MSG_BENVENUTI));
        InputDati.isInvioPremutoEPulisciConsole(Costante.MSG_PREMI_PER_CONTINUARE, Costante.NON_PROPRIO_QUALSIASI);

        Utente.stampa(BelleStringhe.stampaStringaCorniceCentrato(Costante.MSG_INTRO));
        InputDati.isInvioPremutoEPulisciConsole(Costante.MSG_PREMI_PER_CONTINUARE, Costante.MSG_GIA_LO_SAI);

        Equilibrio.setup(); // genera un nuovo equilibrio
        Utente.stampa(BelleStringhe.stampaStringaCorniceCentrato(Costante.MSG_EQUILIBRIO));
        MyTime.wait(Costante.C2); // in ogni videogioco che si rispetti serve un po' di tempo di caricamento XD

        g1 = new Giocatore();
        g2 = new Giocatore();

        Utente.nomeAlievo(g1, Costante.GIOCATORE1); // Nomi giocatori
        Utente.nomeAlievo(g2, Costante.GIOCATORE2);

        g1.evocaGolem(); // evocare i primi Golem: nome + pietre
        g2.evocaGolem();

        battaglia(); // inizia lo scontro
    }

    private static void battaglia() {

        while (!g1.getSconfitto() && !g2.getSconfitto()) { // fino a quando i giocatori sono entrambi vivi
            Utente.stampa(BelleStringhe.stampaStringaCorniceCentrato(String.format(Costante.MSG_INIZIO_BATTAGLIA, g1.getGolem().getNome(), g2.getGolem().getNome())));
            inizioBattaglia(); // ormai piu' che un gioco sembra un meme

            while (g1.getGolem().getVita_attuale() > Costante.C0 && g2.getGolem().getVita_attuale() > Costante.C0) { // fino a quando i TamaGolem sono entrambi vivi

                if (danno())            // se il danno e' diverso da zero (true) si verifica l'eventuale morte del golem
                    verificaMorte();
                else {
                    ruotaTuttePietre();
                }
                MyTime.wait(Costante.C2);
            }

            if (g1.getGolem().isMorto()) { // creazione del nuovo TamaGolem
                g1.evocaGolem();
            } else {
                g2.evocaGolem();
            }
        }
        InputDati.isInvioPremutoEPulisciConsole(Costante.MSG_BRUTTA_FINE, Costante.MSG_GIA_LO_SAI_PT2);
        fineBattaglia();
    }

    private static void ruotaTuttePietre() { // ruota le pietre dei Golem
        Utente.stampa(BelleStringhe.stampaStringaCorniceCentrato(Costante.MSG_RUOTA_PIETRA));
        g1.getGolem().ruotaPietre();
        g2.getGolem().ruotaPietre();
    }

    private static boolean danno() { // assegna il danno al golem se vengono utilizzate pietre di tipo diverso

        Pietra pietra1 = lancioPietra(g1); // lancia le due pietre
        Pietra pietra2 = lancioPietra(g2);
        int danno = Grafo.getMat_ad()[Equilibrio.posizioneNodo(pietra1)][Equilibrio.posizioneNodo(pietra2)]; // calcola interazione fra le pietre e restituisce il danno
        if (danno == Costante.C0) { // pietre dello stesso tipo, non succede nulla
            Utente.stampa(Costante.MSG_PIETRA_UGUALE);
            count++;
            controllaUguaglianzaPietre(); // controllo ripetizione pietre
            return false;
        } else if (danno < Costante.C0) { // in base al segno del danno si modifica la vita del Golem perdente
            infliggiDanno(g2, g1, danno);
        } else {
            infliggiDanno(g1, g2, danno);
        }
        return true;
    }

    private static void verificaMorte() {

        if (g1.getGolem().getVita_attuale() > Costante.C0 && g2.getGolem().getVita_attuale() > Costante.C0) { // se non e' morto nessun golem si stampa il danno
            Utente.stampa(String.format(Costante.MSG_VITA_RIMANENTE, g1.getGolem().getNome(), g1.getGolem().getVita_attuale()));
            Utente.stampa(String.format(Costante.MSG_VITA_RIMANENTE, g2.getGolem().getNome(), g2.getGolem().getVita_attuale()));
            ruotaTuttePietre(); // se non e' morto nessuno bisogna ruotare tutte le pietre
        } else if (g1.getGolem().getVita_attuale() <= Costante.C0) { // altrimenti stampa chi e' morto e ruota chi non e' morto
            ruotaPietraNonMorto(g2, g1);
        } else {
            ruotaPietraNonMorto(g1, g2);
        }
    }

    private static Pietra lancioPietra(Giocatore g) { // stampa la pietra utilizzata e la restituisce
        Utente.stampa(String.format(Costante.MSG_PIETRA_SCAGLIATA, g.getGolem().getNome(), g.getGolem().getPietre().element().getTipo().toString()));
        return g.getGolem().getPietre().element();
    }

    private static void infliggiDanno(Giocatore vincente, Giocatore perdente, int danno) { // decrementa la vita del golem perdente
        count = Costante.C0;
        Utente.stampa(BelleStringhe.stampaStringCentrato(String.format(Costante.MSG_PIETRA_SUPEREFFICACE, vincente.getGolem().getPietre().element().getTipo().toString(), perdente.getGolem().getPietre().element().getTipo().toString())));
        perdente.getGolem().setVita_attuale(perdente.getGolem().getVita_attuale() - Math.abs(danno));
    }

    private static void ruotaPietraNonMorto(Giocatore vincente, Giocatore perdente) { // ruota le pietre del golem vivo e setta il goelm morto come morto
        Utente.stampa(String.format(Costante.MSG_MORTE_GOLEM, perdente.getGolem().getNome(), vincente.getGolem().getNome()));
        Utente.stampa(System.lineSeparator());

        vincente.getGolem().ruotaPietre();
        perdente.getGolem().setMorto(true);
    }

    private static void fineBattaglia() {

        if (g1.isSconfitto()) { // stampa chi ha vinto, stampa equilibrio e chiede rivincita
            StampaVincitoreChiedeRivincita(g2, g1);
        } else {
            StampaVincitoreChiedeRivincita(g1, g2);
        }
    }

    private static void StampaVincitoreChiedeRivincita(Giocatore vincente, Giocatore perdente) {
        Utente.stampa(BelleStringhe.stampaStringaCorniceCentrato(String.format(Costante.MSG_VINCITORE, vincente.getNome())));
        Utente.stampa(String.format(Costante.MSG_RIVINDITA, perdente.getNome()));

        Utente.stampa(BelleStringhe.stampaStringaCorniceCentrato(Costante.MSG_EQUILIBRIO_IN_CORSO));
        MyTime.wait(Costante.C1);
        Utente.stampaEquilibrio();

        if (InputDati.yesOrNo(Costante.RIVINDITA)) { // chiede di rigiocare
            InputDati.pulisciConsole();
            setBattaglia();
        } else {
            Utente.stampa(Costante.MSG_SALUTO_FINALE); // saluto finale e chiusura programma
            System.exit(0);
        }
    }

    private static void controllaUguaglianzaPietre() {
        if (count > TamaGolem.getNumero_pietre_goelm()) {
            Utente.stampa(Costante.MSG_GIOCATORI_INCOMPETENTI);
            System.exit(0);
        }
    }

    private static void inizioBattaglia() {
        int i = Costante.C0;
        while (!InputDati.yesOrNo(BelleStringhe.rigaIsolata(Costante.MSG_START))) {
            i++;
            if (i > Costante.C2) {
                Utente.stampa(Costante.MSG_GIOCO_IMPAZZIENTE);
                MyTime.wait(Costante.C2);
                return;
            }
        }
    }
}