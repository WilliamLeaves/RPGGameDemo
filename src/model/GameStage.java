package model;

import java.util.ArrayList;
import java.util.HashMap;

import VO.EquipmentVO;
import VO.RewardVO;
import VO.ShopVO;
import core.DataManager;

public class GameStage {
	public int stageNum;

	public ArrayList<String> enemyList;

	public RewardVO generateRewards() {
		// TODO Auto-generated method stub
		DataManager instance = DataManager.getInstance();
		RewardVO rewardVO = new RewardVO();
		int exp = this.stageNum * instance.enemyMap.size() * 50;
		instance.player.experience += exp;
		System.out.println(instance.player.name + "获得" + exp + "点经验");
		if (instance.player.experience > 40 * ((instance.player.level - 1) * (instance.player.level - 1) + 1)) {
			instance.player.level++;
			instance.player.statusIncreasePointRemain += 5;
			instance.player.skillIncreasePointRemain++;
			System.out.println(instance.player.name + "升级了！");
		}
		rewardVO.expIncrease = exp;
		int gold = this.stageNum * instance.enemyMap.size() * 100;
		instance.player.gold += gold;
		System.out.println(instance.player.name + "获得" + gold + "个金币");
		rewardVO.goldIncrease = gold;
		rewardVO.eqiupmentDrop = new ArrayList<EquipmentVO>();
		return rewardVO;
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
