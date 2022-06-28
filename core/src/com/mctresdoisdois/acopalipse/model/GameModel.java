package com.mctresdoisdois.acopalipse.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.TimeUtils;
import com.mctresdoisdois.acopalipse.model.entities.EarthModel;
import com.mctresdoisdois.acopalipse.model.entities.InfoModel;
import com.mctresdoisdois.acopalipse.model.entities.SectorModel;
import com.mctresdoisdois.acopalipse.model.entities.StoreModel;
import com.mctresdoisdois.acopalipse.model.entities.TableModel;
import com.mctresdoisdois.acopalipse.model.entities.UpgradeModel;

public class GameModel{

	private final TableModel tableModel;
	private final StoreModel storeModel;
	private final EarthModel earthModel;
	private final AchievementsModel achievementsModel;
	private final InfoModel infoModel;
	private final UpgradeModel upgradeModel;
	private int dust;
	private long lastDustTime;
	private int totalPower;
	//private static final Logger LOG = Logger.getLogger(FileNotFoundExceptionTest.class);
	
	public GameModel() {
		tableModel = new TableModel(this, 64, 64, 256, 256, 0);
		storeModel = new StoreModel(this, 384, 64, 192, 256, 0);
		earthModel = new EarthModel(this, 632, 128, 128, 192, 0);
		achievementsModel = new AchievementsModel();
		infoModel = new InfoModel(this, 64, 384, 192, 64, 0);
		upgradeModel = new UpgradeModel(this, 384, 384, 256, 64, 0);
		dust = 50;
		lastDustTime = 0;
		totalPower = 0;
		
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(Gdx.files.internal("TerraeDinos.png").read()))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        records.add(Arrays.asList(values));
		    }
		} catch (FileNotFoundException ex) {
			System.out.println("Optional file was not found.");
	    } catch (IOException ex) {
	    	System.out.println("IOExecption");
	    }
		
		System.out.println(records);
	}
	
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public StoreModel getStoreModel() {
		return storeModel;
	}
	
	public EarthModel getEarthModel() {
		return earthModel;
	}
	
	public AchievementsModel getAchievementsModel() {
		return achievementsModel;
	}
	
	public InfoModel getInfoModel() {
		return infoModel;
	}
	
	public UpgradeModel getUpgradeModel() {
		return upgradeModel;
	}
	
	public void addDust() {
		this.dust+=tableModel.getDustPerSecond();
		lastDustTime = TimeUtils.nanoTime();
	}
	
	public void subDust(int dust) {
		this.dust-=dust;
	}
	
	public long getLastDustTime() {
		return lastDustTime;
	}
	
	public int getDust() {
		return dust;
	}
	
	public void updateTotalPower() {
		totalPower = tableModel.getTotalPower();
	}
	
	public int getTotalPower() {
		return totalPower;
	}
}
