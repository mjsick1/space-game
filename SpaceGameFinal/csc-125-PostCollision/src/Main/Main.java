package Main;

import javax.swing.*;

public class Main {

    public static void main(String[] args){

/************************************************| WINDOW SETTINGS |***************************************************/

        JFrame window = new JFrame();                           //creates window

        window.setTitle("SpaceGame");                           //names window
        window.setLocationRelativeTo(null);                     //centers window when it opens
        window.setResizable(true);                              //makes window resizable
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //exits game on window close

        GamePanel gamePanel = new GamePanel();                  //creates new gamePanel
        window.add(gamePanel);                                  //adds new gamePanel, which adds to the JPanel
        window.pack();                                          //sizes window to specified size in Screen Settings

        window.setLocationRelativeTo(null);
        window.setVisible(true);

/**************************************************| Start Game |******************************************************/

        gamePanel.startGameThread();

    } //End of Class
} //End of Main
