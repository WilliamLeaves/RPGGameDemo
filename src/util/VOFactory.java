package util;

import java.util.ArrayList;

import VO.BuffVO;
import VO.EnemyVO;
import VO.EquipmentVO;
import VO.PlayerVO;
import VO.RewardVO;
import VO.ShopVO;
import VO.SkillVO;
import VO.StageVO;
import core.DataManager;
import model.EnemyCharacter;
import model.Equipment;
import model.GameStage;
import model.PlayerCharacter;
import model.Skill;
import model.buff.Buff;

//VO对象的简单工厂
public class VOFactory {

	public static PlayerVO getPlayerVO(PlayerCharacter pl) {
		PlayerVO playerVO = new PlayerVO(pl.name, pl.lifeRemain, pl.lifeMax, pl.constitution, pl.strength, pl.mana,
				pl.defence, pl.resistence, pl.gold, pl.experience, pl.level, pl.statusIncreasePointRemain,
				pl.skillIncreasePointRemain, pl.actionPointRemain, pl.actionPointMax, new ArrayList<BuffVO>());

		for (Buff buff : pl.buffList) {
			playerVO.buffList.add(getBuffVO(buff));

		}
		return playerVO;
	}

	public static EnemyVO getEnemyVO(EnemyCharacter en) {
		EnemyVO enemyVO = new EnemyVO(en.name, en.lifeRemain, en.lifeMax);
		return enemyVO;
	}

	public static BuffVO getBuffVO(Buff buff) {
		BuffVO buffVO = new BuffVO(buff.name, buff.desc);
		return buffVO;
	}

	public static EquipmentVO getEquipmentVO(Equipment eq) {
		EquipmentVO equipmentVO = new EquipmentVO(eq.name, eq.userName, eq.desc, eq.position, eq.value, eq.increseList);
		return equipmentVO;
	}

	public static RewardVO getRewardVO() {
		return DataManager.getInstance().currentStage.generateRewards();
	}

	public static ShopVO getShopVO() {
		// TODO Auto-generated method stub
		return DataManager.getInstance().currentStage.generateShop();
	}

	public static SkillVO getSkillVO(Skill skill) {
		SkillVO skillVO = new SkillVO(skill.skillName, skill.targetType, skill.desc, skill.level, skill.userName,
				skill.actionPointCost);
		return skillVO;
	}

	public static StageVO getStageVO(GameStage gameStage) {
		StageVO stageVO = new StageVO(gameStage.stageNum);
		return stageVO;
	}
}
