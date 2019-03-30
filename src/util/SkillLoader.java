package util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import model.Skill;

//skill在xml文件中，相同名称的技能会随着等级的变化生成多个同名技能
public class SkillLoader extends DataLoader {

	private final String filePath = "./data/skill.xml";

	@Override
	public boolean load() throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filePath));
		Element root = document.getRootElement();
		List<Element> childElements = root.elements();
		for (Element child : childElements) {
			int num = Integer.parseInt(child.attributeValue("max_level"))
					- Integer.parseInt(child.attributeValue("min_level")) + 1;
			for (int i = 0; i < num; i++) {
				Skill skill = new Skill();
				skill.skillName = child.attributeValue("name");
				skill.actionPointCost = Integer.parseInt(child.elementText("action_point_cost").split(",")[i]);
				skill.desc = child.attributeValue("desc");
				skill.level = 1 + i;
				skill.userName = child.attributeValue("user_name");
				skill.targetType = child.attributeValue("target_type");

				skill.skillParameter = new HashMap<String, String>();
				for (Element el : child.element("skill_para").elements()) {
					skill.skillParameter.put(el.attributeValue("name"), el.getText());
				}
				skill.buffList = new ArrayList<String>();
				skill.buffParameterMap = new ArrayList<HashMap<String, String>>();
				for (Element el : child.element("buffs").elements()) {
					HashMap<String, String> map = new HashMap<String, String>();
					skill.buffList.add(el.attributeValue("name"));
					for (Element para : el.elements()) {
						map.put(para.attributeValue("name"), para.getText().split(",")[i]);
					}
					skill.buffParameterMap.add(map);
				}
				instance.skillList.add(skill);
				//System.out.println(skill.skillName + skill.level + " loaded");
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
