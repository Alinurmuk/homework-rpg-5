package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult res) {
        if (res.getRounds() <= 2) return "Legendary Chest";
        return "Small Pouch of Gold";
    }
}