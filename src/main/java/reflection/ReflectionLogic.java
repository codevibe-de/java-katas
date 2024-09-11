package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ReflectionLogic {

    public static String getFullyQualifiedName(Object someObject) {
        return someObject.getClass().getName();
    }


    public static String getSimpleClassName(Object someObject) {
        return someObject.getClass().getSimpleName();
    }


    public static String getPackageName(Object someObject) {
        return someObject.getClass().getPackage().getName();
        // also possible:
        // return someObject.getClass().getPackageName();
    }


    public static List<String> getDeclaredMethods(Object someObject) {
        return Arrays.stream(someObject.getClass().getDeclaredMethods())
                .map(Method::getName)
                .toList();
    }


    public static List<String> getMethods(Object someObject) {
        return Arrays.stream(someObject.getClass().getMethods())
                .map(Method::getName)
                .toList();
    }


    public static Constructor<?>[] getConstructors(Object someObject) {
        return someObject.getClass().getConstructors();
    }


    public static <T> T createInstance(Class<T> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return type.getDeclaredConstructor().newInstance();
    }


    public static Orca createNamedOrcaInstance(String willy) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return Orca.class.getDeclaredConstructor(String.class).newInstance(willy);
    }
}
