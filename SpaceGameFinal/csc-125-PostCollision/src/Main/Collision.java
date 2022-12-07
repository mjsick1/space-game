package Main;

import entity.Player;

public class Collision {

    GamePanel gp;

    public Collision(GamePanel gp){

        this.gp = gp;
    }

/***********************************************| CHECK FOR COLLISION |************************************************/

    public void checkTile(Player entity){

        int playerLeftWorldX = entity.worldX + 16;
        int playerRightWorldX = entity.worldX + 16;
        int playerTopWorldY = entity.worldY + 16;
        int playerBottomWorldY = entity.worldY + 16 + 16;

        int playerLeftCol = playerLeftWorldX / gp.tileSize;
        int playerRightCol = playerRightWorldX / gp.tileSize;
        int playerTopRow = playerTopWorldY / gp.tileSize;
        int playerBottomRow = playerBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case "up":
                playerTopRow = (playerTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[playerLeftCol][playerTopRow];
                tileNum2 = gp.tileM.mapTileNum[playerRightCol][playerTopRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
            break;
            case "left":
                playerLeftCol = (playerLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[playerLeftCol][playerTopRow];
                tileNum2 = gp.tileM.mapTileNum[playerLeftCol][playerBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
            break;
            case "down":
                playerBottomRow = (playerBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[playerLeftCol][playerBottomRow];
                tileNum2 = gp.tileM.mapTileNum[playerRightCol][playerRightCol];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
            break;
            case "right":
                playerRightCol = (playerLeftWorldX + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[playerRightCol][playerTopRow];
                tileNum2 = gp.tileM.mapTileNum[playerRightCol][playerBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
            break;
        }

    }
}
