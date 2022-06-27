package com.mctresdoisdois.acopalipse.model.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mctresdoisdois.acopalipse.model.GameModel;

public class TableModel extends EntityModel{
	
	private Array<Array<SectorModel>> sectorModelMatrix;
	private Vector2 selectedSector;
	
	public TableModel(GameModel model, float x, float y, float height, float width, float rotation) {
		super(model, x, y, height, width, rotation);
		
		sectorModelMatrix = new Array<Array<SectorModel>>();
		
		for(int i = 0; i < 4; i++) {
			sectorModelMatrix.add(new Array<SectorModel>());
			for(int j = 0; j < 4; j++) {
				sectorModelMatrix.get(i).add(new SectorModel(this, 64*(i+1), 64*(j+1), 64, 64, 0)); 
			}
		}
	}
	
	public Array<Array<SectorModel>> getSectorModelMatrix() {
		return sectorModelMatrix;
	}
			
	public void touch(Vector3 touchPos) {
		
	}

	public Vector2 getSelectedSector() {
		return selectedSector;
	}

	public void setSelectedSector(Vector2 selectedSector) {
		this.selectedSector = selectedSector;
	}
	
	public void buy(ItemModel itemModel) {
		int i = ((int)selectedSector.x) - 1;
		int j = ((int)selectedSector.y) - 1;
		itemModel.setPosition(64*(i+1), 64*(j+1));
		itemModel.buy();
		sectorModelMatrix.get(i).get(j).setMeteor(itemModel);
	}
	
	public int getDustPerSecond() {
		int dps = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				ItemModel sectorModelItem = sectorModelMatrix.get(i).get(j).getMeteor();
				if(sectorModelItem != null) {
					dps += sectorModelItem.getDustPerSecond();
				}
			}
		}
		return dps;
	}
	
	public int getTotalPower() {
		int totalPower = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				ItemModel sectorModelItem = sectorModelMatrix.get(i).get(j).getMeteor();
				if(sectorModelItem != null) {
					totalPower += sectorModelItem.getPower();
				}
			}
		}
		return totalPower;
	}
}
