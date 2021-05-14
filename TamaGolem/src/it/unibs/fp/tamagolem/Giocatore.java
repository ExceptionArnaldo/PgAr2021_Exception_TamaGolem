package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.tamagolem.utility.Costante;
import it.unibs.fp.tamagolem.utility.Utente;

public class Giocatore {

    private String nome;
    private boolean sconfitto = false;
    private int golem_evocati = Costante.C0;
    private TamaGolem golem;

    public void evocaGolem() { // se sono ancora disponibili evocazioni si crea il golem, in caso contrario il giocatore viene sconfitto
        setGolem_evocati(getGolem_evocati() + Costante.C1); // incrementa il numero di golem evocati
        if (getGolem_evocati() > Costante.NUMERO_GOLEM) { // se non si possono creare altri golem il giocatore perde
            setSconfitto(true);
        } else {
            golem = new TamaGolem();
            golem.setNome(InputDati.leggiStringaNonVuota(getNome() + Costante.MSG_NOME_GOLEM));
            golem.setVita_attuale(Costante.VITA_TAMAGOLEM);

            Utente.stampa(String.format(Costante.MSG_PREPARE_GOLEM, Costante.NUMERO_PIETRE_GOLEM));
            golem.assegnaPietre(); // si assegnano le pietre dalla scorta comune
            Utente.stampa(BelleStringhe.incornicia(String.format(Costante.MSG_GOLEM_CREATO, golem.getNome())));

            Utente.stampaGolemBrutto();
            InputDati.isInvioPremutoEPulisciConsole(Costante.MSG_NASCONDI_AVVERSARIO, Costante.MSG_PREMI_PER_CONTINUARE);
        }
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

    public int getGolem_evocati() {
        return golem_evocati;
    }

    public void setGolem_evocati(int golem_evocati) {
        this.golem_evocati = golem_evocati;
    }
}