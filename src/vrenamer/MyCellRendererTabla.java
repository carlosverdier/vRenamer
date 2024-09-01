package vrenamer;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.table.*;
import java.io.File;

public class MyCellRendererTabla extends DefaultTableCellRenderer {
    final static String separador = System.getProperty("file.separator");

    ClassLoader cldr = this.getClass().getClassLoader();

    java.net.URL genericImg = cldr.getResource("img/generic.png");
    java.net.URL folderImg = cldr.getResource("img/folder.png");
    java.net.URL arrow_upImg = cldr.getResource("img/arrow_up.png");

    ImageIcon genericOk = new ImageIcon(genericImg);
    ImageIcon folderOk = new ImageIcon(folderImg);
    ImageIcon arrow_upOk = new ImageIcon(arrow_upImg);

    private String fecha, sistema;
    private File[] archivosOriginales;
    private Boolean invisible, preview;
    private idiomas Idioma;
    private MotorBusca MB;

    public MyCellRendererTabla(File[] archivosOriginales, String sistema, Boolean invisible, Boolean preview, idiomas Idioma) {
      setOpaque(true);
      setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
      this.archivosOriginales = archivosOriginales;
      this.sistema = sistema;
      this.invisible = invisible;
      this.preview = preview;
      this.Idioma = Idioma;
      MB = new MotorBusca(Idioma);
    }

    @Override
    public Component getTableCellRendererComponent(
                            JTable table, Object color,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
	Component cell = super.getTableCellRendererComponent(table, color, isSelected, hasFocus, row, column);
	Icon icono;
        int altoIcon = genericOk.getIconHeight();
        int anchoIcon = genericOk.getIconHeight();
        
        if (archivosOriginales.length > 0) {
            if ( archivosOriginales[row].canRead()) {
              if (archivosOriginales[row].getName().equals("..")  && row == 0 && invisible) {
                  setIcon(null);
                  setValue("");
              } else {
                  if (archivosOriginales[row].isDirectory()) {
                      if (archivosOriginales[row].getName().equals("..")) {
                          setIcon(arrow_upOk);
                      } else {
                          setIcon(folderOk);
                      }
                  } else {
                      try {
                        icono = FileSystemView.getFileSystemView().getSystemIcon(archivosOriginales[row], anchoIcon, altoIcon);
                        if (icono != null) {
                            setIcon(icono);
                        } else {
                            setIcon(genericOk);
                        }
                    } catch (Exception e) {
                        setIcon(genericOk);
                    }
                  }
                } 
            } else 
                setIcon(genericOk);
            String datoFecha;
            if (Idioma instanceof idiomasEsp) 
                datoFecha = MB.getFecha(archivosOriginales[row].toString(),0, '1');
            else 
                datoFecha = MB.getFecha(archivosOriginales[row].toString(),4, '1');
            boolean seleccionado = false;
            if (vRenamer.listaSeleccion.isEmpty()) {
                seleccionado = isSelected;
            } else {
                seleccionado = vRenamer.listaSeleccion.contains(row);
            }
            if (seleccionado) {
                setBackground(Color.LIGHT_GRAY);
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
            String s = archivosOriginales[row].getName();
            if (preview && ( MB.endsWithIgnoreCase(s,".jpg") || MB.endsWithIgnoreCase(s,".jpeg") || MB.endsWithIgnoreCase(s,".gif") || MB.endsWithIgnoreCase(s,".png") ) ) {
                String imagen = "<img src= file:" + archivosOriginales[row].getParent().replaceAll(" ","%20")+ separador + archivosOriginales[row].getName().replaceAll(" ","%20") + " width=150 height=150>";
                this.setToolTipText("<html><table><tr><td rowspan=7>"+imagen+"</td><td><font size=2>"+Idioma.getName()+"</font></td><td><font size=2>"+archivosOriginales[row].getName()+"</font></td></tr><tr><td><font size=2>"+Idioma.getPath()+"</font></td><td><font size=2>"+archivosOriginales[row].getParent()+"</font></td></tr><tr><td><font size=2>"+Idioma.getModified()+"</font></td><td><font size=2>"+datoFecha+"</font></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr></table></html>");
            } else {
                setToolTipText("<html><table><tr><td><font size=2>"+Idioma.getName()+"</font></td><td><font size=2>"+archivosOriginales[row].getName()+"</font></td></tr><tr><td><font size=2>"+Idioma.getPath()+"</u></font></td><td><font size=2>"+archivosOriginales[row].getParent()+"</font></td></tr><tr><td><font size=2>"+Idioma.getModified()+"</font></td><td><font size=2>"+datoFecha+"</font></td></tr></table></html>");
            }
        }
        return this;
    }
}