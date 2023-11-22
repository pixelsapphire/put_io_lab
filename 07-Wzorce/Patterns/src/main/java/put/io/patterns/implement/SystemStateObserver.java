package put.io.patterns.implement;

import org.jetbrains.annotations.NotNull;

public interface SystemStateObserver {

    void update(@NotNull SystemMonitor monitor);
}
