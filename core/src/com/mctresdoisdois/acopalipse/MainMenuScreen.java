package com.mctresdoisdois.acopalipse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mctresdoisdois.acopalipse.controller.GameController;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.view.GameView;

public class MainMenuScreen implements Screen {
	final Acopalipse game;
	private GlyphLayout layout;
	OrthographicCamera camera;
	final float fontX;
	final float fontY;
	private Texture dinossaurImage;
	private Rectangle dinossaur;
	
	public MainMenuScreen(final Acopalipse game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		layout = new GlyphLayout(this.game.font, "Acopalipse");
		fontX = 800/2 - (layout.width/2);
		fontY = 480/2 - (layout.height/2);	
		this.game.font.getData().setScale(2, 2);
		dinossaurImage = new Texture(Gdx.files.internal("Dinossauro.png"));
		
		dinossaur = new Rectangle();
		dinossaur.x = 800 / 2 - 64 / 2; // center the bucket horizontally
		dinossaur.y = 480/2 + (layout.height/2); // bottom left corner of the bucket is 20 pixels above
						// the bottom screen edge
		dinossaur.width = 64;
		dinossaur.height = 64;

	}
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		
		game.font.draw(game.batch, layout, fontX, fontY);
		game.batch.draw(dinossaurImage, dinossaur.x, dinossaur.y, dinossaur.width, dinossaur.height);
		
		game.batch.end();
			
		if (Gdx.input.isTouched()) {
			
			startGame(game);
			dispose();
		}
	}

	private void startGame(Acopalipse game) {
		GameModel model = new GameModel();
		
		game.setScreen(new GameView(game, model, new GameController(model)));
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
