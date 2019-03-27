package core;

import java.util.ArrayList;

import VO.PlayerVO;
import VO.StageVO;
import controller.GameClientCtroller;
import model.GameStage;
import model.PlayerCharacter;

public class GameClient implements GameClientCtroller {
	public StageControllerImpl stageController;

	@Override
	public PlayerVO getPlayer() {
		// TODO Auto-generated method stub
		PlayerVO playerVO = null;
		{
			// unfinished
		}
		return playerVO;
	}

	@Override
	public boolean gameStart() {
		// TODO Auto-generated method stub
		return DataManager.getInstance().loadData();
	}

	@Override
	public ArrayList<PlayerVO> getAvailablePlayer() {
		// TODO Auto-generated method stub
		ArrayList<PlayerVO> res = new ArrayList<PlayerVO>();
		ArrayList<PlayerCharacter> list = DataManager.getInstance().playerList;
		for (PlayerCharacter player : list) {
			PlayerVO playerVO = new PlayerVO();
			{
				// unfinished
			}
			res.add(playerVO);
		}
		return res;
	}

	@Override
	public boolean choosePlayer(String playerName) {
		// TODO Auto-generated method stub
		ArrayList<PlayerCharacter> list = DataManager.getInstance().playerList;
		boolean isContained = false;
		for (PlayerCharacter player : list) {
			if (player.name.equals(playerName)) {
				{
					DataManager.getInstance().player = player;
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
		ArrayList<GameStage> list = DataManager.getInstance().stageList;
		for (GameStage stage : list) {
			StageVO stageVO = null;
			{
				// unfinished
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
