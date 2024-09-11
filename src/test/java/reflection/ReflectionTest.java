package reflection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.List;

public class ReflectionTest {

    /**
     * The fully qualified name of a class includes the package name.
     */
    @Test
    void getName() {
        // given
        Object someObject = this;
        // when
        String name = ReflectionLogic.getFullyQualifiedName(someObject);
        // then
        Assertions.assertThat(name).isEqualTo("reflection.ReflectionTest");
    }


    /**
     * The simple name of a class is the name of the class without the package name.
     */
    @Test
    void getSimpleName() {
        // given
        Object someObject = this;
        // when
        String name = ReflectionLogic.getSimpleClassName(someObject);
        // then
        Assertions.assertThat(name).isEqualTo("ReflectionTest");
    }


    @Test
    void getPackageName() {
        // given
        Object someObject = this;
        // when
        String name = ReflectionLogic.getPackageName(someObject);
        // then
        Assertions.assertThat(name).isEqualTo("reflection");
    }


    /**
     * The declared methods are the methods that are declared in the class itself.
     */
    @Test
    void getDeclaredMethods() {
        // given
        Orca willy = new Orca();
        // when
        List<String> methods = ReflectionLogic.getDeclaredMethods(willy);
        // then
        Assertions.assertThat(methods).containsExactlyInAnyOrder("getSpecies", "divingTimeInMinutes");
    }


    /**
     * The {@link Class#getMethods()} method returns the methods that are declared in the class itself and those that are
     * inherited from its superclasses.
     */
    @Test
    void getMethods() {
        // given
        Orca willy = new Orca();
        // when
        List<String> methods = ReflectionLogic.getMethods(willy);
        // then
        Assertions.assertThat(methods).contains("feedsOn", "toString", "getSpecies", "divingTimeInMinutes");
    }


    @Test
    void getConstructors() {
        // given
        Orca willy = new Orca();
        // when
        Constructor<?>[] constructors = ReflectionLogic.getConstructors(willy);
        // then
        Assertions.assertThat(constructors).hasSize(2);
    }


    /**
     * Tests that we can create an instance of an arbitrary class using reflection by invoking the default constructor.
     */
    @Test
    void createInstance() throws Exception {
        // given
        Class<Orca> orcaClass = Orca.class;
        // when
        Orca willy = ReflectionLogic.createInstance(orcaClass);
        // then
        Assertions.assertThat(willy).isNotNull();
    }


    /**
     * Tests that we can create an Orca instance using reflection by invoking a constructor that takes parameters.
     */
    @Test
    void createParameterizedInstance() throws Exception {
        // when
        Orca willy = ReflectionLogic.createNamedOrcaInstance("Willy");
        // then
        Assertions.assertThat(willy).isNotNull();
    }

}
