package Main;

import Tiles.TileManager;
import entity.Player;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable{

/**********************************************| SCREEN SETTINGS + FPS |***********************************************/

    final int originalTileSize = 32;                    //creates a 32x32 tile, or building block
    final int scale = 2;                                //sets amount to scale 32x32 tiles by

    public final int tileSize = originalTileSize * scale;      //creates scaled tile size (64x64)

    public final int maxScreenCol = 20;                        //sets column limit
    public final int maxScreenRow = 10;                         //sets row limit       (16*9 Aspect Ratio)
    public final int ScreenWidth = tileSize * maxScreenCol;    //1536 pixels wide
    public final int ScreenHeight = tileSize * maxScreenRow;   //864 pixels high


    int FPS = 60;                                        //limit frames per second to 60
/*************************************************| WORLD SETTINGS |***************************************************/

public final int maxWorldCol = 100;                              //sets world column limit
public final int maxWorldRow = 100;                              //sets world row limit
/***************************************************| CONSTRUCTOR |****************************************************/

    public GamePanel(){                                                     //creates GamePanel

        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));    //sets window dimensions
        this.setBackground(Color.black);                                    //sets background color
        this.setDoubleBuffered(true);                                       //draws in an offscreen buffer, fast render
        this.addKeyListener(keyH);                                          //adds key listener to know keys pressed
        this.setFocusable(true);                                            //allow game panel to receive key input


    }

/*****************************************| IN GAME CLOCK AND UPDATES (FPS) |******************************************/


    TileManager tileM = new TileManager(this);                          //create tile manager
    KeyHandler keyH = new KeyHandler();                                     //creates input manager
    Sound sound = new Sound();                                              //Create Soung
    public Player player = new Player(this,keyH);                       //creates player
    public Collision colli = new Collision(this);                       //creates collision update
    Thread gameThread;                                                      //creates continuous thread



    public void startGameThread(){                                          //creates startGameThread
        gameThread = new Thread(this);                                //new thread, gameThread
        gameThread.start();                                                //starts new gameThread
        playMusic(0);
    }

    @Override
    public void run(){
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }


/*********************************************| KEYBOARD INPUT SETTINGS |**********************************************/

public void update(){                                       //updates Panel
    player.update();                                        //calls update from Player.java
}

/**************************************************| CREATE OBJECT |***************************************************/

    public void paintComponent(Graphics g){                 //print updates to screen

        super.paintComponent(g);                            //mandatory for line above

        Graphics2D g2 = (Graphics2D)g;                      //change Graphics above to Graphics2D for more functions

        tileM.draw(g2);                                     //cals draw from Tile.java
        player.draw(g2);                                    //calls draw from Player.java

        g2.dispose();                                       //ends g2 after use
    }

/*************************************************| Sound Settings |***************************************************/
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(int i) {
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }



















































}