/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.com.game.gameobject.MegaMan;

import java.com.game.state.GameWorldState;

public abstract class GameObject {

	private float posX;
	private float posY;
	
	private GameWorldState gameWorld;
	
	public GameObject(float x, float y, GameWorldState gameWorld){
		posX = x;
		posY = y;
		this.gameWorld = gameWorld;
	}
	
	public void setPosX(float x){
		posX = x;
	}
	
	public float getPosX(){
		return posX;
	}
	
	public void setPosY(float y){
		posY = y;
	}
	
	public float getPosY(){
		return posY;
	}
	
	public GameWorldState getGameWorld(){
		return gameWorld;
	}
	
	public abstract void Update();
	
}

