package VO;

import java.util.HashMap;

import model.Equipment;

public class EquipmentVO {
	public String name;
	public String userName;
	public String desc;
	public String position;
	public int value;
	public boolean isWearing;

	public HashMap<String, String> increseList;

	public EquipmentVO() {

	}

	public EquipmentVO(String name, String userName, String desc, String position, int value,
			HashMap<String, String> increseList) {
		this.name = name;
		this.desc = desc;
		this.userName = userName;
		this.position = position;
		this.value = value;
		this.increseList = increseList;
		this.isWearing = false;
	}

	public Equipment parseEquipment() {
		// TODO Auto-generated method stub
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
