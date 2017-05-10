import java.util.Scanner;

public class Spiel {

    Spieler spieler1, spieler2;
    Schachtel schachtel;

    Spiel(Spieler spieler1, Spieler spieler2, Schachtel schachtel) {
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
    }

    Spiel(Spieler spieler1, Spieler spieler2) {
        new Spiel(spieler1, spieler2, spieler1.hoelzchenLegen());
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
            Spiel spiel;

            if (spieler1Beginnt) {
                System.out.println(spieler1.getName() + " beginnt.");
                spiel = new Spiel(spieler1, spieler2);
            } else {
                System.out.println(spieler2.getName() + " beginnt.");
                spiel = new Spiel(spieler2, spieler2);
            }

            spiel.spielen();

            spieler1Beginnt = !spieler1Beginnt;
        }

        if (spieler1.getAnzahlMuenzen() > 0) {
            System.out.printf(spieler1.getName() + " hat gewonnen!");
        } else {
            System.out.printf(spieler2.getName() + " hat gewonnen!");
        }

        System.out.println(

                        "                         .-.\n" +
                        "                         '-'\n" +
                        "                        //\n" +
                        "               _..---._/|\n" +
                        "             .' .\"     '-.\n" +
                        "            /__/          \\      *\n" +
                        "           ====_____     __|     :\n" +
                        "          /#   #\"\"\" |   /()\\    :    ..*\n" +
                        "          |#   #    |   \\__/    : .'' \n" +
                        "          \\#___#____|      /   :::.. .\n" +
                        "           \\______________|_...‰_: .. '*\n" +
                        "  ()       // /\\||||)))))))      '   . .\n" +
                        " .( \\_     \\\\_\\//   _-'.'/        |   * ..\n" +
                        "( )  |^|^|^|ooo/  _#\\.//\"\"\"_      |   . . .\n" +
                        "(_)_.'v|v|v|     / \\#  \\_ / '_  _'    . .  \n" +
                        "           | _ _/_/     /'./_-|\"         . .\n" +
                        "           /#_#__\"\"\"-._ /#  \\__)       .  .   \n" +
                        "           |__   \"\"-._ |##               . . .\n" +
                        "           |  \"\"|-\"\"\"-_/##              . .    \n" +
                        "           /\"\"--\\__.-|                       .\n" +
                        "           \\-_.-<__ /                   .   .\n" +
                        "           /-_| /  \\\n" +
                        "           \\-_| \\_-<.                        .  .\n" +
                        "           <_-/ <_.-\\                    .\n" +
                        "           <_-|  |_.-|                        .\n" +
                        "      .----|   \\__\\  |                 .\n" +
                        "     |     .\"\"\"   '.  |                       .\n" +
                        "      .___|        |__|                 \n" +
                        "          '.__...\"\"\"  \n");
    }

    public Schachtel getSchachtel() {
        return schachtel;
    }

    public void spielen() {

        System.out.println(spieler1.name + ": " + spieler1.getAnzahlMuenzen() + "Münzen\t" +
                spieler1.name + ": " + spieler1.getAnzahlMuenzen() + "Münzen");


        boolean turn1 = true;

        while(schachtel.getHoelzchen() > 0)
        {
            System.out.printf("Es sind " + schachtel.getHoelzchen() + " Hölzchen in der Schachtel.");

            int n;
            do {
                if(turn1) {
                    n = spieler1.ziehen();
                } else {
                    n = spieler2.ziehen();
                }
            } while (n >= 1 && n <= 3 );

            schachtel.hoelzchenZiehen(n);

            turn1 = !turn1;
        }
    }

}
