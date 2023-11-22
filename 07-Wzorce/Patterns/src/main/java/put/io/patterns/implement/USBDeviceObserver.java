package put.io.patterns.implement;

import org.jetbrains.annotations.NotNull;

public class USBDeviceObserver implements SystemStateObserver {

    SystemState lastState;

    @Override
    public void update(@NotNull SystemMonitor monitor) {
        if (lastState != null && monitor.getLastSystemState().getUsbDevices() != lastState.getUsbDevices())
            System.out.println("> USB devices changed!");
        lastState = monitor.getLastSystemState();
    }
}
