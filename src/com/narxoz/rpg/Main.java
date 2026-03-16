package com.narxoz.rpg;
import com.narxoz.rpg.decorator.*;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.*;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        HeroProfile hero = new HeroProfile("Warrior", 100);
        BossEnemy boss = new BossEnemy("Dragon", 150, 15);

        AttackAction action = new LifestealDecorator(
            new CriticalFocusDecorator(
                new FireRuneDecorator(
                    new BasicAttack("Slash", 20)
                )
            )
        );

        DungeonFacade facade = new DungeonFacade();
        AdventureResult result = facade.runAdventure(hero, boss, action);

        System.out.println("=== ADVENTURE LOG ===");
        for (String line : result.getLog()) {
            System.out.println(line);
        }
        System.out.println("\n--- SUMMARY ---");
        System.out.println("WINNER: " + result.getWinner());
        System.out.println("REWARD: " + result.getReward());
    }
}