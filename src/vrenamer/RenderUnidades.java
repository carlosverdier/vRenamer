package vrenamer;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

class RenderUnidades extends JLabel implements ListCellRenderer {
  final static String separador = System.getProperty("file.separator");

  ClassLoader cldr = this.getClass().getClassLoader();

  java.net.URL harddiskImg = cldr.getResource("img/harddisk.png");
  java.net.URL cdromImg = cldr.getResource("img/cdrom.png");
  java.net.URL homeImg = cldr.getResource("img/home.png");
  java.net.URL folderImg = cldr.getResource("img/folder_small.png");

  ImageIcon harddiskOk = new ImageIcon(harddiskImg);
  ImageIcon cdromOk = new ImageIcon(cdromImg);
  ImageIcon homeOk = new ImageIcon(homeImg);
  ImageIcon folderOk = new ImageIcon(folderImg);

  private String Sistema;
  private int totalUnidades;

  public RenderUnidades(String Sistema, int totalUnidades){
    setOpaque(true);
    this.Sistema = Sistema;
    this.totalUnidades = totalUnidades;
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
   if (new File(s).exists() || Sistema.equals("windows")) {
      setText(s);
      if (s.startsWith(separador + "media") || s.startsWith(separador + "Volumes")) {
	  setIcon(harddiskOk);
      }
      else if (index == totalUnidades -2) setIcon(homeOk);
      else setIcon(folderOk);
   }
   else System.out.println("Device is not present anymore");
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