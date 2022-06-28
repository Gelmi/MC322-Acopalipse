package com.mctresdoisdois.acopalipse.model.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mctresdoisdois.acopalipse.model.GameModel;

public abstract class ItemModel extends EntityModel{

	private EntityModel entityModel;
	private int dustPerSecond;
	private int price;
	private int power;
	private String itemName; 
	private Boolean buy;
	
	protected ItemModel(GameModel model, EntityModel entityModel, float x, float y, float height, float width, float rotation, int dps, int price, int power, String itemName) {
		super(model, x, y, height, width, rotation);
		this.entityModel = entityModel;
		dustPerSecond = dps;
		this.price = price;
		buy = false;
		this.power = power;
		this.itemName = itemName;
	}
	
	public abstract Sprite createSprite();

	public void buy() {
		this.buy = true;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getPower() {
		return power;
	}
	
	public String getName() {
		return itemName;
	}
	
	public Boolean getBuy() {
		return buy;
	}
	
	public int getDustPerSecond() {
		return dustPerSecond;
	}
	
	public Vector2 getPowerUpgradeVector() {
		return new Vector2(5, price * (float)Math.pow(10,((power/5))));
	}
	
	public Vector2 getDPSUpgradeVector() {
		return new Vector2(2, price * (float)Math.pow(10,((dustPerSecond/10))));
	}
	
	public void buyPowerUpgrade(int powerUpgrade) {
		power+=powerUpgrade;
	}
	
	public void buyDPSUpgrade(int dpsUpgrade) {
		dustPerSecond*=dpsUpgrade;
	}
}
