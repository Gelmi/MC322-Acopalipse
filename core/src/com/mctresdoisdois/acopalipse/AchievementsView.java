package com.mctresdoisdois.acopalipse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mctresdoisdois.acopalipse.controller.AchievementsController;
import com.mctresdoisdois.acopalipse.model.AchievementsModel;
import com.mctresdoisdois.acopalipse.view.MyInputProcessor;

public class AchievementsView implements Screen {
	
	private Acopalipse game;
	private AchievementsModel model;
	private AchievementsController controller;
	private OrthographicCamera camera;
	private Texture arrowImage;
	
	public AchievementsView(Acopalipse game, AchievementsModel model, AchievementsController controller){
		this.game = game;
		this.model = model;
		this.controller = controller;
	
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		arrowImage = new Texture(Gdx.files.internal("backArrow.png"));
	}

	@Override
	public void render(float delta) {
		MyInputProcessor inputProcessor = new MyInputProcessor(controller);
		Gdx.input.setInputProcessor(inputProcessor);
		
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);
		
		game.getBatch().begin();
		
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
