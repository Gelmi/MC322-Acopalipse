package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.EntityModel;
import com.mctresdoisdois.acopalipse.view.GameView;

public abstract class EntityView {

	private Sprite sprite;
	private GameView gameView;
	
	public EntityView(Acopalipse game, GameView gameView) {
        sprite = createSprite(game);
        this.gameView = gameView;
    }
	
	public GameView getGameView() {
		return gameView;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
	
	public abstract Sprite createSprite(Acopalipse game);
	
	public void update(EntityModel model) {
        sprite.setCenter(model.getX(), model.getY());
        sprite.setRotation((float) Math.toDegrees(model.getRotation()));
    }
}
