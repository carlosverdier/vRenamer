package vrenamer;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class MyCellRendererTablaCheck extends JCheckBox implements TableCellRenderer {

    final private Boolean modoLog;

    public MyCellRendererTablaCheck(Boolean modoLog) {
      this.modoLog = modoLog;
      setOpaque(true);
      setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
    }
    @Override
    public Component getTableCellRendererComponent(
                            JTable table, Object color,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
	if (hasFocus) {
	    setBackground(new Color(200,200,200));
	    setForeground(Color.BLACK);
	} else {
	    if (row % 2 == 0) {
		setBackground(Color.white);
		setForeground(Color.black);
	    } 
	    else {
		setBackground(new Color(245,245,245));
		setForeground(Color.black);
	    }
	}
	setEnabled(!modoLog);
	if (isEnabled()) {
	    setSelected((color != null && ((Boolean) color).booleanValue()));
	} else {
	    setSelected(true);
	}
        return this;
    }
}