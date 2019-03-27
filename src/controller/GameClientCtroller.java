package controller;

import java.util.ArrayList;

import VO.PlayerVO;
import VO.StageVO;

public interface GameClientCtroller {
	// 开始游戏方法，调用该方法后台会开始加载数据
	public boolean gameStart();

	// 获取当前可用的游戏角色
	public ArrayList<PlayerVO> getAvailablePlayer();

	// 选择游戏角色开始游戏
	public boolean choosePlayer(String playerName);

	// 获取 当前的玩家
	public PlayerVO getPlayer();

	// 获取场景列表
	public ArrayList<StageVO> getStageList();

	// 结束游戏，暂时还没有用处
	public boolean gameOver();
}
