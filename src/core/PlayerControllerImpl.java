package core;

import java.util.ArrayList;
import java.util.HashMap;

import VO.EquipmentVO;
import VO.PlayerVO;
import VO.SkillVO;
import controller.PlayerController;
import model.Equipment;
import model.Skill;

public class PlayerControllerImpl implements PlayerController {
	
	public String name;

	public int actionPointMax;
	public int lifeMax;
	public int lifeRemain;
	public int constitution;
	public int Strength;
	public int mana;
	public int defence;
	public int resistance;
	public int gold;

	public int experience;
	public int level;

	public ArrayList<Equipment> equipmentList;
	public ArrayList<Skill> skillList;

	@Override
	public boolean chooseSkill(String skillName, String... targetname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlayerVO refreshPlayer(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoundEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<SkillVO> getSkillList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SkillVO> getAllAvailableList(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeEqiupment(String originEquipmentName, String newEquipmentName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<EquipmentVO> getEquipmentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean increaseStatus(HashMap<String, Integer> increaseMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean learnSkill(String skillName) {
		// TODO Auto-generated method stub
		return false;
	}

}
