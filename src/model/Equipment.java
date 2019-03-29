package model;

import java.util.HashMap;

public class Equipment {
	public String name;
	public String userName;
	public String desc;
	public String position;
	public int value;

	public HashMap<String, String> increseList;

	public Equipment clone() {
		Equipment eq = new Equipment();
		eq.name = this.name;
		eq.userName = this.userName;
		eq.desc = this.desc;
		eq.position = this.position;
		eq.value = this.value;
		eq.increseList = this.increseList;
		return eq;
	}
}
