package controller;

import VO.EnemyVO;

public interface EnemyController {
	// 根据敌人名称获取敌人
	public EnemyVO getEnemy(String name);

	// 刷新敌人，目前和上面那个的效果一致
	public EnemyVO refreshEnemy(String enemyName);

	// 返回敌人的选择，包括使用了什么技能，产生什么效果,调用这个方法，敌人就会开始执行选用的技能
	public String getEnemyChose(String enmeyName);

	// 判断敌人是否已经死亡
	public boolean isDead(String enemyName);

}
