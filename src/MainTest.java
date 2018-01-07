import java.util.HashMap;
import java.util.Map;

public class MainTest {

    public static void main(String[] args) {
        Map<String, Integer> cardMap = new HashMap<>();

        cardMap.put("C1", 30000);
        cardMap.put("C2", 50000);
        cardMap.put("C3", 100000);
        cardMap.put("C4", 50000);
//        cardMap.put("C5", 100000);


//        Collections.addAll(cards, cardMap.keySet());

//      모든 조합을 만드는
        KCalculator combi = new KCalculator(cardMap);
//        System.out.println(combi.g);

        Map<String, Integer> combiMap = combi.getCriterionCardMap();

        System.out.println(combiMap.size());




    }
}
