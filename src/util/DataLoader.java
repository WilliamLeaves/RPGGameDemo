package util;

import org.dom4j.DocumentException;

import core.DataManager;

public abstract class DataLoader {
	public DataManager instance = DataManager.getInstance();

	public abstract boolean load() throws DocumentException;

	public abstract Object loadByName(String nameAttribute) throws DocumentException;
}
