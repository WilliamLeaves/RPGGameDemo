package controller;

import java.util.ArrayList;

import VO.PlayerVO;
import VO.StageVO;

public interface GameClientCtroller {
	// ��ʼ��Ϸ���������ø÷�����̨�Ὺʼ��������
	public boolean gameStart();

	// ��ȡ��ǰ���õ���Ϸ��ɫ
	public ArrayList<PlayerVO> getAvailablePlayer();

	// ѡ����Ϸ��ɫ��ʼ��Ϸ
	public boolean choosePlayer(String playerName);

	// ������һ������
	public StageVO nextStage();

	// ��ȡ�����б�
	public ArrayList<StageVO> getStageList();

	// ������Ϸ����ʱ��û���ô�
	public boolean gameOver();
}
