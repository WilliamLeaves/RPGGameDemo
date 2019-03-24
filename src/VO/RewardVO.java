package VO;

import java.util.ArrayList;

public class RewardVO {
	public int expIncrease;
	public int goldIncrease;
	public ArrayList<EquipmentVO> eqiupmentDrop;

	public RewardVO() {

	}

	public RewardVO(int expIncrease, int goldIncrease, ArrayList<EquipmentVO> eqiupmentDrop) {
		this.expIncrease = expIncrease;
		this.goldIncrease = goldIncrease;
		this.eqiupmentDrop = eqiupmentDrop;
	}
}
