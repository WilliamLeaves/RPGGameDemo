package util;

import org.dom4j.DocumentException;

import core.DataManager;

public class EquipmentLoader extends DataLoader {
	private final String filePath = "./data/equipmentTag.xml";

	@Override
	public boolean load(DataManager dataManager) throws DocumentException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object loadByName(DataManager dataManager, String nameAttribute) throws DocumentException {
		// TODO Auto-generated method stub

		return null;
	}

}
