package model.buff;

import java.util.ArrayList;

import model.GameCharacter;

public class Vulnurable extends Buff {

	@Override
	public void beAdded(GameCharacter caster, ArrayList<GameCharacter> targetList) {
		// TODO Auto-generated method stub
		this.caster = caster;
		this.targetList = targetList;
		this.round = Integer.parseInt(this.hashMap.get("round"));
		for (GameCharacter target : targetList) {
			target.defence = (int) (target.defence * 0.75);
			target.addBuff(this);
		}
	}

	@Override
	public void beNotified(State state) {
		// TODO Auto-generated method stub
		if (state == State.ROUND_END) {
			this.round -= 1;
			if (this.round == 0) {
				this.disappear();
			}
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disappear() {
		// TODO Auto-generated method stub
		for (GameCharacter target : targetList) {
			target.buffList.remove(this);
			target.defence = (int) (target.defence / 0.75);
		}
	}

}
