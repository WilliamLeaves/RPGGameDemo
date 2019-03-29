package model;

import java.util.ArrayList;

import model.buff.State;

public class EnemyCharacter extends GameCharacter {

	@Override
	public void desc() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public EnemyCharacter clone() {
		EnemyCharacter clone = new EnemyCharacter();
		clone.name = this.name;
		clone.lifeMax = this.lifeMax;
		clone.lifeRemain = this.lifeRemain;
		clone.constitution = this.constitution;
		clone.strength = this.strength;
		clone.mana = this.mana;
		clone.defence = this.defence;
		clone.resistence = this.resistence;

		clone.skillList = new ArrayList<Skill>();
		for (Skill sk : this.skillList) {
			clone.skillList.add(sk.clone());
		}
		return clone;
	}

	@Override
	public void notifyAllBuff(State state) {
		// TODO Auto-generated method stub
		
	}

}
