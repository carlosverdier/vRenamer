package vrenamer;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class MyCellTablaMp3 extends DefaultTableCellRenderer {
    ClassLoader cldr = this.getClass().getClassLoader();

    java.net.URL warningImg = cldr.getResource("img/warning.png");
    java.net.URL warningImgBW = cldr.getResource("img/warningBW.png");

    ImageIcon warningOk = new ImageIcon(warningImg);
    ImageIcon warningBWOk = new ImageIcon(warningImgBW);

    private JTextField txtMp3;
    private idiomas Idioma;

    public MyCellTablaMp3(JTextField txtMp3, idiomas Idioma) {
	this.txtMp3 = txtMp3;
	this.Idioma = Idioma;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(
                            JTable table, Object color,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
	Component cell = super.getTableCellRendererComponent(table, color, isSelected, hasFocus, row, column);
	if (row % 2 == 0) {
	    if (table.isEnabled()) {
		setBackground(Color.white);
		setForeground(Color.black);

	    } else {
		setBackground(new Color (240, 240, 240, 240));
		setForeground(Color.lightGray);
	    }
	} else {
	    if (table.isEnabled()) {
		setBackground(new Color(240,240,240));
		setForeground(Color.black);
	    } else {
		setBackground(new Color (240, 240, 240, 240));
		setForeground(Color.lightGray);
	    }
	}
	String valorTabla = "" + table.getModel().getValueAt(row,1);
	if ( (txtMp3.getName().equals(Idioma.getTagTrack()) || txtMp3.getName().equals(Idioma.getTagYear()) ) && ( ! valorTabla.matches("^[0-9]+$") && ! valorTabla.equals("")) ) {
	    if (table.isEnabled()) {
		setIcon(warningOk);
	    } else {
		setIcon(warningBWOk);
	    }
	} else {
	    setIcon(null);
	}
        return this;
    }
}