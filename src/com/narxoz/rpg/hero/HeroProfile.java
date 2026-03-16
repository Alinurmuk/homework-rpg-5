package com.narxoz.rpg.hero;

public class HeroProfile {
    private final String name;
    private int health;

    public HeroProfile(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public void takeDamage(int amt) { this.health = Math.max(0, this.health - amt); }
    public void heal(int amt) { this.health += amt; }
    public boolean isAlive() { return health > 0; }
}