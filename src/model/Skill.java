package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.buff.Buff;
import model.buff.BuffFactory;

public class Skill {
	public String skillName;
	public String targetType;
	public String desc;
	public int level;
	public String userName;
	public int actionPointCost;

	public HashMap<String, String> skillParameter;
	public ArrayList<String> buffList;
	public ArrayList<HashMap<String, String>> buffParameterMap;

	public void beUsed(GameCharacter caster, ArrayList<GameCharacter> targetList) {
		// 初始化生成bufflist
		ArrayList<Buff> concreteBuffList = new ArrayList<Buff>();
		for (int i = 0; i < buffList.size(); i++) {
			concreteBuffList.add(BuffFactory.createBuff(buffList.get(i), buffParameterMap.get(i)));
		}

		// 调用各个buff的beAdded方法
		for (Buff buff : concreteBuffList) {
			buff.beAdded(caster, targetList);
		}
		// 通知caster使用了技能

		// 通知target获得了buff
	}

	public Skill clone() {
		Skill cloneSkill = new Skill();
		cloneSkill.skillName = this.skillName;
		cloneSkill.targetType = this.targetType;
		cloneSkill.desc = this.desc;
		cloneSkill.level = this.level;
		cloneSkill.userName = this.userName;
		cloneSkill.actionPointCost = this.actionPointCost;

		// unchecked
		cloneSkill.skillParameter = this.skillParameter;
		cloneSkill.buffList = this.buffList;
		cloneSkill.buffParameterMap = this.buffParameterMap;

		return cloneSkill;
	}

}
