package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {

    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;


    public MachinesManagerImpl(PilotFactory pilotFactory,
                               MachineFactory machineFactory,
                               Map<String, Pilot> pilots,
                               Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;

    }


    @Override
    public String hirePilot(String name) {
        Pilot pilot = this.pilotFactory.createPilot(name);
        this.pilots.put(name, pilot);

        return String.format(OutputMessages.pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        boolean exists = this.machines.containsKey(name);

        this.machines.computeIfAbsent(name, ignored ->
                this.machineFactory.createTank(name, attackPoints, defensePoints));

        if (exists) {
            return String.format(OutputMessages.machineExists, name);
        } else {
            return String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
        }

    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        boolean exists = this.machines.containsKey(name);

        if (exists) {
            return String.format(OutputMessages.machineExists, name);
        }

        Fighter fighter = this.machineFactory.createFighter(name, attackPoints, defensePoints);
        this.machines.put(name, fighter);

        return String.format(OutputMessages.fighterManufactured,
                name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        Pilot pilot = this.pilots.get(selectedPilotName);
        Machine machine = this.machines.get(selectedMachineName);

        if (pilot == null) {
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }

        if (machine == null) {
            return String.format(OutputMessages.machineNotFound, selectedMachineName);
        }

        machine.setPilot(pilot);
        pilot.addMachine(machine);

        return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        Machine attacker = this.machines.get(attackingMachineName);
        Machine defender = this.machines.get(defendingMachineName);

        if (attacker == null) {
            return String.format(OutputMessages.machineNotFound, attackingMachineName);
        } else if (defender == null) {
            return String.format(OutputMessages.machineNotFound, defendingMachineName);
        }

        if (attacker.getAttackPoints() > defender.getDefensePoints()) {
            double healthPoints = defender.getHealthPoints();
            defender.setHealthPoints(healthPoints - attacker.getAttackPoints());
        }
        attacker.attack(defendingMachineName);

        return String.format(OutputMessages.attackSuccessful,
                defendingMachineName, attackingMachineName, defender.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        Pilot pilot = this.pilots.get(pilotName);
        return pilot.report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        Fighter fighter = (Fighter) this.machines.get(fighterName);

        if (fighter == null) {
            return String.format(OutputMessages.machineNotFound, fighterName);
        }
        fighter.toggleAggressiveMode();
        return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        Tank tank = (Tank) this.machines.get(tankName);

        if (tank == null) {
            return String.format(OutputMessages.machineNotFound, tankName);
        }
        tank.toggleDefenseMode();
        return String.format(OutputMessages.tankOperationSuccessful , tankName);
    }
}
