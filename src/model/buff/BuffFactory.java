package model.buff;

import java.util.HashMap;

public class BuffFactory {
	public static final String ROOT = "model.buff.";

	// 反射机制生成符合BuffName的Buff实例
	public static Buff createBuff(String BuffName, HashMap<String, String> parameterList) {
		try {
			Buff buff = (Buff) Class.forName(ROOT + BuffName).newInstance();
			buff.hashMap = parameterList;
			return buff;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
