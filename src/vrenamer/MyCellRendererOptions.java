package vrenamer;

import java.awt.*;
import javax.swing.*;

class MyCellRendererOptions extends JLabel implements ListCellRenderer {

  ClassLoader cldr = this.getClass().getClassLoader();

  java.net.URL logoImg = cldr.getResource("img/vrlogoPrueba.png");

  ImageIcon logoOk = new ImageIcon(logoImg);

  private String s;

  public MyCellRendererOptions(){
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

    setIcon(logoOk);
   if (isSelected) {
     Background = Color.PINK;
     Foreground = Color.BLACK;
   }
   else {
     if (index % 2 == 0) {
	Background = new Color(215,215,215);
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