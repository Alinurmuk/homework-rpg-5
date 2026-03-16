package com.narxoz.rpg.facade;
import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile h, BossEnemy b, AttackAction a) {
        return h.getName() + " vs " + b.getName() + " using " + a.getActionName();
    }
}