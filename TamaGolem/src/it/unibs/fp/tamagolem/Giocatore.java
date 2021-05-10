package it.unibs.fp.tamagolem;

public class Giocatore {

    private String nome;
    private boolean sconfitto = false;
    private TamaGolem golem = new TamaGolem(); // da sistemare

    public static int numeroGolem() {
        int n = Grafo.getNodi().size();
        return Math.round((float) (n - 1) * (n - 2) / (2 * TamaGolem.getNumero_pietre()));
    }

    public void caricamentoPietre(Pietra pietra) {
        golem.getPietre().add(pietra);
    }

    public void creaGolem(String nome){
        golem.setNome(nome);
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

    public TamaGolem getGolem() {
        return golem;
    }

    public void setGolem(TamaGolem golem) {
        this.golem = golem;
    }
}