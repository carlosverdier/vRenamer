package vrenamer;

import java.awt.*;
import javax.swing.*;

class SimpleCellRenderer extends JLabel implements ListCellRenderer {

  private String s;

  public SimpleCellRenderer() {
    setOpaque(true);
    setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
  }
  @Override
  public Component getListCellRendererComponent(
  JList list,
  Object value, // Valor a visualizar
  int index, // celda
  boolean isSelected, // la celda esta seleccionada?
  boolean cellHasFocus) // la celda tiene el foco?
  {
    Color Background;
    Color Foreground;
    s = value.toString();
    setText(s);

    if (isSelected) {
	Background = Color.PINK;
	Foreground = Color.BLACK;
    }
    else {
        if (index % 2 == 0) {
	  Background = new Color(245,245,245);
	  Foreground = Color.BLACK;
	}
	else {
	  Background = Color.WHITE;
	  Foreground = Color.BLACK;

	}             
    }
    setBackground(Background);
    setForeground(Foreground);

    setEnabled(list.isEnabled());
    setFont(list.getFont());
    return this;
  }

}