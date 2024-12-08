public class Main {

    public static void main(String[] args) {
        Bet b1 = new Bet("Celtics win", "Draftkings", "+150");
        Bet b2 = new Bet("Knicks win", "espn sportbook", "-125");
        System.out.println(Arbitrage.arbitrageBet(b2, b1, 830.0));
    }


}