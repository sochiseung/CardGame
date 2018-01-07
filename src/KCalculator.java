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
public class KCalculator {
    private ArrayList<String> combinationTmpList;
    private Map<String, Integer> criterionCardMap;

    public KCalculator(Map<String, Integer> criterionCardMap){
        combinationTmpList = new ArrayList<String>();
        this.criterionCardMap = criterionCardMap;
        String[] cards = criterionCardMap.keySet().toArray(new String[criterionCardMap.keySet().size()]);
        Arrays.sort(cards);
        for(int i = 1; i <= cards.length; i++){
            this.makeNormalCombination(cards,i);
        }
    }
    public int getCardsValue(String cardKey){
        return this.criterionCardMap.getOrDefault(cardKey,0);
    }
    public Map<String, Integer> getCriterionCardMap(){
        return criterionCardMap;
    }

    private void makeSingularCombination(String[] userCards){
        /*
        입력 카드에 대한 제한 값에 따른 조합을 함
        - 구한 조합에 대한 계산을 진행한다.
        -- 입력카드는 조합 별 합을 구함 - userValueMap
        - (userValueMap 키값과 criterionCardMap의 키값 포맷이 동일 해야함.)
        -
         */
        for(int i = 1; i <= userCards.length; i++){
            this.makeNormalCombination(userCards,i);
        }

    }
    private void makeNormalCombination(String[] cardList, int numberOfr){
        int cardListLength = cardList.length;
        int[] arr = new int[cardListLength];

        this.combination(cardList,arr, 0 , cardListLength, numberOfr, 0);
        if(numberOfr >1 ){
            for( String com : this.combinationTmpList){
                String[] coms = com.split(",");
                int max = 0;
                for(String card: coms){
                    int cardValue = this.criterionCardMap.getOrDefault(card,0);
                    if(cardValue > max){
                        max = cardValue;
                    }
                }
                criterionCardMap.put(com, max);
            }
        }
        this.combinationTmpList.clear();
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
