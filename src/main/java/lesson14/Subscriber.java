package lesson14;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Subscriber {

    private final String FIO;
    private final long telNumber;
    // Код ниже любезно предоставлен преподаваетелем
    private final Set<Subscriber> boundedSubscribers = new HashSet<>();

    public Subscriber(String FIO, Long telNumber) {
        this.FIO = FIO;
        this.telNumber = telNumber;
    }

    public long getTelNumber() {
        return telNumber;
    }

    // Код ниже любезно предоставлен преподаваетелем
    public Set<Subscriber> getBoundedSubscribers() {
        return boundedSubscribers;
    }

    // Код ниже любезно предоставлен преподаваетелем
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriber that = (Subscriber) o;

        if (telNumber != that.telNumber) return false;
        return Objects.equals(FIO, that.FIO);
    }

    // Код ниже любезно предоставлен преподаваетелем
    @Override
    public int hashCode() {
        int result = FIO != null ? FIO.hashCode() : 0;
        result = 31 * result + (int) (telNumber ^ (telNumber >>> 32));
        return result;
    }
}
