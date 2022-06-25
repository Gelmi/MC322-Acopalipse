package com.mctresdoisdois.acopalipse.view;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.controller.GameController;
import com.mctresdoisdois.acopalipse.model.GameModel;

public class GameView extends ScreenAdapter {
	private final Acopalipse game;
	private final GameModel model;
	private final GameController controller;
	private final OrthographicCamera camera;
	
	public GameView(final Acopalipse game, GameModel model, GameController controller) {
		this.game = game;
		this.model = model;
		this.controller = controller;
		
		camera = createCamera();
	}

	private OrthographicCamera createCamera() {
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		return camera;
	}
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		
		camera.update();

		game.batch.setProjectionMatrix(camera.combined);
	}
}
