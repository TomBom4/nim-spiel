public class Spiel {
    public Spiel() {
        Spieler spieler1 = new Spieler(this);
        Spieler spieler2 = new Spieler(this);
        Topf topf = new Topf();
        Schachtel schachtel = new Schachtel();

        spieler1.beginnen();

        while (schachtel.hoelzchen() > 0) {
            spieler1.ziehen();
            if (schachtel.hoelzchen > 0) {
                spieler2.ziehen();
            }
    }
}
