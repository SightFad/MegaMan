// GameFrame.java - Cửa sổ game chính.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.userinterface;

import com.game.effect.CacheDataLoader;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

// Tạo frame chính của game.
public class GameFrame extends JFrame{

    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 600;

    GamePanel gamePanel;

    public GameFrame(){

        super("Mega Man java game");
// Đóng ứng dụng khi bấm nút X.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = this.getToolkit();
        Dimension solution = toolkit.getScreenSize();

        try {
            CacheDataLoader.getInstance().LoadData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        this.setBounds((solution.width - SCREEN_WIDTH)/2, (solution.height - SCREEN_HEIGHT)/2, SCREEN_WIDTH, SCREEN_HEIGHT);

        gamePanel = new GamePanel();
        addKeyListener(gamePanel);
// Thêm GamePanel vào cửa sổ.
        add(gamePanel);

    }

    public void startGame(){

            gamePanel.startGame();
// Hiển thị frame.
            this.setVisible(true);

    }

    public static void main(String arg[]){

            GameFrame gameFrame = new GameFrame();
            gameFrame.startGame();

    }
        
}