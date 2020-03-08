package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final int INITIAL_HEALTH = 100;
    private static final double ATTACK_POINTS_STEP = 40.0;
    private static final double DEFENSE_POINTS_STEP = 30.0;

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
        if(this.defenceMode){
            this.attackPointsModifier -= ATTACK_POINTS_STEP;
            this.defensePointsModifier += DEFENSE_POINTS_STEP;
        }else{
            this.attackPointsModifier += ATTACK_POINTS_STEP;
            this.defensePointsModifier -= DEFENSE_POINTS_STEP;
        }
    }

    @Override
    public double getDefensePoints() {
        return 0;
    }

    @Override
    protected String getSimpleName() {
        return "Tank";
    }

    @Override
    public String toString() {
        return String.format("%s%n *Defense Mode(%s)",
                super.toString() , this.defenceMode ? "ON" : "OFF");
    }
}
