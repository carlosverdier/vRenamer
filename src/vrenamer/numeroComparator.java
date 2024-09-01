package vrenamer;

import java.util.Comparator;

class numeroComparator implements Comparator<comparaNumero> {

  @Override
  public int compare(comparaNumero o1, comparaNumero o2) {
            if ( o1.getNumero() < o2.getNumero()) {
                return -1;
            }
 
            if ( o1.getNumero() > o2.getNumero()) {
                return 1;
            }
            return 0;  
  }
}

