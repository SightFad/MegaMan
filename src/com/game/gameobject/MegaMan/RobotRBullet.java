/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.gameobject.MegaMan;

import com.game.state.GameWorldState;
import com.game.effect.Animation;
import com.game.effect.CacheDataLoader;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RobotRBullet extends Bullet{
	
    private Animation forwardBulletAnim, backBulletAnim;
    
    public RobotRBullet(float x, float y, GameWorldState gameWorld) {
        super(x, y, 60, 30, 1.0f, 10, gameWorld);
        forwardBulletAnim = CacheDataLoader.getInstance().getAnimation("robotRbullet");
        backBulletAnim = CacheDataLoader.getInstance().getAnimation("robotRbullet");
        backBulletAnim.flipAllImage();
    }

    
    
    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        // TODO Auto-generated method stub
        return getBoundForCollisionWithMap();
    }

    @Override
    public void draw(Graphics2D g2) {
            // TODO Auto-generated method stub
        if(getSpeedX() > 0){          
            forwardBulletAnim.Update(System.nanoTime());
            forwardBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        }else{
            backBulletAnim.Update(System.nanoTime());
            backBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        }
        //drawBoundForCollisionWithEnemy(g2);
    }

    @Override
    public void Update() {
            // TODO Auto-generated method stub
        super.Update();
    }

    @Override
    public void attack() {}

}

