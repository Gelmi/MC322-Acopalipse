package com.mctresdoisdois.acopalipse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mctresdoisdois.acopalipse.controller.EndScreenController;
import com.mctresdoisdois.acopalipse.controller.MainMenuController;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.view.MyInputProcessor;

public class EndScreen implements Screen {
	private final Acopalipse game;
	private OrthographicCamera camera;
	private Texture arrowImage;

	public EndScreen(final Acopalipse game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		arrowImage = new Texture(Gdx.files.internal("backArrow.png"));
		
	}
	
	@Override
	public void render(float delta) {
		MyInputProcessor inputProcessor = new MyInputProcessor(new EndScreenController(game, new GameModel()));
		Gdx.input.setInputProcessor(inputProcessor);
		
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		GlyphLayout layout = new GlyphLayout(this.game.getFont(), "Voce ganhou!");
		float fontX = 800/2 - (layout.width/2);
		float fontY = 480/2 - (layout.height/2);	
		this.game.getFont().getData().setScale(2, 2);
		
		Texture dinossaurImage = new Texture(Gdx.files.internal("Meteoro.png"));
		Rectangle dinossaur = new Rectangle();
		dinossaur.x = 800 / 2 - 64 / 2;
		dinossaur.y = 480/2 + (layout.height/2);
		dinossaur.width = 64;
		dinossaur.height = 64;
		
		game.getBatch().begin();
		
		game.getFont().draw(game.getBatch(), layout, fontX, fontY);
		game.getBatch().draw(dinossaurImage, dinossaur.x, dinossaur.y, dinossaur.width, dinossaur.height);
		game.getBatch().draw(arrowImage, 800-64, 0, 64, 64);
		
		game.getBatch().end();
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
