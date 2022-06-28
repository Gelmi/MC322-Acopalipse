package com.mctresdoisdois.acopalipse.model.entities;

import com.mctresdoisdois.acopalipse.model.GameModel;

public class EarthModel extends EntityModel{

	private int life;
	private int totalLife;
	
	public EarthModel(GameModel model, float x, float y, float height, float width, float rotation) {
		super(model, x, y, height, width, rotation);
		totalLife = 100;
		life = 100;
		// TODO Auto-generated constructor stub
	}
	
	public void damage(int life) {
		this.life-=life;
	}
	
	public void attack() {
		damage(getModel().getTableModel().getTotalPower());
		if(life<=0) {
			getModel().getAchievementsModel().newTable(getModel().getTableModel().getSectorModelMatrix());
		}
		getModel().getTableModel().destroyMeteors();
	}
	
	public int getLife() {
		return life;
	}
	
	public int getTotalLife() {
		return totalLife;
	}

}
