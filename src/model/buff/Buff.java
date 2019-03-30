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

	// Ч��ʩ��ʱ
	public abstract void beAdded(GameCharacter caster, ArrayList<GameCharacter> targetList);

	// Ч��������ʱ
	public abstract void beNotified(State state);

	// Ч������ʱ
	public abstract void execute();

	// Ч����ʧʱ
	public abstract void disappear();
}
