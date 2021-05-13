package it.unibs.fp.tamagolem.utility;

import it.unibs.fp.tamagolem.grafo.Grafo;

public class Costante {

    // Costanti numeriche
    public static final int C0 = 0;
    public static final int C1 = 1;
    public static final int C2 = 2;
    public static final int C3 = 3;

    // formule
    public static final int NUMERO_PIETRE_GOLEM = (int) Math.ceil((float) (Grafo.getNodi().size() + C1) / C3 + C1);
    public static final int NUMERO_GOLEM = (int) Math.ceil((float) (Grafo.getNodi().size() - C1) * (Grafo.getNodi().size() - C2) / (C2 * NUMERO_PIETRE_GOLEM));
    public static final int NUMERO_PIETRE_PER_TIPO = (int) Math.ceil((float) Costante.C2 * NUMERO_PIETRE_GOLEM * Costante.NUMERO_GOLEM / Grafo.getNodi().size());
    public static final int VITA_TAMAGOLEM = 10 * Grafo.getNodi().size();

    // Costanti livello difficolta'
    public static final int MAX_FACILE = 5;
    public static final int MAX_MEDIO = 8;

    public static final String MSG_FACILE = "Facile";
    public static final String MSG_MEDIO = "Medio";
    public static final String MSG_DIFFICILE = "Difficile";
    public static final String MSG_SCELTA_DIFFICOLTA = "Scelta difficolta'";

    // Messaggi vari
    public static final String MSG_BENVENUTI = "BENVENUTI IN TAMAGOLEM ! ! !";
    public static final String MSG_INTRO = "Il delicato Equilibrio del Mondo si basa da sempre sull’interazione fra le diverse forze naturali, dalle più miti alle più distruttive.\n Ogni elemento in natura ha i suoi punti forti e le sue debolezze, caratteristiche che mantengono il nostro Universo stabile e sicuro.\n" +
            " Da migliaia di anni, L’Accademia studia le tecniche per governare tali elementi: utilizzando alcune pietre particolari e dandole in pasto a strane creature denominate TamaGolem,\n infatti, è possibile conservare il potere degli elementi per liberarlo al bisogno.\n" +
            " Gli allievi dell’Accademia, per questo motivo, sono soliti sfidarsi in combattimenti clandestini fra TamaGolem.\n L’abilità dei combattenti, in questo caso, sta nella scelta delle giuste Pietre degli Elementi in modo che lo scontro abbia il risultato sperato.\n Tale scelta non è scontata, poiché gli Equilibri del Mondo sono mutevoli, e possono modificarsi radicalmente da una battaglia all’altra.\n" +
            " Solamente il TamaGolem che resiste fino alla fine decreta la vittoria del proprio combattente.";

    public static final String MSG_EQUILIBRIO = "Generazione dell' equilibrio...";

    public static final String GIOCATORE1 = "Primo Allievo";
    public static final String GIOCATORE2 = "Secondo Allievo";
    public static final String MSG_SCELTA_NOME = "%s, scegli il tuo nome: ";

    public static final String MSG_ASSEGNA_PIETRE = "Scegli la pietra per il tuo TamaGolem";
    public static final String MSG_NOME_GOLEM = " scegli il nome del tuo nuovo TamaGolem: ";
    public static final String MSG_GOLEM_CREATO = "Creazione del TamaGolem avvenuta con successo.\n%s e' pronto alla battaglia ! ! !";
    public static final String MSG_INIZIO_BATTAGLIA = "%s e %s sono pronti alla battaglia ! ! !\n";
    public static final String MSG_PIETRA_SCAGLIATA = "%s scaglia la pietra di tipo %s";
    public static final String MSG_PIETRA_SUPEREFFICACE = "Altro che Pokemon, l'elemento %s e' superefficace sull'elemento %s";
    public static final String MSG_PIETRA_UGUALE = "OH NO, le pietre dello stesso elemento si annullano a vicenda";
    public static final String MSG_RUOTA_PIETRA = "I TamaGolem si stanno preparando alla prossima mossa!";
    public static final String MSG_MORTE_GOLEM = "%s era proprio scarso, %s gli ha rotto il ****\n\t\t༼▀̿̿Ĺ̯̿̿▀̿ ̿༽=ε/̵͇̿̿/’̿’̿ ̿ ̿̿ ̿̿ ̿̿༼ ຈل͜ຈ༽";
    public static final String MSG_VITA_RIMANENTE = "Al Tamagolem %s rimangono %s HP";
    public static final String MSG_VINCITORE = "CONGRATULAZIONI %s, SEI IL VINCITORE DI QUESTA INCREDIBILE BATTAGLIA ! ! !";
    public static final String MSG_RIVINDITA = "%s sei un alievo abbastanza scarso, ma puoi rifarti in una NUOVA INCREDIBILE BATTAGLIA ! ! !";
    public static final String RIVINDITA = "Volete giocare ancora? ";
    public static final String MSG_SALUTO_FINALE = "Arrivederci allievi, alla prossima!";
    public static final String MSG_PREPARE_GOLEM = "Prepare il tuo TamaGolem alla battaglia, fagli ingurgitare %d pietre";
    public static final String FRECCIA = " --> ";
    public static final String MSG_STAMPA_EQUILIBRIO = "%s --> %d --> %s\n";
    public static final String MSG_GIOCATORI_INCOMPETENTI = "Avete poca fantasia, andate a giocare a Pokemon, vi risultera' meno complicato!";

    public static final String[] GOLEM = {"(҂◡̀_◡́)ᕤ", "(ง︡'-'︠)ง", "ᕙ( ︡'︡益'︠)ง", "ヽ༼ ・ ل͜ ・ ༽ﾉ", "(╥︣﹏᷅╥)", "ヽ༼ ಠ益ಠ ༽ﾉ","ᕦ⊙෴⊙ᕤ", "ᕦ(◉෴◉)ᕥ","ᕙ(˵ ಠ ਊ ಠ ˵)ᕗ","༼ ºل͟º༼ ºل͟º༼ ºل͟º༼ ºل͟º ༽ºل͟º ༽ºل͟º ༽ºل͟º ༽"};

    // Messaggi per continuare
    public static final String MSG_PREMI_PER_CONTINUARE = "Premi qualsiasi tasto per continuare ";
    public static final String NON_PROPRIO_QUALSIASI = "Non proprio qualsiasi... ";
    public static final String MSG_GIA_LO_SAI = "Sai gia' quale non puoi premere ";
    public static final String MSG_NASCONDI_AVVERSARIO = "Nascondi le tue scelte all' avversario ";
    public static final String MSG_BRUTTA_FINE = "OPS, qualcuno ha fatto una brutta fine ";
    public static final String MSG_GIA_LO_SAI_PT2 = "Gia lo sai --> ";
}