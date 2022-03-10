/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spidersolitaire;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javax.swing.BorderFactory.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Alex Winterton
 */
public class GameForm extends javax.swing.JFrame {

    /**
     * Creates new form GameForm
     */
    long timeStart;
    long timeFinish;
    private final Table table;
    //private SolitaireDB database = new SolitaireDB();
    
    public GameForm(Table board) {
        //this.database.connect();//connect to the data base
        this.table = board;//starts a new game
        initComponents();
        toButton();//makes cards into buttons
        timeStart = System.currentTimeMillis();//writes down the current time in milliseconds
    }

    private GameForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        winClose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dealCards = new javax.swing.JButton();
        endGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        jLabel2.setText("Congratulations!!!");

        jLabel3.setText("You Won");

        winClose.setText("Close");
        winClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(winClose))
                .addGap(156, 156, 156))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(winClose)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spider Solitaire");

        dealCards.setText("Deal Cards");
        dealCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealCardsActionPerformed(evt);
            }
        });

        endGame.setText("End Game");
        endGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endGameActionPerformed(evt);
            }
        });

        jLabel1.setText("Cards Left: " + this.table.getDeck().getDeck().size());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(dealCards)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(endGame)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dealCards)
                    .addComponent(endGame)
                    .addComponent(jLabel1))
                .addGap(45, 45, 45))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1399, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1418, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dealCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealCardsActionPerformed
        // TODO add your handling code here:
        this.table.dealCards();//deals cards onto the table
        
        this.jLabel1.setText("Cards Left: " + this.table.getDeck().getDeck().size());//changes the display for how many cards are still in the deck
        
        for(int i=0;i<10;i++)
        {
            this.cards.get(i).clear();//get rid of the old buttons
        }
                
        this.jPanel2.removeAll();//remove old buttons
        this.jPanel2.revalidate();//make sure buttons are gone
        this.jPanel2.repaint();//remove button carcasses
        toButton();//make new card buttons
    }//GEN-LAST:event_dealCardsActionPerformed

    private void endGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endGameActionPerformed
        // TODO add your handling code here:
        
        this.timeFinish = System.currentTimeMillis();//writes the current time in milliseconds
        //this.database.addGame(0, false);//adds the game to the scores table
        new StartMenu().setVisible(true);//opens the start menu
        super.dispose();//closes the game
    }//GEN-LAST:event_endGameActionPerformed

    private void winCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_winCloseActionPerformed
       this.jDialog1.dispose();//closes the victory message
    }//GEN-LAST:event_winCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
              public void run() {
                new GameForm().setVisible(true);
            }
        });
    }
    
    int toMoveX;//saving cards coordinates to move later
    int toMoveY;
    int selectCards = 0;//checking whether a card has already been selected
    ArrayList<ArrayList<JButton>> cards = new ArrayList<>();
    
    public void toButton()
    {
        
        int positionX = 0;//used for positioning cards
        int scrollSize = 0;//used for changing the size of the jScrollPanel
        
        for(int j=0;j<10;j++)
        {
            this.cards.add(new ArrayList<>());//make the arraylist for the buttons to go into
        }
        
        for(int i=0;i<10;i++)
        {
            int positionY = 0;
            for(int k=0;k<this.table.getTable().get(i).size();k++)
            {
                this.cards.get(i).add(new JButton()); // Create a new button for a card
                this.cards.get(i).get(k).setIcon(new ImageIcon("../cards/" + table.getTable().get(i).get(k).toImage())); //makes the button an image to show what card it is
                this.cards.get(i).get(k).setLocation(10 + positionX, 11 + positionY);//sets the positionof the card down from the one above it and to the right of the card beside
                this.cards.get(i).get(k).setSize(120, 200);//the size of the card
                this.cards.get(i).get(k).setVisible(true);//shows the cards
                this.jPanel2.add(cards.get(i).get(k));//adds the card to the jpanel
                
                positionY += 200;
                if(positionY > scrollSize)
                {
                    scrollSize = positionY+30; //gets the max size the jScrollPanel and Jpanel are always the right size
                }
                
                final int x = i;//converts the cards to a final variable so it can be sent to the move card method used in the cardAction method
                final int y = k;
                this.cards.get(i).get(k).addActionListener(new ActionListener(){//waits for a card to be clicked
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardAction(e, x, y);
                    }
                    
                });
            }
            positionX += 130;
            this.jPanel2.setPreferredSize(new Dimension(1500, scrollSize));//change the size of the panels to match the amount of buttons
            this.jScrollPane2.setPreferredSize(new Dimension(1500, scrollSize));
        }
        this.jPanel2.revalidate(); //redraw everything
        this.jScrollPane2.revalidate();
    }
    public void cardAction(ActionEvent e, int cardX, int cardY) {
        
        if(this.selectCards == 0)
        {
            this.cards.get(cardX).get(cardY).setBorder(createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 0, 51)));//highlights the card so that user knows what card has been clicked
            this.toMoveX = cardX; //saves the cards position to add to the moveCard method int table
            this.toMoveY = cardY;
            this.selectCards = 1; //make sure the second card can be selected
        }
        else if(this.selectCards == 1)
        {
            if((this.toMoveX == cardX) && (this.toMoveY == cardY))
            {
                //if the same card was clicked twice don't do anything
            }
            else
            {
                this.table.moveCard(this.toMoveX, this.toMoveY, cardX); //calls the moveCrad method of the table class
                
                for(int i=0;i<10;i++)
                {
                    this.cards.get(i).clear(); //get rid of all card buttons
                }
                
                this.jPanel2.removeAll();//remove all the buttons
                this.jPanel2.revalidate();//make sure there aren't any buttons that shouldn't be there
                this.jPanel2.repaint(); // get rid of the buttons
                
                toButton(); //make new buttons with the updated table
            }
            this.selectCards = 0;//reset so that you can move two new cards
            this.cards.get(toMoveX).get(toMoveY).setBorder(createEmptyBorder(0,0,0,0)); //gets rid of the border on the first card clicked
        }
        if(this.table.getPile() == 8)//checks if the player has won
        {
            timeFinish = System.currentTimeMillis();//writes the current time in milliseconds
          //  this.database.addGame((timeFinish-timeStart), true);//adds the game to the database using the final time in ms minus the starting time in ms
            this.jDialog1.setVisible(true);
            this.jDialog1.setSize(400,200);
            this.jDialog1.setLocation(500, 500);
            new StartMenu().setVisible(true);//creates a popup that congratulates the user for winning
            super.dispose();//goes back to the main menu
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dealCards;
    private javax.swing.JButton endGame;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton winClose;
    // End of variables declaration//GEN-END:variables
}