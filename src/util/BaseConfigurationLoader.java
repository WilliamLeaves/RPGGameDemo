package util;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BaseConfigurationLoader extends DataLoader {
	private final String filePath = "./data/baseConfiguration.xml";

	@Override
	public boolean load() throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filePath));
		Element root = document.getRootElement();
		List<Element> childElements = root.elements();
		for (Element child : childElements) {
			instance.baseConfigurationMap.put(child.attributeValue("name"), child.getText());
		}
		return true;
	}

	@Override
	public Object loadByName(String nameAttribute) throws DocumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
