import java.util.InputMismatchException;
import java.util.Scanner;

public class Spieler {

    public String name;

    public int anzahlMuenzen;

    public Spieler(String name, int anzahlMuenzen) {
        this.anzahlMuenzen = anzahlMuenzen;
        this.name = name;
    }

    public void setMuenzen(int n) {
        this.anzahlMuenzen = n;
    }

    public int getAnzahlMuenzen() {
        return anzahlMuenzen;
    }

    public String getName() {
        return name;
    }

    public void muenzenHinzufuegen(int n) {
        this.anzahlMuenzen += n;
    }

    public void muenzeGeben(Spieler spieler) {
        muenzenHinzufuegen(-1);
        spieler.muenzenHinzufuegen(1);
    }

    public int ziehen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(getName() + ": Wie viele Hölzchen ziehst du? (1-3)");
        int n = 0;
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {

        }
        return n;
    }

    public Schachtel hoelzchenLegen () {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.println(getName() + ": Wie viele Hölzchen legst du in die Schachtel? (10-40)");
            n = scanner.nextInt();
        } while (n < 10 || n > 40);

        return new Schachtel(n);
    }


}
