import java.text.DecimalFormat;
public class Bet {
    private String name;
    private String sportsbook;
    private int odds;
    private char plusMinus;
    private String moneyline;
    

    public Bet(String name, String sportsbook, String moneyline) {
        this.name = name;
        this.sportsbook = sportsbook;
        this.plusMinus = moneyline.charAt(0);
        this.odds = Integer.parseInt(moneyline.substring(1));
        this.moneyline = moneyline;
    }
    
    public String getName() {
        return name;
    }

    public String getSportsbook() {
        return sportsbook;
    }

    public int getOdds() {
        return odds;
    }

    public char getPlusMinus() {
        return plusMinus;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    public String getMoneyLine() {
        return moneyline;
    }

    public double impliedProbability() {
        double x;
        //Moneyline to Percentage formula for underdog odds
        if (plusMinus == '-') {
            x = odds;
            x = x / (x + 100.0) * 100.0;
            return x;
        }
        //Moneyline to Percentage formula for favorite odds
        if (plusMinus == '+') {
            x = odds;
            return 100.0 / (x + 100.0);
        }
        // if moneyline odds is inputted incorrectly percentage is 0
        else {
            return 0;
        }
    }
    
    public double moneylineToOdds() {
        double ml;
        double ml2;
        if (moneyline.charAt(0) == '+') {
            ml = Double.parseDouble(moneyline.substring(1));
            ml = (ml / 100.0) + 1;
            return ml;
        }
        if (moneyline.charAt(0) == '-') {
            ml2 = Double.parseDouble(moneyline.substring(1));
            ml2 = (100.0 / ml2) + 1;
            return ml2;

        }
        else {
            return 0;
        }
    }
}