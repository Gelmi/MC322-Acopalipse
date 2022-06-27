package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.TableModel;
import com.mctresdoisdois.acopalipse.view.GameView;

public class TableView extends EntityView{
					
	private Array<Array<SectorView>> sectorViewMatrix;
	
	public TableView(Acopalipse game, GameView gameView) {
		super(game, gameView);	

		sectorViewMatrix = new Array<Array<SectorView>>();
		
		for(int i = 0; i < 4; i++) {
			sectorViewMatrix.add(new Array<SectorView>());
			for(int j = 0; j < 4; j++) {
				sectorViewMatrix.get(i).add(new SectorView(game, this)); 
			}
		}
	}

	@Override
	public Sprite createSprite(Acopalipse game) {
		Texture idleTexture = new Texture(Gdx.files.internal("Tabuleiro.png"));
		return new Sprite(idleTexture);
	}
	 
	public void draw(SpriteBatch batch) {
        //sprite.draw(batch);
		TableModel tableModel = getGameView().getGameModel().getTableModel();
		batch.draw(getSprite(), tableModel.getX(), tableModel.getY(), tableModel.getHeight(), tableModel.getWidth());
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				sectorViewMatrix.get(i).get(j).draw(batch, i , j);
			}
		}
    }
}
