package records;

import net.bytebuddy.utility.nullability.NeverNull;
import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecordsTest {

    @Test
    @Order(1)
    @DisplayName("1. The record class exists")
    void recordClassExists() throws ClassNotFoundException {
        Class<?> clazz = getRecordClass();
        assertThat(clazz).isRecord();
    }

    @NeverNull
    private static Class<?> getRecordClass() {
        try {
            Class<?> clazz = Class.forName("records.Product");
            return clazz;
        } catch (ClassNotFoundException e) {
            fail("Record class not found");
            return null;
        }
    }


    @Test
    @Order(2)
    @DisplayName("2. The record defines fields with correct name and type")
    void hasRecordComponents() {
        Class<?> clazz = getRecordClass();
        assertThat(clazz).hasRecordComponents("id", "name", "priceInCents");
        assertThat(getRecordComponent(clazz, "id").getType()).isEqualTo(long.class);
        assertThat(getRecordComponent(clazz, "name").getType()).isEqualTo(String.class);
        assertThat(getRecordComponent(clazz, "priceInCents").getType()).isEqualTo(int.class);
    }


    @Test
    @Order(3)
    @DisplayName("3. The record implements the Comparator interface")
    void implementsComparable() {
        Class<?> clazz = getRecordClass();
        assertThat(clazz).isAssignableTo(Comparable.class);
    }


    @Test
    @Order(4)
    @DisplayName("4. The record implements the compareTo() method by comparing the price first and then by name")
    void compareTo() {
        // uncomment:
//        Product p1 = new Product(100, "Light Sabre", 2599);
//        Product p2 = new Product(92, "TIE Advanced", 2599);
//        assertThat(p1).isLessThan(p2);
//        assertThat(p2).isGreaterThan(p1);
    }


    @Test
    @Order(5)
    @DisplayName("5. The record has an additional constructor that takes just an id")
    void hasIdOnlyConstructor() {
        Class<?> clazz = getRecordClass();
        assertThat(clazz.getDeclaredConstructors()).hasSize(2);
        getRecordConstructor(clazz, long.class);
    }


    @Test
    @Order(6)
    @DisplayName("6. The record constructor prevents creating a product with a price less than 0 cents")
    void constructorChecksPrice() {
        // uncomment
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> new Product(123, "Test", -1)
//        );
    }


    private RecordComponent getRecordComponent(Class<?> clazz, String name) {
        return Arrays.stream(clazz.getRecordComponents())
                .filter(rc -> rc.getName().equals(name))
                .findFirst()
                .orElseGet(() -> fail("Record component doesn't exist: " + name));
    }


    private Constructor<?> getRecordConstructor(Class<?> clazz, Class<?>... paramTypes) {
        return Arrays.stream(clazz.getDeclaredConstructors())
                .filter(rc -> Arrays.equals(rc.getParameterTypes(), paramTypes))
                .findFirst()
                .orElseGet(() -> fail("Record constructor for given types doesn't exist"));
    }
}
