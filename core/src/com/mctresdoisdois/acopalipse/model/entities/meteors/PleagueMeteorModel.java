package com.mctresdoisdois.acopalipse.model.entities.meteors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.model.entities.EntityModel;
import com.mctresdoisdois.acopalipse.model.entities.ItemModel;

public class PleagueMeteorModel extends ItemModel {

	public PleagueMeteorModel(GameModel model, EntityModel entityModel, float x, float y, float height, float width, float rotation) {
		super(model, entityModel, x, y, height, width, rotation, 1, 100, 10, "Meteoro Praga");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Sprite createSprite() {
		Texture idleTexture = new Texture(Gdx.files.internal("MeteoroPraga.png"));
		Sprite sprite = new Sprite(idleTexture);
		return sprite;
	}
}
