package com.narxoz.rpg.decorator;

public class LifestealDecorator extends ActionDecorator {
    public LifestealDecorator(AttackAction wrapped) { super(wrapped); }
    @Override public String getActionName() { return "Vampiric " + super.getActionName(); }
    @Override public String getEffectSummary() { return super.getEffectSummary() + " [Lifesteal]"; }
}