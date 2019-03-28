package VO;

public class SkillVO {
	public String skillName;
	public String targetType;
	public String desc;
	public int level;
	public String userName;

	public SkillVO() {

	}

	public SkillVO(String skillName, String targetType, String desc, int level, String userName) {
		this.skillName = skillName;
		this.targetType = targetType;
		this.desc = desc;
		this.level = level;
		this.userName = userName;
	}
}
