package vrenamer;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.util.*;
import javax.swing.table.*;

class MyCellRendererRenom extends DefaultTableCellRenderer {
  final static String separador = System.getProperty("file.separator");

  ClassLoader cldr = this.getClass().getClassLoader();

  java.net.URL genericImg = cldr.getResource("img/generic.png");
  java.net.URL folderImg = cldr.getResource("img/folder.png");
  java.net.URL okImg = cldr.getResource("img/aplicar.png");
  java.net.URL badImg = cldr.getResource("img/warning.png");
  java.net.URL arrow_upImg = cldr.getResource("img/arrow_up.png");

  ImageIcon genericOk = new ImageIcon(genericImg);
  ImageIcon folderOk = new ImageIcon(folderImg);
  ImageIcon okOk = new ImageIcon(okImg);
  ImageIcon badOk = new ImageIcon(badImg);
  ImageIcon arrow_upOk = new ImageIcon(arrow_upImg);

  private String ruta;
  private int[] indices;
  private java.util.List<Integer> indicesRepetidos = new ArrayList<>();
  private int borde;

  public MyCellRendererRenom(String ruta, int[] indices, java.util.List<Integer> indicesRepetidos, int borde){
    setOpaque(true);
    setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
    this.ruta = ruta;
    this.indices = indices;
    this.indicesRepetidos = indicesRepetidos;
    this.borde = borde;
  }
    public Component getTableCellRendererComponent(
                            JTable table, Object color,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
      Component cell = super.getTableCellRendererComponent(table, color, isSelected, hasFocus, row, column);

      Color Background;
      Color Foreground;
      String s = (String) color;
      File archiv = new File (ruta + separador + s);
      if (archiv.canRead()) {
	  if (archiv.isDirectory()) setIcon(folderOk);
	  else setIcon(genericOk);
      }
      else setIcon(genericOk);

      Background = Color.WHITE;
      Foreground = new Color(110,110,110);
      if (isSelected) {
	  Background = new Color(240,240,240);
      }
      if (s.equals("..") && row == 0) {
	  setIcon(arrow_upOk);
      } else {
	  for (int x=0;x<indices.length;x++) {
	      if (indices[x]==row && !s.equals("..")) {
		  Background = new Color(152,251,152);
		  Foreground = Color.BLACK;
		  setIcon(okOk);
	      }
	  }
	  if ( indicesRepetidos.contains(row) ) {
	      Background = Color.RED;
	      Foreground = Color.WHITE;
	      setIcon(badOk);
	  }
      }
      if (borde != 0 && borde == row)
	  setBorder(BorderFactory.createDashedBorder(Color.BLACK, 2.0f, 5.0f, 2.3f, false));
      setBackground(Background);
      setForeground(Foreground);
      return this;
  }
} 