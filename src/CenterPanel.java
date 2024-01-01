import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CenterPanel extends JPanel {

    JLabel result = new JLabel("result text");
    JButton playButton = new JButton("play");
    CardPanel playerPanel, computerPanel;
    JFrame frame;

    DeckOfCards deck, playerDeck, computerDeck;


    JPanel bottomPanel = new JPanel(new GridLayout(1,2));
    JLabel playerLabel, computerLabel;

    public CenterPanel(CardPanel playerPanel, CardPanel computerPanel, JFrame frame){
        this.frame = frame;
        this.playerPanel = playerPanel;
        this.computerPanel = computerPanel;

        deck = new DeckOfCards("poker");
        deck.shuffle();

        playerDeck = new DeckOfCards();
        computerDeck = new DeckOfCards();
        while (deck.getNumCards()>0){
            playerDeck.addCard(deck.getNext());
            computerDeck.addCard(deck.getNext());
        }

        this.setLayout(new GridLayout(3,1));
        result = new JLabel("", SwingConstants.CENTER);
        playButton = new JButton("play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button pushed");
                MyCard player = playerDeck.getNext();
                MyCard computer = computerDeck.getNext();
               playerPanel.setImage("images/Playing Cards/PNG-cards-1.3/" + player.getImageName());
                computerPanel.setImage("images/Playing Cards/PNG-cards-1.3/" + computer.getImageName());

                if (player.getValue() > computer.getValue()){
                    result.setText("You Win!");
                    playerDeck.addCard(player);
                    playerDeck.addCard(computer);
                    playerLabel.setText(playerDeck.getNumCards() + " Cards");
                    computerLabel.setText(computerDeck.getNumCards() + " Cards");
                }
                else if (player.getValue() < computer.getValue()){
                        result.setText("You Lose");
                        computerDeck.addCard(player);
                        computerDeck.addCard(computer);
                        playerLabel.setText(playerDeck.getNumCards() + " Cards");
                        computerLabel.setText(computerDeck.getNumCards() + " Cards");
                    }
                else{
                    result.setText("War!");

                }



            }
        });

        this.add(result);
        this.add(playButton);

        playerLabel = new JLabel(playerDeck.getNumCards() + " Cards");
        computerLabel = new JLabel(computerDeck.getNumCards() + " Cards", SwingConstants.RIGHT);
        bottomPanel.add(playerLabel);
        bottomPanel.add(computerLabel);
        this.add(bottomPanel);
    }

}
