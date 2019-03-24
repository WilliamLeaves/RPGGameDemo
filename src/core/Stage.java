package core;

import java.util.ArrayList;

import VO.EnemyVO;
import VO.PlayerVO;
import VO.RewardVO;
import VO.ShopVO;
import controller.StageController;

public class Stage implements StageController {

	@Override
	public PlayerVO getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EnemyVO> getEnemies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStageClear() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RewardVO getRewards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopVO getShop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean buySomethingFromShop(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sellSomethingToShop(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
