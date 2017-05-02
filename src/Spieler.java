import java.util.Scanner;

public class Spieler {

    public int anzahlMuenzen;

    public Spieler() {
        anzahlMuenzen = 0;
    }

    public void ziehen(Spiel spiel) {
        //        Scanner scanner = new Scanner(System.in);
        // TODO: 1. Spieler nach Anzahl der Hölzchen fragen

//        Schachtel.hoelzchenSetzen()


        Spiel.getSchachtel().ziehen();
        Spiel.letzterSpieler = this;
    }

    public void beginnen() {

    }


}
