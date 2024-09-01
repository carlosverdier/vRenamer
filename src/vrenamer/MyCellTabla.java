package vrenamer;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.File;

public class MyCellTabla extends DefaultTableCellRenderer {
    ClassLoader cldr = this.getClass().getClassLoader();

    java.net.URL warningImg = cldr.getResource("img/warning.png");

    ImageIcon warningOk = new ImageIcon(warningImg);

    private File[] archivos;
    private Boolean actuales;

    public MyCellTabla(File[] archivos, Boolean actuales) {
	this.archivos = archivos;
	this.actuales = actuales;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(
                            JTable table, Object color,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
	Component cell = super.getTableCellRendererComponent(table, color, isSelected, hasFocus, row, column);
	setForeground(Color.black);
	if (row % 2 == 0) {
	    setBackground(Color.white);
	    setForeground(Color.black);
	} 
	else {
	    setBackground(new Color(245,245,245));
	    setForeground(Color.black);
	}
        if (actuales) {
	    if ( ! archivos[row + 1].exists() ) {
		setIcon(warningOk);
	    } else {
		setIcon(null);
	    }
	}
        setToolTipText(archivos[row + 1].getParent());
        return this;
    }
}