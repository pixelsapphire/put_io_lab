package put.io.patterns.implement;

import org.jetbrains.annotations.NotNull;

public class SystemCoolerObserver implements SystemStateObserver {

    @Override
    public void update(@NotNull SystemMonitor monitor) {
        if (monitor.getLastSystemState().getCpuTemp() > 60.00) System.out.println("> Increasing cooling of the CPU...");
    }
}
