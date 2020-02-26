package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private static final String NAME_MISSING_ERROR = "Machine name cannot be null or empty.";
    private static final String PILOT_MISSING_ERROR = "Pilot cannot be null.";

    private String name; //validation
    private Pilot pilot;
    private double attackPoints;
    private double defencePoints;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defencePoints, double healthPoints) {
        this.setName(name);
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
        this.targets = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(NAME_MISSING_ERROR);
        }
        this.name = name;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot == null){
            throw new NullPointerException(PILOT_MISSING_ERROR);
        }
        this.pilot = pilot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Pilot getPilot() {
        return pilot;
    }

    @Override
    public double getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public double getDefencePoints() {
        return defencePoints;
    }

    public void setDefencePoints(double defencePoints) {
        this.defencePoints = defencePoints;
    }

    @Override
    public double getHealthPoints() {
        return healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public List<String> getTargets() {
        return Collections.unmodifiableList(targets);
    }

}
