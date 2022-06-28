package com.mctresdoisdois.acopalipse.controller;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.MainMenuScreen;
import com.mctresdoisdois.acopalipse.controller.entities.EarthController;
import com.mctresdoisdois.acopalipse.controller.entities.StoreController;
import com.mctresdoisdois.acopalipse.controller.entities.TableController;
import com.mctresdoisdois.acopalipse.controller.entities.UpgradeController;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.view.GameView;

public class GameController {

	private final TableController tableController;
	private final StoreController storeController;
	private final EarthController earthController;
	private final UpgradeController upgradeController;
	protected final Acopalipse game;
	private GameModel gameModel;
	private GameView gameView;
	
	public GameController(Acopalipse game, GameModel gameModel) {
		tableController = new TableController(this);
		storeController = new StoreController(this);
		earthController = new EarthController(this);
		upgradeController = new UpgradeController(this);
		this.game = game;
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
		tableController.touch(touchPos);
		storeController.touch(touchPos);
		earthController.touch(touchPos);
		upgradeController.touch(touchPos);
		gameView.update();
		if(touchPos.x > 800-64 && touchPos.y < 64) {
			game.setScreen(new MainMenuScreen(game));
		} 
	}
	
	public TableController getTableContoller() {
		return tableController;
	}
}
