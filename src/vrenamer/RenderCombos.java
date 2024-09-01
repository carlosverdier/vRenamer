package vrenamer;

import java.awt.*;
import javax.swing.*;

class RenderCombos extends JLabel implements ListCellRenderer {

  public RenderCombos(){
    setOpaque(true);
    setBorder(BorderFactory.createEmptyBorder(0,2,0,2));
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
   String s = value.toString();
   setText(s);
   JList.DropLocation dropLocation = list.getDropLocation();
   if (dropLocation != null && !dropLocation.isInsert() && dropLocation.getIndex() == index) {
     Background = Color.BLUE;
     Foreground = Color.WHITE;
   }
   else if (isSelected) {
     Background = Color.LIGHT_GRAY;
     Foreground = Color.BLACK;
   }
   else {
     Background = Color.WHITE;
     Foreground = Color.BLACK;
   }
   setBackground(Background);
   setForeground(Foreground);
   setEnabled(list.isEnabled());
   setFont(list.getFont());
   return this;
  }
} 