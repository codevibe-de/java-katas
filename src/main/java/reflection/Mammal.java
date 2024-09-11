package reflection;

public interface Mammal {

    String getSpecies();

    /**
     * By default, our Mammal does not feed on other mammals.
     */
    default boolean feedsOn(Mammal otherMammal) {
        return false;
    }

}
