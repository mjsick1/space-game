package entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

   public final int screenX;        //Final so that player character does not move, but rather the background
   public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.ScreenWidth/2 - (gp.tileSize/2);      //sets player in center of screen
        screenY = gp.ScreenHeight/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();
    }

/*************************************************| PLAYER SETTINGS |**************************************************/

    public void setDefaultValues(){
        worldX = gp.tileSize * 50;                                      //Starting X position
        worldY = gp.tileSize * 50;                                      //starting Y position
        speed = 4;                                                      //Player Speed
        direction = "down";                                             //default Direction
        solidArea = new Rectangle(8,8,8, 8);        //sets collision pixels of player
    }
/***********************************************| IMPORT PLAYER IMAGES |***********************************************/
    public void  getPlayerImage(){

        try{

       up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SUP1.png")));
       up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SUP2.png")));
       up3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SUP3.png")));
       up4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SUP4.png")));

       left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SLEFT1.png")));
       left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SLEFT2.png")));
       left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SLEFT3.png")));
       left4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SLEFT4.png")));

       right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SRIGHT1.png")));
       right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SRIGHT2.png")));
       right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SRIGHT3.png")));
       right4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SRIGHT4.png")));

       down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SDOWN1.png")));
       down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SDOWN2.png")));
       down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SDOWN3.png")));
       down4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/PlayerSprites/SDOWN4.png")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*********************************************| KEYBOARD INPUT SETTINGS |**********************************************/

    public void update(){                                    //updates game information to be displayed

        if(keyH.upPressed){
            direction = "up";                                //Here we take the input, and depending on which button is
 //           worldY -= speed;                               //pressed, the player will move in accordance with the
        }                                                    //button. "W" goes up. "A" goes left. "S" goes down.
        else if(keyH.leftPressed){                           //"D" goes right.
            direction = "left";
  //          worldX -= speed;
        }
        else if(keyH.downPressed){
            direction = "down";
   //         worldY += speed;
        }
        else if(keyH.rightPressed){
            direction = "right";
   //         worldX += speed;
        }

/****************************************| CHECK FOR COLLISION, MOVE IF NONE |*****************************************/
        collisionOn = false;
        gp.colli.checkTile(this);

        if(!collisionOn){

            switch(direction){
                case "up":
                    worldY -= speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }

        }

/*********************************************| IDLE ANIMATION PROGRAM |***********************************************/

         this.spriteCounter++;                //this program would change the image used based off a counter that
        if(this.spriteCounter > 12) {           //alternates between one and two
            if(this.spriteNum == 1) {
                this.spriteNum = 2;
            }
   //         else if(this.spriteNum == 2) {
     //           this.spriteNum = 1;
       //     }
            else if(this.spriteNum == 2) {
                this.spriteNum = 3;
            }
            else if(this.spriteNum == 3) {
                this.spriteNum = 4;
            }
            else if(this.spriteNum == 4) {
                this.spriteNum = 1;
            }

            spriteCounter = 0;
        }
    }


    public void draw(Graphics2D g2){

    //    g2.setColor(Color.white);                           //set color of player to white
    //    g2.fillRect(x, y, gp.tileSize, gp.tileSize);       //set dimensions for player, at the specified position

        BufferedImage image = null;

        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                if(spriteNum == 3){
                    image = up3;
                }
                if(spriteNum == 4){
                    image = up4;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                if(spriteNum == 3){
                    image = down3 ;
                }
                if(spriteNum == 4){
                    image = down4;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                if(spriteNum == 3){
                    image = left3;
                }
                if(spriteNum == 4){
                    image = left4;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                if(spriteNum == 3){
                    image = right3;
                }
                if(spriteNum == 4){
                    image = right4;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);//Draws image of player onto screen
        //ScreenX, WorldX, based on whether you want world or player to move


    }

}
