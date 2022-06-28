package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.InfoModel;
import com.mctresdoisdois.acopalipse.model.entities.ItemModel;
import com.mctresdoisdois.acopalipse.model.entities.UpgradeModel;
import com.mctresdoisdois.acopalipse.view.GameView;

public class UpgradeView extends EntityView {

	BitmapFont font;
	Sprite blackSprite;
	
	public UpgradeView(Acopalipse game, GameView gameView) {
		super(game, gameView);
		// TODO Auto-generated constructor stub
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		blackSprite = createBlackSprite();
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
	
	public Sprite createBlackSprite() {
		Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGB888);
		pixmap.setColor(Color.rgba8888(0.8f, 0.8f, 0.8f, 1f));
		pixmap.fillRectangle(0, 0, 64, 64);
		Texture texture = new Texture(pixmap);
		pixmap.dispose();
		return new Sprite(texture);
	}
	
	public void draw(SpriteBatch batch) {
		UpgradeModel upgradeModel = getGameView().getGameModel().getUpgradeModel();
		ItemModel itemModel = null;
		if(getGameView().getGameModel().getTableModel().getSelectedSectorModel() != null) {
			itemModel = getGameView().getGameModel().getTableModel().getSelectedSectorModel().getMeteor();
		}
		batch.draw(getSprite(), upgradeModel.getX(), upgradeModel.getY(), upgradeModel.getHeight(), upgradeModel.getWidth());
		if(itemModel != null) {
			Vector2 powerUpgrade = itemModel.getPowerUpgradeVector();
			Vector2 dpsUpgrade = itemModel.getDPSUpgradeVector();
			batch.draw(getSprite(), upgradeModel.getX(), upgradeModel.getY(), 128, 64);
			font.draw(batch, "Upgrade de Poder", upgradeModel.getX()+7, upgradeModel.getY()+60);
			font.draw(batch, "Bonus: +"+String.valueOf(powerUpgrade.x), upgradeModel.getX()+7, upgradeModel.getY()+40);
			font.draw(batch, "Custo: "+String.valueOf(powerUpgrade.y), upgradeModel.getX()+7, upgradeModel.getY()+20);
			batch.draw(blackSprite, upgradeModel.getX()+128, upgradeModel.getY(), 128, 64);
			font.draw(batch, "Upgrade de DPS", upgradeModel.getX()+135, upgradeModel.getY()+60);
			font.draw(batch, "Bonus: x"+String.valueOf(dpsUpgrade.x), upgradeModel.getX()+135, upgradeModel.getY()+40);
			font.draw(batch, "Custo: "+String.valueOf(dpsUpgrade.y), upgradeModel.getX()+135, upgradeModel.getY()+20);
		} else {
			font.draw(batch, "Selecione um meteoro", upgradeModel.getX()+10, upgradeModel.getY()+30);
		}
	}
}
