package controller;

import java.util.ArrayList;
import java.util.HashMap;

import VO.EquipmentVO;
import VO.PlayerVO;
import VO.SkillVO;

public interface PlayerController {
	//ʹ�ü��ܣ������ܹ�������һغϵļ���Ҳ�����У�
	public boolean chooseSkill(String skillName, String... targetname);

	//��ȡ��Ҷ���
	public PlayerVO refreshPlayer(String playerName);

	//�ж�����Ƿ�����
	public boolean isDead();

	//�ж���ǰ�غ��Ƿ����
	public boolean isRoundEnd();

	//��ȡ�Ѿ�ӵ�еļ����б�
	public ArrayList<SkillVO> getSkillList();

	//��ȡ�������ڸý�ɫ�ļ����б�
	public ArrayList<SkillVO> getAllAvailableList(String playerName);

	//ʹ��װ������origin�滻Ϊnewװ�������ԭλ��û��origin��Ϊ""
	public boolean changeEqiupment(String originEquipmentName, String newEquipmentName);

	//�鿴װ�����������������еĺ�δ������
	public ArrayList<EquipmentVO> getEquipmentList();

	//�ӵ㣬�������Ե��������д��map��
	public boolean increaseStatus(HashMap<String, Integer> increaseMap);

	//ѧ����
	public boolean learnSkill(String skillName);
}
