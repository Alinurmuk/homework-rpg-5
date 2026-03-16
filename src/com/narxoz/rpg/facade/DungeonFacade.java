package com.narxoz.rpg.facade;
import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class DungeonFacade {
    private final PreparationService prep = new PreparationService();
    private final BattleService battle = new BattleService();
    private final RewardService reward = new RewardService();

    public AdventureResult runAdventure(HeroProfile h, BossEnemy b, AttackAction a) {
        AdventureResult res = battle.battle(h, b, a);
        res.addLine(0, prep.prepare(h, b, a));
        res.setReward(reward.determineReward(res));
        return res;
    }
}