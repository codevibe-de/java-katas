package designpatterns.singleton;

public class ServiceA implements Runnable {

    public ServiceA(ServiceRegistry serviceRegistry, String serviceName) {
        serviceRegistry.registerService(serviceName, this);
    }

    @Override
    public void run() {
        System.out.println("Service A started");
    }

}
