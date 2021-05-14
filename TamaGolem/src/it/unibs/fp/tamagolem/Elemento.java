package it.unibs.fp.tamagolem;

public enum Elemento {

    // MEME ?!
    DOGE(0),
    KARMIT(1),
    PEPPA(2),
    SPIDERMAN(3),
    ENRICOPAPI(4),
    PIPPOBAUDO(5),
    MEMEMAN(6),
    PAINHAROLD(7),
    CLOWN(8),
    ARNALDO(9);

    private int id;

    Elemento(int id) {
        this.id = id;
    }

    public static Elemento getElemento(String tipo) { // prende la stringa con il nome dell'elemento e restituisce il suo tipo Elemento

        for (Elemento el : values()) {
            if (el.name().equals(tipo)) return el;
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