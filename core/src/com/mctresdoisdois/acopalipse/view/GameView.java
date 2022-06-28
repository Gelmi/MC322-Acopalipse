package com.mctresdoisdois.acopalipse.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.EndScreen;
import com.mctresdoisdois.acopalipse.controller.GameController;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.view.entities.EarthView;
import com.mctresdoisdois.acopalipse.view.entities.InfoView;
import com.mctresdoisdois.acopalipse.view.entities.StoreView;
import com.mctresdoisdois.acopalipse.view.entities.TableView;
import com.mctresdoisdois.acopalipse.view.entities.UpgradeView;

public class GameView extends ScreenAdapter {
	private final Acopalipse game;
	private final GameModel model;
	private final GameController controller;
	private final OrthographicCamera camera;
	private final TableView table;
	private final StoreView store;
	private final EarthView earth;
	private final InfoView info;
	private final UpgradeView upgrade;
	private Texture arrowImage;
	
	public GameView(final Acopalipse game, GameModel model, GameController controller) {
		this.game = game;
		this.model = model;
		this.controller = controller;
		this.controller.setGameView(this);
		
		this.table = new TableView(game, this);
		this.store = new StoreView(game, this);
		this.earth = new EarthView(game, this);
		this.info = new InfoView(game, this);
		this.upgrade = new UpgradeView(game, this);
		
		camera = createCamera();
		
		arrowImage = new Texture(Gdx.files.internal("backArrow.png"));
	}

	private OrthographicCamera createCamera() {
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		return camera;
	}
	
	@Override
	public void render(float delta) {
		//handleInputs();
		
		MyInputProcessor inputProcessor = new MyInputProcessor(controller);
		Gdx.input.setInputProcessor(inputProcessor);
		
		ScreenUtils.clear(0, 0, 0.2f, 1);
		
		camera.update();
		
		game.getBatch().setProjectionMatrix(camera.combined);
		game.getBatch().begin();
		
		table.draw(game.getBatch());
		store.draw(game.getBatch());
		earth.draw(game.getBatch());
		info.draw(game.getBatch());
		upgrade.draw(game.getBatch());
		
		//game.getFont().draw(game.getBatch(), "Setor selecionado: "+model.getTableModel().getSelectedSector(), 10, 30);
		game.getFont().draw(game.getBatch(), "Poeira: "+model.getDust()+" (+"+model.getTableModel().getDustPerSecond()+"/s )", 10, 30);
		game.getFont().draw(game.getBatch(), "Poder Total: "+model.getTotalPower(), 10, 60);
		game.getBatch().draw(arrowImage, 800-64, 0, 64, 64);
		
		game.getBatch().end();
		
		if(model.getEarthModel().getLife()<=0) {
			game.setScreen(new EndScreen(game));
		}
		
		if (TimeUtils.nanoTime() - model.getLastDustTime() > 1000000000) model.addDust();
		model.updateTotalPower();
		//game.getShapeRenderer().begin(ShapeType.FilledRectangle);
		
		//store.draw(game.getShapeRenderer());
		
		//game.getShapeRenderer().end();
	}
	
	/*
	private void handleInputs() {
		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);		
			controller.touch(touchPos);
		}
	}*/
	
	public void update() {
		table.update();
		store.update();
	}
	
	public GameModel getGameModel() {
		return model;
	}
	
	public Acopalipse getGame() {
		return game;
	}
	
	public TableView getTableView() {
		return table;
	}
	
	public StoreView getStoreView() {
		return store;
	}
	
}
