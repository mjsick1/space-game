package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener {


    /*************************************************| INPUT MANAGER |****************************************************/

    public boolean upPressed, leftPressed, downPressed, rightPressed;     //sets button presses to true or false

    @Override
    public void keyTyped(KeyEvent e) {                                 //Unused section created by tool
    }

    // @Override
    public void keyPressed(KeyEvent e) {                                //checks for key press

        int code = e.getKeyCode();                                      //return number of key that was pressed

        if (code == KeyEvent.VK_W) {                                    //see if user presses "W"
            upPressed = true;
        }
        if (code == KeyEvent.VK_A) {                                    //see if user presses "A"
            leftPressed = true;
        }
        if (code == KeyEvent.VK_S) {                                    //see if user presses "S"
            downPressed = true;
        }
        if (code == KeyEvent.VK_D) {                                    //see if user presses "D"
            rightPressed = true;
        }

        //UP, DOWN, LEFT, RIGHT

        if (code == KeyEvent.VK_UP) {                                    //see if user presses "UP"
            upPressed = true;
        }
        if (code == KeyEvent.VK_LEFT) {                                    //see if user presses "LEFT"
            leftPressed = true;
        }
        if (code == KeyEvent.VK_DOWN) {                                    //see if user presses "DOWN"
            downPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {                                    //see if user presses "RIGHT"
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased (KeyEvent e){                                   //checks for key release

            int code = e.getKeyCode();                                      //return number of key that was released

            if (code == KeyEvent.VK_W) {                                    //see if user releases "W"
                upPressed = false;
            }
            if (code == KeyEvent.VK_A) {                                    //see if user releases "A"
                leftPressed = false;
            }
            if (code == KeyEvent.VK_S) {                                    //see if user releases "S"
                downPressed = false;
            }
            if (code == KeyEvent.VK_D) {                                    //see if user releases "D"
                rightPressed = false;
            }

            //UP, DOWN, LEFT, RIGHT

            if (code == KeyEvent.VK_UP) {                                    //see if user releases "W"
                upPressed = false;
            }
            if (code == KeyEvent.VK_LEFT) {                                    //see if user releases "A"
                leftPressed = false;
            }
            if (code == KeyEvent.VK_DOWN) {                                    //see if user releases "S"
                downPressed = false;
            }
            if (code == KeyEvent.VK_RIGHT) {                                    //see if user releases "D"
                rightPressed = false;
            }
    }
}


