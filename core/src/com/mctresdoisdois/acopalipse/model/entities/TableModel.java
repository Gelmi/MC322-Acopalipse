package com.mctresdoisdois.acopalipse.model.entities;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.model.entities.meteors.*;

public class TableModel extends EntityModel{
	
	private Array<Array<SectorModel>> sectorModelMatrix;
	private Vector2 selectedSector;
	private List<List<String>> config;
	
	public TableModel(GameModel model, float x, float y, float height, float width, float rotation) {
		super(model, x, y, height, width, rotation);
		
		sectorModelMatrix = new Array<Array<SectorModel>>();
		
		for(int i = 0; i < 4; i++) {
			sectorModelMatrix.add(new Array<SectorModel>());
			for(int j = 0; j < 4; j++) {
				sectorModelMatrix.get(i).add(new SectorModel(this, 64*(i+1), 64*(j+1), 64, 64, 0)); 
			}
		}
		
		config = Arrays.asList(Arrays.asList("","poder","atracao","curto"),Arrays.asList("terra","10000","",""),
				Arrays.asList("meteroro","5","5","50"), Arrays.asList("fogo","50","50","500"), Arrays.asList("gelo","50","50","500"),
				Arrays.asList("gas","5","50","10000"));
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
	
	public SectorModel getSelectedSectorModel() {
		SectorModel sectorModel = null;
		if(selectedSector!=null) sectorModel = sectorModelMatrix.get((int)(selectedSector.x-1)).get((int)(selectedSector.y-1));
		return sectorModel;
	}
	
	public void buy(ItemModel itemModel) {
		int i = ((int)selectedSector.x) - 1;
		int j = ((int)selectedSector.y) - 1;
		itemModel.setPosition(64*(i+1), 64*(j+1));
		itemModel.buy();
		sectorModelMatrix.get(i).get(j).setMeteor(itemModel);
		if(itemModel instanceof FireMeteorModel) {
			fireCheck(i+1, j+1);
		} else if(itemModel instanceof IceMeteorModel) {
			iceCheck(i+1, j+1);
		}
		
	}
	
	private void fireCheck(int x, int y) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				int newI = x + i;
				int newJ = y + j;			
				if(newI > 0 && newI < 5 && newJ > 0 && newJ < 5 && i != j && i != -j) {
					System.out.println(newI+" "+newJ);
					if(sectorModelMatrix.get(newI-1).get(newJ-1).getMeteor() instanceof IceMeteorModel) {
						sectorModelMatrix.get(newI-1).get(newJ-1).setMeteor(new MeteorModel(this.getModel(), this, 64*newI, 64*newJ, 64, 64, 0));
					}
					if(sectorModelMatrix.get(newI-1).get(newJ-1).getMeteor() instanceof GasMeteorModel) {
						sectorModelMatrix.get(newI-1).get(newJ-1).setMeteor(new FireMeteorModel(this.getModel(), this, 64*newI, 64*newJ, 64, 64, 0));
					}
				}
			}
		}
	}
	
	private void iceCheck(int x, int y) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				int newI = x + i;
				int newJ = y + j;			
				if(newI > 0 && newI < 5 && newJ > 0 && newJ < 5 && i != j && i != -j) {
					System.out.println(newI+" "+newJ);
					if(sectorModelMatrix.get(newI-1).get(newJ-1).getMeteor() instanceof GasMeteorModel) {
						sectorModelMatrix.get(newI-1).get(newJ-1).setMeteor(new IceMeteorModel(this.getModel(), this, 64*newI, 64*newJ, 64, 64, 0));
					}
				}
			}
		}
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
	
	public void destroyMeteors() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				sectorModelMatrix.get(i).get(j).destroyMeteor();
			}
		}
	}
	
	public void setConfig(List<List<String>> config) {
		this.config = config;
		getModel().getStoreModel().setConfig(config);
	}
}
