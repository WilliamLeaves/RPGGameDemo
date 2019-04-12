package model.buff;

import java.util.ArrayList;

import model.GameCharacter;

public class Damage_magical extends Buff {

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

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for (GameCharacter target : this.targetList) {
			int damage = (this.caster.mana + Integer.parseInt(this.hashMap.get("base_damage")) - target.resistence)
					* Integer.parseInt(this.hashMap.get("times"));
			target.lifeRemain -= damage;
			System.out.println(target.name + "受到" + damage + "点魔法伤害！");
			target.notifyAllBuff(State.HURT);
		}
	}

	@Override
	public void disappear() {
		// TODO Auto-generated method stub

	}

}
