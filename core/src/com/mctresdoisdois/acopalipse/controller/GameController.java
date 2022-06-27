package com.mctresdoisdois.acopalipse.controller;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.controller.entities.StoreController;
import com.mctresdoisdois.acopalipse.controller.entities.TableController;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.view.GameView;

public class GameController {

	private final TableController tableController;
	private final StoreController storeController;
	private GameModel gameModel;
	private GameView gameView;
	
	public GameController(GameModel gameModel) {
		tableController = new TableController(this);
		storeController = new StoreController(this);
		this.gameModel = gameModel;
	}
	
	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}
	
	public GameView getGameView() {
		return gameView;
	}
	
	public GameModel getGameModel() {
		return gameModel;
	}
	
	public void touch(Vector3 touchPos) {
		System.out.println(touchPos);
		gameView.update();
		tableController.touch(touchPos);
		storeController.touch(touchPos);
	}
	
	public TableController getTableContoller() {
		return tableController;
	}
}
