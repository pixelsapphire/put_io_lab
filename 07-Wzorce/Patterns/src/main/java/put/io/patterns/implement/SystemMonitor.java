package put.io.patterns.implement;

import org.jetbrains.annotations.NotNull;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.util.ArrayList;
import java.util.List;

public class SystemMonitor {

    private final SystemInfo si;
    private final HardwareAbstractionLayer hal;
    private final OperatingSystem os;
    private SystemState lastSystemState = null;
    private List<SystemStateObserver> observers;

    public SystemMonitor() {
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();
        observers = new ArrayList<>();
    }

    public void probe() {

        // Get current state of the system resources
        double cpuLoad = hal.getProcessor().getSystemLoadAverage(1)[0];
        double cpuTemp = hal.getSensors().getCpuTemperature();
        double memory = hal.getMemory().getAvailable() / 1000000.0;
        int usbDevices = hal.getUsbDevices(false).size();

        lastSystemState = new SystemState(cpuLoad, cpuTemp, memory, usbDevices);
        notifyObservers();

//        // Print information to the console
//        System.out.println("============================================");
//        System.out.printf("CPU Load: %2.2f%%\n", lastSystemState.getCpu());
//        System.out.printf("CPU temperature: %.2f C\n", lastSystemState.getCpuTemp());
//        System.out.printf("Available memory: %.2f MB\n", lastSystemState.getAvailableMemory());
//        System.out.printf("USB devices: %d\n", lastSystemState.getUsbDevices());
//
//        // Run garbage collector when out of memory
//        if (lastSystemState.getAvailableMemory() < 200.00) System.out.println("> Running garbage collector...");
//
//        // Increase CPU cooling if the temperature is too high
//        if (lastSystemState.getCpuTemp() > 60.00) System.out.println("> Increasing cooling of the CPU...");

    }

    public void notifyObservers() {
        for (final SystemStateObserver observer : observers) observer.update(this);
    }

    public SystemState getLastSystemState() {
        return lastSystemState;
    }

    public void addObserver(@NotNull SystemStateObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(@NotNull SystemStateObserver observer) {
        observers.remove(observer);
    }
}
