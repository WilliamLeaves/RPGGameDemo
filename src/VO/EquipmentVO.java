package VO;

import java.util.HashMap;

public class EquipmentVO {
	public String name;
	public String desc;
	public String position;
	public String value;

	public HashMap<String, String> increseList;

	public EquipmentVO() {

	}

	public EquipmentVO(String name, String desc, String position, String value, HashMap<String, String> increseList) {
		this.name = name;
		this.desc = desc;
		this.position = position;
		this.value = value;
		this.increseList = increseList;
	}
}
