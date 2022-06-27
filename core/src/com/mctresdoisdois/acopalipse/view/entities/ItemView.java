package com.mctresdoisdois.acopalipse.view.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mctresdoisdois.acopalipse.Acopalipse;
import com.mctresdoisdois.acopalipse.model.entities.ItemModel;

public abstract class ItemView extends EntityView{

	private EntityView entityView;
	private String itemName;
	private int itemPrice;
	private int itemPower;
	
	public ItemView(Acopalipse game, EntityView entityView, String itemName, int itemPrice, int itemPower) {
		super(game, null);
		this.entityView = entityView;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemPower = itemPower;
	}

	//@Override
	//public Sprite createSprite(Acopalipse game) {
		//Texture idleTexture = new Texture(Gdx.files.internal("Meteoro.png"));
		//Sprite sprite = new Sprite(idleTexture);
		//return sprite;
	//}

	public EntityView getEntityView() {
		return entityView;
	}
	
	public void draw(SpriteBatch batch, int i) {
		ItemModel itemModel = entityView.getGameView().getGameModel().getStoreModel().getItemModelArray().get(i);
		batch.draw(getSprite(), itemModel.getX(), itemModel.getY(), itemModel.getHeight(), itemModel.getHeight());
		BitmapFont font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.draw(batch, itemName, itemModel.getX() + itemModel.getHeight()*1.1f, itemModel.getY()+ itemModel.getHeight()*0.9f);
		font.draw(batch, "Custo: "+String.valueOf(itemPrice), itemModel.getX() + itemModel.getHeight()*1.1f, itemModel.getY()+ itemModel.getHeight()*0.7f);
		font.draw(batch, "Poder: "+String.valueOf(itemPower), itemModel.getX() + itemModel.getHeight()*1.1f, itemModel.getY()+ itemModel.getHeight()*0.5f);
	}
	
	public void draw(SpriteBatch batch, int i, int j) {
		ItemModel itemModel = entityView.getGameView().getGameModel().getTableModel().getSectorModelMatrix().get(i).get(j).getMeteor();
		batch.draw(getSprite(), itemModel.getX(), itemModel.getY(), itemModel.getHeight(), itemModel.getHeight());
	}
}
