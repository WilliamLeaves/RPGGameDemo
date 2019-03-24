package VO;

public class SkillVO {
	public String skillName;
	public String targetType;
	public String desc;
	public String level;

	public SkillVO() {

	}

	public SkillVO(String skillName, String targetType, String desc, String level) {
		this.skillName = skillName;
		this.targetType = targetType;
		this.desc = desc;
		this.level = level;
	}
}
