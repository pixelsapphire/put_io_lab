package put.io.patterns.implement;

import org.jetbrains.annotations.NotNull;

public class SystemInfoObserver implements SystemStateObserver {

    @Override
    public void update(@NotNull SystemMonitor monitor) {
        System.out.println("============================================");
        System.out.printf("CPU Load: %2.2f%%\n", monitor.getLastSystemState().getCpu());
        System.out.printf("CPU temperature: %.2f°C\n", monitor.getLastSystemState().getCpuTemp());
        System.out.printf("Available memory: %.2f MB\n", monitor.getLastSystemState().getAvailableMemory());
        System.out.printf("USB devices: %d\n", monitor.getLastSystemState().getUsbDevices());
    }
}
