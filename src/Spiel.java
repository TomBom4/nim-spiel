public class Spiel {

    Spieler spieler1, spieler2;
    Topf topf;
    Schachtel schachtel;

    Spiel(Spieler spieler1, Spieler spieler2) {

    }

    public static void main(String[] args) {


        new Spiel();

        Spieler spieler1 = new Spieler(this);
        Spieler spieler2 = new Spieler(this);

        Topf topf = new Topf();
        Schachtel schachtel;

        schachtel = spieler1.beginnen();

        while (schachtel.hoelzchen() > 0) {
            spieler1.ziehen();
            if (schachtel.hoelzchen > 0) {
                spieler2.ziehen();
            }
        }
    }
}
