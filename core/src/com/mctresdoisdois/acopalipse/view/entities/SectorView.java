package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.SectorModel;

public class SectorView extends EntityView {
	
	private TableView tableView;
	
	public SectorView(Acopalipse game, TableView tableView) {
		super(game, null);
		this.tableView = tableView;
	}
	
	@Override
	public Sprite createSprite(Acopalipse game) {
		Texture idleTexture = new Texture(Gdx.files.internal("Dinossauro.png"));
		Sprite sprite = new Sprite(idleTexture);
		sprite.setAlpha(0.1f);
		return sprite;
	}
	
	public void draw(SpriteBatch batch, int i, int j) {
		//getSprite().draw(batch);
		
		SectorModel sectorModel = tableView.getGameView().getGameModel().getTableModel().getSectorModelMatrix().get(i).get(j);
		//System.out.println(sectorModel.getHeight());
		batch.draw(getSprite(), sectorModel.getX(), sectorModel.getY(), sectorModel.getHeight(), sectorModel.getWidth());
	}
}
