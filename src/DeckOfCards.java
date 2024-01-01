import java.util.ArrayList;

public class DeckOfCards {
    ArrayList<MyCard> deck = new ArrayList<MyCard>();
    String[] suits = {"hearts", "diamonds", "clubs", "spades"};
    String[] faces = {"jack", "queen", "king", "ace"};

    public DeckOfCards(String type){
        for (int i = 2; i<=14; i++){
            for(int suit = 0; suit <=3; suit++){
                String name = "";
                if(i<=10) {
                    name = i + "_of_" + suits[suit] + ".png";
                }
                else{
                    name = faces[i-11] + "_of_" + suits[suit] + ".png";
                }
                    MyCard card = new MyCard(name, i, suits[suit]);
                    deck.add(card);

            }
        }

    }

    public DeckOfCards(){
       deck = new ArrayList<MyCard>();
    }

    public void shuffle(){
        for(int i =0; i<deck.size(); i++){
            int rando = (int)(Math.random()*deck.size());
            MyCard randoCard = deck.get(rando);
            deck.set(rando, deck.get(i));
            deck.set(i,randoCard);

        }
    }

    public MyCard getNext(){
        if (deck.size()>0) {
            return deck.remove(0);
        }
        else{
            return new MyCard("red_joker.png", 0, "none");
        }
    }

    public void addCard(MyCard card){
        deck.add(card);
    }

    public int getNumCards(){
        return deck.size();
    }

}
