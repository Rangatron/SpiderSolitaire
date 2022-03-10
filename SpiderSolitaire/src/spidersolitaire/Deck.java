package spidersolitaire;
import java.util.ArrayList;
import java.util.Collections;

/**
 *  This class is initializing the deck
 * @author Alex Winterton
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    
    public Deck()//initialise the cards in the two decks
    {
        for(int p=0;p<2;p++)
        {
            for(int i=1; i<5;i++)
            {
                for(int k=1;k<14;k++)
                {
                    this.cards.add(new Card(i, k));
                }
            }
        }
    }
    
    public ArrayList<Card> getDeck()
    {
        return this.cards;//returns the cards
    }
    
    public void setDeck(int suit, int card, int cardNo)
    {
        this.cards.set(cardNo, new Card(suit, card)); //allows to set cards in the decks
    }
    
    public void shuffleDeck()
    {
        Collections.shuffle(this.cards);//shuffles the deck
    }
    
    @Override
    public String toString()//prints out all cards in the deck using the cards toString() method
    {
        String toReturn = "";
        
        for(int i=0;i<this.cards.size();i++)
        {
            toReturn = toReturn + this.cards.get(i).toString();
        }
        return toReturn;
    }
}