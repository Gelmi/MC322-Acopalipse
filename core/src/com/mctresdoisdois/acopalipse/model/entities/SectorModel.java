package com.mctresdoisdois.acopalipse.model.entities;

public class SectorModel extends EntityModel{

	private TableModel tableModel;
	
	SectorModel(TableModel tableModel, float x, float y, float height, float width, float rotation) {
		super(null, x, y, height, width, rotation);
		this.tableModel =  tableModel;
	}
	
	public void a() {
		System.out.println("A");
	}

}
