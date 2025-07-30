/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.com.game.gameobject.MegaMan;

import java.com.game.state.GameWorldState;
import java.com.game.effect.Animation;
import java.com.game.effect.CacheDataLoader;
import static java.com.game.gameobject.MegaMan.ParticularObject.LEFT_DIR;
import static java.com.game.gameobject.MegaMan.ParticularObject.NOBEHURT;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SmallRedGun extends ParticularObject{

    private Animation forwardAnim, backAnim;
    
    private long startTimeToShoot;
    
    public SmallRedGun(float x, float y, GameWorldState gameWorld) {
        super(x, y, 127, 89, 0, 100, gameWorld);
        backAnim = CacheDataLoader.getInstance().getAnimation("smallredgun");
        forwardAnim = CacheDataLoader.getInstance().getAnimation("smallredgun");
        forwardAnim.flipAllImage();
        startTimeToShoot = 0;
        setTimeForNoBehurt(300000000);
    }

    @Override
    public void attack() {
    
        Bullet bullet = new YellowFlowerBullet(getPosX(), getPosY(), getGameWorld());
        bullet.setSpeedX(-3);
        bullet.setSpeedY(3);
        bullet.setTeamType(getTeamType());
        getGameWorld().bulletManager.addObject(bullet);
        
        bullet = new YellowFlowerBullet(getPosX(), getPosY(), getGameWorld());
        bullet.setSpeedX(3);
        bullet.setSpeedY(3);
        bullet.setTeamType(getTeamType());
         getGameWorld().bulletManager.addObject(bullet);
    }

    
    public void Update(){
        super.Update();
        if(System.nanoTime() - startTimeToShoot > 1000*10000000*2.0){
            attack();
            System.out.println("Red Eye attack");
            startTimeToShoot = System.nanoTime();
        }
    }
    
    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        Rectangle rect = getBoundForCollisionWithMap();
        rect.x += 20;
        rect.width -= 40;
        
        return rect;
    }

    @Override
    public void draw(Graphics2D g2) {
        if(!isObjectOutOfCameraView()){
            if(getState() == NOBEHURT && (System.nanoTime()/10000000)%2!=1){
                // plash...
            }else{
                if(getDirection() == LEFT_DIR){
                    backAnim.Update(System.nanoTime());
                    backAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), 
                            (int)(getPosY() - getGameWorld().camera.getPosY()), g2);
                }else{
                    forwardAnim.Update(System.nanoTime());
                    forwardAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), 
                            (int)(getPosY() - getGameWorld().camera.getPosY()), g2);
                }
            }
        }
        //drawBoundForCollisionWithEnemy(g2);
    }
    
}

