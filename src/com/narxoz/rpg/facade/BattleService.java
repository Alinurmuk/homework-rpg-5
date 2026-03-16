package com.narxoz.rpg.facade;
import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class BattleService {
    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult res = new AdventureResult();
        int r = 0;
        while (hero.isAlive() && boss.isAlive() && r < 5) {
            r++;
            int dmg = action.getDamage();
            boss.takeDamage(dmg);
            res.addLine("Round " + r + ": " + hero.getName() + " deals " + dmg + " damage.");
            if (action.getEffectSummary().contains("Lifesteal")) {
                hero.heal(5);
                res.addLine("  + Lifesteal: +5 HP");
            }
            if (boss.isAlive()) {
                hero.takeDamage(boss.getAttackPower());
                res.addLine("  - Boss hits: " + boss.getAttackPower());
            }
        }
        res.setWinner(hero.isAlive() ? hero.getName() : boss.getName());
        res.setRounds(r);
        return res;
    }
}