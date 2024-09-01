package vrenamer;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class MyCellTablaMp3NoEdit extends DefaultTableCellRenderer {

    public MyCellTablaMp3NoEdit() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(
                            JTable table, Object color,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
	Component cell = super.getTableCellRendererComponent(table, color, isSelected, hasFocus, row, column);
	    if (table.isEnabled()) {
		setBackground(new Color (230, 230, 230, 230));
		setForeground(Color.black);
		if (isSelected) {
		    setBackground(Color.PINK);
		}
	    } else {
		setBackground(new Color (230, 230, 230, 230));
		setForeground(Color.lightGray);
	    }
        return this;
    }
}