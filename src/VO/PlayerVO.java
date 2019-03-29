package VO;

import java.util.ArrayList;

public class PlayerVO {
	public String name;
	public int lifeRemain;
	public int lifeMax;

	public int constitution;
	public int strength;
	public int mana;
	public int defence;
	public int resisitence;

	public int gold;

	public int exp;
	public int level;
	public int statusIncreasePointRemain;
	public int skillIncreasePointRemain;

	public int actionPointRemain;
	public int actionPointMax;

	public ArrayList<BuffVO> buffList;

	public PlayerVO(String name,int lifeRemain, int lifeMax, int constitution, int strength, int mana, int defence, int resisitence,
			int gold, int exp, int level, int statusIncreasePointRemain, int skillIncreasePointRemain,
			int actionPointRemain, int actionPointMax, ArrayList<BuffVO> buffList) {
		this.name=name;
		this.lifeRemain = lifeRemain;
		this.lifeMax = lifeMax;
		this.constitution = constitution;
		this.mana = mana;
		this.resisitence = resisitence;
		this.gold = gold;
		this.exp = exp;
		this.level = level;
		this.statusIncreasePointRemain = statusIncreasePointRemain;
		this.skillIncreasePointRemain = skillIncreasePointRemain;
		this.actionPointRemain = actionPointRemain;
		this.actionPointMax = actionPointMax;
		this.buffList = buffList;
	}

	public PlayerVO() {

	}
}
