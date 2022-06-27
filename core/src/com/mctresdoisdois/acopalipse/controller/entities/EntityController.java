package com.mctresdoisdois.acopalipse.controller.entities;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.controller.GameController;

public abstract class EntityController {

	GameController gameController;
	
	EntityController(GameController gameController){
		this.gameController = gameController;
	}
	
	public GameController getGameController() {
		return gameController;
	}
	
	abstract void touch(Vector3 touchPos);
}
