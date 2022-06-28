package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.InfoModel;
import com.mctresdoisdois.acopalipse.model.entities.ItemModel;
import com.mctresdoisdois.acopalipse.view.GameView;

public class InfoView extends EntityView{

	BitmapFont font;
	
	public InfoView(Acopalipse game, GameView gameView) {
		super(game, gameView);
		// TODO Auto-generated constructor stub
		font = new BitmapFont();
		font.setColor(Color.BLACK);
	}

	@Override
	public Sprite createSprite(Acopalipse game) {
		Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGB888);
		pixmap.setColor(Color.rgba8888(1, 1, 1, 1f));
		pixmap.fillRectangle(0, 0, 64, 64);
		Texture texture = new Texture(pixmap);
		pixmap.dispose();
		return new Sprite(texture);
	}
	
	public void draw(SpriteBatch batch) {
		InfoModel infoModel = getGameView().getGameModel().getInfoModel();
		ItemModel itemModel = null;
		if(getGameView().getGameModel().getTableModel().getSelectedSectorModel() != null) {
			itemModel = getGameView().getGameModel().getTableModel().getSelectedSectorModel().getMeteor();
		}
		batch.draw(getSprite(), infoModel.getX(), infoModel.getY(), infoModel.getHeight(), infoModel.getWidth());
		if(itemModel != null) {
			batch.draw(itemModel.createSprite(), infoModel.getX(), infoModel.getY(), 64, 64);
			font.draw(batch, itemModel.getName(), infoModel.getX()+74, infoModel.getY()+54);
			font.draw(batch, "Poder: "+itemModel.getPower(), infoModel.getX()+74, infoModel.getY()+40);
			font.draw(batch, "Atração: "+itemModel.getDustPerSecond(), infoModel.getX()+74, infoModel.getY()+26);
		} else {
			font.draw(batch, "Selecione um meteoro", infoModel.getX()+10, infoModel.getY()+30);
		}
	}
}
