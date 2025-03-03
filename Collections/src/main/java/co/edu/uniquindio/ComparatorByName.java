package co.edu.uniquindio;

import java.util.Comparator;

public class ComparatorByName implements Comparator<ComparablePerson> {

    @Override
    public int compare(ComparablePerson p1, ComparablePerson p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }
}
