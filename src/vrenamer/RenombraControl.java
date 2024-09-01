package vrenamer;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static vrenamer.CreaValores.*;

public class RenombraControl implements ActionListener, KeyListener, MouseListener, PopupMenuListener, ChangeListener, UndoableEditListener, FocusListener {
  
  private int[] ultimo = new int[15];
  private Boolean shiftPulsado = false;

  public RenombraControl(){
    RE = new vRenamer();
    RE.dibujaGui(this);
    
  }
  @Override
  public void keyTyped(KeyEvent e){
  }
  @Override
  public void keyPressed(KeyEvent e){
    try {
	JTextField textName = (JTextField) e.getSource();
	if (e.getKeyCode() == 10 && textName.getName().equals("jRuta")) 
            RE.navega(RE.cambiaRuta());
	else if (textName.getName().equals("jFiltro") && !KeyEvent.getKeyText(e.getKeyCode()).equals("Ctrl") && !KeyEvent.getKeyText(e.getKeyCode()).equals("Alt") && e.getKeyCode() != 16) 
            RE.navegaFiltra(RE.getRutaFiltrando());
	else if (textName.getName().equals("separaTexto") && e.getKeyCode() != 16 && e.getKeyCode() != 65406 && !KeyEvent.getKeyText(e.getKeyCode()).equals("Ctrl") && !KeyEvent.getKeyText(e.getKeyCode()).equals("Alt"))
	    RE.conmutaEspera();
	else if (automaticPreview && !KeyEvent.getKeyText(e.getKeyCode()).equals("Ctrl") && !KeyEvent.getKeyText(e.getKeyCode()).equals("Alt") && e.getKeyCode() != 16 && e.getKeyCode() != 65406 && ! textName.getName().equals("jRuta")) {            
            RE.seleccionadosNuevo();
        }
    }
    catch (Exception n) {
    }
    try {
	if (e.getKeyCode() == 16) shiftPulsado = true;
    }
    catch (Exception n) {
    }
  }
  @Override
  public void keyReleased(KeyEvent e){
      JTextField textName = (JTextField) e.getSource();
      String nombreText = textName.getName();
      if (nombreText.equals("fechaAtributos"))
	  RE.dialogFechaAtributos();
  }
  @Override
  public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
    JComboBox comboName = (JComboBox) e.getSource();
    String nombreSeleccionado = (String) comboName.getName();

    if (nombreSeleccionado.equals("rutaCombo")) RE.setRuta();
  }
  @Override
  public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
    JComboBox comboName = (JComboBox) e.getSource();
    String nombreSeleccionado = (String) comboName.getName();
    if (comboName.getName().equals("rutaCombo")) RE.navega(RE.rutaCierra());
    else if (nombreSeleccionado.equals("jCapitaliza")) RE.capitalizaBusca();      
    else if (nombreSeleccionado.equals("jNormaliza")) RE.normalizaBusca();      
    else if (nombreSeleccionado.equals("jNumeros")) RE.numerosBusca();      
    else if (nombreSeleccionado.equals("jAtributos")) RE.actualizaAtributo();      
    else if (nombreSeleccionado.equals("jAtributosEstado")) RE.fijaAtributo();      
    else if (nombreSeleccionado.equals("separaCombo")) RE.conmutaSeparadores();
    else if (nombreSeleccionado.equals("comboCarpeta")) RE.comboCopia();
    else if (nombreSeleccionado.equals("comboFiltro")) RE.navegaFiltra(RE.getRutaFiltrando());

    if ( automaticPreview && !nombreSeleccionado.equals("comboCarpeta") && !nombreSeleccionado.equals("comboFiltro") && !comboName.getName().equals("rutaCombo")) 
	RE.seleccionadosNuevo();      

  }
  @Override
  public void popupMenuCanceled(PopupMenuEvent e) {
  }
  @Override
  public void actionPerformed(ActionEvent e){
    try {
      JButton Boton = (JButton) e.getSource();
      if (ultimo == null) ultimo[1] = 0;
      if (Boton.getName().equals("Previsualizar")) RE.seleccionadosNuevo();
      else if (Boton.getName().equals("Actualizar")) RE.navega(RE.getRutaFiltrando());
      else if (Boton.getName().equals("Aplicar")) RE.aplicado();
      else if (Boton.getName().equals("Limpiar")) RE.limpia();
      else if (Boton.getName().equals("carpeta")) RE.dialogoCopia("carpeta");
      else if (Boton.getName().equals("path")) RE.dialogoCopia("path");
      else if (Boton.getName().equals("mp3")) RE.actualizaMp3();
      else if (Boton.getName().equals("aplicamp3")) RE.escribeMp3();
      else if (Boton.getName().equals("limpiamp3")) RE.limpiaMp3();
      else if (Boton.getName().equals("Cancelar")) RE.cancelaCopia();
      else if (Boton.getName().equals("new")) RE.nuevo();
      else if (Boton.getName().equals("open")) RE.dialogoAbre();
      else if (Boton.getName().equals("saveAs")) RE.dialogoGuardaComo();
      else if (Boton.getName().equals("save")) RE.dialogoGuarda();
      else if (Boton.getName().equals("popUp")) RE.goUp();
      else if (Boton.getName().equals("popDown")) RE.goDown();
      else if (Boton.getName().equals("popUpOne")) RE.goUpOne();
      else if (Boton.getName().equals("popDownOne")) RE.goDownOne();
      else if (Boton.getName().contains(RE.getUndo() + " Re") ) RE.deshacer("renombra");
      else if (Boton.getName().contains(RE.getRedo() + " Re") ) RE.rehacer("renombra");
      else if (Boton.getName().contains(RE.getUndo() + " Mo") ) RE.deshacer("mover");
      else if (Boton.getName().contains(RE.getRedo() + " Mo") ) RE.rehacer("mover");
      else if (Boton.getName().contains(RE.getUndo() + " mp3") ) RE.deshacer("mp3");
      else if (Boton.getName().contains(RE.getRedo() + " mp3") ) RE.rehacer("mp3");
      else if (Boton.getName().contains(RE.getUndo() + " at") ) RE.deshacer("atributos");
      else if (Boton.getName().contains(RE.getRedo() + " at") ) RE.rehacer("atributos");
      else if (Boton.getName().equals("labelImage")) RE.dialogFoto();
      else RE.navega(RE.cambiaRutaBotones(Boton.getName()));

    }
    catch (Exception n) {
    }
    try {
      JMenuItem menu = (JMenuItem) e.getSource();
      if (menu.getText().equals(RE.getPreview())) RE.seleccionadosNuevo();
      else if (menu.getText().equals(RE.getApply())) RE.aplicado();
      else if (menu.getText().contains(RE.getUndo() + " Re")) RE.deshacer("renombra");
      else if (menu.getText().contains(RE.getRedo() + " Re")) RE.rehacer("renombra");
      else if (menu.getText().equals(RE.getUndo() + " mp3")) RE.deshacer("mp3");
      else if (menu.getText().equals(RE.getRedo() + " mp3")) RE.rehacer("mp3");
      else if (menu.getText().contains(RE.getUndo() + " Mo") ) RE.deshacer("mover");
      else if (menu.getText().contains(RE.getRedo() + " Mo") ) RE.rehacer("mover");
      else if (menu.getText().contains(RE.getUndo() + " at")) RE.deshacer("atributos");
      else if (menu.getText().contains(RE.getRedo() + " at")) RE.rehacer("atributos");
      else if (menu.getText().equals(RE.getSelectAll())) RE.seleccionaTodo();
      else if (menu.getText().equals(RE.getInvSel())) RE.invertirSeleccion();
      else if (menu.getText().equals(RE.getFolderSel())) RE.seleccionaCarpetas();
      else if (menu.getText().equals(RE.getFileSel())) RE.seleccionaArchivos();
      else if (menu.getText().equals(RE.getAbout())) RE.acercaDe();
      else if (menu.getText().equals(RE.getExit())) RE.salir();
      else if (menu.getName().equals("options")) RE.dialogOpciones();
      else if (menu.getName().equals("new")) RE.nuevo();
      else if (menu.getName().equals("open")) RE.dialogoAbre();
      else if (menu.getName().equals("saveAs")) RE.dialogoGuardaComo();
      else if (menu.getName().equals("save")) RE.dialogoGuarda();
      else if (menu.getName().equals("log")) RE.importaLog();
      else if (menu.getName().equals("import")) RE.dialogImportaTexto();
      else if (menu.getName().equals("popUp")) RE.goUp();
      else if (menu.getName().equals("popDown")) RE.goDown();
      else if (menu.getName().equals("popUpOne")) RE.goUpOne();
      else if (menu.getName().equals("popDownOne")) RE.goDownOne();
      else if (menu.getName().startsWith("order-")) RE.reordenaAuto(menu.getName());
      else if (menu.getName().startsWith("recent")) RE.abreRecent(menu.getName().replace("recent",""));
    }
    catch (Exception n) {
    }
    try {
      JCheckBoxMenuItem checkbox = (JCheckBoxMenuItem) e.getSource();
      if (checkbox.getText().equals(RE.getHidden())) {
          RE.navega(RE.getRuta());
      }
      else if (checkbox.getName().equals("dropMode")) {
          RE.pulsaDrop();
      }
    }
    catch (Exception n) {
    }
    try {
      JCheckBox check = (JCheckBox) e.getSource();
        switch (check.getName()) {
            case "copiaCarpeta" -> {
                //	  if (check.getText().equals(RE.getCopy() + " ")) {
                if (check.isSelected()) RE.pasaCopia();
                else RE.desactivaCopiaCarpeta();
              }
            case "separador" -> {
                RE.conmutaSeparadores();
                if (automaticPreview) RE.seleccionadosNuevo();
              }
            case "extension" -> {
                RE.conmutaExtension();
                if (automaticPreview) RE.seleccionadosNuevo();
              }
            case "Case" -> RE.ckFiltra();
            case "Recursivo" -> RE.navegaFiltra(RE.getRutaFiltrando());
            default -> {
                RE.activaCheck(check.getName());
                RE.atributos();
                if (automaticPreview) RE.seleccionadosNuevo();
              }
        }
          //	  }     break;
    }
    catch (Exception n) {
    }
    try {
      JRadioButton radio = (JRadioButton) e.getSource();
      if ( ! radio.getName().equals("opAleatorioLong") && ! radio.getName().equals("opAleatorioOrig") )RE.activa(radio.getName());
      if (automaticPreview) RE.seleccionadosNuevo();      
    }
    catch (Exception n) {
    }

  }
  @Override
  public void undoableEditHappened (UndoableEditEvent evt) {
        RE.desAdapta(evt.getEdit());
  }


  @Override
  public void stateChanged(ChangeEvent e) {
    try {
	RE.atributos();
    }
    catch (Exception n) {
    }
    try {
      if (automaticPreview){
          RE.seleccionadosNuevo();
      }      
    }
    catch (Exception n) {
    }
  }

  @Override
  public void focusGained(FocusEvent e) {

  }
  @Override
  public void focusLost(FocusEvent e) {
      RE.cierraDialogFoto();
  }

  @Override
  public void mouseClicked (MouseEvent e) {
      try {
	  JTextField textSource = (JTextField) e.getSource();
	  String textSourceName = textSource.getName();
	  if (textSourceName != null && textSourceName.equals("fechaAtributos"))
	    RE.dialogFechaAtributos();
      } catch (ClassCastException c) {
      }
  }
  @Override
  public void mouseEntered (MouseEvent e) {
      RE.toolTip();
  }
  @Override
  public void mouseExited (MouseEvent e) {

  }
  @Override
  public void mousePressed (MouseEvent e) {

  }
  @Override
  public void mouseReleased (MouseEvent e) {

  }

  public void setUltimo(int[] ultimo) {
    this.ultimo = ultimo;
  }
}