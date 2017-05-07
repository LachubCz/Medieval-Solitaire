package ija.ija2016.homework3.view;

import java.awt.Image;
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
        ImageIcon imageEmpty = new ImageIcon(new ImageIcon(LayoutVisualization.class.getResource("/ija/textures/empty.png"))
                .getImage().getScaledInstance(165, 320, Image.SCALE_SMOOTH));
        ImageIcon imageEmptySmall = new ImageIcon(imageEmpty.getImage().getScaledInstance(82, 160, Image.SCALE_SMOOTH));
        
        cards.add(imageEmpty);
        smallCards.add(imageEmptySmall);
        
        for(int i = 1; i <= 13; i++) {
            ImageIcon imageCard = new ImageIcon(new ImageIcon(LayoutVisualization.class.getResource("/ija/textures/S" + i + ".png"))
                .getImage().getScaledInstance(165, 320, Image.SCALE_FAST));
            
            ImageIcon imageCardSmall = new ImageIcon(imageCard.getImage().getScaledInstance(82, 160, Image.SCALE_FAST));
            
            cards.add(imageCard);
            smallCards.add(imageCardSmall);
        }
        
        for(int i = 1; i <= 13; i++) {
            ImageIcon imageCard = new ImageIcon(new ImageIcon(LayoutVisualization.class.getResource("/ija/textures/D" + i + ".png"))
                .getImage().getScaledInstance(165, 320, Image.SCALE_FAST));
            
            ImageIcon imageCardSmall = new ImageIcon(imageCard.getImage().getScaledInstance(82, 160, Image.SCALE_FAST));
            
            cards.add(imageCard);
            smallCards.add(imageCardSmall);
        }
        
        for(int i = 1; i <= 13; i++) {
            ImageIcon imageCard = new ImageIcon(new ImageIcon(LayoutVisualization.class.getResource("/ija/textures/H" + i + ".png"))
                .getImage().getScaledInstance(165, 320, Image.SCALE_FAST));
            
            ImageIcon imageCardSmall = new ImageIcon(imageCard.getImage().getScaledInstance(82, 160, Image.SCALE_FAST));
            
            cards.add(imageCard);
            smallCards.add(imageCardSmall);
        }
        
        for(int i = 1; i <= 13; i++) {
            ImageIcon imageCard = new ImageIcon(new ImageIcon(LayoutVisualization.class.getResource("/ija/textures/C" + i + ".png"))
                .getImage().getScaledInstance(165, 320, Image.SCALE_FAST));
            
            ImageIcon imageCardSmall = new ImageIcon(imageCard.getImage().getScaledInstance(82, 160, Image.SCALE_FAST));
            
            cards.add(imageCard);
            smallCards.add(imageCardSmall);
        }
        
        ImageIcon imageBack= new ImageIcon(new ImageIcon(LayoutVisualization.class.getResource("/ija/textures/card_back.png"))
                .getImage().getScaledInstance(165, 320, Image.SCALE_SMOOTH));
        ImageIcon imageBackSmall = new ImageIcon(imageEmpty.getImage().getScaledInstance(82, 160, Image.SCALE_SMOOTH));
        
        cards.add(imageBack);
        smallCards.add(imageBackSmall);
        
        cards.add(imageEmpty);
        smallCards.add(imageEmptySmall);
        
        ImageIcon imageReasamble= new ImageIcon(new ImageIcon(LayoutVisualization.class.getResource("/ija/textures/reassemble.png"))
                .getImage().getScaledInstance(165, 320, Image.SCALE_SMOOTH));
        ImageIcon imageReasambleSmall = new ImageIcon(imageEmpty.getImage().getScaledInstance(82, 160, Image.SCALE_SMOOTH));
        
        cards.add(imageReasamble);
        smallCards.add(imageReasambleSmall);
        
        setState();
        
        
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
        if(null == state) {
            return new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
        }
        else switch (state) {
            case HINT_TARGET:
                return this.stateHint;
            case SELECTED:
                return this.stateSelected;
            default:
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
