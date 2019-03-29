package core;

import java.util.ArrayList;
import java.util.HashMap;

import org.dom4j.DocumentException;

import model.EnemyCharacter;
import model.Equipment;
import model.GameStage;
import model.PlayerCharacter;
import model.Skill;
import util.BaseConfigurationLoader;
import util.CharacterLoader;
import util.DataLoader;
import util.EquipmentLoader;
import util.SkillLoader;
import util.StageLoader;

public class DataManager {
	private static DataManager instance = new DataManager();

	private DataLoader dataLoader;

	//初始载入数据
	public HashMap<String,String> baseConfigurationMap;
	public ArrayList<PlayerCharacter> playerList;
	public ArrayList<EnemyCharacter> enemyList;
	public ArrayList<Skill> skillList;
	public ArrayList<Equipment> equipmentList;
	public ArrayList<GameStage> stageList;

	
	
	//运行时使用到的数据
	public GameStage currentStage;
	public PlayerCharacter player;
	public HashMap<String, EnemyCharacter> enemyMap;

	public boolean isPlayerRound;
	
	
	private DataManager() {

	}

	public static DataManager getInstance() {
		return instance;
	}

	public boolean loadData() {
		boolean flag = true;
		try {
			this.dataLoader = new BaseConfigurationLoader();
			dataLoader.load(this);
			this.dataLoader = new CharacterLoader();
			dataLoader.load(this);
			this.dataLoader = new StageLoader();
			dataLoader.load(this);
			this.dataLoader = new SkillLoader();
			dataLoader.load(this);
			this.dataLoader = new EquipmentLoader();
			dataLoader.load(this);
			dataLoader = new SkillLoader();
			dataLoader.load(this);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
