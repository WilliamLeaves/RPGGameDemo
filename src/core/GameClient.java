package core;

import java.util.ArrayList;

import VO.PlayerVO;
import VO.StageVO;
import controller.GameClientCtroller;

public class GameClient implements GameClientCtroller {

	@Override
	public boolean gameStart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<PlayerVO> getAvailablePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean choosePlayer(String playerName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StageVO nextStage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StageVO> getStageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean gameOver() {
		// TODO Auto-generated method stub
		return false;
	}

}
