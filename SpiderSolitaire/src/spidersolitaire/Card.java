/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spidersolitaire;

import java.util.ArrayList;

/**
 *
 * @author Alex Winterton
 */
public class Card {
    private ArrayList<Integer> card = new ArrayList<>();
    
    public Card(int suit, int value)//initialises cards suit and value
    {
        this.card.add(suit);
        this.card.add(value);
    }
    
    public Card()
    {
        
    }
    
    public void setCard(int suit, int value)//sets the cards suit and value
    {
        this.card.set(0, suit);
        this.card.set(1, value);
    }
    
    public ArrayList<Integer> getCard()
    {
        return this.card;//returns the card
    }
    
    public String toString()//converts the cards into their text version e.g 13 to K for values and for suits e.g. 2 to D
    {
        String rSuit = "";
        String rValue = "";
        
        if(this.card.get(0) == 0)
        {
            rSuit = " ";
        }
        else if(this.card.get(0) == 1)
        {
            rSuit = "H";
        }
        else if(this.card.get(0) == 2)
        {
            rSuit = "D";
        }
        else if(this.card.get(0) == 3)
        {
            rSuit = "C";
        }
        else if(this.card.get(0) == 4)
        {
            rSuit = "S";
        }
        
        if(this.card.get(1) > 9)
        {
            if(this.card.get(1) == 10)
            {
                rValue = "10";
            }
            if(this.card.get(1) == 11)
            {
                rValue = "J ";
            }
            else if(this.card.get(1) == 12)
            {
                rValue = "Q ";
            }
            else if(this.card.get(1) == 13)
            {
                rValue = "K ";
            }
        }
        else if(this.card.get(1) == 0 || this.card.get(1) == 14)
        {
            rValue = "  ";
        }
        else
        {
            rValue = this.card.get(1) + " ";
        }
        
        return "[" + rSuit + rValue + "]";
    }
    
    public String toImage()//converts the card into an image of the card for the GUI
    {
        String toreturn = "";
        switch(this.card.get(0))
        {
            case 0:
            {
                if(this.card.get(1) == 14)
                {
                    toreturn = "EMPTY.png";
                }
                else
                {
                    toreturn = "BACK.png";
                }
                break;
            }
            case 1:
            {
                switch(this.card.get(1))
                {
                    case 1:
                    {
                        toreturn = "AH.png";
                        break;
                    }
                    case 11:
                    {
                        toreturn = "JH.png";
                        break;
                    }
                    case 12:
                    {
                      toreturn = "QH.png";  
                      break;
                    }
                    case 13:
                    {
                        toreturn = "KH.png";
                        break;
                    }
                    default:
                    {
                        toreturn = this.card.get(1) + "H.png";
                    }
                }
                break;
            }
            case 2:
            {
                switch(this.card.get(1))
                {
                    case 1:
                    {
                        toreturn = "AD.png";
                        break;
                    }
                    case 11:
                    {
                        toreturn = "JD.png";
                        break;
                    }
                    case 12:
                    {
                      toreturn = "QD.png";  
                      break;
                    }
                    case 13:
                    {
                        toreturn = "KD.png";
                        break;
                    }
                    default:
                    {
                        toreturn = this.card.get(1) + "D.png";
                    }
                }
                break;
            }
            case 3:
            {
                switch(this.card.get(1))
                {
                    case 1:
                    {
                        toreturn = "AC.png";
                        break;
                    }
                    case 11:
                    {
                        toreturn = "JC.png";
                        break;
                    }
                    case 12:
                    {
                      toreturn = "QC.png";  
                      break;
                    }
                    case 13:
                    {
                        toreturn = "KC.png";
                        break;
                    }
                    default:
                    {
                        toreturn = this.card.get(1) + "C.png";
                    }
                }
                break;
            }
            case 4:
            {
                switch(this.card.get(1))
                {
                    case 1:
                    {
                        toreturn = "AS.png";
                        break;
                    }
                    case 11:
                    {
                        toreturn = "JS.png";
                        break;
                    }
                    case 12:
                    {
                      toreturn = "QS.png";  
                      break;
                    }
                    case 13:
                    {
                        toreturn = "KS.png";
                        break;
                    }
                    default:
                    {
                        toreturn = this.card.get(1) + "S.png";
                    }
                }
                break;
            }
        }
        
        return toreturn;//returns the name of the file that is added onto the end of it's file destination
    }
}
