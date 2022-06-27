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
	
}
