import java.util.Scanner;

public class Spiel {

    Spieler erster, zweiter;
    Schachtel schachtel;

    Spiel(Spieler erster, Spieler zweiter, Schachtel schachtel) {
        this.erster = erster;
        this.zweiter = zweiter;
        this.schachtel = schachtel;
    }

    public static void main(String[] args) {
        // Spieler nach Namen fragen:
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name von Spieler 1: ");
        String name1 = scanner.next();

        System.out.println("Name von Spieler 2: ");
        String name2 = scanner.next();


        Spieler spieler1 = new Spieler(name1, 3);
        Spieler spieler2 = new Spieler(name2, 3);

        boolean spieler1Beginnt = true;

        while (spieler1.getAnzahlMuenzen() > 0 && spieler2.getAnzahlMuenzen() > 0) {
            System.out.println(spieler1.getName() + ": " + spieler1.getAnzahlMuenzen() + " Münzen\t\t" +
                    spieler2.getName() + ": " + spieler2.getAnzahlMuenzen() + " Münzen");

            if (spieler1Beginnt) {
                System.out.println(spieler1.getName() + " beginnt.");
                spielen(spieler1, spieler2);
            } else {
                System.out.println(spieler2.getName() + " beginnt.");
                spielen(spieler2, spieler1);
            }

            spieler1Beginnt = !spieler1Beginnt;
        }

        if (spieler1.getAnzahlMuenzen() > 0) {
            System.out.printf(spieler1.getName() + " hat das Spiel gewonnen!");
        } else {
            System.out.printf(spieler2.getName() + " hat das Spiel gewonnen!");
        }

        System.out.println();
    }

    public static void spielen(Spieler erster, Spieler zweiter) {
        Schachtel schachtel = zweiter.hoelzchenLegen();
        new Spiel(erster, zweiter, schachtel).spielen();
    }

    public Schachtel getSchachtel() {
        return schachtel;
    }

    public void spielen() {
        boolean turn1 = true;

        while(schachtel.getHoelzchen() > 0)
        {
            System.out.println("Es sind " + schachtel.getHoelzchen() + " Hölzchen in der Schachtel.");

            int n;
            do {
                if(turn1) {
                    n = erster.ziehen();
                } else {
                    n = zweiter.ziehen();
                }
            } while (n < 1 || n > 3 );

            schachtel.hoelzchenZiehen(n);

            turn1 = !turn1;
        }

        if(turn1) {
            System.out.println(zweiter.getName() + " hat das letzte Hölzchen gezogen und damit diese Runde verloren.");
            zweiter.muenzeGeben(erster);
        } else {
            System.out.println(erster.getName() + " hat das letzte Hölzchen gezogen und damit diese Runde verloren.");
            erster.muenzeGeben(zweiter);
        }
    }

}
