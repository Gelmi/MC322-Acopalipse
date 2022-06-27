package com.mctresdoisdois.acopalipse.controller.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.controller.GameController;
import com.mctresdoisdois.acopalipse.model.entities.ItemModel;
import com.mctresdoisdois.acopalipse.model.entities.TableModel;

public class TableController extends EntityController {
	
	public TableController(GameController gameController) {
		super(gameController);
	}
	
	public void touch(Vector3 touchPos) {
		TableModel tableModel = getGameController().getGameModel().getTableModel();
		if(touchPos.x >= tableModel.getX() && touchPos.y >= tableModel.getY() && touchPos.x <= tableModel.getX() + tableModel.getWidth() && touchPos.y <= tableModel.getY() + tableModel.getHeight()) {
			System.out.println(Math.floor(touchPos.x/(tableModel.getHeight()/4))+" "+Math.floor(touchPos.y/(tableModel.getWidth()/4)));
			int i = (int) Math.floor(touchPos.x/(tableModel.getHeight()/4));
			int j = (int) Math.floor(touchPos.y/(tableModel.getWidth()/4));
			getGameController().getGameModel().getTableModel().setSelectedSector(new Vector2(i,j));
		} else {
			//getGameController().getGameModel().getTableModel().setSelectedSector(null);
		}
	}
	
	public void buy(ItemModel itemModel) {
		System.out.println(itemModel.getX()+" "+itemModel.getY());
		getGameController().getGameModel().getTableModel().buy(itemModel);
	}
}
