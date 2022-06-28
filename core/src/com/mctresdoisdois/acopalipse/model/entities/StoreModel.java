package com.mctresdoisdois.acopalipse.model.entities;

import com.badlogic.gdx.utils.Array;
import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.model.entities.meteors.*;

public class StoreModel extends EntityModel {

	private Array<ItemModel> itemModelArray;
	
	public StoreModel(GameModel model, float x, float y, float height, float width, float rotation) {
		super(model, x, y, height, width, rotation);
		itemModelArray = new Array<ItemModel>();
		itemModelArray.add(new MeteorModel(model, this, x, y+(64*0),64, 192,0));
		itemModelArray.add(new IceMeteorModel(model, this, x, y+(64*1),64, 192,0));
		itemModelArray.add(new GasMeteorModel(model, this, x, y+(64*2),64, 192,0));
		itemModelArray.add(new FireMeteorModel(model, this, x, y+(64*3),64, 192,0));
	}
	
	public void createItem(int i, ItemModel itemModel) {
		if(itemModel instanceof MeteorModel) {
			itemModelArray.set(i, new MeteorModel(this.getModel(), this, this.getX(), this.getY()+(64*i),64, 192,0));
		} else if(itemModel instanceof IceMeteorModel) {
			itemModelArray.set(i, new IceMeteorModel(this.getModel(), this, this.getX(), this.getY()+(64*i),64, 192,0));
		} else if(itemModel instanceof GasMeteorModel) {
			itemModelArray.set(i, new GasMeteorModel(this.getModel(), this, this.getX(), this.getY()+(64*i),64, 192,0));
		} else if(itemModel instanceof FireMeteorModel) {
			itemModelArray.set(i, new FireMeteorModel(this.getModel(), this, this.getX(), this.getY()+(64*i),64, 192,0));
		}
	}
	
	public Array<ItemModel> getItemModelArray() {
		return itemModelArray;
	}
	//Contem as informações de tamanho e posição
	//Contem um vetor de Itens que serão renderizados assim como no tabuleiro
	//Scrollable vs numero fíxo de meteoros aleatórios pra comprar
	
}
