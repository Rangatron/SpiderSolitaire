/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spidersolitaire;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 *
 * @author Alex Winterton
 */
public class Table {
    private Deck deck = new Deck();
    private ArrayList<ArrayList<Card>> table = new ArrayList<>();
    private ArrayList<ArrayList<Card>> hiddenCards = new ArrayList<>();
    static int columns = 10;
    private int piles = 0;
    
    public Table()//initailize the table laying out the cards on the table and shuffling the deck
    {
        this.deck.shuffleDeck();
        
        for(int i=0;i<10;i++)
        {
            this.table.add(new ArrayList<>());
            this.hiddenCards.add(new ArrayList<>());
        }
        
        for(int k=0;k<4;k++)       //deals out first 4 rows of cards and hides them from the player
        {
            for(int i=0;i<10;i++)
            {
               this.hiddenCards.get(i).add(this.deck.getDeck().get(0));
               this.deck.getDeck().remove(0);
               this.table.get(i).add(new Card(0,0));
            }
        }
        for(int i=0;i<4;i++)        //deals out 4 cards that are also hidden from the player
        {
            this.hiddenCards.get(i).add(this.deck.getDeck().get(0));
                this.deck.getDeck().remove(0);
                this.table.get(i).add(new Card(0,0));
        }
        for(int i=4;i<10;i++)       //deals out six cards to be revealed in the fifth row
        {
            this.table.get(i).add(this.deck.getDeck().get(0));
            this.deck.getDeck().remove(0);
        }
        for(int l=0;l<4;l++)       // deal out 4 cards to be revealed in the sixth row
        {
            this.table.get(l).add(this.deck.getDeck().get(0));
            this.deck.getDeck().remove(0);
        }
    }
    
    public Deck getDeck()
    {
        return this.deck;//returns the deck
    }
    
    public int getPile()
    {
        return this.piles;//returns the number of piles
    }
    
    public ArrayList<ArrayList<Card>> getTable()
    {
        return this.table;//returns the table
    }
    
    public void setTable(int x, int y, Card card)
    {
        this.table.get(x).set(y, card);//allows you to move cards arround
    }
    
    public void revealCard(int x, int y)
    {
        this.table.get(x).set(y, this.hiddenCards.get(x).get(y));//swaps a hidden card with what the card is
    }
    
    public void moveCard(int cardX, int cardY, int placeX) //move cards from one cordinate position to another
    {
        int nextCard = cardY + 1;//the card after the card the user wants to move
        ArrayList<Card> buffer = new ArrayList<>();//a buffer for moving multiple cards at once
        
        for(int i=0;i<10;i++)
        {
            this.table.get(i).add(new Card(0,15));//create an invisible row of cards to avoid errors
        }
        
        for(int j=0;j<this.table.get(cardX).size();j++)
        {
            if(this.table.get(cardX).get(cardY + j).getCard().get(0) == this.table.get(cardX).get(cardY).getCard().get(0) && (this.table.get(cardX).get(cardY + j).getCard().get(1)-1 == this.table.get(cardX).get(cardY + j + 1).getCard().get(1) || this.table.get(cardX).get(cardY + j + 1).getCard().get(1) == 15))
            {
                //checks whether the card below is allowed to be moved with the chosen card or if there is only one card
                buffer.add(this.table.get(cardX).get(cardY + j));
            }
            else if(this.table.get(cardX).get(cardY + j).getCard().get(0) == 0 || this.table.get(cardX).get(cardY + j).getCard().get(1) == 15 )
            {
                j=this.table.get(cardX).size();
                //if this is an invisible card added earlier stop checking for cards to add to the buffer
            }
            else if(this.table.get(cardX).get(cardY + j).getCard().get(0) != this.table.get(cardX).get(cardY).getCard().get(0) && this.table.get(cardX).get(cardY + j).getCard().get(1) != 15)
            {
                //if the next card doesn't match the first cards suit and isn't an invisible card empty the buffer and stop checking for cards
                buffer.clear();
                j=this.table.get(cardX).size();
                buffer.add(new Card(0, 0));
            }
            else if(this.table.get(cardX).get(cardY + j).getCard().get(1)-1 == this.table.get(cardX).get(cardY + j + 1).getCard().get(1) && this.table.get(cardX).get(cardY + j).getCard().get(1) != 15)
            {
                //if the next card isn't one value lower than the card before it and isn't an invisible card empty the buffer and stop checking for cards
                buffer.clear();
                j=this.table.get(cardX).size();
                buffer.add(new Card(0, 0));
            }
        }
            
            for(int i=0;i<10;i++)//get rid of the invisible cards
            {
                this.table.get(i).remove(this.table.get(i).size()-1);
            }
            
            if(this.table.get(placeX).get(0).getCard().get(1) == 14)//if there are no cards in this column
            {
                this.table.get(placeX).remove(0);//remove the place holder
                
                boolean btf = buffer.isEmpty();
                
                if(btf == true)
                {
                    //if the buffer is empty put the placeholder back
                    this.table.get(placeX).add(new Card(0, 14));
                }
                else
                {
                    //if the buffer has cards in it
                    if(this.table.get(cardX).size() == 1)
                    {}//if its the last card in a column skip the next if statement (i know bad design but it's a quick fix)
                    else if(this.table.get(cardX).get(cardY-1).getCard().get(1) == 0 && this.table.get(cardX).get(cardY-1).getCard().get(0) == 0)
                    {//if the card befor the card to move is hidden reveal it
                        revealCard(cardX, (cardY-1));
                    }
                    while(btf == false)
                    {
                        //while there's something in the buffer 
                        this.table.get(placeX).add(buffer.get(0));//place a card from the buffer
                        buffer.remove(0);//remove the card from the buffer
                        this.table.get(cardX).remove(this.table.get(cardX).size()-1);//remove the card from it's original spot on the table
                        btf = buffer.isEmpty();//check if the buffer is empty or not
                    }
                }
            }
            else if(1+buffer.get(0).getCard().get(1) == this.table.get(placeX).get(this.table.get(placeX).size()-1).getCard().get(1))
            {
                //if the first card in the buffer is one value lower than the last card in the place the cards are to move to
                boolean btf = buffer.isEmpty();
                
                if(this.table.get(cardX).size() == 1)
                {}//if its the last card in a column skip the next if statement (i know bad design but it's a quick fix)
                else if(this.table.get(cardX).get(cardY-1).getCard().get(1) == 0 && this.table.get(cardX).get(cardY-1).getCard().get(0) == 0)
                {////if the card befor the card to move is hidden reveal it
                    revealCard(cardX, (cardY-1));
                }
                
                while(btf == false)
                {
                    //while there's something in the buffer 
                    this.table.get(placeX).add(buffer.get(0));//place a card from the buffer
                    buffer.remove(0);//remove the card from the buffer
                    this.table.get(cardX).remove(this.table.get(cardX).size()-1);//remove the card from it's original spot on the table
                    btf = buffer.isEmpty();//check if the buffer is empty or not
                }
            }
            
            if(this.table.get(cardX).isEmpty() == true)
            {
                //if the collumn the cards moved from has nothing in it
                this.table.get(cardX).add(new Card(0, 14));//add a place holder card
            }
            
            if(checkPile(placeX, (this.table.get(placeX).size()-1)) == true)
            {//runs the checkPile function and removes piles that have been made
                for(int i=0;i<13;i++)
                {
                    this.table.get(placeX).remove(this.table.get(placeX).size()-1);
                }
            }
    }

    
    public void dealCards()//adds one card from the deck onto the end of each column
    {
        for(int i=0;i<10;i++)
        {
            this.table.get(i).add(this.deck.getDeck().get(0));
            this.deck.getDeck().remove(0);
        }
    }
    
    public boolean checkPile(int cardX, int cardY)//checks if a pile has formed
    {
        boolean isPile = true;
        
        while(isPile == true)
        {
            for(int i=0;i<13;i++)
            {
                if(this.table.get(cardX).get(cardY - i).getCard().get(0) != this.table.get(cardX).get(cardY-i-1).getCard().get(0))
                {//if the suit is not the same
                    if(this.table.get(cardX).get(cardY - i).getCard().get(1)+1 != this.table.get(cardX).get(cardY-i-1).getCard().get(1))
                    {//if the value of the card above is not one higher
                        isPile = false;//stop the while loop and will return false
                        i=13;//stops the for loop
                    }
                }
                else
                {// if the suit is the same and the card above is one value higher the whole way through the method will return true
                    isPile = true;
                }
            }
        }
        
        if(isPile == true)
        {
            this.piles+=1;//if a pile was made add one to the pile counter
        }
        return isPile;
    }
    
    @Override
    public String toString()//prints the table in the console
    {
        String toReturn = "";
        int mostCards = 0;
        ArrayList<Integer> sizes = new ArrayList<>();
        
        for(int i=0;i<10;i++)//finds the column with the most cards to pad out the rest of the cards
        {
            if(mostCards < this.table.get(i).size())
            {
                mostCards = this.table.get(i).size();
            }
        }
        
        for(int f=0; f<10;f++)
        {//saves the original length of the columns
            toReturn = toReturn + "    " + f + " ";
            sizes.add(this.table.get(f).size());
            for(int m=sizes.get(f);m<mostCards;m++)
            {
                this.table.get(f).add(new Card(0, 0));
            }
        }
        
        toReturn = toReturn + '\n';
        
        for(int k=0;k<mostCards;k++)
        {//while k is less than the length of the longest column
            toReturn = toReturn + k + " ";
            for(int j=0;j<10;j++)
            {//for each column add the card to the string
                toReturn = toReturn + this.table.get(j).get(k).toString() + " ";
            }
            toReturn = toReturn +'\n';
        }
        
        //removes extra cards that were added to pad out table
        for(int p=0;p<10;p++)
        {
            while(sizes.get(p) < this.table.get(p).size())
            {
                this.table.get(p).remove(this.table.get(p).size()-1);
            }
        }
        
        return toReturn;
    }
}


