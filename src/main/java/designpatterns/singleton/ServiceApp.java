package designpatterns.singleton;

public class ServiceApp {

    public static void main(String[] args) {
        ServiceRegistry serviceRegistry = new ServiceRegistry();
        ServiceA serviceA = new ServiceA(serviceRegistry, "a");
        ServiceB serviceB = new ServiceB(serviceRegistry, "b");
        serviceRegistry.startService("a");
        serviceRegistry.startService("b");
    }

}
