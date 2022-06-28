package com.mctresdoisdois.acopalipse.controller.entities;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.controller.GameController;
import com.mctresdoisdois.acopalipse.model.entities.StoreModel;

public class StoreController extends EntityController {

	public StoreController(GameController gameController) {
		super(gameController);
	}

	@Override
	public void touch(Vector3 touchPos) {
		StoreModel storeModel = getGameController().getGameModel().getStoreModel();
		//System.out.println(storeModel.getX()+" "+storeModel.getY()+" "+storeModel.getX() + storeModel.getWidth()+" "+storeModel.getY() + storeModel.getHeight());
		if(touchPos.x >= storeModel.getX() && touchPos.y >= storeModel.getY() && touchPos.x <= storeModel.getX() + storeModel.getHeight() && touchPos.y <= storeModel.getY() + storeModel.getWidth()) {
			if(getGameController().getGameModel().getTableModel().getSelectedSector() != null) {
				int i = (int) Math.floor(touchPos.y/(storeModel.getWidth()/4))-1;
				int price = getGameController().getGameModel().getStoreModel().getItemModelArray().get(i).getPrice();
				if(getGameController().getGameModel().getDust() >= price) {
					if(getGameController().getGameModel().getTableModel().getSelectedSectorModel().getMeteor() == null) {
						getGameController().getGameModel().subDust(price);
						getGameController().getTableContoller().buy(getGameController().getGameModel().getStoreModel().getItemModelArray().get(i));
						getGameController().getGameModel().getStoreModel().createItem(i, getGameController().getGameModel().getStoreModel().getItemModelArray().get(i));
					}
				}
			}
		}
	}

	//lidando com cliques da mesma forma que o tablecontroller
	
}
