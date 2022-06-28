package com.mctresdoisdois.acopalipse.model.entities;

import com.badlogic.gdx.math.Vector2;
import com.mctresdoisdois.acopalipse.model.GameModel;

public class UpgradeModel extends EntityModel{

	public UpgradeModel(GameModel model, float x, float y, float height, float width, float rotation) {
		super(model, x, y, height, width, rotation);
	}
	
	public void buyPowerUpgrade() {
		ItemModel meteorModel = getModel().getTableModel().getSelectedSectorModel().getMeteor();
		Vector2 powerUpgradeVector = meteorModel.getPowerUpgradeVector();
		if(getModel().getDust()>=powerUpgradeVector.y) {
			getModel().subDust((int)powerUpgradeVector.y);
			meteorModel.buyPowerUpgrade((int)powerUpgradeVector.x);
		}
	}
	
	public void buyDPSUpgrade() {
		ItemModel meteorModel = getModel().getTableModel().getSelectedSectorModel().getMeteor();
		Vector2 dpsUpgradeVector = meteorModel.getDPSUpgradeVector();
		if(getModel().getDust()>=dpsUpgradeVector.y) {
			getModel().subDust((int)dpsUpgradeVector.y);
			meteorModel.buyDPSUpgrade((int)dpsUpgradeVector.x);
		}
	}

}
