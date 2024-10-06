package classes;

import java.util.random.RandomGenerator;

class Thermostat {

    public int measureTemperature() {
        return RandomGenerator.getDefault().nextInt(4, 7);
    }

}
