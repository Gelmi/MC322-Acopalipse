package com.mctresdoisdois.acopalipse.controller;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.AchievementsView;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.MainMenuScreen;
import com.mctresdoisdois.acopalipse.model.AchievementsModel;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.view.GameView;

public class MainMenuController extends GameController{

	public MainMenuController(Acopalipse game, GameModel gameModel) {
		super(game, gameModel);
	}
	
	public void touch(Vector3 touchPos) {
		if(touchPos.x < 64 && touchPos.y < 64) {
			startAchievements(game);
		} else {
			startGame(game);
		}
	}
	
	private void startGame(Acopalipse game) {
		GameModel model = new GameModel();
		game.setScreen(new GameView(game, model, new GameController(game, model)));
	}
	
	private void startAchievements(Acopalipse game) {
		GameModel gameModel = new GameModel();
		AchievementsModel achievementsModel = new AchievementsModel();
		game.setScreen(new AchievementsView(game, achievementsModel, new AchievementsController(game, gameModel, achievementsModel)));
	}
	
}
