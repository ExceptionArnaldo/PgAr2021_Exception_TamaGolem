package it.unibs.fp.tamagolem;

public class Giocatore {

    private String nome;
    private boolean sconfitto = false;
    private static int numero_golem = Math.round((float) (Grafo.getNodi().size() - 1) * (Grafo.getNodi().size() - 2) / (2 * TamaGolem.getNumero_pietre()));
    private int golem_evocati = 0;
    private TamaGolem golem = new TamaGolem(); // da sistemare

    public static int getNumero_golem() {
        return numero_golem;
    }

    public void caricamentoPietre(Pietra pietra) {
        golem.getPietre().add(pietra);
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

    public boolean getSconfitto(){
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

    public void creaGolem() {
        setGolem_evocati(getGolem_evocati() + 1);
        if (getGolem_evocati() > Giocatore.getNumero_golem()) {
            setSconfitto(true);
            return;
        }
        //getGolem().setNome(nome_golem);
        getGolem().setVita_attuale(getGolem().getVita_totale());
        for (int i = 0; i < getGolem().getNumero_pietre(); i++) {
            //scelta pietra utente
            //g.caricamentoPietre(pietra);
            //g.getGolem().getPietre().element().usaPietra(pietra.toString());
        }
    }
}