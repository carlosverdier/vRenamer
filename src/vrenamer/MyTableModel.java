package vrenamer;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {

  public MyTableModel() {
    super(new String[]{"", ""}, 0);
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    Class clazz = String.class;
    switch (columnIndex) {
      case 0:
	clazz = Boolean.class;
	break;
      case 1:
	clazz = String.class;
	break;
    }
    return clazz;
  }
  @Override
  public boolean isCellEditable(int row, int column) {
    return column == 0;
  }
  @Override
  public void setValueAt(Object aValue, int row, int column) {
    if (aValue instanceof Boolean && column == 0) {
      Vector rowData = (Vector)getDataVector().get(row);
      rowData.set(0, (Boolean)aValue);
      fireTableCellUpdated(row, column);
    }

  }
}