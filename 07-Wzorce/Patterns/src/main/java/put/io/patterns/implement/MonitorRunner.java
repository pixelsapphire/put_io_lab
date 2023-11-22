package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String[] args) {

        final var monitor = new SystemMonitor();

        monitor.addObserver(new SystemInfoObserver());
        monitor.addObserver(new SystemGarbageCollectorObserver());
        monitor.addObserver(new SystemCoolerObserver());
        monitor.addObserver(new USBDeviceObserver());

        while (true) {
            monitor.probe();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
