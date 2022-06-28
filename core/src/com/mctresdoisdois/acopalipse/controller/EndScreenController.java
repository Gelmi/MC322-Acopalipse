package com.mctresdoisdois.acopalipse.controller;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.MainMenuScreen;
import com.mctresdoisdois.acopalipse.model.AchievementsModel;
import com.mctresdoisdois.acopalipse.model.GameModel;

public class EndScreenController extends GameController{
	
	public EndScreenController(Acopalipse game, GameModel gameModel) {
		super(game, gameModel);
	}
	
	public void touch(Vector3 touchPos) {
		if(touchPos.x > 800-64 && touchPos.y < 64) {
			game.setScreen(new MainMenuScreen(game));
		} 
	}
	
}
