package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import model.GameStage;

public class StageLoader extends DataLoader {

	private final String filePath = "./data/stage.xml";

	@Override
	public boolean load() throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filePath));
		Element root = document.getRootElement();
		List<Element> childElements = root.elements();
		for (Element child : childElements) {
			GameStage stage = new GameStage();
			stage.stageNum = Integer.parseInt(child.attributeValue("stage_num"));
			stage.enemyList = new ArrayList<String>();
			for (Element el : child.element("enemies").elements()) {
				stage.enemyList.add(el.attributeValue("name"));
			}
			instance.stageList.add(stage);
		}
		return true;
	}

	@Override
	public Object loadByName(String nameAttribute) throws DocumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
