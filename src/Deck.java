import java.util.ArrayList;

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
public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void addCardInDeck(Card card){
        this.cards.add(card);
    }


}
