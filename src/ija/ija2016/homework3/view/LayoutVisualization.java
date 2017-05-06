package ija.ija2016.homework3.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LayoutVisualization {
    private BufferedImage stateHint;
    private BufferedImage stateSelected;
    
    static LayoutVisualization VIEW = null;
    private ArrayList<ImageIcon> cards = new ArrayList<>();
    private ArrayList<ImageIcon> smallCards = new ArrayList<>();
    private boolean useSmallCards = false;
    
    LayoutVisualization() {
        
        
        URL url = LayoutVisualization.class.getResource("/ija/textures/card_back.png");
        
    }
    
    public static LayoutVisualization get() {
	if(VIEW == null) {
            VIEW = new LayoutVisualization();
        }
        return VIEW;
    }

    public void setState() {
        try {
            URL url = LayoutVisualization.class.getResource("/ija/textures/hint.png");
            this.stateHint = ImageIO.read(url);
        }
        catch(IOException e) {
            this.stateHint = new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
        }
        
        try {
            URL url = LayoutVisualization.class.getResource("/ija/textures/selected.png");
            this.stateSelected = ImageIO.read(url);
        }
        catch(IOException e) {
            this.stateSelected = new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
        }

        
    }
        
    public BufferedImage getState(CardView.CardViewState state) {
        if(state == CardView.CardViewState.HINT_TARGET) {
            return this.stateHint;
        }
        else if(state == CardView.CardViewState.SELECTED) {
            return this.stateSelected;
        }
        else {
            return new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
        }
    }
    
    public ImageIcon getCardImage(CardView.CardViewColor color, int value) {
        ArrayList<ImageIcon> card;
        if(this.useSmallCards) {
            card = this.smallCards;
        }
        else {
            card = this.cards;
        }
        
        switch(color) {
            case SPADES:
                return card.get(value);
            case DIAMONDS:
                return card.get(13 + value);
            case HEARTS:
                return card.get(26 + value);
            case CLUBS:
                return card.get(39 + value);
            case BACK:
                return card.get(52 + value + 1);
            case NONE:
                return card.get(52 + value + 2);
            case NEW_DECK:
                return card.get(52 + value + 3);
            default:
                return card.get(52 + value + 1);
            
        }
        
        
    }
    
    public void setUsingSmallCards(boolean value) {
        this.useSmallCards = value;
    }
    
    public boolean isLayoutChanged() {
        return this.useSmallCards;
    }
    


}
