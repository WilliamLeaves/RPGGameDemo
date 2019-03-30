package util;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import model.Equipment;

public class EquipmentLoader extends DataLoader {
	private final String filePath = "./data/equipment.xml";

	@Override
	public boolean load() throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filePath));
		Element root = document.getRootElement();
		List<Element> childElements = root.elements();
		for (Element child : childElements) {
			Equipment eq = new Equipment();
			eq.name = child.attributeValue("name");
			eq.userName = child.attributeValue("user_name");
			eq.position = child.attributeValue("position");
			eq.value = Integer.parseInt(child.attributeValue("value"));
			eq.purchasable = child.attributeValue("purchasable").equals("true") ? true : false;
			eq.droppable = child.attributeValue("droppable").equals("true") ? true : false;
			eq.increseList = new HashMap<String, String>();
			eq.increseList.put("Strength",
					child.element("base_status_increase").element("strength_increase").getText());
			eq.increseList.put("Mana", child.element("base_status_increase").element("mana_increase").getText());
			eq.increseList.put("Defence", child.element("base_status_increase").element("defence_increase").getText());
			eq.increseList.put("Resistence",
					child.element("base_status_increase").element("resistence_increase").getText());
			eq.increseList.put("Constitution",
					child.element("base_status_increase").element("constitution_increase").getText());

			eq.appearPro = Integer.parseInt(child.element("appear_pro").getText());
			eq.lowestAppearStageNum = Integer.parseInt(child.element("lowest_appear_stage_num").getText());
			eq.lowestLevel = Integer.parseInt(child.element("lowest_level").getText());
			instance.equipmentList.add(eq);
		}
		return true;
	}

	@Override
	public Object loadByName(String nameAttribute) throws DocumentException {
		// TODO Auto-generated method stub

		return null;
	}

}
