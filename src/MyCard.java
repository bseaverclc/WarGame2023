import javax.swing.*;

public class MyCard {

    String imageName;
    int value;
    String suit;
    ImageIcon icon;

    public MyCard(String imageName, int value, String suit){
        this.imageName = imageName;
        this.value = value;
        this.suit = suit;
    }

    public String getImageName() {
        return imageName;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }
}
