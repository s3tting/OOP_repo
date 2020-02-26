package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final int INITIAL_HEALTH = 100;

    private boolean defenceMode;
    private double attackPointsModifier;
    private double defensePointsModifier;

    public TankImpl(String name,
                    double attackPoints,
                    double defencePoints) {
        super(name, attackPoints, defencePoints, INITIAL_HEALTH);
        this.attackPointsModifier = 40.0;
        this.defensePointsModifier = 30.0;
        this.defenceMode = true;
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenceMode;
    }

    @Override
    public void toggleDefenseMode() {
        this.defenceMode = !this.defenceMode;
    }

    @Override
    public double getDefensePoints() {
        return 0;
    }

    @Override
    public void attack(String target) {

    }
}
