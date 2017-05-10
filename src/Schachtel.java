
public class Schachtel {
    int hoelzchen;

    public Schachtel(int hoelzchen) {
        this.hoelzchen = hoelzchen;
    }

    public int getHoelzchen() {
        return hoelzchen;
    }

    public void hoelzchenZiehen(int n) {
        hoelzchen -= n;
    }
}
