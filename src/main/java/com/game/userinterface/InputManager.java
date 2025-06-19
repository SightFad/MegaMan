/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.userinterface;

import com.game.gameobject.MegaMan.MegaMan;
import java.awt.event.KeyEvent;

/**
 *
 * @author lepha
 */
public class InputManager {
    
    private GamePanel gamePanel;
    
    public InputManager(GamePanel gamepanel) {
        this.gamePanel = gamepanel;
    }
    
    public void processKeyPressed(int keyCode){
        
        switch(keyCode) {
        
        case KeyEvent.VK_W:
        gamePanel.physicalMap.y+=17;
        break;
            
        case KeyEvent.VK_A:
        gamePanel.megaman.setDirection(MegaMan.DIR_LEFT);   
        gamePanel.megaman.setSpeedX(-5);
        gamePanel.physicalMap.x+=37;
        break;          
        
        case KeyEvent.VK_S:
        gamePanel.physicalMap.y-=17;    
        break;
        
        case KeyEvent.VK_D:
        gamePanel.megaman.setDirection(MegaMan.DIR_RIGHT);       
        gamePanel.megaman.setSpeedX(5);
        gamePanel.physicalMap.x-=37;
        break;
        
        case KeyEvent.VK_ENTER:
        
        break;
        
        case KeyEvent.VK_SPACE:
        gamePanel.megaman.setSpeedY(-3);
        gamePanel.megaman.setPosY(gamePanel.megaman.getPosY() - 3);
        break;
        
        case KeyEvent.VK_TAB:
        
        break;
    }
        
    }
    
    public void processKeyReleased(int keyCode){
        
        switch(keyCode) {
        
        case KeyEvent.VK_W:
        
        break;
            
        case KeyEvent.VK_A:
        gamePanel.megaman.setSpeedX(0);
        break;          
        
        case KeyEvent.VK_S:
        
        break;
        
        case KeyEvent.VK_D:
        gamePanel.megaman.setSpeedX(0);
        break;
        
        case KeyEvent.VK_ENTER:
        
        break;
        
        case KeyEvent.VK_SPACE:
        
        break;
        
        case KeyEvent.VK_TAB:
        
        break;
    }
        
    }
}
