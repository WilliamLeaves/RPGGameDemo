package model.buff;

import java.util.ArrayList;
import java.util.HashMap;

import model.GameCharacter;

public abstract class Buff {
	public int round;
	public String name;
	public String desc;

	public GameCharacter caster;
	public ArrayList<GameCharacter> targetList;
	public HashMap<String, String> hashMap;

	// 效果施加时
	public abstract void beAdded(GameCharacter caster, ArrayList<GameCharacter> targetList);

	// 效果被提醒时
	public abstract void beNotified(State state);

	// 效果触发时
	public abstract void execute();

	// 效果消失时
	public abstract void disappear();
}
