package vrenamer;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.util.*;
import javax.swing.table.*;

class MyCellRendererDos extends DefaultTableCellRenderer {

  ClassLoader cldr = this.getClass().getClassLoader();

  java.net.URL genericImg = cldr.getResource("img/generic.png");
  java.net.URL folderImg = cldr.getResource("img/folderBW.png");
  java.net.URL okImg = cldr.getResource("img/aplicar.png");
  java.net.URL badImg = cldr.getResource("img/warning.png");
  java.net.URL arrow_upImg = cldr.getResource("img/arrow_upBW.png");

  ImageIcon genericOk = new ImageIcon(genericImg);
  ImageIcon folderOk = new ImageIcon(folderImg);
  ImageIcon okOk = new ImageIcon(okImg);
  ImageIcon badOk = new ImageIcon(badImg);
  ImageIcon arrow_upOk = new ImageIcon(arrow_upImg);

  private File[] archivosOriginales;
  private java.util.List<Integer> indicesRepetidos = new ArrayList<>();
  private java.util.List<Integer> indicesCambiados = new ArrayList<>();
  private int borde;

  public MyCellRendererDos(File[] archivosOriginales, java.util.List<Integer> indicesRepetidos, java.util.List<Integer> indicesCambiados, int borde){
    setOpaque(true);
    setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
    this.archivosOriginales = archivosOriginales;
    this.indicesRepetidos = indicesRepetidos;
    this.indicesCambiados = indicesCambiados;
    this.borde = borde;
  }
    @Override
    public Component getTableCellRendererComponent(
                            JTable table, Object value,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
	  Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	  Color Background;
	  Color Foreground;
	  String s = (String) value;
// 	  setText(s);
	  File archiv = null;
	  try {
	      archiv = archivosOriginales[row];
	  } catch (IndexOutOfBoundsException | NullPointerException e) {
	  }
	  if (archiv != null && archiv.canRead()) {
	      if (archiv.isDirectory()) setIcon(folderOk);
	      else setIcon(genericOk);
	  } else setIcon(genericOk);
	  Background = Color.WHITE;
	  Foreground = new Color(110,110,110);
	  if (isSelected) {
	      Background = new Color(240,240,240);
	  }
	  if (s.equals("..") && row == 0) {
	      setValue("");
	      setIcon(arrow_upOk);
	  } else {
	      if ( indicesCambiados.contains(row) && !s.equals("..") ) {
		  Background = new Color(152,251,152);
		  Foreground = Color.BLACK;
		  setIcon(okOk);
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
      public int[] getIndicesRepetidos() {
	  int[] repetidos = new int[indicesRepetidos.size()];
	  for (int x=0;x<repetidos.length;x++) {
	      repetidos[x] = indicesRepetidos.get(x);
	  }
	  return repetidos;
      }
} 