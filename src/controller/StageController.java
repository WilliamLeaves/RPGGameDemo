package controller;

import java.util.ArrayList;

import VO.EnemyVO;
import VO.PlayerVO;
import VO.RewardVO;
import VO.ShopVO;
import VO.StageVO;

public interface StageController {

	// 获取场景内的所有敌人
	public ArrayList<EnemyVO> getEnemies();

	// 查看当前场景是否已经通过
	public boolean isStageClear();

	// 获得当前场景奖励
	public RewardVO getRewards();

	// 获得当前场景的商店
	public ShopVO getShop();

	// 从商店里买东西
	public boolean buySomethingFromShop(String name);

	// 将东西卖给商店
	public boolean sellSomethingToShop(String name);

	// 进入下一个场景
	public StageVO nextStage();

	// 结束玩家回合

	public boolean nextRound();
}
