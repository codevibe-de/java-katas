package designpatterns.singleton;

public class ServiceA implements Runnable {

    public ServiceA(String serviceName) {
        ServiceRegistry.INSTANCE.registerService(serviceName, this);
    }

    @Override
    public void run() {
        System.out.println("Service A started");
    }

}
