package com.mctresdoisdois.acopalipse.controller;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.controller.entities.TableController;
import com.mctresdoisdois.acopalipse.model.GameModel;

public class GameController {

	private final TableController tableController;
	private GameModel gameModel;
	
	public GameController(GameModel gameModel) {
		tableController = new TableController(this);
		this.gameModel = gameModel;
	}
	
	public GameModel getGameModel() {
		return gameModel;
	}
	
	public void touch(Vector3 touchPos) {
		tableController.touch(touchPos);
	}
}
