package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.SectorModel;
import com.mctresdoisdois.acopalipse.model.entities.TableModel;

public class SectorView extends EntityView {
	
	private TableView tableView;
	private Sprite selectedSprite;
	private ItemView meteorView;
	
	public SectorView(Acopalipse game, TableView tableView) {
		super(game, null);
		this.tableView = tableView;
		Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGBA8888);
		pixmap.setColor(Color.RED);
		pixmap.fillRectangle(0, 0, 4, 64);
		pixmap.fillRectangle(0, 0, 64, 4);
		pixmap.setColor(Color.ORANGE);
		pixmap.fillRectangle(60, 0, 4, 64);
		pixmap.fillRectangle(0, 60, 64, 4);
		pixmap.setColor(Color.CLEAR);
		pixmap.fillRectangle(4, 4, 56, 56);
		Texture texture = new Texture(pixmap);
		pixmap.dispose();
		selectedSprite = new Sprite(texture);
	}
	
	@Override
	public Sprite createSprite(Acopalipse game) {
		Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGBA8888);
		pixmap.setColor(Color.CLEAR);
		pixmap.fillRectangle(0, 0, 64, 64);
		Texture texture = new Texture(pixmap);
		pixmap.dispose();
		return new Sprite(texture);
	}
	
	public Sprite createMeteorSprite(FileHandle file) {
		Texture idleTexture = new Texture(file);
		return new Sprite(idleTexture);
	}
	
	public void draw(SpriteBatch batch, int i, int j) {
		TableModel tableModel = tableView.getGameView().getGameModel().getTableModel();
		SectorModel sectorModel = tableView.getGameView().getGameModel().getTableModel().getSectorModelMatrix().get(i).get(j);

		if(tableModel.getSelectedSector() != null) {
			if(i+1 == (int)tableModel.getSelectedSector().x && j+1 == (int)tableModel.getSelectedSector().y) {
				batch.draw(getSprite(), sectorModel.getX(), sectorModel.getY(), sectorModel.getHeight(), sectorModel.getWidth());
				if(meteorView!=null) meteorView.draw(batch, i, j);
				batch.draw(selectedSprite, sectorModel.getX(), sectorModel.getY(), sectorModel.getHeight(), sectorModel.getWidth());
			} else {
				if(meteorView!=null) meteorView.draw(batch, i, j);
				batch.draw(getSprite(), sectorModel.getX(), sectorModel.getY(), sectorModel.getHeight(), sectorModel.getWidth());
			}
		} else {
			if(meteorView!=null) meteorView.draw(batch, i, j);
			batch.draw(getSprite(), sectorModel.getX(), sectorModel.getY(), sectorModel.getHeight(), sectorModel.getWidth());
		}
	}
	
	public void setMeteorView(ItemView meteorView) {
		this.meteorView = meteorView;
	}
}
