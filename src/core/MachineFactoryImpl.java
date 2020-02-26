package core;

import core.interfaces.MachineFactory;
import entities.interfaces.Fighter;
import entities.interfaces.Tank;

public class MachineFactoryImpl implements MachineFactory {
    @Override
    public Tank createTank(String name, double attackPoints, double defensePoints) {
        return null;
    }

    @Override
    public Fighter createFighter(String name, double attackPoints, double defensePoints) {
        return null;
    }
}
