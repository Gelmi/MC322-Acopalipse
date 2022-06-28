package com.mctresdoisdois.acopalipse.controller;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.MainMenuScreen;
import com.mctresdoisdois.acopalipse.model.AchievementsModel;
import com.mctresdoisdois.acopalipse.model.GameModel;

public class AchievementsController extends GameController {

	public AchievementsController(Acopalipse game, GameModel gameModel, AchievementsModel AchievementsModel) {
		super(game, gameModel);
		// TODO Auto-generated constructor stub
	}
	
	public void touch(Vector3 touchPos) {
		if(touchPos.x > 800-64 && touchPos.y < 64) {
			game.setScreen(new MainMenuScreen(game));
		} 
	}
}
