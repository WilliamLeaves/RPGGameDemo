package util;

import org.dom4j.DocumentException;

import core.DataManager;

public abstract class DataLoader {

	public abstract boolean load(DataManager dataManager) throws DocumentException;

	public abstract Object loadByName(DataManager dataManager, String nameAttribute) throws DocumentException;
}
