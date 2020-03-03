package rs.ac.metropolitan.cs230;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StockQuoteGenerator {
    private List<String> actions = new ArrayList<>();
    private Random generator = new Random();

    public StockQuoteGenerator() {
        actions.add("AAPL");
        actions.add("MSFT");
        actions.add("YHOO");
        actions.add("AMZN");
    }
    public String calculateRandomPrice(String simbol){
        if(actions.contains(simbol)){
            int randomNumber = 1 + generator.nextInt(100);
            return String.valueOf(randomNumber);
        }
        return "Simbol akcije nije podrzan";
    }
    
}
