package VO;

public class SkillVO {
	public String skillName;
	public String targetType;
	public String desc;
	public int level;
	public String userName;
	public int actionPointCost;

	public SkillVO() {

	}

	public SkillVO(String skillName, String targetType, String desc, int level, String userName, int actionPointCost) {
		this.skillName = skillName;
		this.targetType = targetType;
		this.desc = desc;
		this.level = level;
		this.userName = userName;
		this.actionPointCost = actionPointCost;
	}
}
