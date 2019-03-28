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

	public HashMap<String, String> skillParameter;
	public ArrayList<Buff> buffList;
	public ArrayList<HashMap<String, String>> buffParameterMap;

}
