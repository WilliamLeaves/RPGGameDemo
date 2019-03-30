package model;

import java.util.HashMap;

public class Equipment {
	public String name;
	public String userName;
	public String desc;
	public String position;
	public int value;

	public boolean purchasable;
	public boolean droppable;
	public int appearPro;
	public int lowestAppearStageNum;
	public int lowestLevel;

	public HashMap<String, String> increseList;

	public Equipment clone() {
		Equipment eq = new Equipment();
		eq.name = this.name;
		eq.userName = this.userName;
		eq.desc = this.desc;
		eq.position = this.position;
		eq.value = this.value;
		eq.increseList = this.increseList;

		eq.purchasable = this.purchasable;
		eq.droppable = this.droppable;
		eq.appearPro = this.appearPro;
		eq.lowestAppearStageNum = this.lowestAppearStageNum;
		eq.lowestLevel = this.lowestLevel;
		
		return eq;
	}
}
