import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    JPanel thePanel;
    ImageIcon icon;
    JLabel picLabel;
    JFrame frame;

    public CardPanel(String cardName, JFrame frame){

        this.frame = frame;
        this.setOpaque(false);
        icon = new ImageIcon(cardName);
        icon.setImage(icon.getImage().getScaledInstance(150,400,Image.SCALE_DEFAULT));
        picLabel = new JLabel(icon);
        this.add(picLabel);

    }


    public void setImage(String newImage){
        icon = new ImageIcon(newImage);
        icon.setImage(icon.getImage().getScaledInstance(150,400,Image.SCALE_DEFAULT));
        picLabel = new JLabel(icon);
        this.removeAll();
        this.add(picLabel);

        this.revalidate();

    }


}
