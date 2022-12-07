package Tiles;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;

    public int[][] mapTileNum;                                          //creates a 2 dimensional array

/**************************************************| Tile Settings |***************************************************/

    public TileManager(GamePanel gp){

        this.gp = gp;

        tile = new Tile[22];                                             /**Change Number to Change Max Tiles Allowed**/

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();     //gets image
        loadMap("/Resources/Maps/map.txt");                 /**Change .txt File To Change What Map To Use**/
    }

/*****************************************| Get Tile Images From Resources |*******************************************/

    public void getTileImage(){                     //constructs and finds new tiles and tile .png location

        try{
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/LandSprites/emptySpace.png")));
        tile[0].collision = false;

        tile[1] = new Tile();
        tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/LandSprites/asteroids.png")));
        tile[1].collision = true;

        tile[2] = new Tile();
        tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/LandSprites/planet.png")));
        tile[2].collision = false;

        tile[3] = new Tile();
        tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/LandSprites/nova.png")));
        tile[3].collision = false;

        tile[4] = new Tile();
        tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/LandSprites/spaceStation.png")));
        tile[4].collision = true;

        tile[5] = new Tile();
        tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/LandSprites/blackHole.png")));
        tile[5].collision = false;

        tile[6] = new Tile();
        tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/LandSprites/")));
        tile[6].collision = true;

        tile[7] = new Tile();
        tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/LandSprites/")));
        tile[7].collision = false;

        tile[8] = new Tile();
        tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resources/LandSprites/")));
        tile[8].collision = false;

        }catch (IOException e){
            e.printStackTrace();
        }
    }

/****************************************| Convert Text File Into Map Data |*******************************************/

public void loadMap(String mapchoice){                                     //LOADS MAP TEXT FILE INTO GAME

        try{
            InputStream is = getClass().getResourceAsStream(mapchoice);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){               //while loop to go through values in .txt

                String line = br.readLine();                                   //READS LINE OF TEXT FROM TEXT FILE

                while(col < gp.maxWorldCol){                                   //second while loop to change columns

                    String[] numbers = line.split(" ");                  //continues to read with spaces
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch(Exception ignored){}
    }

/************************************| Draw Graphics From Images and Map Data |****************************************/

    public void draw(Graphics2D g2){

    int worldCol = 0;
    int worldRow = 0;


    while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

        int tileNum = mapTileNum[worldCol][worldRow];      //Gives us which tile to display

        int WorldX = worldCol * gp.tileSize;               //sets World x position
        int WorldY = worldRow * gp.tileSize;               //sets World y position

        int ScreenX = WorldX - gp.player.worldX + gp.player.screenX;
        int ScreenY = WorldY - gp.player.worldY + gp.player.screenY;

        g2.drawImage(tile[tileNum].image, ScreenX, ScreenY, gp.tileSize, gp.tileSize, null);  //draws from.txt

        worldCol++;


        if (worldCol == gp.maxWorldCol){
            worldCol = 0;

            worldRow++;

        }
    }
    }

}
