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
        String name1 = scanner.next();

        System.out.println("Name von Spieler 2: ");
        String name2 = scanner.next();

        Spieler spieler1 = new Spieler(name1, 3);
        Spieler spieler2 = new Spieler(name2, 3);


        while (schachtel.hoelzchen() > 0) {
            spieler1.ziehen();
            if (schachtel.hoelzchen > 0) {
                spieler2.ziehen();
            }
        }

        // spiel gewinnt
    }
}
