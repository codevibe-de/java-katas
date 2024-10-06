package classes;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("InfiniteLoopStatement")
public class Fridge {

    //
    // fields
    //

    private final List<SensorListener> sensorListeners = new ArrayList<>();

    private final ListenerManagement<SensorListener> listenerManagement = new ListenerManagementAdapter(this);

    private final Thermostat thermostat = new Thermostat();


    //
    // methods
    //

    public void loop() {
        int prevTemperature = 0;
        while (true) {
            System.out.print(".");
            int newTemperature = thermostat.measureTemperature();
            if (newTemperature != prevTemperature) {
                prevTemperature = newTemperature;
                for (SensorListener listener : sensorListeners) {
                    listener.temperatureChanged(newTemperature);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public List<SensorListener> getSensorListeners() {
        return sensorListeners;
    }

    public void addSensorListener(SensorListener listener) {
        listenerManagement.addListener(listener);
    }

    public void removeSensorListener(SensorListener listener) {
        listenerManagement.removeListener(listener);
    }

}
