package designpatterns.singleton;

public class ServiceB implements Runnable {

    public ServiceB(ServiceRegistry serviceRegistry, String serviceName) {
        serviceRegistry.registerService(serviceName, this);
    }

    @Override
    public void run() {
        System.out.println("Service B started");
    }

}
