package model;

import java.util.ArrayList;

public class PlayerCharacter extends GameCharacter {
	public String name;

	public int actionPointMax;
	public int lifeMax;
	public int lifeRemain;
	public int constitution;
	public int Strength;
	public int mana;
	public int defence;
	public int resistance;
	public int gold;

	public int experience;
	public int level;

	public ArrayList<Equipment> equipmentList;
	public ArrayList<Skill> skillList;
	public ArrayList<Equipment> bag;

	@Override
	public void desc() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.getClass().toString();
	}

}
