/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.userinterface;

import com.game.gameobject.MegaMan.MegaMan;
import com.game.gameobject.MegaMan.PhysicalMap;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author lepha
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {

    private Thread thread;

    private boolean isRunning;

    private InputManager inputManager;

    private BufferedImage buffImage;

    private Graphics2D bufG2D;
    
    MegaMan megaman = new MegaMan(300, 300, 100, 100, 0.1f);
    PhysicalMap physicalMap = new PhysicalMap(0,0);

    public GamePanel() {
        inputManager = new InputManager(this);

        buffImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(buffImage, 0, 0, this);
    }
    
    public void UpdateGame(){
        megaman.update();
    }

    public void RenderGame() {
        if (buffImage == null) {
            buffImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }

        if (buffImage != null) {
            bufG2D = (Graphics2D) buffImage.getGraphics();
        }

        if (bufG2D != null) {
            bufG2D.setColor(Color.WHITE);
            bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
            
            //Draw here
            megaman.draw(bufG2D);
            
            physicalMap.draw(bufG2D);
        }
    }

    public void startGame() {
        if (thread == null) {
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {

        long FPS = 40;
        long period = 1000 * 1000000 / FPS;
        long beginTime;
        long sleepTime;


        beginTime = System.nanoTime();
        while (isRunning) {
            
            // Update game
            UpdateGame();
            RenderGame();
            repaint();

            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;

            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime / 1000000);
                } else {
                    Thread.sleep(period / 2000000);
                }
            } catch (InterruptedException ex) {
            }

            beginTime = System.nanoTime();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        inputManager.processKeyPressed(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {

        inputManager.processKeyReleased(e.getKeyCode());

    }

}
