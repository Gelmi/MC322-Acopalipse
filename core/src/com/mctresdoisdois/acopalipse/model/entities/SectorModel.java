package com.mctresdoisdois.acopalipse.model.entities;

public class SectorModel extends EntityModel{

	private TableModel tableModel;
	private ItemModel meteor;
	
	SectorModel(TableModel tableModel, float x, float y, float height, float width, float rotation) {
		super(null, x, y, height, width, rotation);
		this.tableModel =  tableModel;
	}
	
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void setMeteor(ItemModel meteor) {
		System.out.println(meteor.getX()+" "+meteor.getY());
		//meteor.buy();
		//meteor.setPosition(this.getX(), this.getY());
		//meteor.setSize(64, 64);
		this.meteor = meteor;
	}
	
	public ItemModel getMeteor() {
		return meteor;
	}
}
