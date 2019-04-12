package util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import core.DataManager;
import model.EnemyCharacter;
import model.Equipment;
import model.PlayerCharacter;
import model.Skill;
import model.buff.Buff;

public class CharacterLoader extends DataLoader {

	private final String filePath = "./data/character.xml";

	@Override
	public boolean load() throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filePath));
		Element root = document.getRootElement();
		List<Element> childElements = root.elements();
		for (Element child : childElements) {
			if (child.elementText("type").equals("player")) {
				PlayerCharacter character = new PlayerCharacter();
				character.name = child.elementText("name");
				character.gold = Integer.parseInt(child.elementText("init_gold").toString());
				character.actionPointMax = Integer
						.parseInt(DataManager.getInstance().baseConfigurationMap.get("BASE_ACTION_POINT"));
				character.actionPointRemain = character.actionPointMax;
				character.constitution = Integer.parseInt(child.elementText("constitution"));
				character.strength = Integer.parseInt(child.elementText("strength"));
				character.mana = Integer.parseInt(child.elementText("mana"));
				character.defence = Integer.parseInt(child.elementText("defence"));
				character.resistence = Integer.parseInt(child.elementText("resistence"));

				character.experience = 0;
				character.level = 1;
				character.initBaseStatus = new HashMap<String, Integer>();
				character.statusIncreasePointRemain = 0;
				character.bag = new ArrayList<Equipment>();

				character.equipmentList = new ArrayList<Equipment>();
				for (Element skillEl : child.element("init_equipment").elements()) {
					for (int i = 0; i < instance.skillList.size(); i++) {
						if (skillEl.elementText("equipment_name").equals(instance.equipmentList.get(i).name)) {
							character.equipmentList.add(instance.equipmentList.get(i).clone());
							character.strength += Integer
									.parseInt(instance.equipmentList.get(i).increseList.get("Strength"));
							character.mana += Integer.parseInt(instance.equipmentList.get(i).increseList.get("Mana"));
							character.defence += Integer
									.parseInt(instance.equipmentList.get(i).increseList.get("Defence"));
							character.constitution += Integer
									.parseInt(instance.equipmentList.get(i).increseList.get("Constitution"));
							character.resistence += Integer
									.parseInt(instance.equipmentList.get(i).increseList.get("Resistence"));
							break;
						}
					}
				}
				character.skillList = new ArrayList<Skill>();
				for (Element skillEl : child.element("init_skill").elements()) {
					for (int i = 0; i < instance.skillList.size(); i++) {
						if (skillEl.elementText("skill_name").equals(instance.skillList.get(i).skillName) && Integer
								.parseInt(skillEl.elementText("skill_level")) == (instance.skillList.get(i).level)) {
							character.skillList.add(instance.skillList.get(i).clone());
							break;
						}
					}
				}
				character.buffList = new ArrayList<Buff>();
				character.initBaseStatus = new HashMap<String, Integer>();
				{
					character.initBaseStatus.put("Strength", character.strength);
					character.initBaseStatus.put("Mana", character.mana);
					character.initBaseStatus.put("Defence", character.defence);
					character.initBaseStatus.put("Resistence", character.resistence);
					character.initBaseStatus.put("Constitution", character.constitution);
				}
				instance.playerList.add(character);
			} else if (child.elementText("type").equals("enemy")) {
				// 批量添加敌人
				String[] str = child.elementText("name").split(",");
				int num = child.elementText("name").split(",").length;
				for (int i = 0; i < num; i++) {
					EnemyCharacter character = new EnemyCharacter();
					character.name = child.elementText("name").split(",")[i];
					character.constitution = Integer.parseInt(child.elementText("constitution").split(",")[i]);
					character.strength = Integer.parseInt(child.elementText("strength").split(",")[i]);
					character.mana = Integer.parseInt(child.elementText("mana").split(",")[i]);
					character.defence = Integer.parseInt(child.elementText("defence").split(",")[i]);
					character.resistence = Integer.parseInt(child.elementText("resistence").split(",")[i]);
					character.initBaseStatus = new HashMap<String, Integer>();
					character.skillList = new ArrayList<Skill>();
					for (Element skillEl : child.element("init_skill").elements()) {
						for (int j = 0; j < instance.skillList.size(); j++) {
							if (skillEl.elementText("skill_name").equals(instance.skillList.get(j).skillName)
									&& Integer.parseInt(skillEl.elementText("skill_level")
											.split(",")[i]) == (instance.skillList.get(j).level)) {
								character.skillList.add(instance.skillList.get(j).clone());
								break;
							}
						}
					}
					character.buffList = new ArrayList<Buff>();
					instance.enemyList.add(character);
				}

			}
		}
		return true;
	}

	@Override
	public Object loadByName(String nameAttribute) throws DocumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
