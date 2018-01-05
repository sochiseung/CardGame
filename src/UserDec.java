import java.util.ArrayList;
import java.util.Collections;

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
public class UserDec {
    ArrayList<Card> usrCards;

    UserDec(Card[] cards){
        usrCards = new ArrayList<Card>();
        if(cards.length>0){
            Collections.addAll(usrCards, cards);
        }
    }

    public void addCardInDeck(Card card){
        this.usrCards.add(card);
    }
}
