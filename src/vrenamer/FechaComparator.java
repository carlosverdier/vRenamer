package vrenamer;
import java.util.Comparator;

class FechaComparator implements Comparator<comparaArchivo> {
    @Override
    public int compare(comparaArchivo o1, comparaArchivo o2) {
        if ( o1.getFecha() < o2.getFecha()) {
            return -1;
        }
        if ( o1.getFecha() > o2.getFecha()) {
            return 1;
        }
        return 0;  
    }
}

