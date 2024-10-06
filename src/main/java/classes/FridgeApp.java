package classes;

public class FridgeApp {

    public static void main(String[] args) {
        Fridge fridge = new Fridge();
        fridge.addSensorListener(new SensorListener() {
            @Override
            public void temperatureChanged(int newTemperature) {
                System.out.println("Temperature changed: " + newTemperature);
            }
        });
        fridge.loop();
    }
}
