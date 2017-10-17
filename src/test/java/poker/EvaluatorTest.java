package poker;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class EvaluatorTest {

    @Test
    public void 로티플_검증_성공(){
        Hand hand = new Hand();

        hand.addCard(new Card(10,Suit.SPADE));
        hand.addCard(new Card(11,Suit.SPADE));
        hand.addCard(new Card(12,Suit.SPADE));
        hand.addCard(new Card(13,Suit.SPADE));
        hand.addCard(new Card(1,Suit.SPADE));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluate(hand);
        assertTrue(result.equals("ROYAL_STRAIGHT_FLUSH"));
    }

    @Test
    public void 동일숫자카운트(){

        Evaluator evaluator = new Evaluator();

        // 포카드 = 4
        Hand hand = new Hand();
        hand.addCard(new Card(1,Suit.HEART));
        hand.addCard(new Card(2,Suit.SPADE));
        hand.addCard(new Card(1,Suit.CLUB));
        hand.addCard(new Card(1,Suit.DIAMOND));
        hand.addCard(new Card(1,Suit.SPADE));
        int count = evaluator.duplicationCount(hand);
        assertTrue(count == 4);

        // 풀하우스 = 3
        hand = new Hand();
        hand.addCard(new Card(3,Suit.HEART));
        hand.addCard(new Card(11,Suit.SPADE));
        hand.addCard(new Card(3,Suit.CLUB));
        hand.addCard(new Card(3,Suit.DIAMOND));
        hand.addCard(new Card(11,Suit.DIAMOND));
        count = evaluator.duplicationCount(hand);
        assertTrue(count == 3);

        // 트리플 = 3
        hand = new Hand();
        hand.addCard(new Card(3,Suit.HEART));
        hand.addCard(new Card(11,Suit.SPADE));
        hand.addCard(new Card(3,Suit.CLUB));
        hand.addCard(new Card(3,Suit.DIAMOND));
        hand.addCard(new Card(2,Suit.SPADE));
        count = evaluator.duplicationCount(hand);
        assertTrue(count == 3);

        // 투페어 = 2
        hand = new Hand();
        hand.addCard(new Card(10,Suit.HEART));
        hand.addCard(new Card(10,Suit.SPADE));
        hand.addCard(new Card(12,Suit.CLUB));
        hand.addCard(new Card(12,Suit.DIAMOND));
        hand.addCard(new Card(1,Suit.SPADE));
        count = evaluator.duplicationCount(hand);
        assertTrue(count == 2);

        // 원페어 = 2
        hand = new Hand();
        hand.addCard(new Card(8,Suit.HEART));
        hand.addCard(new Card(8,Suit.SPADE));
        hand.addCard(new Card(12,Suit.CLUB));
        hand.addCard(new Card(13,Suit.DIAMOND));
        hand.addCard(new Card(1,Suit.SPADE));
        count = evaluator.duplicationCount(hand);
        assertTrue(count == 2);

    }


    @Test
    public void 포카드_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(7, Suit.HEART));
        hand.addCard(new Card(1, Suit.SPADE));
        hand.addCard(new Card(7, Suit.DIAMOND));
        hand.addCard(new Card(7, Suit.CLUB));
        hand.addCard(new Card(7, Suit.HEART));

        Evaluator evaluator = new Evaluator();
        int count = evaluator.duplicationCount(hand);
        assertTrue(count == 4);
    }

    @Test
    public void 플러쉬_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(7, Suit.CLUB));
        hand.addCard(new Card(8, Suit.CLUB));
        hand.addCard(new Card(10, Suit.CLUB));
        hand.addCard(new Card(13, Suit.CLUB));
        hand.addCard(new Card(2, Suit.CLUB));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluate(hand);
        assertTrue(result.equals("FLUSH"));
    }

}
