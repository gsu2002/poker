package poker;

import java.util.List;

public class Evaluator {



    public String evaluate(Hand hand){
        if(hand.getCardCount() != 5)
            throw new NotFullHandException();

        List<Card> handList = hand.getHandList();
        // Four Card
        if(duplicationCount(hand) == 4)
            return "FOUR_CARD";


        // Flush
        int count = 1;
        Suit suit = null;
        for(Card card : hand.getHandList()){
            if(suit == null)
                suit = card.getSuit();

            if(suit != card.getSuit()) {
                break;
            }
            count++;
        }
        if(count >= 5)
            return "FLUSH";



        return null;
    }

    public int duplicationCount(Hand hand) {
        int maxCount = 0;

        int rank ;
        for(Card card : hand.getHandList())
        {
            int count = 0;
            rank = card.getRank();
            for(Card card1 : hand.getHandList())
            {
                if(rank == card1.getRank())
                    count++;
            }
            if(count > maxCount)
                maxCount = count;
        }

        return maxCount;
    }
}
