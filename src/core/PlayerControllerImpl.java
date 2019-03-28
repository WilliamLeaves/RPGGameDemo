package core;

import java.util.ArrayList;
import java.util.HashMap;

import VO.EquipmentVO;
import VO.PlayerVO;
import VO.SkillVO;
import controller.PlayerController;
import model.EnemyCharacter;
import model.Equipment;
import model.GameCharacter;
import model.Skill;

public class PlayerControllerImpl implements PlayerController {
	public DataManager instance = DataManager.getInstance();

	@Override
	public boolean chooseSkill(String skillName, String... targetname) {
		// TODO Auto-generated method stub

		// 确定技能名称
		ArrayList<Skill> list = instance.player.skillList;
		Skill chosenSkill = null;
		boolean flag = false;
		for (Skill skill : list) {
			if (skill.skillName.equals(skillName)) {
				chosenSkill = skill;
				flag = false;
				break;
			}
		}
		if (flag == true) {
			return false;
		}
		flag = true;

		// 确定技能释放目标
		ArrayList<EnemyCharacter> enemyList = instance.enemyList;
		ArrayList<GameCharacter> targetList = new ArrayList<GameCharacter>();
		if (chosenSkill.targetType.equals("self")) {
			targetList.add(instance.player);
			flag = false;
		} else if (chosenSkill.skillName.equals("single_enemy")) {
			for (String na : targetname) {
				for (EnemyCharacter enemy : enemyList) {
					if (enemy.name.equals(na)) {
						targetList.add(enemy);
						flag = false;
						break;
					}
				}
			}
		} else if (chosenSkill.skillName.equals("all_enemies")) {
			for (EnemyCharacter enemy : enemyList) {
				targetList.addAll(enemyList);
			}
			flag = false;
		} else if (chosenSkill.skillName.equals("random_enemies")) {
			{
				// unfinished
			}
		} else {
			return false;
		}
		if (flag == true) {
			return false;
		}
		flag = true;

		// 使用技能效果
		for (int i = 0; i < chosenSkill.buffList.size(); i++) {
			chosenSkill.buffList.get(i).execute(instance.player, targetList, chosenSkill.buffParameterMap.get(i));
			{
				// unfinished
				// 释放技能
			}
		}
		return true;
	}

	@Override
	public PlayerVO refreshPlayer(String playerName) {
		// TODO Auto-generated method stub
		PlayerVO playerVO = null;
		{
			// unfinished
		}
		return playerVO;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return instance.player.lifeRemain > 0 ? false : true;
	}

	@Override
	public boolean isRoundEnd() {
		// TODO Auto-generated method stub
		return instance.isPlayerRound ? true : false;
	}

	@Override
	public ArrayList<SkillVO> getSkillList() {
		// TODO Auto-generated method stub
		ArrayList<Skill> list = instance.player.skillList;
		ArrayList<SkillVO> res = new ArrayList<SkillVO>();
		for (Skill skill : list) {
			SkillVO skillVO = null;
			{
				// unfinished
			}
			res.add(skillVO);
		}
		return res;
	}

	@Override
	public ArrayList<SkillVO> getAllAvailableList(String playerName) {
		// TODO Auto-generated method stub
		ArrayList<Skill> list = instance.skillList;
		ArrayList<SkillVO> res = new ArrayList<SkillVO>();
		for (Skill skill : list) {
			SkillVO skillVO = null;
			if (skill.userName.equals(playerName)) {
				// unfinished
			}
			res.add(skillVO);
		}
		return res;
	}

	@Override
	public boolean waerEqiupment(String newEquipmentName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		ArrayList<Equipment> wearing = instance.player.equipmentList;
		ArrayList<Equipment> bagging = instance.player.bag;
		Equipment newEq = null;
		// 背包中是否有这件武器
		for (Equipment eq1 : bagging) {
			if (eq1.name.equals(newEquipmentName)) {
				newEq = eq1;
				flag = true;
				break;
			}
		}
		if (flag == false) {
			return false;
		}
		flag = false;

		// 检测数量是否超过限制
		int samePositionNum = 0;
		for (Equipment eq2 : wearing) {
			if (eq2.position.equals(newEq.position)) {
				samePositionNum++;
			}
		}
		if (samePositionNum >= Integer.parseInt(instance.baseConfigurationMap.get(newEq.position + "_MAX_NUM"))) {
			return false;
		} else {
			instance.player.bag.remove(instance.player.bag.indexOf(newEq));
			instance.player.equipmentList.add(newEq);
			instance.player.equipmentIncrease(newEq.increseList);
			return true;
		}
	}

	@Override
	public boolean unwearEquipment(String originEquipmentname) {
		// TODO Auto-generated method stub
		ArrayList<Equipment> wearing = instance.player.equipmentList;
		for (Equipment eq : wearing) {
			if (eq.name.equals(originEquipmentname)) {
				instance.player.bag.add(eq);
				instance.player.equipmentList.remove(instance.player.equipmentList.indexOf(eq));
				instance.player.equipmentDecrease(eq.increseList);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<EquipmentVO> getEquipmentList() {
		// TODO Auto-generated method stub
		ArrayList<EquipmentVO> res = new ArrayList<EquipmentVO>();
		ArrayList<Equipment> wearing = instance.player.equipmentList;
		ArrayList<Equipment> bagging = instance.player.bag;
		for (Equipment eq1 : wearing) {
			EquipmentVO eqvo = null;
			{
				// unfinished
			}
			eqvo.isWearing = true;
			res.add(eqvo);
		}
		for (Equipment eq2 : bagging) {
			EquipmentVO eqvo = null;
			{
				// unfinished
			}
			eqvo.isWearing = false;
			res.add(eqvo);
		}

		return res;
	}

	@Override
	public boolean increaseStatus(HashMap<String, Integer> increaseMap) {
		// TODO Auto-generated method stub
		return instance.player.increase(increaseMap);
	}

	@Override
	public boolean learnSkill(String skillName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		ArrayList<Skill> list = instance.player.skillList;
		ArrayList<Skill> allList = instance.skillList;
		Skill skillLearning = null;
		// 判断是否存在这个技能
		for (Skill skill : allList) {
			if (skill.userName.equals(instance.player.name)) {
				if (skill.skillName.equals(skillName)) {
					skillLearning = skill;
					break;
				}
			}
		}
		if (skillLearning == null) {
			return false;
		}

		// 判断是否已经掌握前置技能，默认前置技能最多有一个，且前置技能的要求都为1
		if (skillLearning.skillParameter.get("front_skill") != null) {
			for (Skill skill : list) {
				if (skill.skillName.equals(skillLearning.skillParameter.get("front_skill"))) {
					flag = true;
					break;
				}
			}
		} else {
			flag = true;
		}
		if (flag == false) {
			return false;
		}
		flag = true;

		// 判断是否已经学会这个技能，技能是否已经超过等级上限
		for (Skill skill : list) {
			if (skill.skillName.equals(skillLearning.skillName)
					&& (skill.level >= Integer.parseInt(skill.skillParameter.get("max_level")))) {
				return false;
			}
		}
		if (flag == false) {
			return false;
		} else {
			instance.player.skillList.add(skillLearning);
			return true;
		}
	}

}
