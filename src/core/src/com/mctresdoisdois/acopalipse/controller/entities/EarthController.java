package com.mctresdoisdois.acopalipse.controller.entities;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.controller.GameController;
import com.mctresdoisdois.acopalipse.model.entities.EarthModel;

public class EarthController extends EntityController{

	public EarthController(GameController gameController) {
		super(gameController);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void touch(Vector3 touchPos) {
		EarthModel earthModel = getGameController().getGameModel().getEarthModel();
		if(touchPos.x >= earthModel.getX() && touchPos.y >= earthModel.getY() && touchPos.x <= earthModel.getX() + earthModel.getHeight() && touchPos.y <= earthModel.getY() + earthModel.getWidth()/3) {
			//System.out.println("A");
			earthModel.attack();
		}
	}
}
