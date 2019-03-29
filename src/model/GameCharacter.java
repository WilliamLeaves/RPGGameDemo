package model;

import java.util.ArrayList;

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

	public abstract void desc();

	public abstract String getType();

	public abstract void notifyAllBuff(State state);
}
