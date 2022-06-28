package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.ItemModel;
import com.mctresdoisdois.acopalipse.model.entities.StoreModel;
import com.mctresdoisdois.acopalipse.model.entities.meteors.*;
import com.mctresdoisdois.acopalipse.view.GameView;
import com.mctresdoisdois.acopalipse.view.entities.meteors.*;

public class StoreView extends EntityView{
	
	private Array<ItemView> itemViewArray;
	
	public StoreView(Acopalipse game, GameView gameView) {
		super(game, gameView);
		itemViewArray = new Array<ItemView>();
		Array<ItemModel> itemModelArray = gameView.getGameModel().getStoreModel().getItemModelArray();
		for(int i = 0; i < itemModelArray.size; i++) {
			if(itemModelArray.get(i) instanceof MeteorModel) {
				itemViewArray.add(new MeteorView(game, this));
			} else if(itemModelArray.get(i) instanceof IceMeteorModel) {
				itemViewArray.add(new IceMeteorView(game, this));
			} else if(itemModelArray.get(i) instanceof GasMeteorModel) {
				itemViewArray.add(new GasMeteorView(game, this));
			} else if(itemModelArray.get(i) instanceof FireMeteorModel) {
				itemViewArray.add(new FireMeteorView(game, this));
			}
		}
	}

	@Override
	public Sprite createSprite(Acopalipse game) {
		Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGB888);
		pixmap.setColor(Color.rgba8888(1, 1, 1, 1f));
		pixmap.fillRectangle(0, 0, 64, 16);
		pixmap.fillRectangle(0, 32, 64, 16);
		pixmap.setColor(Color.rgba8888(0.8f, 0.8f, 0.8f, 1f));
		pixmap.fillRectangle(0, 16, 64, 16);
		pixmap.fillRectangle(0, 48, 64, 16);
		Texture texture = new Texture(pixmap);
		pixmap.dispose();
		return new Sprite(texture);
	}
	
	public void draw(SpriteBatch batch) {
		//getSprite().draw(batch);
		
		//System.out.println(sectorModel.getHeight());
		StoreModel storeModel = getGameView().getGameModel().getStoreModel();
		
		//shapes.rect(storeModel.getX(), storeModel.getY(), storeModel.getHeight(), storeModel.getWidth());
		batch.draw(getSprite(), storeModel.getX(), storeModel.getY(), storeModel.getHeight(), storeModel.getWidth());
		for(int i = 0; i < 4; i++) {
			itemViewArray.get(i).draw(batch, i);
		}
	}
	
	public void update() {
		Array<ItemModel> itemModelArray = getGameView().getGameModel().getStoreModel().getItemModelArray();
		for(int i = 0; i < itemModelArray.size; i++) {
			if(itemModelArray.get(i) instanceof MeteorModel) {
				itemViewArray.add(new MeteorView(getGameView().getGame(), this));
			} else if(itemModelArray.get(i) instanceof IceMeteorModel) {
				itemViewArray.add(new IceMeteorView(getGameView().getGame(), this));
			} else if(itemModelArray.get(i) instanceof GasMeteorModel) {
				itemViewArray.add(new GasMeteorView(getGameView().getGame(), this));
			} else if(itemModelArray.get(i) instanceof FireMeteorModel) {
				itemViewArray.add(new FireMeteorView(getGameView().getGame(), this));
			}
		}
	}
	
	public Array<ItemView> getItemViewArray(){
		return itemViewArray;
	}
}
