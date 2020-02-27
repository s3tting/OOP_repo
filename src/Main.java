import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager =
                new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String commandName = input[0];

        while (!commandName.equals("Over")) {
            String commandOutput = "";

            switch (commandName) {
                case "Hire":
                    commandOutput = hirePilot(machinesManager, input);
                    break;
                case "Report":
                    commandOutput = getPilotReport(machinesManager , input);
                    break;
                case "ManufactureTank":
                    commandOutput = manufactureTank(machinesManager, input);
                    break;
                case "ManufactureFighter":
                    commandOutput = manufactureFighter(machinesManager, input);
                    break;
                case "Engage":
                    commandOutput = engage(machinesManager, input);
                    break;
                case "Attack":
                    commandOutput = attack(machinesManager, input);
                    break;
                case "AggressiveMode":
                    commandOutput = toggleAggressiveMode(machinesManager, input);
                    break;
                case "DefenseMode":
                    commandOutput = toggleDefenseMode(machinesManager, input);
                    break;

            }

            System.out.println(commandOutput);
            input = scanner.nextLine().split(" ");
            commandName = input[0];
        }

    }

    private static String toggleDefenseMode(MachinesManager machinesManager, String[] input) {
        return machinesManager.toggleTankDefenseMode(input[1]);
    }

    private static String toggleAggressiveMode(MachinesManager machinesManager, String[] input) {
        return machinesManager.toggleFighterAggressiveMode(input[1]);
    }

    private static String attack(MachinesManager machinesManager, String[] input) {
        return machinesManager.attackMachines(input[1],input[2]);
    }

    private static String engage(MachinesManager machinesManager, String[] input) {
        return machinesManager.engageMachine(input[1],input[2]);
    }

    private static String manufactureFighter(MachinesManager machinesManager, String[] input) {
        return machinesManager.manufactureFighter(input[1],Double.parseDouble(input[2]),Double.parseDouble(input[3]));
    }

    private static String manufactureTank(MachinesManager machinesManager, String[] input) {
       return machinesManager.manufactureTank(input[1],Double.parseDouble(input[2]),Double.parseDouble(input[3]));
    }

    private static String getPilotReport(MachinesManager machinesManager, String[] input) {
       return machinesManager.pilotReport(input[1]);
    }

    private static String hirePilot(MachinesManager machinesManager, String[] input) {
        return machinesManager.hirePilot(input[1]);
    }
}
