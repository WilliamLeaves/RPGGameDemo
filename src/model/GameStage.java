package model;

import java.util.ArrayList;
import java.util.HashMap;

import VO.RewardVO;
import VO.ShopVO;
import core.DataManager;

public class GameStage {
	public int stageNum;

	public ArrayList<String> enemyList;

	public RewardVO generateRewards() {
		// TODO Auto-generated method stub
		return null;
	}

	public ShopVO generateShop() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, EnemyCharacter> getEnemy() {
		HashMap<String, EnemyCharacter> map = new HashMap<String, EnemyCharacter>();
		ArrayList<EnemyCharacter> list = DataManager.getInstance().enemyList;
		for (String name : enemyList) {
			for (EnemyCharacter en : list) {
				if (en.name.equals(name)) {
					map.put(name, en.clone());
				}
			}
		}
		return map;
	}
}
