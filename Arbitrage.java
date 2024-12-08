import java.util.*;
public class Arbitrage{
    double stake;
    ArrayList<Bet> betList;

    public static boolean arbitrageValidity(Bet x1,Bet x2) {
        boolean validity = false;
        //false if both moneylines are underdogs or favorites
        if (x1.getPlusMinus() == x2.getPlusMinus()) {
            return validity;
        }
        // if the probabilities of both bets are less than 100 its an arb bet
        else if (x1.impliedProbability() + x2.impliedProbability() <= 100) {
            validity = true;
            return validity;
        }
        // returns if overall prob is over 100 
        else {
            return validity;
        }   
    }
    // returns betting increments for each and ROI
    public static String arbitrageBet(Bet under, Bet favorite, double stake) {
        double a = under.moneylineToOdds();
        double b = favorite.moneylineToOdds();
        a = (b * stake) / (a + b);
        b = stake - a;
        a = Math.round(a * 100.0) / 100.0;
        b = Math.round(b * 100.0) / 100.0;
        double payout = a * under.moneylineToOdds();
        double roi = (payout - stake) / stake;
        roi = Math.round(roi * 10000);
        roi = roi * .01;
        payout = Math.round(payout * 100.0) / 100.0;
        double profit = payout - stake;
        profit = Math.round(profit * 100.0) / 100.0;
        return under.getName()+": $" + a + "\n"+ favorite.getName()+": $" + b + "\nROI: %" + roi +
            "\nPayout: $" + payout +"\nProfit: $"+ profit;
    }
    // returns increments and ROI for weighted arb
    public static String weigthedBet(Bet choice, Bet other) {
        return "hi";
    }
    
    public void listAdd() {
    
    }

    public static ArrayList<Bet> massArbCheck(ArrayList<Bet> betList)
    {
        for (Bet e : betList) {
        
        }
    }
}