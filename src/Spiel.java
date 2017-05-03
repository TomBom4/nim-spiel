import java.util.Scanner;

public class Spiel {

    Spieler spieler1, spieler2;
    Schachtel schachtel;

    Spiel(Spieler spieler1, Spieler spieler2) {

    }

    public static void main(String[] args) {

        // Spieler nach Namen fragen:
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name von Spieler 1: ");

        Spieler spieler1 = new Spieler();
        Spieler spieler2 = new Spieler();



        schachtel = spieler1.beginnen();

        while (schachtel.hoelzchen() > 0) {
            spieler1.ziehen();
            if (schachtel.hoelzchen > 0) {
                spieler2.ziehen();
            }
        }

        // spiel gewinnt
    }
}
