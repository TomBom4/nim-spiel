import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Spieler {

    public final String name;
    public final boolean computer;

    public int anzahlMuenzen;

    public Spieler(String name, int anzahlMuenzen) {
        this.anzahlMuenzen = anzahlMuenzen;
        if (name.equalsIgnoreCase("computer")) {
            computer = true;
            this.name = "COMPUTER";
        } else {
            this.name = name;
            computer = false;
        }
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

    public int ziehen(int hoelzchen) {
        if (computer) {
            int n;
            if (hoelzchen > 5) {
                if ((hoelzchen + 3) % 4 == 0)
                    n = 1;
                else if (hoelzchen % 4 == 0)
                    n = 3;
                else
                    n = 2;
            } else {
                if (hoelzchen == 4)
                    n = 3;
                else if (hoelzchen == 3)
                    n = 2;
                else {
                    n = 1;
                }
            }

            return n;
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.println(getName() + ": Wie viele Hölzchen ziehst du? (1-3)");
            int n = 0;
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {}
            return n;
        }
    }

    public Schachtel hoelzchenLegen () {
        if (computer) {
            Random random = new Random();
            int n = random.nextInt(7);
            return new Schachtel(13 + n * 4);
        } else {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.println(getName() + ": Wie viele Hölzchen legst du in die Schachtel? (10-40)");
            n = scanner.nextInt();
        } while (n < 10 || n > 40);

        return new Schachtel(n);
        }
    }


}
