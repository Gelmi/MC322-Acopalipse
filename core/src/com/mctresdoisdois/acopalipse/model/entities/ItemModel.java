package com.mctresdoisdois.acopalipse.model.entities;

import com.mctresdoisdois.acopalipse.model.GameModel;

public class ItemModel extends EntityModel{

	EntityModel entityModel;
	int dustPerSecond;
	int price;
	int power;
	Boolean buy;
	
	protected ItemModel(GameModel model, EntityModel entityModel, float x, float y, float height, float width, float rotation, int dps, int price, int power) {
		super(model, x, y, height, width, rotation);
		this.entityModel = entityModel;
		dustPerSecond = dps;
		this.price = price;
		buy = false;
		this.power = power;
	}

	public void buy() {
		this.buy = true;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getPower() {
		return power;
	}
	
	public Boolean getBuy() {
		return buy;
	}
	
	public int getDustPerSecond() {
		return dustPerSecond;
	}
	
}
