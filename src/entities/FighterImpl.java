package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter  {
    private static final int INITIAL_HEALTH = 200;
    private static final double ATTACK_POINTS_STEP = 50.0;
    private static final double DEFENSE_POINTS_STEP = 25.0;

    private boolean aggressiveMode;
    private double attackPointsModifier;
    private double defensePointsModifier;


    public FighterImpl(String name, double attackPoints, double defencePoints) {
        super(name, attackPoints, defencePoints, INITIAL_HEALTH);

        this.aggressiveMode = true;
        this.attackPointsModifier = ATTACK_POINTS_STEP;
        this.defensePointsModifier = DEFENSE_POINTS_STEP;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        this.aggressiveMode = !this.aggressiveMode;
        if(this.aggressiveMode){
            this.attackPointsModifier += ATTACK_POINTS_STEP;
            this.defensePointsModifier -= DEFENSE_POINTS_STEP;
        }else{
            this.attackPointsModifier -= ATTACK_POINTS_STEP;
            this.defensePointsModifier += DEFENSE_POINTS_STEP;
        }
    }

    @Override
    public double getDefensePoints() {
        return 0;
    }

}
