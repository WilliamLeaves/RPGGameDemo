package controller;

import java.util.ArrayList;

import VO.EnemyVO;
import VO.PlayerVO;
import VO.RewardVO;
import VO.ShopVO;
import VO.StageVO;

public interface StageController {

	// ��ȡ�����ڵ����е���
	public ArrayList<EnemyVO> getEnemies();

	// �鿴��ǰ�����Ƿ��Ѿ�ͨ��
	public boolean isStageClear();

	// ��õ�ǰ��������
	public RewardVO getRewards();

	// ��õ�ǰ�������̵�
	public ShopVO getShop();

	// ���̵�������
	public boolean buySomethingFromShop(String name);

	// �����������̵�
	public boolean sellSomethingToShop(String name);

	// ������һ������
	public StageVO nextStage();

	// ������һغ�

	public boolean nextRound();
}
