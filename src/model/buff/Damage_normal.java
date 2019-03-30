package model.buff;

import java.util.ArrayList;

import model.GameCharacter;

//普通物理攻击，一旦被添加，立刻生效并被移除
public class Damage_normal extends Buff {

	@Override
	public void beAdded(GameCharacter caster, ArrayList<GameCharacter> targetList) {
		// TODO Auto-generated method stub
		this.caster = caster;
		this.targetList = targetList;
		this.execute();
	}

	@Override
	public void beNotified(State state) {
		// TODO Auto-generated method stub
		// do nothing
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for (GameCharacter target : this.targetList) {
			int damage = (this.caster.strength + Integer.parseInt(this.hashMap.get("base_damage")) - target.defence)
					* Integer.parseInt(this.hashMap.get("times"));
			target.lifeRemain -= damage;
			target.notifyAllBuff(State.HURT);
		}
	}

	@Override
	public void disappear() {
		// TODO Auto-generated method stub
		// do nothing
	}

}
