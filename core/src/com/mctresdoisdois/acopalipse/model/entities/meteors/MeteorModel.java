package com.mctresdoisdois.acopalipse.model.entities.meteors;

import com.mctresdoisdois.acopalipse.model.GameModel;
import com.mctresdoisdois.acopalipse.model.entities.EntityModel;
import com.mctresdoisdois.acopalipse.model.entities.ItemModel;

public class MeteorModel extends ItemModel {

	public MeteorModel(GameModel model, EntityModel entityModel, float x, float y, float height, float width,
			float rotation) {
		super(model, entityModel, x, y, height, width, rotation, 1, 50, 5);
		// TODO Auto-generated constructor stub
	}

}
