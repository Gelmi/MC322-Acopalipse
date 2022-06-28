package com.mctresdoisdois.acopalipse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mctresdoisdois.acopalipse.controller.MainMenuController;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.view.MyInputProcessor;

public class MainMenuScreen implements Screen {
	private final Acopalipse game;
	private OrthographicCamera camera;
	private Texture bookImage;
	private Texture dinossaurImage;
	private Rectangle dinossaur;
	private MyInputProcessor inputProcessor;
	
	public MainMenuScreen(final Acopalipse game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		bookImage = new Texture(Gdx.files.internal("Livro.png"));
		dinossaurImage = new Texture(Gdx.files.internal("Dinossauro.png"));
		this.game.getFont().getData().setScale(2, 2);
		
		dinossaur = new Rectangle();
		dinossaur.x = 800 / 2 - 64 / 2;
		dinossaur.y = 480/2 + 10;
		dinossaur.width = 64;
		dinossaur.height = 64;
		inputProcessor = new MyInputProcessor(new MainMenuController(game, new GameModel()));
	}
	
	@Override
	public void render(float delta) {
		Gdx.input.setInputProcessor(inputProcessor);
		
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		GlyphLayout layout = new GlyphLayout(this.game.getFont(), "Acopalipse");
		float fontX = 800/2 - (layout.width/2);
		float fontY = 480/2 - (layout.height/2);	
		
		game.getBatch().begin();
		
		game.getFont().draw(game.getBatch(), layout, fontX, fontY);
		game.getBatch().draw(dinossaurImage, dinossaur.x, dinossaur.y, dinossaur.width, dinossaur.height);
		game.getBatch().draw(bookImage, 0, 0, 64, 64);
		
		game.getBatch().end();
			
		
		/*if (Gdx.input.isTouched()) {
			System.out.println(Gdx.input.getX()+" "+Gdx.input.getY());
			if(Gdx.input.getX() < 64 && Gdx.input.getY() > 416) {
				startAchievements(game);
			} else {
				startGame(game);
			}
			dispose();
		}*/
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
