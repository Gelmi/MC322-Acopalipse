package com.mctresdoisdois.acopalipse.model.entities.meteors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.model.entities.EntityModel;
import com.mctresdoisdois.acopalipse.model.entities.ItemModel;

public class FireMeteorModel extends ItemModel{

	Sprite sprite;
	
	public FireMeteorModel(GameModel model, EntityModel entityModel, float x, float y, float height, float width,
			float rotation) {
		super(model, entityModel, x, y, height, width, rotation, 50, 500, 50, "Meteoro Fogo");
		// TODO Auto-generated constructor stub
		sprite = createSprite();
	}
	
	@Override
	public Sprite createSprite() {
		Texture idleTexture = new Texture(Gdx.files.internal("MeteoroFogo.png"));
		Sprite sprite = new Sprite(idleTexture);
		return sprite;
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	public Vector2 getPowerUpgradeVector() {
		return new Vector2(5, price * (float)Math.pow(10,((power/50)-1)));
	}
	
	public Vector2 getDPSUpgradeVector() {
		return new Vector2(2, price * (float)Math.pow(10,((dustPerSecond/50))));
	}
	
}
