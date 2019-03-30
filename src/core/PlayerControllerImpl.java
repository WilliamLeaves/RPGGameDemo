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
import util.VOFactory;

public class PlayerControllerImpl implements PlayerController {
	public DataManager instance = DataManager.getInstance();

	@Override
	public boolean chooseSkill(String skillName, String... targetname) {
		// TODO Auto-generated method stub

		// ȷ����������
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

		// ȷ�������ͷ�Ŀ��
		HashMap<String, EnemyCharacter> enemyMap = instance.enemyMap;
		ArrayList<GameCharacter> targetList = new ArrayList<GameCharacter>();
		if (chosenSkill.targetType.equals("self")) {
			targetList.add(instance.player);
			flag = false;
		} else if (chosenSkill.skillName.equals("single_enemy")) {
			for (String na : targetname) {
				EnemyCharacter enemy = enemyMap.get("na");
				if (enemy != null) {
					targetList.add(enemy);
					flag = false;
					break;
				}
			}
		} else if (chosenSkill.skillName.equals("all_enemies")) {
			for (EnemyCharacter enemy : enemyMap.values()) {
				targetList.add(enemy);
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

		// ʹ�ü���Ч��
		this.instance.player.actionPointRemain -= chosenSkill.actionPointCost;
		for (int i = 0; i < chosenSkill.buffList.size(); i++) {
			chosenSkill.beUsed(instance.player, targetList);
		}
		return true;
	}

	@Override
	public PlayerVO refreshPlayer() {
		// TODO Auto-generated method stub
		PlayerVO playerVO = null;
		{
			playerVO = VOFactory.getPlayerVO(instance.player);
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
				skillVO = VOFactory.getSkillVO(skill);
			}
			res.add(skillVO);
		}
		return res;
	}

	@Override
	public ArrayList<SkillVO> getAllAvailableList(String playerName) {
		// TODO Auto-generated method stub
		ArrayList<Skill> allList = instance.skillList;
		ArrayList<Skill> learnedList = instance.player.skillList;
		ArrayList<SkillVO> res = new ArrayList<SkillVO>();
		// �ҳ����м��ܵȼ���Ϊ0�����¼��ܵȼ����������޵ļ���
		for (Skill skill : allList) {
			Skill learned = null;
			for (Skill skill1 : learnedList) {
				if (skill1.skillName.equals(skill.skillName) && skill.level == skill1.level + 1) {
					SkillVO skillVO = VOFactory.getSkillVO(skill);
					res.add(skillVO);
					break;
				}
			}
		}
		// �ҳ����м��ܵȼ�Ϊ0���Ҹü���ǰ�ü��ܵȼ���Ϊ���
		for (Skill skill : allList) {
			boolean isLearned = false;
			for (Skill skill1 : learnedList) {
				if (skill1.skillName.equals(skill.skillName)) {
					isLearned = true;
					break;
				}
			}
			if (isLearned == true) {
				continue;
			}
			for (Skill skill2 : learnedList) {
				if (skill2.skillName.equals(skill.skillParameter.get("front_skill"))) {
					SkillVO skillVO = VOFactory.getSkillVO(skill);
					res.add(skillVO);
					break;
				}
			}
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
		// �������Ƿ����������
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

		// ��������Ƿ񳬹�����
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
				eqvo = VOFactory.getEquipmentVO(eq1);
			}
			eqvo.isWearing = true;
			res.add(eqvo);
		}
		for (Equipment eq2 : bagging) {
			EquipmentVO eqvo = null;
			{
				eqvo = VOFactory.getEquipmentVO(eq2);
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
		// �ж��Ƿ�����������
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

		// �ж��Ƿ��Ѿ�����ǰ�ü��ܣ�Ĭ��ǰ�ü��������һ������ǰ�ü��ܵ�Ҫ��Ϊ1
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

		// �ж��Ƿ��Ѿ�ѧ��������ܣ������Ƿ��Ѿ������ȼ�����

		int learned = -1;
		for (Skill skill : list) {
			if (skill.skillName.equals(skillLearning.skillName)) {
				learned = list.indexOf(skill);
				if ((skill.level >= Integer.parseInt(skill.skillParameter.get("max_level")))) {
					return false;
				}
			}
		}
		if (flag == false) {
			return false;
		} else {
			if (learned != -1) {
				// �Ƴ��ɵļ���,�����������ļ���
				instance.player.skillList.remove(learned);
				for (Skill levelUpSkill : instance.skillList) {
					if (levelUpSkill.skillName.equals(skillName) && levelUpSkill.level == learned + 1) {
						instance.player.skillList.add(levelUpSkill.clone());
					}
				}
			} else {
				// �����µļ���
				instance.player.skillList.add(skillLearning.clone());
			}
			return true;
		}
	}

}
