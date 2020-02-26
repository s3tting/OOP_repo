package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter  {
    private static final int INITIAL_HEALTH = 200;

    private boolean aggressiveMode;
    private double attackPointsModifier;
    private double defensePointsModifier;


    public FighterImpl(String name, double attackPoints, double defencePoints, double healthPoints) {
        super(name, attackPoints, defencePoints, INITIAL_HEALTH);

        this.aggressiveMode = true;
        this.attackPointsModifier = 50.0;
        this.defensePointsModifier = 25.0;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        this.aggressiveMode = !this.aggressiveMode;
    }

    @Override
    public double getDefensePoints() {
        return 0;
    }

    @Override
    public void attack(String target) {

    }
}
