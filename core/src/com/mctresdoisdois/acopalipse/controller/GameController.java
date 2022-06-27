package com.mctresdoisdois.acopalipse.controller;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.controller.entities.TableController;
import com.mctresdoisdois.acopalipse.model.GameModel;

public class GameController {

	private final TableController tableController;
	
	public GameController(GameModel model) {
		tableController = new TableController(model.getTableModel());
	}
	
	public void touch(Vector3 touchPos) {
		tableController.touch(touchPos);
	}
}
