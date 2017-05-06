package ija.ija2016.homework3.view;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class LayoutVisualization {
    private BufferedImage stateHint;
    private BufferedImage stateSelected;
    
    static LayoutVisualization VIEW = null;
    private ArrayList<ImageIcon> cards = new ArrayList<>();
    private ArrayList<ImageIcon> smallCards = new ArrayList<>();
    private boolean useMiniatures = false;

    
    
	public static LayoutVisualization get() {
		if(VIEW == null) {
                    VIEW = new LayoutVisualization();
                }
                return VIEW;
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

}
