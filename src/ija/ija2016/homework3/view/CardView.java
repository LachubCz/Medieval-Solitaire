/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2016.homework3.view;

import ija.ija2016.homework3.model.cards.Card;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Holajz
 */
public class CardView extends JLabel{
    
    private Card.Color color;
    int value;
    private float opacity;
    private boolean isSelected;
    private boolean isHint;
    
    CardView(CardView.CardViewColor cardColor, int cardValue, int x, int y) {
        this.color = CardViewColor.toColor(cardColor);
        this.value = cardValue;
        
        ImageIcon icon = LayoutVisualization.get().getCardImage(cardColor, cardValue);
        this.setIcon(icon);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
    }


        public static enum CardViewColor {
            SPADES("S"), DIAMONDS("D"), HEARTS("H"), CLUBS("C"), BACK("BACK"), NONE("NONE"), NEW_DECK("NEWDECK");
            
            private final String cardValue;
            
            private CardViewColor(String value) {
                this.cardValue = value;
            }
            
            public static CardView.CardViewColor ColorView(Card.Color color) {
                    switch(color) {
                        case SPADES:
                            return SPADES;
                        case DIAMONDS:
                            return DIAMONDS;
                        case HEARTS:
                            return HEARTS;
                        case CLUBS:
                            return CLUBS;
                    }
                    return SPADES;
            }
            
            public static Card.Color toColor(CardView.CardViewColor color) {
                    switch(color) {
                        case SPADES:
                            return Card.Color.SPADES;
                        case DIAMONDS:
                            return Card.Color.DIAMONDS;
                        case HEARTS:
                            return Card.Color.HEARTS;
                        case CLUBS:
                            return Card.Color.CLUBS;
                    }
                    return Card.Color.SPADES;
            }
            
        }
        
        public static enum CardViewState {
		NONE("NONE"),
		SELECTED_CARD("SELECTED CARD"),
		HINT_CARD("HINT TARGET");

		private final String cardValue;

		private CardViewState(String value){
			this.cardValue = value;
		}
	}
        
        
        public float getOpacity() {
            return this.opacity;
        }
        
        public void setOpacity(float opacity) {
            this.opacity = opacity;
        }
        
        public void setSelected(boolean isSelected) {
            this.isSelected = isSelected;
            repaint();
        }
        
        public Card toCard() {
            return new Card(this.color, this.value);
        }
        
        public void setHint(boolean isHint) {
            this.isHint = isHint;
            repaint();
        }
        
        @Override
        public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		if(isSelected || isHint){
			Graphics2D g2 = (Graphics2D)g;
			BufferedImage im = isSelected ? LayoutVisualization.get().getState(CardView.CardViewState.SELECTED_CARD) :
							LayoutVisualization.get().getState(CardView.CardViewState.HINT_CARD);
			
                        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
                        //getTranslateInstance - Returns a transform representing a translation transformation. move matrix.
			g2.drawRenderedImage((RenderedImage)im, AffineTransform.getTranslateInstance(0, 0));
			g2.dispose();
		}
        }
        
        
    
    
    
}
