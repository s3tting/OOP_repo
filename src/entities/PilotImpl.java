package entities;

import common.Validation;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PilotImpl implements Pilot {
    private static final String NAME_MISSING_ERROR = "Pilot name cannot be null or empty string.";
    private static final String MACHINE_MISSING_ERROR = "Null machine cannot be added to the pilot";

    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    public void setName(String name) {
        Validation.requireNonEmptyString(name,NAME_MISSING_ERROR);

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        Validation.requireNonNull(machine, MACHINE_MISSING_ERROR);
        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return Collections.unmodifiableList(this.machines);
    }

    @Override
    public String report() {
        return null;
    }
}
