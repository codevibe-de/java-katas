package designpatterns.singleton;

public class ServiceApp {

    public static void main(String[] args) {
        ServiceA serviceA = new ServiceA("a");
        ServiceB serviceB = new ServiceB("b");
        ServiceRegistry.INSTANCE.startService("a");
        ServiceRegistry.INSTANCE.startService("b");
    }

}
