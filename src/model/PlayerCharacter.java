package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.buff.Buff;

public class PlayerCharacter extends GameCharacter {
	public int actionPointRemain;
	public int actionPointMax;

	public int gold;

	public int experience;
	public int level;

	public ArrayList<Equipment> equipmentList;

	public ArrayList<Equipment> bag;

	public int statusIncreasePointRemain;

	public int skillIncreasePointRemain;

	// public int actionPointMaxactionPointMax;

	@Override
	public void desc() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.getClass().toString();
	}

	public void equipmentIncrease(HashMap<String, String> increaseList) {
		// TODO Auto-generated method stub
		this.initBaseStatus.replace("Strength",
				this.initBaseStatus.get("Strength") + Integer.parseInt(increaseList.get("Strength")));
		this.initBaseStatus.replace("Constitution",
				this.initBaseStatus.get("Constitution") + Integer.parseInt(increaseList.get("Constitution")));
		this.initBaseStatus.replace("Mana",
				this.initBaseStatus.get("Mana") + Integer.parseInt(increaseList.get("Mana")));
		this.initBaseStatus.replace("Defence",
				this.initBaseStatus.get("Defence") + Integer.parseInt(increaseList.get("Defence")));
		this.initBaseStatus.replace("Resistence",
				this.initBaseStatus.get("Resistence") + Integer.parseInt(increaseList.get("Resistence")));
		this.strength += Integer.parseInt(increaseList.get("Strength"));
		this.constitution += Integer.parseInt(increaseList.get("Constitution"));
		this.mana += Integer.parseInt(increaseList.get("Mana"));
		this.defence += Integer.parseInt(increaseList.get("Defence"));
		this.resistence += Integer.parseInt(increaseList.get("Resistence"));
	}

	public void equipmentDecrease(HashMap<String, String> increaseList) {
		// TODO Auto-generated method stub
		this.initBaseStatus.replace("Strength",
				this.initBaseStatus.get("Strength") - Integer.parseInt(increaseList.get("Strength")));
		this.initBaseStatus.replace("Constitution",
				this.initBaseStatus.get("Constitution") - Integer.parseInt(increaseList.get("Constitution")));
		this.initBaseStatus.replace("Mana",
				this.initBaseStatus.get("Mana") - Integer.parseInt(increaseList.get("Mana")));
		this.initBaseStatus.replace("Defence",
				this.initBaseStatus.get("Defence") - Integer.parseInt(increaseList.get("Defence")));
		this.initBaseStatus.replace("Resistence",
				this.initBaseStatus.get("Resistence") - Integer.parseInt(increaseList.get("Resistence")));
		this.strength -= Integer.parseInt(increaseList.get("Strength"));
		this.constitution -= Integer.parseInt(increaseList.get("Constitution"));
		this.mana -= Integer.parseInt(increaseList.get("Mana"));
		this.defence -= Integer.parseInt(increaseList.get("Defence"));
		this.resistence -= Integer.parseInt(increaseList.get("Resistence"));

	}

	public boolean increase(HashMap<String, Integer> increaseMap) {
		// TODO Auto-generated method stub
		int sum = 0;
		int strength_inc = increaseMap.get("Strength");
		int constitution_inc = increaseMap.get("Constitution");
		int mana_inc = increaseMap.get("Mana");
		int defence_inc = increaseMap.get("Defence");
		int resistence_inc = increaseMap.get("Resistence");
		sum = strength_inc + constitution_inc + mana_inc + defence_inc + resistence_inc;
		if (sum > this.statusIncreasePointRemain) {
			return false;
		} else {
			this.initBaseStatus.replace("Strength", this.initBaseStatus.get("Strength") + strength_inc);
			this.initBaseStatus.replace("Constitution", this.initBaseStatus.get("Constitution") + constitution_inc);
			this.initBaseStatus.replace("Mana", this.initBaseStatus.get("Mana") + mana_inc);
			this.initBaseStatus.replace("Defence", this.initBaseStatus.get("Defence") + defence_inc);
			this.initBaseStatus.replace("Resistence", this.initBaseStatus.get("Resistence") + resistence_inc);
			this.strength += strength_inc;
			this.constitution += constitution_inc;
			this.mana += mana_inc;
			this.resistence += resistence_inc;
			this.defence += defence_inc;
			this.statusIncreasePointRemain -= sum;
		}
		return true;
	}

	public PlayerCharacter clone() {
		PlayerCharacter clonePlayer = new PlayerCharacter();
		clonePlayer.name = this.name;
		clonePlayer.actionPointMax = this.actionPointMax;
		clonePlayer.lifeMax = this.lifeMax;
		clonePlayer.lifeRemain = this.lifeRemain;
		clonePlayer.constitution = this.constitution;
		clonePlayer.strength = this.strength;
		clonePlayer.mana = this.mana;
		clonePlayer.defence = this.defence;
		clonePlayer.resistence = this.resistence;
		clonePlayer.gold = this.gold;

		clonePlayer.experience = this.experience;
		clonePlayer.level = this.level;

		clonePlayer.equipmentList = new ArrayList<Equipment>();
		for (Equipment eq : this.equipmentList) {
			clonePlayer.equipmentList.add(eq.clone());
		}
		clonePlayer.skillList = new ArrayList<Skill>();
		for (Skill sk : this.skillList) {
			clonePlayer.skillList.add(sk.clone());
		}
		clonePlayer.bag = new ArrayList<Equipment>();
		for (Equipment eq : this.bag) {
			clonePlayer.bag.add(eq.clone());
		}
		clonePlayer.buffList = new ArrayList<Buff>();
		// for (Buff bu : this.buffList) {
		// clonePlayer.buffList.add(bu);
		// }
		clonePlayer.initBaseStatus = new HashMap<String, Integer>();
		clonePlayer.initBaseStatus.putAll(initBaseStatus);
		return clonePlayer;
	}

}
