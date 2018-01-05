import java.util.*;

/**
 * @author :
 * @version 1.0
 *          <p>
 *          == Modification Information ==
 *          <p>
 *          Date			Author			Note
 *          ----------	-------------	--------------------------------
 *          2018-01-03		soh			최초 생성
 * @packgename : PACKAGE_NAME
 * @description :
 */
public class Combination {
    private ArrayList<String> combinationTmpList;
    private Map<String, Integer> cardMap;

    public Combination(Map<String, Integer> cardMap){
        combinationTmpList = new ArrayList<String>();
        this.cardMap = cardMap;
        String[] cards = cardMap.keySet().toArray(new String[cardMap.keySet().size()]);
        Arrays.sort(cards);
        for(int i = 1; i <= cards.length; i++){
            this.refineCombination(cards,i);
        }
    }
    public static void main(String[] args){
        Map<String, Integer> cardMap = new HashMap<>();

        cardMap.put("C1", 30000);
        cardMap.put("C2", 50000);
        cardMap.put("C3", 50000);
        cardMap.put("C4", 100000);


//        Collections.addAll(cards, cardMap.keySet());

//      모든 조합을 만드는
        Combination combi = new Combination(cardMap);
        System.out.println(combi.getCardsValue("C1,C3,"));
    }

    private void refineCombination(String[] cardList, int numberOfr){
        int cardListLength = cardList.length;
        int[] arr = new int[cardListLength];

        this.combination(cardList,arr, 0 , cardListLength, numberOfr, 0);
        if(numberOfr >1 ){
            for( String com : this.combinationTmpList){
                String[] coms = com.split(",");
                int max = 0;
                for(String card: coms){
                    int cardValue = this.cardMap.getOrDefault(card,0);
                    if(cardValue > max){
                        max = cardValue;
                    }
                }
                cardMap.put(com, max);
//                System.out.println(com+"  "+max);


            }
        }
        this.combinationTmpList.clear();
    }

    public int getCardsValue(String cardKey){
        return this.cardMap.getOrDefault(cardKey,0);
    }
    private void combination(String[] cardList, int[] arr, int index, int n, int r, int target)
    {
        String combiString = "";
        if (r == 0){
            combiString = print(cardList, arr, index);
            this.combinationTmpList.add(combiString);
        }

        else if (target == n){
            return;
        }
        else {
            arr[index] = target;
            combination(cardList, arr, index + 1, n, r - 1, target + 1);
            combination(cardList, arr, index, n, r, target + 1);
        }
    }

    private String print(String[] cardList, int[] arr, int length)
    {
        String result = "";
        for (int i = 0; i < length; i++)
            result += cardList[arr[i]]+",";
        return result;
    }

}
