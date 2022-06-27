package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.SectorModel;
import com.mctresdoisdois.acopalipse.model.entities.TableModel;
import com.mctresdoisdois.acopalipse.model.entities.meteors.*;
import com.mctresdoisdois.acopalipse.view.GameView;
import com.mctresdoisdois.acopalipse.view.entities.meteors.*;

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
	
	public void buy(ItemView itemView) {
		Vector2 selectedSector = getGameView().getGameModel().getTableModel().getSelectedSector();
		sectorViewMatrix.get(((int)selectedSector.x) - 1).get(((int)selectedSector.y) - 1).setMeteorView(itemView);
	}
	
	public void update() {
		TableModel tableModel = getGameView().getGameModel().getTableModel();
		Array<Array<SectorModel>> sectorModelMatrix = tableModel.getSectorModelMatrix();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				SectorModel sectorModel = sectorModelMatrix.get(i).get(j);
				if(sectorModel.getMeteor() != null) {
					//setor tem meteoro
					if(sectorModel.getMeteor() instanceof MeteorModel) {
						sectorViewMatrix.get(i).get(j).setMeteorView(new MeteorView(this.getGameView().getGame(), this));
					} else if(sectorModel.getMeteor() instanceof GasMeteorModel) {
						sectorViewMatrix.get(i).get(j).setMeteorView(new GasMeteorView(this.getGameView().getGame(), this));
					} else if(sectorModel.getMeteor() instanceof IceMeteorModel) {
						sectorViewMatrix.get(i).get(j).setMeteorView(new IceMeteorView(this.getGameView().getGame(), this));
					}  else if(sectorModel.getMeteor() instanceof PleagueMeteorModel) {
						sectorViewMatrix.get(i).get(j).setMeteorView(new PleagueMeteorView(this.getGameView().getGame(), this));
					}
				}
			}
		}
	}
}
