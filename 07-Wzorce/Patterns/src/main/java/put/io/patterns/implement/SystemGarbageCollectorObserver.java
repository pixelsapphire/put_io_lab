package put.io.patterns.implement;

import org.jetbrains.annotations.NotNull;

public class SystemGarbageCollectorObserver implements SystemStateObserver {

    @Override
    public void update(@NotNull SystemMonitor monitor) {
        if (monitor.getLastSystemState().getAvailableMemory() < 200.00) System.out.println("> Running garbage collector...");
    }
}
