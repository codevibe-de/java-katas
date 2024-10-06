package designpatterns.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceRegistry {

    private final Map<String, Runnable> services;

    ServiceRegistry() {
        this.services = new ConcurrentHashMap<>();
    }


    public void registerService(String serviceName, Runnable service) {
        this.services.put(serviceName, service);
    }


    public void startService(String serviceName) {
        if (this.services.containsKey(serviceName)) {
            this.services.get(serviceName).run();
        }
    }
}
