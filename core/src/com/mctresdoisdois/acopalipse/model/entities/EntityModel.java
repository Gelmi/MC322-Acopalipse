package com.mctresdoisdois.acopalipse.model.entities;

import com.mctresdoisdois.acopalipse.model.GameModel;

public abstract class EntityModel {
	private float x;
	private float y;
	private float height;
	private float width;
	private float rotation;
	private GameModel model;
	
	EntityModel(GameModel model, float x, float y, float height, float width, float rotation) {
		this.model = model;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.rotation = rotation;
    }
	
	public GameModel getModel() {
		return model;
	}
	
	public float getX() {
	    return x;
	}


	public float getY() {
	    return y;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getRotation() {
        return rotation;
    }
	
	public void setSize(float height, float width) {
		this.height = height;
		this.width = width;
	}
	
	public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
	
	public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
