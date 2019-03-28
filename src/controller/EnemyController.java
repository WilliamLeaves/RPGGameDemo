package controller;

import VO.EnemyVO;

public interface EnemyController {
	// ���ݵ������ƻ�ȡ����
	public EnemyVO getEnemy(String name);

	// ˢ�µ��ˣ�Ŀǰ�������Ǹ���Ч��һ��
	public EnemyVO refreshEnemy(String enemyName);

	// ���ص��˵�ѡ�񣬰���ʹ����ʲô���ܣ�����ʲôЧ��,����������������˾ͻῪʼִ��ѡ�õļ���
	public String getEnemyChose(String enmeyName);

	// �жϵ����Ƿ��Ѿ�����
	public boolean isDead(String enemyName);

}
