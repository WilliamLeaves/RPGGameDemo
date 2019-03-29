package core;

import java.util.ArrayList;

import VO.PlayerVO;
import VO.StageVO;
import controller.GameClientCtroller;
import model.GameStage;
import model.PlayerCharacter;
import util.VOFactory;

public class GameClient implements GameClientCtroller {
	public DataManager instance = DataManager.getInstance();

	@Override
	public PlayerVO getPlayer() {
		// TODO Auto-generated method stub
		PlayerVO playerVO = null;
		{
			playerVO = VOFactory.getPlayerVO(instance.player);
		}
		return playerVO;
	}

	@Override
	public boolean gameStart() {
		// TODO Auto-generated method stub
		return instance.loadData();
	}

	@Override
	public ArrayList<PlayerVO> getAvailablePlayer() {
		// TODO Auto-generated method stub
		ArrayList<PlayerVO> res = new ArrayList<PlayerVO>();
		ArrayList<PlayerCharacter> list = instance.playerList;
		for (PlayerCharacter player : list) {
			PlayerVO playerVO = new PlayerVO();
			{
				playerVO = VOFactory.getPlayerVO(player);
			}
			res.add(playerVO);
		}
		return res;
	}

	@Override
	public boolean choosePlayer(String playerName) {
		// TODO Auto-generated method stub
		ArrayList<PlayerCharacter> list = instance.playerList;
		boolean isContained = false;
		for (PlayerCharacter player : list) {
			if (player.name.equals(playerName)) {
				{
					instance.player = player.clone();
				}
				isContained = true;
				break;
			}
		}
		return isContained;
	}

	@Override
	public ArrayList<StageVO> getStageList() {
		// TODO Auto-generated method stub
		ArrayList<StageVO> res = new ArrayList<StageVO>();
		ArrayList<GameStage> list = instance.stageList;
		for (GameStage stage : list) {
			StageVO stageVO = null;
			{
				stageVO = VOFactory.getStageVO(stage);
			}
			res.add(stageVO);
		}
		return res;
	}

	@Override
	public boolean gameOver() {
		// TODO Auto-generated method stub
		System.out.println("GameOver!");
		return true;
	}

}
