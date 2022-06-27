package com.mctresdoisdois.acopalipse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Acopalipse extends Game {
	private SpriteBatch batch;
	private BitmapFont font;
	private Stage stage;
	private AssetManager assetManager;
	private ShapeRenderer shapes;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(); // use libGDX's default Arial font
		stage = new Stage();
		shapes = new ShapeRenderer();
		assetManager = new AssetManager();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();		
		stage.dispose();
		shapes.dispose();
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
	
	public BitmapFont getFont() {
		return font;
	}
	
	public AssetManager getAssetManager() {
		return assetManager;
	}
	
	public ShapeRenderer getShapeRenderer() {
		return shapes;
	}
}
