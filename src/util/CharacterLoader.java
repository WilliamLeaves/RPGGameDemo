package util;

import org.dom4j.DocumentException;

import core.DataManager;

public class CharacterLoader extends DataLoader {

	private final String filePath = "./data/character.xml";

	@Override
	public boolean load(DataManager dataManager) throws DocumentException {
		// TODO Auto-generated method stub
//		SAXReader reader = new SAXReader();
//		Document document = reader.read(new File(filePath));
//		Element root = document.getRootElement();
//		List<Element> childElements = root.elements();
//		for (Element child : childElements) {
//			if (child.elementText("type").equals("player")) {
//				PlayerCharacter playerCharacter = new PlayerCharacter();
//				playerCharacter.name = child.elementText("name");
//				playerCharacter.constitution = Integer.parseInt(child.elementText("constitution"));
//				playerCharacter.Strength = Integer.parseInt(child.elementText("Strength"));
//				playerCharacter.mana = Integer.parseInt(child.elementText("mana"));
//				playerCharacter.defence = Integer.parseInt(child.elementText("defence"));
//				playerCharacter.resistance = Integer.parseInt(child.elementText("resistance"));
//				playerCharacter.gold = Integer.parseInt(child.elementText("init_gold"));
//				playerCharacter.level = 1;
//				playerCharacter.experience = 0;
//				playerCharacter.lifeRemain = Integer.parseInt(dataManager.BaseConfigurationMap.get("CONSTITUTION_PARA"))
//						* playerCharacter.constitution;
//
//				// 初始化装备
//				for (Element equipment : child.element("init_equipment").elements()) {
//					playerCharacter.equipmentList
//							.add((Equipment) (new EquipmentLoader().loadByName(dataManager, child.getName())));
//				}
//
//				// 初始化技能
//				for (Element skill : child.element("init_skill").elements()) {
//					playerCharacter.skillList.add((Skill) (new SkillLoader().loadByName(dataManager, child.getName())));
//				}
//				dataManager.availableCharacter.add(playerCharacter);
//			} else if (child.elementText("type").equals("enemy")) {
//
//			} else if (child.elementText("type").equals("npc")) {
//
//			}
//		}
		return true;
	}

	@Override
	public Object loadByName(DataManager dataManager, String nameAttribute) throws DocumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
