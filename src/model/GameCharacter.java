package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.buff.Buff;
import model.buff.State;

public abstract class GameCharacter {
	public String name;
	public int lifeMax;
	public int lifeRemain;
	public int constitution;
	public int strength;
	public int mana;
	public int defence;
	public int resistence;

	public ArrayList<Buff> buffList;
	public ArrayList<Skill> skillList;

	public HashMap<String, Integer> initBaseStatus;

	public abstract void desc();

	public abstract String getType();

	public void notifyAllBuff(State state) {
		for (Buff buff : buffList) {
			buff.beNotified(state);
		}
	}

	// 状态触发器，这些触发器会被buff调用以提醒其他buff
	public void addBuff(Buff buff) {
		this.buffList.add(buff);
		this.notifyAllBuff(State.GET_BUFF);
	}

	public void unsubscribe(Buff buff) {
		this.buffList.remove(buff);
	}

	public void restoreBaseStatus() {
		this.initBaseStatus = new HashMap<String, Integer>();
		initBaseStatus.put("Strength", this.strength);
		initBaseStatus.put("Mana", this.mana);
		initBaseStatus.put("Defence", this.defence);
		initBaseStatus.put("Constitution", this.constitution);
		initBaseStatus.put("Resistence", this.resistence);
	}

	public void recoverBaseStatus() {
		this.strength = this.initBaseStatus.get("Strength");
		this.mana = this.initBaseStatus.get("Mana");
		this.defence = this.initBaseStatus.get("Defence");
		this.constitution = this.initBaseStatus.get("Constitution");
		this.resistence = this.initBaseStatus.get("Resistence");
	}
}
