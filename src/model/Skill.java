package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.buff.Buff;

public class Skill {
	public String skillName;
	public String targetType;
	public String desc;
	public int level;
	public String userName;
	public int actionPointCost;

	public HashMap<String, String> skillParameter;
	public ArrayList<Buff> buffList;
	public ArrayList<HashMap<String, String>> buffParameterMap;

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
