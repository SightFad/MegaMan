/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.effect;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author lepha
 */
public class FrameImage {
    
    private String name;
    private BufferedImage image;
    
    public FrameImage(String name, BufferedImage image) {
        this.name = name;
        this.image = image;
    }
    
    public FrameImage(FrameImage frameImage) {
        
        image = new BufferedImage(frameImage.getImageWidth(), frameImage.getImageHeight(), 
                frameImage.getImage().getType());
        
        Graphics g = image.getGraphics();
        g.drawImage(frameImage.getImage(), 0, 0, null);
    }
    
    FrameImage(){
        
        image = null;
        name = null;
        
    }
    
    public void draw(Graphics2D g, int x, int y) {
        g.drawImage(image, x - image.getWidth()/2, y - image.getHeight()/2, null);
    }
    
    public int getImageWidth(){
        return image.getWidth();
    }
    
    public int getImageHeight(){
        return image.getHeight();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    
}
