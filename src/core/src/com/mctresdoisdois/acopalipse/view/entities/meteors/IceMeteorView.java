package com.mctresdoisdois.acopalipse.view.entities.meteors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.view.entities.EntityView;
import com.mctresdoisdois.acopalipse.view.entities.ItemView;

public class IceMeteorView extends ItemView{
	
	public IceMeteorView(Acopalipse game, EntityView entityView) {
		super(game, entityView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Sprite createSprite(Acopalipse game) {
		Texture idleTexture = new Texture(Gdx.files.internal("MeteoroGelo.png"));
		Sprite sprite = new Sprite(idleTexture);
		return sprite;
	}
}
