package com.mctresdoisdois.acopalipse.controller.entities;

import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.model.entities.TableModel;

public class TableController extends EntityController{

	private TableModel tableModel;
	
	public TableController(TableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	public void touch(Vector3 touchPos) {
		tableModel.touch(touchPos);
	}
}
