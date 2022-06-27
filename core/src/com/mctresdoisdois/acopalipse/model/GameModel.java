package com.mctresdoisdois.acopalipse.model;

import com.badlogic.gdx.utils.TimeUtils;
import com.mctresdoisdois.acopalipse.model.entities.StoreModel;
import com.mctresdoisdois.acopalipse.model.entities.TableModel;

public class GameModel {

	private final TableModel tableModel;
	private final StoreModel storeModel;
	private int dust;
	private long lastDustTime;
	private int totalPower;
	
	public GameModel() {
		tableModel = new TableModel(this, 64, 64, 256, 256, 0);
		storeModel = new StoreModel(this, 384, 64, 192, 256, 0);
		dust = 50;
		lastDustTime = 0;
		totalPower = 0;
	}
	
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public StoreModel getStoreModel() {
		return storeModel;
	}
	
	public void addDust() {
		this.dust+=tableModel.getDustPerSecond();
		lastDustTime = TimeUtils.nanoTime();
	}
	
	public void subDust(int dust) {
		this.dust-=dust;
	}
	
	public long getLastDustTime() {
		return lastDustTime;
	}
	
	public int getDust() {
		return dust;
	}
	
	public void updateTotalPower() {
		totalPower = tableModel.getTotalPower();
	}
	
	public int getTotalPower() {
		return totalPower;
	}
}
