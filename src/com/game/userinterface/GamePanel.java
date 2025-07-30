// GamePanel.java - Vẽ và cập nhật game.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.userinterface;

import java.com.game.state.GameWorldState;
import java.com.game.state.MenuState;
import java.com.game.state.State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

// Lớp GamePanel kế thừa từ JPanel và triển khai Runnable, KeyListener để xử lý vẽ game và đầu vào.
public class GamePanel extends JPanel implements Runnable, KeyListener{

// Trạng thái hiện tại của game (ví dụ: menu, chơi game, v.v.)
    State gameState;

// Quản lý đầu vào từ bàn phím.
    InputManager inputManager;
    
// Luồng riêng cho game để xử lý logic mà không làm đứng UI.
    Thread gameThread;

    public boolean isRunning = true;

    public GamePanel(){

        //gameState = new MenuState(this);
        gameState = new GameWorldState(this);
        
        inputManager = new InputManager(gameState);

    }

// Bắt đầu game: tạo và khởi động luồng game.
    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    int a = 0;
    @Override
// Phương thức chạy luồng game - thực hiện game loop (vòng lặp cập nhật và vẽ game).
    public void run() {

        long previousTime = System.nanoTime();
        long currentTime;
        long sleepTime;

        long period = 100000000/80;

        while(isRunning){

            gameState.Update();
            gameState.Render();


// Gọi phương thức vẽ lại game trên JPanel.
            repaint();

            currentTime = System.nanoTime();
            sleepTime = period - (currentTime - previousTime);
            try{

                    if(sleepTime > 0)
                            Thread.sleep(sleepTime/1000000);
                    else Thread.sleep(period/2000000);

            }catch(Exception e){}

            previousTime = System.nanoTime();
        }

    }

    public void paint(Graphics g){

        g.drawImage(gameState.getBufferedImage(), 0, 0, this);

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        inputManager.setPressedButton(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputManager.setReleasedButton(e.getKeyCode());
    }

    public void setState(State state) {
        gameState = state;
        inputManager.setState(state);
    }
    
}