
public class Spieler {

    public final String name;

    public int anzahlMuenzen;

    public Spieler(String name, int anzahlMuenzen) {
        this.anzahlMuenzen = anzahlMuenzen;
        this.name = name;
    }

    public void setMuenzen(int n) {
        this.anzahlMuenzen = n;
    }

    public void muenzenHinzufuegen(int n) {
        this.anzahlMuenzen += n;
    }

    public void ziehen(Spiel spiel) {
        // TODO: 1. Spieler nach Anzahl der Hölzchen (1 - 3) fragen
        int n = 1;

        Spiel.getSchachtel().ziehen();
        Spiel.letzterSpieler = this;
    }

    public void beginnen() {
        // TODO: 1. Spieler nach Anzahl der Hölzchen (10 - 40) fragen
        int n = 10;
        Schachtel.hoelzchenSetzen(n);
    }


}
