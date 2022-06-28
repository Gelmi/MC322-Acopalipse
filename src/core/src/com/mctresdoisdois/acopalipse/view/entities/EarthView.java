package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.EarthModel;
import com.mctresdoisdois.acopalipse.view.GameView;

public class EarthView extends EntityView {

	private Sprite earthSprite;
	private Sprite lifeRedSprite;
	private Sprite lifeGreenSprite;
	private BitmapFont font; 
	
	public EarthView(Acopalipse game, GameView gameView) {
		super(game, gameView);
		// TODO Auto-generated constructor stub
		Texture earthTexture = new Texture(Gdx.files.internal("TerraeDinos.png"));
		earthSprite = new Sprite(earthTexture);
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.getData().setScale(1.2f,1.2f);
		lifeRedSprite = createLifeSprite(Color.RED);
		lifeGreenSprite = createLifeSprite(Color.GREEN);
	}

	@Override
	public Sprite createSprite(Acopalipse game) {
		Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGB888);
		pixmap.setColor(Color.rgba8888(1, 1, 1, 1f));
		pixmap.fillRectangle(0, 0, 64, 64);
		Texture texture = new Texture(pixmap);
		pixmap.dispose();
		return new Sprite(texture);
	}
	
	public Sprite createLifeSprite(Color color) {
		Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGB888);
		pixmap.setColor(color);
		pixmap.fillRectangle(0, 0, 64, 64);
		Texture texture = new Texture(pixmap);
		pixmap.dispose();
		return new Sprite(texture);
	}
	
	public void draw(SpriteBatch batch) {
		EarthModel earthModel = getGameView().getGameModel().getEarthModel();
		batch.draw(getSprite(), earthModel.getX(), earthModel.getY(), earthModel.getHeight(), earthModel.getWidth()-128);
		batch.draw(lifeRedSprite, earthModel.getX(), earthModel.getY(), earthModel.getHeight(), (earthModel.getWidth()-128)/3);
		batch.draw(lifeGreenSprite, earthModel.getX(), earthModel.getY(), earthModel.getHeight()*(earthModel.getLife()/(float)earthModel.getTotalLife()), (earthModel.getWidth()-128)/3);
		font.draw(batch, "ATAQUE!", earthModel.getX()+21, earthModel.getY()+60);
		font.draw(batch, "HP: "+String.valueOf(earthModel.getLife()), earthModel.getX()+21, earthModel.getY()+40);
		batch.draw(earthSprite, earthModel.getX(), earthModel.getY()+64, earthModel.getHeight(), earthModel.getWidth()-64);
	}
	
	public void dispose() {
		font.dispose();		
	}
}
