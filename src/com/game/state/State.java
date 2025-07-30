/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.state;
import com.game.userinterface.GamePanel;
import java.awt.image.BufferedImage;

public abstract class State {
    
    protected GamePanel gamePanel;
    
    public State(GamePanel gamePanel) {
       this.gamePanel = gamePanel; 
    }
    
    public abstract void Update();
    public abstract void Render();
    public abstract BufferedImage getBufferedImage();
    
    public abstract void setPressedButton(int code);
    public abstract void setReleasedButton(int code);
}

