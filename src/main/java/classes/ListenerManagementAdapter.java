package classes;

import java.util.List;

class ListenerManagementAdapter extends ListenerManagement<SensorListener> {

    private final Fridge fridge;

    public ListenerManagementAdapter(Fridge fridge) {
        this.fridge = fridge;
    }

    @Override
    protected List<? super SensorListener> listeners() {
        return fridge.getSensorListeners();
    }

}
