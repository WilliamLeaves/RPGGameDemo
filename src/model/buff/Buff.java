package model.buff;

import java.util.ArrayList;
import java.util.HashMap;

import model.GameCharacter;

public abstract class Buff {

	public abstract void execute(GameCharacter caster, ArrayList<GameCharacter> targetList, HashMap<String, String> hashMap);

}
