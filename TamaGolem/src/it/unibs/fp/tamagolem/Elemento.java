package it.unibs.fp.tamagolem;

public enum Elemento {

    ROCCIA(0),
    FUOCO(1),
    ARIA(2),
    ACQUA(3),
    ERBA(4),
    MONTAGNA(5),
    TENEBRA(6),
    SPETTRO(7),
    SCINTILLA(8),
    ACCIAIO(9);

    private int id;

    Elemento(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Elemento getElemento(int indice) {

        for (Elemento el : values()) {
            if (el.id == indice) return el;
        }
        return null;
    }

    public static String elementoPerId(int indice) {

        for (Elemento el : values()) {
            if (el.id == indice) return el.name();
        }
        return null;
    }
}