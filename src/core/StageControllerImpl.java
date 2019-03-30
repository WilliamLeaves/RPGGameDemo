package core;

import java.util.ArrayList;

import VO.EnemyVO;
import VO.EquipmentVO;
import VO.RewardVO;
import VO.ShopVO;
import VO.StageVO;
import controller.StageController;
import model.EnemyCharacter;
import model.Equipment;
import model.GameStage;
import model.buff.State;
import util.VOFactory;

public class StageControllerImpl implements StageController {
	public DataManager instance = DataManager.getInstance();
	public ShopVO shopVO;
	public RewardVO rewardVO;

	@Override
	public ArrayList<EnemyVO> getEnemies() {
		// TODO Auto-generated method stub
		ArrayList<EnemyVO> res = new ArrayList<EnemyVO>();
		for (String key : instance.enemyMap.keySet()) {
			if (instance.enemyMap.get(key).lifeRemain > 0) {
				EnemyVO enemyVO = null;
				{
					enemyVO = VOFactory.getEnemyVO(instance.enemyMap.get(key));
				}
				res.add(enemyVO);
			}
		}
		return res;
	}

	@Override
	public boolean isStageClear() {
		// TODO Auto-generated method stub
		boolean isClear = true;
		for (String key : instance.enemyMap.keySet()) {
			if (instance.enemyMap.get(key).lifeRemain > 0) {
				isClear = false;
				break;
			}
		}
		return isClear;
	}

	@Override
	public RewardVO getRewards() {
		// TODO Auto-generated method stub
		if (rewardVO == null) {
			this.rewardVO = VOFactory.getRewardVO();
		}
		return rewardVO;
	}

	@Override
	public ShopVO getShop() {
		// TODO Auto-generated method stub
		if (shopVO == null) {
			this.shopVO = VOFactory.getShopVO();
		}
		return shopVO;
	}

	@Override
	public boolean buySomethingFromShop(String name) {
		// TODO Auto-generated method stub
		ArrayList<EquipmentVO> list = this.shopVO.equipmentList;
		for (int i = 0; i < list.size(); i++) {
			EquipmentVO vo = list.get(i);
			if (vo.name.equals(name)) {
				if (vo.value <= instance.player.gold) {
					this.shopVO.equipmentList.remove(i);
					Equipment eq = list.get(i).parseEquipment();
					instance.player.bag.add(eq);
					instance.player.gold -= vo.value;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean sellSomethingToShop(String name) {
		// TODO Auto-generated method stub
		ArrayList<Equipment> list = instance.player.bag;
		for (int i = 0; i < list.size(); i++) {
			Equipment equipment = list.get(i);
			if (equipment.name.equals(name)) {
				list.remove(i);
				instance.player.gold += equipment.value
						* Integer.parseInt(instance.baseConfigurationMap.get("SELLING_VALUE_RATE"));
				return true;
			}
		}
		return false;
	}

	@Override
	public StageVO nextStage() {
		// TODO Auto-generated method stub
		// 将基本属性恢复为进入场景时的数值
		instance.player.notifyAllBuff(State.STATE_END);
		instance.player.recoverBaseStatus();
		StageVO stagtVO = null;
		ArrayList<GameStage> list = instance.stageList;
		int currentStageNum = instance.currentStage != null ? instance.currentStage.stageNum : 0;
		for (GameStage stage : list) {
			if (stage.stageNum == currentStageNum + 1) {
				{
					instance.currentStage = stage;
					instance.player.lifeMax = Integer.parseInt(instance.baseConfigurationMap.get("CONSTITUTION_PARA"))
							* instance.player.constitution;
					instance.player.lifeRemain = instance.player.lifeMax;
					instance.player.restoreBaseStatus();
					instance.enemyMap = stage.getEnemy();
				}
			}
		}
		this.rewardVO = null;
		this.shopVO = null;
		instance.isPlayerRound = true;
		return stagtVO;
	}

	@Override
	public boolean nextRound() {
		// TODO Auto-generated method stub
		if (instance.isPlayerRound == false) {
			return false;
		} else {
			instance.isPlayerRound = true;
			instance.player.actionPointRemain = instance.player.actionPointMax;
			for (String key : instance.enemyMap.keySet()) {
				instance.enemyMap.get(key).notifyAllBuff(State.ROUND_END);
			}
			instance.player.notifyAllBuff(State.ROUND_END);
			return true;
		}
	}

}
