package com.mctresdoisdois.acopalipse.model;

import com.mctresdoisdois.acopalipse.model.entities.TableModel;

public class GameModel {

	private final TableModel tableModel;
	
	public GameModel() {
		tableModel = new TableModel(this, 64, 64, 256, 256, 0);
	}
	
	public TableModel getTableModel() {
		return tableModel;
	}
}
