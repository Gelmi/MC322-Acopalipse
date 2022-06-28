package com.mctresdoisdois.acopalipse.controller.entities;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.controller.GameController;
import com.mctresdoisdois.acopalipse.model.entities.ItemModel;
import com.mctresdoisdois.acopalipse.model.entities.StoreModel;
import com.mctresdoisdois.acopalipse.model.entities.UpgradeModel;

public class UpgradeController extends EntityController {

	public UpgradeController(GameController gameController) {
		super(gameController);
		// TODO Auto-generated constructor stub
	}

	@Override
	public
	void touch(Vector3 touchPos) {
		UpgradeModel upgradeModel = getGameController().getGameModel().getUpgradeModel();
		if(touchPos.x >= upgradeModel.getX() && touchPos.y >= upgradeModel.getY() && touchPos.x <= upgradeModel.getX() + upgradeModel.getHeight() && touchPos.y <= upgradeModel.getY() + upgradeModel.getWidth()) {
			int click = (int)Math.floor((touchPos.x-upgradeModel.getX())/(upgradeModel.getHeight()/2));
			ItemModel itemModel = null;
			if(getGameController().getGameModel().getTableModel().getSelectedSectorModel()!=null) itemModel = getGameController().getGameModel().getTableModel().getSelectedSectorModel().getMeteor();
			if(itemModel != null) {
				if(click == 0) {
					upgradeModel.buyPowerUpgrade();
				} else {
					upgradeModel.buyDPSUpgrade();
				}
			}
		}
	}

}
