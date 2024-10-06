package designpatterns.singleton;

public class ServiceB implements Runnable {

    public ServiceB(String serviceName) {
        ServiceRegistry.INSTANCE.registerService(serviceName, this);
    }

    @Override
    public void run() {
        System.out.println("Service B started");
    }

}
