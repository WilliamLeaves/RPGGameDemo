package main;

import java.util.ArrayList;
import java.util.HashMap;

import VO.EnemyVO;
import VO.PlayerVO;
import VO.SkillVO;
import controller.EnemyController;
import controller.GameClientCtroller;
import controller.PlayerController;
import controller.StageController;
import core.EnemyControllerImpl;
import core.GameClient;
import core.PlayerControllerImpl;
import core.StageControllerImpl;

public class GameApplication {
	GameClientCtroller gameClient = new GameClient();
	EnemyController enemyController = new EnemyControllerImpl();
	PlayerController playerController = new PlayerControllerImpl();
	StageController stageController = new StageControllerImpl();

	public static void main(String args[]) {
		GameApplication ga = new GameApplication();
		ga.gameTest();
	}

	public void gameTest() {
		this.gameClient.gameStart();
		ArrayList<PlayerVO> plyaerList = this.gameClient.getAvailablePlayer();
		this.gameClient.choosePlayer("սʿ");
		PlayerVO playerVO = this.gameClient.getPlayer();
		this.playerController.unwearEquipment("����ĵ�");
		playerVO = this.gameClient.getPlayer();
		// this.playerController.waerEqiupment("����ĵ�");
		// System.out.println();
		this.stageController.nextStage();
		ArrayList<EnemyVO> enemyList = this.stageController.getEnemies();
		// System.out.println("pause at load");
		boolean enemyDead, playerDead;

		while (true) {
			this.playerController.chooseSkill("���", "ѵ��ľ׮1");
			enemyDead = this.enemyController.isDead("ѵ��ľ׮1");
			if (enemyDead) {
				if (this.stageController.isStageClear()) {
					break;
				}
			} else {
				this.enemyController.getEnemy("ѵ��ľ׮1");
			}

			this.playerController.chooseSkill("�ػ�", "ѵ��ľ׮1");
			enemyDead = this.enemyController.isDead("ѵ��ľ׮1");
			if (enemyDead) {
				if (this.stageController.isStageClear()) {

					break;
				}
			} else {
				this.enemyController.getEnemy("ѵ��ľ׮1");
			}

			this.enemyController.getEnemyChose("ѵ��ľ׮1");
			playerDead = this.playerController.isDead();
			if (playerDead) {
				this.gameClient.gameOver();
				break;
			} else {
				this.playerController.refreshPlayer();
			}

			this.stageController.nextRound();
		}

		this.stageController.getRewards();
		this.stageController.nextStage();

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Strength", 1);
		map.put("Constitution", 3);
		map.put("Mana", 0);
		map.put("Defence", 1);
		map.put("Resistence", 0);
		this.playerController.increaseStatus(map);

		this.playerController.learnSkill("�ػ�");
		ArrayList<SkillVO> sl = this.playerController.getSkillList();

		this.stageController.nextStage();

		while (true) {
			this.playerController.chooseSkill("���", "ѵ��ľ׮2");
			enemyDead = this.enemyController.isDead("ѵ��ľ׮2");
			if (enemyDead) {
				if (this.stageController.isStageClear()) {
					break;
				}
			} else {
				this.enemyController.getEnemy("ѵ��ľ׮2");
			}

			this.playerController.chooseSkill("�ػ�", "ѵ��ľ׮2");
			enemyDead = this.enemyController.isDead("ѵ��ľ׮2");
			if (enemyDead) {
				if (this.stageController.isStageClear()) {

					break;
				}
			} else {
				this.enemyController.getEnemy("ѵ��ľ׮2");
			}

			this.enemyController.getEnemyChose("ѵ��ľ׮2");
			playerDead = this.playerController.isDead();
			if (playerDead) {
				this.gameClient.gameOver();
				break;
			} else {
				this.playerController.refreshPlayer();
			}

			this.stageController.nextRound();
		}

		this.stageController.getRewards();
		this.stageController.nextStage();

	}
}
