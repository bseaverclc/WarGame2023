import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;

public class Main
{
    public static void main(String[] args){



        JFrame frame = new JFrame();
        frame.setSize(500,500);

        JPanel board = new JPanel();
        board.setBackground(Color.GREEN);

        // This is where you can set a layout manager of the panel
        // If you don't set one, the default is FlowLayout
        BorderLayout borderLayout = new BorderLayout();

        board.setLayout(borderLayout);

        //
        JLabel title = new JLabel("War Game", SwingConstants.CENTER);
        board.add(title,BorderLayout.PAGE_START );

        //Creating the Player's Panel
//        JPanel playerPanel = new JPanel();
//        playerPanel.setOpaque(false);
//        ImageIcon icon = new ImageIcon("images/Playing Cards/PNG-cards-1.3/2_of_clubs.png");
//        // Scaling the image before putting it on the label
//        icon.setImage(icon.getImage().getScaledInstance(frame.getWidth()/3,(int)(frame.getHeight()*.80),Image.SCALE_DEFAULT));
//        // Creating a Label with an icon on it
//        JLabel playerPicLabel = new JLabel(icon);
//        playerPanel.add(playerPicLabel);

        CardPanel playerPanel = new CardPanel("images/Playing Cards/PNG-cards-1.3/2_of_clubs.png", frame);
        board.add(playerPanel,BorderLayout.LINE_START);




        //Creating the Computer's Panel
//        JPanel computerPanel = new JPanel();
//        ImageIcon icon2 = new ImageIcon("images/Playing Cards/PNG-cards-1.3/5_of_clubs.png");
//        // Scaling the image before putting it on the label
//        icon2.setImage(icon2.getImage().getScaledInstance(frame.getWidth()/3,(int)(frame.getHeight()*.8),Image.SCALE_DEFAULT));
//        // Creating a Label with an icon on it
//        JLabel computerPicLabel = new JLabel(icon2);
//        computerPanel.add(computerPicLabel);
        CardPanel computerPanel = new CardPanel("images/Playing Cards/PNG-cards-1.3/5_of_clubs.png",frame);
        board.add(computerPanel,BorderLayout.LINE_END);

        // Creating the Center Panel
//        JPanel center = new JPanel(); // flow layout
//        GridLayout grid = new GridLayout(2,1);
//        center.setLayout(grid);
//
//        JLabel winner = new JLabel("winner?", SwingConstants.CENTER);
//        JButton playButton = new JButton("Push Me");
//        playButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Hi");
//
//
//            }
//        });
//
//        center.add(winner);
//        center.add(playButton);
        CenterPanel center = new CenterPanel(playerPanel,computerPanel, frame);
        board.add(center, BorderLayout.CENTER);

        frame.add(board);
        frame.pack();

        frame.setVisible(true);


    }
}