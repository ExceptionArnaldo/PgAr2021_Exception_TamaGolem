package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.tamagolem.grafica.GolemGUI;
import it.unibs.fp.tamagolem.grafica.MenuGUI;
import it.unibs.fp.tamagolem.grafo.Grafo;
import it.unibs.fp.tamagolem.utility.Costante;
import it.unibs.fp.tamagolem.utility.Utente;

import java.awt.*;

public class Giocatore {

    private String nome;
    private boolean sconfitto = false;
        private static int numero_golem = (int) Math.ceil((float) (Grafo.getNodi().size() - Costante.C1) * (Grafo.getNodi().size() - Costante.C2) / (Costante.C2 * TamaGolem.getNumero_pietre()));
    private int golem_evocati = Costante.C0;
    private TamaGolem golem;

    public void evocaGolem() { // se sono ancora disponibili evocazioni si crea il golem, in caso contrario il giocatore viene sconfitto
        setGolem_evocati(getGolem_evocati() + Costante.C1); // incrementa il numero di golem evocati
        if (getGolem_evocati() > Giocatore.getNumero_golem()) { // se non si possono creare altri golem il giocatore perde
            setSconfitto(true);
        } else {
            //MenuGUI.menuPrincipale();
            GolemGUI.sceltaGolem(this);

            golem = new TamaGolem();

            //golem.setNome(GolemGUI.getNomeGolem());

            /*golem.setNome(InputDati.leggiStringaNonVuota(getNome() + Costante.MSG_NOME_GOLEM));
            golem.setVita_attuale(getGolem().getVita_totale());*/

            /*Utente.stampa(String.format(Costante.MSG_PREPARE_GOLEM, TamaGolem.getNumero_pietre()));
            golem.assegnaPietre(); // si assegnano le pietre dalla scorta comune
            Utente.stampa(BelleStringhe.incornicia(String.format(Costante.MSG_GOLEM_CREATO, golem.getNome())));

            Utente.stampaGolemBrutto();
            InputDati.isInvioPremutoEPulisciConsole(Costante.MSG_PREMI_PER_CONTINUARE, Costante.MSG_NASCONDI_AVVERSARIO);*/
        }
    }

    public static int getNumero_golem() {
        return numero_golem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isSconfitto() {
        return sconfitto;
    }

    public void setSconfitto(boolean sconfitto) {
        this.sconfitto = sconfitto;
    }

    public boolean getSconfitto() {
        return this.sconfitto;
    }

    public TamaGolem getGolem() {
        return golem;
    }

    public void setGolem(TamaGolem golem) {
        this.golem = golem;
    }

    public int getGolem_evocati() {
        return golem_evocati;
    }

    public void setGolem_evocati(int golem_evocati) {
        this.golem_evocati = golem_evocati;
    }
}