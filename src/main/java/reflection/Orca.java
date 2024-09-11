package reflection;

import net.bytebuddy.utility.nullability.MaybeNull;

public class Orca extends Whale {

    @MaybeNull
    private final String name;

    public Orca() {
        this(null);
    }

    public Orca(String name) {
        this.name = name;
    }

    @Override
    public int divingTimeInMinutes() {
        return 15;
    }

    @Override
    public String getSpecies() {
        return "Orcinus orca";
    }

}
