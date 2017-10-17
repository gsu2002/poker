package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cardList = new ArrayList<Card>();


    public Deck(int deckCount) {
        for(int i = 1; i < 14; i++){
            for(Suit suit : Suit.values()){
                cardList.add(new Card(i,suit));
            }
        }
        Collections.shuffle(cardList);
    }

    public int getTotalCard() {
        return cardList.size();
    }

    public Card drawCard() {
        if(cardList.size()>0)
            return cardList.remove(0);
        throw new NoMoreCardException();
    }

}
