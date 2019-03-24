package controller;

import java.util.ArrayList;

import VO.EnemyVO;
import VO.PlayerVO;
import VO.RewardVO;
import VO.ShopVO;

public interface StageController {
	// 获取场景内的玩家
	public PlayerVO getPlayer();

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
}
