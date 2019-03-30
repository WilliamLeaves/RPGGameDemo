package core;

import java.util.ArrayList;

import VO.EnemyVO;
import controller.EnemyController;
import model.EnemyCharacter;
import model.GameCharacter;
import model.Skill;
import util.VOFactory;

public class EnemyControllerImpl implements EnemyController {
	public DataManager instance = DataManager.getInstance();

	@Override
	public EnemyVO getEnemy(String name) {
		// TODO Auto-generated method stub
		for (String key : instance.enemyMap.keySet()) {
			if (instance.enemyMap.get(key).name.equals(name)) {
				EnemyVO vo = null;
				{
					vo = VOFactory.getEnemyVO(instance.enemyMap.get(key));
				}
				return vo;
			}
		}
		return null;
	}

	@Override
	public EnemyVO refreshEnemy(String enemyName) {
		// TODO Auto-generated method stub
		for (String key : instance.enemyMap.keySet()) {
			if (instance.enemyMap.get(key).name.equals(enemyName)) {
				EnemyVO vo = null;
				{
					vo = VOFactory.getEnemyVO(instance.enemyMap.get(key));
				}
				return vo;
			}
		}
		return null;
	}

	@Override
	public String getEnemyChose(String enemyName) {
		// TODO Auto-generated method stub
		for (String key : instance.enemyMap.keySet()) {
			EnemyCharacter en = instance.enemyMap.get(key);
			if (en.name.equals(enemyName)) {
				int r = (int) (Math.random() * en.skillList.size());
				Skill chosenSkill = en.skillList.get(r);
				boolean flag = true;
				ArrayList<EnemyCharacter> enemyList = instance.enemyList;
				ArrayList<GameCharacter> targetList = new ArrayList<GameCharacter>();
				if (chosenSkill.targetType.equals("self")) {
					targetList.add(en);
					flag = false;
				} else if (chosenSkill.skillName.equals("single_enemy")) {
					targetList.add(instance.player);
				} else if (chosenSkill.skillName.equals("all_enemies")) {
					{
						// unfinished
					}
				} else if (chosenSkill.skillName.equals("random_enemies")) {
					{
						// unfinished
					}
				} else {
					return "nothing happens";
				}
				// 使用技能效果
				for (int i = 0; i < chosenSkill.buffList.size(); i++) {
					chosenSkill.beUsed(en,targetList);
				}
				return en.name + "使用" + chosenSkill + "技能！";
			}
			break;
		}
		return "nothing happens";
	}

	@Override
	public boolean isDead(String enemyName) {
		// TODO Auto-generated method stub
		for (String key : instance.enemyMap.keySet()) {
			if (instance.enemyMap.get(key).name.equals(enemyName)) {
				if (instance.enemyMap.get(key).lifeRemain > 0) {
					return false;
				} else {
					return true;
				}
			}
		}
		return true;
	}

}
