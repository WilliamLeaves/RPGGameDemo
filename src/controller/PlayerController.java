package controller;

import java.util.ArrayList;
import java.util.HashMap;

import VO.EquipmentVO;
import VO.PlayerVO;
import VO.SkillVO;

public interface PlayerController {
	// 使用技能，其中能够结束玩家回合的技能也在其中；
	public boolean chooseSkill(String skillName, String... targetname);

	// 获取玩家对象
	public PlayerVO refreshPlayer();

	// 判定玩家是否死亡
	public boolean isDead();

	// 判定当前回合是否结束
	public boolean isRoundEnd();

	// 获取已经拥有的技能列表
	public ArrayList<SkillVO> getSkillList();

	// 获取所有目前可以学习的技能列表
	public ArrayList<SkillVO> getAllAvailableList(String playerName);

	// 使用装备
	public boolean waerEqiupment(String newEquipmentName);

	// 卸下装备
	public boolean unwearEquipment(String originEquipmentname);

	// 查看装备背包，包括穿戴中的和未穿戴的
	public ArrayList<EquipmentVO> getEquipmentList();

	// 加点，基础属性点和提升都写在map中,为Strength,Constitution,Mana,Defence,Resistence五个属性
	public boolean increaseStatus(HashMap<String, Integer> increaseMap);

	// 学技能
	public boolean learnSkill(String skillName);

	public ArrayList<SkillVO> getAllSkillofPlayer(String playerName);
}
