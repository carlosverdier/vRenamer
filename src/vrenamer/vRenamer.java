package vrenamer;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.SystemInfo;
import java.nio.charset.Charset;
import javax.swing.undo.*;
import javax.swing.*;
import javax.swing.table.*;
import java.beans.XMLDecoder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

import java.net.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.io.File;
import java.util.*;
import javax.swing.UIManager;
import javax.swing.event.*;
import java.util.prefs.Preferences;
import javax.swing.TransferHandler;
import java.awt.dnd.*;
import javax.swing.DropMode;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.regex.*;
import java.text.*;
import javax.swing.filechooser.*;
import java.awt.geom.Rectangle2D;

import java.awt.image.BufferedImage;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.image.Raster;

import java.awt.image.WritableRaster;
import java.awt.image.ColorConvertOp;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ColorSpace;


import net.coobird.thumbnailator.*;
import net.coobird.thumbnailator.geometry.*;

import de.umass.lastfm.*;

import org.apache.commons.io.comparator.*;

import com.jgoodies.looks.*;
import com.jgoodies.looks.plastic.*;
import com.jgoodies.looks.plastic.theme.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.desktop.QuitEvent;
import java.awt.desktop.QuitResponse;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;

import org.freixas.jcalendar.*;

import net.furbelow.*;
import static vrenamer.CreaValores.*;

/**
* GNU GENERAL PUBLIC LICENSE
*
* LGPL v3
*
* Copyright © 2010 -2014 Carlos Verdier Santiago
*/

public class vRenamer extends JFrame {
  final static String directorio = System.getProperty("user.dir");
  final static String separador = System.getProperty("file.separator");
  final static String rutaHome = System.getProperty("user.home");
  final static String codificacion = Charset.defaultCharset().toString();

  ClassLoader cldr = this.getClass().getClassLoader();
  
  String rutaMac = cldr.getResource("img/select.png").toString();

  java.net.URL selectImg = cldr.getResource("img/select.png");
  java.net.URL aplicarImg = cldr.getResource("img/aplicar.png");
//  java.net.URL aplicarBigImg = cldr.getResource("img/aplicarBig.png");
  java.net.URL aplicarBigImg = cldr.getResource("img/tik.gif");
  
//  java.net.URL aplicarGifImg = cldr.getResource("img/aplicargig.gif");
  
  java.net.URL aplicarBigBWImg = cldr.getResource("img/aplicarBigBW.png");
  java.net.URL previewImg = cldr.getResource("img/preview.png");
  java.net.URL cleanImg = cldr.getResource("img/clean.png");
  java.net.URL addImg = cldr.getResource("img/list-add.png");  
  java.net.URL undoImg = cldr.getResource("img/undo.png");
  java.net.URL redoImg = cldr.getResource("img/redo.png");
  java.net.URL logImg = cldr.getResource("img/log.png");
  java.net.URL importImg = cldr.getResource("img/import.png");

  java.net.URL iconFolderImg = cldr.getResource("img/folder_small.png");
  java.net.URL exitImg = cldr.getResource("img/salir.png");
  java.net.URL exitBWImg = cldr.getResource("img/salirBW.png");
  java.net.URL infoImg = cldr.getResource("img/info.png");
  java.net.URL actualizaImg = cldr.getResource("img/update.png");
  java.net.URL espImg = cldr.getResource("img/es.png");
  java.net.URL engImg = cldr.getResource("img/us.png");
  java.net.URL yesImg = cldr.getResource("img/yes.png");
  java.net.URL yesAllImg = cldr.getResource("img/yesAll.png");
  java.net.URL cancelImg = cldr.getResource("img/cancel.png");
  java.net.URL openImg = cldr.getResource("img/folder_small.png");
  java.net.URL openRecentImg = cldr.getResource("img/openRecent.png");
  java.net.URL saveImg = cldr.getResource("img/save.png");
  java.net.URL saveAsImg = cldr.getResource("img/saveas.png");
  java.net.URL preferencesImg = cldr.getResource("img/preferences.png");

  java.net.URL vrlogoImg = cldr.getResource("img/vrlogo.png");
  java.net.URL vrlogoPrueba = cldr.getResource("img/vrlogoPrueba.png");
  java.net.URL newImg = cldr.getResource("img/new.png");
  java.net.URL arrowTopImg = cldr.getResource("img/top.png");
  java.net.URL arrowBottomImg = cldr.getResource("img/bottom.png");
  java.net.URL arrowUpImg = cldr.getResource("img/up.png");
  java.net.URL arrowDownImg = cldr.getResource("img/down.png");

  java.net.URL imageImg = cldr.getResource("img/image.png");
  java.net.URL manualOrderImg = cldr.getResource("img/manualOrder.png");
  java.net.URL nameOrderImg = cldr.getResource("img/nameOrder.png");
  java.net.URL dateOrderImg = cldr.getResource("img/dateOrder.png");
  java.net.URL extensionOrderImg = cldr.getResource("img/extensionOrder.png");
  java.net.URL sizeOrderImg = cldr.getResource("img/sizeOrder.png");
  java.net.URL numberOrderImg = cldr.getResource("img/numberOrder.png");

  java.net.URL checkBoxEnabledImg = cldr.getResource("img/checkboxEnabled.png");
  java.net.URL checkBoxDisabledImg = cldr.getResource("img/checkboxDisabled.png");

  java.net.URL refreshingImg = cldr.getResource("img/img_refreshing.gif");
  java.net.URL imageWarningImg = cldr.getResource("img/image_warning.png");

  java.net.URL generalOptImg = cldr.getResource("img/general.png");
  java.net.URL dateImg = cldr.getResource("img/date.png");

  java.net.URL donaImg = cldr.getResource("img/dona.png");

  java.net.URL removeDropImg = cldr.getResource("img/remove.png");
  java.net.URL removeDropBWImg = cldr.getResource("img/removeBW.png");

  java.net.URL waitingImg = cldr.getResource("img/wait.gif");
  java.net.URL configImg = cldr.getResource("img/config.png");
  java.net.URL lastImg = cldr.getResource("img/Last.png");

  java.net.URL optionRenameImg = cldr.getResource("img/optionRename.png");
  
  ImageIcon selectOk = new ImageIcon(selectImg);
  ImageIcon aplicarOk = new ImageIcon(aplicarImg);
  ImageIcon aplicarBigOk = new ImageIcon(aplicarBigImg);
  ImageIcon aplicarBigBWOk = new ImageIcon(aplicarBigBWImg);
  ImageIcon previewOk = new ImageIcon(previewImg);
  ImageIcon cleanOk = new ImageIcon(cleanImg);
  ImageIcon undoOk = new ImageIcon(undoImg);
  ImageIcon redoOk = new ImageIcon(redoImg);
  ImageIcon logOk = new ImageIcon(logImg);
  ImageIcon importOk = new ImageIcon(importImg);

  ImageIcon iconFolder = new ImageIcon(iconFolderImg);
  ImageIcon exitOk = new ImageIcon(exitImg);
  ImageIcon exitBWOk = new ImageIcon(exitBWImg);
  ImageIcon infoOk = new ImageIcon(infoImg);
  ImageIcon actualizaOk = new ImageIcon(actualizaImg);
  ImageIcon espOk = new ImageIcon(espImg);
  ImageIcon engOk = new ImageIcon(engImg);
  ImageIcon yesOk = new ImageIcon(yesImg);
  ImageIcon yesAllOk = new ImageIcon(yesAllImg);
  ImageIcon cancelOk = new ImageIcon(cancelImg);
  ImageIcon openOk = new ImageIcon(openImg);
  ImageIcon openRecentOk = new ImageIcon(openRecentImg);
  ImageIcon saveOk = new ImageIcon(saveImg);
  ImageIcon saveAsOk = new ImageIcon(saveAsImg);
  ImageIcon preferencesOk = new ImageIcon(preferencesImg);

  ImageIcon vrlogoOk = new ImageIcon(vrlogoImg);
  BufferedImage vrlogoBuff;
  ImageIcon newOk = new ImageIcon(newImg);
  ImageIcon manualOrderOk = new ImageIcon(manualOrderImg);
  ImageIcon nameOrderOk = new ImageIcon(nameOrderImg);
  ImageIcon dateOrderOk = new ImageIcon(dateOrderImg);
  ImageIcon extensionOrderOk = new ImageIcon(extensionOrderImg);
  ImageIcon sizeOrderOk = new ImageIcon(sizeOrderImg);
  ImageIcon numberOrderOk = new ImageIcon(numberOrderImg);

  ImageIcon imageOk = new ImageIcon(imageImg);
  ImageIcon arrowTopOk = new ImageIcon(arrowTopImg);
  ImageIcon arrowBottomOk = new ImageIcon(arrowBottomImg);
  ImageIcon arrowUpOk = new ImageIcon(arrowUpImg);
  ImageIcon arrowDownOk = new ImageIcon(arrowDownImg);
  ImageIcon checkBoxEnabledOk = new ImageIcon(checkBoxEnabledImg);
  ImageIcon checkBoxDisabledOk = new ImageIcon(checkBoxDisabledImg);

  ImageIcon refreshingOk = new ImageIcon(refreshingImg);
  ImageIcon imageWarningOk = new ImageIcon(imageWarningImg);

  ImageIcon generalOptOk = new ImageIcon(generalOptImg);
  ImageIcon dateOk = new ImageIcon(dateImg);

  ImageIcon donaOk = new ImageIcon(donaImg);

  ImageIcon removeDropOk = new ImageIcon(removeDropImg);
  ImageIcon removeDropBWOk = new ImageIcon(removeDropBWImg);
  
  ImageIcon waitingOk = new ImageIcon(waitingImg);
  ImageIcon configOk = new ImageIcon(configImg);

  ImageIcon lastOk = new ImageIcon(lastImg);

  ImageIcon optionRenameOk = new ImageIcon(optionRenameImg);

  BufferedImage infoBigOk;


  private Preferences prefs;
  private String prefDirectorio, prefIdioma, prefRuta, prefSesion, prefReboot, prefRenderer, prefAuto, prefMaximized, prefDimension, prefDivideTop, prefDivideBottom, prefLocation, prefDiasMes, prefModified, prefTextoSepara, prefComboCarpeta, prefDrop, prefCarpeta, prefBasura, prefEstructura, prefRecursivoCarpeta, prefCopiarRenombrados, prefRecent, prefVersion;
  private String iniciaIdioma;
  private String iniciaSesion;
  private String iniciaReboot;
  private String iniciaRenderer;
  private String iniciaAuto;
  private String iniciaMaximized;
  private String iniciaDimension;
  private String iniciaDivideTop;
  private String iniciaDivideBottom;
  private String iniciaLocation;
  private String iniciaDiasMes;
  private String iniciaModified;
  private String iniciaTextoSepara;
  private String iniciaComboCarpeta;
  private String iniciaDrop;
  private String iniciaCarpeta;
  private String iniciaBasura;
  private String iniciaEstructura;
  private String iniciaRecursivoCarpeta;
  private String iniciaCopiarRenombrados;
  private String iniciaRecent;
  private String iniciaVersion;

  private boolean autoDespuesReset, copiarEstructura, recursivoCarpeta, copiarRenombrados;
  private boolean primero;
  private boolean cambiaFoco;
  private boolean modoDrop;
  private boolean dropAplicado;

  private InputStream licenciaTxt;
  private BufferedReader reader;

  private InputStream creditosTxt;

  private int cantidadRenombrados;
  private int[] indSeleccionadosOk;
  private int posicion;
  private int opSeleccionada;
  
  private String filtrado;
  private ListArchivos oArchivos;
  private ListArchivos oRenombrados;
  private MotorBusca mBusca;

  private JScrollPane scrTexto;
  private JFileChooser dlgCopia;
  private JDialog dLicencia, dImporta;
  private JDialog DialogOpciones;
  private JDialog DialogConfigMp3;
  private JCalendar calendario;
  private JButton btnActualizaCalendar;
  private Locale locale;
  private JTextField txtImportaSepara;

  private JRadioButton modified;
  private JRadioButton creation;
  private JRadioButton accessed;
  private JRadioButton manual;

  private JRadioButton soloPanel;
  private JRadioButton ambos;

  private JComboBox comboIdioma, comboSesion, comboFechas, comboAuto, comboRenombrado, comboEstructura, comboRecursivoCarpeta, comboCopiarRenombrados;
  private JTextField txtBasura;

  private File rutaActual;
  private int index;
  private String newRuta;
  private String ruta, rutaAnterior;  
  private String rutaRenombrados;  

  private String activaAnterior;

  private int[] okSeleccionRe, indicesSeleccion, okSeleccion;
  private ArrayList<File> archivosCheck = new ArrayList<>();
  private ArrayList<Integer> seleccionCheck = new ArrayList<>();
  private java.util.List<Integer> indicesMarcar = new ArrayList<>();
  private java.util.List<Integer> indicesCambiados = new ArrayList<>();
  private java.util.List<Integer> indicesCiclo = new ArrayList<>();
  private Boolean noPasarFiltro, seleccionCancelada, modoLog, contenidoCarpetaLog;
  private java.util.List<String> listaEntradasInter;
  private java.util.List<String> listaEntradas;

  private SeleccionadosNuevo doSeleccionadosNuevo;
  
  public static java.util.List<Integer> listaSeleccion;
  private Boolean reseteaRenombrados;

  private DefaultTableModel listRenombradosModel;
  private DefaultTableModel listArchivosModel;
  private JTable listArchivos;
  private StringBuffer[] Archivos;
  private JLabel lblArchivos;
  private JPanel pnlArchivos;
  private JScrollPane scrArchivos;
  private JSplitPane pnlDivide;

  private int devuelve;
  private JPanel pnlLog;
  private JPanel pnlCentralLog;
  private JScrollPane scrListLog;
  private java.util.List<String> logFechas;
  private java.util.List<File> logFiles;
  private String[] listFechas;
  private int logSeleccionado;
  private JPanel pnlBotonLog, pnlSurLog;
  private JLabel lblLog;
  private DefaultTableModel tablaLogModel;
  private JTable tablaLog;

  private File[] archivosOriginales, archivosOriginalesAplicar, archivosOriginalesDrop;
  private File[] archivosRenombrados, archivosRenombradosAplicar;
  private File mArchivoDest;
  private File[] archivosRenombradosMover;
  private Boolean[][] okSeleccionDoble;
  private String operacionAplicada;

  private JTable listRenombrados;
  private StringBuffer[] Renombrados, RenombradosCopia;
  private JLabel lblRenombrados;
  private JPanel pnlRenombrados;
  private JScrollPane scrRenombrados;
  private String[] RenombradosEstructura;

  private JPanel pnlOpcionDos;
  private JPanel pnlOpcionTres;
  private JPanel pnlExtras;
  private JPanel pnlExtrasTotal;
  private JPanel pnlExtrasBorde;
  private JCheckBox ckCopiaCarpeta;
  private JComboBox<String> comboCarpeta;
  private JCheckBox ckOpcionDos;
  private JTextField txtExtension;
  private Boolean restauraCkCopia;
  private int restauraComboCarpeta;

  private JCheckBox ckOpcionTres;
  private JButton btnCarpeta;
  private JComboBox jSepara;
  private JPanel pnlCarpeta;
  private JPanel pnlCentral;

  private JPanel pnlSustituciones;
  private JScrollPane scrollSustituciones;
  private JSplitPane pnlSur;

  private JPanel pnlOtrosIzq;
  private JPanel pnlOtrosDer;

  private JPanel pnlMp3Der;

  private String tagMp3, tagMp3Pista, tagMp3Artista, tagMp3Cancion, tagMp3Album, tagMp3Anyo, tagMp3Genero;

  private JLabel lblPista;
  private JPanel pnlPista;
  private JTextField pistaInfo;

  private JLabel lblArtista;
  private JPanel pnlArtista;
  private JTextField artistaInfo;

  private JLabel lblCancion;
  private JPanel pnlCancion;
  private JTextField cancionInfo;

  private JLabel lblAlbum;
  private JPanel pnlAlbum;
  private JTextField albumInfo;

  private JLabel lblAnyo;
  private JPanel pnlAnyo;
  private JTextField anyoInfo;

  private JLabel lblGenero;
  private JPanel pnlGenero;
  private JTextField generoInfo;

  private JButton jBotonMp3;
  private JPanel pnlBotonMp3;

  private JPanel pnlMp3Izq;

  private JLabel lblPistaIzq;
  private numbersField txtPista;
  private JCheckBox ckPista;

  private JPanel pnlPistaIzq;

  private JLabel lblArtistaIzq;
  private JTextField txtArtista;
  private JPanel pnlArtistaIzq;

  private JLabel lblCancionIzq;
  private JTextField txtCancion;
  private JPanel pnlCancionIzq;

  private JLabel lblAlbumIzq;
  private JTextField txtAlbum;
  private JPanel pnlAlbumIzq;

  private JLabel lblAnyoIzq;
  private numbersField txtAnyo;
  private JPanel pnlAnyoIzq;

  private JLabel lblGeneroIzq;
  private JTextField txtGenero;
  private JPanel pnlGeneroIzq;

  private JButton jLimpiaMp3;
  private JButton jBotonMp3Izq;
  private JPanel pnlBotonMp3Izq;

  private JPanel pnlSurMp3;

  private JTabbedPane pestPanel;
  private JPanel pnlSurDos;

  private JProgressBar jProgreso;
  private Iterator indicesMarcarItera;
  private Boolean cancelarCopia;
  private Boolean cancelarMp3;
  private File fotoArchivo, fotoArchivoActual;
  private java.awt.Image newimg;
  private int rotacion;
  private BufferedImage fotoImagen;
  private int alturaImagen, anchuraImagen;
  private JLabel labelImage;
  private JPanel pnlInfoImagen;
  private cargaImagen cargaWorker;
  private cargaImagenMarco doCargaImagenMarco;
  private Navegando doNavega;

  private JPanel jMuestraFoto;
  private JDialog DialogFotoPrevio, DialogFoto;

  private JPanel pnlInfo;
  private JPanel pnlInfoLeft;
  private JPanel pnlInfoDatos;
  private JPanel pnlProgreso, pnlProgresoInfo;
  private JPanel comboSur;

  private JPanel pnlNumeros;
  private JComboBox jNumeros;

  private JLabel lblNormaCeros;
  private JLabel lblNormaPosicion;
  private SpinnerNumberModel spNormaPosicion;
  private JSpinner normaPosicion;
  private SpinnerNumberModel spNormaCeros;
  private JSpinner normaCeros;

  private JLabel lblNumerosEn;
  private JLabel lblNumerosSalto;
  private SpinnerNumberModel spNumerosEn;
  private JSpinner numerosEn;
  private SpinnerNumberModel spNumerosSalto;
  private JSpinner numerosSalto;
  private SpinnerNumberModel spNumerosPosicion;
  private JSpinner numerosPosicion;

  private JPanel pnlNormaliza;
  private JComboBox jNormaliza;
  private JLabel lblNormalizaTrim;
  private SpinnerNumberModel spNormalizaTrim;
  private JSpinner normalizaTrim;
  private JCheckBox desdeDerechaTrim;

  private JTextField txtReemplazaUno;
  private JLabel lblReemplaza;
  private JWidePopupComboBox cMode;
  private JTextField txtReemplazaDos;
  private JPanel pnlReemplaza;

  private JPanel pnlCapitaliza;
  private JComboBox jCapitaliza;
  private JTextField txtSymbols;

  private JPanel pnlAtributos;
  private JComboBox jAtributos;
  private JTextField fechaAtributos;
  private JDialog dAtribFecha;
  private JCheckBox lastAtrib;
  private JCheckBox CreationAtrib;
  private JCheckBox AccessAtrib;
  private JComboBox jAtributosEstado;
  private int[] iAtributos;
  private String[] sAtributos;  
  private JWidePopupComboBox cAtributos;

  private JPanel pnlAleatorio;
  private JRadioButton opAleatorioLong;
  private SpinnerModel spAleatorio;
  private JSpinner AleatorioLong;
  private JRadioButton opAleatorioOrig;
  private ButtonGroup grAleatorio;

  private int diasMes;
  private Date datoCalendario;

  private JPanel pnlInsertar;
  private JTextField txtInsertar;
  private JLabel lblInsertar;
  private JSpinner spnInsertar;
  private SpinnerModel smIns;
  private JCheckBox desdeDerechaInserta;

  private JPanel pnlEliminar;
  private JPanel pnlInserciones;
  private JLabel desdeInsertar;
  private JLabel hastaInsertar;
  private JSpinner spnDesde;
  private JSpinner spnHasta;
  private SpinnerModel smDesde;
  private SpinnerModel smHasta;
  private JCheckBox desdeDerecha;

  private JRadioButton opSustituciones;
  private JRadioButton opInserta;
  private JRadioButton opElimina;
  private ButtonGroup opRenombra;

  private JCheckBox opNumeros;
  private JCheckBox opNormaliza;
  private JCheckBox opReemplaza;
  private JCheckBox opCapitaliza;
  private JCheckBox opAtributos;
  private JCheckBox opAleatorio;
  private JPanel pnlSustiOpciones;

  private JButton btnActualizar;
  private JButton btnPreview;
  private JButton btnAplicar;
  private JButton btnLimpiar;
  private JButton comboSelecAplica;
  private int opcionSelec;

  private JButton jCancel;

  private JPanel pnlNavegador;
  private String rutaModificada;
  private String opcionOrdena;

  private JPanel pnlHerramientasNorte;
  private JPanel pnlHerramientasParcial;
  
  private String[] unidades;
  private JComboBox jRuta;
  private JTextField tRuta;
  private JButton btnRutaIzq;
  private JLabel lblTextoDer;
  private JPanel pnlTexto;
  private JPanel pnlControlesSuperior;

  private JLabel lblFiltro;
  private JTextField jFiltro;
  private JComboBox comboFiltro;

  private JPanel opcionesFiltroDer;
  private JCheckBox ckCase;
  private JCheckBox ckExcluye;
  private JCheckBox ckRecursivo;

  private JPanel pnlSerieConfig;
  private JComboBox comboMp3;
  private JTextField corteMp3;
  private JSpinner numeracionCorteMp3;
  private JLabel lblSeccionMp3;
  private JWidePopupComboBox hastaFinalMp3;
  private JTextField archivoTextoDesdeMp3;
  private JLabel lblArchivoTextoHastaMp3;
  private JTextField archivoTextoHastaMp3;
  private JCheckBox ckEnable;
  private JComboBox comboEnable;
  private JComboBox comboCase;

  private String[][] tablaMp3Originales;
  private String[][] arrayTablaMp3;
  private String[] arrayTablaRecoge;
  private String[] nombreColumnasMp3;
  private DefaultTableModel tablaMp3Model;
  private JTable tablaMp3;
  private JScrollPane tablaScrollMp3;
  private ArrayList<String> tablaMp3OriginalesList;
  private ArrayList<String> tablaMp3TagList;
  private populateTableMp3 populateWorker;

  private JTextField txtTextoGlobal;
  private int indiceConfigMp3Global;
  private String campoMp3;
  private Boolean leeDatos = false;

  private JPanel pnlCkEnable;
  private JPanel pnlComboCase;
  private JPanel pnlTablaMp3;
  private JPanel pnlDialogConfigMp3;
  private JPanel pnlDialgMp3Sur;
  private JPanel pnlPrincipalConfig;
  private BarraRenombra panelDragged;
  private JButton btnLast;

  private Integer[] intComboMp3 = new Integer[6];
  private Integer[] intFinalMp3 = new Integer[6];
  private String[] stringCorte = new String[6];
  private String[] stringnumeracion = new String[6];
  private String[] stringDesde = new String[6];
  private String[] stringHasta = new String[6];
  private Boolean[] booleanCkEnable = new Boolean[6];
  private Integer[] intComboEnable = new Integer[6];
  private Integer[] intComboCase = new Integer[6];

  private WindowAdapter wa;

  private JToolBar toolBar;
  private JButton toolNew;
  private JButton toolOpen;
  private JButton toolSave;
  private JButton toolSaveAs;
  private JButton toolUndo;
  private JButton toolRedo;
  private JButton toolUp;
  private JButton toolDown;
  private JButton toolTop;
  private JButton toolBottom;

  private JPopupMenu popMenu;
  private JMenuItem popAll;
  private JMenuItem popInvert;
  private JMenuItem popFiles;
  private JMenuItem popFolders;

  private JMenuBar mMenu;
  private JMenu m1;
  private JMenu m2;
  private JMenu m3;
  private JMenu m4;
  private JMenu sorting;

  private JMenuItem m11;
  private JMenuItem m12;
  private JMenu menuRecent;
  private JMenuItem m13;
  private JMenuItem m14;
  private JMenuItem m15;
  private JMenuItem m16;
  private JMenuItem m17;
  private JMenuItem m21;
  private JMenuItem m22;
  private JMenuItem m23;
  private JMenuItem m24;
  private JMenuItem m25;
  private JMenuItem m26;
  private JMenuItem m31;
  private JMenuItem m41;
  private JCheckBoxMenuItem m42;
  private JCheckBoxMenuItem m43;

  private JMenuItem mLog;
  private JMenuItem mImport;

  private JMenu sortName;
  private JMenuItem sortNameNormal;
  private JMenuItem sortNameReverse;

  private JMenu sortDate;
  private JMenuItem sortDateNormal;
  private JMenuItem sortDateReverse;

  private JMenu sortPictureDate;
  private JMenuItem sortPictureDateNormal;
  private JMenuItem sortPictureDateReverse;

  private JMenu sortSize;
  private JMenuItem sortSizeNormal;
  private JMenuItem sortSizeReverse;

  private JMenu sortExtension;
  private JMenuItem sortExtensionNormal;
  private JMenuItem sortExtensionReverse;

  private JMenu sortNumber;
  private JMenuItem sortNumberNormal;
  private JMenuItem sortNumberReverse;

  private UndoableEdit edit;
  private UndoManager undoManager_;
  private UndoableEditSupport undoSupport_;
  private String rutaGuarda;
  private java.util.List<String> openRecent;

  private java.util.List<Integer> iSeleccionadosOk;
  private int respuestaOpcion;
  private Boolean estadoAplicar;

  private java.util.List<File> ficherosImportados;
  private java.util.List<File> ficherosImportadosAdd;
  private Boolean externo;
  private String tipoImportados;

  private java.util.List<File> directoriosCreados;
  private java.util.List<File> directoriosProvisionalCreados;
  private java.util.List<File> archivosCiclo;

  private File[] directoriosDeshacer;

  private Boolean bloqueaConmuta;

  private int[] indSeleccionados, indSeleccionadosRe;
  private StringBuffer[] FicherosComp;
  private Boolean copia;
  private String rutaRe;
  private Boolean derecho, muestraFoto;

  private String vrenamerFolder;

  private Graphics2D g;
  private JDialog AcercaDe;
  private final static String Version = "1.6.1";
  
  private JPanel pnlPrincipal;

  private MyCellRendererDos renderizaDos;

    public vRenamer() {
        this.estadoAplicar = true;
        this.nombreColumnasMp3 = new String[2];
        this.cancelarMp3 = false;
        this.rotacion = 0;
        this.filtrado = "";
        this.primero = true;
        this.cambiaFoco = false;
        this.modoDrop = false;
        this.dropAplicado = false;
        this.posicion = 1;
        this.RenombradosEstructura = new String[0];
        this.txtSymbols = new JTextField("");
        this.opcionSelec = 1;
        this.diasMes = 0;
        this.tablaMp3TagList = new ArrayList<>();
        this.tablaMp3OriginalesList = new ArrayList<>();
        this.wa = null;
        this.bloqueaConmuta = false;
        this.tipoImportados = "";
        this.ficherosImportados = new ArrayList<>();
        this.externo = false;
        this.ficherosImportadosAdd = new ArrayList<>();
    }

  public void dibujaGui(RenombraControl cc) {
    CreaValores.cc=cc;
    if (getSistema().equals("mac")) {
        Desktop.getDesktop().setAboutHandler((a) -> {
            acercaDe();
        });
        Desktop.getDesktop().setPreferencesHandler((p) -> {
            dialogOpciones();        
        });
        Desktop.getDesktop().setQuitHandler((QuitEvent e, QuitResponse response) -> {
            salir();
        });
        Desktop.getDesktop().setOpenFileHandler((o) -> {
            dialogoAbreMac();
        });
    }
    prefs = Preferences.userRoot().node(this.getClass().getName());
    prefDirectorio = "directorioSaved";
    prefIdioma = "idiomaSaved";
    prefRuta = "rutaSaved";
    prefSesion = "sesionSaved";
    prefReboot = "sesionReboot";
    prefRenderer = "rendererSaved";
    prefAuto = "autoSaved";
    prefMaximized = "maxSaved";
    prefDimension = "dimensionSaved";
    prefDivideTop = "divideTop";
    prefDivideBottom = "divideBottom";
    prefLocation = "locationSaved";
    prefDiasMes = "diasMesSaved";
    prefModified = "modifiedSaved";
    prefTextoSepara ="separaSaved";
    prefComboCarpeta ="carpetaSaved";
    prefDrop = "dropSaved";
    prefCarpeta = "carpetaDropSaved";
    prefBasura = "basuraSaved";
    prefEstructura = "estructuraSaved";
    prefRecursivoCarpeta = "recursivoCarpetaSaved";
    prefCopiarRenombrados = "copiarRenombradosSaved";
    prefRecent = "recentSaved";
    prefVersion = "versionSaved";

    iniciaIdioma = (prefs.get(prefIdioma, "ninguno"));
    switch (iniciaIdioma) {
        case "ninguno" -> {
            if (System.getProperty("user.language").equals("es")) {
                iniciaIdioma = "Esp";
                Idioma = new idiomasEsp();
            } else {
                iniciaIdioma = "Eng";
                Idioma = new idiomasEng();
            }
          }
        case "Eng" -> Idioma = new idiomasEng();
        case "Esp" -> Idioma = new idiomasEsp();
    }
    iniciaSesion = (prefs.get(prefSesion, "clean"));
    iniciaReboot = (prefs.get(prefReboot, "clean"));
    iniciaRenderer = (prefs.get(prefRenderer, "default"));
    iniciaAuto = (prefs.get(prefAuto, "verdadero"));
    iniciaMaximized = (prefs.get(prefMaximized, "falso"));
    iniciaDimension = (prefs.get(prefDimension, "default"));
    iniciaDivideTop = (prefs.get(prefDivideTop, "default"));
    iniciaDivideBottom = (prefs.get(prefDivideBottom, "default"));
    iniciaLocation = (prefs.get(prefLocation, "default"));
    iniciaDiasMes = (prefs.get(prefDiasMes, "0"));
    iniciaModified = (prefs.get(prefModified, "modified"));
    iniciaCarpeta = (prefs.get(prefCarpeta, "default"));
    iniciaBasura = (prefs.get(prefBasura, "[^a-zA-Z0-9_ -]+"));
    iniciaEstructura = (prefs.get(prefEstructura, "false"));
    iniciaRecursivoCarpeta = (prefs.get(prefRecursivoCarpeta, "false"));
    iniciaCopiarRenombrados = (prefs.get(prefCopiarRenombrados, "false"));
    iniciaRecent = (prefs.get(prefRecent, ""));
    iniciaVersion = (prefs.get(prefVersion, "true"));

    copiarEstructura = iniciaEstructura.equals("true");
    recursivoCarpeta = iniciaRecursivoCarpeta.equals("true");
    copiarRenombrados = iniciaCopiarRenombrados.equals("true");
    if ( !iniciaRecent.equals("")) {
	String [] arrayRecent = iniciaRecent.split(",");
	openRecent = new LinkedList<>(Arrays.asList(arrayRecent));
    } else {
	openRecent = new ArrayList<>();
    }
    try {
	vrlogoBuff = ImageIO.read(vrlogoPrueba);
    } catch (IOException e) {
    }
    
    automaticPreview = false;
    mMenu = new JMenuBar();
    mMenu.setOpaque(true);
    if ( getSistema().equals("linux") ) {
	mMenu.setBackground(Color.pink);
    }

    mMenu.putClientProperty(Options.HEADER_STYLE_KEY,HeaderStyle.BOTH);    

    m1 = new JMenu(Idioma.getMenuFile());
    m1.setMnemonic(Idioma.getMenuMaskFile());
    m2 = new JMenu(Idioma.getMenuEdit());
    m2.setMnemonic(KeyEvent.VK_E);
    m3 = new JMenu(Idioma.getMenuHelp());
    m3.setMnemonic(Idioma.getMenuMaskHelp());
    m4 = new JMenu(Idioma.getMenuPrefs());
    m4.setMnemonic(Idioma.getMenuMaskSettings());
    sorting = new JMenu(Idioma.getSorting());
    sorting.setMnemonic(Idioma.getMenuMaskSorting());

    m11 = new JMenuItem(Idioma.getMenuNew(),newOk);
    m11.setName("new");
    m11.setMnemonic(KeyEvent.VK_N);    
    m11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, java.awt.Event.META_MASK));
    }
    m12 = new JMenuItem(Idioma.getMenuOpen(),openOk);
    m12.setName("open");
    m12.setMnemonic(Idioma.getMenuMaskOpen());
    m12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, java.awt.Event.META_MASK));
    }
    menuRecent = new JMenu(Idioma.getMenuOpenRecent());
    menuRecent.setIcon(openRecentOk);
    m13 = new JMenuItem(Idioma.getMenuSave(),saveOk);
    m13.setName("save");
    m13.setMnemonic(Idioma.getMenuMaskSave());
    m13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, java.awt.Event.META_MASK));
    }
    m14 = new JMenuItem(Idioma.getMenuSaveAs(),saveAsOk);
    m14.setName("saveAs");
    m14.setMnemonic(Idioma.getMenuMaskSaveAs());
    m15 = new JMenuItem(Idioma.getMenuPreview(),previewOk);
    m15.setMnemonic(KeyEvent.VK_V);
    m15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, java.awt.Event.META_MASK));
    }
    m16 = new JMenuItem(Idioma.getMenuApply(),aplicarOk);
    m16.setMnemonic(KeyEvent.VK_A);
    m16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, java.awt.Event.META_MASK));
    }
    m17 = new JMenuItem(Idioma.getMenuExit(),exitOk);
    m17.setMnemonic(Idioma.getMenuMaskExit());
    m17.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
    mLog = new JMenuItem(Idioma.getMenuLog(),logOk);
    mLog.setName("log");
    mLog.setMnemonic(Idioma.getMenuMaskLog());
    mLog.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       mLog.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, java.awt.Event.META_MASK));
    }

    mImport = new JMenuItem(Idioma.getMenuImport(),importOk);
    mImport.setName("import");
    mImport.setMnemonic(Idioma.getMenuMaskImport());
    mImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       mImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, java.awt.Event.META_MASK));
    }

    m21 = new JMenuItem(Idioma.getMenuSelectAll(),selectOk);
    m21.setMnemonic(KeyEvent.VK_S);
    m21.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m21.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, java.awt.Event.META_MASK));
    }
    m22 = new JMenuItem(Idioma.getMenuInvSel());
    m22.setMnemonic(KeyEvent.VK_I);
    m22.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m22.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, java.awt.Event.META_MASK));
    }
    m23 = new JMenuItem(Idioma.getMenuSelFile());
    m23.setMnemonic(KeyEvent.VK_E);
    m23.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m23.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, java.awt.Event.META_MASK));
    }
    m24 = new JMenuItem(Idioma.getMenuSelFolder());
    m24.setMnemonic(KeyEvent.VK_L); 
    m24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, java.awt.Event.META_MASK));
    }
    m25 = new JMenuItem(Idioma.getMenuUndo(),undoOk);
    m25.setMnemonic(Idioma.getMenuMaskUndo());
    m25.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m25.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, java.awt.Event.META_MASK));
    }
    m26 = new JMenuItem(Idioma.getMenuRedo(),redoOk);
    m26.setMnemonic(KeyEvent.VK_R);
    m26.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, java.awt.Event.SHIFT_MASK | ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m26.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, java.awt.Event.SHIFT_MASK| java.awt.Event.META_MASK));
    }

    m31 = new JMenuItem(Idioma.getMenuAbout());
    m31.setMnemonic(Idioma.getMenuMaskAbout());

    m41 = new JMenuItem(Idioma.getMenuOptions(),preferencesOk);
    m41.setMnemonic(KeyEvent.VK_P);
    m41.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    m41.setName("options");

    m42 = new JCheckBoxMenuItem(Idioma.getMenuHidden());
    m42.setMnemonic(KeyEvent.VK_O);
    m42.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
    if( getSistema().equals("mac") ) {
       m42.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, java.awt.Event.META_MASK));
    }

    m43 = new JCheckBoxMenuItem(Idioma.getMenuDrop());
    m43.setMnemonic(KeyEvent.VK_D);
    m43.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK, true));
    if( getSistema().equals("mac") ) {
       m43.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.META_MASK, true));
    }
    m43.setName("dropMode");

    setMenuRecent();
    sortName = new JMenu(Idioma.getNameOrder());
    sortName.setIcon(nameOrderOk);
    sortName.setMnemonic(Idioma.getMenuMaskByName());
    sortNameNormal = new JMenuItem(Idioma.getNormal());
    sortNameNormal.setName("order-nameNormal");
    sortNameReverse = new JMenuItem(Idioma.getReverse());
    sortNameReverse.setName("order-nameReverse");

    sortDate = new JMenu(Idioma.getLastOrder());
    sortDate.setIcon(dateOrderOk);
    sortDate.setMnemonic(Idioma.getMenuMaskByDate());
    sortDateNormal = new JMenuItem(Idioma.getNormal());
    sortDateNormal.setName("order-lastNormal");
    sortDateReverse = new JMenuItem(Idioma.getReverse());
    sortDateReverse.setName("order-lastReverse");
    
    sortPictureDate = new JMenu(Idioma.getCameraDateOrder());
    sortPictureDate.setIcon(imageOk);
    sortPictureDate.setMnemonic(Idioma.getMenuMaskByPictureDate());
    sortPictureDateNormal = new JMenuItem(Idioma.getNormal());
    sortPictureDateNormal.setName("order-dateCameraNormal");
    sortPictureDateReverse = new JMenuItem(Idioma.getReverse());
    sortPictureDateReverse.setName("order-dateCameraReverse");

    sortSize = new JMenu(Idioma.getSizeOrder());
    sortSize.setIcon(sizeOrderOk);
    sortSize.setMnemonic(Idioma.getMenuMaskBySize());
    sortSizeNormal = new JMenuItem(Idioma.getNormal());
    sortSizeNormal.setName("order-sizeNormal");
    sortSizeReverse = new JMenuItem(Idioma.getReverse());
    sortSizeReverse.setName("order-sizeReverse");

    sortExtension = new JMenu(Idioma.getExtensionOrder());
    sortExtension.setIcon(extensionOrderOk);
    sortExtension.setMnemonic(Idioma.getMenuMaskByExtension());
    sortExtensionNormal = new JMenuItem(Idioma.getNormal());
    sortExtensionNormal.setName("order-extensionNormal");
    sortExtensionReverse = new JMenuItem(Idioma.getReverse());
    sortExtensionReverse.setName("order-extensionReverse");

    sortNumber = new JMenu(Idioma.getNumberOrder());
    sortNumber.setIcon(numberOrderOk);
    sortNumber.setMnemonic(Idioma.getMenuMaskByNumber());
    sortNumberNormal = new JMenuItem(Idioma.getNormal());
    sortNumberNormal.setName("order-numberNormal");
    sortNumberReverse = new JMenuItem(Idioma.getReverse());
    sortNumberReverse.setName("order-numberReverse");

    m11.addActionListener(cc);
    m12.addActionListener(cc);
    m13.addActionListener(cc);
    m14.addActionListener(cc);
    m15.addActionListener(cc);
    m16.addActionListener(cc);
    m17.addActionListener(cc);
    mLog.addActionListener(cc);
    mImport.addActionListener(cc);  

    m21.addActionListener(cc);
    m22.addActionListener(cc);
    m23.addActionListener(cc);
    m24.addActionListener(cc);
    m25.addActionListener(cc);
    m26.addActionListener(cc);

    m31.addActionListener(cc);
    m41.addActionListener(cc);
    m42.addActionListener(cc);
    m43.addActionListener(cc);
    
    sortNameNormal.addActionListener(cc);
    sortNameReverse.addActionListener(cc);
    sortDateNormal.addActionListener(cc);
    sortDateReverse.addActionListener(cc);
    sortPictureDateNormal.addActionListener(cc);
    sortPictureDateReverse.addActionListener(cc);
    sortSizeNormal.addActionListener(cc);
    sortSizeReverse.addActionListener(cc);
    sortExtensionNormal.addActionListener(cc);
    sortExtensionReverse.addActionListener(cc);
    sortNumberNormal.addActionListener(cc);
    sortNumberReverse.addActionListener(cc);

    m1.add(m11);
    m1.addSeparator();
    m1.add(m12);
    m1.add(menuRecent);
    m1.add(m13);
    m1.add(m14);
    m1.addSeparator();
    m1.add(mLog);
    m1.add(mImport);
    m1.addSeparator();
    m1.add(m15);
    m1.add(m16);
    m1.addSeparator();

    m2.add(m21);
    m2.addSeparator();
    m2.add(m25);
    m2.add(m26);
    m2.addSeparator();
    m2.add(m21);
    m2.add(m22);
    m2.addSeparator();
    m2.add(m23);
    m2.add(m24);

    m4.add(m42);
    m4.add(m43);

    if( ! getSistema().equals("mac") ) {
	m1.add(m17);
	m3.add(m31);
	m4.add(m41);
    }

    sorting.add(sortName);
    sorting.add(sortDate);
    sorting.add(sortPictureDate);
    sorting.add(sortSize);
    sorting.add(sortExtension);
    sorting.add(sortNumber);

    sortName.add(sortNameNormal);
    sortName.add(sortNameReverse);
    sortDate.add(sortDateNormal);
    sortDate.add(sortDateReverse);
    sortPictureDate.add(sortPictureDateNormal);
    sortPictureDate.add(sortPictureDateReverse);
    sortSize.add(sortSizeNormal);
    sortSize.add(sortSizeReverse);
    sortExtension.add(sortExtensionNormal);
    sortExtension.add(sortExtensionReverse);
    sortNumber.add(sortNumberNormal);
    sortNumber.add(sortNumberReverse);

    mMenu.add(m1);
    mMenu.add(m2);
    mMenu.add(m4);
    mMenu.add(sorting);
    mMenu.add(m3);

    setJMenuBar(mMenu);
    m16.setEnabled(false);

    if ( getSistema().equals("mac") ) {
	iniciaDrop = (prefs.get(prefDrop, "true"));
    } else {
	iniciaDrop = (prefs.get(prefDrop, "false"));
    }
    if (iniciaDrop.equals("true")) {
	modoDrop = true;
	m43.setSelected(true);
    }
    
    toolNew = new JButton(newOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                this.setBackground(Color.lightGray);
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                this.setBackground(Color.gray);
            } 
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }
        }
        
    };
    toolOpen = new JButton(openOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                this.setBackground(Color.lightGray);
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                this.setBackground(Color.gray);
            } 
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }
        }
        
    };
    toolSave = new JButton(saveOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                this.setBackground(Color.lightGray);
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                this.setBackground(Color.gray);
            } 
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }
        }
        
    };
    toolSaveAs = new JButton(saveAsOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                this.setBackground(Color.lightGray);
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                this.setBackground(Color.gray);
            } 
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }
        }
        
    };
    toolUndo = new JButton(undoOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (isEnabled()) {
                if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                    this.setBackground(Color.lightGray);
                }
                if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                    this.setBackground(Color.gray);
                } 
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }            
        }
        
    };
    toolRedo = new JButton(redoOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (isEnabled()) {
                if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                    this.setBackground(Color.lightGray);
                }
                if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                    this.setBackground(Color.gray);
                } 
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }            
        }
        
    };
    toolUp = new JButton(arrowUpOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                this.setBackground(Color.lightGray);
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                this.setBackground(Color.gray);
            } 
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }
        }
        
    };
    toolDown = new JButton(arrowDownOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                this.setBackground(Color.lightGray);
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                this.setBackground(Color.gray);
            } 
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }
        }
        
    };
    toolTop = new JButton(arrowTopOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                this.setBackground(Color.lightGray);
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                this.setBackground(Color.gray);
            } 
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }
        }
        
    };
    toolBottom = new JButton(arrowBottomOk) {
        @Override
        protected void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
            if (e.getID() == MouseEvent.MOUSE_ENTERED) {
                this.setBackground(Color.lightGray);
            }
            if (e.getID() == MouseEvent.MOUSE_EXITED) {
                this.setBackground(null);                
            }            
            if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                this.setBackground(Color.gray);
            } 
            if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                this.setBackground(null);                
            }
        }
        
    };
    
    toolNew.setUI((ButtonUI) BasicButtonUI.createUI(toolNew));  
    toolOpen.setUI((ButtonUI) BasicButtonUI.createUI(toolOpen));  
    toolSave.setUI((ButtonUI) BasicButtonUI.createUI(toolSave));  
    toolSaveAs.setUI((ButtonUI) BasicButtonUI.createUI(toolSaveAs));  
    toolUndo.setUI((ButtonUI) BasicButtonUI.createUI(toolUndo));  
    toolRedo.setUI((ButtonUI) BasicButtonUI.createUI(toolRedo));  
    toolUp.setUI((ButtonUI) BasicButtonUI.createUI(toolUp));  
    toolDown.setUI((ButtonUI) BasicButtonUI.createUI(toolDown));  
    toolTop.setUI((ButtonUI) BasicButtonUI.createUI(toolTop));  
    toolBottom.setUI((ButtonUI) BasicButtonUI.createUI(toolBottom));  
    
    toolNew.setPreferredSize(new Dimension(15,10));
    toolNew.setName("new");
    toolNew.addActionListener(cc);

    toolOpen.setName("open");
    toolOpen.addActionListener(cc);

    toolSave.setName("save");
    toolSave.addActionListener(cc);

    toolSaveAs.setName("saveAs");
    toolSaveAs.addActionListener(cc);

    toolUndo.setName("undo");
    toolUndo.addActionListener(cc);
    toolUndo.addMouseListener(cc);

    toolRedo.setName("redo");
    toolRedo.addActionListener(cc);
    toolRedo.addMouseListener(cc);

    toolUp.setName("popUpOne");
    toolUp.addActionListener(cc);

    toolDown.setName("popDownOne");
    toolDown.addActionListener(cc);

    toolTop.setName("popUp");
    toolTop.addActionListener(cc);

    toolBottom.setName("popDown");
    toolBottom.addActionListener(cc);

    toolBar = new JToolBar(){
	@Override
	public boolean isBorderPainted() {
	    super.isBorderPainted();
	    return false;
	}
    };
    toolBar.setFloatable(false);
//    toolBar.setMargin(new Insets(5,3,5,3));
    toolBar.setOpaque(false);
    toolBar.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
    toolBar.putClientProperty(Options.HEADER_STYLE_KEY,HeaderStyle.BOTH);
    if( SystemInfo.isMacFullWindowContentSupported ) {
        toolBar.add(Box.createHorizontalStrut(70)); 
    }
    toolBar.add(toolNew);
    toolBar.add(toolOpen);
    toolBar.add(toolSave);
    toolBar.add(toolSaveAs);
    toolBar.addSeparator(new Dimension(70,10));
    toolBar.add(toolUndo);
    toolBar.add(toolRedo);
    toolBar.addSeparator(new Dimension(70,10));
    toolBar.add(toolUp);
    toolBar.add(toolDown);
    toolBar.add(toolTop);
    toolBar.add(toolBottom);
    
    for (Component c : toolBar.getComponents()) {
        c.setBackground(null);
    }
    
    popAll = new JMenuItem (Idioma.getMenuSelectAll());
    popInvert = new JMenuItem (Idioma.getMenuInvSel());
    popFiles = new JMenuItem (Idioma.getMenuSelFile());
    popFolders = new JMenuItem (Idioma.getMenuSelFolder());
    popAll.addActionListener(new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e) {
	    seleccionaTodo();
	}
    });
    popInvert.addActionListener((ActionEvent e) -> {
        invertirSeleccion();
    });
    popFiles.addActionListener((ActionEvent e) -> {
        seleccionaArchivos();
    });
    popFolders.addActionListener((ActionEvent e) -> {
        seleccionaCarpetas();
    });
    popMenu = new JPopupMenu();

    popMenu.add(popAll);
    popMenu.add(popInvert);
    popMenu.addSeparator();
    popMenu.add(popFiles);
    popMenu.add(popFolders);

    if (separador.equals("/")) vrenamerFolder = ".vRenamerOptions";
    else vrenamerFolder = "vRenamerOptions";

    undoManager_= new UndoManager();
    undoSupport_ = new UndoableEditSupport();
    undoSupport_.addUndoableEditListener(cc);
    refreshUndoRedo();

    ruta = (prefs.get(prefDirectorio, System.getProperty("user.home")+separador));
    ruta = chequeaRuta(ruta);
    rutaRenombrados = ruta.toString();

//    ToolTipManager.sharedInstance().setInitialDelay(10);
    ToolTipManager.sharedInstance().setDismissDelay(2000000);

    fotoArchivoActual = new File("");
    cancelarCopia = false;
    noPasarFiltro = false;
    reseteaRenombrados = true;
    modoLog = false;
    okSeleccion = new int[0];
    mBusca = new MotorBusca(Idioma);
 
    pnlArchivos = new JPanel ();
    pnlArchivos.setLayout(new BoxLayout(pnlArchivos ,BoxLayout.Y_AXIS));
    pnlArchivos.setAlignmentX(Component.CENTER_ALIGNMENT);

    if (modoDrop) {
	Archivos = new StringBuffer[0];
	archivosOriginales = new File[0];
    }
    tomaFicheros(filtrado, false, true, false, false, Idioma);
    eligeSeleccionCheck();
    panelModelo();
    panelArchivos();
    if (modoDrop) {
	Renombrados = new StringBuffer[0];
	archivosRenombrados = new File[0];
    }
    else {
	Renombrados = Arrays.copyOf(Archivos, Archivos.length);
    }
    pnlRenombrados = new JPanel (new GridLayout(1,1));
    modeloRenombrados();
    creaPanelRe();
    panelRenombrados();
    pnlDivide = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,true,pnlArchivos,pnlRenombrados) {
	// overridden to mape divider snap while dragging
        @Override
	public void setDividerLocation(int location){
	    Dimension prefSize = getLeftComponent().getPreferredSize();
	    int pref = (getOrientation()==HORIZONTAL_SPLIT ? prefSize.width : prefSize.height) + getDividerSize()/2;
	    super.setDividerLocation(Math.abs(pref-location)<=10 ? pref : location);
	}
    };
    pnlDivide.setOneTouchExpandable(true);
    pnlDivide.setDividerSize(5);
    pnlDivide.setBorder(null);
    pnlArchivos.setMinimumSize(new Dimension(50,50));
    pnlRenombrados.setMinimumSize(new Dimension(50,50));

    unidades=mBusca.unidades(getSistema());

    iniciaComboCarpeta = (prefs.get(prefComboCarpeta, "0"));
    int intComboCarpeta = Integer.parseInt(iniciaComboCarpeta);

    ckCopiaCarpeta = new JCheckBox();
    ckCopiaCarpeta.setName("copiaCarpeta");
    ckCopiaCarpeta.addActionListener(cc);
    String[] opcionesComboCarpeta = {Idioma.getCopyFolder(),Idioma.getMoveFolder()};
    comboCarpeta = new JComboBox<> (opcionesComboCarpeta);
    setFont(comboCarpeta, 11, Font.PLAIN);
    comboCarpeta.setRenderer(new RenderCombos());
    comboCarpeta.setName("comboCarpeta");
    comboCarpeta.setSelectedIndex(intComboCarpeta);
    comboCarpeta.addPopupMenuListener(cc);

    btnCarpeta = getButton("",iconFolder,false);
    btnCarpeta.setName("carpeta");
    btnCarpeta.addActionListener(cc);
    btnCarpeta.setPreferredSize(new Dimension(35,22));
    btnCarpeta.setMaximumSize(new Dimension(35,22));

    pnlCarpeta = new JPanel();
    pnlCarpeta.setLayout(new BoxLayout(pnlCarpeta,BoxLayout.X_AXIS));
    pnlCarpeta.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlCarpeta.setBackground(Color.lightGray);
    pnlCarpeta.add(ckCopiaCarpeta);
    pnlCarpeta.add(Box.createGlue());
    pnlCarpeta.add(comboCarpeta);
    pnlCarpeta.add(Box.createGlue());
    pnlCarpeta.add(btnCarpeta);

    ckOpcionDos = new JCheckBox(Idioma.getExtension() + " ");
    setFont(ckOpcionDos, 11, Font.PLAIN);
//    ckOpcionDos.setForeground(Color.white);

    ckOpcionDos.setName("extension");
    ckOpcionDos.addActionListener(cc);
    txtExtension = new JTextField(4);
    txtExtension.setFont(new Font("Arial", Font.PLAIN, 11));
    txtExtension.setEnabled(false);
    txtExtension.setPreferredSize(new Dimension(130,21));
    txtExtension.setMaximumSize(new Dimension(130,21));
    txtExtension.setName("txtExtension");
    txtExtension.addKeyListener(cc);
    pnlOpcionDos = new JPanel();
    pnlOpcionDos.setLayout(new BoxLayout(pnlOpcionDos,BoxLayout.X_AXIS));
    pnlOpcionDos.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlOpcionDos.setBackground(Color.lightGray);
    pnlOpcionDos.add(ckOpcionDos);
    pnlOpcionDos.add(Box.createGlue());
    pnlOpcionDos.add(txtExtension);

    ckOpcionTres = new JCheckBox(Idioma.getSeparator() + " ");
    ckOpcionTres.setSelected(true);
    setFont(ckOpcionTres, 11, Font.PLAIN);
//    ckOpcionTres.setForeground(Color.white);
    ckOpcionTres.setName("separador");
    ckOpcionTres.addActionListener(cc);
    String[] separaOpciones = {"_","-","{ }",separador};
    jSepara = new JComboBox(separaOpciones);
    jSepara.setEditable(true);
    jSepara.setName("separaCombo");
    jSepara.setPreferredSize(new Dimension(53,23));
    jSepara.setMaximumSize(new Dimension(53,23));
    jSepara.setRenderer(new RenderCombos());
    jSepara.addPopupMenuListener(cc);
    jSepara.getEditor().getEditorComponent().addKeyListener(cc);
    jSepara.getEditor().getEditorComponent().setName("separaTexto");
    jSepara.getEditor().getEditorComponent().setFont(new Font("Arial", Font.BOLD, 10));
    pnlOpcionTres = new JPanel();
    pnlOpcionTres.setLayout(new BoxLayout(pnlOpcionTres,BoxLayout.X_AXIS));
    pnlOpcionTres.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlOpcionTres.setBackground(Color.lightGray);
    pnlOpcionTres.add(ckOpcionTres);
    pnlOpcionTres.add(Box.createGlue());
    pnlOpcionTres.add(jSepara);


    pnlExtras = new JPanel();
    pnlExtras.setLayout(new BoxLayout(pnlExtras,BoxLayout.Y_AXIS));
    pnlExtras.setBorder(new CompoundBorder (new EmptyBorder(2,2,2,2), BorderFactory.createEtchedBorder()));
    pnlExtras.setBackground(Color.lightGray);
    pnlExtras.add(pnlCarpeta);
    pnlExtras.add(Box.createRigidArea(new Dimension(0,10)));
    pnlExtras.add(pnlOpcionDos);
    pnlExtras.add(Box.createRigidArea(new Dimension(0,10)));
    pnlExtras.add(pnlOpcionTres);

    pnlExtrasBorde = new JPanel();
    pnlExtrasBorde.setLayout(new BoxLayout(pnlExtrasBorde,BoxLayout.X_AXIS));
    pnlExtrasBorde.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlExtrasBorde.setBackground(Color.lightGray);
    pnlExtrasBorde.add(pnlExtras);
    pnlExtrasBorde.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

    pnlExtrasTotal = new JPanel(new BorderLayout());
    pnlExtrasTotal.add(pnlExtrasBorde,"North");
    pnlExtrasTotal.setBackground(Color.lightGray);
    
    pnlCentral = new JPanel(new BorderLayout());
    pnlCentral.add(pnlDivide,"Center");
    pnlCentral.add(pnlExtrasTotal,"East");

    btnRutaIzq = new JButton(Idioma.getPath()){
      @Override
      protected void processMouseEvent(MouseEvent e) {
	super.processMouseEvent(e);
	if (e.getID() == MouseEvent.MOUSE_ENTERED) {
	  this.setOpaque(true);
	  this.setContentAreaFilled(true);
	  this.setBackground(Color.LIGHT_GRAY);
	}
	if (e.getID() == MouseEvent.MOUSE_EXITED) {
	  this.setOpaque(false);
	  this.setBorderPainted(false);
	  this.setContentAreaFilled(false);
	}
      }
    };
    btnRutaIzq.setName("path");
    setFont(btnRutaIzq,10,Font.BOLD);
    btnRutaIzq.setPreferredSize(new Dimension (70,20));
    btnRutaIzq.setOpaque(false);
    btnRutaIzq.setContentAreaFilled(false);
    btnRutaIzq.setBorderPainted(false);
    btnRutaIzq.addActionListener(cc);

    jRuta = new JComboBox(unidades);
    jRuta.setName("rutaCombo");
    jRuta.setEditable(true);
    jRuta.setPreferredSize(new Dimension(380,20));
    jRuta.setMaximumSize(new Dimension(2000,20));
    jRuta.addPopupMenuListener(cc);
    jRuta.getEditor().getEditorComponent().addKeyListener(cc);
    jRuta.getEditor().getEditorComponent().setName("jRuta");
    jRuta.getEditor().getEditorComponent().setFont(new Font("Helvetica", Font.PLAIN, 11));    
    jRuta.addItem(ruta);
    jRuta.setSelectedIndex(jRuta.getItemCount()-1);
    jRuta.setRenderer(new RenderUnidades(getSistema(),jRuta.getItemCount()));

    lblFiltro = new JLabel(Idioma.getFiltro());
    setFont(lblFiltro,11,Font.PLAIN);

    String[] camposFiltro = {" ", Idioma.getFilterImg(), Idioma.getFilterAudio(), Idioma.getFilterVideo(), "-- Office"};
    comboFiltro = new JComboBox(camposFiltro);
    comboFiltro.addMouseListener(cc);
    comboFiltro.setToolTipText(Idioma.getTipFilter());
    comboFiltro.setEditable(true);
    comboFiltro.setName("comboFiltro");
    comboFiltro.setPreferredSize(new Dimension(110,22));
    comboFiltro.setMaximumSize(new Dimension(110,22));
    comboFiltro.setRenderer(new RenderCombos());
    comboFiltro.addPopupMenuListener(cc);
    jFiltro = (JTextField)comboFiltro.getEditor().getEditorComponent();
    jFiltro.addKeyListener(cc);
    jFiltro.setName("jFiltro");
    setFont(jFiltro, 10, Font.PLAIN);
    jFiltro.setText("");

    ckCase = new JCheckBox("Case", true);
    ckCase.setName("Case");
    ckCase.addActionListener(cc);
    ckCase.addMouseListener(cc);
    ckCase.setPreferredSize(new Dimension(75,10));
    ckCase.setMaximumSize(new Dimension(75,10));
    ckCase.setIcon( checkBoxDisabledOk );
    ckCase.setSelectedIcon( checkBoxEnabledOk );
    setFont(ckCase,9,Font.PLAIN);
    ckCase.setToolTipText(Idioma.getTipCase());

    ckExcluye = new JCheckBox(Idioma.getExclude());
    ckExcluye.setName("Case");
    ckExcluye.addActionListener(cc);
    ckExcluye.addMouseListener(cc);
    ckExcluye.setIcon( checkBoxDisabledOk );
    ckExcluye.setSelectedIcon( checkBoxEnabledOk );
    ckExcluye.setPreferredSize(new Dimension(75,10));
    ckExcluye.setMaximumSize(new Dimension(75,10));
    setFont(ckExcluye,9,Font.PLAIN);
    ckExcluye.setToolTipText(Idioma.getTipExclude());

    ckRecursivo = new JCheckBox("Recursiv", false);
    ckRecursivo.setName("Recursivo");
    ckRecursivo.addActionListener(cc);
    ckRecursivo.addMouseListener(cc);
    ckRecursivo.setPreferredSize(new Dimension(75,10));
    ckRecursivo.setMaximumSize(new Dimension(75,10));
    ckRecursivo.setIcon( checkBoxDisabledOk );
    ckRecursivo.setSelectedIcon( checkBoxEnabledOk );
    setFont(ckRecursivo,9,Font.PLAIN);
    ckRecursivo.setToolTipText(Idioma.getTipRecursive());

    opcionesFiltroDer = new JPanel(new GridLayout(2,2)) {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length;
	  for (int i = 0; i < count; i++) {
	      components[i].setEnabled(enabled);
          }
        }          
      }
    };
    opcionesFiltroDer.add(ckCase);
    opcionesFiltroDer.add(ckRecursivo);
    opcionesFiltroDer.add(ckExcluye);
    opcionesFiltroDer.setPreferredSize(new Dimension(155,25));
    opcionesFiltroDer.setMaximumSize(new Dimension(155,25));

    btnLimpiar = getButton("",cleanOk,false);
    btnLimpiar.setToolTipText(Idioma.getTipClean());
    btnLimpiar.setName("Limpiar");
    btnLimpiar.setPreferredSize(new Dimension(40,23));
    btnLimpiar.setMaximumSize(new Dimension(40,23));
    btnLimpiar.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnLimpiar.addActionListener(cc);

    btnPreview = getButton("",previewOk,false);
    btnPreview.setToolTipText(Idioma.getTipPreview());
    btnPreview.setFont(new Font("Arial", Font.PLAIN, 11));
    btnPreview.setName("Previsualizar");
    btnPreview.setPreferredSize(new Dimension(40,23));
    btnPreview.setMaximumSize(new Dimension(40,23));
    btnPreview.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnPreview.addActionListener(cc);

    comboSelecAplica = new JButton("▼") {
      @Override
      protected void processMouseEvent(MouseEvent e) {
	  super.processMouseEvent(e);
	  if (e.getID() == MouseEvent.MOUSE_ENTERED) {
	    this.setBorder(BorderFactory.createLineBorder(Color.RED));
	    btnPreview.setBorder(BorderFactory.createLineBorder(Color.RED));	    
	    ToolTipManager.sharedInstance().setEnabled(true);
	  }
	  if (e.getID() == MouseEvent.MOUSE_EXITED) {
	    this.setBorder(BorderFactory.createLineBorder(Color.PINK));
	    btnPreview.setBorder(BorderFactory.createLineBorder(Color.PINK));	    
	  }
      }
    };
    comboSelecAplica.setBorder(BorderFactory.createLineBorder(Color.PINK));
    comboSelecAplica.setOpaque(false);
    comboSelecAplica.setContentAreaFilled(false);
    setFont(comboSelecAplica, 8, Font.PLAIN);
    comboSelecAplica.setPreferredSize(new Dimension(16,23));	
    comboSelecAplica.setMaximumSize(new Dimension(16,23));	
    
    final JPopupMenu opcionesSelec = new JPopupMenu();
    opcionesSelec.setBackground(Color.white);
    final JMenuItem itemSelectFile = new JMenuItem(Idioma.getSelectFile());
    itemSelectFile.addMouseListener(new MouseAdapter() {
        @Override
	public void mousePressed(MouseEvent e) {
	    opcionSelec = 1;
	    seleccionadosNuevo();
	}
    });
    setFont(itemSelectFile, 11, Font.PLAIN);

    final JMenuItem itemSelectExtension = new JMenuItem(Idioma.getSelectExtension());
    itemSelectExtension.addMouseListener(new MouseAdapter() {
        @Override
	public void mousePressed(MouseEvent e) {
	    opcionSelec = 2;
	    seleccionadosNuevo();
	}
    });
    setFont(itemSelectExtension, 11, Font.PLAIN);

    final JMenuItem itemSelectWhole = new JMenuItem(Idioma.getSelectWhole());
    itemSelectWhole.addMouseListener(new MouseAdapter() {
        @Override
	public void mousePressed(MouseEvent e) {
	    opcionSelec = 3;
	    seleccionadosNuevo();
	}
    });
    setFont(itemSelectWhole, 11, Font.PLAIN);


    opcionesSelec.add(itemSelectFile);
    opcionesSelec.add(itemSelectExtension);
    opcionesSelec.add(itemSelectWhole);
    comboSelecAplica.addMouseListener(new MouseAdapter() {
        @Override
	public void mousePressed(MouseEvent e) {
	    JButton fuente = (JButton) e.getSource();
	    opcionesSelec.show(e.getComponent(), e.getX(), e.getY());
	    SwingUtilities.invokeLater(() -> {
                switch (opcionSelec) {
                    case 1:
                        MenuSelectionManager.defaultManager().setSelectedPath(new MenuElement[]{opcionesSelec, itemSelectFile});
                        break;
                    case 2:
                        MenuSelectionManager.defaultManager().setSelectedPath(new MenuElement[]{opcionesSelec, itemSelectExtension});
                        break;
                    case 3:
                        MenuSelectionManager.defaultManager().setSelectedPath(new MenuElement[]{opcionesSelec, itemSelectWhole});
                        break;
                }
            });
	}
    });
    opcionesSelec.setPopupSize(160,60); 
    btnAplicar = getButton("",aplicarBigBWOk,false);
    btnAplicar.setToolTipText(Idioma.getTipApply());
    btnAplicar.setName("Aplicar");
    btnAplicar.setPreferredSize(new Dimension(55,43));
    btnAplicar.setMaximumSize(new Dimension(55,43));
    btnAplicar.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnAplicar.addActionListener(cc);
    btnAplicar.setEnabled(false);
    btnAplicar.setContentAreaFilled(true);
    btnAplicar.setBackground(Color.WHITE);

    btnActualizar = getButton("",actualizaOk,false);
    btnActualizar.setToolTipText(Idioma.getTipReload());
    btnActualizar.setName("Actualizar");
    btnActualizar.setPreferredSize(new Dimension(40,23));
    btnActualizar.setMaximumSize(new Dimension(40,23));
    btnActualizar.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnActualizar.addActionListener(cc);

    pnlNavegador = new JPanel();
    pnlNavegador.setLayout(new BoxLayout(pnlNavegador,BoxLayout.X_AXIS));
    pnlNavegador.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlNavegador.setBorder(new EmptyBorder(0,5,0,5));
    actualizaNavegador();

    pnlControlesSuperior = new JPanel();
    pnlControlesSuperior.setLayout(new BoxLayout(pnlControlesSuperior,BoxLayout.X_AXIS));
    pnlControlesSuperior.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlControlesSuperior.add(btnRutaIzq);
    pnlControlesSuperior.add(Box.createRigidArea(new Dimension(5,0)));
    pnlControlesSuperior.add(jRuta);
    pnlControlesSuperior.add(Box.createRigidArea(new Dimension(10,0)));
    pnlControlesSuperior.add(lblFiltro);
    pnlControlesSuperior.add(Box.createRigidArea(new Dimension(5,0)));
    pnlControlesSuperior.add(comboFiltro);
    pnlControlesSuperior.add(Box.createRigidArea(new Dimension(5,0)));
    pnlControlesSuperior.add(opcionesFiltroDer);
    pnlControlesSuperior.add(Box.createRigidArea(new Dimension(5,0)));
    pnlControlesSuperior.add(btnActualizar);
    pnlControlesSuperior.add(Box.createRigidArea(new Dimension(5,0)));
    pnlControlesSuperior.add(btnLimpiar);
    pnlControlesSuperior.add(Box.createRigidArea(new Dimension(20,0)));
    pnlControlesSuperior.add(btnPreview);
    pnlControlesSuperior.add(comboSelecAplica);

    pnlOtrosDer = new JPanel();
    pnlOtrosDer.setLayout(new BoxLayout(pnlOtrosDer,BoxLayout.Y_AXIS));

    pnlTexto = new JPanel ();
    pnlTexto.setLayout(new BoxLayout(pnlTexto,BoxLayout.Y_AXIS));
    pnlTexto.add(Box.createRigidArea(new Dimension(0,5)));
    pnlTexto.add(pnlControlesSuperior);
    pnlTexto.add(Box.createRigidArea(new Dimension(0,5)));
    pnlTexto.add(pnlNavegador);
    pnlTexto.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));


    pnlHerramientasParcial = new JPanel(new BorderLayout());
    pnlHerramientasParcial.add(pnlTexto,"Center");
    pnlHerramientasParcial.add(btnAplicar,"East");

    pnlHerramientasNorte = new JPanel (new BorderLayout());
//    if ( ! getSistema().equals("mac")) {
	pnlHerramientasNorte.add(toolBar,"North");
//    }
    pnlHerramientasNorte.add(pnlHerramientasParcial,"South");

    opSustituciones = new JRadioButton(Idioma.getOpCombina(),true);
    opInserta = new JRadioButton(Idioma.getOpInserta());
    opElimina = new JRadioButton(Idioma.getOpElimina());

    opNumeros = new JCheckBox(Idioma.getOpNumeros());  
    opReemplaza = new JCheckBox(Idioma.getOpReemplaza());
    opNormaliza = new JCheckBox(Idioma.getOpNormaliza());
    opCapitaliza = new JCheckBox(Idioma.getOpCapitaliza());
    opAtributos = new JCheckBox(Idioma.getOpAtributos());
    opAleatorio = new JCheckBox(Idioma.getOpAleatorio());

    opRenombra = new ButtonGroup();
    opRenombra.add(opSustituciones);
    opRenombra.add(opInserta);
    opRenombra.add(opElimina);

    opSustituciones.addActionListener(cc);
    opInserta.addActionListener(cc);
    opElimina.addActionListener(cc);

    opNumeros.addActionListener(cc);
    opReemplaza.addActionListener(cc);
    opNormaliza.addActionListener(cc);
    opCapitaliza.addActionListener(cc);
    opAtributos.addActionListener(cc);
    opAleatorio.addActionListener(cc);    

    opSustituciones.setName("combinadas");
    opInserta.setName("inserta");
    opElimina.setName("elimina");

    opNumeros.setName("numeros");
    opReemplaza.setName("reemplaza");
    opNormaliza.setName("normaliza");
    opCapitaliza.setName("capitaliza");
    opAtributos.setName("atributos");
    opAleatorio.setName("aleatorio");    

    activaAnterior = "Combinadas";

    pnlBuscaTotal = new JPanel();
    pnlBuscaTotal.setLayout(new BoxLayout(pnlBuscaTotal,BoxLayout.Y_AXIS));
    
    pnlSustiOpciones = new JPanel();
    pnlSustiOpciones.setLayout(new BoxLayout(pnlSustiOpciones,BoxLayout.Y_AXIS));
    pnlSustiOpciones.setAlignmentY(Component.LEFT_ALIGNMENT);
    pnlSustiOpciones.add(opSustituciones);
    pnlSustiOpciones.add(Box.createRigidArea(new Dimension(0,5)));
    pnlSustiOpciones.add(pnlBuscaTotal);
    pnlSustiOpciones.setBorder(new CompoundBorder(BorderFactory.createRaisedBevelBorder(),new EmptyBorder(10,10,10,5)));
    
    pnlSustituciones = new JPanel();
    pnlSustituciones.setLayout(new BoxLayout(pnlSustituciones,BoxLayout.X_AXIS));
    pnlSustituciones.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlSustituciones.add(pnlSustiOpciones);
    pnlSustituciones.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getTitleRename()),new EmptyBorder(10,10,10,10)));

    scrollSustituciones = new JScrollPane(pnlSustituciones);
    scrollSustituciones.setBorder(null);
    scrollSustituciones.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    lblInsertar = new JLabel(" " + Idioma.getMainIn() + " ");
    setFont(lblInsertar,11,Font.PLAIN);
    smIns = new SpinnerNumberModel(1,1,9999,1);

    spnInsertar = new JSpinner(smIns);
    spnInsertar.setFont(new Font("Helvetica", Font.PLAIN, 10));
    spnInsertar.setPreferredSize(new Dimension(43,23));
    spnInsertar.setMaximumSize(new Dimension(43,23));
    spnInsertar.setName("spnInsertar");
    spnInsertar.addChangeListener(cc);
    ((JSpinner.DefaultEditor)spnInsertar.getEditor()).getTextField().setName("spnInsertarEditor");
    ((JSpinner.DefaultEditor)spnInsertar.getEditor()).getTextField().addKeyListener(cc);

    desdeDerechaInserta = new JCheckBox(Idioma.getMainRight());
    setFont(desdeDerechaInserta,9,Font.PLAIN);
    desdeDerechaInserta.setName("desdeDerechaInserta");
    desdeDerechaInserta.addActionListener(cc);

    pnlInsertar = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length;
	  for (int i = 1; i < count; i++)
	  components[i].setEnabled(enabled);
	}
      }
    };
    pnlInsertar.setLayout(new BoxLayout(pnlInsertar,BoxLayout.X_AXIS));
    pnlInsertar.setAlignmentX(Component.LEFT_ALIGNMENT);
    txtInsertar = new JTextField(13);
    txtInsertar.setPreferredSize(new Dimension(225,23));
    txtInsertar.setMaximumSize(new Dimension(600,23));
    txtInsertar.setName("txtInsertar");
    txtInsertar.addKeyListener(cc);

    pnlInsertar.add(opInserta);
    pnlInsertar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlInsertar.add(txtInsertar);
    pnlInsertar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlInsertar.add(lblInsertar);
    pnlInsertar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlInsertar.add(spnInsertar);
    pnlInsertar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlInsertar.add(desdeDerechaInserta);
    desdeInsertar = new JLabel(" " + Idioma.getMainPosition() + " ");
    setFont(desdeInsertar,11,Font.PLAIN);

    smDesde = new SpinnerNumberModel(1,1,9999,1);
    spnDesde = new JSpinner(smDesde);
    spnDesde.setPreferredSize(new Dimension(43,23));
    spnDesde.setMaximumSize(new Dimension(43,23));
    spnDesde.setFont(new Font("Helvetica", Font.PLAIN, 10));
    spnDesde.setName("spnDesde");
    spnDesde.addChangeListener(cc);
    ((JSpinner.DefaultEditor)spnDesde.getEditor()).getTextField().setName("spnDesdeEditor");
    ((JSpinner.DefaultEditor)spnDesde.getEditor()).getTextField().addKeyListener(cc);

    hastaInsertar = new JLabel(" " + Idioma.getMainThrough() + " ");
    setFont(hastaInsertar,11,Font.PLAIN);
    smHasta = new SpinnerNumberModel(5,1,9999,1);
    spnHasta = new JSpinner(smHasta);
    spnHasta.setPreferredSize(new Dimension(43,23));
    spnHasta.setMaximumSize(new Dimension(43,23));
    spnHasta.setFont(new Font("Helvetica", Font.PLAIN, 10));
    spnHasta.setName("spnHasta");
    spnHasta.addChangeListener(cc);
    ((JSpinner.DefaultEditor)spnHasta.getEditor()).getTextField().setName("spnHastaEditor");
    ((JSpinner.DefaultEditor)spnHasta.getEditor()).getTextField().addKeyListener(cc);

    desdeDerecha = new JCheckBox(Idioma.getMainRight());
    setFont(desdeDerecha,9,Font.PLAIN);
    desdeDerecha.setName("desdeDerecha");
    desdeDerecha.addActionListener(cc);

    pnlEliminar = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length;
	  for (int i = 1; i < count; i++)
	  components[i].setEnabled(enabled);
	}
      }
    };
    pnlEliminar.setLayout(new BoxLayout(pnlEliminar,BoxLayout.X_AXIS));
    pnlEliminar.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlEliminar.add(opElimina);
    pnlEliminar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlEliminar.add(desdeInsertar);
    pnlEliminar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlEliminar.add(spnDesde);
    pnlEliminar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlEliminar.add(hastaInsertar);
    pnlEliminar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlEliminar.add(spnHasta);
    pnlEliminar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlEliminar.add(desdeDerecha);

    pnlInserciones = new JPanel();
    pnlInserciones.setLayout(new BoxLayout(pnlInserciones,BoxLayout.Y_AXIS));
    pnlInserciones.add(pnlInsertar);
    Dimension minSize = new Dimension(5, 90);
    Dimension prefSize = new Dimension(5, 90);
    Dimension maxSize = new Dimension(Short.MAX_VALUE, 90);
    pnlInserciones.add(new Box.Filler(minSize, prefSize, maxSize));    
    pnlInserciones.add(pnlEliminar);
    pnlInserciones.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getTitleRemove()),new EmptyBorder(35,10,10,10)));

    pnlSur = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,true,scrollSustituciones,pnlInserciones) {
	// overridden to mape divider snap while dragging
        @Override
	public void setDividerLocation(int location){
	    Dimension prefSize = getLeftComponent().getPreferredSize();
	    int pref = (getOrientation()==HORIZONTAL_SPLIT ? prefSize.width : prefSize.height) + getDividerSize()/2;
	    super.setDividerLocation(Math.abs(pref-location)<=10 ? pref : location);
	}
    };
    pnlSur.setDividerSize(5);
    pnlSur.setEnabled(true);
    pnlSur.setOneTouchExpandable(true);
    pnlSur.setBackground(Color.WHITE);

    pnlInserciones.setMinimumSize(new Dimension (400,50));
    pnlSustituciones.setMinimumSize(new Dimension (400,50));
    scrollSustituciones.setMinimumSize(new Dimension (400,50));

    String[] sNumeros = {Idioma.getOpNormaCeros(), Idioma.getOpRenumber()};
    jNumeros = new JComboBox(sNumeros);
    jNumeros.setPreferredSize(new Dimension(320,22));
    jNumeros.setMaximumSize(new Dimension(320,22));
    setFont(jNumeros, 11, Font.PLAIN);
    jNumeros.setRenderer(new RenderCombos());
    jNumeros.setName("jNumeros");
    jNumeros.addPopupMenuListener(cc);

    spNormaPosicion = new SpinnerNumberModel(1,1,100,1);
    normaPosicion = new JSpinner(spNormaPosicion);
    normaPosicion.setName("normaPosicion");
    normaPosicion.addChangeListener(cc);
    ((JSpinner.DefaultEditor)normaPosicion.getEditor()).getTextField().setName("normaPosicionEditor");
    ((JSpinner.DefaultEditor)normaPosicion.getEditor()).getTextField().addKeyListener(cc);

    spNormaCeros = new SpinnerNumberModel(1,1,18,1);
    normaCeros = new JSpinner(spNormaCeros);
    normaCeros.setName("normaCeros");
    normaCeros.addChangeListener(cc);
    ((JSpinner.DefaultEditor)normaCeros.getEditor()).getTextField().setName("normaCerosEditor");
    ((JSpinner.DefaultEditor)normaCeros.getEditor()).getTextField().addKeyListener(cc);

    spNumerosEn = new SpinnerNumberModel(1,0,9999,1);
    numerosEn = new JSpinner(spNumerosEn);
    numerosEn.setName("numerosPosicion");
    numerosEn.addChangeListener(cc);
    ((JSpinner.DefaultEditor)numerosEn.getEditor()).getTextField().setName("numerosEnEditor");
    ((JSpinner.DefaultEditor)numerosEn.getEditor()).getTextField().addKeyListener(cc);

    spNumerosSalto = new SpinnerNumberModel(1,1,100,1);
    numerosSalto = new JSpinner(spNumerosSalto);
    numerosSalto.setName("numerosSalto");
    numerosSalto.addChangeListener(cc);
    ((JSpinner.DefaultEditor)numerosSalto.getEditor()).getTextField().setName("numerosSaltoEditor");
    ((JSpinner.DefaultEditor)numerosSalto.getEditor()).getTextField().addKeyListener(cc);

    spNumerosPosicion = new SpinnerNumberModel(1,1,100,1);
    numerosPosicion = new JSpinner(spNumerosPosicion);
    numerosPosicion.setName("numerosPosicion");
    numerosPosicion.addChangeListener(cc);
    ((JSpinner.DefaultEditor)numerosPosicion.getEditor()).getTextField().setName("numerosPosicionEditor");
    ((JSpinner.DefaultEditor)numerosPosicion.getEditor()).getTextField().addKeyListener(cc);

    pnlNumeros = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length;
	  for (int i = 1; i < count; i++)
	  components[i].setEnabled(enabled);
	}
      }
    };
    pnlNumeros.setLayout(new BoxLayout(pnlNumeros,BoxLayout.X_AXIS));
    pnlNumeros.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlNumeros.add(opNumeros);
    pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
    pnlNumeros.add(jNumeros);
    numerosBusca();

    txtReemplazaUno = new JTextField(10);
    txtReemplazaUno.setToolTipText(Idioma.getTipReplace());
    txtReemplazaUno.setPreferredSize(new Dimension(220,22));
    txtReemplazaUno.setMaximumSize(new Dimension(920,22));
    txtReemplazaUno.setName("txtReemplazaUno");
    txtReemplazaUno.addKeyListener(cc);
    txtReemplazaUno.addMouseListener(cc);

    lblReemplaza = new JLabel(" " + Idioma.getWith() + " ");
    txtReemplazaDos = new JTextField(10);
    txtReemplazaDos.setToolTipText(Idioma.getTipCapture());
    txtReemplazaDos.setPreferredSize(new Dimension(220,22));
    txtReemplazaDos.setMaximumSize(new Dimension(920,22));
    txtReemplazaDos.setName("txtReemplazaDos");
    txtReemplazaDos.addKeyListener(cc);
    txtReemplazaDos.addMouseListener(cc);

    String[] cModos = {Idioma.getModoAll(),Idioma.getModoFirst()};
    cMode = new JWidePopupComboBox(cModos);
    cMode.setPreferredWidth(40);
    setFont(cMode, 11, Font.PLAIN);
    cMode.setPreferredSize(new Dimension(20,16));
    cMode.setMaximumSize(new Dimension(10,16));
    cMode.setRenderer(new RenderCombos());
    cMode.setName("cMode");
    cMode.addPopupMenuListener(cc);

    pnlReemplaza = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length;
	  for (int i = 1; i < count; i++)
	  components[i].setEnabled(enabled);
	}
      }
    };
    pnlReemplaza.setLayout(new BoxLayout(pnlReemplaza,BoxLayout.X_AXIS));
    pnlReemplaza.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlReemplaza.add(opReemplaza);
    pnlInsertar.add(Box.createRigidArea(new Dimension(5,0)));
    pnlReemplaza.add(txtReemplazaUno);
    pnlReemplaza.add(lblReemplaza);
    pnlReemplaza.add(txtReemplazaDos);
    pnlReemplaza.add(Box.createRigidArea(new Dimension(5,0)));
    pnlReemplaza.add(cMode);

    String[] sNormaliza = {Idioma.getOpAcentos(),Idioma.getOpBasura(),Idioma.getOpEspacios(),Idioma.getOpTrim()};

    desdeDerechaTrim = new JCheckBox(Idioma.getMainRight());
    desdeDerechaTrim.setName("desdeDerechaTrim");
    desdeDerechaTrim.addActionListener(cc);

    spNormalizaTrim = new SpinnerNumberModel(1,1,100,1);
    normalizaTrim = new JSpinner(spNormalizaTrim);
    normalizaTrim.setName("normalizaTrim");
    normalizaTrim.addChangeListener(cc);
    ((JSpinner.DefaultEditor)normalizaTrim.getEditor()).getTextField().setName("normalizaTrimEditor");
    ((JSpinner.DefaultEditor)normalizaTrim.getEditor()).getTextField().addKeyListener(cc);

    jNormaliza = new JComboBox(sNormaliza);
    jNormaliza.setPreferredSize(new Dimension(320,22));
    jNormaliza.setMaximumSize(new Dimension(320,22));
    setFont(jNormaliza, 11, Font.PLAIN);
    jNormaliza.setRenderer(new RenderCombos());
    jNormaliza.setName("jNormaliza");
    jNormaliza.addPopupMenuListener(cc);

    pnlNormaliza = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length;
	  for (int i = 1; i < count; i++)
	  components[i].setEnabled(enabled);
	}
      }
    };
    pnlNormaliza.setLayout(new BoxLayout(pnlNormaliza,BoxLayout.X_AXIS));
    pnlNormaliza.setAlignmentX(Component.LEFT_ALIGNMENT);

    pnlNormaliza.add(opNormaliza);
    pnlNormaliza.add(Box.createRigidArea(new Dimension(5,0)));
    pnlNormaliza.add(jNormaliza);

    pnlOtrosIzq = new JPanel();
    pnlOtrosIzq.setLayout(new BoxLayout(pnlOtrosIzq,BoxLayout.Y_AXIS));
    minSize = new Dimension(5, 40);
    prefSize = new Dimension(5, 40);
    maxSize = new Dimension(Short.MAX_VALUE, 40);
    pnlOtrosIzq.add(pnlNumeros);
    pnlOtrosIzq.add(new Box.Filler(minSize, prefSize, maxSize));    
    pnlOtrosIzq.add(new JSeparator());
    pnlOtrosIzq.add(pnlNormaliza);
    pnlOtrosIzq.add(new Box.Filler(minSize, prefSize, maxSize));    
    pnlOtrosIzq.add(new JSeparator());
    pnlOtrosIzq.add(pnlReemplaza);
    pnlOtrosIzq.add(new Box.Filler(minSize, prefSize, maxSize));    
    pnlOtrosIzq.setBorder(new CompoundBorder(BorderFactory.createEtchedBorder(),new EmptyBorder(35,30,10,10)));

    String[] sCapitaliza = {Idioma.getCaseUp(),Idioma.getCaseLow(),Idioma.getCaseFirst(),Idioma.getCaseAll(),Idioma.getCaseSymbol()};
    jCapitaliza = new JComboBox(sCapitaliza);
    jCapitaliza.setPreferredSize(new Dimension(320,22));
    jCapitaliza.setMaximumSize(new Dimension(600,22));
    setFont(jCapitaliza, 11, Font.PLAIN);
    jCapitaliza.setRenderer(new RenderCombos());
    jCapitaliza.setName("jCapitaliza");
    jCapitaliza.addPopupMenuListener(cc);
    txtSymbols = new JTextField("_-[(");
    txtSymbols.setName("txtSymbols");
    txtSymbols.addKeyListener(cc);

    pnlCapitaliza = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length;
	  for (int i = 1; i < count; i++)
	  components[i].setEnabled(enabled);
	}
      }
    };
    pnlCapitaliza.setLayout(new BoxLayout(pnlCapitaliza,BoxLayout.X_AXIS));
    pnlCapitaliza.setAlignmentX(Component.LEFT_ALIGNMENT);

    pnlCapitaliza.add(opCapitaliza);
    pnlCapitaliza.add(Box.createRigidArea(new Dimension(5,0)));
    pnlCapitaliza.add(jCapitaliza);

    if (separador.equals("/")) 
	sAtributos = new String[] {Idioma.getReadable(),Idioma.getWritable(),Idioma.getExecute(),Idioma.getHidden(),Idioma.getMenPickStamp()};
    else 
	sAtributos = new String[] {Idioma.getReadOnly(),Idioma.getHidden(),"Archivo","Sistema",Idioma.getMenPickStamp()};
    jAtributos = new JComboBox(sAtributos);
    jAtributos.setPreferredSize(new Dimension(130,22));
    jAtributos.setMaximumSize(new Dimension(130,22));
    setFont(jAtributos, 11, Font.PLAIN);
    jAtributos.setRenderer(new RenderCombos());
    jAtributos.setName("jAtributos");
    jAtributos.addPopupMenuListener(cc);

    String[] sAtributosEstado = {Idioma.getActivated(),Idioma.getDeactivated()};
    jAtributosEstado = new JComboBox(sAtributosEstado);
    jAtributosEstado.setPreferredSize(new Dimension(120,22));
    jAtributosEstado.setMaximumSize(new Dimension(120,22));
    setFont(jAtributosEstado, 11, Font.PLAIN);
    jAtributosEstado.setRenderer(new RenderCombos());
    jAtributosEstado.setName("jAtributosEstado");
    jAtributosEstado.addPopupMenuListener(cc);

    String[] sAtributosAplica = {Idioma.getApplySelected(),Idioma.getApplyAll()};
    cAtributos = new JWidePopupComboBox(sAtributosAplica);
    cAtributos.setPreferredWidth(40);
    setFont(cAtributos, 11, Font.PLAIN);
    cAtributos.setPreferredSize(new Dimension(20,16));
    cAtributos.setMaximumSize(new Dimension(20,16));
    cAtributos.setRenderer(new RenderCombos());

    iAtributos = new int[sAtributos.length];
    for (int x=0;x<iAtributos.length;x++) {
	iAtributos[x] = 0;
    }
    pnlAtributos = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length;
	  for (int i = 1; i < count; i++)
	  components[i].setEnabled(enabled);
	}
      }
    };
    pnlAtributos.setLayout(new BoxLayout(pnlAtributos,BoxLayout.X_AXIS));
    pnlAtributos.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlAtributos.add(opAtributos);
    pnlAtributos.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAtributos.add(jAtributos);
    pnlAtributos.add(Box.createRigidArea(new Dimension(8,0)));
    pnlAtributos.add(jAtributosEstado);
    pnlAtributos.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAtributos.add(cAtributos);

    opAleatorioLong = new JRadioButton(Idioma.getLengthOne()+":", true);
    setFont(opAleatorioLong, 11, Font.PLAIN);
    opAleatorioLong.setName("opAleatorioLong");
    opAleatorioLong.addActionListener(cc);

    spAleatorio = new SpinnerNumberModel(1,1,20,1);
    AleatorioLong = new JSpinner(spAleatorio);
    AleatorioLong.setPreferredSize(new Dimension(43,23));
    AleatorioLong.setMaximumSize(new Dimension(43,23));
    setFont(AleatorioLong, 10, Font.PLAIN);
    AleatorioLong.setName("AleatorioLong");
    AleatorioLong.addChangeListener(cc);
    ((JSpinner.DefaultEditor)AleatorioLong.getEditor()).getTextField().setName("AleatorioLongEditor");
    ((JSpinner.DefaultEditor)AleatorioLong.getEditor()).getTextField().addKeyListener(cc);

    opAleatorioOrig = new JRadioButton(Idioma.getLengthTwo());
    setFont(opAleatorioOrig, 11, Font.PLAIN);
    opAleatorioOrig.setName("opAleatorioOrig");
    opAleatorioOrig.addActionListener(cc);
    grAleatorio = new ButtonGroup();
    grAleatorio.add(opAleatorioLong);
    grAleatorio.add(opAleatorioOrig);

    pnlAleatorio = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length;
	  for (int i = 1; i < count; i++)
	  components[i].setEnabled(enabled);
	}
      }
    };
    pnlAleatorio.setLayout(new BoxLayout(pnlAleatorio,BoxLayout.X_AXIS));
    pnlAleatorio.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlAleatorio.add(opAleatorio);
    pnlAleatorio.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAleatorio.add(opAleatorioLong);
    pnlAleatorio.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAleatorio.add(AleatorioLong);
    pnlAleatorio.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAleatorio.add(opAleatorioOrig);

    pnlInsertar.setEnabled(false);
    pnlEliminar.setEnabled(false);
    pnlReemplaza.setEnabled(false);
    pnlNormaliza.setEnabled(false);
    pnlNumeros.setEnabled(false);
    pnlAtributos.setEnabled(false);
    pnlCapitaliza.setEnabled(false);
    pnlAleatorio.setEnabled(false);
    pnlOpcionDos.setEnabled(true);

    pnlOtrosDer = new JPanel();
    pnlOtrosDer.setLayout(new BoxLayout(pnlOtrosDer,BoxLayout.Y_AXIS));
    pnlOtrosDer.add(pnlAtributos);
    pnlOtrosDer.add(new Box.Filler(minSize, prefSize, maxSize));    
    pnlOtrosDer.add(new JSeparator());
    pnlOtrosDer.add(pnlAleatorio);
    pnlOtrosDer.add(new Box.Filler(minSize, prefSize, maxSize));    
    pnlOtrosDer.add(new JSeparator());
    pnlOtrosDer.add(pnlCapitaliza);
    pnlOtrosDer.add(new Box.Filler(minSize, prefSize, maxSize));    
    pnlOtrosDer.setBorder(new CompoundBorder(BorderFactory.createEtchedBorder(),new EmptyBorder(35,30,10,10)));

    pnlSurDos = new JPanel(new GridLayout(1,2));
    pnlSurDos.add(pnlOtrosIzq);
    pnlSurDos.add(pnlOtrosDer);

    lblPistaIzq = new JLabel(Idioma.getTagTrack() + ": ");
    lblPistaIzq.setFont(new Font("Helvetica", Font.BOLD, 11));    
    txtPista = new numbersField(3);
    txtPista.setName(Idioma.getTagTrack());
    setFont(txtPista, 10, Font.PLAIN);
    txtPista.setPreferredSize(new Dimension(50,18));
    txtPista.setMaximumSize(new Dimension(50,18));
    ckPista = new JCheckBox (Idioma.getBtnIncrease());
    ckPista.setFont(new Font("Helvetica", Font.PLAIN, 11));    
    JButton btnConfigPista = getButton("",configOk,false,0);
    btnConfigPista.addActionListener((e) -> {
        dialogoConfigMp3(txtPista, pnlPistaIzq);
    });

    pnlPistaIzq = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length -1;
	  for (int i = 1; i < count; i++) {
	      components[i].setEnabled(enabled);
	      if (components[i] instanceof JTextField) {
		  if (enabled)
		      components[i].setBackground(new JTextField().getBackground());
		  else
		      components[i].setBackground(new Color(240,240,240));
	      }
	  }
	}
      }
    };
    pnlPistaIzq.setLayout(new BoxLayout(pnlPistaIzq,BoxLayout.X_AXIS));
    pnlPistaIzq.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlPistaIzq.setBorder(BorderFactory.createLineBorder(Color.PINK));

    pnlPistaIzq.add(lblPistaIzq);
    pnlPistaIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlPistaIzq.add(txtPista);
    pnlPistaIzq.add(Box.createRigidArea(new Dimension(8,0)));
    pnlPistaIzq.add(ckPista);
    pnlPistaIzq.add(Box.createRigidArea(new Dimension(8,0)));
    pnlPistaIzq.add(btnConfigPista);

    lblArtistaIzq = new JLabel(Idioma.getTagArtist() + ": ");
    lblArtistaIzq.setFont(new Font("Helvetica", Font.BOLD, 11));
    txtArtista = new JTextField(27);
    txtArtista.setName(Idioma.getTagArtist());
    setFont(txtArtista, 10, Font.PLAIN);
    txtArtista.setPreferredSize(new Dimension(130,18));
    txtArtista.setMaximumSize(new Dimension(900,18));
    JButton btnConfigArtista = getButton("",configOk,false,0);
    btnConfigArtista.addActionListener(new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e) {
	    dialogoConfigMp3(txtArtista, pnlArtistaIzq);
	}
    });

    pnlArtistaIzq = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length -1;
	  for (int i = 1; i < count; i++) {
	      components[i].setEnabled(enabled);
	      if (components[i] instanceof JTextField) {
		  if (enabled) {
		      components[i].setBackground(new JTextField().getBackground());
		  } else {
		      components[i].setBackground(new Color(240,240,240));
		  }
	      }
	  }
	}
      }
    };
    pnlArtistaIzq.setLayout(new BoxLayout(pnlArtistaIzq,BoxLayout.X_AXIS));
    pnlArtistaIzq.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlArtistaIzq.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlArtistaIzq.add(lblArtistaIzq);
    pnlArtistaIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlArtistaIzq.add(txtArtista);
    pnlArtistaIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlArtistaIzq.add(btnConfigArtista);

    lblCancionIzq = new JLabel(Idioma.getTagTitle() + ": ");
    lblCancionIzq.setFont(new Font("Helvetica", Font.BOLD, 11));
    txtCancion = new JTextField(26);
    txtCancion.setName(Idioma.getTagTitle());
    setFont(txtCancion, 10, Font.PLAIN);
    txtCancion.setPreferredSize(new Dimension(130,18));
    txtCancion.setMaximumSize(new Dimension(900,18));
    JButton btnConfigCancion = getButton("",configOk,false,0);
    btnConfigCancion.addActionListener(new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e) {
	    dialogoConfigMp3(txtCancion,pnlCancionIzq);
	}
    });

    pnlCancionIzq = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length -1;
	  for (int i = 1; i < count; i++) {
	      components[i].setEnabled(enabled);
	      if (components[i] instanceof JTextField) {
		  if (enabled) {
		      components[i].setBackground(new JTextField().getBackground());
		  } else {
		      components[i].setBackground(new Color(240,240,240));
		  }
	      }
	  }
	}
      }
    };
    pnlCancionIzq.setLayout(new BoxLayout(pnlCancionIzq,BoxLayout.X_AXIS));
    pnlCancionIzq.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlCancionIzq.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlCancionIzq.add(lblCancionIzq);
    pnlCancionIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlCancionIzq.add(txtCancion);
    pnlCancionIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlCancionIzq.add(btnConfigCancion);

    lblAlbumIzq = new JLabel(Idioma.getTagAlbum() + ": ");
    lblAlbumIzq.setFont(new Font("Helvetica", Font.BOLD, 11));
    txtAlbum = new JTextField(27);
    txtAlbum.setName(Idioma.getTagAlbum());
    setFont(txtAlbum, 10, Font.PLAIN);
    txtAlbum.setPreferredSize(new Dimension(130,18));
    txtAlbum.setMaximumSize(new Dimension(900,18));
    JButton btnConfigAlbum = getButton("",configOk,false,0);
    btnConfigAlbum.addActionListener(new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e) {
	    dialogoConfigMp3(txtAlbum, pnlAlbumIzq);
	}
    });

    pnlAlbumIzq = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length -1;
	  for (int i = 1; i < count; i++) {
	      components[i].setEnabled(enabled);
	      if (components[i] instanceof JTextField) {
		  if (enabled) {
		      components[i].setBackground(new JTextField().getBackground());
		  } else {
		      components[i].setBackground(new Color(240,240,240));
		  }
	      }
	  }
	}
      }
    };
    pnlAlbumIzq.setLayout(new BoxLayout(pnlAlbumIzq,BoxLayout.X_AXIS));
    pnlAlbumIzq.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlAlbumIzq.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlAlbumIzq.add(lblAlbumIzq);
    pnlAlbumIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAlbumIzq.add(txtAlbum);
    pnlAlbumIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAlbumIzq.add(btnConfigAlbum);

    lblAnyoIzq = new JLabel(Idioma.getTagYear() + ": ");
    lblAnyoIzq.setFont(new Font("Helvetica", Font.BOLD, 11));
    txtAnyo = new numbersField(4);
    txtAnyo.setName(Idioma.getTagYear());
    setFont(txtAnyo, 10, Font.PLAIN);
    txtAnyo.setPreferredSize(new Dimension(50,18));
    txtAnyo.setMaximumSize(new Dimension(50,18));
    JButton btnConfigAnyo = getButton("",configOk,false,0);
    btnConfigAnyo.addActionListener(new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e) {
	    dialogoConfigMp3(txtAnyo, pnlAnyoIzq);
	}
    });

    pnlAnyoIzq = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length -1;
	  for (int i = 1; i < count; i++) {
	      components[i].setEnabled(enabled);
	      if (components[i] instanceof JTextField) {
		  if (enabled) {
		      components[i].setBackground(new JTextField().getBackground());
		  } else {
		      components[i].setBackground(new Color(240,240,240));
		  }
	      }
	  }
	}
      }
    };
    pnlAnyoIzq.setLayout(new BoxLayout(pnlAnyoIzq,BoxLayout.X_AXIS));
    pnlAnyoIzq.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlAnyoIzq.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlAnyoIzq.add(lblAnyoIzq);
    pnlAnyoIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAnyoIzq.add(txtAnyo);
    pnlAnyoIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAnyoIzq.add(btnConfigAnyo);


    lblGeneroIzq = new JLabel(Idioma.getTagGenre() + ": ");
    lblGeneroIzq.setFont(new Font("Helvetica", Font.BOLD, 11));
    txtGenero = new JTextField(26);
    txtGenero.setName(Idioma.getTagGenre());
    setFont(txtGenero, 10, Font.PLAIN);
    txtGenero.setPreferredSize(new Dimension(130,18));
    txtGenero.setMaximumSize(new Dimension(900,18));
    JButton btnConfigGenero = getButton("",configOk,false,0);
    btnConfigGenero.addActionListener(new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e) {
	    dialogoConfigMp3(txtGenero, pnlGeneroIzq);
	}
    });

    pnlGeneroIzq = new JPanel() {
      @Override
      public void setEnabled(boolean enabled) {
	super.setEnabled(enabled);
	Component[] components = getComponents();
	if (components != null && components.length > 0) {
	  int count = components.length -1;
	  for (int i = 1; i < count; i++) {
	      components[i].setEnabled(enabled);
	      if (components[i] instanceof JTextField) {
		  if (enabled) {
		      components[i].setBackground(new JTextField().getBackground());
		  } else {
		      components[i].setBackground(new Color(240,240,240));
		  }
	      }
	  }
	}
      }
    };
    pnlGeneroIzq.setLayout(new BoxLayout(pnlGeneroIzq,BoxLayout.X_AXIS));
    pnlGeneroIzq.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlGeneroIzq.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlGeneroIzq.add(lblGeneroIzq);
    pnlGeneroIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlGeneroIzq.add(txtGenero);
    pnlGeneroIzq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlGeneroIzq.add(btnConfigGenero);

    jLimpiaMp3 = getButton(Idioma.getBtnClean(),cleanOk,false);
    jLimpiaMp3.setMaximumSize(new Dimension(68,23));
    jLimpiaMp3.setToolTipText("");
    jLimpiaMp3.setFont(new Font("Helvetica", Font.PLAIN, 9));
    jLimpiaMp3.setName("limpiamp3");
    jLimpiaMp3.addActionListener(cc);

    jBotonMp3Izq = getButton(Idioma.getBtnSet(),aplicarOk,false);
    jBotonMp3Izq.setMaximumSize(new Dimension(68,23));
    jBotonMp3Izq.setToolTipText("");
    jBotonMp3Izq.setFont(new Font("Helvetica", Font.PLAIN, 9));
    jBotonMp3Izq.setName("aplicamp3");
    jBotonMp3Izq.addActionListener(cc);

    pnlBotonMp3Izq = new JPanel();
    pnlBotonMp3Izq.setLayout(new BoxLayout(pnlBotonMp3Izq,BoxLayout.X_AXIS));
    pnlBotonMp3Izq.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlBotonMp3Izq.add(Box.createGlue());
    pnlBotonMp3Izq.add(jLimpiaMp3);
    pnlBotonMp3Izq.add(Box.createRigidArea(new Dimension(5,0)));
    pnlBotonMp3Izq.add(jBotonMp3Izq);

    pnlMp3Izq = new JPanel();
    pnlMp3Izq.setLayout(new BoxLayout(pnlMp3Izq,BoxLayout.Y_AXIS));
    pnlMp3Izq.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getTitleMp3()),new EmptyBorder(10,30,10,10)));
    pnlMp3Izq.add(pnlPistaIzq);
    pnlMp3Izq.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Izq.add(pnlCancionIzq);
    pnlMp3Izq.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Izq.add(pnlArtistaIzq);
    pnlMp3Izq.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Izq.add(pnlAlbumIzq);
    pnlMp3Izq.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Izq.add(pnlAnyoIzq);
    pnlMp3Izq.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Izq.add(pnlGeneroIzq);
    pnlMp3Izq.add(Box.createRigidArea(new Dimension(0,8)));
    pnlMp3Izq.add(pnlBotonMp3Izq);

    lblPista = new JLabel(Idioma.getTagTrack() + ": ");
    lblPista.setFont(new Font("Helvetica", Font.BOLD, 11));
    pistaInfo = new JTextField();
    pistaInfo.setEditable(false);
    pistaInfo.setBorder(null);
    pistaInfo.setForeground(UIManager.getColor("Label.foreground"));
    pistaInfo.setFont(UIManager.getFont("Label.font"));
    pistaInfo.setOpaque(false);
    pistaInfo.setPreferredSize(new Dimension(50,20));
    pistaInfo.setMaximumSize(new Dimension(50,20));

    pnlPista = new JPanel();
    pnlPista.setLayout(new BoxLayout(pnlPista,BoxLayout.X_AXIS));
    pnlPista.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlPista.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlPista.add(lblPista);
    pnlPista.add(Box.createRigidArea(new Dimension(5,0)));
    pnlPista.add(pistaInfo);

    lblArtista = new JLabel(Idioma.getTagArtist() + ": ");
    lblArtista.setFont(new Font("Helvetica", Font.BOLD, 11));
    artistaInfo = new JTextField();
    artistaInfo.setEditable(false);
    artistaInfo.setBorder(null);
    artistaInfo.setForeground(UIManager.getColor("Label.foreground"));
    artistaInfo.setFont(UIManager.getFont("Label.font"));
    artistaInfo.setOpaque(false);
    artistaInfo.setPreferredSize(new Dimension(130,20));
    artistaInfo.setMaximumSize(new Dimension(900,20));

    pnlArtista = new JPanel();
    pnlArtista.setLayout(new BoxLayout(pnlArtista,BoxLayout.X_AXIS));
    pnlArtista.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlArtista.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlArtista.add(lblArtista);
    pnlArtista.add(Box.createRigidArea(new Dimension(5,0)));
    pnlArtista.add(artistaInfo);
    
    lblCancion = new JLabel(Idioma.getTagTitle() + ": ");
    lblCancion.setFont(new Font("Helvetica", Font.BOLD, 11));
    cancionInfo = new JTextField();
    cancionInfo.setEditable(false);
    cancionInfo.setBorder(null);
    cancionInfo.setForeground(UIManager.getColor("Label.foreground"));
    cancionInfo.setFont(UIManager.getFont("Label.font"));
    cancionInfo.setOpaque(false);
    cancionInfo.setPreferredSize(new Dimension(130,20));
    cancionInfo.setMaximumSize(new Dimension(900,20));

    pnlCancion = new JPanel();
    pnlCancion.setLayout(new BoxLayout(pnlCancion,BoxLayout.X_AXIS));
    pnlCancion.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlCancion.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlCancion.add(lblCancion);
    pnlCancion.add(Box.createRigidArea(new Dimension(5,0)));
    pnlCancion.add(cancionInfo);

    lblAlbum = new JLabel(Idioma.getTagAlbum() + ": ");
    lblAlbum.setFont(new Font("Helvetica", Font.BOLD, 11));
    albumInfo = new JTextField();
    albumInfo.setEditable(false);
    albumInfo.setBorder(null);
    albumInfo.setForeground(UIManager.getColor("Label.foreground"));
    albumInfo.setFont(UIManager.getFont("Label.font"));
    albumInfo.setOpaque(false);
    albumInfo.setPreferredSize(new Dimension(130,20));
    albumInfo.setMaximumSize(new Dimension(900,20));

    pnlAlbum = new JPanel();
    pnlAlbum.setLayout(new BoxLayout(pnlAlbum,BoxLayout.X_AXIS));
    pnlAlbum.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlAlbum.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlAlbum.add(lblAlbum);
    pnlAlbum.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAlbum.add(albumInfo);

    lblAnyo = new JLabel(Idioma.getTagYear() + ": ");
    lblAnyo.setFont(new Font("Helvetica", Font.BOLD, 11));
    anyoInfo = new JTextField();
    anyoInfo.setEditable(false);
    anyoInfo.setBorder(null);
    anyoInfo.setForeground(UIManager.getColor("Label.foreground"));
    anyoInfo.setFont(UIManager.getFont("Label.font"));
    anyoInfo.setOpaque(false);
    anyoInfo.setPreferredSize(new Dimension(50,20));
    anyoInfo.setMaximumSize(new Dimension(50,20));

    pnlAnyo = new JPanel();
    pnlAnyo.setLayout(new BoxLayout(pnlAnyo,BoxLayout.X_AXIS));
    pnlAnyo.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlAnyo.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlAnyo.add(lblAnyo);
    pnlAnyo.add(Box.createRigidArea(new Dimension(5,0)));
    pnlAnyo.add(anyoInfo);

    lblGenero = new JLabel(Idioma.getTagGenre() + ": ");
    lblGenero.setFont(new Font("Helvetica", Font.BOLD, 11));
    generoInfo = new JTextField();
    generoInfo.setEditable(false);
    generoInfo.setBorder(null);
    generoInfo.setForeground(UIManager.getColor("Label.foreground"));
    generoInfo.setFont(UIManager.getFont("Label.font"));
    generoInfo.setOpaque(false);
    generoInfo.setPreferredSize(new Dimension(130,20));
    generoInfo.setMaximumSize(new Dimension(900,20));

    pnlGenero = new JPanel();
    pnlGenero.setLayout(new BoxLayout(pnlGenero,BoxLayout.X_AXIS));
    pnlGenero.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlGenero.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlGenero.add(lblGenero);
    pnlGenero.add(Box.createRigidArea(new Dimension(5,0)));
    pnlGenero.add(generoInfo);

    jBotonMp3 = getButton(Idioma.getBtnGet(),previewOk,false);
    jBotonMp3.setToolTipText("");
    jBotonMp3.setFont(new Font("Helvetica", Font.PLAIN, 9));
    jBotonMp3.setName("mp3");

    pnlBotonMp3 = new JPanel();
    pnlBotonMp3.setLayout(new BoxLayout(pnlBotonMp3,BoxLayout.X_AXIS));
    pnlBotonMp3.setAlignmentX(Component.LEFT_ALIGNMENT);
    pnlBotonMp3.add(Box.createGlue());
    pnlBotonMp3.add(jBotonMp3);
    jBotonMp3.addActionListener(cc);

    pnlMp3Der = new JPanel();
    pnlMp3Der.setLayout(new BoxLayout(pnlMp3Der,BoxLayout.Y_AXIS));
    pnlMp3Der.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Info mp3"),new EmptyBorder(10,30,10,10)));
    pnlMp3Der.add(pnlPista);
    pnlMp3Der.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Der.add(pnlCancion);
    pnlMp3Der.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Der.add(pnlArtista);
    pnlMp3Der.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Der.add(pnlAlbum);
    pnlMp3Der.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Der.add(pnlAnyo);
    pnlMp3Der.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Der.add(pnlGenero);
    pnlMp3Der.add(Box.createRigidArea(new Dimension(0,5)));
    pnlMp3Der.add(pnlBotonMp3);
    
    pnlSurMp3 = new JPanel(new GridLayout(1,2));
    pnlSurMp3.add(pnlMp3Der);
    pnlSurMp3.add(pnlMp3Izq);

    pestPanel = new JTabbedPane();
    pestPanel.addChangeListener(cc);
    pestPanel.addTab(Idioma.getTabBasic(),pnlSur);
    pestPanel.addTab(Idioma.getTabOther(),pnlSurDos);
    pestPanel.addTab(Idioma.getTabMp3(),pnlSurMp3);
    pestPanel.setBorder(BorderFactory.createEmptyBorder());

    pnlInfo = new JPanel(new BorderLayout());
    pnlInfo.setBorder(BorderFactory.createLineBorder(Color.PINK));
    pnlInfo.setPreferredSize( new Dimension(1054, 75) );
    pnlInfo.setMinimumSize( new Dimension(1054, 75) );
    
    jProgreso = new JProgressBar();
    jProgreso.setValue(0);
    jProgreso.setStringPainted(true);

    muestraInfo(false, false);

    comboSur = new JPanel(new BorderLayout());
    comboSur.add(pestPanel,"Center");
    comboSur.add(pnlInfo,"South");
    comboSur.setBorder(BorderFactory.createEmptyBorder());
    comboSur.setPreferredSize( new Dimension(1054, 329) );
    comboSur.setMaximumSize( new Dimension(1054, 329) );

    pnlPrincipal = new JPanel(new BorderLayout());
    pnlPrincipal.add(pnlCentral,"Center");
    pnlPrincipal.add(comboSur,"South");
    pnlPrincipal.add(pnlHerramientasNorte,"North");
    pnlPrincipal.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    pnlPrincipal.setBackground(new Color(240,240,240));

    setContentPane(pnlPrincipal);
    Options.setPopupDropShadowEnabled(true);
    Options.setUseNarrowButtons(false);
    setMinimumSize(new Dimension(527,345));
    setIconImage(new ImageIcon(vrlogoImg).getImage());
    if( SystemInfo.isMacFullWindowContentSupported ) {
        getRootPane().putClientProperty( "apple.awt.fullWindowContent", true );
        getRootPane().putClientProperty( "apple.awt.transparentTitleBar", true );
    }                           
    setTitle("vRenamer ");
    if (iniciaLocation.equals("default")) {
	setLocationByPlatform(true);
    } else {
	String[] locations = iniciaLocation.split("x");
	int locationX = Integer.parseInt(locations[0]);
	int locationY = Integer.parseInt(locations[1]);
	setLocation(new Point(locationX, locationY));
    }
    if( anchuraP > 1900 ) {
	if (iniciaMaximized.equals("verdadero")) {
	    setPreferredSize(new Dimension(1600,980));
	    SwingUtilities.invokeLater(new Runnable() {
                @Override
		public void run() {
		    setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
	    });
	} else if ( ! iniciaDimension.equals("default") ) {
	    String [] dimensionesInicia = iniciaDimension.split("x");
	    int[] dimensionesInteger = new int[2];
	    dimensionesInteger[0] = Integer.parseInt(dimensionesInicia[0]);
	    dimensionesInteger[1] = Integer.parseInt(dimensionesInicia[1]);
	    setPreferredSize(new Dimension(dimensionesInteger[0],dimensionesInteger[1]));
	} else {
	    setPreferredSize(new Dimension(1600,980));
	}
	if (iniciaDivideTop.equals("default")) {
	    pnlDivide.setDividerLocation(815);
	} if (iniciaDivideBottom.equals("default")) {
	    pnlSur.setDividerLocation(715);
	}
	pnlInfo.setPreferredSize( new Dimension(1054, 95) );
	pnlInfo.setMinimumSize( new Dimension(1054, 95) );
	scrollSustituciones.setPreferredSize(new Dimension (715,50));
	comboSur.setPreferredSize( new Dimension(1054, 380) );
	comboSur.setMaximumSize( new Dimension(1054, 380) );
    } else {
	int currentSize;
	if (iniciaMaximized.equals("verdadero")) {
	    setPreferredSize(new Dimension(1054,690));
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    currentSize = anchuraP/2;
	    scrollSustituciones.setPreferredSize(new Dimension (currentSize,50));
	} else if ( ! iniciaDimension.equals("default") ) {
	    String [] dimensionesInicia = iniciaDimension.split("x");
	    int[] dimensionesInteger = new int[2];
	    dimensionesInteger[0] = Integer.parseInt(dimensionesInicia[0]);
	    dimensionesInteger[1] = Integer.parseInt(dimensionesInicia[1]);
	    setPreferredSize(new Dimension(dimensionesInteger[0]+2,dimensionesInteger[1]+3));
	} else {
	    setPreferredSize(new Dimension(1054,690));
	}
    }
    if ( ! iniciaDivideTop.equals("default") ) {
	int intDivideTop = Integer.parseInt(iniciaDivideTop);
	pnlDivide.setDividerLocation(intDivideTop);
    } else if ( anchuraP <= 1900 ) {
	pnlDivide.setDividerLocation(515);
    }
    if ( ! iniciaDivideBottom.equals("default") ) {
	final int intDivideBottom = Integer.parseInt(iniciaDivideBottom);
	pnlSur.setDividerLocation(intDivideBottom);
    }

    pack();
    setVisible(true);
       
    addWindowListener(new WindowAdapter() {
        @Override
	public void windowClosing(WindowEvent e){
            salir();
	}
    });
    addMouseListener(new MouseAdapter() {
        @Override
	public void mouseEntered(MouseEvent e) {
	    pnlDivide.setResizeWeight(0.60);
	    pnlSur.setResizeWeight(0.40);
	}
    });
    resetValoresNuevo();
    iniciaValores();

 }

  private void setMenuRecent() {      
      if ( ! iniciaRecent.equals("")) {
          for (String strRecent : openRecent) {
              JMenuItem jRecent = new JMenuItem(strRecent);
              jRecent.setName("recent" + strRecent);
              menuRecent.add(jRecent);
              jRecent.addActionListener(cc);
          }
      }      
  }

  private void tomaFicheros(String tomaFiltro, Boolean tomaOcultos, Boolean tomaCase, Boolean tomaExcluye, Boolean tomaRecursivo, idiomas tomaIdioma){
      oArchivos = new ListArchivos(ruta);
      if ( ! modoDrop ) {
	  Archivos = oArchivos.getFicheros(tomaFiltro, tomaOcultos, tomaCase, tomaExcluye, tomaRecursivo, recursivoCarpeta, tomaIdioma);
	  if (Archivos == null) {
	      ruta = rutaAnterior;
	      oArchivos = new ListArchivos(ruta);      
	      Archivos = oArchivos.getFicheros(filtrado, m42.isSelected(), ckCase.isSelected(), ckExcluye.isSelected(), ckRecursivo.isSelected(), recursivoCarpeta, Idioma);      
	      navega(ruta);
	  }
	  archivosOriginales = oArchivos.getAbstractFiltrado();
      }
  }
  private void tomaRenombrados(){
      if (!ckCopiaCarpeta.isSelected()) {
// 	  if ( ! modoDrop ) {
          Renombrados = new StringBuffer[Archivos.length];
          System.arraycopy(Archivos, 0, Renombrados, 0, Archivos.length);
      } else {
	  oRenombrados = new ListArchivos(rutaRenombrados);
	  Renombrados = oRenombrados.getFicheros("", m42.isSelected(), false, false, false, false, Idioma);
	  if (Renombrados == null) {
	      ckCopiaCarpeta.setSelected(false);
	      rutaRenombrados = ruta;
	      navega(ruta);
	  }
      }
  }
  public void setRuta(){
      String rutaBarra = jRuta.getItemAt(jRuta.getItemCount()-1).toString();
      rutaBarra = chequeaRuta(rutaBarra);
      jRuta.removeAllItems();
      unidades = mBusca.unidades(getSistema());
      for (int x=0;x<unidades.length;x++) 
          jRuta.addItem(unidades[x]);
      jRuta.addItem(rutaBarra);
      jRuta.setSelectedIndex(jRuta.getItemCount()-1);
      jRuta.setRenderer(new RenderUnidades(getSistema(),jRuta.getItemCount()));
  }
  public String rutaCierra(){
      tRuta = (JTextField)jRuta.getEditor().getEditorComponent();
      return tRuta.getText();
  }
  public void cierraDrop() {
      if (modoDrop) {
	  m43.setSelected(false);
	  pulsaDrop();
      }
  }
  public void actualizaNavegador() {
      pnlNavegador.removeAll();
      if ( ! modoDrop ) {
	  Boolean remoto = false;
	  JButton btnRutaUno;
	  String [] Botones = ruta.split("\\"+separador);
	  if (ruta.length() > 1) {
	      if (ruta.substring(0,2).equals("\\\\")) {
                  remoto = true;
              }
	  }
	  if (ruta.equals("/")) {
	      Botones = new String[1];
	      Botones[0] = "";
	  }
	  if ( ! Botones[0].equals("") && ! remoto ) {
	      rutaModificada = "";
          } else {
	      if (remoto) 
                  rutaModificada = "\\\\";
	      else 
                  rutaModificada ="/";
	      final JButton btnNavegaUno = new JButton(rutaModificada) {
                @Override
		protected void processMouseEvent(MouseEvent e) {
		  super.processMouseEvent(e);
		  if (e.getID() == MouseEvent.MOUSE_ENTERED) {
		    this.setOpaque(true);
		    this.setContentAreaFilled(true);
		    this.setBackground(Color.PINK);
		  }
		  if (e.getID() == MouseEvent.MOUSE_EXITED) {
		    this.setOpaque(false);
		    this.setBorderPainted(false);
		    this.setContentAreaFilled(false);
		  }
		}
	      };
	      btnNavegaUno.setName(rutaModificada);
	      btnNavegaUno.setFont(new Font("Helvetica", Font.PLAIN, 12));
	      btnNavegaUno.setPreferredSize(new Dimension (35,20));
	      btnNavegaUno.setMaximumSize(new Dimension (35,20));
	      btnNavegaUno.setOpaque(false);
	      btnNavegaUno.setContentAreaFilled(false);
	      btnNavegaUno.setBorderPainted(false);
              btnNavegaUno.setForeground(Color.DARK_GRAY);
	      btnNavegaUno.addActionListener(cc);
	      pnlNavegador.add(btnNavegaUno);

	      btnRutaUno = new JButton(">"){
                @Override
		protected void processMouseEvent(MouseEvent e) {
		    super.processMouseEvent(e);
		    if (e.getID() == MouseEvent.MOUSE_ENTERED) {
		      this.setOpaque(true);
		      this.setContentAreaFilled(true);
		      this.setBackground(new Color(255,240,245));
		      btnNavegaUno.setOpaque(true);
		      btnNavegaUno.setContentAreaFilled(true);
		      btnNavegaUno.setBackground(Color.PINK);
		    }
		    if (e.getID() == MouseEvent.MOUSE_EXITED) {
		      this.setOpaque(false);
		      this.setBorderPainted(false);
		      this.setContentAreaFilled(false);
		      btnNavegaUno.setOpaque(false);
		      btnNavegaUno.setBorderPainted(false);
		      btnNavegaUno.setContentAreaFilled(false);
		    }
		  }
	      };
	      btnRutaUno.setName(rutaModificada);
	      final JPopupMenu dropUp = addDropDown();
	      btnRutaUno.addMouseListener(new MouseAdapter() {
		  @Override
		  public void mousePressed(MouseEvent e) {
		      dropUp.show(e.getComponent(), e.getX(), e.getY());
		  }
	      });
	      btnRutaUno.setFont(new Font("Helvetica", Font.PLAIN, 12));
	      btnRutaUno.setPreferredSize(new Dimension (45,18));
	      btnRutaUno.setMaximumSize(new Dimension (45,18));
	      btnRutaUno.setOpaque(false);
	      btnRutaUno.setContentAreaFilled(false);
	      btnRutaUno.setBorderPainted(false);
              btnRutaUno.setForeground(Color.DARK_GRAY);
	      btnRutaUno.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
	      pnlNavegador.add(btnRutaUno);
	  }
	  for (int x=0;x<Botones.length -1;x++) {
	      if (Botones[x].equals("")) continue;
	      rutaModificada += Botones[x] + separador;
	      JButton btnNavega = new JButton(Botones[x]) {
                @Override
		protected void processMouseEvent(MouseEvent e) {
		  super.processMouseEvent(e);
		  if (e.getID() == MouseEvent.MOUSE_ENTERED) {
		    this.setOpaque(true);
		    this.setContentAreaFilled(true);
		    this.setBackground(Color.PINK);
		  }
		  if (e.getID() == MouseEvent.MOUSE_EXITED) {
		    this.setOpaque(false);
		    this.setBorderPainted(false);
		    this.setContentAreaFilled(false);
		  }
		}
	      };
	      btnNavega.setName(rutaModificada);
	      btnNavega.setFont(new Font("Helvetica", Font.PLAIN, 12));
	      btnNavega.setOpaque(false);
	      btnNavega.setContentAreaFilled(false);
	      btnNavega.setBorderPainted(false);
              btnNavega.setForeground(Color.DARK_GRAY);
	      btnNavega.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
	      btnNavega.addActionListener(cc);
	      pnlNavegador.add(btnNavega);
	      JButton btnRuta = new JButton(">"){
                @Override
		protected void processMouseEvent(MouseEvent e) {
		  super.processMouseEvent(e);
		  JButton fuente = (JButton) e.getSource();
		  int indice = Integer.parseInt(fuente.getName());
		  if (e.getID() == MouseEvent.MOUSE_ENTERED) {
		    this.setOpaque(true);
		    this.setContentAreaFilled(true);
		    this.setBackground(new Color(255,240,245));
		    btnNavega.setOpaque(true);
		    btnNavega.setContentAreaFilled(true);
		    btnNavega.setBackground(Color.PINK);
		  }
		  if (e.getID() == MouseEvent.MOUSE_EXITED) {
		    this.setOpaque(false);
		    this.setBorderPainted(false);
		    this.setContentAreaFilled(false);
		    btnNavega.setOpaque(false);
		    btnNavega.setBorderPainted(false);
		    btnNavega.setContentAreaFilled(false);
		  }
		}
	      };
	      btnRuta.setName(x+"");              
	      JPopupMenu dropUpNavega = addDropDown();
	      btnRuta.addMouseListener(new MouseAdapter() {
                  @Override
		  public void mousePressed(MouseEvent e) {
		      JButton fuente = (JButton) e.getSource();
		      int indice = Integer.parseInt(fuente.getName());
		      dropUpNavega.show(e.getComponent(), e.getX(), e.getY());
		  }
	      });
	      btnRuta.setFont(new Font("Helvetica", Font.PLAIN, 12));
	      btnRuta.setPreferredSize(new Dimension (45,18));
	      btnRuta.setMaximumSize(new Dimension (45,18));
              btnRuta.setForeground(Color.DARK_GRAY);
	      btnRuta.setOpaque(false);
	      btnRuta.setContentAreaFilled(false);
	      btnRuta.setBorderPainted(false);
	      btnRuta.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
	      if (x < Botones.length -1) {
		  pnlNavegador.add(btnRuta);
              }
	  }
          JLabel lblUltimo = new JLabel(Botones[Botones.length -1]);
          lblUltimo.setFont(new Font("Helvetica", Font.BOLD, 12));
          lblUltimo.setPreferredSize(new Dimension (45,18));
          
          pnlNavegador.add(lblUltimo);
      } else {
	  JLabel lblModoDrop = new JLabel(Idioma.getMenuTipDrop());
	  setFont(lblModoDrop,11,Font.PLAIN);
	  lblModoDrop.setForeground(new Color(139,10,80));
	  JButton btnCancelDrop = new JButton(removeDropOk){
              @Override
	      protected void processMouseEvent(MouseEvent e) {
		super.processMouseEvent(e);
		  if (e.getID() == MouseEvent.MOUSE_ENTERED) {
		      ToolTipManager.sharedInstance().setEnabled(true);
		  }
		  if (e.getID() == MouseEvent.MOUSE_EXITED) {
		  }
	      }
	  };
	  btnCancelDrop.setToolTipText(Idioma.getMenuTipDrop());
	  btnCancelDrop.setRolloverIcon(removeDropBWOk);
	  btnCancelDrop.setPreferredSize(new Dimension(20,20));
	  btnCancelDrop.setBorder(null);
	  btnCancelDrop.setOpaque(true);
	  btnCancelDrop.setContentAreaFilled(false);
	  btnCancelDrop.setBorderPainted(false);
	  btnCancelDrop.addActionListener(new ActionListener() {
              @Override
	      public void actionPerformed(ActionEvent e) {
		  if (archivosOriginales.length > 0) {
		      limpiaArchivosDrop(listArchivos.getSelectedRows());
		  }
	      }
	  });
	  pnlNavegador.add(Box.createRigidArea(new Dimension(12,0)));
	  pnlNavegador.add(lblModoDrop);
	  pnlNavegador.add(Box.createRigidArea(new Dimension(20,0)));
	  pnlNavegador.add(btnCancelDrop);
      }
      pnlNavegador.updateUI();
  }
  public JPopupMenu addDropDown() {
      JPopupMenu dropActual = new JPopupMenu();
      dropActual.setBorderPainted(false);
      File[] directoriosParaOrdenar = new File(rutaModificada).listFiles();
      Arrays.sort(directoriosParaOrdenar, NameFileComparator.NAME_INSENSITIVE_COMPARATOR);
      for (File rModificada : directoriosParaOrdenar) {
	  if ( rModificada.isDirectory() && rModificada.listFiles()!=null && !rModificada.isHidden() ) {
	      JMenuItem menuItem = new JMenuItem (rModificada.getName(),iconFolder);
	      menuItem.setName(rModificada.toString());
	      dropActual.add(menuItem);
	      menuItem.addActionListener(new ActionListener() {
                  @Override
		  public void actionPerformed(ActionEvent e) {
		      JMenuItem fuente = (JMenuItem) e.getSource();
		      navega(cambiaRutaBotones(fuente.getName() + separador));
		  }
	      });
	      if (ruta.contains(rModificada.toString() + separador)) {
		  menuItem.setFont(new Font("Arial", Font.BOLD, 11));
	      } else {
		  menuItem.setFont(new Font("Arial", Font.PLAIN, 11));
	      }
	  }
      }
      return dropActual;
  }
  public void muestraInfo(Boolean Cargando, Boolean muestraImagen) {
      if ( ! new File(ruta).canRead() ) {
	  navega(rutaHome + separador);
	  cambiaRuta();
      }
      pnlInfo.removeAll();
      pnlInfoLeft = new JPanel();
      pnlInfoLeft.setLayout(new BoxLayout(pnlInfoLeft,BoxLayout.X_AXIS));
      pnlInfoLeft.setAlignmentX(Component.LEFT_ALIGNMENT);
      pnlInfoLeft.setAlignmentY(Component.TOP_ALIGNMENT);
      pnlInfoLeft.setBorder(BorderFactory.createRaisedSoftBevelBorder());

      String informacion;
      int indexFile = Idioma.getInfoFile().length()-1;
      int indexFolder = Idioma.getInfoFolder().length()-1;
      String sArchivos = Idioma.getInfoFile();
      String sCarpetas = Idioma.getInfoFolder();

      if (oArchivos.getCuentaCarpetas() == 1) {
	  sCarpetas = Idioma.getInfoFolder().substring(0,indexFolder);
      }
      if (oArchivos.getCuentaArchivos() == 1) {
	  sArchivos = Idioma.getInfoFile().substring(0,indexFile);
      }
      if (oArchivos.getCuentaArchivos() == 0 && oArchivos.getCuentaCarpetas() == 0) {
	  informacion = "--";
      } else if (oArchivos.getCuentaArchivos() == 0) {
	  informacion = oArchivos.getCuentaCarpetas() + " " + sCarpetas;
      } else if (oArchivos.getCuentaCarpetas() == 0) {
	  informacion = oArchivos.getCuentaArchivos() + " " + sArchivos;
      } else {
	  informacion = oArchivos.getCuentaCarpetas() + " " + sCarpetas + ", " + oArchivos.getCuentaArchivos() + " " + sArchivos;
      }
      if (Cargando) {
	  informacion = Idioma.getInfoLoading() + " " + informacion;
      }
      JLabel lblInfoIcon = new JLabel(infoOk);
      JLabel lblInfo = new JLabel(informacion);
      lblInfo.setFont(new Font("FreeSans", Font.BOLD, 11));
      if (Cargando) {
	  lblInfo.setForeground(new Color(205,0,0));
      }
      pnlProgreso = new JPanel();
      pnlProgreso.setLayout(new BoxLayout(pnlProgreso,BoxLayout.X_AXIS));
      pnlProgreso.setAlignmentX(Component.LEFT_ALIGNMENT);
      pnlProgreso.setAlignmentY(Component.CENTER_ALIGNMENT);

      pnlProgresoInfo = new JPanel();
      pnlProgresoInfo.setLayout(new BoxLayout(pnlProgresoInfo,BoxLayout.Y_AXIS));
      pnlProgresoInfo.setAlignmentY(Component.CENTER_ALIGNMENT);

      pnlInfoLeft.add(Box.createRigidArea(new Dimension(10,0)));
      pnlInfoLeft.add(lblInfoIcon);
      pnlInfoLeft.add(Box.createRigidArea(new Dimension(5,0)));

      JPanel pnlLblInfo = new JPanel();
      pnlLblInfo.setLayout(new BoxLayout(pnlLblInfo,BoxLayout.Y_AXIS));
      pnlLblInfo.add(lblInfo);
      if ( ! jFiltro.getText().equals("") && ! jFiltro.getText().equals(" ") ) {
	  JLabel avisoFiltro = new JLabel(Idioma.getFiltroOn());
	  avisoFiltro.setFont(new Font("FreeSans", Font.BOLD, 11));
	  avisoFiltro.setForeground(new Color(139,69,0));
	  pnlLblInfo.add(Box.createRigidArea(new Dimension(0,1)));
	  pnlLblInfo.add(avisoFiltro);
      }
      if ( ! indicesMarcar.isEmpty() ) {
	  indicesMarcarItera = indicesMarcar.iterator();
	  String lblError = (indicesMarcar.size() == 1) ? Idioma.getError() : Idioma.getErrors();
	  JButton avisoRepetidos = new JButton(indicesMarcar.size() + " " + lblError);
	  avisoRepetidos.addMouseListener(new MouseAdapter() {
	      @Override
	      public void mouseEntered(MouseEvent e) {
		  setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	      }
	      @Override
	      public void mouseExited(MouseEvent e) {
		  setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	      }
	  });
	  avisoRepetidos.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
		  Integer indicesMarcarCiclo = 0;
		  if (indicesMarcarItera.hasNext()) {
		      indicesMarcarCiclo = (Integer) indicesMarcarItera.next();
		  } else {
		      indicesMarcarItera = indicesMarcar.iterator();
		      if (indicesMarcarItera.hasNext()) {
			  indicesMarcarCiclo = (Integer) indicesMarcarItera.next();
		      }
		  }
		  Rectangle rect;
		  if (ckCopiaCarpeta.isSelected()) {
		      rect = listRenombrados.getCellRect(indicesMarcarCiclo, 1, true);
		      listRenombrados.scrollRectToVisible(rect);
		      listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererRenom(rutaRenombrados, okSeleccionRe, indicesMarcar, indicesMarcarCiclo));
		  } else {
		      rect = listArchivos.getCellRect(indicesMarcarCiclo, 1, true);
		      listArchivos.scrollRectToVisible(rect);
		      listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, indicesMarcarCiclo));
		  }
		  listRenombrados.repaint();
	      }      
	  });
	  avisoRepetidos.setOpaque(false);
	  avisoRepetidos.setContentAreaFilled(false);
	  avisoRepetidos.setBorderPainted(false);
	  avisoRepetidos.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

	  Font fuenteRepetidos = new Font("FreeSans", Font.BOLD, 11);
	  Map<TextAttribute, Object> map = new Hashtable<>();
	  map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	  map.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
	  fuenteRepetidos = fuenteRepetidos.deriveFont(map);
	  avisoRepetidos.setFont(fuenteRepetidos);
	  avisoRepetidos.setForeground(Color.RED);
	  pnlLblInfo.add(Box.createRigidArea(new Dimension(0,1)));
	  pnlLblInfo.add(avisoRepetidos);
      }
      pnlInfoLeft.add(pnlLblInfo);
      pnlInfoLeft.add(Box.createRigidArea(new Dimension(5,0)));

      pnlInfo.add(pnlInfoLeft,"West");
      if (fotoArchivo == null) {
	  fotoArchivo = new File (ruta);
      }
      if (muestraImagen) {
	  addImagen();
      }
      pnlInfo.add(pnlProgresoInfo,"East");
      pnlInfo.updateUI();
      if (jProgreso.getValue() != 0) {
          muestraBarra(true,"");
      }
  }
  public void muestraBarra(Boolean botonCancela,String textoProgreso) {
    jCancel = new JButton(exitOk);
    jCancel.setName("Cancelar");
    jCancel.setRolloverIcon(exitBWOk);
    jCancel.addActionListener(cc);
    jCancel.setPreferredSize(new Dimension(20,20));
    jCancel.setBorder(null);
    jCancel.setOpaque(true);
    pnlProgreso.removeAll();
    pnlProgresoInfo.removeAll();
    if (botonCancela) {
	pnlProgreso.add(Box.createRigidArea(new Dimension(10,0)));
	pnlProgreso.add(jCancel);
	pnlProgreso.add(Box.createRigidArea(new Dimension(10,0)));
    }
    pnlProgreso.add(jProgreso);
    pnlProgreso.add(Box.createRigidArea(new Dimension(10,0)));

    JLabel infoProgreso = new JLabel(textoProgreso);
    JPanel pnlLabelProgreso = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    pnlLabelProgreso.setBorder(new EmptyBorder(0,0,0,5));
    pnlLabelProgreso.add(infoProgreso);
    infoProgreso.setFont(new Font("FreeSans", Font.BOLD, 11));
    pnlLabelProgreso.setPreferredSize(new Dimension(550,35));
    pnlLabelProgreso.setMaximumSize(new Dimension(550,35));
    pnlLabelProgreso.setMinimumSize(new Dimension(550,35));
    pnlProgresoInfo.setPreferredSize(new Dimension(550,35));
    pnlProgresoInfo.setMaximumSize(new Dimension(550,35));
    pnlProgresoInfo.setMinimumSize(new Dimension(550,35));
    pnlProgresoInfo.add(Box.createRigidArea(new Dimension(0,20)));
    pnlProgresoInfo.add(pnlProgreso);
    pnlProgreso.add(Box.createRigidArea(new Dimension(0,15)));
    pnlProgresoInfo.add(pnlLabelProgreso);    
    pnlProgreso.updateUI();
    pnlProgresoInfo.updateUI();
  }
  public void addImagen() {
      if ( cargaWorker == null || cargaWorker.isDone() ) 
	  fotoArchivoActual = new File(fotoArchivo.toString());
      pnlInfoImagen = new JPanel(new BorderLayout());
      pnlInfoImagen.setBorder(null);
      labelImage = new JLabel(refreshingOk);
      pnlInfoImagen.add(labelImage,"Center");

      long tamanyo = fotoArchivoActual.length();
      String tamanyoHuman = humanReadableByteCount(tamanyo, false);

      JLabel nombreArchivoCat = new JLabel(Idioma.getName());
      nombreArchivoCat.setFont(new Font("Helvetica", Font.PLAIN, 11));
      JLabel tamArchivoCat = new JLabel(Idioma.getLength() + ": ");
      tamArchivoCat.setFont(new Font("Helvetica", Font.PLAIN, 11));
      JLabel fechaMetaCat = new JLabel(Idioma.getModified() + ": ");
      fechaMetaCat.setFont(new Font("Helvetica", Font.PLAIN, 11));

      JLabel nombreArchivo = new JLabel(fotoArchivoActual.getName());
      nombreArchivo.setFont(new Font("Helvetica", Font.PLAIN, 11));
      JLabel tamanyoArchivo = new JLabel(tamanyoHuman);
      tamanyoArchivo.setFont(new Font("Helvetica", Font.PLAIN, 11));
      JLabel fechaMeta;
      String fechaMetaRecibe;
      if (iniciaIdioma.equals("Esp")) {
	  fechaMetaRecibe = mBusca.getFecha(fotoArchivoActual.toString(),0,'1');
      } else {
	  fechaMetaRecibe = mBusca.getFecha(fotoArchivoActual.toString(),4,'1');
      }
      if (mBusca.endsWithIgnoreCase(fotoArchivoActual.toString(),".jpg") || mBusca.endsWithIgnoreCase(fotoArchivoActual.toString(),".jpeg") ) {
	  if (iniciaIdioma.equals("Esp")) {
	      fechaMetaRecibe = mBusca.getFechaMeta(fotoArchivoActual.toString(),0,'1');
	  } else {
	      fechaMetaRecibe = mBusca.getFechaMeta(fotoArchivoActual.toString(),4,'1');
	  }
	  fechaMetaCat = new JLabel(Idioma.getComboDatePicture() + ": ");
	  if (fechaMetaRecibe.contains("File:")) {
	      fechaMetaRecibe = fechaMetaRecibe.replace("File:","");
	      fechaMetaCat = new JLabel(Idioma.getModified());
	  }
	  fechaMetaCat.setFont(new Font("Helvetica", Font.PLAIN, 11));      
      }
      fechaMeta = new JLabel(fechaMetaRecibe);
      fechaMeta.setFont(new Font("Helvetica", Font.PLAIN, 11));

      JPanel pnlInfoDatosCat = new JPanel(new GridLayout(5,1));
      pnlInfoDatosCat.add(nombreArchivoCat);
      pnlInfoDatosCat.add(new JSeparator());
      pnlInfoDatosCat.add(tamArchivoCat);
      pnlInfoDatosCat.add(new JSeparator());
      pnlInfoDatosCat.add(fechaMetaCat);

      pnlInfoDatos = new JPanel(new GridLayout(5,1));
      pnlInfoDatos.add(nombreArchivo);
      pnlInfoDatos.add(new JSeparator());
      pnlInfoDatos.add(tamanyoArchivo);
      pnlInfoDatos.add(new JSeparator());
      pnlInfoDatos.add(fechaMeta);

      pnlInfoLeft.add(pnlInfoImagen);
      pnlInfoLeft.add(Box.createRigidArea(new Dimension(5,0)));
      pnlInfoLeft.add(new JSeparator(SwingConstants.VERTICAL));
      pnlInfoLeft.add(Box.createRigidArea(new Dimension(5,0)));
      pnlInfoLeft.add(pnlInfoDatosCat);
      pnlInfoLeft.add(Box.createRigidArea(new Dimension(5,0)));
      pnlInfoLeft.add(pnlInfoDatos);
      pnlInfoLeft.add(Box.createRigidArea(new Dimension(5,0)));
      pnlInfoLeft.updateUI();
      if ( cargaWorker == null || cargaWorker.isDone() ) {
	  if (mBusca.endsWithIgnoreCase(fotoArchivoActual.toString(),".jpg") || mBusca.endsWithIgnoreCase(fotoArchivoActual.toString(),".jpeg") || mBusca.endsWithIgnoreCase(fotoArchivoActual.toString(),".png") || mBusca.endsWithIgnoreCase(fotoArchivoActual.toString(),".gif") || mBusca.endsWithIgnoreCase(fotoArchivoActual.toString(),".bmp") ) {
	      cargaWorker = new cargaImagen();
	      cargaWorker.execute();
	  } else {
	      Icon icono;
	      if (fotoArchivoActual.canRead()) {
		  if (getSistema().equals("mac")) {
		      icono = new JFileChooser().getIcon(fotoArchivoActual);		      
		  } else {
		      icono = FileSystemView.getFileSystemView().getSystemIcon(fotoArchivoActual);
		  }
	      } else {
		  System.err.println("File not found or can't read");
		  icono = imageWarningOk;
	      }
	      pnlInfoImagen.removeAll();
	      pnlInfoImagen.setBorder(BorderFactory.createLineBorder(Color.red));
	      JLabel labelArchivos = new JLabel(icono);
	      labelArchivos.setPreferredSize(new Dimension(60,60));
	      pnlInfoImagen.add(labelArchivos, "Center");
	      pnlInfoLeft.updateUI();
	}
     }
  }
  private static String humanReadableByteCount(long bytes, boolean si) {
      int unit = si ? 1000 : 1024;
      if (bytes < unit) 
	  return bytes + " B";
      int exp = (int) (Math.log(bytes) / Math.log(unit));
      String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
      return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
  }
  private BufferedImage getReader(int fotoSize) {
    BufferedImage bi;
    ImageInputStream input = null;
    ImageReader reader;
    try {
	input = ImageIO.createImageInputStream(fotoArchivo);
	Iterator readers = ImageIO.getImageReaders(input);
	reader = null;
	while(readers.hasNext()) {
	    reader = (ImageReader) readers.next();
	    if(reader.canReadRaster()) {
		break;
	    }
	}
	ImageReadParam param = new ImageReadParam();
	reader.setInput(input, true, true); 
	param.setSourceSubsampling(fotoSize, fotoSize, 0, 0);
	try {
	    bi = reader.read(0,param);
	} catch (IIOException iio) {
	    Raster raster = reader.readRaster(0, null); 
	    bi = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_3BYTE_BGR); 

	    InputStream imageInputStream = cldr.getResourceAsStream("resource/Generic_CMYK_Profile.icc");
	    WritableRaster resultRaster = bi.getRaster();
	    ICC_Profile iccProfile = ICC_Profile.getInstance(imageInputStream);

	    ColorSpace cs = new ICC_ColorSpace(iccProfile);
//	    bi.getRaster().setRect(raster);

	    ColorConvertOp cmykToRgb = new ColorConvertOp(cs, bi.getColorModel().getColorSpace(), null);
	    cmykToRgb.filter(raster, resultRaster);
	}
	return bi;
    } catch (IOException ne) {
	System.err.println("Image format not supported so far");
	return null;
    }
    finally {
	try {
	    input.close();
	}
	catch (IOException c) {
	    System.err.println("Image no longer exists");
	}
    }
  }
  public void limpiaSeleccion() {
      listArchivos.clearSelection();
      if (doSeleccionadosNuevo == null || doSeleccionadosNuevo.isDone()) {
	  muestraInfo(false, false);
      }
  }
  public void cancelaCopia() {
      jCancel.setEnabled(false);
      oArchivos.cancelaCopia();
      mBusca.cancelarCopia();
      cancelarCopia = true;
  }
  public Boolean preguntaCancela() {
      return cancelarCopia;
  }
  public String chequeaRuta(String intentaRuta) {
      if ( ! new File(intentaRuta).canRead() ) {
	  ruta = rutaHome + separador;
	  if (ckRecursivo != null) 
	      cambiaRuta();
      } else {
	  ruta = intentaRuta;
      }
      return ruta;
  }
  public void conmutaEspera() {
      ConmutaEspera doConmuta = new ConmutaEspera();
      doConmuta.execute();
  }
  public void conmutaSeparadores() {
      if (!bloqueaConmuta) {
	  int conmutaSeleccion;
	  String conmutaTexto;
	  JTextField tSepara = (JTextField)jSepara.getEditor().getEditorComponent();
	  jSepara.setEnabled(true);
	  if (ckOpcionTres.isSelected()) {
	      conmutaSeleccion = jSepara.getSelectedIndex();
	      conmutaTexto = tSepara.getText();
	      for (Component cBarra : pnlBuscaTotal.getComponents()) {
                  BarraRenombra barra = (BarraRenombra) cBarra;
                  barra.setSeparaIndex(jSepara.getSelectedIndex());
                  barra.setSeparaText(tSepara.getText());
                  barra.updateUI();
	      }
	  } else {
	      conmutaSeleccion = 4;
	      conmutaTexto = "off";
	      jSepara.setEnabled(false);
	      for (Component cBarra : pnlBuscaTotal.getComponents()) {
                  BarraRenombra barra = (BarraRenombra) cBarra;
                  barra.setSeparaIndex(4);
                  barra.setSeparaText("off");
                  barra.updateUI();
	      }
	  }
	  for (Component cBarra : pnlBuscaTotal.getComponents()) {
              BarraRenombra barra = (BarraRenombra) cBarra;
	      barra.setSeparaIndex(conmutaSeleccion);
	      barra.setSeparaText(conmutaTexto);
	      barra.updateUI();
	  }
      }
  }
  public void conmutaExtension() {
      if (ckOpcionDos.isSelected()) {
	  txtExtension.setEnabled(true);
      } else {
	  txtExtension.setEnabled(false);
      }
  }
  public void toolTip() {
      ToolTipManager.sharedInstance().setEnabled(true);
  }
  public void actualizaMp3() {
      pistaInfo.setText("");
      artistaInfo.setText("");
      cancionInfo.setText("");
      albumInfo.setText("");
      anyoInfo.setText("");
      generoInfo.setText("");      
      tomaArchivos();
      okSeleccion = checkAudioSeleccion();
//      eligeSeleccion();
      if (okSeleccion.length > 0) {
	setCursor(new Cursor(Cursor.WAIT_CURSOR));
	archivosOriginales = oArchivos.getAbstractFiltrado();
	muestraBarra(true,Idioma.getBarMp3());
	jProgreso.setStringPainted(false);
	jProgreso.setIndeterminate(true);
	ActualizaMp3 doActualizaMp3 = new ActualizaMp3();
	doActualizaMp3.execute();
      }
  }
  public void limpiaMp3(){
      txtPista.setText("");
      txtArtista.setText("");
      txtCancion.setText("");
      txtAlbum.setText("");
      txtAnyo.setText("");
      txtGenero.setText("");
      txtPista.setNumero(true);
      txtAnyo.setNumero(true);
      ckPista.setSelected(false);
      pnlPistaIzq.setEnabled(true);
      pnlArtistaIzq.setEnabled(true);
      pnlCancionIzq.setEnabled(true);
      pnlAlbumIzq.setEnabled(true);
      pnlAnyoIzq.setEnabled(true);
      pnlGeneroIzq.setEnabled(true);
      arrayTablaMp3 = null;
      intComboMp3 = new Integer[6];
  }
  public void capitalizaBusca(){
    if (jCapitaliza.getSelectedIndex() == 4) {
	jCapitaliza.setPreferredSize(new Dimension(210,22));
	jCapitaliza.setMaximumSize(new Dimension(210,22));
	txtSymbols = new JTextField(txtSymbols.getText());
	txtSymbols.setPreferredSize(new Dimension(75,22));
	txtSymbols.setMaximumSize(new Dimension(500,22));
	txtSymbols.setName("txtSymbols");
	txtSymbols.addKeyListener(cc);
	pnlCapitaliza.removeAll();
	pnlCapitaliza.add(opCapitaliza);
	pnlCapitaliza.add(Box.createRigidArea(new Dimension(5,0)));
	pnlCapitaliza.add(jCapitaliza);
	pnlCapitaliza.add(Box.createRigidArea(new Dimension(5,0)));
	pnlCapitaliza.add(txtSymbols);
    } else {
	jCapitaliza.setPreferredSize(new Dimension(320,22));
	jCapitaliza.setMaximumSize(new Dimension(600,22));
	pnlCapitaliza.removeAll();
	pnlCapitaliza.add(opCapitaliza);
	pnlCapitaliza.add(Box.createRigidArea(new Dimension(5,0)));
	pnlCapitaliza.add(jCapitaliza);
    }
    pnlCapitaliza.updateUI();
  }
  public void numerosBusca() {
    if (jNumeros.getSelectedIndex() == 0) {
	jNumeros.setPreferredSize(new Dimension(120,22));
	jNumeros.setMaximumSize(new Dimension(500,22));
	lblNormaPosicion = new JLabel(Idioma.getNormaPosition()+":");
	setFont(lblNormaPosicion,11,Font.PLAIN);
	Object valorPosicion = normaPosicion.getModel().getValue();
	normaPosicion = new JSpinner(spNormaPosicion);
	normaPosicion.getModel().setValue(valorPosicion);
	normaPosicion.setPreferredSize(new Dimension(43,23));
	normaPosicion.setMaximumSize(new Dimension(43,23));
	setFont(normaPosicion, 10, Font.PLAIN);
	lblNormaCeros = new JLabel(Idioma.getNormaCeros()+":");
	setFont(lblNormaCeros,11,Font.PLAIN);
	Object valorCeros = normaCeros.getModel().getValue();
	normaCeros = new JSpinner(spNormaCeros);
	normaCeros.getModel().setValue(valorCeros);
	normaCeros.setPreferredSize(new Dimension(43,23));
	normaCeros.setMaximumSize(new Dimension(43,23));
	setFont(normaCeros, 10, Font.PLAIN);
	pnlNumeros.removeAll();
	pnlNumeros.add(opNumeros);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(jNumeros);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(lblNormaPosicion);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(normaPosicion);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(lblNormaCeros);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(normaCeros);
    } else if (jNumeros.getSelectedIndex() == 1) {
	jNumeros.setPreferredSize(new Dimension(95,22));
	jNumeros.setMaximumSize(new Dimension(500,22));
	lblNumerosEn = new JLabel(Idioma.getNumberLabel());
	setFont(lblNumerosEn,11,Font.PLAIN);
	Object valorEn = numerosEn.getModel().getValue();
	numerosEn = new JSpinner(spNumerosEn);
	numerosEn.getModel().setValue(valorEn);
	numerosEn.setPreferredSize(new Dimension(43,23));
	numerosEn.setMaximumSize(new Dimension(43,23));
	setFont(numerosEn, 10, Font.PLAIN);
	lblNumerosSalto = new JLabel(Idioma.getNumberSkip());
	setFont(lblNumerosSalto,11,Font.PLAIN);
	Object valorSalto = numerosSalto.getModel().getValue();
	numerosSalto = new JSpinner(spNumerosSalto);
	numerosSalto.getModel().setValue(valorSalto);
	numerosSalto.setPreferredSize(new Dimension(43,23));
	numerosSalto.setMaximumSize(new Dimension(43,23));
	setFont(numerosSalto, 10, Font.PLAIN);
	lblNormaPosicion = new JLabel(Idioma.getNormaPosition()+":");
	setFont(lblNormaPosicion,11,Font.PLAIN);
	Object valorPosicion = numerosPosicion.getModel().getValue();
	numerosPosicion = new JSpinner(spNumerosPosicion);
	numerosPosicion.getModel().setValue(valorPosicion);
	numerosPosicion.setPreferredSize(new Dimension(43,23));
	numerosPosicion.setMaximumSize(new Dimension(43,23));
	setFont(numerosPosicion, 10, Font.PLAIN);
	pnlNumeros.removeAll();
	pnlNumeros.add(opNumeros);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(jNumeros);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(lblNormaPosicion);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(numerosPosicion);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(lblNumerosEn);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(numerosEn);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(lblNumerosSalto);
	pnlNumeros.add(Box.createRigidArea(new Dimension(5,0)));
	pnlNumeros.add(numerosSalto);
    }
    pnlNumeros.updateUI();
  }
  public void normalizaBusca(){
    if (jNormaliza.getSelectedIndex() == 3) {
      	jNormaliza.setPreferredSize(new Dimension(120,22));
      	jNormaliza.setMaximumSize(new Dimension(500,22));
      	lblNormalizaTrim = new JLabel(Idioma.getLengthOne()+":");
      	setFont(lblNormalizaTrim,11,Font.PLAIN);
      	Boolean estadoTrim = desdeDerechaTrim.isSelected();
      	Object valorNormaliza = normalizaTrim.getModel().getValue();
      	desdeDerechaTrim = new JCheckBox(Idioma.getMainRight());
      	desdeDerechaTrim.setSelected(estadoTrim);
      	desdeDerechaTrim.setName("desdeDerechaTrim");
      	desdeDerechaTrim.addActionListener(cc);
      	normalizaTrim = new JSpinner(spNormalizaTrim);
      	normalizaTrim.getModel().setValue(valorNormaliza);
      	normalizaTrim.setPreferredSize(new Dimension(43,23));
      	normalizaTrim.setMaximumSize(new Dimension(43,23));
      	setFont(normalizaTrim, 8, Font.PLAIN);
      	setFont(desdeDerechaTrim, 9, Font.PLAIN);
      	pnlNormaliza.removeAll();
      	pnlNormaliza.add(opNormaliza);
      	pnlNormaliza.add(Box.createRigidArea(new Dimension(5,0)));
      	pnlNormaliza.add(jNormaliza);
      	pnlNormaliza.add(Box.createRigidArea(new Dimension(5,0)));
      	pnlNormaliza.add(lblNormalizaTrim);
      	pnlNormaliza.add(Box.createRigidArea(new Dimension(5,0)));
      	pnlNormaliza.add(normalizaTrim);
      	pnlNormaliza.add(Box.createRigidArea(new Dimension(5,0)));
      	pnlNormaliza.add(desdeDerechaTrim);
    } else {
      	jNormaliza.setPreferredSize(new Dimension(300,22));
      	jNormaliza.setMaximumSize(new Dimension(300,22));
      	pnlNormaliza.removeAll();
      	pnlNormaliza.add(opNormaliza);
      	pnlNormaliza.add(Box.createRigidArea(new Dimension(5,0)));
      	pnlNormaliza.add(jNormaliza);
    }
    pnlNormaliza.updateUI();
  }
  

  public void panelModelo() {
      listArchivosModel = new MyTableModel();
      Boolean checkSeleccionado;
      for (int x=0;x<Archivos.length;x++) {
	  if (seleccionCheck.contains(x)) {
	      checkSeleccionado = true;
	  } else {
	      checkSeleccionado = false;
	  }
	  listArchivosModel.addRow(new Object[]{checkSeleccionado, archivosOriginales[x].getName()});
      }
  }
  private void setPanelArchivos() {
      Boolean fotoPreview = false;
      listArchivos.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererTablaCheck(modoLog));
      listaSeleccion = new ArrayList<>();
      if ( ! modoLog ) {
	  listArchivos.setDragEnabled(true);
	  listArchivos.setDropMode(DropMode.INSERT);
	  listArchivos.setTransferHandler(new MyListDropHandler(listArchivos));
          MyDragListener myDragListener = new MyDragListener(listArchivos);
	  if (iniciaRenderer.equals("default")) {
	      fotoPreview = false;
	  } else {
	      fotoPreview = true;
	  }
          ficherosImportadosAdd = new LinkedList<>(Arrays.asList(archivosOriginales));
	  listArchivos.getColumnModel().getColumn(1).setCellRenderer(new MyCellRendererTabla(archivosOriginales, getSistema(), (modoDrop || ( ckRecursivo != null && ckRecursivo.isSelected() ) ), fotoPreview, Idioma));
	  pnlArchivos.setBorder(BorderFactory.createTitledBorder(Idioma.getTitleOriginals()));
      } else {
	  listArchivos.getColumnModel().getColumn(1).setCellRenderer(new MyCellRendererTabla(archivosOriginales, getSistema(), (modoDrop || ( ckRecursivo != null && ckRecursivo.isSelected() ) ), fotoPreview, Idioma));
	  pnlArchivos.setBorder(BorderFactory.createTitledBorder(Idioma.getLogCurrent()));
      }
      if (modoDrop && archivosOriginales.length == 0) {
	  DraftWatermark draft = new DraftWatermark(scrArchivos);
	  pnlArchivos.add(scrArchivos);
      }
      SwingUtilities.invokeLater(new Runnable() {
	  @Override
	  public void run() {
	      scrArchivos.setBorder(null);
	  }
      });
  }
  public void panelArchivos() {
    derecho = false;
    listArchivos = new JTable() {
        @Override
	protected void processMouseEvent(MouseEvent e) {
	    Boolean shift = (e.getModifiersEx() & MouseEvent.SHIFT_DOWN_MASK) != 0;
	    Boolean control = (e.getModifiersEx() & MouseEvent.CTRL_DOWN_MASK) != 0;
	    if (e.getID() == MouseEvent.MOUSE_ENTERED) {
		ToolTipManager.sharedInstance().setEnabled(true);
	    }
	    if (e.getID() == MouseEvent.MOUSE_EXITED) {
		ToolTipManager.sharedInstance().setEnabled(false);
	    }
	    if ( doNavega == null || doNavega.isDone() ) {
		try {
		    if (e.getID() == MouseEvent.MOUSE_PRESSED) {
			listRenombrados.clearSelection();
			if (this.columnAtPoint(e.getPoint()) == 1) {
			    muestraFoto = false;
			    doPop(e);
			    Boolean estaSeleccionado = false;
			    Boolean primero = false;
			    index = this.rowAtPoint(e.getPoint());
			    okSeleccion = this.getSelectedRows();  
			    if (okSeleccion.length > 0 && ! derecho) { 
				if (okSeleccion.length > 1 || okSeleccion[0] != index) {
				    muestraFoto = true;
				}
			    } else if ( ! derecho && archivosOriginales.length > 0) {
				muestraFoto = true;
			    }
			    int indexOne = this.getSelectedRow();
			    int[] indexArray = this.getSelectedRows();
			    int indexDos = indexArray[indexArray.length -1];
			    super.processMouseEvent(e);
			    if (e.getClickCount() == 2 && ! ckRecursivo.isSelected()) {
				if (archivosOriginales[index].isDirectory()) {
                                    if ( ! modoDrop ) {
                                        reseteaRenombrados = true;
                                        navega(actualiza(index));
                                        index = 0;
                                    }
				} else {
                                    String[] abre;
                                    abre = switch (getSistema()) {
                                        case "mac" -> new String[]{"open", archivosOriginales[index].toString()};
                                        case "windows" -> new String[]{"rundll32", "url.dll,FileProtocolHandler", archivosOriginales[index].getAbsolutePath()};
                                        default -> new String[]{"xdg-open", archivosOriginales[index].toString()};
                                    };
                                    try {
                                        Runtime.getRuntime().exec(abre);
                                    } catch (IOException r) {
                                    }
                                }
			    }
			    if (!shift && !control) {
				if (index < indexOne || index > indexDos) 
				    this.setRowSelectionInterval(this.rowAtPoint(e.getPoint()), this.rowAtPoint(e.getPoint()));
				else if (compruebaCorrelativos(okSeleccion)) {
				    this.setRowSelectionInterval(indexOne,indexDos);
				    okSeleccion = this.getSelectedRows();
				}
			    }
			} else if (this.columnAtPoint(e.getPoint()) == 0) {
			    pulsaCheck(this.rowAtPoint(e.getPoint()));
			}
		    }
		} catch (Exception j) {
		    super.processMouseEvent(e);
		}
		if (e.getID() == MouseEvent.MOUSE_RELEASED) {
		    if (this.columnAtPoint(e.getPoint()) == 1) {
			try {
			    fotoArchivo = archivosOriginales[index];
			} catch (ArrayIndexOutOfBoundsException a) {
			    index = 0;
			}
			if (!shift && !control && !derecho) {
			    try {
				this.setRowSelectionInterval(this.rowAtPoint(e.getPoint()), this.rowAtPoint(e.getPoint()));
			    } catch (IllegalArgumentException i) {
			    }
			}
                        if ( fotoArchivo.getName().equals("..") )
                            muestraInfo(false, false);
                        else {
                            if ( muestraFoto && !shift && !control) {
                                try {
                                    muestraInfo(false, true);
                                } catch (Exception j) {
                                }
                            } else if ( ( modoDrop && ! ficherosImportadosAdd.isEmpty() ) && muestraFoto && !shift && !control ) {
                                try {
                                    muestraInfo(false, true);
                                } catch (Exception j) {
                                }
                            }
                        }
			doPop(e);	  
			derecho = false;
		    }
		}
	    }
	}
        @Override
	protected void processKeyEvent(KeyEvent e) {
	    if ( (doNavega == null || doNavega.isDone())  && (doSeleccionadosNuevo == null || doSeleccionadosNuevo.isDone()) ) {
		try {
		  if (e.getID() == KeyEvent.KEY_PRESSED) {  
		      if (e.getKeyCode() != 10) {
			  super.processKeyEvent(e);
		      }
		      if (this.getSelectedColumn() == 0 && e.getKeyCode() == 32) {
			  pulsaCheck(this.getSelectedRow());
		      }
		  }
		  if (e.getID() == KeyEvent.KEY_RELEASED) {  
		      super.processKeyEvent(e);
		      if (e.getKeyCode() == 10 && archivosOriginales[listArchivos.getSelectedRow()].isDirectory() && ! modoDrop && ! ckRecursivo.isSelected()) {
			  reseteaRenombrados = true;
			  navega(actualiza(listArchivos.getSelectedRow()));
			  cambiaFoco = true;
		      }
		      if ( e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			  fotoArchivo = archivosOriginales[listArchivos.getSelectedRow()];
//			  if (automaticPreview && ! modoDrop)
//			      seleccionadosNuevo();
//			  else
			  if ( fotoArchivo.getName().equals("..") )
			      muestraInfo(false, false);
			  else
			      muestraInfo(false,true);
		      }
		  }
		} catch (Exception j) {
		}
	    }
	}
    };

    listArchivos.setRowSelectionAllowed(true);
    listArchivos.setShowGrid(false);
    listArchivos.setModel(listArchivosModel);
    listArchivos.setName("listArchivos");
    listArchivos.setFillsViewportHeight(true);
    listArchivos.setTableHeader(null);
    listArchivos.setAutoCreateColumnsFromModel(false);
//     listArchivos.addKeyListener(cc);
    setFont(listArchivos,11,Font.PLAIN);
    listArchivos.setRowHeight(25);
    listArchivos.getColumnModel().getColumn(0).setMaxWidth(25);
    listArchivos.getColumnModel().getColumn(1).sizeWidthToFit();
    scrArchivos = new JScrollPane(listArchivos);
    scrArchivos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    pnlArchivos.add(scrArchivos);
    scrArchivos.setPreferredSize(new Dimension(515,150));
    setPanelArchivos();
  }
  public void doPop(MouseEvent e) {
      if (e.isPopupTrigger()) {
	  derecho = true;
	  popMenu.show(e.getComponent(), e.getX(), e.getY());
      }
  }
  private void modeloRenombrados() {
      listRenombradosModel = new DefaultTableModel(Renombrados.length, 1);
      for (int x=0;x<Renombrados.length;x++) {
	  listRenombradosModel.setValueAt(Renombrados[x].toString(),x,0);
      }
  }
  public void panelRenombrados() {
      if ( ! modoLog ) {
	  listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0));
	  pnlRenombrados.setBorder(BorderFactory.createTitledBorder(Idioma.getTitlePreviews()));
      } else {
	  listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0));
	  TitledBorder colorBorde;
	  if (ckCopiaCarpeta.isSelected()) {
	      colorBorde = BorderFactory.createTitledBorder(Idioma.getLogRecover());
	      colorBorde.setTitleFont(new Font(Idioma.getLogRecover(),1,11));
	  } else {
	      colorBorde = BorderFactory.createTitledBorder(Idioma.getLogRecover());
	      colorBorde.setTitleFont(new Font(Idioma.getLogRecover(),1,11));
	  }
	  colorBorde.setTitleColor(Color.RED);
	  pnlRenombrados.setBorder(colorBorde);
      }
      if ( ckCopiaCarpeta != null && ! ckCopiaCarpeta.isSelected() ) {
	  scrRenombrados.getVerticalScrollBar().setModel(new DefaultBoundedRangeModel());
	  scrRenombrados.getVerticalScrollBar().setModel(scrArchivos.getVerticalScrollBar().getModel());
	  scrRenombrados.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
      }
      listRenombrados.setModel(listRenombradosModel);
  }
  public void renombrados() {
      if (okSeleccionRe == null) okSeleccionRe = new int[0];
      if (!ckCopiaCarpeta.isSelected()) {
	  pnlRenombrados.setBorder(BorderFactory.createTitledBorder(Idioma.getTitlePreviews()));
	  listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0));
	  scrRenombrados.getVerticalScrollBar().setModel(new DefaultBoundedRangeModel());
	  scrRenombrados.getVerticalScrollBar().setModel(scrArchivos.getVerticalScrollBar().getModel());
	  scrRenombrados.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
	  m24.setEnabled(true);
      } else {
	  TitledBorder colorBorde;
	  if (comboCarpeta.getSelectedIndex() == 0) {
	      colorBorde = BorderFactory.createTitledBorder(Idioma.getCopyLabel()+rutaRenombrados.replace(rutaHome,"HOME"));
	      colorBorde.setTitleFont(new Font(Idioma.getCopyLabel()+rutaRenombrados.replace(rutaHome,"HOME"),1,11));
	  } else {
	      colorBorde = BorderFactory.createTitledBorder(Idioma.getMoveLabel()+rutaRenombrados.replace(rutaHome,"HOME"));
	      colorBorde.setTitleFont(new Font(Idioma.getMoveLabel()+rutaRenombrados.replace(rutaHome,"HOME"),1,11));
	  }
	  colorBorde.setTitleColor(Color.RED);
	  pnlRenombrados.setBorder(colorBorde);
	  scrRenombrados.getVerticalScrollBar().setPreferredSize(scrArchivos.getVerticalScrollBar().getPreferredSize());
	  listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererRenom(rutaRenombrados, okSeleccionRe, indicesMarcar, 0));
	  m24.setEnabled(false); 
      }
      listRenombrados.setModel(listRenombradosModel);
  }
  private void creaPanelRe() {
      listRenombrados = new JTable() {
	  @Override
	  public boolean isCellEditable(int row, int column) {
	      super.isCellEditable(row,column);
	      if ( ! ckCopiaCarpeta.isSelected() ) {
		  if (seleccionCheck.contains(row) && row != 0) {
		      return true;
		  }
	      } else {
		  for (int in : okSeleccionRe) {
		      if (in == row && row != 0) {
			  return true;
		      }
		  }
	      }
	      return false;
	  }
	  @Override
	  protected void processMouseEvent(MouseEvent e) {
	      super.processMouseEvent(e);
	      if ( doNavega == null || doNavega.isDone() ) {
		  try {
		    if (e.getID() == MouseEvent.MOUSE_CLICKED) {
			if (this.isEditing())   
			    this.getCellEditor().stopCellEditing();
			if (e.getClickCount() == 2 && ckCopiaCarpeta.isSelected()) {
			      if (this.isEditing())
				  this.getCellEditor().stopCellEditing();
			      int indexRe = this.rowAtPoint(e.getPoint());
			      File cheqRuta;
			      if (Renombrados[indexRe].toString().equals("..")) {
				    cheqRuta = new File(new File(rutaRenombrados).getParent());
			      } else {
				    cheqRuta = new File(rutaRenombrados + Renombrados[indexRe]);
			      }
			      if (cheqRuta.isDirectory() && cheqRuta.canRead()) {
				  rutaRenombrados = cheqRuta.toString() + separador;
				  pasaCopia(true);
			      }
			}
			limpiaSeleccion();
		    }
		  } catch (Exception ex){
		  }
	      }
	      if (e.getID() == MouseEvent.MOUSE_RELEASED) {
		  if (this.isEditing()) {
		      JTextField celda = (JTextField) this.getEditorComponent();
		      celda.selectAll();
		  }
	      }
	      if (e.getID() == MouseEvent.MOUSE_ENTERED) {
		  ToolTipManager.sharedInstance().setEnabled(true);
	      }
	  }
	  @Override
	  protected void processKeyEvent(KeyEvent e) {
	      super.processKeyEvent(e);
	      if (e.getID() == KeyEvent.KEY_PRESSED) {
                  if (this.isEditing()) {
                      final JTextField celda = (JTextField) this.getEditorComponent();
                      celda.selectAll();
                      celda.requestFocusInWindow();
                      SwingUtilities.invokeLater(new Runnable() {
                          @Override
                          public void run() {
                              celda.select(0,0);
                              celda.setCaretPosition(1);
                          }
                      });
                  }
	      }
          }
	};
	listRenombrados.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
	    @Override
	    public void editingCanceled(ChangeEvent e) {
	    }
	    @Override
	    public void editingStopped(ChangeEvent e) {
		TableCellEditor cellSource = (TableCellEditor) e.getSource();
		int filaAbierta = listRenombrados.getSelectedRow();
		String renombradoManual = cellSource.getCellEditorValue().toString();
                try {
                    if (renombradoManual.equals("")) {
                        listRenombradosModel.setValueAt(Renombrados[filaAbierta].toString(),filaAbierta,0);
                        return;
                    }
                    Renombrados[filaAbierta] = new StringBuffer().append(renombradoManual);
		    if (ckCopiaCarpeta.isSelected()) {
			seleccionCancelada = mBusca.checkRepetidosCopia(rutaRenombrados, okSeleccionRe, okSeleccion, Renombrados, RenombradosEstructura, Archivos, getSistema());
			indicesMarcar = mBusca.getIndicesMarcar();
			indicesCambiados = mBusca.getIndicesCambiados();
			listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererRenom(rutaRenombrados, okSeleccionRe, indicesMarcar, 0));
		    } else {
			seleccionCancelada = mBusca.checkRepetidos(Renombrados, archivosOriginales, getSistema());
			indicesMarcar = mBusca.getIndicesMarcar();
			indicesCambiados = mBusca.getIndicesCambiados();
			oArchivos.setRenombrados(Renombrados);
			listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0));
		    }
		    listRenombrados.repaint();
		    if ( ! indicesCambiados.isEmpty() ) {
			if ( ! btnAplicar.isEnabled() ) {
			    btnAplicar.setEnabled(true);
                            btnAplicar.setIcon(aplicarBigOk);
			    m16.setEnabled(true);
			    new Blink().execute();
			}
		    } else {
			btnAplicar.setEnabled(false);
                        btnAplicar.setIcon(aplicarBigBWOk);
			m16.setEnabled(false);
		    }
		} catch (ArrayIndexOutOfBoundsException | NullPointerException i) {
		    indicesCambiados = new ArrayList<>();
		    indicesMarcar = new ArrayList<>();
		    if (modoDrop) {
			actualizaDespuesDrop();
		    } else {
			actualizaDespuesAplicar(ruta);
		    }
		}
	    }
	});
	listRenombrados.setModel(listRenombradosModel);
	listRenombrados.setRowSelectionAllowed(true); 
	listRenombrados.setFillsViewportHeight(true);
	listRenombrados.setTableHeader(null);
	listRenombrados.setAutoCreateColumnsFromModel(false);
	listRenombrados.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
	setFont(listRenombrados,11,Font.PLAIN);
	listRenombrados.setRowHeight(25);
	listRenombrados.setGridColor(new Color(240,240,240));
	scrRenombrados = new JScrollPane(listRenombrados);
	scrRenombrados.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrRenombrados.setPreferredSize(new Dimension(320,150));
	pnlRenombrados.add(scrRenombrados);
	scrRenombrados.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		scrRenombrados.setBorder(null);
	    }
	});
  }

  public String getSistema() {
      String sistema = System.getProperty("os.name");
      if (sistema.startsWith("Mac")) {
	  return "mac";
      } else if (sistema.startsWith("Win")) {
	  return "windows";
      } else {
	  return "linux";
      }
  }
  public String getRuta(){
    reseteaRenombrados = true;
    limpia(true);
    ruta = chequeaRuta(ruta);
    return ruta;
  }
  public String getRutaFiltrando(){
    ruta = chequeaRuta(ruta);
    return ruta;
  }
  public String getRutaRenombrados(){
    return rutaRenombrados;
  }
  public String cambiaRuta(){
    ruta = chequeaRuta(ruta);
    rutaAnterior = ruta;
    cierraDrop();
    if ( doNavega == null || doNavega.isDone() ) {
	ckRecursivo.setSelected(false);
	reseteaRenombrados = true;
	tRuta = (JTextField)jRuta.getEditor().getEditorComponent();
	File cheqRuta = new File (tRuta.getText());
	if (cheqRuta.isDirectory() && cheqRuta.canRead() && ( getSistema().equals("windows") || cheqRuta.toString().startsWith(separador) ))
	    ruta = cheqRuta.toString() + separador;
	if ( ! ruta.replaceAll("[a-zA-Z0-9]$","").equals(ruta) && ! ruta.equals(separador) ) 
            ruta += separador;
	jRuta.removeItemAt(jRuta.getItemCount() -1);
	jRuta.addItem(ruta);      
	jRuta.setSelectedIndex(jRuta.getItemCount() -1);
    } else {
	if (!ruta.replaceAll("[a-zA-Z0-9]$","").equals(ruta) && !ruta.equals(separador)) 
            ruta += separador;
	jRuta.removeItemAt(jRuta.getItemCount()-1);
	jRuta.addItem(ruta);      
	jRuta.setSelectedIndex(jRuta.getItemCount()-1);
    }
    return ruta;
  }
  public String cambiaRutaBotones(String rutaBotones) {
      if ( doNavega == null || doNavega.isDone() ) {
	  cierraDrop();
	  ruta = chequeaRuta(ruta);
	  rutaAnterior = ruta;
	  ckRecursivo.setSelected(false);
	  File cheqRuta = new File (rutaBotones);
	  if (!cheqRuta.isDirectory() || !cheqRuta.canRead()) rutaBotones = ruta;
//		  System.err.println(MessageFormat.format("Cambia ruta botones: {0}",rutaBotones));
	  jRuta.removeItemAt(jRuta.getItemCount()-1);
	  jRuta.addItem(rutaBotones);      
	  jRuta.setSelectedIndex(jRuta.getItemCount()-1);
      }
      return rutaBotones;
  }
  public String actualiza(int index) {
    rutaAnterior = ruta;
    this.index=index;
    String rutaAhora;
    if ( doNavega == null || doNavega.isDone() ) {
      newRuta=""+Archivos[index]+separador;
      File cheqRuta = new File(ruta+newRuta);
      rutaActual = new File(ruta);
      if (cheqRuta.isDirectory() && cheqRuta.canRead()){
	if (newRuta.equals(".."+separador)) {
	  ruta = rutaActual.getParent();
	  cheqRuta = new File(ruta);
	  if (cheqRuta.getParent() != null) ruta = ruta+separador;
	}
	else ruta = ruta+newRuta;
	}
      rutaAhora = ruta;
      jRuta.removeItemAt(jRuta.getItemCount()-1);
      jRuta.addItem(rutaAhora);      
      jRuta.setSelectedIndex(jRuta.getItemCount()-1);      
    }
    else rutaAhora = ruta;
    return rutaAhora;
  }
  public void restauraOriginalesDrop() {
      archivosOriginales = new File[archivosOriginalesDrop.length];
      System.arraycopy(archivosOriginalesDrop, 0, archivosOriginales, 0, archivosOriginalesDrop.length);
      actualizaDespuesDrop();
  }
  public void setDropOriginales (File[] archivosOriginales) {
      this.archivosOriginales = archivosOriginales;
      ficherosImportadosAdd = new LinkedList<>(Arrays.asList(archivosOriginales));
  }
  public void actualizaDespuesDrop() {
      RenombradosCopia = new StringBuffer[archivosOriginales.length];
      for (int x=0;x<archivosOriginales.length;x++) {
	  RenombradosCopia[x] = new StringBuffer().append(archivosOriginales[x].getName());
      }
      dropAplicado = true;
      muestraInfo(false, false);
      navega(ruta);
  }
  public void actualizaDespuesAplicar(String ruta) {
      this.ruta=ruta;
      indicesCambiados = new ArrayList<>();
      indicesMarcar = new ArrayList<>();
      arrayTablaMp3 = null;
      okSeleccion = new int[0];
      okSeleccionRe = new int[0];
      btnPreview.setEnabled(false);
      comboSelecAplica.setEnabled(false);
      m15.setEnabled(false);
      btnAplicar.setEnabled(false);
      btnAplicar.setIcon(aplicarBigBWOk);
      m16.setEnabled(false);
      ckRecursivo.setSelected(false);
      tomaFicheros(filtrado, m42.isSelected(), ckCase.isSelected(), ckExcluye.isSelected(), ckRecursivo.isSelected(), Idioma);
      regeneraCheck();
      panelModelo();
      setPanelArchivos();
      listArchivos.setModel(listArchivosModel);
      if ( ! ckCopiaCarpeta.isSelected() ) 
	  rutaRenombrados=ruta;
      tomaRenombrados();
      modeloRenombrados();
      renombrados();
      fotoArchivo = new File (ruta);
      muestraInfo(false, false);
      atributos();
      btnLimpiar.setEnabled(true);
      actualizaNavegador();
      if (modoLog) {
	  ckCopiaCarpeta.setSelected(restauraCkCopia);
	  comboCarpeta.setSelectedIndex(restauraComboCarpeta);
      }
  }
  public void desactivaCopiaCarpeta() {
	  indicesCambiados = new ArrayList<>();
	  indicesMarcar = new ArrayList<>();
	  tomaRenombrados();
	  modeloRenombrados();
	  renombrados();
	  RenombradosCopia = Arrays.copyOf(Renombrados,Renombrados.length);
	  SwingUtilities.invokeLater(new Runnable() {
	      @Override
	      public void run() {
		  scrArchivos.getVerticalScrollBar().setValue(0);
	      }
	  });
	  if (automaticPreview)
	      seleccionadosNuevo();
  }
  public void navega(final String ruta) {
      this.ruta=ruta;
      arrayTablaMp3 = null;
      if ( doNavega == null || doNavega.isDone() ) {
	  try {
	      doSeleccionadosNuevo.get();
	  } catch (InterruptedException | ExecutionException | NullPointerException e) {
	  }
	  indicesCambiados = new ArrayList<>();
	  indicesMarcar = new ArrayList<>();
	  btnLimpiar.setEnabled(true);
	  btnAplicar.setEnabled(false);
          btnAplicar.setIcon(aplicarBigBWOk);
	  m16.setEnabled(false);
	  if (modoLog) {
	      ckCopiaCarpeta.setSelected(restauraCkCopia);
	      comboCarpeta.setSelectedIndex(restauraComboCarpeta);
	  }
	  if ( ! modoDrop ) {
	      modoLog = false;
	      btnPreview.setEnabled(false);
	      comboSelecAplica.setEnabled(false);
	      m15.setEnabled(false);
	      reseteaRenombrados = true;
	      limpia(true);
	      okSeleccion = new int[0];
	      okSeleccionRe = new int[0];
	      muestraBarra(true,Idioma.getBarBrowse());
	      jProgreso.setStringPainted(false);
	      jProgreso.setIndeterminate(true);	
	      doNavega = new Navegando();
	      doNavega.execute();
	  } else {
	      btnPreview.setEnabled(true);
	      comboSelecAplica.setEnabled(true);
	      m15.setEnabled(true);
	      ficherosImportadosAdd = new ArrayList<>();
	      ficherosImportados = new LinkedList<>(Arrays.asList(archivosOriginales));
	      archivosOriginales = new File[0];
	      if (modoLog)
		  modoLog = false;
	      dropExterno(0, true, true, false);
	      contenidoCarpetaLog = null;
	  }
      } else if ( ! doNavega.isDone() ) {
	  cancelaCopia();
      }
  }

  public void comienzaCarga() {
      muestraInfo(true, false);
      setCursor(new Cursor(Cursor.WAIT_CURSOR));
      new Cargando().execute();
  }

  public void comienzaPreview() {
      muestraInfo(true, false);
      setCursor(new Cursor(Cursor.WAIT_CURSOR));
      new Visualizando().execute();
  }
  private void tomaTodos() {
      if (archivosOriginales.length > oArchivos.getUltimaCarpeta() + 1) {
	  okSeleccion = new int[archivosOriginales.length - (oArchivos.getUltimaCarpeta() +1)];
	  int y = 0;
	  for (int x=oArchivos.getUltimaCarpeta() + 1;x<archivosOriginales.length;x++) {
	      okSeleccion[y] = x;
	      y++;
	  }
      } else {
	  okSeleccion = new int[0];
      }
  }
  private void tomaSeleccion() {
      if (seleccionCheck.size() > 0) {
	  if (archivosOriginales.length == seleccionCheck.size()) {
	      okSeleccion = new int[seleccionCheck.size() - 1];
	  } else {
	      okSeleccion = new int[seleccionCheck.size()];
	  }
	  int y = 0;
	  for (int x=0;x<seleccionCheck.size();x++) {
	      if ( ! archivosOriginales[seleccionCheck.get(x)].getName().equals("..") ) {
		  okSeleccion[y] = seleccionCheck.get(x);
		  y++;
	      }
	  }
	  Arrays.sort(okSeleccion);
      } else {
	  okSeleccion = new int[0];
      }
  }
  private void tomaArchivos() {
      java.util.List<Integer> seleccionCheckArchivos = (java.util.List<Integer>) seleccionCheck.clone();
      ListIterator archivosIterator = seleccionCheckArchivos.listIterator();
      while (archivosIterator.hasNext()) {
	  int indiceArchivo = (int) archivosIterator.next();
	  if (archivosOriginales[indiceArchivo].isDirectory())
	      archivosIterator.remove();
      }
      okSeleccion = new int[seleccionCheckArchivos.size()];
      for (int x=0;x<okSeleccion.length;x++)
	  okSeleccion[x] = seleccionCheckArchivos.get(x);
      Arrays.sort(okSeleccion);
  }
  private void regeneraCheck() {
      seleccionCheck = new ArrayList<>();
      for (int x=0;x<archivosOriginales.length;x++) {
	  if (archivosCheck.contains(archivosOriginales[x]))
	      seleccionCheck.add(x);
      }
      if (seleccionCheck.size() == archivosOriginales.length -1 && ! seleccionCheck.contains(0)) {
	  seleccionCheck.add(0);
	  archivosCheck.add(archivosOriginales[0]);
      }
      if (seleccionCheck.size() < archivosOriginales.length && seleccionCheck.contains(0)) {
	  seleccionCheck.remove(0);
	  archivosCheck.remove(archivosOriginales[0]);
      }
      if (seleccionCheck.size() == 1 && seleccionCheck.contains(0)) {
	  seleccionCheck.remove(0);
	  archivosCheck.remove(archivosOriginales[0]);
      }
  }
  private void eligeSeleccionCheck() {
      seleccionCheck = new ArrayList<>();
      archivosCheck = new ArrayList<>();
      if ( modoDrop || (ckRecursivo != null && ckRecursivo.isSelected()) ) {
	  for (int x=0;x<archivosOriginales.length;x++) {
	      seleccionCheck.add(x);
	      archivosCheck.add(archivosOriginales[x]);
	  }
      } else {
	  if (oArchivos.getUltimaCarpeta()+1<=Archivos.length-1) {
	      if (oArchivos.getUltimaCarpeta() == 0) {
		  seleccionCheck.add(0);
		  archivosCheck.add(archivosOriginales[0]);
	      }
	      for (int x=oArchivos.getUltimaCarpeta()+1;x<Archivos.length;x++) {
		  seleccionCheck.add(x);
		  archivosCheck.add(archivosOriginales[x]);
	      }
	  }
      }
  }
  private void eligeSeleccionCheck(int primerCheck, int ultimoCheck) {
      for (int x=primerCheck;x<ultimoCheck;x++) {
	  seleccionCheck.add(x);
	  archivosCheck.add(archivosOriginales[x]);
      }
  }
  private void pulsaCheck(int fila) {
      Boolean valorCheck = (Boolean) listArchivos.getModel().getValueAt(fila, 0);
      if (valorCheck) {
	  seleccionCheck.remove(Integer.valueOf(fila));
	  archivosCheck.remove(archivosOriginales[fila]);
	  if (seleccionCheck.contains(0)) {
	      seleccionCheck.remove(Integer.valueOf(0));
	      archivosCheck.remove(archivosOriginales[0]);
	      listArchivos.getModel().setValueAt( ! valorCheck, 0, 0);
	  }
      } else {
	  seleccionCheck.add(fila);
	  archivosCheck.add(archivosOriginales[fila]);
	  if (seleccionCheck.size() == archivosOriginales.length -1 && ! seleccionCheck.contains(0)) {
	      seleccionCheck.add(0);
	      archivosCheck.add(archivosOriginales[0]);
	      listArchivos.getModel().setValueAt( ! valorCheck, 0, 0);
	  }
      }
      listArchivos.getModel().setValueAt( ! valorCheck, fila, 0);
      if (fila == 0 && archivosOriginales.length > 0) {
	  if (valorCheck) {
	      seleccionaNada(true);
	  } else {
	      seleccionaTodo();
	  }
      } else if (automaticPreview && !modoLog) {
	  seleccionadosNuevo();
      }
  }

  private void eligeSeleccion() {
      if (modoDrop) {
	  okSeleccion = new int[archivosOriginales.length];
	  for (int x=0;x<archivosOriginales.length;x++) {
	      okSeleccion[x] = x;
	  }
      } else {
	  if (listArchivos != null) {
	      okSeleccion=listArchivos.getSelectedRows();
	  } else {
	      okSeleccion = new int[0];
	  }
	  if ( okSeleccion.length == 0 || (okSeleccion.length == 1 && Archivos[okSeleccion[0]].toString().equals("..")) ) {
	      if (recursivoCarpeta && ckRecursivo.isSelected()) {
		  okSeleccion = new int[Archivos.length];
		  for (int x=0;x<Archivos.length;x++) {
		      okSeleccion[x] = x;
		  }
	      } else {
		  if (oArchivos.getUltimaCarpeta()+1<=Archivos.length-1) {
		      okSeleccion = new int[ (Archivos.length) - (oArchivos.getUltimaCarpeta()+1) ];
		      for (int x=oArchivos.getUltimaCarpeta()+1;x<Archivos.length;x++) {
			  okSeleccion[x - (oArchivos.getUltimaCarpeta()+1)] = x;
		      }
		  }
	      }
	  }
      }
  }
  public void limpia() {
      if (ckCopiaCarpeta.isSelected()) {
	  limpia(true);
      } else {
	  limpia(false);
	  listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0));
      }
  }
  public void limpia(Boolean recarga) {
      if ( doNavega == null || doNavega.isDone() ) {
	  okSeleccion = new int[0];
	  okSeleccionRe = new int[0];
	  indicesCambiados = new ArrayList<>();
	  indicesMarcar = new ArrayList<>();
	  atributos();
	  if (ckCopiaCarpeta.isSelected() || reseteaRenombrados) {
	      tomaRenombrados();
	  } else if (RenombradosCopia != null && RenombradosCopia.length > 0 ) {
	      Renombrados = Arrays.copyOf(RenombradosCopia,RenombradosCopia.length);
	  } else 
	      tomaRenombrados();
	  if (recarga) {
	      modeloRenombrados();
	      renombrados();
	  } else {
	      limpiaRenombrados();
	  }
	  muestraInfo(false, listArchivos.getSelectedRows().length > 0);
      }
  }
  private void limpiaRenombrados() {
      try {
	doSeleccionadosNuevo.get();
      } catch (InterruptedException | ExecutionException | NullPointerException e) {
      }
      modeloRenombrados();
      panelRenombrados();
      archivosRenombrados = oArchivos.getAbstractFiltrado();
  }
  private String[] getTagSiguiente(JTextField txtTexto) {
      int indiceTag = 0;
      String[] stringTag = new String[okSeleccion.length];
      if (txtTexto.getName().equals(Idioma.getTagTrack())) {
	  indiceTag= 0;
      } else if (txtTexto.getName().equals(Idioma.getTagTitle())) {
	  indiceTag = 1;
      } else if (txtTexto.getName().equals(Idioma.getTagArtist())) {
	  indiceTag = 2;
      } else if (txtTexto.getName().equals(Idioma.getTagAlbum())) {
	  indiceTag = 3;
      } else if (txtTexto.getName().equals(Idioma.getTagYear())) {
	  indiceTag = 4;
      } else if (txtTexto.getName().equals(Idioma.getTagGenre())) {
	  indiceTag = 5;
      }
      if (txtTexto.isEnabled()) {
	  for (int x=0; x<okSeleccion.length; x++)
	      stringTag[x] = txtTexto.getText();
      } else {
	  for (int x=0; x<okSeleccion.length; x++) {
	      if (arrayTablaMp3 != null) {
		  if (arrayTablaMp3[indiceTag][x] != null) {
		      stringTag[x] = arrayTablaMp3[indiceTag][x];
		  } else {
		      stringTag[x] = "";
		  }
	      } else {
		  stringTag[x] = "";
	      }
	  }
      }
      return stringTag;
  }
  private String getTagSiguientePopulate(JTextField txtTexto, int intTexto) {
      int indiceTag = 0;
      String stringTag;
      if (txtTexto.getName().equals(Idioma.getTagTrack())) {
	  indiceTag= 0;
      } else if (txtTexto.getName().equals(Idioma.getTagTitle())) {
	  indiceTag = 1;
      } else if (txtTexto.getName().equals(Idioma.getTagArtist())) {
	  indiceTag = 2;
      } else if (txtTexto.getName().equals(Idioma.getTagAlbum())) {
	  indiceTag = 3;
      } else if (txtTexto.getName().equals(Idioma.getTagYear())) {
	  indiceTag = 4;
      } else if (txtTexto.getName().equals(Idioma.getTagGenre())) {
	  indiceTag = 5;
      }
      if (txtTexto.isEnabled()) {
	  stringTag = txtTexto.getText();
	  if (indiceTag == 0 && ckPista.isSelected()) {
	      int intTag = Integer.parseInt(stringTag);
	      stringTag = intTag + intTexto + "";
	  }
      } else {
	  if (arrayTablaMp3 != null) {
	      if (arrayTablaMp3[indiceTag][intTexto] != null) {
		  stringTag = arrayTablaMp3[indiceTag][intTexto];
	      } else {
		  stringTag = "";
	      }
	  } else {
	      stringTag = "";
	  }
      }
      return stringTag;
  }
  public void escribeMp3(){
      tomaArchivos();
      okSeleccion = checkAudioSeleccion();
      if (okSeleccion.length > 0) {
	    archivosOriginales = oArchivos.getAbstractFiltrado();
	    muestraBarra(true,Idioma.getBarMp3Write());
	    jProgreso.setStringPainted(false);
	    jProgreso.setIndeterminate(true);
	    setCursor(new Cursor(Cursor.WAIT_CURSOR));
	    EscribeMp3 doEscribeMp3 = new EscribeMp3();
	    doEscribeMp3.execute();
      }
  }
  public void seleccionadosNuevo() {
      if (doSeleccionadosNuevo == null || doSeleccionadosNuevo.isDone()) {
	  if (primero) {
	      if (modoDrop) { //Elimina archivos que ya no se pueden leer
		  compruebaExisten();
	      }
	  }
	  if (opcionSelec == 1 || opcionSelec == 3) {
	      ckOpcionDos.setEnabled(true);
	  }
	  else {
	      ckOpcionDos.setSelected(false);
	      ckOpcionDos.setEnabled(false);
	  }
	  conmutaExtension();
          limpia(ckCopiaCarpeta.isSelected());
	  archivosOriginales = oArchivos.getAbstractFiltrado();
	  if (archivosOriginales == null)
	      archivosOriginales = new File[0];
 	  tomaSeleccion();
	  if (ckCopiaCarpeta.isSelected())
	      reubicaRenombrados();
	  else {
	      mBusca.setArchivosOriginales(archivosOriginales);
	      RenombradosCopia = Arrays.copyOf(Archivos,Renombrados.length);
	      indicesSeleccion = okSeleccion;
	  }
          if (okSeleccion.length > 0) {              
	      muestraBarra(true,Idioma.getBarPreview());
	      jProgreso.setStringPainted(false);
	      jProgreso.setIndeterminate(true);              
	      doSeleccionadosNuevo = new SeleccionadosNuevo();
	      doSeleccionadosNuevo.execute();
          } else {
	      indicesCambiados = new ArrayList<>();
	      indicesMarcar = new ArrayList<>();
	      modeloRenombrados();
	      if ( ! ckCopiaCarpeta.isSelected() )
		  panelRenombrados();
	      else
		  renombrados();
	      btnAplicar.setEnabled(false);
              btnAplicar.setIcon(aplicarBigBWOk);
	      m16.setEnabled(false);
	  }
      }  
  }

  private void reubicaRenombrados() {
      okSeleccion = mBusca.apruebaSeleccion(archivosOriginales, okSeleccion);
      Renombrados = mBusca.reformaRenombrados(rutaRe, archivosOriginales, Archivos, Renombrados, okSeleccion, oRenombrados.getUltimaCarpeta());
      okSeleccionRe = new int[okSeleccion.length];
      for (int x=0;x<okSeleccion.length;x++) {
	  okSeleccionRe[x] = (oRenombrados.getUltimaCarpeta() + 1) + x;
      }
      indicesSeleccion = okSeleccionRe;
  }
  public void actualizaAtributo() {
      if ( jAtributos.getSelectedIndex() < 4 ) {
	  panelAtributos(0);
	  jAtributosEstado.setSelectedIndex(iAtributos[jAtributos.getSelectedIndex()]);
      } else {
	  if (fechaAtributos == null) {
	      Date fechaStringAtributo = new Date();
	      SimpleDateFormat dateFormat = new SimpleDateFormat("dd" + "/" + "MM" + "/" + "yyyy" + " " + "HH" + ":" + "mm" + ":" + "ss");
	      String fechaFormateada = dateFormat.format(fechaStringAtributo);
	      fechaAtributos = new JTextField(fechaFormateada);
	      setFont(fechaAtributos,9,Font.PLAIN);
	      fechaAtributos.setPreferredSize(new Dimension(120,22));
	      fechaAtributos.setMaximumSize(new Dimension(120,22));
	      fechaAtributos.setName("fechaAtributos");
	      fechaAtributos.setEditable(false);
	      fechaAtributos.addMouseListener(cc);
	      fechaAtributos.addKeyListener(cc);
	  }
	  panelAtributos(1);
	  if ( ! jAtributosEstado.isEnabled() )
	      fechaAtributos.setEnabled(false);
      }
  }
  public void fijaAtributo() {
      iAtributos[jAtributos.getSelectedIndex()] = jAtributosEstado.getSelectedIndex();
  }
  public void atributos() {
      if ( opAtributos.isSelected() && (!opNumeros.isSelected() && !opNormaliza.isSelected() && !opReemplaza.isSelected() && !opAleatorio.isSelected() && !opCapitaliza.isSelected()) && pestPanel.getSelectedIndex() == 1 ) {
	  if (indicesCambiados.isEmpty()) {
	      if ( ! btnAplicar.isEnabled() ) {
		  m16.setEnabled(true);
		  btnAplicar.setEnabled(true);
                  btnAplicar.setIcon(aplicarBigOk);
		  new Blink().execute();
	      }
	  }
	  btnPreview.setEnabled(false);
	  comboSelecAplica.setEnabled(false);
	  m15.setEnabled(false);
      } else {
	  btnPreview.setEnabled(true);
	  m15.setEnabled(true);
	  comboSelecAplica.setEnabled(true);
	  if ( opAtributos.isSelected() && (!opNumeros.isSelected() && !opNormaliza.isSelected() && !opReemplaza.isSelected() && !opAleatorio.isSelected() && !opCapitaliza.isSelected()) && pestPanel.getSelectedIndex() != 1 ) {
	      if (indicesCambiados.isEmpty()) {
		  btnAplicar.setEnabled(false);
                  btnAplicar.setIcon(aplicarBigBWOk);
		  m16.setEnabled(false);
	      } else {
		  btnAplicar.setEnabled(true);
                  btnAplicar.setIcon(aplicarBigOk);
		  m16.setEnabled(true);
	      }
	  }
      }
  }
  protected void dialogFechaAtributos() {
      if ( ! fechaAtributos.isEnabled() )
	  return;
      if (dAtribFecha == null) {
	  dAtribFecha = new JDialog(this, "vRenamer -- ", false);
	  final JCalendar calendarioAtrib = new JCalendar(3, true, locale);
	  calendarioAtrib.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.pink),BorderFactory.createEmptyBorder(5,5,5,5)));
	  calendarioAtrib.setBackground(Color.white);
	  calendarioAtrib.setDayFont(new Font("Helvetica", Font.PLAIN, 9));
	  calendarioAtrib.setPreferredSize(new Dimension(215,190));
	  calendarioAtrib.setMinimumSize(new Dimension(215,190));
	  calendarioAtrib.setMaximumSize(new Dimension(215,190));
	  JButton btnActualizaAtrib = getButton("", actualizaOk, false);
	  btnActualizaAtrib.addActionListener(new ActionListener () {
              @Override
              public void actionPerformed(ActionEvent e) {
		  calendarioAtrib.setDate(new Date());
	      }
	  });
	  btnActualizaAtrib.setToolTipText(Idioma.getCalendarReload());
	  btnActualizaAtrib.setPreferredSize(new Dimension(40,23));
	  btnActualizaAtrib.setMaximumSize(new Dimension(40,23));

	  JPanel pnlCalendario = new JPanel();
	  pnlCalendario.setLayout(new BoxLayout(pnlCalendario,BoxLayout.X_AXIS));
	  pnlCalendario.add(btnActualizaAtrib);
	  pnlCalendario.add(Box.createRigidArea(new Dimension(5,0)));
	  pnlCalendario.add(calendarioAtrib);
	  btnActualizaAtrib.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	  calendarioAtrib.setAlignmentY(Component.BOTTOM_ALIGNMENT);

	  CreationAtrib = new JCheckBox(Idioma.getMenPickCreation()); 
	  setFont(CreationAtrib,9,Font.PLAIN);
	  AccessAtrib = new JCheckBox(Idioma.getMenPickAccessed()); 
	  setFont(AccessAtrib,9,Font.PLAIN);
	  lastAtrib = new JCheckBox(Idioma.getMenPickModified()); 
	  setFont(lastAtrib,9,Font.PLAIN);
	  lastAtrib.setSelected(true);

	  JPanel pnlRadio = new JPanel();
	  pnlRadio.setLayout(new BoxLayout(pnlRadio,BoxLayout.Y_AXIS));
	  pnlRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlRadio.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	  if ( getSistema().equals("windows") ) {
	      pnlRadio.add(CreationAtrib);
	      pnlRadio.add(Box.createRigidArea(new Dimension(0,5)));
	  }
	  pnlRadio.add(lastAtrib);
	  if ( getSistema().equals("windows") ) {
	      pnlRadio.add(Box.createRigidArea(new Dimension(0,5)));
	      pnlRadio.add(AccessAtrib);
	  }
	  JButton atribAceptar = new JButton(Idioma.getCopiaOk());
	  atribAceptar.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
		  Date datoCalendarioAtrib = calendarioAtrib.getDate();
		  SimpleDateFormat dateFormatAtrib = new SimpleDateFormat("dd" + "/" + "MM" + "/" + "yyyy" + " " + "HH" + ":" + "mm" + ":" + "ss");
		  String fechaFormateadaAtrib = dateFormatAtrib.format(datoCalendarioAtrib);
		  fechaAtributos.setText(fechaFormateadaAtrib);
		  cambiaFoco();
		  dAtribFecha.setVisible(false);
		  if ( ! CreationAtrib.isSelected() && ! AccessAtrib.isSelected() && ! lastAtrib.isSelected() )
		      fechaAtributos.setForeground(Color.GRAY);
		  else
		      fechaAtributos.setForeground(Color.BLACK);
	      }
	  });
	  JPanel pnlBtnAtrib = new JPanel(new FlowLayout(FlowLayout.CENTER));
	  pnlBtnAtrib.add(atribAceptar);

	  JPanel pnlAtribFecha = new JPanel(new BorderLayout());
	  pnlAtribFecha.add(pnlCalendario, "Center");
	  pnlAtribFecha.add(pnlRadio, "West");
	  pnlAtribFecha.add(pnlBtnAtrib, "South");
	  pnlAtribFecha.setBorder(BorderFactory.createLoweredSoftBevelBorder());

          dAtribFecha.setUndecorated(true);
	  dAtribFecha.setName("atributos fecha");
	  dAtribFecha.add(pnlAtribFecha);
	  dAtribFecha.setSize(380,220);
	  dAtribFecha.setResizable(false);
      }
      dAtribFecha.setLocation(fechaAtributos.getLocationOnScreen());
      dAtribFecha.setVisible(true);
  }
  private void panelAtributos(int opcionAtrib) {
      pnlAtributos.removeAll();
      pnlAtributos.add(opAtributos);
      pnlAtributos.add(Box.createRigidArea(new Dimension(5,0)));
      pnlAtributos.add(jAtributos);
      pnlAtributos.add(Box.createRigidArea(new Dimension(8,0)));
      if (opcionAtrib == 0) {
	  pnlAtributos.add(jAtributosEstado);
	  pnlAtributos.add(Box.createRigidArea(new Dimension(5,0)));
	  pnlAtributos.add(cAtributos);
	  jAtributosEstado.setPreferredSize(new Dimension(120,22));
	  jAtributosEstado.setMaximumSize(new Dimension(120,22));
      } else
	  pnlAtributos.add(fechaAtributos);
	  if (fechaAtributos != null) {
	      fechaAtributos.setPreferredSize(new Dimension(140,22));
	      fechaAtributos.setMaximumSize(new Dimension(140,22));
	  }
      pnlAtributos.updateUI();
  }
  public void aplicaAtributosWindows() {
      tomaSeleccion();
      archivosOriginales = oArchivos.getAbstractFiltrado();
      okSeleccionDoble = new Boolean[okSeleccion.length][4];
      File[] archivosOriginalesCopia = oArchivos.getAbstractFiltrado();
      FileTime tiempoAnterior[][] = new FileTime[okSeleccion.length][3];
      ArrayList<FileTime> tiempoActual = new ArrayList<>();
      java.util.List<Integer> okSeleccionList = new ArrayList<>();
      String fechaAtributoSelec = "";
      if (lastAtrib == null || lastAtrib.isSelected())
	  fechaAtributoSelec = "last";
      if (CreationAtrib != null && CreationAtrib.isSelected())
	  fechaAtributoSelec += "creation";
      if (AccessAtrib != null && AccessAtrib.isSelected())
	  fechaAtributoSelec += "access";
      for (int x=0;x<okSeleccion.length;x++) {
	  if (cAtributos.getSelectedIndex() == 0) {
	      switch(jAtributos.getSelectedIndex()) {
		  case 0:
		      if (jAtributosEstado.getSelectedIndex() == 0) {
			  if ( archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionList.add(okSeleccion[x]);
			  if ( ! archivosOriginales[okSeleccion[x]].setWritable(false, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      } else {
			  if ( ! archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionList.add(okSeleccion[x]);
			  if ( ! archivosOriginales[okSeleccion[x]].setWritable(true, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      }
		  break;
		  case 1:
		      okSeleccionList.add(okSeleccion[x]);
		      if (jAtributosEstado.getSelectedIndex() == 0) {
			  try {
			      Process p = Runtime.getRuntime().exec("attrib +H " + "\"" + archivosOriginales[okSeleccion[x]] + "\"");
			      try {
				  p.waitFor();
			      } catch (InterruptedException i) {
			      }
			  } catch (IOException e) {
			      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  }
		      } else {
			  try {
			      Process p = Runtime.getRuntime().exec("attrib -H " + "\"" + archivosOriginales[okSeleccion[x]] + "\"");
			      try {
				  p.waitFor();
			      } catch (InterruptedException i) {
			      }
			  } catch (IOException e) {
			      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  }
		      }
		  break;
		  case 2:
		      Path path = archivosOriginales[okSeleccion[x]].toPath();
		      DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class); 
		      if (jAtributosEstado.getSelectedIndex() == 0) {
			  if ( archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionList.add(okSeleccion[x]);
			  try {
			      DosFileAttributes dos = dosView.readAttributes();
			      if ( ! dos.isSystem() )
				  dosView.setSystem(true);
			  } catch (IOException io) {
			      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  }
		      } else {
			  if ( ! archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionList.add(okSeleccion[x]);
			  try {
			      DosFileAttributes dos = dosView.readAttributes();
			      if ( dos.isSystem() )
				  dosView.setSystem(false);
			  } catch (IOException io) {
			      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  }
		      }
		  break;
		  case 3:
		      path = archivosOriginales[okSeleccion[x]].toPath();
		      dosView = Files.getFileAttributeView(path, DosFileAttributeView.class); 
		      if (jAtributosEstado.getSelectedIndex() == 0) {
			  if ( archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionList.add(okSeleccion[x]);
			  try {
			      DosFileAttributes dos = dosView.readAttributes();
			      if ( ! dos.isArchive() )
				  dosView.setArchive(true);
			  } catch (IOException io) {
			      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  }
		      } else {
			  if ( ! archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionList.add(okSeleccion[x]);
			  try {
			      DosFileAttributes dos = dosView.readAttributes();
			      if ( dos.isArchive() )
				  dosView.setArchive(false);
			  } catch (IOException io) {
			      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  }
		      }
		  break;
		  case 4:
		      okSeleccionList.add(okSeleccion[x]);
		      String sTiempoElegido = fechaAtributos.getText();
		      SimpleDateFormat dateFormat = new SimpleDateFormat("dd" + "/" + "MM" + "/" + "yyyy" + " " + "HH" + ":" + "mm" + ":" + "ss");
		      try {
			  Date fechaDate = dateFormat.parse(sTiempoElegido);
			  long fechaLong = fechaDate.getTime();
			  FileTime fechaTime = FileTime.fromMillis(fechaLong);
			  tiempoActual.add(fechaTime);
			  BasicFileAttributes attributes = Files.readAttributes(archivosOriginales[okSeleccion[x]].toPath(), BasicFileAttributes.class);
			  if (lastAtrib == null || lastAtrib.isSelected()) {
			      long ultimoModif = archivosOriginales[okSeleccion[x]].lastModified();
			      tiempoAnterior[x][0] = FileTime.fromMillis(ultimoModif);
			      Files.setLastModifiedTime(archivosOriginales[okSeleccion[x]].toPath(), fechaTime);
			  }
			  if (CreationAtrib != null && CreationAtrib.isSelected()) {
			      long creationTime = attributes.creationTime().toMillis();
			      tiempoAnterior[x][1] = FileTime.fromMillis(creationTime);
			      Files.setAttribute(archivosOriginales[okSeleccion[x]].toPath(), "basic:creationTime", fechaTime); 
			  } 
			  if (AccessAtrib != null && AccessAtrib.isSelected()) {
			      long accessTime = attributes.lastAccessTime().toMillis();
			      tiempoAnterior[x][2] = FileTime.fromMillis(accessTime);
			      Files.setAttribute(archivosOriginales[okSeleccion[x]].toPath(), "basic:lastAccessTime", fechaTime); 
			  }
		      } catch (IOException | ParseException e) {
		      }
		  break;
	      }
	  } else {
	      okSeleccionList.add(okSeleccion[x]);
	      if (iAtributos[0] == 0) {
                  okSeleccionDoble[x][0] = archivosOriginales[okSeleccion[x]].canRead();
		  if ( ! archivosOriginales[okSeleccion[x]].setWritable(false, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
	      } else {
                  okSeleccionDoble[x][0] = ! archivosOriginales[okSeleccion[x]].canRead();
		  if ( ! archivosOriginales[okSeleccion[x]].setWritable(true, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
	      }
	      okSeleccionDoble[x][1] = true;
	      if (iAtributos[1] == 0) {
		  try {
		      Process p = Runtime.getRuntime().exec(new String[]{"attrib +H " + "\"" + archivosOriginales[okSeleccion[x]] + "\""});
		      try {
			  p.waitFor();
		      } catch (InterruptedException i) {
		      }
		  } catch (IOException e) {
		      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		  }
	      } else {
		  try {
		      Process p = Runtime.getRuntime().exec(new String[]{"attrib -H " + "\"" + archivosOriginales[okSeleccion[x]] + "\""});
		      try {
			  p.waitFor();
		      } catch (InterruptedException i) {
		      }
		  } catch (IOException e) {
		      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		  }
	      }
	      Path path = archivosOriginales[okSeleccion[x]].toPath();
	      DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class); 
	      if (iAtributos[2] == 0) {
                  okSeleccionDoble[x][2] = archivosOriginales[okSeleccion[x]].canRead();
		  try {
		      DosFileAttributes dos = dosView.readAttributes();
		      if ( ! dos.isSystem() )
			  dosView.setSystem(true);
		  } catch (IOException io) {
		      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		  }
	      } else {
                  okSeleccionDoble[x][2] = ! archivosOriginales[okSeleccion[x]].canRead();
		  try {
		      DosFileAttributes dos = dosView.readAttributes();
		      if ( dos.isSystem() )
			  dosView.setSystem(false);
		  } catch (IOException io) {
		      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		  }
	      }
	      if (iAtributos[3] == 0) {
                  okSeleccionDoble[x][3] = archivosOriginales[okSeleccion[x]].canRead();
		  try {
		      DosFileAttributes dos = dosView.readAttributes();
		      if ( ! dos.isArchive() )
			  dosView.setArchive(true);
		  } catch (IOException io) {
		      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		  }
	      } else {
                  okSeleccionDoble[x][3] = ! archivosOriginales[okSeleccion[x]].canRead();
		  try {
		      DosFileAttributes dos = dosView.readAttributes();
		      if ( dos.isArchive() )
			  dosView.setArchive(false);
		  } catch (IOException io) {
		      sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		  }
	      }
	  }
      }
      int [] okSeleccionAtributos = new int [okSeleccionList.size()];
      for (int x=0;x<okSeleccionAtributos.length;x++) 
	  okSeleccionAtributos[x] = okSeleccionList.get(x);
      edit = new AttributesEdit(okSeleccionDoble, okSeleccionAtributos, archivosOriginalesCopia, jAtributos.getSelectedIndex(), jAtributosEstado.getSelectedIndex(), cAtributos.getSelectedIndex(), iAtributos, tiempoAnterior, tiempoActual, fechaAtributoSelec, separador, Idioma);
      undoSupport_.postEdit( edit );
      if (jAtributos.getSelectedIndex() == 1)
	  actualizaDespuesAplicar(ruta);
      else {
	  if (jAtributosEstado.getSelectedIndex() == 0) {
	      if ( ! ckCopiaCarpeta.isSelected() ) 
		  listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0));
	  } else {
	      if ( ! ckCopiaCarpeta.isSelected() ) 
		  listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0));
	  }
      }
      JOptionPane.showMessageDialog(pnlPrincipal, okSeleccionList.size() + " " + Idioma.getInfoFile() + " " + Idioma.getMainChanged(), Idioma.getMainDone(), JOptionPane.INFORMATION_MESSAGE, infoOk);
  }
  public void aplicaAtributos() {
      if (getSistema().equals("windows")) 
	  aplicaAtributosWindows();
      else {
	  tomaSeleccion();
	  archivosOriginales = oArchivos.getAbstractFiltrado();
	  okSeleccionDoble = new Boolean[okSeleccion.length][4];
	  File[] archivosOriginalesCopia = oArchivos.getAbstractFiltrado();
	  java.util.List<Integer> okSeleccionList = new ArrayList<>();
	  FileTime tiempoAnterior[][] = new FileTime[okSeleccion.length][3];
	  ArrayList<FileTime> tiempoActual = new ArrayList<>();
	  String fechaAtributoSelec = "";
	  if (lastAtrib == null || lastAtrib.isSelected())
	      fechaAtributoSelec = "last";
	  if (CreationAtrib != null && CreationAtrib.isSelected())
	      fechaAtributoSelec += "creation";
	  if (AccessAtrib != null && AccessAtrib.isSelected())
	      fechaAtributoSelec += "access";
	  for (int x=0;x<okSeleccion.length;x++) {
	      if (cAtributos.getSelectedIndex() == 0) {
		  switch(jAtributos.getSelectedIndex()) {
		      case 0:
			  if (jAtributosEstado.getSelectedIndex() == 0) {
			      if ( ! archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionList.add(okSeleccion[x]);
			      if ( ! archivosOriginales[okSeleccion[x]].setReadable(true, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  } else {
			      if ( archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionList.add(okSeleccion[x]);
			      if ( ! archivosOriginales[okSeleccion[x]].setReadable(false, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  }
		      break;
		      case 1:
			  if (jAtributosEstado.getSelectedIndex() == 0) {
			      if ( ! archivosOriginales[okSeleccion[x]].canWrite() ) okSeleccionList.add(okSeleccion[x]);
			      if ( ! archivosOriginales[okSeleccion[x]].setWritable(true, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  } else {
			      if ( archivosOriginales[okSeleccion[x]].canWrite() ) okSeleccionList.add(okSeleccion[x]);
			      if ( ! archivosOriginales[okSeleccion[x]].setWritable(false, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  }
		      break;
		      case 2:
			  if (jAtributosEstado.getSelectedIndex() == 0) {
			      if ( ! archivosOriginales[okSeleccion[x]].canExecute() ) okSeleccionList.add(okSeleccion[x]);
			      if ( ! archivosOriginales[okSeleccion[x]].setExecutable(true, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  } else {
			      if ( archivosOriginales[okSeleccion[x]].canExecute() ) okSeleccionList.add(okSeleccion[x]);
			      if ( ! archivosOriginales[okSeleccion[x]].setExecutable(false, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			  }
		      break;
		      case 3:
			  okSeleccionList.add(okSeleccion[x]);
			  if (jAtributosEstado.getSelectedIndex() == 0) {
			      if ( ! archivosOriginales[okSeleccion[x]].renameTo( ( archivosOriginales[okSeleccion[x]].getName().substring(0,1).equals(".") ) ? archivosOriginales[okSeleccion[x]] : new File (archivosOriginales[okSeleccion[x]].getParent() + separador + "." + archivosOriginales[okSeleccion[x]].getName() ) ) ) {
				  sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			      }
			  } else {
			      if ( ! archivosOriginales[okSeleccion[x]].renameTo( (archivosOriginales[okSeleccion[x]].getName().substring(0,1).equals(".") ) ? new File (archivosOriginales[okSeleccion[x]].getParent() + separador + archivosOriginales[okSeleccion[x]].getName().substring(1,archivosOriginales[okSeleccion[x]].getName().length() )) : archivosOriginales[okSeleccion[x]] ) ) {
				  sinPermiso(archivosOriginales[okSeleccion[x]].toString());
			      }
			  }
		      break;
		      case 4:
			  okSeleccionList.add(okSeleccion[x]);
			  String sTiempoElegido = fechaAtributos.getText();
			  SimpleDateFormat dateFormat = new SimpleDateFormat("dd" + "/" + "MM" + "/" + "yyyy" + " " + "HH" + ":" + "mm" + ":" + "ss");
			  try {
			      Date fechaDate = dateFormat.parse(sTiempoElegido);
			      long fechaLong = fechaDate.getTime();
			      FileTime fechaTime = FileTime.fromMillis(fechaLong);
			      tiempoActual.add(fechaTime);
			      BasicFileAttributes attributes = Files.readAttributes(archivosOriginales[okSeleccion[x]].toPath(), BasicFileAttributes.class);
			      if (lastAtrib == null || lastAtrib.isSelected()) {
				  long ultimoModif = archivosOriginales[okSeleccion[x]].lastModified();
				  tiempoAnterior[x][0] = FileTime.fromMillis(ultimoModif);
				  Files.setLastModifiedTime(archivosOriginales[okSeleccion[x]].toPath(), fechaTime);
			      }
			      if (CreationAtrib != null && CreationAtrib.isSelected()) {
				  long creationTime = attributes.creationTime().toMillis();
				  tiempoAnterior[x][1] = FileTime.fromMillis(creationTime);
				  Files.setAttribute(archivosOriginales[okSeleccion[x]].toPath(), "basic:creationTime", fechaTime); 
			      } 
			      if (AccessAtrib != null && AccessAtrib.isSelected()) {
				  long accessTime = attributes.lastAccessTime().toMillis();
				  tiempoAnterior[x][2] = FileTime.fromMillis(accessTime);
				  Files.setAttribute(archivosOriginales[okSeleccion[x]].toPath(), "basic:lastAccessTime", fechaTime); 
			      }
			  } catch (ParseException | IOException e) {
			  }
		      break;
		  }
	      } else {
		      okSeleccionList.add(okSeleccion[x]);
		      if (iAtributos[0] == 0) {
			  if ( ! archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionDoble[x][0] = true;
			  else okSeleccionDoble[x][0] = false;
			  if ( ! archivosOriginales[okSeleccion[x]].setReadable(true, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      } else {
			  if ( archivosOriginales[okSeleccion[x]].canRead() ) okSeleccionDoble[x][0] = true;
			  else okSeleccionDoble[x][0] = false;
			  if ( ! archivosOriginales[okSeleccion[x]].setReadable(false, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      }
		      if (iAtributos[1] == 0) {
			  if ( ! archivosOriginales[okSeleccion[x]].canWrite() ) okSeleccionDoble[x][1] = true;
			  else okSeleccionDoble[x][1] = false;
			  if ( ! archivosOriginales[okSeleccion[x]].setWritable(true, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      } else {
			  if ( archivosOriginales[okSeleccion[x]].canWrite() ) okSeleccionDoble[x][1] = true;
			  else okSeleccionDoble[x][1] = false;
			  if ( ! archivosOriginales[okSeleccion[x]].setWritable(false, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      }
		      if (iAtributos[2] == 0) {
			  if ( ! archivosOriginales[okSeleccion[x]].canExecute() ) okSeleccionDoble[x][2] = true;
			  else okSeleccionDoble[x][2] = false;
			  if ( ! archivosOriginales[okSeleccion[x]].setExecutable(true, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      } else {
			  if ( archivosOriginales[okSeleccion[x]].canExecute() ) okSeleccionDoble[x][2] = true;
			  else okSeleccionDoble[x][2] = false;
			  if ( ! archivosOriginales[okSeleccion[x]].setExecutable(false, false) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      }
		      if (iAtributos[3] == 0) {
			  if ( archivosOriginales[okSeleccion[x]].isHidden() ) okSeleccionDoble[x][3] = false;
			  else okSeleccionDoble[x][3] = true;
			  if ( ! archivosOriginales[okSeleccion[x]].renameTo( ( archivosOriginales[okSeleccion[x]].getName().substring(0,1).equals(".") ) ? archivosOriginales[okSeleccion[x]] : new File (archivosOriginales[okSeleccion[x]].getParent() + separador + "." + archivosOriginales[okSeleccion[x]].getName() ) ) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      } else {
			  if ( ! archivosOriginales[okSeleccion[x]].isHidden() ) okSeleccionDoble[x][3] = false;
			  else okSeleccionDoble[x][3] = true;
			  if ( ! archivosOriginales[okSeleccion[x]].renameTo( (archivosOriginales[okSeleccion[x]].getName().substring(0,1).equals(".") ) ? new File (archivosOriginales[okSeleccion[x]].getParent() + separador + archivosOriginales[okSeleccion[x]].getName().substring(1,archivosOriginales[okSeleccion[x]].getName().length() )) : archivosOriginales[okSeleccion[x]] ) ) sinPermiso(archivosOriginales[okSeleccion[x]].toString());
		      }
	      }
	  }
	  int [] okSeleccionAtributos = new int [okSeleccionList.size()];
	  for (int x=0;x<okSeleccionAtributos.length;x++) okSeleccionAtributos[x] = okSeleccionList.get(x);
	  edit = new AttributesEdit(okSeleccionDoble, okSeleccionAtributos, archivosOriginalesCopia, jAtributos.getSelectedIndex(), jAtributosEstado.getSelectedIndex(), cAtributos.getSelectedIndex(), iAtributos, tiempoAnterior, tiempoActual, fechaAtributoSelec, separador, Idioma);
	  undoSupport_.postEdit( edit );
	  if (jAtributos.getSelectedIndex() == 3 || cAtributos.getSelectedIndex() == 1) navega(ruta);
	  else {
	      if (jAtributosEstado.getSelectedIndex() == 0) {
		  if ( ! ckCopiaCarpeta.isSelected() ) listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0));
	      } else {
		  if ( ! ckCopiaCarpeta.isSelected() ) listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0));
	      }
	  }
	  JOptionPane.showMessageDialog(pnlPrincipal, okSeleccionList.size() + " " + Idioma.getInfoFile() + " " + Idioma.getFilechanged(), Idioma.getMainDone(), JOptionPane.INFORMATION_MESSAGE, infoOk);
      }
  }
  public void aplicado(){
      if ( ! (ckCopiaCarpeta.isSelected() && copiarRenombrados) ) {
	  tomaSeleccion();
      }
      if ( opAtributos.isSelected() && indicesCambiados.isEmpty() && pestPanel.getSelectedIndex() == 1 ) 
	  aplicaAtributos();
      else {
	  recogeAplicar();
	  reseteaRenombrados = true;
      }
  }

  public void recogeAplicar(){
      if (ckCopiaCarpeta.isSelected()) {
	  indSeleccionados = okSeleccion;
      } else {
	  indSeleccionados = mBusca.getIndicesCambiadosArray();
      }

      indSeleccionadosRe = okSeleccionRe;
      cantidadRenombrados = indSeleccionados.length;
      FicherosComp = Renombrados;
      copia = ckCopiaCarpeta.isSelected();
      iSeleccionadosOk = new ArrayList<>();
      btnAplicar.setEnabled(false);
      btnAplicar.setIcon(aplicarBigBWOk);
      btnPreview.setEnabled(false);
      btnLimpiar.setEnabled(false);
      btnActualizar.setEnabled(false);
      comboSelecAplica.setEnabled(false);
      m15.setEnabled(false);
      m16.setEnabled(false);
      archivosOriginales = oArchivos.getAbstractFiltrado();
      archivosRenombrados = oArchivos.getRenombradosFinal();
      archivosOriginalesAplicar = oArchivos.getAbstractFiltrado();
      archivosRenombradosAplicar = oArchivos.getRenombradosFinal();
      jProgreso.setStringPainted(true);
      jProgreso.setValue(0);
      jProgreso.setMinimum(0);
      jProgreso.setMaximum(okSeleccion.length);
      muestraBarra(true,Idioma.getBarApply());
      Aplicado doAplicar = new Aplicado();
      doAplicar.execute();
  }

  public int[] getSelectUndo(){
      return indSeleccionadosOk;
  }
  public String filtrando(){    
      filtrado = jFiltro.getText();
      return ruta;
  }
  public void ckFiltra(){
      if (!jFiltro.getText().equals("")) 
          navegaFiltra(ruta);
  }
  public void navegaFiltra(final String ruta) {
      this.ruta = ruta;
      if ( ! noPasarFiltro ) {
	  cierraDrop();
	  limpia(true);
	  Filtrando doFiltra = new Filtrando();
	  doFiltra.execute();     
      }
  }
  private void seleccionaNada(Boolean selecciona) {
      for (int x=0;x<archivosOriginales.length;x++) {
	  if (seleccionCheck.contains(x)) {
	      seleccionCheck.remove(Integer.valueOf(x));
	      archivosCheck.remove(archivosOriginales[x]);
	      listArchivos.getModel().setValueAt( false, x, 0);
	  }
      }
      if (automaticPreview && selecciona && ! modoLog) {
	  seleccionadosNuevo();
      }
  }
  public void seleccionaTodo(){
      for (int x=0;x<archivosOriginales.length;x++) {
	  if ( ! seleccionCheck.contains(x) ) {
	      seleccionCheck.add(x);
	      archivosCheck.add(archivosOriginales[x]);
	      listArchivos.getModel().setValueAt(true, x, 0);
	  }
      }
      if (automaticPreview && ! modoLog) {
	  seleccionadosNuevo();
      }
  }
  public void invertirSeleccion() {
      if (seleccionCheck.isEmpty()) {
	  seleccionaTodo();
      } else if (seleccionCheck.size() == archivosOriginales.length) {
      seleccionaNada(true);
      } else {
	  for (int x=1;x<archivosOriginales.length;x++) {
	      if ( ! seleccionCheck.contains(x) ) {
		  seleccionCheck.add(x);
		  archivosCheck.add(archivosOriginales[x]);
		  listArchivos.getModel().setValueAt( true, x, 0);
	      } else {
		  seleccionCheck.remove(Integer.valueOf(x));
		  archivosCheck.remove(archivosOriginales[x]);
		  listArchivos.getModel().setValueAt( false, x, 0);
  }
	  }
	  if (automaticPreview && ! modoLog) {
	      seleccionadosNuevo();
	  }
      }
  }
  public void seleccionaCarpetas(){
      seleccionaNada(true);
      int comienza;
      if (oArchivos.getUltimaCarpeta() == archivosOriginales.length -1) {
	  comienza = 0;
      } else {
	  comienza = 1;
      }
      if (oArchivos.getUltimaCarpeta() > 0) {
	  for (int x=comienza;x<=oArchivos.getUltimaCarpeta();x++) {
	      if ( ! seleccionCheck.contains(x) ) {
		  seleccionCheck.add(x);
		  archivosCheck.add(archivosOriginales[x]);
		  listArchivos.getModel().setValueAt( true, x, 0);
	      }
	  }
	  if (automaticPreview && ! modoLog) {
	      seleccionadosNuevo();
	  }
      }
  }
  public void seleccionaArchivos(){
      seleccionaNada(true);
      int comienza;
      if (oArchivos.getUltimaCarpeta() == 0) {
	  comienza = 0;
      } else {
	  comienza = 1;
      }
      if (oArchivos.getUltimaCarpeta()+1 <= Archivos.length-1) {
	  for (int x=oArchivos.getUltimaCarpeta()+comienza;x<archivosOriginales.length;x++) {
	      if ( ! seleccionCheck.contains(x) ) {
		  seleccionCheck.add(x);
		  archivosCheck.add(archivosOriginales[x]);
		  listArchivos.getModel().setValueAt( true, x, 0);
	      }
	  }
	  if (automaticPreview && ! modoLog) {
	      seleccionadosNuevo();
	  }
      }
  }
  public void activaCheck(String compActiva) {
      if (compActiva.equals("reemplaza") || compActiva.equals(Idioma.getOpReemplaza())) {
	  pnlReemplaza.setEnabled(opReemplaza.isSelected());
      } else if (compActiva.equals("normaliza") || compActiva.equals(Idioma.getOpNormaliza())) {
	  pnlNormaliza.setEnabled(opNormaliza.isSelected());
      } else if (compActiva.equals("numeros") || compActiva.equals(Idioma.getOpNumeros())) {
	  pnlNumeros.setEnabled(opNumeros.isSelected());
      } else if (compActiva.equals("atributos") || compActiva.equals(Idioma.getOpAtributos())) {
	  pnlAtributos.setEnabled(opAtributos.isSelected());
      } else if (compActiva.equals("capitaliza") || compActiva.equals(Idioma.getOpCapitaliza())) {
	  pnlCapitaliza.setEnabled(opCapitaliza.isSelected());
      } else if (compActiva.equals("aleatorio") || compActiva.equals(Idioma.getOpAleatorio())) {
	  pnlAleatorio.setEnabled(opAleatorio.isSelected());
      }
  }
  public void activa(String compActiva) {
      switch (activaAnterior) {
          case "Combinadas":
              for(Component cBarra : pnlBuscaTotal.getComponents()) { 
                  BarraRenombra barra = (BarraRenombra) cBarra;
                  barra.setEnabled(false, true);
              }
              break;
          case "Elimina":
              pnlEliminar.setEnabled(false);
              break;
          case "Inserta":
              pnlInsertar.setEnabled(false);
              break;
          default:
              activaAnterior = "";
              break;
      }
      if (compActiva.equals("elimina") || compActiva.equals(Idioma.getOpElimina())) {
	  opElimina.setSelected(true);
	  pnlEliminar.setEnabled(true);      
	  activaAnterior = "Elimina";
      } else if (compActiva.equals("inserta") || compActiva.equals(Idioma.getOpInserta())) {
	  opInserta.setSelected(true);
	  pnlInsertar.setEnabled(true);
	  activaAnterior = "Inserta";
      } else if (compActiva.equals("combinadas") || compActiva.equals(Idioma.getOpCombina())) {
	  opSustituciones.setSelected(true);
	  for(Component cBarra : pnlBuscaTotal.getComponents()) {
              BarraRenombra barra = (BarraRenombra) cBarra;
              barra.getCkEnabled().setSelected(barra.getCkEnabled().isSelected());              
              barra.setEnabled(barra.getCkEnabled().isSelected(), true);
              barra.getCkEnabled().setEnabled(true);
              barra.getBotonMas().setEnabled(true);
              barra.getBotonMenos().setEnabled(true);              
          }
	  activaAnterior = "Combinadas";
      }
  }
  private int dialogoExiste() { 
    System.out.println("Existe");
    String[] opciones = {Idioma.getCopiaOk(), Idioma.getOptionCancel()};
    int respuesta = JOptionPane.showOptionDialog(null, Idioma.getWarningWarning(), " -- vRenamer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[1]);
    return respuesta;
  }  
  private int yaExiste(String original, String repetido) {
    opSeleccionada = 2;
    final JDialog dialogExiste = new JDialog(this, Idioma.getWarningExists() + " -- vRenamer", true);

    JLabel targetInfo = new JLabel(Idioma.getWarningWarning());
    JLabel choose = new JLabel(Idioma.getWarningAction());
    JLabel source = new JLabel(Idioma.getWarningSource());
    JLabel sourceFile = new JLabel(original);
    
    Icon icono = new JFileChooser().getIcon(new File(original));		      
    JLabel sourceIcon = new JLabel(icono);
    JLabel sourceLenght = new JLabel(new File(original).length() + " bytes");
        
    JPanel infoSource = new JPanel();
    infoSource.setLayout(new BoxLayout(infoSource,BoxLayout.X_AXIS));
    infoSource.setAlignmentX(Component.LEFT_ALIGNMENT);
    infoSource.add(new JLabel("    "));
    infoSource.add(Box.createRigidArea(new Dimension(5,0)));
    infoSource.add(sourceIcon);
    infoSource.add(Box.createRigidArea(new Dimension(5,0)));
    infoSource.add(sourceLenght);

    JLabel target = new JLabel(Idioma.getWarningTarget());
    JLabel targetFile = new JLabel(repetido);
    
    icono = new JFileChooser().getIcon(new File(repetido));		      
    JLabel targetIcon = new JLabel(icono);
    JLabel targetLenght = new JLabel(new File(original).length() + " bytes");

    JPanel infoTarget = new JPanel();
    infoTarget.setLayout(new BoxLayout(infoTarget,BoxLayout.X_AXIS));
    infoTarget.setAlignmentX(Component.LEFT_ALIGNMENT);
    infoTarget.add(new JLabel("    "));
    infoTarget.add(Box.createRigidArea(new Dimension(5,0)));
    infoTarget.add(targetIcon);
    infoTarget.add(Box.createRigidArea(new Dimension(5,0)));
    infoTarget.add(targetLenght);

    JPanel existeInfo = new JPanel();
    existeInfo.setLayout(new BoxLayout(existeInfo,BoxLayout.Y_AXIS));
    existeInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
    existeInfo.add(targetInfo);
    existeInfo.add(Box.createRigidArea(new Dimension(0,3)));
    existeInfo.add(choose);
    existeInfo.add(Box.createRigidArea(new Dimension(0,3)));
    existeInfo.add(source);
    existeInfo.add(Box.createRigidArea(new Dimension(0,5)));
    existeInfo.add(sourceFile);
    existeInfo.add(Box.createRigidArea(new Dimension(0,5)));
    existeInfo.add(infoSource);
    existeInfo.add(Box.createRigidArea(new Dimension(0,5)));
    existeInfo.add(target);
    existeInfo.add(Box.createRigidArea(new Dimension(0,5)));
    existeInfo.add(targetFile);
    existeInfo.add(Box.createRigidArea(new Dimension(0,5)));
    existeInfo.add(infoTarget);

    final JRadioButton accionRename = new JRadioButton(Idioma.getWarningOverwrite());
    final JRadioButton accionSkip = new JRadioButton(Idioma.getWarningSkip());
    ButtonGroup opcionesActions = new ButtonGroup();
    opcionesActions.add(accionRename);
    opcionesActions.add(accionSkip);
    accionSkip.setSelected(true);
    
    JPanel panelAcciones = new JPanel();
    panelAcciones.setLayout(new BoxLayout(panelAcciones,BoxLayout.Y_AXIS));
    panelAcciones.setAlignmentX(Component.LEFT_ALIGNMENT);
    panelAcciones.add(accionRename);
    panelAcciones.add(Box.createRigidArea(new Dimension(0,5)));
    panelAcciones.add(accionSkip);
    panelAcciones.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getWarningLabelAction()), BorderFactory.createRaisedSoftBevelBorder()));
    
    final JCheckBox repiteAccion = new JCheckBox(Idioma.getWarningAlways());
    
    JPanel panelAccionesTotal = new JPanel();
    panelAccionesTotal.setLayout(new BoxLayout(panelAccionesTotal,BoxLayout.Y_AXIS));
    panelAccionesTotal.setAlignmentX(Component.LEFT_ALIGNMENT);
    panelAccionesTotal.add(Box.createRigidArea(new Dimension(0,35)));
    panelAccionesTotal.add(panelAcciones);
    panelAccionesTotal.add(Box.createRigidArea(new Dimension(0,5)));
    panelAccionesTotal.add(repiteAccion);

    JButton buttonOk = new JButton(Idioma.getCopiaOk());
    buttonOk.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (accionRename.isSelected()) {
                if (repiteAccion.isSelected()) {
                    opSeleccionada = 1;
                } else {
                    opSeleccionada = 0;
                }
            } else if (accionSkip.isSelected()) {
                if (repiteAccion.isEnabled()) {
                    opSeleccionada = 4;
                } else {
                    opSeleccionada = 2;
                }
            }
            dialogExiste.setVisible(false);
        }
    });	
    JButton buttonCancel = new JButton(Idioma.getOptionCancel());
    buttonCancel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            opSeleccionada = 3;
            dialogExiste.setVisible(false);
        }
    });
    JPanel buttonsExiste = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonsExiste.add(buttonOk);
    buttonsExiste.add(buttonCancel);
    
    JPanel panelExiste = new JPanel(new BorderLayout());
    panelExiste.add(existeInfo,"Center");
    panelExiste.add(panelAccionesTotal,"East");
    panelExiste.add(buttonsExiste,"South");
    panelExiste.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    
    dialogExiste.add(panelExiste);    
    int dialogWide = (sourceFile.getPreferredSize().width > targetFile.getPreferredSize().width) ? sourceFile.getPreferredSize().width : targetFile.getPreferredSize().width;
    dialogWide += 250;
    if (dialogWide > anchuraP)
        dialogWide = anchuraP;
    dialogExiste.setSize(dialogWide,270);
    dialogExiste.setLocationRelativeTo(this);
    dialogExiste.setResizable(false);
    dialogExiste.getRootPane().setDefaultButton(buttonOk);
    dialogExiste.setVisible(true);
    
    return opSeleccionada;
  }
  
  public void dropProhibido(String dropNo) {
      JOptionPane.showMessageDialog(pnlPrincipal,dropNo, "ERROR", JOptionPane.ERROR_MESSAGE);
  }

  public void sinPermiso(String rutaProhibida) {
      int opSeleccionada = 0;
      JOptionPane.showMessageDialog(pnlPrincipal,Idioma.getErrorLabel()+rutaProhibida, "ERROR", JOptionPane.ERROR_MESSAGE);
      limpia(true);
  }
  public void mayusculasWindows (){
      JOptionPane.showMessageDialog(pnlPrincipal,Idioma.getForbiddenWindows(), "ERROR", JOptionPane.ERROR_MESSAGE);
  //    limpia();
  }

  public static JButton getButtonOption(final JOptionPane optionPane, String texto, Icon icono) {
    final JButton button = new JButton(texto, icono) {
      @Override
      protected void processMouseEvent(MouseEvent e) {
	  super.processMouseEvent(e);
	  if (e.getID() == MouseEvent.MOUSE_ENTERED) {
	    this.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.RED), BorderFactory.createEmptyBorder(5,5,5,5)));
	  }
	  if (e.getID() == MouseEvent.MOUSE_EXITED) {
	    this.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.PINK), BorderFactory.createEmptyBorder(5,5,5,5)));
	  }
      }
    };
    button.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.PINK), BorderFactory.createEmptyBorder(5,5,5,5)));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    ActionListener actionListener = (e) -> {
        // Return current text label, instead of argument to method
        optionPane.setValue(button.getText());
    };
    button.addActionListener(actionListener);
    return button;
  }
  public static JButton getButton(String texto, Icon icono, final Boolean enlazar) {
      return getButton(texto, icono, enlazar, 5);
  }

  public static JButton getButton(String texto, Icon icono, final Boolean enlazar, final int margen) {
      final JButton button = new JButton(texto, icono) {
        @Override
	protected void processMouseEvent(MouseEvent e) {
	    super.processMouseEvent(e);
	    if (e.getID() == MouseEvent.MOUSE_ENTERED) {
	      if (this.isEnabled()) this.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.RED), BorderFactory.createEmptyBorder(margen, margen, margen, margen)));
	      ToolTipManager.sharedInstance().setEnabled(true);
	      if (enlazar) setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    }
	    if (e.getID() == MouseEvent.MOUSE_EXITED) {
	      this.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.PINK), BorderFactory.createEmptyBorder(margen, margen, margen, margen)));
	    }
	}
      };
      button.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.PINK), BorderFactory.createEmptyBorder(margen, margen, margen, margen)));
      button.setOpaque(false);
      button.setContentAreaFilled(false);
      return button;
  }
  public static void setFont(JComponent fuenteObjeto, int tamanyo, int fuente) {
      if (anchuraP > 1900) 
          tamanyo += 2;
      fuenteObjeto.setFont(new Font("Helvetica", fuente, tamanyo));    
  }
  public void descarta(){
//      undoManager_.discardAllEdits();
  }
  public void cambiaFoco() {
    listArchivos.requestFocusInWindow();
  }
  public void comboCopia() {
    if (ckCopiaCarpeta.isSelected()) 
        pasaCopia();
  }
  public void pasaCopia() {
      pasaCopia(false);
  }
  private void pasaCopia(Boolean esperaSeleccionados) {
    if ( ! listArchivos.getDragEnabled() ) {
	actualizaDespuesAplicar(ruta);
    } else {
	if (esperaSeleccionados) {
	    try {
		doSeleccionadosNuevo.get();
	    } catch (InterruptedException | ExecutionException | NullPointerException e) {
	    }
	}
	indicesCambiados = new ArrayList<>();
	indicesMarcar = new ArrayList<>();
	tomaRenombrados();
	modeloRenombrados();
	renombrados();    
	scrRenombrados.getVerticalScrollBar().setModel(new DefaultBoundedRangeModel());
	scrRenombrados.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	if (automaticPreview) {
	    seleccionadosNuevo();
	}
    }
  }
  public void dialogoCopia(final String fuente) {  
      if (getSistema().equals("mac")) {
	  dialogoCopiaMac(fuente);
      } else {
	  dlgCopia = new JFileChooser(rutaRenombrados){
	    @Override
	    public void approveSelection() {
		super.approveSelection();
		if (fuente.equals("carpeta")) {
                    if (getSistema().equals("mac")) {
                        rutaRenombrados= dlgCopia.getCurrentDirectory().toString()+separador;                        
                    } else { 
                        rutaRenombrados= dlgCopia.getSelectedFile().toString()+separador;
                    }
		    File cheqRuta = new File (rutaRenombrados);
                    if (cheqRuta.canRead()) {
			ckCopiaCarpeta.setSelected(true);
                        pasaCopia(false);
		    }
		} else if (fuente.equals("path")) {
                    if (getSistema().equals("mac")) {
                        ruta=dlgCopia.getCurrentDirectory().toString()+separador;                        
                    } else { 
                        ruta= dlgCopia.getSelectedFile().toString()+separador;
                    }
		    File cheqRuta = new File (ruta);
		    if (cheqRuta.canRead()) {
			navega(cambiaRutaBotones(ruta));
		    }
		}

	      }
	  };
	  okSeleccion=new int[0];
	  dlgCopia.setFileSelectionMode(1);
	  dlgCopia.setDialogTitle(Idioma.getCopiaTitle()); 
	  dlgCopia.showDialog(this,Idioma.getCopiaOk());
      }
  }
  public void dialogoCopiaMac(String fuente) {      
      System.setProperty("apple.awt.fileDialogForDirectories", "true");
      FileDialog dlgCopia = new FileDialog(this,Idioma.getCopiaTitle());
      dlgCopia.setDirectory(rutaRenombrados);
      dlgCopia.setModal(true);
      dlgCopia.setLocationRelativeTo(this);
      dlgCopia.setVisible(true);
      switch (fuente) {
          case "carpeta":
              if ( dlgCopia.getDirectory() != null && dlgCopia.getFile() != null) {
                  rutaRenombrados = dlgCopia.getDirectory() + dlgCopia.getFile() + separador;
                  File cheqRuta = new File (rutaRenombrados);
                  if (cheqRuta.canRead()) {
                      ckCopiaCarpeta.setSelected(true);
                      pasaCopia(false);
                  }
              }
              break;
          case "path":
              if ( dlgCopia.getDirectory() != null && dlgCopia.getFile() != null) {
                  ruta = dlgCopia.getDirectory() + dlgCopia.getFile() + separador;
                  File cheqRuta = new File (ruta);
                  if (cheqRuta.canRead()) {
                      navega(cambiaRutaBotones(ruta));
                  }
              }
              break;
      }
      System.setProperty("apple.awt.fileDialogForDirectories", "false");
  }
  public void abreRecent(String rutaAbrir) {
      if (new File(rutaAbrir).canRead()) {
	  rutaGuarda = rutaAbrir;
	  if (leerDatos(rutaGuarda)) {
	      if ( openRecent.contains(rutaGuarda) ) {
		  openRecent.remove(rutaGuarda);
		  openRecent.add(0, rutaGuarda);
	      }
	      String nombreTitulo = new File(rutaGuarda).getName();
	      setTitle("vRenamer" + " -- " + nombreTitulo);
	      if (automaticPreview) {
		  seleccionadosNuevo();
	      }
	  } else {
	      sinPermiso(rutaGuarda);
	      openRecent.remove(rutaGuarda);
	      rutaGuarda = null;
	  }
      } else {
	  sinPermiso(rutaGuarda);
	  openRecent.remove(rutaGuarda);
	  rutaGuarda = null;
      }
      menuRecent.removeAll();
      setMenuRecent();
      menuRecent.updateUI();
  }
  public void dialogoAbre() {
      if (getSistema().equals("mac")) {
	  dialogoAbreMac();
      }
      else {
	  String rutaGuardada = (prefs.get(prefRuta, ruta));
	  JFileChooser dlgOpen = new JFileChooser(rutaGuardada);
	  dlgOpen.setFileSelectionMode(0);
	  dlgOpen.setDialogTitle(Idioma.getMenuOpen()); 
	  FileNameExtensionFilter f;
	  dlgOpen.addChoosableFileFilter( f = new FileNameExtensionFilter("vRenamer (.vrn)", "vrn" ) );
	  dlgOpen.setFileFilter( f );
	  int opAbre = dlgOpen.showOpenDialog(this);
	  if (opAbre == 0) {
	      rutaGuarda = dlgOpen.getSelectedFile().toString();
	      String nombreTitulo = dlgOpen.getSelectedFile().getName();
	      if (leerDatos(rutaGuarda)) {
		  if ( openRecent.contains(rutaGuarda) ) {
		      openRecent.remove(rutaGuarda);
		  }
		  openRecent.add(0, rutaGuarda);
		  if (openRecent.size() > 5) {
		      openRecent.remove(openRecent.size() -1);
		  }
		  menuRecent.removeAll();
		  setMenuRecent();
		  menuRecent.updateUI();
		  setTitle("vRenamer" + " -- " + nombreTitulo);
		  prefs.put(prefRuta, dlgOpen.getSelectedFile().getAbsolutePath());
		  if (automaticPreview) {
		      seleccionadosNuevo();
		  }
	    } else {
		sinPermiso(rutaGuarda);
		rutaGuarda = null;
	    }
	  }
      }
  }
  public void dialogoAbreMac() {
      String rutaGuardada = (prefs.get(prefRuta, ruta));
      if ( new File (rutaGuardada).isFile()) 
          rutaGuardada = new File (rutaGuardada).getParent();
      FileDialog dlgOpen = new FileDialog(this,Idioma.getMenuOpen(),FileDialog.LOAD);
      dlgOpen.setDirectory(rutaGuardada);
      dlgOpen.setModal(true);

      dlgOpen.setFilenameFilter(new FilenameFilter(){
          @Override
	  public boolean accept(File dir, String name){
	    return (name.endsWith(".vrn"));
	  }
      });
      dlgOpen.setLocationRelativeTo(this);
      dlgOpen.setVisible(true);
      rutaGuarda = dlgOpen.getDirectory() + dlgOpen.getFile();
      String nombreTitulo = dlgOpen.getFile();
      if ( dlgOpen.getDirectory() != null && dlgOpen.getFile() != null) {
	  if (leerDatos(rutaGuarda)) {
	      if ( openRecent.contains(rutaGuarda) ) {
		  openRecent.remove(rutaGuarda);
	      }
	      openRecent.add(0, rutaGuarda);
	      if (openRecent.size() > 5) {
		  openRecent.remove(openRecent.size() -1);
	      }
	      menuRecent.removeAll();
	      setMenuRecent();
	      menuRecent.updateUI();
	      setTitle("vRenamer" + " -- " + nombreTitulo);	
	      prefs.put(prefRuta, rutaGuarda);
	      if (automaticPreview) {
                  seleccionadosNuevo();
              }
	  }
	  else {
	      sinPermiso(rutaGuarda);
	      rutaGuarda = null;
	  }
      }
      System.setProperty("apple.awt.fileDialogForDirectories", "false");
  }

  public void dialogoGuardaComo(){
      if (getSistema().equals("mac")) {
	  dialogoGuardaComoMac();
      }
      else {
	  String rutaGuardada = (prefs.get(prefRuta, ruta));
	  JFileChooser dlgSave = new JFileChooser(rutaGuardada);
	  dlgSave.setFileSelectionMode(JFileChooser.FILES_ONLY);
	  dlgSave.setDialogTitle(Idioma.getMenuSaveAs()); 

	  FileNameExtensionFilter f;
	  dlgSave.addChoosableFileFilter( f = new FileNameExtensionFilter("vRenamer (.vrn)", "vrn" ) );
	  dlgSave.setFileFilter( f );
	  int opGuarda = dlgSave.showSaveDialog(this);
	  if (opGuarda == 0) {
	    rutaGuarda = dlgSave.getSelectedFile().toString();
	    String nombreTitulo = dlgSave.getSelectedFile().getName();
	    if (!mBusca.getExtension(dlgSave.getSelectedFile().getAbsolutePath(), dlgSave.getSelectedFile().getName(), false, "").equals(".vrn")) {
	      rutaGuarda = rutaGuarda + ".vrn";
	      nombreTitulo = nombreTitulo + ".vrn";
	    }
            int respuesta = 0;
            if (new File(rutaGuarda).exists()) {
                respuesta = dialogoExiste();
            };     
            if (respuesta == 0) {
                if (escribirDatos(rutaGuarda)){
                  setTitle("vRenamer" + " -- " + nombreTitulo);
                  prefs.put(prefRuta, dlgSave.getSelectedFile().getAbsolutePath());
                } else {
                  sinPermiso(rutaGuarda);
                  rutaGuarda = null;
                }
            } else {
                rutaGuarda = null;
            }
	  }
      }
  }
  public void dialogoGuardaComoMac(){
      String rutaGuardada = (prefs.get(prefRuta, ruta));
      if ( new File (rutaGuardada).isFile()){
          rutaGuardada = new File (rutaGuardada).getParent();
      }
      FileDialog dlgSave = new FileDialog(this, Idioma.getMenuSaveAs(), FileDialog.SAVE);
      dlgSave.setDirectory(rutaGuardada);
      if (rutaGuarda != null) {
          dlgSave.setFile(new File(rutaGuarda).getName());
      }
      dlgSave.setModal(true);
      dlgSave.setFilenameFilter((File dir, String name1) -> (name1.endsWith(".vrn")));
      dlgSave.setVisible(true);
      if (dlgSave.getDirectory() != null) {
          rutaGuarda = dlgSave.getDirectory() + dlgSave.getFile();
      }
      String nombreTitulo = dlgSave.getFile();
      if ( dlgSave.getDirectory() != null && dlgSave.getFile() != null) {
	  if (!mBusca.getExtension(rutaGuarda, dlgSave.getFile(), false, "").equals(".vrn")) {
	    rutaGuarda = rutaGuarda + ".vrn";
	    nombreTitulo = nombreTitulo + ".vrn";
	  }
        int respuesta = 0;
//        if (new File(rutaGuarda).exists()) {
//            respuesta = dialogoExiste();
//        };     
        if (respuesta == 0) {
	  if (escribirDatos(rutaGuarda)) {
	      setTitle("vRenamer" + " -- " + nombreTitulo);	
	      prefs.put(prefRuta, rutaGuarda);
	  }
	  else {
	      sinPermiso(rutaGuarda);
	      rutaGuarda = null;
	    }
        } else {
            rutaGuarda = null;
        }
      }
  }
  public void dialogoGuarda() {
    if (rutaGuarda == null) dialogoGuardaComo();
    else if (!escribirDatos(rutaGuarda)) sinPermiso(rutaGuarda);    
  }
  public void iniciaValores() {
      automaticPreview = !(iniciaAuto.equals("falso"));
      autoDespuesReset = automaticPreview;
      if (modoDrop) {
	  opcionesFiltroDer.setEnabled(false);
	  comboFiltro.setEnabled(false);
	  jRuta.setEnabled(false);
      }
      if ( ! iniciaSesion.equals("clean") || ! iniciaReboot.equals("clean")) {
	  prefs.put(prefReboot, "clean");
	  if ( ! recuperaLast() ) {
	      System.err.println("Cannot recover last session");
	  } else if (automaticPreview) {
              seleccionadosNuevo();
          }
      }
      if ( ! new File (rutaHome + separador + vrenamerFolder).exists() ) {
	  if ( ! new File (rutaHome + separador + vrenamerFolder).mkdir() ) {
	      System.err.println("Cannot create vRenamer directory");
	  }
      }
      if ( iniciaIdioma.equals("Esp") ) {
	  locale = new Locale("es", "ES");
      } else {
	  locale = new Locale("en", "US");
      }
      diasMes = Integer.parseInt(iniciaDiasMes);
      if (iniciaModified.equals("manual")) {
	  datoCalendario = new Date();
      }
//      if (automaticPreview && iniciaSesion.equals("last")) {
//	  seleccionadosNuevo();
//      }
      if (iniciaVersion.startsWith("false")) {
	  String[] versionArray = iniciaVersion.split(",");
	  if (versionArray[1] != null) {
	      int versionInt = Integer.parseInt(versionArray[1]);
	      int versionActualInt = Integer.parseInt(Version.replace(".",""));
	      if (versionActualInt > versionInt) {
		  iniciaVersion = "true";
		  prefs.put(prefVersion, "true");
	      } else {
		  iniciaVersion = "false";
	      }
	  } else {
	      prefs.put(prefVersion, "false" + "," + Version.replace(".",""));	      
	  }
      }
      if (iniciaVersion.equals("true")) {
	  chequeaVersion();
      }
  }
  private void aplicaOpciones() {
      Boolean creaPreview = false;
      if (comboIdioma.getSelectedIndex() == 0) cambiaAEsp();
      else if (comboIdioma.getSelectedIndex() == 1) cambiaAEng();
      if (comboSesion.getSelectedIndex() == 0) iniciaSesion = "clean";
      else iniciaSesion = "last";
      switch (comboRenombrado.getSelectedIndex()) {
	  case 0:
	      iniciaCarpeta = "default";
	  break;
	  case 1:
	      iniciaCarpeta = "contenido";
	  break;
      }
      switch (comboEstructura.getSelectedIndex()) {
	  case 0:
	      if (copiarEstructura && ckCopiaCarpeta.isSelected()) {
		  creaPreview = true;
	      }
	      copiarEstructura = false;
	  break;
	  case 1:
	      if ( ! copiarEstructura  && ckCopiaCarpeta.isSelected()) {
		  creaPreview = true;
	      }
	      copiarEstructura = true;
	  break;
      }
      switch (comboRecursivoCarpeta.getSelectedIndex()) {
	  case 0:
	      recursivoCarpeta = false;
	  break;
	  case 1:
	      recursivoCarpeta = true;
	  break;
      }
      switch (comboCopiarRenombrados.getSelectedIndex()) {
	  case 0:
	      if (copiarRenombrados && ckCopiaCarpeta.isSelected()) {
		  creaPreview = true;
	      }
	      copiarRenombrados = false;
	  break;
	  case 1:
	      if ( ! copiarRenombrados  && ckCopiaCarpeta.isSelected()) {
		  creaPreview = true;
	      }
	      copiarRenombrados = true;
	  break;
      }
      iniciaBasura = txtBasura.getText();
      if (comboAuto.isEnabled()) {
	  if (comboAuto.getSelectedIndex() == 0) {
	      automaticPreview = true;
	      autoDespuesReset = true;
	  } else {
	      automaticPreview = false;
	      autoDespuesReset = false;
	  }
      }
      if (soloPanel.isSelected() && iniciaRenderer.equals("preview")) {
	  iniciaRenderer = "default";
	  navega(ruta);
      } else if (ambos.isSelected() && iniciaRenderer.equals("default")) {
	  iniciaRenderer = "preview";
	  navega(ruta);
      }
      diasMes = comboFechas.getSelectedIndex();
      if ( modified.isSelected() ) {
          if ( ! iniciaModified.equals("modified") ) {
              creaPreview = true;
          }
          iniciaModified = "modified";
      } else if ( creation.isSelected() ) {
          if ( ! iniciaModified.equals("creation") ) {
              creaPreview = true;
          }
          iniciaModified = "creation";
      } else if ( accessed.isSelected() ) {
          if ( ! iniciaModified.equals("accessed") ) {
              creaPreview = true;
          }
          iniciaModified = "accessed";
      } else if ( manual.isSelected() ) {
          if ( ! iniciaModified.equals("manual") ) {
              creaPreview = true;
          }
          iniciaModified = "manual";
      }
      datoCalendario = calendario.getDate();
      if ( automaticPreview && creaPreview ) {
	  seleccionadosNuevo();
      }
  }
  public void leeOpciones() {
      if (Idioma instanceof idiomasEsp) comboIdioma.setSelectedIndex(0);
      else if (Idioma instanceof idiomasEng) comboIdioma.setSelectedIndex(1);
      if (iniciaSesion.equals("clean")) comboSesion.setSelectedIndex(0);
      else comboSesion.setSelectedIndex(1);
      if (iniciaRenderer.equals("default")) soloPanel.setSelected(true);
      else ambos.setSelected(true);
      if (oArchivos.getCuentaArchivos() > 10000 ) comboAuto.setEnabled(false);
      else comboAuto.setEnabled(true);
      if (iniciaCarpeta.equals("default")) comboRenombrado.setSelectedIndex(0);
      else comboRenombrado.setSelectedIndex(1);
      if ( ! copiarEstructura ) comboEstructura.setSelectedIndex(0);
      else comboEstructura.setSelectedIndex(1);     
      if ( ! recursivoCarpeta ) comboRecursivoCarpeta.setSelectedIndex(0);
      else comboRecursivoCarpeta.setSelectedIndex(1);     
      if ( ! copiarRenombrados ) comboCopiarRenombrados.setSelectedIndex(0);
      else comboCopiarRenombrados.setSelectedIndex(1);     
      txtBasura.setText(iniciaBasura);
      if ( ! automaticPreview && autoDespuesReset ) {
	  if (autoDespuesReset) comboAuto.setSelectedIndex(0);
	  else comboAuto.setSelectedIndex(1);
      }
      else {
	  if (automaticPreview) comboAuto.setSelectedIndex(0);
	  else comboAuto.setSelectedIndex(1);
      }
      comboFechas.setSelectedIndex(diasMes);
      if ( datoCalendario != null) calendario.setDate(datoCalendario);
      switch (iniciaModified) {
          case "modified":
              modified.setSelected(true);
              calendario.setEnabled(false);
              btnActualizaCalendar.setEnabled(false);
	  break;
          case "creation":
              creation.setSelected(true);
              calendario.setEnabled(false);
              btnActualizaCalendar.setEnabled(false);
	  break;
          case "accessed":
              accessed.setSelected(true);
              calendario.setEnabled(false);
              btnActualizaCalendar.setEnabled(false);
	  break;
          default:
              manual.setSelected(true);
              calendario.setEnabled(true);
              btnActualizaCalendar.setEnabled(true);
	  break;
      }
  }

  public Boolean guardaLast() {
      return escribirDatos(rutaHome + separador + vrenamerFolder + separador + "vrenamerLast");
  }
  public Boolean recuperaLast() {
      return leerDatos(rutaHome + separador + vrenamerFolder + separador + "vrenamerLast");
  }
  private BarraRenombra creaBarraRenombra() {
      BarraRenombra barra = new BarraRenombra();
      DropTarget dropTarget = new DropTarget(barra, DnDConstants.ACTION_MOVE, null);    
      try {
          dropTarget.addDropTargetListener(new DropTargetBarra(barra));
      } catch (TooManyListenersException ex) {
          Logger.getLogger(vRenamer.class.getName()).log(Level.SEVERE, null, ex);
      }
      barra.addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
          }

          @Override
          public void mousePressed(MouseEvent e) {
              barra.setTransferHandler(new ValueExportTransferHandler(Integer.toString(BarraRenombra.getComponenteIndex(barra))));
          }

          @Override
          public void mouseReleased(MouseEvent e) {
          }

          @Override
          public void mouseEntered(MouseEvent e) {
          }

          @Override
          public void mouseExited(MouseEvent e) {
          }
      });
        barra.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                panelDragged = (BarraRenombra) e.getSource();
                TransferHandler handle = panelDragged.getTransferHandler();
                handle.exportAsDrag(panelDragged, e, TransferHandler.MOVE);
            }
        });      
      return barra;
  }
    public void pulsaMas(int posicion) {
        pnlBuscaTotal.add(creaBarraRenombra(), posicion +1);
        pnlBuscaTotal.updateUI();
        if (automaticPreview) {
            seleccionadosNuevo();                        
        }           
    }
    public void pulsaMenos(BarraRenombra barra) {
        pnlBuscaTotal.remove(barra);        
        if (pnlBuscaTotal.getComponentCount() == 0  ) {
            pnlBuscaTotal.add(new BarraRenombra());            
        }
        pnlBuscaTotal.updateUI();        
        if (automaticPreview) {
            RE.seleccionadosNuevo();                        
        }                   
    }  
  public Boolean leerDatos(String rutaIn) {
    Boolean despuesReset = automaticPreview;
    automaticPreview = false;
    bloqueaConmuta = true ;
    FileInputStream fileInputStream = null;
    XMLDecoder decoder;
    vDatos datos = null;
    resetValoresNuevo();
    try { 
      fileInputStream = new FileInputStream(rutaIn);
      decoder = new XMLDecoder(fileInputStream);
      try {
	  datos = (vDatos) decoder.readObject();
      } catch (Exception n) {
	  datos = intentaDatos(decoder, rutaIn);
      }
      int gContador = datos.getContador();
      int[] estadoContador = datos.getEstadoContador();
      int[] selecCampos = datos.getSelecCampos();
      boolean[] esSeleccionado = datos.getEsSeleccionado();
      boolean[] esActivo = datos.getEsActivo();
      String[] txtCampos = datos.getTxtCampos();
      String[] txtTexto = datos.getTxtTexto();
      int[] secuenciaTip = datos.getSecuenciaTipo();
      int[] secuenciaTipoCas = datos.getSecuenciaTipoCase();
      int[] numeraCeros = datos.getNumeraCeros();
      int[] opcionNumeracion = datos.getOpcionNumeracion();
      String[] numeraEmpieza = datos.getNumeraEmpieza();
      String[] numeraSalto = datos.getNumeraSalto();
      int [] comArchivo = datos.getComArchivos();
      String[] txtCorte = datos.getTxtCorte();
      String[] spSeccion = datos.getSpSeccion();
      int[] comFinal = datos.getComFinal();
      String[] archDesde = datos.getArchDesde();
      String[] archHasta = datos.getArchHasta();
      String[] archTextoDesde = datos.getArchTextoDesde();
      String[] archTextoHasta = datos.getArchTextoHasta();
      int[] comCarpeta = datos.getComCarpeta();
      int[] comSepFecha = datos.getComSepFecha();
      int[] comFecha = datos.getComFecha();
      int[] comFechaMeta = datos.getComFechaMeta();
      int[] comCamara = datos.getComCamara();
      int[] comMusica = datos.getComMusica();
      String texInserta = datos.getTexInserta();
      String spInserta = datos.getSpInserta();
      Boolean derInserta = datos.getDerInserta();
      Boolean derTrimInserta = datos.getDerTrimInserta();
      String spDesde = datos.getSpDesde();
      String spHasta = datos.getSpHasta();
      Boolean derElimina = datos.getDerElimina();
      String reemUno = datos.getReemUno();
      String reemDos = datos.getReemDos();
      int modoReem = datos.getModoReem();
      String aleaSel = datos.getAleaSel();
      String spAleatorio = datos.getSpAleatorio();
      int opCapi = datos.getOpCapi();
      int opNorma = datos.getOpNorma();
      int opNume = datos.getOpNumeros();
      int opAtri = datos.getOpAtri();
      int[] iAtrib = datos.getIAtrib();
      int cAtrib = datos.getCAtrib();
      int opAtriEst = datos.getOpAtriEst();
      Boolean checkNum = datos.getCheckNum();
      Boolean checkNorma = datos.getCheckNorma();
      Boolean checkReem = datos.getCheckReem();
      Boolean checkAtri = datos.getCheckAtri();
      Boolean checkAlea = datos.getCheckAlea();
      Boolean checkMay = datos.getCheckMay();
      int tabPanel = datos.getTabPanel();
      String txtSym = datos.getTxtSym();
      String normalizaTri = datos.getNormalizaTrim();
      String normaPos = datos.getNormaPosicion();
      String numerosE = datos.getNumerosEn();
      String numerosSal = datos.getNumerosSalto();
      String numerosPos = datos.getNumerosPosicion();
      String normaCer = datos.getNormaCeros();
      Boolean Case = datos.getCase();
      Boolean Excluye = datos.getExcluye();
      String txtFiltro = datos.getTxtFiltro();
      Boolean ckExtension = datos.getCkExtension();
      String txtExt = datos.getTxtExt();
      Boolean ckSepara = datos.getCkSepara();
      String txtSepara = datos.getTxtSepara();
      int opSepara = datos.getOpSepara();
      pnlBuscaTotal.removeAll();
      pnlBuscaTotal.updateUI();
      for (int x=0;x<=gContador -1;x++) {          
        BarraRenombra barra = creaBarraRenombra();
	try {
          barra.setSeparaIndex(selecCampos[x]);
          barra.setSeparaText(txtCampos[x]);
	} catch (NullPointerException j) { //compatibilidad versiones anteriores
	  barra.setSeparaIndex(opSepara);
	  barra.setSeparaText(txtSepara);
	  if (!ckSepara) {
              barra.setSeparaText("off");
          }
	}        
	switch(estadoContador[x]) {
	  case 0 -> {
              barra.creaText();
              barra.setComboBusca(0);
              barra.setText(txtTexto[x]);
          }
	  case 1 -> {
              barra.setComboBusca(1);              
              barra.creaNumeracion();              
              try {
                  barra.setSecuenciaTipo(secuenciaTip[x]);
              } catch (NullPointerException j) { //compatibilidad versiones anteriores
              }                            
              try {
                  barra.setSecuenciaTipoCase(secuenciaTipoCas[x]);
              } catch (NullPointerException j) { //compatibilidad versiones anteriores
              }              
              
              barra.setJNumeracion(numeraCeros[x]);

              if (barra.getSecuenciaTipo().getSelectedIndex() == 0) {
                  barra.setNumeracionTexto(Integer.valueOf(numeraEmpieza[x]));
              } else {
                 java.util.List<String> listaModeloNumeracion = MotorBusca.getListaModeloNumeracion(barra.getSecuenciaTipo().getSelectedIndex());  
                 SpinnerModel spin = new SpinnerListModel(listaModeloNumeracion);
                 spin.setValue(listaModeloNumeracion.get(Integer.parseInt(numeraEmpieza[x])));
                 barra.setModeloNumeracion(spin);
              }
              
              try {
                  barra.setNumeracionSalto(Integer.valueOf(numeraSalto[x]));
              } catch (NullPointerException j) { //compatibilidad versiones anteriores
              }
              
              try {
                  barra.setResetNumera(opcionNumeracion[x]);
              } catch (NullPointerException j) { //compatibilidad versiones anteriores
                                  
              } 
              barra.addElementosNumeracion();
              
          }
	  case 2 -> {
              barra.creaNombreArchivo();
              barra.setComboBusca(2);
              try {
                  switch (comArchivo[x]) {
                      case 0 -> {
                          barra.setJCorte(txtCorte[x]);
                          barra.setNumeracionCorte(Integer.valueOf(spSeccion[x]));
                          barra.setHastaFinal(comFinal[x]);
                      }
                      case 1 -> {
                          barra.setJArchivo(comArchivo[x]);
                          barra.setArchivoDesde(Integer.valueOf(archDesde[x]));
                          barra.setArchivoHasta(Integer.valueOf(archHasta[x]));
                      }
                      case 2 -> {
                          barra.setJArchivo(comArchivo[x]);
                          barra.setArchivoTextoDesde(archTextoDesde[x]);
                          barra.setArchivoTextoHasta(archTextoHasta[x]);
                      }
                      default -> {
                      }
                  }
              } catch (NullPointerException j) { //compatibilidad versiones anteriores
                  barra.setJCorte(txtCorte[x]);
                  barra.setNumeracionCorte(Integer.valueOf(spSeccion[x]));
                  barra.setHastaFinal(comFinal[x]);
              } 
              barra.addElementosNombreArchivo();   
              
          }
	  case 3 -> {
              barra.creaNombreCarpeta();
              barra.setComboBusca(3);
              barra.setJCarpeta(comCarpeta[x]);
              }
	  case 4 -> {
              barra.creaFecha();
              barra.setComboBusca(4);
              try {
                  barra.setSeparaFecha(comSepFecha[x]);
              } catch (NullPointerException j) { //compatibilidad versiones anteriores
                  barra.setSeparaFecha(1);
              }
              barra.setJFecha(comFecha[x]);
              }
	  case 5 -> {
              barra.creaMetaImg();
              barra.setComboBusca(5);
              try {
                  barra.setSeparaFecha(comSepFecha[x]);
              } catch (NullPointerException j) { //compatibilidad versiones anteriores
                  barra.setSeparaFecha(1);
              }
              try {
                  barra.setJMetadata(comFechaMeta[x]);
              }
              catch (NullPointerException j) { //compatibilidad versiones anteriores
                  barra.setJMetadata(comFecha[x]);
              } }
	  case 6 -> {
              barra.creaCamara();
              barra.setComboBusca(6);
              barra.setJMetadataCamara(comCamara[x]);
              }
	  case 7 -> {
              barra.creaMp3();
              barra.setComboBusca(7);
              barra.setJMp3(comMusica[x]);
              if (comMusica[x] == 2) {
                  barra.setJMp3(numeraCeros[x]);
              } 
              barra.addElementosMp3();
          }	      	    
	}
        try {            
            barra.setCkEnabled(esSeleccionado[x]);
            barra.setEnabled(esActivo[x]);
        } catch (Exception j) {            
        }
        pnlBuscaTotal.add(barra);
        pnlBuscaTotal.updateUI();
      }
      txtInsertar.setText(texInserta);
      spnInsertar.getModel().setValue(Integer.valueOf(spInserta));
      desdeDerechaInserta.setSelected(derInserta);
      try {
	  desdeDerechaTrim.setSelected(derTrimInserta);
      } catch (Exception j) { //compatibilidad versiones anteriores
	  desdeDerechaTrim.setSelected(false);
      }
      spnDesde.getModel().setValue(Integer.valueOf(spDesde));
      spnHasta.getModel().setValue(Integer.valueOf(spHasta));
      desdeDerecha.setSelected(derElimina);
      txtReemplazaUno.setText(reemUno);
      txtReemplazaDos.setText(reemDos);
      cMode.setSelectedIndex(modoReem);
      JRadioButton b;
      for (Enumeration e=grAleatorio.getElements(); e.hasMoreElements(); ) {
        b = (JRadioButton)e.nextElement();
        if (b.getText().equals(aleaSel)) {
	    b.setSelected(true);
            break;
        }
      }
      AleatorioLong.getModel().setValue(Integer.valueOf(spAleatorio));
      jCapitaliza.setSelectedIndex(opCapi);
      capitalizaBusca();
      try {
	  jNormaliza.setSelectedIndex(opNorma);
	  normalizaBusca();
      } catch (Exception j) { //compatibilidad versiones anteriores
	  jNormaliza.setSelectedIndex(0);
      }
      try {
	  opNumeros.setSelected(checkNum);
      } catch (Exception j) { //compatibilidad versiones anteriores
	  opNumeros.setSelected(false);
      }
      try {
	  jNumeros.setSelectedIndex(opNume);
	  numerosBusca();
	  activaCheck("numeros");
      } catch (Exception j) { //compatibilidad versiones anteriores
	  jNumeros.setSelectedIndex(0);
      }
      try {
	  jAtributos.setSelectedIndex(opAtri);
      } catch (Exception j) { //compatibilidad versiones anteriores
	  jAtributos.setSelectedIndex(0);
      }
      try {
	  jAtributosEstado.setSelectedIndex(opAtriEst);
      } catch (Exception j) { //compatibilidad versiones anteriores
	  jAtributosEstado.setSelectedIndex(0);
      }
      try {
	  opReemplaza.setSelected(checkReem);
	  activaCheck("reemplaza");
      } catch (Exception j) { //compatibilidad versiones anteriores
	  opReemplaza.setSelected(false);
      }
      try {
	  opNormaliza.setSelected(checkNorma);
	  activaCheck("normaliza");
      } catch (Exception j) { //compatibilidad versiones anteriores
	  opNormaliza.setSelected(false);
      }
      try {
	  opAtributos.setSelected(checkAtri);
	  activaCheck("atributos");
	  if (opAtri == 4)
	      actualizaAtributo();
      } catch (Exception j) { //compatibilidad versiones anteriores
	  opAtributos.setSelected(false);
      }
      try {
          System.arraycopy(iAtrib, 0, iAtributos, 0, sAtributos.length);
      } catch (Exception j) { //compatibilidad versiones anteriores
	  for (int x=0;x<iAtributos.length;x++) {
	      if (x == iAtributos.length - 1) iAtributos[x] = 1;
	      else iAtributos[x] = 0;
	  }
      }
      try {
	  cAtributos.setSelectedIndex(cAtrib);
      } catch (Exception j) { //compatibilidad versiones anteriores
	  cAtributos.setSelectedIndex(0);
      }

      try {
	  opAleatorio.setSelected(checkAlea);
	  activaCheck("aleatorio");
      } catch (Exception j) { //compatibilidad versiones anteriores
	  opAleatorio.setSelected(false);
      }
      try {
	  opCapitaliza.setSelected(checkMay);
	  activaCheck("capitaliza");
      } catch (Exception j) { //compatibilidad versiones anteriores
	  opCapitaliza.setSelected(false);
      }
      try {
	  txtSymbols.setText(txtSym);
      } catch (Exception j) { //compatibilidad versiones anteriores
	  txtSymbols.setText("_-[(");
      }
      try {
	  normalizaTrim.getModel().setValue(Integer.valueOf(normalizaTri));
      } catch (Exception j) { //compatibilidad versiones anteriores
	  normalizaTrim.getModel().setValue(1);
      }
      try {
	  normaPosicion.getModel().setValue(Integer.valueOf(normaPos));
      } catch (Exception j) { //compatibilidad versiones anteriores
	  normaPosicion.getModel().setValue(1);
      }
      try {
	  normaCeros.getModel().setValue(Integer.valueOf(normaCer));
      } catch (Exception j) { //compatibilidad versiones anteriores
	  normaCeros.getModel().setValue(1);
      }
      try {
	  numerosEn.getModel().setValue(Integer.valueOf(numerosE));
      } catch (Exception j) { //compatibilidad versiones anteriores
	  numerosEn.getModel().setValue(1);
      }
      try {
	  numerosSalto.getModel().setValue(Integer.valueOf(numerosSal));
      } catch (Exception j) { //compatibilidad versiones anteriores
	  numerosSalto.getModel().setValue(1);
      }
      try {
	  numerosPosicion.getModel().setValue(Integer.valueOf(numerosPos));
      } catch (Exception j) { //compatibilidad versiones anteriores
	  numerosPosicion.getModel().setValue(1);
      }
      pestPanel.setSelectedIndex(tabPanel);

      activa(datos.getGrupoRenombra());

      jFiltro.setText(txtFiltro);
      try {
	  ckCase.setSelected(Case);
      } catch (Exception j) { //compatibilidad versiones anteriores
	  ckCase.setSelected(false);
      }
      try {
	  ckExcluye.setSelected(Excluye);
      } catch (Exception j) { //compatibilidad versiones anteriores
	ckExcluye.setSelected(false);
      }
      ckOpcionDos.setSelected(ckExtension);
      txtExtension.setText(txtExt);
      conmutaExtension();
      ckOpcionTres.setSelected(ckSepara);
      jSepara.setSelectedIndex(opSepara);
      JTextField jtSepara = (JTextField)jSepara.getEditor().getEditorComponent();
      jtSepara.setText(txtSepara);
      if (ckOpcionTres.isSelected()) jSepara.setEnabled(true);
      else jSepara.setEnabled(false);
      bloqueaConmuta = false;
      filtrado = jFiltro.getText();
      if (modoDrop) {
          actualizaDespuesDrop();
      }
      else {
	  actualizaDespuesAplicar(ruta);
      }
      atributos();
      automaticPreview = despuesReset;
      return true;
    } catch (FileNotFoundException | NullPointerException | ArrayIndexOutOfBoundsException e) {
        return false;
    } finally {
        try {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Exception n) {

        }
    }

  }

  private vDatos intentaDatos(XMLDecoder decoder, String rutaIn) {
      vDatos datos = null;
      String rutaInDos;
      try {
            datos = (vDatos) decoder.readObject();
      } catch (Exception ex) {
            FileInputStream fileInputStreamDos = null;
            XMLDecoder decoderDos;
            rutaInDos = fixDatos (rutaIn);
            try {
                fileInputStreamDos = new FileInputStream(rutaInDos);
                decoderDos = new XMLDecoder(fileInputStreamDos);
                datos = (vDatos) decoderDos.readObject();
                new File (rutaIn).delete();
                new File (rutaInDos).renameTo(new File (rutaIn));
            } catch (Exception e) {
                new File (rutaInDos).delete();
            } finally {
                try {
                    if (fileInputStreamDos != null) {
                        fileInputStreamDos.close();
                    }
                }
                catch (Exception e) {

                }
            }
      }
      return datos;
  }
  
  private String fixDatos(String rutaFix) {
        FileInputStream entradaFixStream = null;
        PrintStream pwDatosTemp = null;
        int indiceNuevaRuta = 0;
        String nuevaRutaFix;
        nuevaRutaFix = rutaFix.substring(0, rutaFix.lastIndexOf('.')) + "_tmp.vrn";
        while (new File(nuevaRutaFix).exists()) {
            indiceNuevaRuta++;
            nuevaRutaFix = nuevaRutaFix.replace("_tmp", "_tmp" + indiceNuevaRuta);
        }
        try {
            reader = null;
            entradaFixStream = new FileInputStream(rutaFix);
            reader = new BufferedReader(new InputStreamReader(entradaFixStream, "UTF8"));
            pwDatosTemp = new PrintStream(new FileOutputStream(nuevaRutaFix), true, "UTF8");
            String linea = reader.readLine();
            while (linea != null) {
                if ( linea.contains("vDatos") && ! linea.contains("vrenamer") ) {
                    pwDatosTemp.println(linea.replace("vDatos","vrenamer.vDatos"));
                } else {
                    pwDatosTemp.println(linea);                    
                }
                linea = reader.readLine();
            }

        } catch (Exception e) {
            
        } finally {
            try {
                if (entradaFixStream != null) {
                    entradaFixStream.close();
                }
                if (pwDatosTemp != null) {
                    pwDatosTemp.close();
                }
            } catch (Exception n) {
               
            }
        }
        return nuevaRutaFix;
  }
  
  public Boolean escribirDatos(String rutaIn) {
    vDatos datos;
    SerializarDatos serializarDatos;
    datos = new vDatos();

    try {
      String grupoSel="";
      JRadioButton b;
      for ( Enumeration e=opRenombra.getElements(); e.hasMoreElements(); ) {
        b = (JRadioButton)e.nextElement();
        if (b.isSelected()) {
	    grupoSel = b.getName();
            break;
        }
      }
      int c = pnlBuscaTotal.getComponentCount();
      int[] estadoContador = new int[c];
      int[] selecCampos = new int[c];
      String[] txtCampos = new String[c];
      boolean[] esSeleccionado = new boolean[c];
      boolean[] esActivo = new boolean[c];
      
      String[] txtTexto = new String[c];
      int[] secuenciaTip = new int[c];
      int[] secuenciaTipoCas = new int[c];
      int[] numeraCeros = new int[c];
      String[] numeraEmpieza = new String[c];
      String[] numeraSalto = new String[c];

      int[] opcionNumeracion = new int[c];

      int[] comArchivo = new int[c];
      String[] txtCorte = new String[c];
      String[] spSeccion = new String[c];
      int[] comFinal = new int[c];

      String[] archDesde = new String[c];
      String[] archHasta = new String[c];

      String[] archTextoDesde = new String[c];
      String[] archTextoHasta = new String[c];

      int[] comCarpeta = new int[c];
      int[] comSepFecha = new int[c];
      int[] comFecha = new int[c];
      int[] comFechaMeta = new int[c];
      int[] comCamara = new int[c];
      int[] comMusica = new int[c];
      String texInserta;
      String spInserta;
      Boolean derInserta;
      Boolean derTrimInserta;
      String spDesde;
      String spHasta;
      Boolean derElimina;
      String reemUno;
      String reemDos;
      int modoReem;
      String aleaSel="";
      String spAleatorio;
      int opCapi;
      int opNorma;
      int opNume;
      int opAtri;
      int[] iAtrib = new int[sAtributos.length];
      int cAtrib;
      int opAtriEst;
      int tabPanel;
      String txtSym;
      String normalizaTri;
      String normaPos;
      String normaCer;
      String numerosE;
      String numerosSal;
      String numerosPos;
      Boolean checkNum;
      Boolean checkNorma;
      Boolean checkReem;
      Boolean checkAtri;
      Boolean checkAlea;
      Boolean checkMay;
      String txtFiltro;
      Boolean Case;
      Boolean Excluye;

      Boolean ckExtension;
      String txtExt;
      Boolean ckSepara;
      String txtSepara;
      int opSepara;

      datos.setGrupoRenombra(grupoSel);
      datos.setContador(c);
      int x = 0;
      for (Component comp : pnlBuscaTotal.getComponents()) {
        BarraRenombra barra = (BarraRenombra) comp;
	selecCampos[x] = barra.getJSeparaCampos().getSelectedIndex();
//	JTextField jtSepara = (JTextField)barra.getJSeparaCampos().getEditor().getEditorComponent();
	txtCampos[x] = barra.getSeparaText();
        esSeleccionado[x] = barra.getCkEnabled().isSelected();
        esActivo[x] = barra.isEnabled();        
	estadoContador[x] = barra.getComboBusca().getSelectedIndex();
	switch (estadoContador[x]) {
	  case 0:
	    txtTexto[x] = barra.getName();
	  break;
	  case 1:
            secuenciaTip[x] = barra.getSecuenciaTipo().getSelectedIndex();
            secuenciaTipoCas[x] = barra.getSecuenciaTipoCase().getSelectedIndex();
            numeraCeros[x] = barra.getJNumeracion().getSelectedIndex();
	    if (secuenciaTip[x] == 0) {
		numeraEmpieza[x] = barra.getNumeracionTexto().getModel().getValue().toString();
	    } else {
		SpinnerListModel modeloNumeracion = (SpinnerListModel) barra.getNumeracionTexto().getModel();
		java.util.List<String> listaModeloNumeracion = (java.util.ArrayList<String>) modeloNumeracion.getList();
		String indiceNumeracion = listaModeloNumeracion.indexOf(barra.getNumeracionTexto().getValue().toString()) + "";
		numeraEmpieza[x] = indiceNumeracion;
	    }
	    numeraSalto[x] = barra.getNumeracionSalto().getModel().getValue().toString();
	    opcionNumeracion[x] = barra.getResetNumera().getSelectedIndex();
	  break;	      
	  case 2:
	    comArchivo[x] = barra.getJArchivo().getSelectedIndex();
	    if (comArchivo[x] == 0) {
	      txtCorte[x] = barra.getJCorte().getText();
	      spSeccion[x] = barra.getNumeracionCorte().getModel().getValue().toString();
	      comFinal[x] = barra.getHastaFinal().getSelectedIndex();
	    }
	    else if (comArchivo[x] == 1) {
	      archDesde[x] = barra.getArchivoDesde().getModel().getValue().toString();
	      archHasta[x] = barra.getArchivoHasta().getModel().getValue().toString();
	    }
	    else if (comArchivo[x] == 2) {
	      archTextoDesde[x] = barra.getArchivoTextoDesde().getText();
	      archTextoHasta[x] = barra.getArchivoTextoHasta().getText();
	    }
	  break;	      
	  case 3:
	    comCarpeta[x] = barra.getJCarpeta().getSelectedIndex();
	  break;	      
	  case 4:
	    comSepFecha[x] = barra.getSeparaFecha().getSelectedIndex();
	    comFecha[x] = barra.getJFecha().getSelectedIndex();
	  break;	      
	  case 5:
	    comSepFecha[x] = barra.getSeparaFecha().getSelectedIndex();
	    comFechaMeta[x] = barra.getJMetadata().getSelectedIndex();
	  break;	      
	  case 6:
	    comCamara[x] = barra.getJMetadataCamara().getSelectedIndex();
	  break;	      
	  case 7:
	    comMusica[x] = barra.getJMp3().getSelectedIndex();
	    if (comMusica[x] == 2) {
                numeraCeros[x] = barra.getJNumeracion().getSelectedIndex();
            }
	  break;	      	    
	}
        x++;
      }
      texInserta = txtInsertar.getText();
      spInserta = spnInsertar.getModel().getValue().toString();  
      derInserta = desdeDerechaInserta.isSelected();
      derTrimInserta = desdeDerechaTrim.isSelected();
      spDesde = spnDesde.getModel().getValue().toString();
      spHasta = spnHasta.getModel().getValue().toString();
      derElimina = desdeDerecha.isSelected();
      reemUno = txtReemplazaUno.getText();
      reemDos = txtReemplazaDos.getText();
      modoReem = cMode.getSelectedIndex();
      for ( Enumeration e=grAleatorio.getElements(); e.hasMoreElements(); ) {
        b = (JRadioButton)e.nextElement();
        if (b.isSelected()) {
	    aleaSel = b.getText();
            break;
        }
      }
      spAleatorio = AleatorioLong.getModel().getValue().toString();
      opCapi = jCapitaliza.getSelectedIndex();
      opNorma = jNormaliza.getSelectedIndex();
      opNume = jNumeros.getSelectedIndex();
      opAtri = jAtributos.getSelectedIndex();
      System.arraycopy(iAtributos, 0, iAtrib, 0, sAtributos.length);
      cAtrib = cAtributos.getSelectedIndex();
      opAtriEst = jAtributosEstado.getSelectedIndex();
      checkNum = opNumeros.isSelected();
      checkNorma = opNormaliza.isSelected();
      checkReem = opReemplaza.isSelected();
      checkAtri = opAtributos.isSelected();
      checkAlea = opAleatorio.isSelected();
      checkMay = opCapitaliza.isSelected();

      tabPanel = pestPanel.getSelectedIndex();
      txtSym = txtSymbols.getText();
      normalizaTri = normalizaTrim.getModel().getValue().toString();
      normaPos = normaPosicion.getModel().getValue().toString();
      normaCer = normaCeros.getModel().getValue().toString();
      numerosE = numerosEn.getModel().getValue().toString();      
      numerosSal = numerosSalto.getModel().getValue().toString();      
      numerosPos = numerosPosicion.getModel().getValue().toString();      
      
      txtFiltro = jFiltro.getText();
      Case = ckCase.isSelected();
      Excluye = ckExcluye.isSelected();
      ckExtension = ckOpcionDos.isSelected();
      txtExt = txtExtension.getText();
      ckSepara = ckOpcionTres.isSelected();
      JTextField jtSepara = (JTextField)jSepara.getEditor().getEditorComponent();
      txtSepara = jtSepara.getText();
      opSepara = jSepara.getSelectedIndex();

      datos.setEstadoContador(estadoContador);

      datos.setSelecCampos(selecCampos);
      datos.setTxtCampos(txtCampos);
      datos.setEsSeleccionado(esSeleccionado);
      datos.setEsActivo(esActivo);
      datos.setTxtTexto(txtTexto);
      datos.setSecuenciaTipo(secuenciaTip);
      datos.setSecuenciaTipoCase(secuenciaTipoCas);
      datos.setNumeraCeros(numeraCeros);
      datos.setOpcionNumeracion(opcionNumeracion);
      datos.setNumeraEmpieza(numeraEmpieza);
      datos.setNumeraSalto(numeraSalto);
      datos.setComArchivos(comArchivo);
      datos.setTxtCorte(txtCorte);
      datos.setSpSeccion(spSeccion);
      datos.setComFinal(comFinal);
      datos.setArchDesde(archDesde);
      datos.setArchHasta(archHasta);
      datos.setArchTextoDesde(archTextoDesde);
      datos.setArchTextoHasta(archTextoHasta);
      datos.setComCarpeta(comCarpeta);
      datos.setComSepFecha(comSepFecha);
      datos.setComFecha(comFecha);
      datos.setComFechaMeta(comFechaMeta);
      datos.setComCamara(comCamara);
      datos.setComMusica(comMusica);
      datos.setTexInserta(texInserta);
      datos.setSpInserta(spInserta);
      datos.setDerInserta(derInserta);
      datos.setDerTrimInserta(derTrimInserta);
      datos.setSpDesde(spDesde);
      datos.setSpHasta(spHasta);
      datos.setDerElimina(derElimina);
      datos.setReemUno(reemUno);
      datos.setReemDos(reemDos);
      datos.setModoReem(modoReem);
      datos.setAleaSel(aleaSel);
      datos.setSpAleatorio(spAleatorio);
      datos.setOpCapi(opCapi);
      datos.setOpNorma(opNorma);
      datos.setOpNumeros(opNume);
      datos.setOpAtri(opAtri);
      datos.setIAtrib(iAtrib);
      datos.setCAtrib(cAtrib);
      datos.setOpAtriEst(opAtriEst);
      datos.setCheckNum(checkNum);
      datos.setCheckNorma(checkNorma);
      datos.setCheckReem(checkReem);
      datos.setCheckAtri(checkAtri);
      datos.setCheckAlea(checkAlea);
      datos.setCheckMay(checkMay);
      datos.setTabPanel(tabPanel);
      datos.setTxtSym(txtSym);
      datos.setNormalizaTrim(normalizaTri);
      datos.setNormaPosicion(normaPos);
      datos.setNormaCeros(normaCer);
      datos.setNumerosEn(numerosE);
      datos.setNumerosSalto(numerosSal);
      datos.setNumerosPosicion(numerosPos);
      datos.setTxtFiltro(txtFiltro);
      datos.setCkExtension(ckExtension);
      datos.setTxtExt(txtExt);
      datos.setCase(Case);
      datos.setExcluye(Excluye);
      datos.setCkSepara(ckSepara);
      datos.setTxtSepara(txtSepara);
      datos.setOpSepara(opSepara);

      serializarDatos = new SerializarDatos();
      serializarDatos.xmlEnconder(rutaIn, datos);
      return true;
    } 
    catch (IOException e) {
      return false;
    }
  }
  public void nuevo() {
    Boolean autoDespuesReset = automaticPreview;
    automaticPreview = false;
//    resetValores();
    resetValoresNuevo();    
    
    if (modoDrop) {
	actualizaDespuesDrop();
    }
    else {
	actualizaDespuesAplicar(ruta);
    }
    seleccionadosNuevo();
    rutaGuarda = null;
    setTitle("vRenamer ");
    automaticPreview = autoDespuesReset;
  }
  public void refreshUndoRedo() {
     // refresh undo
     m25.setText( undoManager_.getUndoPresentationName() );
     m25.setEnabled( undoManager_.canUndo() );
     toolUndo.setEnabled( undoManager_.canUndo() );
     toolUndo.setName( undoManager_.getUndoPresentationName() );
     toolUndo.setToolTipText( undoManager_.getUndoPresentationName() );

     // refresh redo
     m26.setText( undoManager_.getRedoPresentationName() );
     m26.setEnabled( undoManager_.canRedo() );
     toolRedo.setEnabled( undoManager_.canRedo() );
     toolRedo.setName( undoManager_.getRedoPresentationName() );
     toolRedo.setToolTipText( undoManager_.getRedoPresentationName() );

  }
  public void desAdapta(UndoableEdit edit) {
      this.edit = edit;
      undoManager_.addEdit( edit );
      refreshUndoRedo();
  }
  public void deshacer(String fuente) {
      undoManager_.undo();
      refreshUndoRedo();
      switch (fuente) {
          case "mp3":
              actualizaMp3();
              break;
          case "atributos":
              actualizaDespuesAplicar(ruta);
              break;
      }
  }
  public void rehacer(String fuente) {
      undoManager_.redo();
      refreshUndoRedo();
      switch (fuente) {
          case "mp3":
              actualizaMp3();
              break;
          case "atributos":
              actualizaDespuesAplicar(ruta);
              break;
      }
  }
  public Boolean compruebaCorrelativos(int[] okSeleccion) {
      this.okSeleccion = okSeleccion;
      for (int x=0;x<okSeleccion.length;x++) {
	  if (x>0 && (okSeleccion[x] - okSeleccion[x-1] > 1)) {
	    return false;
	  }
	  if (okSeleccion[x] == index) { 
	    return true;
	  }
      }
      return true;
  }
  public void goUp() {
      int[] indicesSeleccionados = listArchivos.getSelectedRows();
      if ( ! compruebaCorrelativos(indicesSeleccionados) ) return;
      if (archivosOriginales[indicesSeleccionados[0]].isDirectory()) return;
      reordena(oArchivos.getUltimaCarpeta() + 1,indicesSeleccionados,true);
  }
  public void goDown() {
      int[] indicesSeleccionados = listArchivos.getSelectedRows();
      if ( ! compruebaCorrelativos(indicesSeleccionados) ) return;
      if (archivosOriginales[indicesSeleccionados[0]].isDirectory()) return;
      reordena(Archivos.length,indicesSeleccionados,true);
  }
  public void goUpOne() {
      int[] indicesSeleccionados = listArchivos.getSelectedRows();
      if ( ! compruebaCorrelativos(indicesSeleccionados) ) return;
      if (archivosOriginales[indicesSeleccionados[0]].isDirectory()) return;
      if ( (indicesSeleccionados[0] > oArchivos.getUltimaCarpeta() + 1 ) ) reordena (indicesSeleccionados[0] - 1,indicesSeleccionados,true);
  }
  public void goDownOne() {
      int[] indicesSeleccionados = listArchivos.getSelectedRows();
      if ( ! compruebaCorrelativos(indicesSeleccionados) ) return;
      if (archivosOriginales[indicesSeleccionados[0]].isDirectory()) return;
      if (indicesSeleccionados[indicesSeleccionados.length -1] < (Archivos.length - 1) ) reordena (indicesSeleccionados[0] + indicesSeleccionados.length +1,indicesSeleccionados,true);
  }
  public void reordena (int indiceFinal, int[] indicesOrigen, Boolean doSeleccion) {
      setCursor(new Cursor(Cursor.WAIT_CURSOR));
      okSeleccion = new int[indicesOrigen.length];
      if (Archivos[0].toString().equals("..") && (indicesOrigen[0] < 1 || indiceFinal < 1) ) {
	  setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	  return;
      }
      oArchivos.setOriginales(archivosOriginales);
      oArchivos.reordena(indiceFinal, indicesOrigen, ckCopiaCarpeta.isSelected());
      Archivos = oArchivos.getArchReordenados();
      Renombrados = oArchivos.getRenomReordenados();
      archivosOriginales = oArchivos.getAbstractFiltrado();
      archivosRenombrados = oArchivos.getRenombradosFinal();
      okSeleccion = oArchivos.getOkSeleccion();
      regeneraCheck();
      panelModelo();
      setPanelArchivos();
      listArchivos.setModel(listArchivosModel);
      if (!ckCopiaCarpeta.isSelected()) {
	  RenombradosCopia = Arrays.copyOf(Archivos,Renombrados.length);
	  reseteaRenombrados = false;
	  modeloRenombrados();
	  panelRenombrados();
      }
      if (doSeleccion) {
	  listArchivos.setRowSelectionInterval(okSeleccion[0], okSeleccion[okSeleccion.length -1]);
	  if (btnAplicar.isEnabled()) {
	      seleccionadosNuevo();
	  }
      }
      Rectangle rect = listArchivos.getCellRect(listArchivos.getSelectedRow(), 1, true);
      listArchivos.scrollRectToVisible(rect);
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }

  public void reordenaAuto(String opcionOrdena) {
      this.opcionOrdena=opcionOrdena;
//      if (listArchivos.getSelectedRow() == 0 && Archivos[listArchivos.getSelectedRow()].toString().equals("..")) listArchivos. removeRowSelectionInterval(0,0);
      muestraBarra(true,Idioma.getBarSort());
      jProgreso.setStringPainted(false);
      jProgreso.setIndeterminate(true);	
      new reordenaAutoWorker().execute();
  }
  public void importaLog() {
      int contaLog = 1;
      logFiles = new ArrayList<>();
      tablaLogModel = null;
      if ( new File (rutaHome + separador + vrenamerFolder + separador + "renamed.log").canRead() ) 
          logFiles.add(new File (rutaHome + separador + vrenamerFolder + separador + "renamed.log"));
      while (true) {
	if ( new File (rutaHome + separador + vrenamerFolder + separador + "renamed.log." + contaLog).canRead() ) 
            logFiles.add(new File (rutaHome + separador + vrenamerFolder + separador + "renamed.log." + contaLog));
	else break;
	contaLog++;
      }
      if (logFiles.size() < 1) 
          sinPermiso(Idioma.getLogFile());
      else {
	String[] logList = new String[logFiles.size()];
	for (int x=0;x<logList.length;x++) 
            logList[x] = logFiles.get(x).getName();
	JDialog dFicheroLog = new JDialog (this, Idioma.getChooseLogFile(), true);
	logSeleccionado = dialogoLog(logList, dFicheroLog);
	if (logSeleccionado < 1000) {
	    logFechas = new ArrayList<>();
	    BufferedReader reader = null;
	    FileInputStream fechasStream = null;
	    try {
	      fechasStream = new FileInputStream(logFiles.get(logSeleccionado).toString());
	      reader = new BufferedReader(new InputStreamReader(fechasStream, "UTF-8"));
	      Pattern patron = Pattern.compile("Start Rename Date:");
	      Pattern patronM = Pattern.compile("Start Move Date:");
	      String linea = reader.readLine();
	      while (linea != null) {
		  Matcher lineaOk = patron.matcher(linea);
		  Matcher lineaMOk = patronM.matcher(linea);
		  if (lineaOk.find()) {
		    logFechas.add(linea.substring(19) + " R");
		  }
		  else if (lineaMOk.find()) {
		    logFechas.add(linea.substring(17) + " M");
		  }
		  linea = reader.readLine();
	      }
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }
	    finally {
	      try {
		  reader.close();
		  fechasStream.close();
	      } catch (Exception e){
		throw new RuntimeException(e);
	      }
	    }
	    if (logFechas.size() < 1) 
                sinPermiso(Idioma.getLogFile());
	    else {
	      listFechas = new String[logFechas.size()];
	      for (int x=0;x<listFechas.length;x++) listFechas[x] = logFechas.get(x);
	      JDialog dFechasLog = new JDialog(this, Idioma.getChooseDateFile(), true);
	      int fechaSeleccionada = dialogoLog(listFechas, dFechasLog);
	      if (fechaSeleccionada < 1000) 
                  activaLog(fechaSeleccionada);
	    }
	 }
      }
  }
  public void importaEntradas(int fechaSeleccionada) {
      listaEntradas = new ArrayList<>();
      reader = null;
      FileInputStream entradasStream = null;
      try {
	entradasStream = new FileInputStream(logFiles.get(logSeleccionado).toString());
	reader = new BufferedReader(new InputStreamReader(entradasStream, "UTF-8"));
	Pattern patron = Pattern.compile(listFechas[fechaSeleccionada].substring(0 , listFechas[fechaSeleccionada].length() - 3));
	String linea = reader.readLine();
	while (linea != null) {
	    Matcher lineaOk = patron.matcher(linea);
	    if (lineaOk.find()) {
		linea = reader.readLine();
		while (linea != null) {
		    if (linea.contains("End Date")) break;
		    if (linea.split("-->").length == 2)
			listaEntradas.add(linea);
		    linea = reader.readLine();
		}
		break;
	    }
	    linea = reader.readLine();
	}
      }
      catch (Exception e) {
	  throw new RuntimeException(e);
      }
      finally {
	try {
	    reader.close();
	    entradasStream.close();
	}
	catch (Exception e){
	  throw new RuntimeException(e);
	}
      }
      archivosOriginales = new File[listaEntradas.size() + 1];
      archivosRenombrados = new File[listaEntradas.size() + 1];
      Archivos = new StringBuffer[listaEntradas.size() + 1];
      Renombrados = new StringBuffer[listaEntradas.size() + 1];
      archivosOriginales[0] = new File(ruta + separador + "..");
      Archivos[0] = new StringBuffer().append("..");
      archivosRenombrados[0] = new File(ruta + separador + "..");
      Renombrados[0] = new StringBuffer().append("..");
      for (int x=0;x<listaEntradas.size();x++) {
	  String[] entradaDividida = listaEntradas.get(x).split("-->");
	  archivosOriginales[x + 1] = new File(entradaDividida[1]);
	  archivosRenombrados[x + 1] = new File(entradaDividida[0]);
	  Archivos[x + 1] = new StringBuffer().append(archivosOriginales[x + 1].getName());
	  Renombrados[x + 1] = new StringBuffer().append(archivosRenombrados[x + 1].getName());  
	  if (Archivos[x + 1].toString().startsWith("vRTP")) {
	      Archivos[x + 1] = new StringBuffer().append(Archivos[x + 1].toString().substring(4));
	      archivosOriginales[x + 1] = new File(archivosOriginales[x + 1].getParent() + separador + archivosOriginales[x + 1].getName().substring(4));
	  }
      }
  }
  public void activaLog(int fechaSeleccionada) {
      listaEntradasInter = new ArrayList<>();
      int cuentaArchivos = 0;
      int cuentaCarpetas = 0;
      Iterator iteraLista = listaEntradas.iterator();
      while (iteraLista.hasNext()) {
	  String[] listaCheck = iteraLista.next().toString().split("-->");
	  if (new File(listaCheck[1]).getName().startsWith("vRTP")) {
	      listaCheck[1] = new File(listaCheck[1]).getParent() + separador + new File(listaCheck[1]).getName().substring(4);
	  }
	  if ( new File(listaCheck[1]).canRead() ) {
	      listaEntradasInter.add(listaCheck[0] + "-->" + listaCheck[1]);
	  }
      }
      archivosOriginales = new File[listaEntradasInter.size() + 1];
      archivosRenombrados = new File[listaEntradasInter.size() + 1];
      Archivos = new StringBuffer[listaEntradasInter.size() + 1];
      Renombrados = new StringBuffer[listaEntradasInter.size() + 1];
      archivosOriginales[0] = new File(ruta + separador + "..");
      Archivos[0] = new StringBuffer().append("..");
      archivosRenombrados[0] = new File(ruta + separador + "..");
      Renombrados[0] = new StringBuffer().append("..");
      for (int x=0;x<listaEntradasInter.size();x++) {
	  String[] entradaDividida = listaEntradasInter.get(x).split("-->");
	  archivosOriginales[x + 1] = new File(entradaDividida[1]);
	  archivosRenombrados[x + 1] = new File(entradaDividida[0]);
	  Archivos[x + 1] = new StringBuffer().append(archivosOriginales[x + 1].getName());
	  Renombrados[x + 1] = new StringBuffer().append(archivosRenombrados[x + 1].getName());  
	  if (Archivos[x + 1].toString().startsWith("vRTP")) {
	      Archivos[x + 1] = new StringBuffer().append(Archivos[x + 1].toString().substring(4));
	      archivosOriginales[x + 1] = new File(archivosOriginales[x + 1].getParent() + separador + archivosOriginales[x + 1].getName().substring(4));
	  }
	  if (archivosOriginales[x + 1].isDirectory()) {
	      cuentaCarpetas++;
	  } else {
	      cuentaArchivos++;
	  }
      }
      if ( ! listaEntradasInter.isEmpty() ) {
	  if (modoLog) {
	      ckCopiaCarpeta.setSelected(restauraCkCopia);
	      comboCarpeta.setSelectedIndex(restauraComboCarpeta);
	  }
	  modoLog = true;
	  seleccionCancelada = mBusca.checkRepetidos(Renombrados, archivosOriginales, getSistema());
	  indicesMarcar = mBusca.getIndicesMarcar();
	  indicesCambiados = mBusca.getIndicesCambiados();
	  oArchivos.setOriginales(archivosOriginales);
	  oArchivos.setRenombrados(archivosRenombrados);
	  eligeSeleccionCheck();
	  restauraCkCopia = ckCopiaCarpeta.isSelected();
	  restauraComboCarpeta = comboCarpeta.getSelectedIndex();
	  if (listFechas[fechaSeleccionada].endsWith("M")) {
	      tomaSeleccion();
	      ckCopiaCarpeta.setSelected(true);
	      comboCarpeta.setSelectedIndex(1);
	      okSeleccionRe = Arrays.copyOf(okSeleccion,okSeleccion.length);
	  } else {
	      ckCopiaCarpeta.setSelected(false);
	  }
	  panelModelo();
	  if (modoDrop && ficherosImportadosAdd.isEmpty()) {
	      pnlArchivos.removeAll();
	      panelArchivos();
	      pnlArchivos.updateUI();
	  } else {
	      setPanelArchivos();
	  }
	  modeloRenombrados();
	  panelRenombrados();
	  listArchivos.setModel(listArchivosModel);
	  btnPreview.setEnabled(false);
	  comboSelecAplica.setEnabled(false);
	  m15.setEnabled(false);
	  btnLimpiar.setEnabled(false);
	  if ( ! btnAplicar.isEnabled() ) {
	      btnAplicar.setEnabled(true);
              btnAplicar.setIcon(aplicarBigOk);
	      m16.setEnabled(true);
	      new Blink().execute();
	  }
	  contenidoCarpetaLog = (cuentaCarpetas == 0) ? true : false;
	  oArchivos.setCuentaArchivos(cuentaArchivos);
	  oArchivos.setCuentaCarpetas(cuentaCarpetas);
	  muestraInfo(false, false);
      } else {
	  if (modoDrop) {
	      actualizaDespuesDrop();
	  } else {
	      actualizaDespuesAplicar(ruta);
	  }
      }
  }
  public int dialogoLog(String[] logList, final JDialog dLog) {
      archivosOriginalesDrop = new File[archivosOriginales.length];
      System.arraycopy(archivosOriginales, 0, archivosOriginalesDrop, 0, archivosOriginales.length);
      devuelve = 1000;
      lblLog = new JLabel("LOGS: ");
      lblLog.setForeground(new Color(205,0,0));
      final JList listLog = new JList(logList) {
          @Override
	  protected void processMouseEvent(MouseEvent e) {
	      if (e.getID() == MouseEvent.MOUSE_PRESSED) {  
		  super.processMouseEvent(e);
		  if (dLog.getTitle().equals(Idioma.getChooseDateFile())) tablaLog(this.getSelectedIndex());
		  this.requestFocusInWindow();
	      }
	  }
          @Override
	  protected void processKeyEvent(KeyEvent k) {
	      super.processKeyEvent(k);
	      if (k.getID() == KeyEvent.KEY_PRESSED) {
		  if (dLog.getTitle().equals(Idioma.getChooseDateFile())) tablaLog(this.getSelectedIndex());
		  this.requestFocusInWindow();
		  if (k.getKeyCode() == 10) {
		      if ( ! this.isSelectionEmpty() ) devuelve = this.getSelectedIndex();
		      dLog.setVisible(false);
		  }
	      }
	  }
      };

      listLog.setFixedCellHeight(40);
      listLog.setCellRenderer(new SimpleCellRenderer());
      setFont(listLog, 11, Font.PLAIN);
      listLog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      listLog.setSelectedIndex(logList.length -1);
      scrListLog = new JScrollPane(listLog);
      scrListLog.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      if (dLog.getTitle().equals(Idioma.getChooseLogFile())) 
          scrListLog.setPreferredSize(new Dimension(320,150));
      else 
          scrListLog.setPreferredSize(new Dimension(520,350));

      pnlCentralLog = new JPanel();
      pnlCentralLog.setLayout(new BoxLayout(pnlCentralLog,BoxLayout.X_AXIS));
      pnlCentralLog.setAlignmentX(Component.LEFT_ALIGNMENT);
      pnlCentralLog.add(scrListLog);

      JButton btnLog = getButton(Idioma.getCopiaOk(),null,false);
      dLog.getRootPane().setDefaultButton(btnLog);
      setFont(btnLog, 10, Font.PLAIN);
      btnLog.addActionListener(new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e) {
	  if ( ! listLog.isSelectionEmpty() ) 
              devuelve = listLog.getSelectedIndex();
	  dLog.setVisible(false);
	  }
      });	
      btnLog.setPreferredSize(new Dimension(75,22));
      JButton btnLogCancel = getButton(Idioma.getOptionCancel(),null,false);
      setFont(btnLogCancel, 10, Font.PLAIN);
      btnLogCancel.addActionListener(new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e) {
	    devuelve = 1000;
	    if (dLog.getTitle().equals(Idioma.getChooseDateFile())) {
		if (modoDrop) {
		    restauraOriginalesDrop();
		} else {
		    actualizaDespuesAplicar(ruta);
		}
	    }
	    dLog.setVisible(false);
	  }
      });
      btnLogCancel.setPreferredSize(new Dimension(75,22));

      JLabel lRenombrados = new JLabel(Idioma.getInfoRenamed());
      setFont(lRenombrados, 12, Font.PLAIN);
      JLabel lMovidos = new JLabel(Idioma.getInfoMoved());
      setFont(lMovidos, 12, Font.PLAIN);
      JPanel pnlInfoOperacion = new JPanel();
      pnlInfoOperacion.setLayout(new BoxLayout(pnlInfoOperacion,BoxLayout.Y_AXIS));
      pnlInfoOperacion.setAlignmentX(Component.LEFT_ALIGNMENT);
      pnlInfoOperacion.add(lRenombrados);
      pnlInfoOperacion.add(lMovidos);

      pnlBotonLog = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      pnlBotonLog.add(btnLog);
      pnlBotonLog.add(btnLogCancel);

      pnlSurLog = new JPanel(new BorderLayout());
      pnlSurLog.add(pnlInfoOperacion,"West");
      pnlSurLog.add(pnlBotonLog,"East");

      pnlLog = new JPanel(new BorderLayout());
      pnlLog.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      Runnable doScrollR = new Runnable() {
        @Override
	public void run() {
	  scrListLog.getVerticalScrollBar().setValue(scrListLog.getVerticalScrollBar().getMaximum());
	}
      };
      SwingUtilities.invokeLater(doScrollR);
      pnlLog.add(lblLog,"North");
      pnlLog.add(pnlCentralLog,"Center");
      if (dLog.getTitle().equals(Idioma.getChooseLogFile()))
	  pnlLog.add(pnlBotonLog,"South");
      else 
          pnlLog.add(pnlSurLog,"South");

      dLog.add(pnlLog);
      if (dLog.getTitle().equals(Idioma.getChooseLogFile())) dLog.setSize(350,250);
      else dLog.setSize(650,450);
      if (dLog.getTitle().equals(Idioma.getChooseDateFile())) listLog.clearSelection();
      dLog.setLocationRelativeTo(this);
      dLog.setVisible(true);
      return devuelve;
  }
  public void tablaLog(int fechaSeleccionada) {
      importaEntradas(fechaSeleccionada);
      Object[][] datosTabla = new Object [archivosOriginales.length -1][2];
      for (int x=0;x<archivosOriginales.length - 1;x++) {
	  datosTabla[x][0] = Archivos[x+1];
	  datosTabla[x][1] = Renombrados[x+1];
      }
      String[] nombreColumnas = {Idioma.getTitleOriginals(),Idioma.getLogRecover()};
      if (tablaLogModel == null) {
	  tablaLogModel = new DefaultTableModel(datosTabla, nombreColumnas);
	  tablaLog = new JTable() {
	      @Override
	      public boolean isCellEditable(int row, int column) {
	      super.isCellEditable(row,column);
		  return false;
	      }
	  };
	  setFont(tablaLog, 11, Font.PLAIN);
	  tablaLog.setModel(tablaLogModel);
	  tablaLog.setShowGrid(false);
	  tablaLog.getColumnModel().getColumn(0).setCellRenderer(new MyCellTabla(archivosOriginales, true));
	  tablaLog.getColumnModel().getColumn(1).setCellRenderer(new MyCellTabla(archivosRenombrados, false));
	  tablaLog.setAutoCreateColumnsFromModel(false);
	  tablaLog.setPreferredScrollableViewportSize(new Dimension(600, 450));
	  JScrollPane tablaScroll = new JScrollPane(tablaLog);
	  pnlLog.removeAll();
	  JSplitPane pnlCentralLog = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,true,scrListLog,tablaScroll);
	  pnlCentralLog.setDividerLocation(255);
	  pnlCentralLog.setResizeWeight(0.10);
	  pnlCentralLog.setDividerSize(2);
	  pnlCentralLog.setEnabled(true);

	  pnlCentralLog.updateUI();      
	  pnlLog.add(lblLog,"North");
	  pnlLog.add(pnlCentralLog,"Center");
	  pnlLog.add(pnlSurLog,"South");
	  pnlLog.updateUI();
      } else {
	  tablaLogModel = new DefaultTableModel(datosTabla, nombreColumnas);
	  tablaLog.setModel(tablaLogModel);
	  tablaLog.getColumnModel().getColumn(0).setCellRenderer(new MyCellTabla(archivosOriginales, true));
	  tablaLog.getColumnModel().getColumn(1).setCellRenderer(new MyCellTabla(archivosRenombrados, false));
	  pnlCentralLog.updateUI();      	  
      }
  }
  public void dialogImportaTexto() {
      if (dImporta == null) {

	  dImporta = new JDialog(this, "vRenamer -- " + Idioma.getMenuImport(), true);

	  JLabel lblImporta = new JLabel(Idioma.getTextHelp(),infoOk,0);
	  setFont(lblImporta, 12, Font.PLAIN);

	  JPanel pnlLblImporta = new JPanel();
	  pnlLblImporta.setLayout(new BoxLayout(pnlLblImporta,BoxLayout.X_AXIS));
	  pnlLblImporta.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlLblImporta.add(lblImporta);
	  pnlLblImporta.setMaximumSize(new Dimension(10000,350));
	  pnlLblImporta.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.BLACK), new EmptyBorder(15,15,15,15)));
	  pnlLblImporta.setBackground(Color.WHITE);

	  final JTextArea txtCarga = new JTextArea();
	  setFont(txtCarga, 12, Font.PLAIN);
	  txtCarga.setDragEnabled(true);
	  txtCarga.setDropMode(DropMode.INSERT);
	  JScrollPane scrTxtCarga = new JScrollPane(txtCarga);

	  JButton btnLimpiaCarga = getButton("",cleanOk,false);
	  setFont(btnLimpiaCarga, 10, Font.PLAIN);
	  btnLimpiaCarga.setPreferredSize(new Dimension(38,15));
	  btnLimpiaCarga.setMaximumSize(new Dimension(38,15));

	  btnLimpiaCarga.addActionListener(new ActionListener() {
            @Override
	    public void actionPerformed(ActionEvent e)
	      {
		  txtCarga.setText("");
	      }
	  });

	  final JCheckBox ckConExtension = new JCheckBox(Idioma.getTextExtension());
	  setFont(ckConExtension, 11, Font.PLAIN);

	  JPanel pnlCargaExtension = new JPanel();
	  pnlCargaExtension.setLayout(new BoxLayout(pnlCargaExtension,BoxLayout.X_AXIS));
	  pnlCargaExtension.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlCargaExtension.add(ckConExtension);

	  JPanel pnlControlesCarga = new JPanel(new BorderLayout());
	  pnlControlesCarga.add(btnLimpiaCarga, "East");
	  pnlControlesCarga.add(pnlCargaExtension, "West");

	  JPanel pnlCarga = new JPanel();
	  pnlCarga.setLayout(new BoxLayout(pnlCarga,BoxLayout.Y_AXIS));
	  pnlCarga.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlCarga.add(scrTxtCarga);

	  JPanel pnlImportaCarga = new JPanel();
	  pnlImportaCarga.setLayout(new BoxLayout(pnlImportaCarga,BoxLayout.Y_AXIS));
	  pnlImportaCarga.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlImportaCarga.add(pnlLblImporta);
	  pnlImportaCarga.add(Box.createRigidArea(new Dimension(0,25)));
	  pnlImportaCarga.add(pnlCarga);

	  JPanel pnlImportaCentral = new JPanel(new BorderLayout());
	  pnlImportaCentral.add(pnlImportaCarga, "Center");
	  pnlImportaCentral.add(pnlControlesCarga, "South");
	  pnlImportaCentral.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getPanelText()),new EmptyBorder(25,40,20,40)));

	  JButton btnImporta = getButton(Idioma.getCopiaOk(),null,false);
	  setFont(btnImporta, 10, Font.PLAIN);
	  btnImporta.addActionListener(new ActionListener() {
            @Override
	    public void actionPerformed(ActionEvent e)
	      {
		  importaTexto(txtCarga.getText(), ckConExtension.isSelected());
		  dImporta.setVisible(false);
	      }
	  });
	  btnImporta.setPreferredSize(new Dimension(75,22));

	  dImporta.getRootPane().setDefaultButton(btnImporta);

	  JPanel pnlBotonIm = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	  pnlBotonIm.add(btnImporta);

	  JPanel pnlImporta = new JPanel(new BorderLayout());
	  pnlImporta.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	  pnlImporta.add(pnlImportaCentral,"Center");
	  pnlImporta.add(pnlBotonIm,"South");

	  dImporta.add(pnlImporta);
	  dImporta.setSize(500,550);
	  dImporta.setLocationRelativeTo(this);
// 	  dImporta.setResizable(false);
      }
      dImporta.setVisible(true);
  }

  private void importaTexto (String contenidoTxtCarga, Boolean conExtension) {
      if ( ! contenidoTxtCarga.equals("") ) {
	  if (ckCopiaCarpeta.isSelected()) {
	      ckCopiaCarpeta.setSelected(false);
	  }
	  int indiceNom = 0;
	  if (modoDrop) {
	      actualizaDespuesDrop();
	  } else {
	      limpia(true);
	  }
	  tomaSeleccion();
	  String[] arrayContenido = contenidoTxtCarga.split("\n");
	  int y = 0;
	  for (int x=0;x<okSeleccion.length;x++) {
	      if (y < arrayContenido.length && ! arrayContenido[y].equals("")) {
		  String renombradoTexto = arrayContenido[y].replaceAll("[ ]+$","");
		  if (conExtension && ! archivosOriginales[okSeleccion[x]].isDirectory()) {
		      String original = archivosOriginales[okSeleccion[x]].getName();
		      int puntoTexto = original.lastIndexOf('.');
		      if (puntoTexto < original.length() -1) {
			  renombradoTexto += original.substring(puntoTexto,original.length());
		      }
		  }
		  Renombrados[okSeleccion[x]] = new StringBuffer().append(renombradoTexto);
	      }
	      y++;
	  }
	  seleccionCancelada = mBusca.checkRepetidos(Renombrados, archivosOriginales, getSistema());
	  indicesMarcar = mBusca.getIndicesMarcar();
	  indicesCambiados = mBusca.getIndicesCambiados();
	  renderizaDos = new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0);
	  oArchivos.setRenombrados(Renombrados);
	  panelModelo();
	  setPanelArchivos();
	  listArchivos.setModel(listArchivosModel);
	  modeloRenombrados();
	  panelRenombrados();
	  pnlRenombrados.updateUI();      
	  if (!indicesCambiados.isEmpty()) {
	      btnPreview.setEnabled(false);
	      comboSelecAplica.setEnabled(false);
	      m15.setEnabled(false);
	      if ( ! btnAplicar.isEnabled() ) {
		  btnAplicar.setEnabled(true);
                  btnAplicar.setIcon(aplicarBigOk);
		  m16.setEnabled(true);
		  new Blink().execute();
	      }
	  }
          muestraInfo(false, false);
      } else {
	  if (modoDrop) {
	      actualizaDespuesDrop();
	  } else {
	      limpia(true);
	  }
      }
  }
  private void limpiaArchivosDrop(int[] indicesEliminar) {
      ficherosImportadosAdd = new ArrayList<>();
      ficherosImportados = new ArrayList<>();
      int inicio;
      if (indicesEliminar.length == 0) {
	  eligeSeleccion();
	  inicio = 0;
      } else {
	  okSeleccion = indicesEliminar;
	  inicio = 1;
      }
      int t = 0;
      for (int x=inicio;x<archivosOriginales.length;x++) {
	  if (t < okSeleccion.length && x == okSeleccion[t]) {
	      t++;
	      archivosCheck.remove(archivosOriginales[x]);
	  } else {
	      ficherosImportados.add(archivosOriginales[x]);
	  }
      }
      archivosOriginales = new File[0];
      if (!ficherosImportados.isEmpty()) {
	  dropExterno(0, false, true, true);
	  ficherosImportados = new ArrayList<>();

      } else {
	  pulsaDrop();
	  muestraInfo(false,false);
      }
    }
  private java.util.List<File> contenidoCarpeta() {
      java.util.List<File> ficherosImportadosContenido = new ArrayList<>();
      for (int x=0; x<ficherosImportados.size(); x++) {
	  if ( ! ficherosImportados.get(x).isDirectory() ) {
	      ficherosImportadosContenido.add(ficherosImportados.get(x));
	  } else if ( ! ficherosImportados.get(x).getName().equals("..") ) {
	      ListArchivos archivosContenido = new ListArchivos(ficherosImportados.get(x).toString());
	      if (archivosContenido.getFicheros("", false, false, false, false, false, Idioma) != null) {
		  File[] archivosContenidoList = archivosContenido.getAbstractFiltrado();
		  for (int y=0; y<archivosContenidoList.length; y++) {
		      if ( ! new File(archivosContenidoList[y].toString().replaceAll("\\.\\.$","")).isDirectory() ) {
			  ficherosImportadosContenido.add(archivosContenidoList[y]);
		      }
		  }
	      }
	  }
      }
      return ficherosImportadosContenido;
  }
  private void compruebaRepetidosDrop() {
      Boolean mostradoDropProhibido = false;
      if (ficherosImportadosAdd.isEmpty() && ! ficherosImportados.isEmpty()) {
	  if (ficherosImportados.get(1).isDirectory()) {
	      tipoImportados = "directorio";
	  }
	  else {
	      tipoImportados = "archivo";
	  }
      }
      for (int x=0;x<ficherosImportados.size();x++) {
	  if (ficherosImportados.get(x).getName().equals(".."))
	      continue;
	  if (ficherosImportados.get(x).isDirectory() && tipoImportados.equals("archivo")) {
	      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	      if ( ! mostradoDropProhibido ) {
		  dropProhibido(Idioma.getDropMixtos());
		  mostradoDropProhibido = true;
	      }
	      ficherosImportados.remove(x);
	      x--;
	      continue;
	  } else if (ficherosImportados.get(x).isFile() && tipoImportados.equals("directorio")) {
	      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	      if ( ! mostradoDropProhibido ) {
		  dropProhibido(Idioma.getDropMixtos());
		  mostradoDropProhibido = true;
	      }
	      ficherosImportados.remove(x);
	      x--;
	      continue;
	  }
	  if (ficherosImportadosAdd.contains(ficherosImportados.get(x))) {
	      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	      if ( ! mostradoDropProhibido ) {
		  dropProhibido(Idioma.getDropRepetidos());
		  mostradoDropProhibido = true;
	      }
	      ficherosImportados.remove(x);
	      x--;
	  }
      }
      if (mostradoDropProhibido) {
	  setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
  }
  private void dropExterno(int indexDrop, Boolean reordenaDrop, Boolean actualizaSeleccionados, Boolean limpiaManual) {
	setCursor(new Cursor(Cursor.WAIT_CURSOR));
	Boolean primerDrop = ficherosImportadosAdd.isEmpty();
	if ( ! primerDrop && indexDrop == 0) {
	    indexDrop = archivosOriginales.length;
	}
        if ( (iniciaCarpeta.equals("contenido") && contenidoCarpetaLog == null) || (contenidoCarpetaLog != null && contenidoCarpetaLog) ) {
	    ficherosImportados = contenidoCarpeta();
	    reordenaDrop = false;
	} else {
            ficherosImportados = new ArrayList(ficherosImportados);            
        }
	if ( primerDrop && ! ficherosImportados.isEmpty() && ! ficherosImportados.get(0).getName().equals("..") )
            ficherosImportados.add(0, new File(ruta + ".."));
	compruebaRepetidosDrop();
        arrayTablaMp3 = null;
	int ficherosImportadosCheck = ficherosImportados.size();
        if ( ! actualizaSeleccionados && ficherosImportados.size() == ficherosImportadosCheck) {
	    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	    return;
	}
	Boolean dropReordena = true;
	int [] indicesReordenar = new int[0];
	reseteaRenombrados = false;
	if (!modoDrop || ficherosImportadosAdd.isEmpty()) {
	    reseteaRenombrados = true;
	    archivosOriginales = new File[0];
	    dropReordena = false;
	} else {
	    ficherosImportadosAdd = new LinkedList<>(Arrays.asList(archivosOriginales));
	    indicesReordenar = new int[ficherosImportados.size()];
	    for (int x=0;x<ficherosImportados.size();x++)
		indicesReordenar[x] = archivosOriginales.length + x;
	}
	File[] originalesDrop = new File[ficherosImportados.size()];
	originalesDrop = ficherosImportados.toArray(originalesDrop);
	if (reordenaDrop || primerDrop || ficherosImportados.isEmpty())
	    Arrays.sort(originalesDrop, NameFileComparator.NAME_INSENSITIVE_COMPARATOR);
	for (int x=0;x<ficherosImportados.size();x++)
	    ficherosImportadosAdd.add(originalesDrop[x]);
	archivosOriginales = new File[ficherosImportadosAdd.size()];
	Archivos = new StringBuffer[ficherosImportadosAdd.size()];
	if ( ! ckCopiaCarpeta.isSelected() ) {
	    archivosRenombrados = new File[ficherosImportadosAdd.size()];
	    Renombrados = new StringBuffer[ficherosImportadosAdd.size()];
	    RenombradosCopia = new StringBuffer[ficherosImportadosAdd.size()];
	}
	for (int x=0;x<ficherosImportadosAdd.size();x++) {
	    archivosOriginales[x] = ficherosImportadosAdd.get(x);
	    Archivos[x] = new StringBuffer().append(archivosOriginales[x].getName());
	    if ( ! ckCopiaCarpeta.isSelected() ) {
		archivosRenombrados[x] = ficherosImportadosAdd.get(x);
		Renombrados[x] = new StringBuffer().append(archivosRenombrados[x].getName());  
		RenombradosCopia[x] = new StringBuffer().append(archivosRenombrados[x].getName());  
	    }
	}
	oArchivos.setOriginales(archivosOriginales);
	if ( ! ckCopiaCarpeta.isSelected() ) 
	    oArchivos.setRenombrados(archivosRenombrados);
	if (dropReordena && ficherosImportados.size() > 0 && archivosOriginales.length > 0)
	    reordena(indexDrop, indicesReordenar, false);
	m43.setSelected(true);
	activaExterno(actualizaSeleccionados, primerDrop, indexDrop, indicesReordenar, limpiaManual);
  }
  private void activaExterno(Boolean actualizaSeleccionados, Boolean primerDrop, int indexDrop, int[] indicesReordenar, Boolean limpiaManual) {
      opcionesFiltroDer.setEnabled(false);
      jFiltro.setText("");
      comboFiltro.setSelectedIndex(0);
      comboFiltro.setEnabled(false);
      jRuta.setEnabled(false);
      modoDrop = true;
      int cuentaOriginales = (archivosOriginales.length == 0) ? 0 : archivosOriginales.length -1;
      if (tipoImportados.equals("archivo")) {
	  oArchivos.setCuentaArchivos(cuentaOriginales);
	  oArchivos.setCuentaCarpetas(0);
      } else {
	  oArchivos.setCuentaCarpetas(cuentaOriginales);
	  oArchivos.setCuentaArchivos(0);
      }
      if ( primerDrop && ! limpiaManual && ! dropAplicado ) {
	  eligeSeleccionCheck();
      } else {
	  eligeSeleccionCheck(indexDrop, (indexDrop + indicesReordenar.length));
      }
      regeneraCheck();
      panelModelo();
      if (primerDrop && ! dropAplicado) {
	  pnlArchivos.removeAll();
	  panelArchivos();
	  pnlArchivos.updateUI();
      } else {
	  setPanelArchivos();
	  listArchivos.setModel(listArchivosModel);
      }
      if ( ! ckCopiaCarpeta.isSelected() ) {
	  modeloRenombrados();
	  panelRenombrados();
      } else {
	  tomaRenombrados();
	  modeloRenombrados();
	  renombrados();
      }
      actualizaNavegador();
      if ( archivosOriginales.length > 0 && ! dropAplicado && actualizaSeleccionados ) {
	  primero = false;
	  seleccionadosNuevo();
	  primero = true;
      } else if (dropAplicado) {
// 	  seleccionadosNuevo();
	  dropAplicado = false;
      }
      ficherosImportados = new ArrayList<>();
      reseteaRenombrados = false;
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
  private  void compruebaExisten() {
      java.util.List<File> originalesList = new LinkedList<>(Arrays.asList(archivosOriginales));
      ListIterator originalesListItera = originalesList.listIterator();
      while (originalesListItera.hasNext()) {
	  File original = (File) originalesListItera.next();
	  if ( ! original.canRead() ) {
	      archivosCheck.remove(original);
	      originalesListItera.remove();
	  }
      }
      if (originalesList.size() < archivosOriginales.length) {
	  archivosOriginales = new File[originalesList.size()];
	  archivosOriginales = originalesList.toArray(archivosOriginales);
	  oArchivos.setOriginales(archivosOriginales);
	  Archivos = new StringBuffer[archivosOriginales.length];
	  Archivos = oArchivos.getArchReordenados();
	  regeneraCheck();
	  panelModelo();
	  setPanelArchivos();
	  listArchivos.setModel(listArchivosModel);
	  oArchivos.setRenombrados(archivosOriginales);
	  Renombrados = new StringBuffer[archivosOriginales.length];
	  Renombrados = oArchivos.getRenomReordenados();
	  RenombradosCopia = Arrays.copyOf(Renombrados,Renombrados.length);
	  modeloRenombrados();
	  panelRenombrados();
	  if (ckCopiaCarpeta.isSelected()) {
	      seleccionCancelada = mBusca.checkRepetidos(Renombrados, archivosOriginales, getSistema());
	      indicesMarcar = mBusca.getIndicesMarcar();
	      indicesCambiados = mBusca.getIndicesCambiados();
	      renderizaDos = new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0);
	  }
      }
  }
  public void pulsaDrop() {
      indicesCambiados = new ArrayList<>();
      indicesMarcar = new ArrayList<>();
      if (m43.isSelected()) {          
	  archivosOriginales = new File[0];
	  Archivos = new StringBuffer[0];
	  if ( ! ckCopiaCarpeta.isSelected()) {
	      archivosRenombrados = new File[0];
	      Renombrados = new StringBuffer[0];	      
	  } else {
	      okSeleccionRe = new int[0];
	  }
	  activaExterno(false, false, 0, new int[0], false);
	  muestraInfo(false,false);
      } else {
	  opcionesFiltroDer.setEnabled(true);
	  comboFiltro.setEnabled(true);
	  jRuta.setEnabled(true);
	  modoDrop = false;
	  pnlArchivos.removeAll();
	  panelArchivos();
	  pnlArchivos.updateUI();
	  ficherosImportadosAdd = new ArrayList<>();
      }
      navega(ruta);
  }

  public String getPreview(){
      return Idioma.getMenuPreview();
  }
  public String getApply(){
      return Idioma.getMenuApply();
  }
  public String getSpanish(){
      return Idioma.getMenuSpanish();
  }  
  public String getEnglish(){
      return Idioma.getMenuEnglish();
  }  
  public String getHidden(){
      return Idioma.getMenuHidden();
  }
  public String getUndo(){
      String[] undoSplit = undoManager_.getUndoPresentationName().split(" ");
      return undoSplit[0];
  }
  public String getRedo(){
      String[] redoSplit = undoManager_.getRedoPresentationName().split(" ");
      return redoSplit[0];  
  }
  public String getSelectAll(){
      return Idioma.getMenuSelectAll();
  }
  public String getInvSel(){
      return Idioma.getMenuInvSel();
  }
  public String getFolderSel(){
      return Idioma.getMenuSelFolder();
  }
  public String getFileSel(){
      return Idioma.getMenuSelFile();
  }
  public String getAbout(){
      return Idioma.getMenuAbout();
  }
  public String getExit(){
      return Idioma.getMenuExit();
  }
  public String getCopy(){
      return Idioma.getCopyFolder();
  }
  public String getComboText(){
      return Idioma.getComboText();
  }
  public String getComboNumber(){
      return Idioma.getComboNumber();
  }
  public String getSecuenciaArabic(){
      return Idioma.getSeqArab();
  }
  public String getSecuenciaRoman(){
      return Idioma.getSeqRoman();
  }
  public String getSecuenciaLetters(){
      return Idioma.getSeqLetters();
  }
  public String getSecuenciaBinary(){
      return Idioma.getSeqBinary();
  }
  public String getSecuenciaHex(){
      return Idioma.getSeqHex();
  }
  public String getSecuenciaOc(){
      return Idioma.getSeqOc();
  }
  public String getComboFile(){
      return Idioma.getComboFile();
  }
  public String getComboFolder(){
      return Idioma.getComboFolder();
  }
  public String getComboDate(){
      return Idioma.getComboDate();
  }
  public String getComboDatePicture(){
      return Idioma.getComboDatePicture();
  }
  public String getComboCamera(){
      return Idioma.getComboCamera();
  }
  public String getComboMusic(){
      return Idioma.getComboMusic();
  }
  public String getTagTrack(){
      return Idioma.getTagTrack();
  }
  public String getTagTitle(){
      return Idioma.getTagTitle();
  }
  public String getTagArtist(){
      return Idioma.getTagArtist();
  }
  public String getTagAlbum(){
      return Idioma.getTagAlbum();
  }
  public String getTagYear(){
      return Idioma.getTagYear();
  }
  public String getTagGenre(){
      return Idioma.getTagGenre();
  }
  public String getFileCut(){
      return Idioma.getFileCut();
  }
  public String getFileFrom(){
      return Idioma.getFileFrom();
  }
  public String getFileBetween(){
      return Idioma.getFileBetween();
  }
  private void cambiaAEsp(){
    if (Idioma instanceof idiomasEsp) return;
    JOptionPane optionPane = new JOptionPane();
    optionPane.setMessage("El idioma cambiará a español reiniciando el programa");
    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
    JButton botonRestart = getButtonOption(optionPane, "Reiniciar ahora", actualizaOk);
    botonRestart.setName("reboot");
    JButton botonOk = getButtonOption(optionPane, Idioma.getCopiaOk(), aplicarOk);
    botonRestart.setName("okay");
    optionPane.setOptions(new Object[] { botonRestart, botonOk });
//    optionPane.setInitialValue(botonOk);
    JDialog dialog = optionPane.createDialog(pnlPrincipal, "Cambio idioma");
    dialog.setVisible(true);
    prefs.put(prefIdioma, "Esp");
    if (optionPane.getValue().equals("Reiniciar ahora")) { 
	if ( ! guardaLast() ) 
	    System.err.println("Cannot save last session");
	else 
	    prefs.put(prefReboot, "last");
	if (System.getProperty("os.name").contains("Windows")) {
	    try {
		Runtime.getRuntime().exec(directorio + separador + "vRenamer_" + Version + ".exe");
	    } catch (Exception e) {
	    }
	} else if (System.getProperty("os.name").contains("Linux")) {
	    try {
		Runtime.getRuntime().exec("vRenamer");
	    } catch (Exception e) {
	    }
	} else if (getSistema().equals("mac")) {
	    try {
		String macCasa = rutaMac.substring(rutaMac.lastIndexOf(":") + 1, rutaMac.indexOf("app") + 3 );
		String[] cadenaAbre = new String[]{"open","-Wn",macCasa};
		Runtime.getRuntime().exec(cadenaAbre);
	    } catch (Exception e) {
	    }
	}
	salir();
    }
  }
  private void cambiaAEng(){
    if (Idioma instanceof idiomasEng) return;
    JOptionPane optionPane = new JOptionPane();
    optionPane.setMessage("The language will switch to English restarting the app");
    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
    JButton botonRestart = getButtonOption(optionPane, "Restart now", actualizaOk);
    botonRestart.setName("reboot");
    JButton botonOk = getButtonOption(optionPane, Idioma.getCopiaOk(), aplicarOk);
    botonRestart.setName("okay");
    optionPane.setOptions(new Object[] { botonRestart, botonOk });
//    optionPane.setInitialValue(botonOk);
    JDialog dialog = optionPane.createDialog(pnlPrincipal, "Change Language");
    dialog.setVisible(true);
    prefs.put(prefIdioma, "Eng");
    if (optionPane.getValue().equals("Restart now")) { 
	if ( ! guardaLast() ) System.err.println("Cannot save last session");
	else prefs.put(prefReboot, "last");
	if (System.getProperty("os.name").contains("Windows")) {
	    try {
		Runtime.getRuntime().exec(directorio + separador + "vRenamer_" + Version + ".exe");
	    } catch (IOException e) {
	    }
	} else if (System.getProperty("os.name").contains("Linux")) {
	    try {
		Runtime.getRuntime().exec("vRenamer");
	    } catch (IOException e) {
	    }
	} else if (getSistema().equals("mac")) {
	    try {
		String macCasa = rutaMac.substring(rutaMac.lastIndexOf(":") + 1, rutaMac.indexOf("app") + 3 );
		Runtime.getRuntime().exec("open -Wn " + macCasa);
	    } catch (IOException e) {
	    }
	}
	salir();
    }
  }
  
  private void resetValoresNuevo() {
      reseteaRenombrados = !modoDrop;
      opcionSelec = 1;
      pnlEliminar.setEnabled(false);
      pnlInsertar.setEnabled(false);
      pnlReemplaza.setEnabled(false);
      pnlNormaliza.setEnabled(false);
      pnlNumeros.setEnabled(false);
      pnlAtributos.setEnabled(false);
      pnlCapitaliza.setEnabled(false);
      pnlAleatorio.setEnabled(false);
      pnlOpcionDos.setEnabled(true);

      pnlBuscaTotal.removeAll();
      pnlBuscaTotal.add(creaBarraRenombra());
      pnlBuscaTotal.updateUI();
      
      activaAnterior = "Combinadas";

      txtInsertar.setText("");
      spnInsertar.getModel().setValue(1);
      desdeDerechaInserta.setSelected(false);
      
      spnDesde.getModel().setValue(1);
      spnHasta.getModel().setValue(5);
      desdeDerecha.setSelected(false);

      txtReemplazaUno.setText("");
      txtReemplazaDos.setText("");
      cMode.setSelectedIndex(0);

      opAleatorioLong.setSelected(true);
      AleatorioLong.getModel().setValue(1);
      jCapitaliza.setSelectedIndex(0);
      capitalizaBusca();
      txtSymbols.setText("_-[(");
      jNormaliza.setSelectedIndex(0);
      normalizaTrim.getModel().setValue(1);
      normaPosicion.getModel().setValue(1);
      normaCeros.getModel().setValue(1);
      numerosEn.getModel().setValue(1);
      numerosSalto.getModel().setValue(1);
      numerosPosicion.getModel().setValue(1);
      desdeDerechaTrim.setSelected(false);
      normalizaBusca();

      jAtributos.setSelectedIndex(0);
      actualizaAtributo();
      jAtributosEstado.setSelectedIndex(0);
      for (int x=0;x<iAtributos.length;x++) {
	  iAtributos[x] = 0;
      }
      cAtributos.setSelectedIndex(0);
      fechaAtributos = null;
      dAtribFecha = null;
      opNumeros.setSelected(false);
      opNormaliza.setSelected(false);
      opReemplaza.setSelected(false);
      opAtributos.setSelected(false);
      jAtributosEstado.setEnabled(false);
      cAtributos.setEnabled(false);
      opAleatorio.setSelected(false);
      opCapitaliza.setSelected(false);

      pestPanel.setSelectedIndex(0);

      activa("combinadas");

      jFiltro.setText("");
      filtrado = "";
      ckCase.setSelected(false);
      ckExcluye.setSelected(false);
      ckOpcionDos.setSelected(false);
      txtExtension.setText("");
      txtExtension.setEnabled(false);
      ckOpcionTres.setSelected(true);
      jSepara.setSelectedIndex(0);
      JTextField tSepara = (JTextField)jSepara.getEditor().getEditorComponent();
      tSepara.setText("_");
  }  
  
  public void dialogFoto() {
      if ( doCargaImagenMarco == null || doCargaImagenMarco.isDone() ) {
	  DialogFotoPrevio = new JDialog(this, "vRenamer", false);
	  DialogFotoPrevio.setUndecorated(true);
	  DialogFotoPrevio.addMouseListener(new MouseAdapter() {
              @Override
	      public void mouseClicked(MouseEvent e) {
		  JDialog dPicture = (JDialog) e.getSource();
		  dPicture.dispose();
		  DialogFotoPrevio = null;
	      }
	  });
	  JPanel jMuestraFotoPrevio = new JPanel(new BorderLayout());
	  jMuestraFotoPrevio.add(new JLabel(refreshingOk),"Center");
	  jMuestraFotoPrevio.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(fotoArchivoActual.getName()),new EmptyBorder(10,10,10,10)));
	  DialogFotoPrevio.add(jMuestraFotoPrevio);    
	  DialogFotoPrevio.setSize(600,400);
	  DialogFotoPrevio.setLocationRelativeTo(this);
	  DialogFotoPrevio.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	  DialogFotoPrevio.setVisible(true);
	  doCargaImagenMarco = new cargaImagenMarco();
	  doCargaImagenMarco.execute();
      }
  }

  public void cierraDialogFoto() {
      DialogFoto.dispose();
  }

  private void dialogoConfigMp3 (final JTextField txtMp3, final JPanel pnlMp3Config) {
      if (DialogConfigMp3 == null) {
	  KeyListener ky = new KeyListener() {
              @Override
	      public void keyTyped(KeyEvent k) {
	      }
              @Override
              public void keyPressed(KeyEvent k) {
	      }
              @Override
              public void keyReleased(KeyEvent k) {
		  recogeConfigMp3();
	      }

	  };
	  ChangeListener ch = new ChangeListener() {
              @Override
              public void stateChanged(ChangeEvent c) {
		  recogeConfigMp3();
	      }
	  };
	  PopupMenuListener pu = new PopupMenuListener() {
              @Override
              public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	      }
              @Override
              public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		  recogeConfigMp3();
	      }
              @Override
              public void popupMenuCanceled(PopupMenuEvent e) {
	      }
	  };
	  CellEditorListener ce = new CellEditorListener() {
              @Override
              public void editingCanceled(ChangeEvent e) {
	      }
              @Override
              public void editingStopped(ChangeEvent e) {
		  TableCellEditor cellSource = (TableCellEditor) e.getSource();
		  for (int x=0;x<arrayTablaRecoge.length;x++) {
		      arrayTablaRecoge[x] = "" + tablaMp3Model.getValueAt(x, 1);
		  }
	      }
	  };

	  DialogConfigMp3 = new JDialog(this, true);
	  String[] opcionesConfigMp3 = {Idioma.getFileCut(), Idioma.getFileBetween()};
	  String[] hFinalMp3 = {Idioma.getFileOnly(), Idioma.getFileEnd(), Idioma.getFileBeginning()};
	  comboMp3 = new JComboBox(opcionesConfigMp3);
	  setFont(comboMp3, 11, Font.PLAIN);
	  comboMp3.setPreferredSize(new Dimension(115,23));
	  comboMp3.setMaximumSize(new Dimension(115,23));
	  comboMp3.setRenderer(new RenderCombos());
	  comboMp3.addPopupMenuListener(pu);
	  corteMp3 = new JTextField();
	  setFont(corteMp3, 11, Font.PLAIN);
	  corteMp3.setPreferredSize(new Dimension(62,23));
	  corteMp3.setMaximumSize(new Dimension(2000,23));
	  corteMp3.setToolTipText(Idioma.getTipCut());
    	  corteMp3.addKeyListener(ky);
	  corteMp3.addMouseListener(cc);

	  SpinnerNumberModel spCorteMp3 = new SpinnerNumberModel(1,1,50,1);
	  numeracionCorteMp3 = new JSpinner(spCorteMp3);
	  numeracionCorteMp3.setToolTipText(Idioma.getTipSection());
	  numeracionCorteMp3.setPreferredSize(new Dimension(43,23));
	  numeracionCorteMp3.setMaximumSize(new Dimension(43,23));
	  setFont(numeracionCorteMp3, 8, Font.PLAIN);
	  numeracionCorteMp3.addChangeListener(ch);
    	  ((JSpinner.DefaultEditor)numeracionCorteMp3.getEditor()).getTextField().addKeyListener(ky);
	  numeracionCorteMp3.addMouseListener(cc);

	  lblSeccionMp3 = new JLabel(Idioma.getFileSection());
	  setFont(lblSeccionMp3, 9, Font.PLAIN);

	  hastaFinalMp3 = new JWidePopupComboBox(hFinalMp3);
	  hastaFinalMp3.setPreferredWidth(40);
	  setFont(hastaFinalMp3, 11, Font.PLAIN);
	  hastaFinalMp3.setPreferredSize(new Dimension(20,16));
	  hastaFinalMp3.setMaximumSize(new Dimension(20,16));
	  hastaFinalMp3.setRenderer(new RenderCombos());
	  hastaFinalMp3.addPopupMenuListener(pu);

	  archivoTextoDesdeMp3 = new JTextField();
	  archivoTextoDesdeMp3.setToolTipText(Idioma.getTipReplace());
	  archivoTextoDesdeMp3.setPreferredSize(new Dimension(55,23));
	  archivoTextoDesdeMp3.setMaximumSize(new Dimension(2000,23));
	  setFont(archivoTextoDesdeMp3, 11, Font.PLAIN);
    	  archivoTextoDesdeMp3.addKeyListener(ky);
	  archivoTextoDesdeMp3.addMouseListener(cc);

	  lblArchivoTextoHastaMp3 = new JLabel(Idioma.getFileAnd());
	  lblArchivoTextoHastaMp3.setFont(new Font("Helvetica", Font.PLAIN, 11));

	  archivoTextoHastaMp3 = new JTextField();
	  archivoTextoHastaMp3.setToolTipText(Idioma.getTipReplace());
	  archivoTextoHastaMp3.setPreferredSize(new Dimension(55,23));
	  archivoTextoHastaMp3.setMaximumSize(new Dimension(2000,23));
	  setFont(archivoTextoHastaMp3, 11, Font.PLAIN);
    	  archivoTextoHastaMp3.addKeyListener(ky);
	  archivoTextoHastaMp3.addMouseListener(cc);

	  pnlSerieConfig = new JPanel() {
	      @Override
	      public void setEnabled(boolean enabled) {
		  super.setEnabled(enabled);
		  Component[] components = getComponents();
		  if (components != null && components.length > 0) {
		      int count = components.length;
		      for (int i = 0; i < count; i++) {
			  components[i].setEnabled(enabled);
		      }
		  }          
	      }
	  };
	  pnlSerieConfig.setLayout(new BoxLayout(pnlSerieConfig,BoxLayout.X_AXIS));
	  pnlSerieConfig.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlSerieConfig.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
	  comboMp3.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
		  configMp3Paneles();
	      }
	  });

	  ckEnable = new JCheckBox ();
	  ckEnable.setFont(new Font("Helvetica", Font.PLAIN, 11));
	  ckEnable.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed (ActionEvent e) {
		  conmutaCkEnable();
	      }
	  });
	  comboEnable = new JComboBox (new String[]{Idioma.getFromFile(), Idioma.getFromFolder(), Idioma.getFromTag(), Idioma.getFromLast()});
	  comboEnable.setRenderer(new RenderCombos());
	  comboEnable.setName("comboEnable");

	  JButton btnActualizaTabla = getButton("",actualizaOk,false);
	  btnActualizaTabla.setPreferredSize(new Dimension(40,23));
	  btnActualizaTabla.setMaximumSize(new Dimension(40,23));
	  btnActualizaTabla.setAlignmentX(Component.CENTER_ALIGNMENT);
	  btnActualizaTabla.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed (ActionEvent e) {
		  leeDatos = true;
		  leeTablaMp3(txtTextoGlobal);
	      }
	  });
	  
	  configMp3Paneles();

	  pnlCkEnable = new JPanel() {
	      @Override
	      public void setEnabled(boolean enabled) {
		  super.setEnabled(enabled);
		  Component[] components = getComponents();
		  if (components != null && components.length > 0) {
		      int count = components.length;
		      for (int i = 1; i < count; i++) {
			  components[i].setEnabled(enabled);
		      }
		  }          
	      }
	  };
	  pnlCkEnable.setLayout(new BoxLayout(pnlCkEnable,BoxLayout.X_AXIS));
	  pnlCkEnable.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlCkEnable.add(ckEnable);
	  pnlCkEnable.add(Box.createRigidArea(new Dimension(5,0)));
	  pnlCkEnable.add(comboEnable);
	  pnlCkEnable.add(Box.createRigidArea(new Dimension(5,0)));
	  pnlCkEnable.add(btnActualizaTabla);

	  comboEnable.addPopupMenuListener(new PopupMenuListener() {
              @Override
              public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	      }
              @Override
              public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		  leeDatos = true;
		  leeTablaMp3(txtTextoGlobal);
	      }
              @Override
              public void popupMenuCanceled(PopupMenuEvent e) {
	      }
	  });

	  comboCase = new JComboBox(new String[]{Idioma.getMp3Keep(), Idioma.getMp3Upper(), Idioma.getMp3Lower(), Idioma.getMp3First(), Idioma.getMp3Title()});
	  setFont(comboCase, 11, Font.PLAIN);
	  comboCase.setPreferredSize(new Dimension(115,23));
	  comboCase.setMaximumSize(new Dimension(115,23));
	  comboCase.setRenderer(new RenderCombos());
	  comboCase.addPopupMenuListener(pu);

	  pnlComboCase = new JPanel() {
	      @Override
	      public void setEnabled(boolean enabled) {
		  super.setEnabled(enabled);
		  Component[] components = getComponents();
		  if (components != null && components.length > 0) {
		      int count = components.length;
		      for (int i = 0; i < count; i++) {
			  components[i].setEnabled(enabled);
		      }
		  }          
	      }
	  };
	  pnlComboCase.setLayout(new BoxLayout(pnlComboCase,BoxLayout.X_AXIS));
	  pnlComboCase.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlComboCase.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
	  pnlComboCase.add(comboCase);

	  JPanel pnlConfigCentral = new JPanel();
	  pnlConfigCentral.setLayout(new BoxLayout(pnlConfigCentral,BoxLayout.Y_AXIS));
	  pnlConfigCentral.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlConfigCentral.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getMp3Modify()),new EmptyBorder(20,5,5,5)));
	  pnlConfigCentral.add(pnlSerieConfig);
	  pnlConfigCentral.add(Box.createRigidArea(new Dimension(0,5)));
	  pnlConfigCentral.add(pnlComboCase);
	  pnlConfigCentral.setPreferredSize(new Dimension(550, 100));
	  pnlConfigCentral.setMaximumSize(new Dimension(2550, 100));

	  tablaMp3Originales = new String[0][2];
	  nombreColumnasMp3[0] = Idioma.getTitleOriginals();
	  nombreColumnasMp3[1] = Idioma.getTagFor() + " " + txtMp3.getName();
	  tablaMp3Model = new DefaultTableModel (tablaMp3Originales, nombreColumnasMp3);
	  tablaMp3 = new JTable() {
	      @Override
	      public boolean isCellEditable(int row, int column) {
		  super.isCellEditable(row,column);
		  if (column == 0) {
		      return false;
		  } else {
		      return true;
		  }
	      }
	  };
	  setFont(tablaMp3, 11, Font.PLAIN);
	  tablaMp3.setColumnSelectionAllowed(true); 
	  tablaMp3.setModel(tablaMp3Model);
	  tablaMp3.setShowGrid(false);
          tablaMp3.getColumnModel().getColumn(0).setCellRenderer(new MyCellTablaMp3NoEdit());
          tablaMp3.getColumnModel().getColumn(1).setCellRenderer(new MyCellTablaMp3(txtMp3, Idioma));
	  tablaMp3.getDefaultEditor(String.class).addCellEditorListener(ce);
	  tablaMp3.setAutoCreateColumnsFromModel(false);

	  tablaScrollMp3 = new JScrollPane(tablaMp3);

	  pnlTablaMp3 = new JPanel();
	  pnlTablaMp3.setLayout(new BoxLayout(pnlTablaMp3,BoxLayout.Y_AXIS));
	  pnlTablaMp3.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlTablaMp3.add(tablaScrollMp3);

	  pnlDialogConfigMp3 = new JPanel();
	  pnlDialogConfigMp3.setLayout(new BoxLayout(pnlDialogConfigMp3,BoxLayout.Y_AXIS));
	  pnlDialogConfigMp3.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlDialogConfigMp3.setBorder(BorderFactory.createEmptyBorder(25,25,5,25));
	  pnlDialogConfigMp3.add(Box.createRigidArea(new Dimension(0,10)));
	  pnlDialogConfigMp3.add(pnlCkEnable);
	  pnlDialogConfigMp3.add(Box.createRigidArea(new Dimension(0,40)));
	  pnlDialogConfigMp3.add(pnlConfigCentral);
	  pnlDialogConfigMp3.add(Box.createRigidArea(new Dimension(0,20)));
	  pnlDialogConfigMp3.add(pnlTablaMp3);

	  btnLast = new JButton (lastOk)  {
	      @Override
	      protected void processMouseEvent(MouseEvent e) {
		  super.processMouseEvent(e);
		  if (e.getID() == MouseEvent.MOUSE_ENTERED) {
		      setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		  }
		  if (e.getID() == MouseEvent.MOUSE_EXITED) {
		      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		  }
		}
	  };
	  btnLast.setOpaque(false);
	  btnLast.setBorder(null);
	  btnLast.setContentAreaFilled(false);
	  btnLast.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e)
	      {
		try {
		    Desktop.getDesktop().browse(new URI ("http://www.last.fm") );
		}
		catch (URISyntaxException | IOException z) {
		    JOptionPane.showMessageDialog(pnlPrincipal, Idioma.getErrorLabel()+" http://www.last.fm", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	      }
	  });

	  pnlDialgMp3Sur = new JPanel(new BorderLayout());
	  pnlDialgMp3Sur.setBorder(BorderFactory.createEmptyBorder(0,25,0,25));
	  pnlDialgMp3Sur.setPreferredSize( new Dimension(450, 50) );
	  pnlDialgMp3Sur.setMaximumSize( new Dimension(450, 50) );

	  pnlPrincipalConfig = new JPanel(new BorderLayout());
	  pnlPrincipalConfig.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
	  pnlPrincipalConfig.add(pnlDialogConfigMp3, "Center");
	  pnlPrincipalConfig.add(pnlDialgMp3Sur, "South");

	  DialogConfigMp3.add(pnlPrincipalConfig);
	  DialogConfigMp3.setSize(550,600);
	  DialogConfigMp3.setMinimumSize(new Dimension(450,600));
	  DialogConfigMp3.setLocationRelativeTo(this);
      } 

      DialogConfigMp3.setTitle(txtMp3.getName() + " -- Batch");
      if (wa != null) {
	  DialogConfigMp3.removeWindowListener(wa);
      }
      wa = new WindowAdapter() {
	  @Override
	  public void windowDeactivated(WindowEvent w) {
	      if ( ! DialogConfigMp3.isVisible() ) {
		  cancelarMp3 = true;
		  try {
		      populateWorker.get();
		      escribeTxtMp3(txtMp3);
		      escribeTablaMp3(txtMp3);
		  } catch(InterruptedException | ExecutionException e) {
		  }
		  if (ckEnable.isSelected()) {
                      if (txtMp3.getName().equals(Idioma.getTagTrack()))
                          txtPista.setNumero(false);
                      else if (txtMp3.getName().equals(Idioma.getTagYear()))
                          txtAnyo.setNumero(false);
                      txtMp3.setText("Batch");
		      pnlMp3Config.setEnabled(false);

		  } else {
                      if (txtMp3.getName().equals(Idioma.getTagTrack()))
                          txtPista.setNumero(true);
                      else if (txtMp3.getName().equals(Idioma.getTagYear()))
                          txtAnyo.setNumero(true);
                      txtMp3.setText("");
		      pnlMp3Config.setEnabled(true);
		  }
              }
	  }
      };
      DialogConfigMp3.addWindowListener(wa);
      if (doNavega == null || doNavega.isDone()) {
	  cancelarMp3 = false;
	  leeTxtMp3(txtMp3);
	  DialogConfigMp3.setVisible(true);
      }
  }
  private void configMp3Paneles() {
      pnlSerieConfig.removeAll();
      pnlSerieConfig.add(comboMp3);
      pnlSerieConfig.add(Box.createRigidArea(new Dimension(5,0)));
      switch (comboMp3.getSelectedIndex()) {
	  case 0:
	      pnlSerieConfig.add(corteMp3);
	      pnlSerieConfig.add(Box.createRigidArea(new Dimension(5,0)));
	      pnlSerieConfig.add(lblSeccionMp3);
	      pnlSerieConfig.add(Box.createRigidArea(new Dimension(5,0)));
	      pnlSerieConfig.add(numeracionCorteMp3);
	      pnlSerieConfig.add(Box.createRigidArea(new Dimension(5,0)));
	      pnlSerieConfig.add(hastaFinalMp3);
	  break;
	  case 1:
	      pnlSerieConfig.add(archivoTextoDesdeMp3);
	      pnlSerieConfig.add(Box.createRigidArea(new Dimension(5,0)));
	      pnlSerieConfig.add(lblArchivoTextoHastaMp3);
	      pnlSerieConfig.add(Box.createRigidArea(new Dimension(5,0)));
	      pnlSerieConfig.add(archivoTextoHastaMp3);
	      pnlSerieConfig.add(Box.createRigidArea(new Dimension(5,0)));
	  break;
      } 
      pnlSerieConfig.updateUI();
  }
  private void escribeTxtMp3(JTextField txtTexto) {
      int indiceConfigMp3 = 0;
      if (txtTexto.getName().equals(Idioma.getTagTrack())) {
	  indiceConfigMp3 = 0;
      } else if (txtTexto.getName().equals(Idioma.getTagTitle())) {
	  indiceConfigMp3 = 1;
      } else if (txtTexto.getName().equals(Idioma.getTagArtist())) {
	  indiceConfigMp3 = 2;
      } else if (txtTexto.getName().equals(Idioma.getTagAlbum())) {
	  indiceConfigMp3 = 3;
      } else if (txtTexto.getName().equals(Idioma.getTagYear())) {
	  indiceConfigMp3 = 4;
      } else if (txtTexto.getName().equals(Idioma.getTagGenre())) {
	  indiceConfigMp3 = 5;
      }
      switch (comboMp3.getSelectedIndex()) {
	  case 0:
	      intComboMp3[indiceConfigMp3] = 0;
	      stringCorte[indiceConfigMp3] = corteMp3.getText();
	      stringnumeracion[indiceConfigMp3] = numeracionCorteMp3.getModel().getValue().toString();
	      intFinalMp3[indiceConfigMp3] = hastaFinalMp3.getSelectedIndex();
	  break;
	  case 1:
	      intComboMp3[indiceConfigMp3] = 1;
	      stringDesde[indiceConfigMp3] = archivoTextoDesdeMp3.getText();
	      stringHasta[indiceConfigMp3] = archivoTextoHastaMp3.getText();
	  break;
      }
      booleanCkEnable[indiceConfigMp3] = ckEnable.isSelected();
      intComboEnable[indiceConfigMp3] = comboEnable.getSelectedIndex();
      intComboCase[indiceConfigMp3] = comboCase.getSelectedIndex();
  }
  private void leeTxtMp3(JTextField txtTexto) {
      comboMp3.setSelectedIndex(0);
      corteMp3.setText("");
      numeracionCorteMp3.getModel().setValue(1);
      hastaFinalMp3.setSelectedIndex(0);
      archivoTextoDesdeMp3.setText("");
      archivoTextoHastaMp3.setText("");
      ckEnable.setSelected(false);
      comboEnable.setSelectedIndex(0);
      comboCase.setSelectedIndex(0);
      int indiceConfigMp3 = 0;
      if (txtTexto.getName().equals(Idioma.getTagTrack())) {
	  indiceConfigMp3 = 0;
      } else if (txtTexto.getName().equals(Idioma.getTagTitle())) {
	  indiceConfigMp3 = 1;
      } else if (txtTexto.getName().equals(Idioma.getTagArtist())) {
	  indiceConfigMp3 = 2;
      } else if (txtTexto.getName().equals(Idioma.getTagAlbum())) {
	  indiceConfigMp3 = 3;
      } else if (txtTexto.getName().equals(Idioma.getTagYear())) {
	  indiceConfigMp3 = 4;
      } else if (txtTexto.getName().equals(Idioma.getTagGenre())) {
	  indiceConfigMp3 = 5;
      }
      if (intComboMp3[indiceConfigMp3] != null) {
	  comboMp3.setSelectedIndex(intComboMp3[indiceConfigMp3]);
	  configMp3Paneles();
	  switch (comboMp3.getSelectedIndex()) {
	      case 0:
		  corteMp3.setText(stringCorte[indiceConfigMp3]);
		  numeracionCorteMp3.getModel().setValue(Integer.valueOf(stringnumeracion[indiceConfigMp3]));
		  hastaFinalMp3.setSelectedIndex(intFinalMp3[indiceConfigMp3]);
	      break;
	      case 1:
		  archivoTextoDesdeMp3.setText(stringDesde[indiceConfigMp3]);
		  archivoTextoHastaMp3.setText(stringHasta[indiceConfigMp3]);
	      break;
	  }
	  ckEnable.setSelected(booleanCkEnable[indiceConfigMp3]);
	  comboEnable.setSelectedIndex(intComboEnable[indiceConfigMp3]);
	  comboCase.setSelectedIndex(intComboCase[indiceConfigMp3]);
      }
      conmutaCkEnable();
      leeTablaMp3(txtTexto);
  }
  private void conmutaCkEnable() {
      if (ckEnable.isSelected()) {
	  pnlComboCase.setEnabled(true);
	  pnlCkEnable.setEnabled(true);
	  pnlSerieConfig.setEnabled(true);
	  tablaMp3.setEnabled(true);
      } else {
	  pnlComboCase.setEnabled(false);
	  pnlCkEnable.setEnabled(false);
	  pnlSerieConfig.setEnabled(false);
	  tablaMp3.setEnabled(false);
      }
  }
  private void leeTablaMp3(JTextField txtTexto) {
      if ( populateWorker == null || populateWorker.isDone() ) {
	  pnlCkEnable.setEnabled(false);
	  int indiceConfigMp3 = 0;
	  if (txtTexto.getName().equals(Idioma.getTagTrack())) {
	      indiceConfigMp3 = 0;
	      campoMp3 = "2";
	  } else if (txtTexto.getName().equals(Idioma.getTagTitle())) {
	      indiceConfigMp3 = 1;
	      campoMp3 = "1";
	  } else if (txtTexto.getName().equals(Idioma.getTagArtist())) {
	      indiceConfigMp3 = 2;
	      campoMp3 = "0";
	  } else if (txtTexto.getName().equals(Idioma.getTagAlbum())) {
	      indiceConfigMp3 = 3;
	      campoMp3 = "3";
	  } else if (txtTexto.getName().equals(Idioma.getTagYear())) {
	      indiceConfigMp3 = 4;
	      campoMp3 = "4";
	  } else if (txtTexto.getName().equals(Idioma.getTagGenre())) {
	      indiceConfigMp3 = 5;
	      campoMp3 = "5";
	  }
	  txtTextoGlobal = txtTexto;
	  indiceConfigMp3Global = indiceConfigMp3;
	  if (comboEnable.getSelectedIndex() == 3) {
	      pnlDialgMp3Sur.add(btnLast, "West");
	  }
	  pnlDialgMp3Sur.add(new JLabel(waitingOk), "East");
	  pnlPrincipalConfig.updateUI();
	  try {
	      if (arrayTablaMp3 == null || leeDatos || arrayTablaMp3[indiceConfigMp3Global][0] == null) {
		  leeDatos = true;
		  tablaMp3Originales = new String[0][0];
		  tablaMp3Model = new DefaultTableModel (tablaMp3Originales, nombreColumnasMp3);
		  tablaMp3.setModel(tablaMp3Model);
	      }
	  } catch (ArrayIndexOutOfBoundsException a) {
	  }
	  nombreColumnasMp3[1] = Idioma.getTagFor() + " " + txtTexto.getName();
	  tablaMp3.getTableHeader().getColumnModel().getColumn(1).setHeaderValue(nombreColumnasMp3[1]);  
	  tablaMp3.getColumnModel().getColumn(1).setCellRenderer(new MyCellTablaMp3(txtTexto, Idioma));
	  pnlTablaMp3.updateUI();
	  populateWorker = new populateTableMp3();
	  populateWorker.execute();
      }
  }
  private void escribeTablaMp3 (JTextField txtTexto) {
      try {
	  tablaMp3.getCellEditor().stopCellEditing();
      }
      catch (NullPointerException n) {
      }
      int indiceConfigMp3 = 0;
      if (txtTexto.getName().equals(Idioma.getTagTrack())) {
	  indiceConfigMp3 = 0;
      } else if (txtTexto.getName().equals(Idioma.getTagTitle())) {
	  indiceConfigMp3 = 1;
      } else if (txtTexto.getName().equals(Idioma.getTagArtist())) {
	  indiceConfigMp3 = 2;
      } else if (txtTexto.getName().equals(Idioma.getTagAlbum())) {
	  indiceConfigMp3 = 3;
      } else if (txtTexto.getName().equals(Idioma.getTagYear())) {
	  indiceConfigMp3 = 4;
      } else if (txtTexto.getName().equals(Idioma.getTagGenre())) {
	  indiceConfigMp3 = 5;
      }
      for (int x=0; x<arrayTablaMp3[indiceConfigMp3].length; x++) {
	  arrayTablaMp3[indiceConfigMp3][x] = "" + tablaMp3Model.getValueAt(x,1);
      }
  }
  private Boolean checkAudio(String fileCheck) {
      return (mBusca.endsWithIgnoreCase(fileCheck.toString(),".mp3") || mBusca.endsWithIgnoreCase(fileCheck.toString(),".mp4") || mBusca.endsWithIgnoreCase(fileCheck.toString(),".ogg") || mBusca.endsWithIgnoreCase(fileCheck.toString(),".flac") || mBusca.endsWithIgnoreCase(fileCheck.toString(),".wma") || mBusca.endsWithIgnoreCase(fileCheck.toString(),".wav") || mBusca.endsWithIgnoreCase(fileCheck.toString(),".ra"));
  }
  private int[] checkAudioSeleccion() {
      ArrayList<Integer> okAudioSeleccionList = new ArrayList<>();
      for (int x=0;x<okSeleccion.length;x++) {
	  if (mBusca.endsWithIgnoreCase(archivosOriginales[okSeleccion[x]].getName(),".mp3") || mBusca.endsWithIgnoreCase(archivosOriginales[okSeleccion[x]].getName(),".mp4") || mBusca.endsWithIgnoreCase(archivosOriginales[okSeleccion[x]].getName(),".ogg") || mBusca.endsWithIgnoreCase(archivosOriginales[okSeleccion[x]].getName(),".flac") || mBusca.endsWithIgnoreCase(archivosOriginales[okSeleccion[x]].getName(),".wma") || mBusca.endsWithIgnoreCase(archivosOriginales[okSeleccion[x]].getName(),".wav") || mBusca.endsWithIgnoreCase(archivosOriginales[okSeleccion[x]].getName(),".ra")) {
	      okAudioSeleccionList.add(okSeleccion[x]);
	  }
      }
      int[] okAudioSeleccion = new int[okAudioSeleccionList.size()];
      for (int x=0;x<okAudioSeleccion.length;x++) {
	  okAudioSeleccion[x] = okAudioSeleccionList.get(x);
      }
      return okAudioSeleccion;
  }
  private void recogeConfigMp3() {
      if (populateWorker.isDone()) {
	  String valorTabla;
	  try {
	      for(int x=0;x<arrayTablaMp3[indiceConfigMp3Global].length;x++) {
		  valorTabla = arrayTablaRecoge[x];
		  tablaMp3Originales[x][1] = "";
		  switch (comboMp3.getSelectedIndex()) {
		      case 0: 
			  String[] textoCorte;
			  int mNumero;
			  mNumero=Integer.parseInt(numeracionCorteMp3.getModel().getValue().toString());
			  String literal = corteMp3.getText();
			  if (corteMp3.getText().contains(".")) { 
			      literal = Pattern.quote(corteMp3.getText());
			      literal.replace(".","\\.");
			  }
			  try {
			      textoCorte = valorTabla.split(literal);
			  } catch (PatternSyntaxException e) {
			      try {
				  literal = Pattern.quote(corteMp3.getText());
				  textoCorte = valorTabla.split(literal);
			      } catch (PatternSyntaxException d) {
				  System.out.println("regex error");
				  textoCorte = valorTabla.split("");
			      }
			  }
			  if (textoCorte.length < 1 || corteMp3.getText().equals("")) {
			      tablaMp3Originales[x][1] = valorTabla;
			  } else {
			      if (mNumero >= textoCorte.length) mNumero = textoCorte.length;
			      switch (hastaFinalMp3.getSelectedIndex()) {
				  case 0:
				      tablaMp3Originales[x][1] = textoCorte[mNumero-1];
				  break;
				  case 1:
				      tablaMp3Originales[x][1] = ""; 
				      for (int p=mNumero;p<=textoCorte.length;p++) {
					  tablaMp3Originales[x][1] += (p < textoCorte.length) ? textoCorte[p-1]+corteMp3.getText() : textoCorte[p-1];
				      }
				  break;
				  case 2:
				      tablaMp3Originales[x][1] = ""; 
				      for (int p=0;p<=textoCorte.length-mNumero;p++) {
					  tablaMp3Originales[x][1] += (p < (textoCorte.length-mNumero) ) ? textoCorte[p]+corteMp3.getText() : textoCorte[p];
				      }
				  break;
			      }
			  }
		      break;
		      case 1:
			  if ( ! archivoTextoDesdeMp3.getText().equals("") || ! archivoTextoHastaMp3.getText().equals("") ) {
			      literal = archivoTextoDesdeMp3.getText();
			      if (archivoTextoDesdeMp3.getText().contains(".")) { 
				  literal = Pattern.quote(archivoTextoDesdeMp3.getText());
				  literal.replace(".","\\.");
			      }
			      try {
				  textoCorte = valorTabla.split(literal,2);
			      } catch (PatternSyntaxException e) {
				  try {
				      literal = Pattern.quote(archivoTextoDesdeMp3.getText());
				      textoCorte = valorTabla.split(literal,2);
				  } catch (PatternSyntaxException d) {
				      System.err.println("regex error");
				      textoCorte = valorTabla.split("");
				  }
			      }
			      if (textoCorte[0].length() < valorTabla.length()) {
				  if (archivoTextoHastaMp3.getText().equals("")) {
				      tablaMp3Originales[x][1] = textoCorte[1];
				  } else {
				      literal = archivoTextoHastaMp3.getText();
				      if (archivoTextoHastaMp3.getText().contains(".")) { 
					  literal = Pattern.quote(archivoTextoHastaMp3.getText());
					  literal.replace(".","\\.");
				      }
				      try {
					  textoCorte=textoCorte[1].split(literal,2);
				      } catch (PatternSyntaxException e) {
					  try {
					      literal = Pattern.quote(archivoTextoHastaMp3.getText());
					      textoCorte=textoCorte[1].split(literal,2);
					  } catch (PatternSyntaxException d) {
					      System.err.println("regex error");
					      textoCorte = valorTabla.split("");
					  }
				      }
				  tablaMp3Originales[x][1] = textoCorte[0];
				  }
			      }
			  } else {
			      tablaMp3Originales[x][1] = valorTabla;
			  }
		      break;
		  }
		  if (tablaMp3Originales[x][1].equals("")) {
		      valorTabla = arrayTablaRecoge[x];
		  } else {
		      valorTabla = tablaMp3Originales[x][1];
		  }
		  switch (comboCase.getSelectedIndex()) {
		      case 0:
			  tablaMp3Originales[x][1] = valorTabla;
		      break;
		      case 1:
			  tablaMp3Originales[x][1] = valorTabla.toUpperCase(locale);
		      break;
		      case 2:
			  tablaMp3Originales[x][1] = valorTabla.toLowerCase(locale);
		      break;
		      case 3:
			  try {
			      valorTabla = valorTabla.toLowerCase(locale);
			      String primera = valorTabla.substring(0,1).toUpperCase(locale);
			      valorTabla = primera + valorTabla.substring(1,valorTabla.length());
			      tablaMp3Originales[x][1] = valorTabla;		  
			  } catch (Exception e) {
			  }
		      break;
		      case 4:
			  try {
			      valorTabla = valorTabla.toLowerCase(locale);
			      String primera;
			      String[] palabras = valorTabla.split(" ");
			      valorTabla="";
			      for(int z=0;z<palabras.length;z++) {
				  if (palabras[z].length() < 1) continue;
				  primera = palabras[z].substring(0,1).toUpperCase(locale);		    
				  valorTabla=(!valorTabla.equals("")) ? valorTabla+" "+primera+palabras[z].substring(1,palabras[z].length()) : primera+palabras[z].substring(1,palabras[z].length());
			      }
			      tablaMp3Originales[x][1] = valorTabla;		  
			  } catch (Exception e) {
			  }
		      break;
		      
		  }
		  tablaMp3Model.setValueAt(tablaMp3Originales[x][1], x, 1);
	      } 
	  } catch (NullPointerException n) {
	      System.err.println("Error recuperando");
	  }
      }
  }
  protected void dialogOpciones() {
      if (DialogOpciones == null) {
	  DialogOpciones = new JDialog(this, Idioma.getMenuOptions() + " -- vRenamer", true);

	  String[] Categorias = {"General", Idioma.getMenuRenaming(), Idioma.getMenuDate(), "Cuarta"};

	  /** GENERAL
	  */

	  String[] listIdiomas = {Idioma.getMenuSpanish(), Idioma.getMenuEnglish()};
	  JLabel lblIdioma = new JLabel(Idioma.getMenuIdioma());
	  JPanel pnlLblIdioma = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  pnlLblIdioma.add(lblIdioma);
	  pnlLblIdioma.setPreferredSize(new Dimension(180,35));
	  pnlLblIdioma.setMinimumSize(new Dimension(180,35));
	  comboIdioma = new JComboBox(listIdiomas);
	  comboIdioma.setPreferredSize(new Dimension(300,20));
	  comboIdioma.setMinimumSize(new Dimension(300,20));
	  comboIdioma.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
	  comboIdioma.setRenderer(new RenderComboIdioma(Idioma));
	  JPanel selecIdioma = new JPanel();
	  selecIdioma.setLayout(new BoxLayout(selecIdioma,BoxLayout.X_AXIS));
	  selecIdioma.setAlignmentX(Component.LEFT_ALIGNMENT);
	  selecIdioma.setMaximumSize(new Dimension(1500,35));
	  selecIdioma.add(pnlLblIdioma);
	  selecIdioma.add(new Box.Filler(new Dimension(100,35), new Dimension(100,35), new Dimension(Short.MAX_VALUE,35)));
	  selecIdioma.add(comboIdioma);

	  String[] listSesion = {Idioma.getMenuSesionClean(), Idioma.getMenuSesionLast()};
	  JLabel lblSesion = new JLabel(Idioma.getMenuSesion());
	  JPanel pnlLblSesion = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  pnlLblSesion.add(lblSesion);
	  pnlLblSesion.setPreferredSize(new Dimension(180,35));
	  pnlLblSesion.setMinimumSize(new Dimension(180,35));
	  comboSesion = new JComboBox(listSesion);
	  comboSesion.setPreferredSize(new Dimension(300,20));
	  comboSesion.setMinimumSize(new Dimension(300,20));
	  comboSesion.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
	  comboSesion.setRenderer(new RenderCombos());
	  JPanel selecSesion = new JPanel();
	  selecSesion.setLayout(new BoxLayout(selecSesion,BoxLayout.X_AXIS));
	  selecSesion.setAlignmentX(Component.LEFT_ALIGNMENT);
	  selecSesion.setMaximumSize(new Dimension(1500,35));
	  selecSesion.add(pnlLblSesion);
	  selecSesion.add(new Box.Filler(new Dimension(100,35), new Dimension(100,35), new Dimension(Short.MAX_VALUE,35)));
	  selecSesion.add(comboSesion);

	  soloPanel = new JRadioButton(Idioma.getOpcionSolo());
	  ambos = new JRadioButton(Idioma.getOpcionAmbos());
	  ButtonGroup opcionesPreview = new ButtonGroup();
	  opcionesPreview.add(soloPanel);
	  opcionesPreview.add(ambos);
	  JPanel pnlOpcionesPreview = new JPanel();
	  pnlOpcionesPreview.setLayout(new BoxLayout(pnlOpcionesPreview,BoxLayout.Y_AXIS));
	  pnlOpcionesPreview.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlOpcionesPreview.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getOpcionPreview()),new EmptyBorder(5,5,5,5)));
	  pnlOpcionesPreview.setPreferredSize(new Dimension(300,100));
	  pnlOpcionesPreview.setMaximumSize(new Dimension(Short.MAX_VALUE,100));
	  pnlOpcionesPreview.add(soloPanel);      
	  pnlOpcionesPreview.add(Box.createRigidArea(new Dimension(0,5)));
	  pnlOpcionesPreview.add(ambos);      
	  JPanel selecOpcionesUno = new JPanel();

	  String[] listAuto = {Idioma.getActivated(), Idioma.getDeactivated()};
	  JLabel lblAuto = new JLabel(Idioma.getMenuAuto());
	  JPanel pnlLblAuto = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  pnlLblAuto.add(lblAuto);
	  pnlLblAuto.setPreferredSize(new Dimension(180,35));
	  pnlLblAuto.setMinimumSize(new Dimension(180,35));
	  comboAuto = new JComboBox(listAuto);
	  comboAuto.setPreferredSize(new Dimension(300,20));
	  comboAuto.setMinimumSize(new Dimension(300,20));
	  comboAuto.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
	  comboAuto.setRenderer(new RenderCombos());
	  JPanel selecAuto = new JPanel();
	  selecAuto.setLayout(new BoxLayout(selecAuto,BoxLayout.X_AXIS));
	  selecAuto.setAlignmentX(Component.LEFT_ALIGNMENT);
	  selecAuto.setMaximumSize(new Dimension(1500,35));
	  selecAuto.add(pnlLblAuto);
	  selecAuto.add(new Box.Filler(new Dimension(100,35), new Dimension(100,35), new Dimension(Short.MAX_VALUE,35)));
	  selecAuto.add(comboAuto);

	  selecOpcionesUno.setLayout(new BoxLayout(selecOpcionesUno,BoxLayout.Y_AXIS));
	  selecOpcionesUno.add(selecIdioma);
	  selecOpcionesUno.add(selecSesion);
	  selecOpcionesUno.add(selecAuto);
	  selecOpcionesUno.add(Box.createRigidArea(new Dimension(0,20)));
	  selecOpcionesUno.add(pnlOpcionesPreview);
	  selecOpcionesUno.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

	  /** RENOMBRADO
	  */

	  String[] listRenombrado = {Idioma.getMenuRenamingUno(), Idioma.getMenuRenamingDos()};
	  JLabel lblRenombrado = new JLabel(Idioma.getMenuRenamingLbl());
	  JPanel pnlLblRenombrado = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  pnlLblRenombrado.add(lblRenombrado);
	  pnlLblRenombrado.setPreferredSize(new Dimension(180,35));
	  pnlLblRenombrado.setMinimumSize(new Dimension(180,35));
	  comboRenombrado = new JComboBox(listRenombrado);
	  comboRenombrado.setPreferredSize(new Dimension(300,20));
	  comboRenombrado.setMinimumSize(new Dimension(300,20));
	  comboRenombrado.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
	  comboRenombrado.setRenderer(new RenderCombos());
	  JPanel selecRenombrado = new JPanel();
	  selecRenombrado.setLayout(new BoxLayout(selecRenombrado,BoxLayout.X_AXIS));
	  selecRenombrado.setAlignmentX(Component.LEFT_ALIGNMENT);
	  selecRenombrado.setMaximumSize(new Dimension(1500,35));
	  selecRenombrado.add(pnlLblRenombrado);
	  selecRenombrado.add(new Box.Filler(new Dimension(100,35), new Dimension(100,35), new Dimension(Short.MAX_VALUE,35)));
	  selecRenombrado.add(comboRenombrado);

	  String[] listEstructura = {Idioma.getMenuEstructuraUno(), Idioma.getMenuEstructuraDos()};
	  JLabel lblEstructura = new JLabel(Idioma.getMenuEstructuraLbl());
	  JPanel pnlLblEstructura = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  pnlLblEstructura.add(lblEstructura);
	  pnlLblEstructura.setPreferredSize(new Dimension(180,35));
	  pnlLblEstructura.setMinimumSize(new Dimension(180,35));
	  comboEstructura = new JComboBox(listEstructura);
	  comboEstructura.setPreferredSize(new Dimension(300,20));
	  comboEstructura.setMinimumSize(new Dimension(300,20));
	  comboEstructura.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
	  comboEstructura.setRenderer(new RenderCombos());
	  JPanel selecEstructura = new JPanel();
	  selecEstructura.setLayout(new BoxLayout(selecEstructura,BoxLayout.X_AXIS));
	  selecEstructura.setAlignmentX(Component.LEFT_ALIGNMENT);
	  selecEstructura.setMaximumSize(new Dimension(1500,35));
	  selecEstructura.add(pnlLblEstructura);
	  selecEstructura.add(new Box.Filler(new Dimension(100,35), new Dimension(100,35), new Dimension(Short.MAX_VALUE,35)));
	  selecEstructura.add(comboEstructura);

	  String[] listCopiarRenombrados = {Idioma.getMenuCopiarRenombradosUno(),Idioma.getMenuCopiarRenombradosDos()};
	  JLabel lblCopiarRenombrados = new JLabel(Idioma.getMenuCopiarRenombradosLbl());
	  JPanel pnlLblCopiarRenombrados = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  pnlLblCopiarRenombrados.add(lblCopiarRenombrados);
	  pnlLblCopiarRenombrados.setPreferredSize(new Dimension(180,35));
	  pnlLblCopiarRenombrados.setMinimumSize(new Dimension(180,35));
	  comboCopiarRenombrados = new JComboBox(listCopiarRenombrados);
	  comboCopiarRenombrados.setPreferredSize(new Dimension(300,20));
	  comboCopiarRenombrados.setMinimumSize(new Dimension(300,20));
	  comboCopiarRenombrados.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
	  comboCopiarRenombrados.setRenderer(new RenderCombos());
	  JPanel selecCopiarRenombrados = new JPanel();
	  selecCopiarRenombrados.setLayout(new BoxLayout(selecCopiarRenombrados,BoxLayout.X_AXIS));
	  selecCopiarRenombrados.setAlignmentX(Component.LEFT_ALIGNMENT);
	  selecCopiarRenombrados.setMaximumSize(new Dimension(1500,35));
	  selecCopiarRenombrados.add(pnlLblCopiarRenombrados);
	  selecCopiarRenombrados.add(new Box.Filler(new Dimension(100,35), new Dimension(100,35), new Dimension(Short.MAX_VALUE,35)));
	  selecCopiarRenombrados.add(comboCopiarRenombrados);

	  String[] listRecursivoCarpeta = {Idioma.getMenuCarpetaRecursivaUno(),Idioma.getMenuCarpetaRecursivaDos()};
	  JLabel lblRecursivoCarpeta = new JLabel(Idioma.getMenuCarpetaRecursivaLbl());
	  JPanel pnlLblRecursivoCarpeta = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  pnlLblRecursivoCarpeta.add(lblRecursivoCarpeta);
	  pnlLblRecursivoCarpeta.setPreferredSize(new Dimension(180,35));
	  pnlLblRecursivoCarpeta.setMinimumSize(new Dimension(180,35));
	  comboRecursivoCarpeta = new JComboBox(listRecursivoCarpeta);
	  comboRecursivoCarpeta.setPreferredSize(new Dimension(300,20));
	  comboRecursivoCarpeta.setMinimumSize(new Dimension(300,20));
	  comboRecursivoCarpeta.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
	  comboRecursivoCarpeta.setRenderer(new RenderCombos());
	  JPanel selecRecursivoCarpeta = new JPanel();
	  selecRecursivoCarpeta.setLayout(new BoxLayout(selecRecursivoCarpeta,BoxLayout.X_AXIS));
	  selecRecursivoCarpeta.setAlignmentX(Component.LEFT_ALIGNMENT);
	  selecRecursivoCarpeta.setMaximumSize(new Dimension(1500,35));
	  selecRecursivoCarpeta.add(pnlLblRecursivoCarpeta);
	  selecRecursivoCarpeta.add(new Box.Filler(new Dimension(100,35), new Dimension(100,35), new Dimension(Short.MAX_VALUE,35)));
	  selecRecursivoCarpeta.add(comboRecursivoCarpeta);

	  JPanel pnlOpcionesCarpeta = new JPanel();
	  pnlOpcionesCarpeta.setLayout(new BoxLayout(pnlOpcionesCarpeta,BoxLayout.Y_AXIS));
	  pnlOpcionesCarpeta.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlOpcionesCarpeta.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getMenuTituloCarpeta()),new EmptyBorder(5,5,5,5)));
	  pnlOpcionesCarpeta.add(selecRenombrado);
	  pnlOpcionesCarpeta.add(Box.createRigidArea(new Dimension(0,5)));
	  pnlOpcionesCarpeta.add(selecEstructura);      
	  pnlOpcionesCarpeta.add(Box.createRigidArea(new Dimension(0,5)));
	  pnlOpcionesCarpeta.add(selecCopiarRenombrados);      
	  pnlOpcionesCarpeta.add(Box.createRigidArea(new Dimension(0,5)));
	  pnlOpcionesCarpeta.add(selecRecursivoCarpeta);      

	  JLabel lblBasura = new JLabel(Idioma.getMenuTrash());
	  JPanel pnlLblBasura = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  pnlLblBasura.add(lblBasura);
	  pnlLblBasura.setPreferredSize(new Dimension(180,35));
	  pnlLblBasura.setMinimumSize(new Dimension(180,35));
	  txtBasura = new JTextField();
	  setFont(txtBasura, 10, Font.PLAIN);
	  txtBasura.setPreferredSize(new Dimension(300,20));
	  txtBasura.setMinimumSize(new Dimension(300,20));
	  txtBasura.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
	  JPanel selecBasura = new JPanel();
	  selecBasura.setLayout(new BoxLayout(selecBasura,BoxLayout.X_AXIS));
	  selecBasura.setAlignmentX(Component.LEFT_ALIGNMENT);
	  selecBasura.setMaximumSize(new Dimension(1500,35));
	  selecBasura.add(pnlLblBasura);
	  selecBasura.add(new Box.Filler(new Dimension(100,35), new Dimension(100,35), new Dimension(Short.MAX_VALUE,35)));
	  selecBasura.add(txtBasura);

	  JPanel pnlOpcionesNormaliza = new JPanel();
	  pnlOpcionesNormaliza.setLayout(new BoxLayout(pnlOpcionesNormaliza,BoxLayout.Y_AXIS));
	  pnlOpcionesNormaliza.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlOpcionesNormaliza.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getMenuTituloNormaliza()),new EmptyBorder(5,5,5,5)));
	  pnlOpcionesNormaliza.add(selecBasura);

	  JPanel selecOpcionesDos = new JPanel();
	  selecOpcionesDos.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
	  selecOpcionesDos.setLayout(new BoxLayout(selecOpcionesDos,BoxLayout.Y_AXIS));
	  selecOpcionesDos.add(pnlOpcionesCarpeta);
	  selecOpcionesDos.add(Box.createRigidArea(new Dimension(0,12)));
	  selecOpcionesDos.add(pnlOpcionesNormaliza);

	  /** FECHAS
	  */

	  String[] listFechas = {Idioma.getMenuDayOne(), Idioma.getMenuDayTwo(), Idioma.getMenuDayThree()};
	  JLabel lblFechas = new JLabel(Idioma.getMenuDayMonth());
	  JPanel pnlLblFechas = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  pnlLblFechas.add(lblFechas);
	  pnlLblFechas.setPreferredSize(new Dimension(180,35));
	  pnlLblFechas.setMinimumSize(new Dimension(180,35));
	  comboFechas = new JComboBox(listFechas);
	  comboFechas.setPreferredSize(new Dimension(300,20));
	  comboFechas.setMinimumSize(new Dimension(300,20));
	  comboFechas.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
	  comboFechas.setRenderer(new RenderCombos());

	  JPanel selecFechas = new JPanel();
	  selecFechas.setLayout(new BoxLayout(selecFechas,BoxLayout.X_AXIS));
	  selecFechas.setAlignmentX(Component.LEFT_ALIGNMENT);
	  selecFechas.setMaximumSize(new Dimension(1500,35));
	  selecFechas.add(pnlLblFechas);
	  selecFechas.add(new Box.Filler(new Dimension(100,35), new Dimension(100,35), new Dimension(Short.MAX_VALUE,35)));
	  selecFechas.add(comboFechas);

	  modified = new JRadioButton(Idioma.getMenPickModified());
	  modified.addActionListener (new ActionListener () {
              @Override
              public void actionPerformed(ActionEvent e)
		{
		  calendario.setEnabled(false);
		  btnActualizaCalendar.setEnabled(false);
		}
	  });
	  creation = new JRadioButton(Idioma.getMenPickCreation());
	  creation.addActionListener (new ActionListener () {
              @Override
              public void actionPerformed(ActionEvent e)
		{
		  calendario.setEnabled(false);
		  btnActualizaCalendar.setEnabled(false);
		}
	  });
	  accessed = new JRadioButton(Idioma.getMenPickAccessed());
	  accessed.addActionListener (new ActionListener () {
              @Override
              public void actionPerformed(ActionEvent e)
		{
		  calendario.setEnabled(false);
		  btnActualizaCalendar.setEnabled(false);
		}
	  });
	  manual = new JRadioButton(Idioma.getMenPickManual()); 
	  manual.addActionListener (new ActionListener () {
              @Override
              public void actionPerformed(ActionEvent e)
		{
		  calendario.setEnabled(true);
		  btnActualizaCalendar.setEnabled(true);
		}
	  });
	  ButtonGroup pickFechas = new ButtonGroup();
	  pickFechas.add(modified);
	  if ( getSistema().equals("windows") ) {
	      pickFechas.add(accessed);
	      pickFechas.add(creation);
	  }
	  pickFechas.add(manual);

	  JPanel indentaManual = new JPanel();
	  indentaManual.setLayout(new BoxLayout(indentaManual,BoxLayout.X_AXIS));
	  indentaManual.setAlignmentX(Component.LEFT_ALIGNMENT);
	  indentaManual.add(new JLabel("      "));
	  indentaManual.add(Box.createRigidArea(new Dimension(0,10)));
	  indentaManual.add(manual);

	  JPanel pnlPick = new JPanel();
	  pnlPick.setLayout(new BoxLayout(pnlPick,BoxLayout.Y_AXIS));
	  pnlPick.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlPick.setPreferredSize(new Dimension(240,55));
	  pnlPick.setMinimumSize(new Dimension(240,55));
	  pnlPick.setMaximumSize(new Dimension(240,55));
	  if ( getSistema().equals("windows") ) {
	      pnlPick.add(creation);
	      pnlPick.add(Box.createRigidArea(new Dimension(0,10)));
	  }
	  pnlPick.add(modified);
	  if ( getSistema().equals("windows") ) {
	      pnlPick.add(Box.createRigidArea(new Dimension(0,10)));
	      pnlPick.add(accessed);
	  }
	  pnlPick.add(Box.createRigidArea(new Dimension(0,10)));
	  pnlPick.add(indentaManual);

	  calendario = new JCalendar(3,true,locale);
	  calendario.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.pink),BorderFactory.createEmptyBorder(5,5,5,5)));
	  calendario.setBackground(Color.white);
	  calendario.setDayFont(new Font("Helvetica", Font.BOLD, 10));
	  calendario.setPreferredSize(new Dimension(220,220));
	  calendario.setMinimumSize(new Dimension(220,220));
	  calendario.setMaximumSize(new Dimension(220,220));
	  calendario.setEnabled(false);

	  btnActualizaCalendar = getButton("",actualizaOk,false);
	  btnActualizaCalendar.addActionListener(new ActionListener () {
              @Override
              public void actionPerformed(ActionEvent e) {
		  calendario.setDate(new Date());
	      }
	  });
	  btnActualizaCalendar.setToolTipText(Idioma.getCalendarReload());

	  btnActualizaCalendar.setPreferredSize(new Dimension(40,23));
	  btnActualizaCalendar.setMaximumSize(new Dimension(40,23));
	  btnActualizaCalendar.setEnabled(false);

	  JPanel calendarioyBoton = new JPanel();
	  calendarioyBoton.setLayout(new BoxLayout(calendarioyBoton,BoxLayout.X_AXIS));
	  btnActualizaCalendar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	  calendario.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	  calendarioyBoton.add(btnActualizaCalendar);
	  calendarioyBoton.add(Box.createRigidArea(new Dimension(5,0)));
	  calendarioyBoton.add(calendario);

	  JPanel pnlCalendario = new JPanel(new BorderLayout());
	  pnlCalendario.setPreferredSize(new Dimension(600,220));
	  pnlCalendario.setMinimumSize(new Dimension(550,220));
	  pnlCalendario.setMaximumSize(new Dimension(Short.MAX_VALUE,220));
	  pnlCalendario.add(pnlPick,"West");
	  pnlCalendario.add(calendarioyBoton, "East");

	  JPanel pnlOpcionesFecha = new JPanel();
	  pnlOpcionesFecha.setLayout(new BoxLayout(pnlOpcionesFecha,BoxLayout.Y_AXIS));
	  pnlOpcionesFecha.setAlignmentX(Component.LEFT_ALIGNMENT);
	  pnlOpcionesFecha.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getMenPickDate()),new EmptyBorder(5,5,5,5)));
	  pnlOpcionesFecha.add(pnlCalendario);

	  JPanel selecOpcionesTres = new JPanel();
	  selecOpcionesTres.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
	  selecOpcionesTres.setLayout(new BoxLayout(selecOpcionesTres,BoxLayout.Y_AXIS));
	  selecOpcionesTres.add(selecFechas);
	  selecOpcionesTres.add(Box.createRigidArea(new Dimension(0,5)));
	  selecOpcionesTres.add(pnlOpcionesFecha);

	  /** RESTO
	  */

	  JPanel selecOpcionesCuatro = new JPanel();
	  selecOpcionesCuatro.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(Idioma.getMenuOptions()),new EmptyBorder(10,10,10,10)));
	  selecOpcionesCuatro.setLayout(new BoxLayout(selecOpcionesCuatro,BoxLayout.Y_AXIS));

	  /** PANEL CONTENEDOR Y BOTONES
	  */

	  JTabbedPane categoriaOpciones = new JTabbedPane();
	  categoriaOpciones.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
	  categoriaOpciones.add(selecOpcionesUno,Categorias[0]);
	  categoriaOpciones.add(selecOpcionesDos,Categorias[1]);
          categoriaOpciones.add(selecOpcionesTres,Categorias[2]);
    //      categoriaOpciones.add(selecOpcionesCuatro,Categorias[3]);
	  categoriaOpciones.setSelectedIndex(0);
	  categoriaOpciones.setIconAt(0,generalOptOk);
	  categoriaOpciones.setIconAt(1,optionRenameOk);
	  categoriaOpciones.setIconAt(2,dateOk);

	  JPanel selecBotonesDer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	  JButton btnDialogOk = getButton(Idioma.getCopiaOk(),aplicarOk,false);
	  setFont(btnDialogOk, 10, Font.PLAIN);
	  btnDialogOk.addActionListener((ActionEvent e) -> {
              DialogOpciones.setVisible(false);
              aplicaOpciones();
          });

	  JButton btnDialogCancel = getButton(Idioma.getOptionCancel(),cancelOk,false);
	  setFont(btnDialogCancel, 10, Font.PLAIN);
	  btnDialogCancel.addActionListener((ActionEvent e) -> {
              DialogOpciones.setVisible(false);
          });
//	  DialogOpciones.getRootPane().setDefaultButton(btnDialogOk);
	  selecBotonesDer.add(btnDialogOk);
	  selecBotonesDer.add(btnDialogCancel);


	  JPanel selecBotonesIzq = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  JButton btnDialogReset = getButton(Idioma.getMenuDefault(),actualizaOk,false);
	  setFont(btnDialogReset, 10, Font.PLAIN);
	  btnDialogReset.addActionListener((ActionEvent e) -> {
              reseteaOpciones();
          });
	  selecBotonesIzq.add(btnDialogReset);

	  JPanel selecBotonesTotal = new JPanel(new BorderLayout());
	  selecBotonesTotal.add(selecBotonesDer, "East");
	  selecBotonesTotal.add(selecBotonesIzq, "West");

	  JPanel pnlDialogOpciones = new JPanel (new BorderLayout());
	  pnlDialogOpciones.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
	  pnlDialogOpciones.add(categoriaOpciones,"Center");
	  pnlDialogOpciones.add(selecBotonesTotal,"South");

	  leeOpciones();

	  DialogOpciones.add(pnlDialogOpciones);    
	  DialogOpciones.setSize(720,470);
	  DialogOpciones.setMinimumSize(new Dimension(720,470));
	  DialogOpciones.setLocationRelativeTo(this);
    //      DialogOpciones.setResizable(false);
	  DialogOpciones.setVisible(true);
	  if ( getSistema().equals("mac")) {
	      DialogOpciones.addWindowListener(new WindowAdapter() {
		  @Override
		  public void windowDeactivated (WindowEvent e) {
		      aplicaOpciones();	      
		  }
	      });
	  }
      } else {
	  leeOpciones();
	  DialogOpciones.setVisible(true);
      }
  }
  public void reseteaOpciones() {
      comboSesion.setSelectedIndex(0);
      comboAuto.setSelectedIndex(0);
      soloPanel.setSelected(true);
      comboRenombrado.setSelectedIndex(0);
      comboEstructura.setSelectedIndex(0);
      comboRecursivoCarpeta.setSelectedIndex(0);
      comboCopiarRenombrados.setSelectedIndex(0);
      txtBasura.setText("[^a-zA-Z0-9_ -]+");
      comboFechas.setSelectedIndex(0);
      modified.setSelected(true);
      calendario.setEnabled(false);
      aplicaOpciones();
  }

  public void acercaDe(){
    if ( AcercaDe == null ) {
	AcercaDe = new JDialog(this, Idioma.getMenuAbout(), true);

	JLabel acercaIcono = new JLabel (vrlogoOk);
	JLabel acercaVRenamer = new JLabel ("vRenamer");
	acercaVRenamer.setFont(new Font("Helvetica", Font.BOLD, 14));

	JLabel acercaAutor = new JLabel ("Carlos Verdier Santiago");
	acercaAutor.setFont(new Font("Helvetica", Font.PLAIN, 12));
	JLabel coment = new JLabel(Idioma.getDescription());
	coment.setFont(new Font("Helvetica", Font.PLAIN, 11));

	JPanel panelAcercaIcono = new JPanel(new FlowLayout(FlowLayout.LEFT));
	panelAcercaIcono.add(acercaIcono);

	JPanel pnlAcercaTexto = new JPanel();
	pnlAcercaTexto.setLayout(new BoxLayout(pnlAcercaTexto,BoxLayout.Y_AXIS));
	pnlAcercaTexto.setAlignmentX(Component.LEFT_ALIGNMENT);
	pnlAcercaTexto.add(acercaVRenamer);
	pnlAcercaTexto.add(acercaAutor);
	pnlAcercaTexto.add(coment);

	/** ACERCA DE
	*/

	JLabel acercaVRenamerAbout = new JLabel ("vRenamer");
	acercaVRenamerAbout.setFont(new Font("Helvetica", Font.BOLD, 14));

	JLabel comentAbout = new JLabel(Idioma.getDescription());
	comentAbout.setFont(new Font("Helvetica", Font.PLAIN, 11));

	JLabel acercaVersion = new JLabel (Idioma.getAboutLabel() + " " + Version);
	acercaVersion.setFont(new Font("Helvetica", Font.BOLD, 12));
	JLabel acercaAutorCopy = new JLabel ("(c) 2010-2023 Carlos Verdier Santiago");
	acercaAutor.setFont(new Font("Helvetica", Font.PLAIN, 12));
	JTitledSeparator online = new JTitledSeparator("Online");
	JLink webEnlazada = new JLink<>("vRenamer homepage", "http://vrenamer.wordpress.com");
	JButton btnDona = getButton("",donaOk,true);
	btnDona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
	    {
	      try {
		  Desktop.getDesktop().browse(new URI ("http://sourceforge.net/donate/index.php?group_id=385049") );
	      }
	      catch (URISyntaxException | IOException z) {
		  JOptionPane.showMessageDialog(pnlPrincipal, Idioma.getErrorLabel()+" http://sourceforge.net/donate/index.php?group_id=385049", "ERROR", JOptionPane.ERROR_MESSAGE);
	      }
	    }
	});

	JPanel pnlAcercaPanel = new JPanel();
	pnlAcercaPanel.setLayout(new BoxLayout(pnlAcercaPanel,BoxLayout.Y_AXIS));
	pnlAcercaPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	pnlAcercaPanel.setBorder(BorderFactory.createEmptyBorder(50,10,10,10));
	pnlAcercaPanel.add(acercaVRenamerAbout);
	pnlAcercaPanel.add(Box.createRigidArea(new Dimension(0,5)));
	pnlAcercaPanel.add(comentAbout);
	pnlAcercaPanel.add(Box.createRigidArea(new Dimension(0,5)));
	pnlAcercaPanel.add(acercaVersion);
	pnlAcercaPanel.add(Box.createRigidArea(new Dimension(0,5)));
	pnlAcercaPanel.add(acercaAutorCopy);
	pnlAcercaPanel.add(Box.createRigidArea(new Dimension(0,20)));
	pnlAcercaPanel.add(online);
	pnlAcercaPanel.add(Box.createRigidArea(new Dimension(0,10)));
	pnlAcercaPanel.add(webEnlazada);
	pnlAcercaPanel.add(Box.createRigidArea(new Dimension(0,5)));
	pnlAcercaPanel.add(btnDona);

	/** LICENCIA
	*/

	JLabel lblLcencia = new JLabel(Idioma.getLicenseTitle());
	JTextArea txtLicencia = new JTextArea(1,1);
	txtLicencia.setEditable(false);
	txtLicencia.setLineWrap(true);
	txtLicencia.setWrapStyleWord(true);
	scrTexto = new JScrollPane(txtLicencia);
	reader = null;
	  try {  
	    if (Idioma instanceof idiomasEsp) licenciaTxt = cldr.getResourceAsStream("textos/licencia.txt");
	    else if (Idioma instanceof idiomasEng) licenciaTxt = cldr.getResourceAsStream("textos/licencia_Eng.txt");
	    reader = new BufferedReader(new InputStreamReader(licenciaTxt, "UTF-8"));
	    String linea = reader.readLine();
	    while (linea != null) {
	      txtLicencia.append(linea);
	      txtLicencia.append(System.getProperty("line.separator")); 
	      linea = reader.readLine();
	    } 
	}
	catch (IOException e) {
	    throw new RuntimeException(e);
	}
	finally {
	  try {
	    reader.close();
	    licenciaTxt.close();
	}
	  catch (IOException e){
	    throw new RuntimeException(e);
	  }
	}
	JPanel pnlLicencia = new JPanel(new BorderLayout());
	pnlLicencia.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	Runnable doScrollR = new Runnable() {
          @Override
	  public void run() {
	    scrTexto.getVerticalScrollBar().setValue(0);
	  }
	};
	SwingUtilities.invokeLater(doScrollR);
	pnlLicencia.add(lblLcencia,"North");
	pnlLicencia.add(scrTexto,"Center");

	/** CRÉDITOS
	*/

	JLabel lblCreditos = new JLabel(Idioma.getCredits());
	JTextArea txtCreditos = new JTextArea(1,1);
	txtCreditos.setEditable(false);
	txtCreditos.setLineWrap(true);
	txtCreditos.setWrapStyleWord(true);
	final JScrollPane scrCreditos = new JScrollPane(txtCreditos);
	reader = null;
	  try {  
	    if (Idioma instanceof idiomasEsp) creditosTxt = cldr.getResourceAsStream("textos/creditos.txt");
	    else if (Idioma instanceof idiomasEng) creditosTxt = cldr.getResourceAsStream("textos/creditos_Eng.txt");
	    reader = new BufferedReader(new InputStreamReader(creditosTxt, "UTF-8"));
	    String linea = reader.readLine();
	    while (linea != null) {
	      txtCreditos.append(linea);
	      txtCreditos.append(System.getProperty("line.separator")); 
	      linea = reader.readLine();
	    } 
	}
	catch (IOException e) {
	    throw new RuntimeException(e);
	}
	finally {
	  try {
	    reader.close();
	    creditosTxt.close();
	}
	  catch (IOException e){
	    throw new RuntimeException(e);
	  }
	}
	JPanel pnlCreditos = new JPanel(new BorderLayout());
	pnlCreditos.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	SwingUtilities.invokeLater(new Runnable() {
          @Override
	  public void run() {
	    scrCreditos.getVerticalScrollBar().setValue(0);
	  }
	});
	pnlCreditos.add(lblCreditos,"North");
	pnlCreditos.add(scrCreditos,"Center");


	JTabbedPane pnlPestAcerca = new JTabbedPane();
	pnlPestAcerca.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
 	pnlPestAcerca.add(pnlAcercaPanel, Idioma.getAboutTitle());
	pnlPestAcerca.add(pnlCreditos, Idioma.getCredits());
 	pnlPestAcerca.add(pnlLicencia, Idioma.getAboutLicense());

	JPanel acercaCentral = new JPanel(new BorderLayout());
	acercaCentral.add(panelAcercaIcono, "West");
	acercaCentral.add(pnlAcercaTexto, "Center");

	JButton btnAboutOk = getButton(Idioma.getCopiaOk(),null,false);
	btnAboutOk.setFont(new Font("Helvetica", Font.PLAIN, 11));
	btnAboutOk.addActionListener(new ActionListener() {
          @Override
	  public void actionPerformed(ActionEvent e)
	    {
	      AcercaDe.setVisible(false);
	    }
	});
	btnAboutOk.setPreferredSize(new Dimension (60,23));

	AcercaDe.getRootPane().setDefaultButton(btnAboutOk);
	JPanel acercaBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	acercaBotones.add(btnAboutOk);

	JPanel pnlAcercaDe = new JPanel (new BorderLayout());
	pnlAcercaDe.setBorder(BorderFactory.createEmptyBorder(15,10,10,20));
	pnlAcercaDe.add(acercaCentral,"North");
	pnlAcercaDe.add(pnlPestAcerca, "Center");
//	pnlAcercaDe.add(acercaBotones,"South");

	AcercaDe.add(pnlAcercaDe);
	
	AcercaDe.setSize(495,520);
	AcercaDe.setMinimumSize(new Dimension(495,520));

	AcercaDe.setLocationRelativeTo(this);
	AcercaDe.setResizable(false);
	AcercaDe.setVisible(true);
    }
    else AcercaDe.setVisible(true);
  }
  private void chequeaVersion() {
      muestraBarra(false,Idioma.getCheckVersion());
      jProgreso.setStringPainted(false);
      jProgreso.setIndeterminate(true);
      new checkeaVersionWorker().execute();
  }
  public void salir(){
	prefs.put(prefDirectorio, ruta);
	if (iniciaSesion.equals("last")) {
	    prefs.put(prefSesion, "last");
	    if ( ! guardaLast() ) System.err.println("Cannot save last session");
	}
	else prefs.put(prefSesion, "clean");
	if (iniciaRenderer.equals("default")) prefs.put(prefRenderer, "default");
	else prefs.put(prefRenderer, "preview");
	if (automaticPreview || autoDespuesReset) prefs.put(prefAuto, "verdadero");
	else prefs.put(prefAuto, "falso");
	if (getExtendedState() == 6) prefs.put(prefMaximized, "verdadero");
	else prefs.put(prefMaximized, "falso");
	if (iniciaCarpeta.equals("default")) {
	    prefs.put(prefCarpeta, "default");
	} else {
	    prefs.put(prefCarpeta, "contenido");
	}
	if (copiarEstructura) {
	    prefs.put(prefEstructura, "true");
	} else {
	    prefs.put(prefEstructura, "false");
	}
	if (recursivoCarpeta) {
	    prefs.put(prefRecursivoCarpeta, "true");
	} else {
	    prefs.put(prefRecursivoCarpeta, "false");
	}
	if (copiarRenombrados) {
	    prefs.put(prefCopiarRenombrados, "true");
	} else {
	    prefs.put(prefCopiarRenombrados, "false");
	}
	if (!openRecent.isEmpty()) {
	    String arrayRecent = "";
	    for (int x=0;x<openRecent.size();x++) {
		arrayRecent += openRecent.get(x) + ",";
	    }
	    prefs.put(prefRecent, arrayRecent);
	}
	prefs.put(prefBasura, iniciaBasura);
	int ancho = getSize().width;
	int alto = getSize().height;
	prefs.put(prefDimension, ancho + "x" + alto);
	prefs.put(prefDivideTop,pnlDivide.getDividerLocation() + "");
	prefs.put(prefDivideBottom,pnlSur.getDividerLocation() + "");
	prefs.put(prefLocation,getLocation().x + "x" + getLocation().y);
	prefs.put(prefDiasMes, diasMes + "");
        switch (iniciaModified) {
            case "modified":
                prefs.put(prefModified, "modified");
	    break;
            case "creation":
                prefs.put(prefModified, "creation");
	    break;
            case "accessed":
                prefs.put(prefModified, "accessed");
	    break;
            default:
                prefs.put(prefModified, "manual");
	    break;
        }
	if ( txtImportaSepara != null ) {
	    if ( ! txtImportaSepara.getText().equals(iniciaTextoSepara) ) 
                prefs.put(prefTextoSepara, txtImportaSepara.getText());
	}
	prefs.put(prefComboCarpeta, comboCarpeta.getSelectedIndex() + "");
	if (m43.isSelected()) {
	    prefs.put(prefDrop, "true");
	}
	else {
	    prefs.put(prefDrop, "false");
	}
	System.out.println("Nos vemos");
	System.exit(0);
  }

  class DraftWatermark extends AbstractComponentDecorator {
      public DraftWatermark(JComponent target) {
	  super(target);
      }
      @Override
      public void paint(Graphics graphics) {
	  try {
	      infoBigOk = ImageIO.read(infoImg);
	  }
	  catch (IOException e) {
	  }
	  float tamFuente;
	  if (anchuraP > 1900)
	      tamFuente = 2.0f;
	  else
	      tamFuente = 1.5f;
	  Rectangle r = getDecorationBounds();
	  Graphics2D g = (Graphics2D)graphics;
	  g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			      RenderingHints.VALUE_ANTIALIAS_ON);
	  Font f = g.getFont();
	  g.setFont(f.deriveFont(Font.BOLD, f.getSize() * tamFuente));
	  g.setColor(new Color(128,128,128,128));
	  float dash1[] = {15.0f};
	  BasicStroke dashed = new BasicStroke(2,
				  BasicStroke.CAP_BUTT,
				  BasicStroke.JOIN_MITER,
				  10.0f, dash1, 0.0f);
	  g.setStroke(dashed);
	  g.drawRect(r.x + 30, r.y + 20, r.width - 50, r.height - 40);
	  g.setColor(new JPanel().getBackground());
	  g.fillRect(r.x + 31, r.y + 21, r.width - 51, r.height - 41);
	  g.setColor(new Color(128,128,128,128));
	  g.drawImage(infoBigOk, r.x + 21, r.y + 10, null);
	  g.setColor(new Color(98,98,98,98));
	  FontMetrics fm = g.getFontMetrics();
	  Rectangle2D rect = fm.getStringBounds(Idioma.getDropHere(), g);
	  g.drawString(Idioma.getDropHere(), (int) ((r.x + r.width/2) - (rect.getWidth()/2)), 
		      (int) (r.y + r.height/2 + rect.getHeight()/2) - 10);
	  g.setFont(f.deriveFont(Font.BOLD, f.getSize() * tamFuente/1.8f));
	  g.drawString(Idioma.getDropNot(), (int) ((r.x + r.width/2) - (rect.getWidth()/2)), 
		      (int) (r.y + r.height/2 + rect.getHeight()/2 + rect.getHeight()/2));
      }
  }

  class AddEdit extends AbstractUndoableEdit {

      private int[] indSeleccionados;
      private File[] archivosOriginales, archivosOriginalesUndo, archivosRenombrados, archivosRenombradosUndo, directoriosDeshacer;
      private idiomas Idioma;
      private java.util.List<File> archivosCiclo;
      private File deshacerActual, rehacerActual;
      private Boolean modoDrop;
      private StringBuffer[] RenombradosUndo;
      private StringBuffer[] ArchivosUndo;

      public AddEdit( int[] indSeleccionados, File[] archivosOriginales, File[] archivosRenombrados, StringBuffer[] ArchivosUndo, StringBuffer[] RenombradosUndo, File[] directoriosDeshacer, Boolean modoDrop, idiomas Idioma ) {
	  this.indSeleccionados = indSeleccionados;
	  this.archivosOriginales = archivosOriginales;
	  this.archivosRenombrados = archivosRenombrados;
	  this.RenombradosUndo = RenombradosUndo;
	  this.ArchivosUndo = ArchivosUndo;
	  this.directoriosDeshacer = directoriosDeshacer;
	  this.modoDrop = modoDrop;
	  this.Idioma = Idioma;
	  if(modoDrop) {
	      setDropOriginales(archivosRenombrados);
	  }
	  archivosOriginalesUndo = new File[archivosOriginales.length];
	  int x=0;
	  for (File fOriginales : archivosOriginales) {
	      archivosOriginalesUndo[x] = fOriginales;
	      x++;
	  }
	  x=0;
	  archivosRenombradosUndo = new File[archivosRenombrados.length];
	  for (File fRenombrados : archivosRenombrados) {
	      archivosRenombradosUndo[x] = fRenombrados;
	      x++;
	  }
  }

  @Override
  public void undo() throws CannotUndoException {
      btnAplicar.setEnabled(false);
      btnAplicar.setIcon(aplicarBigBWOk);
      btnPreview.setEnabled(false);
      btnLimpiar.setEnabled(false);
      btnActualizar.setEnabled(false);
      comboSelecAplica.setEnabled(false);
      m15.setEnabled(false);
      m16.setEnabled(false);
      jProgreso.setStringPainted(true);
      jProgreso.setValue(0);
      jProgreso.setMinimum(0);
      jProgreso.setMaximum(indSeleccionados.length);
      muestraBarra(true,Idioma.getBarApply());
      new Deshaciendo().execute();
  }

  @Override
  public void redo() throws CannotRedoException {
      btnAplicar.setEnabled(false);
      btnAplicar.setIcon(aplicarBigBWOk);
      btnPreview.setEnabled(false);
      btnLimpiar.setEnabled(false);
      btnActualizar.setEnabled(false);
      comboSelecAplica.setEnabled(false);
      m15.setEnabled(false);
      m16.setEnabled(false);
      jProgreso = new JProgressBar(0,archivosOriginales.length);
      jProgreso.setStringPainted(true);
      muestraBarra(true,Idioma.getBarApply());
      new Rehaciendo().execute();
  }
  
  @Override
  public boolean canUndo() {
     return true;
  }

  @Override
  public boolean canRedo() {
     return true;
  }

  @Override
  public String getPresentationName() {
     return Idioma.getTitleRename();
  }
  public boolean deleteDirectory(File path) {
    if( path.exists() ) {
      File[] files = path.listFiles();
      for(int i=0; i<files.length; i++) {
         if(files[i].isDirectory()) {
	    deleteDirectory(files[i]);
         }
         else {
           return false;
         }
      }
    }
    return( path.delete() );
  }
  class Deshaciendo extends SwingWorker<Void, Integer> {

      @Override    
      protected Void doInBackground() throws Exception {
	  Boolean siTodo = false;
	  Boolean noTodo = false;
          java.util.List<Integer> indicesCiclo;
	  java.util.List<Integer> indicesMarcar;
	  archivosCiclo = new ArrayList<>();
	  mBusca.checkRepetidos(ArchivosUndo, archivosRenombradosUndo, getSistema());
	  indicesCiclo = mBusca.getIndicesCiclo();
	  indicesMarcar = mBusca.getIndicesMarcar();
	  for(int x=0;x<indSeleccionados.length;x++) {
	      deshacerActual = archivosOriginales[indSeleccionados[x]];
	      publish(x + 1);
	      int respuestaRenombra = 0;
	      if (archivosRenombrados[indSeleccionados[x]].getName().startsWith("vRTP")) {
		  File originales = new File ( archivosOriginales[indSeleccionados[x]].getParent() + separador + "vRTP" + archivosOriginales[indSeleccionados[x]].getName() );
		  File renombrados = new File ( archivosRenombrados[indSeleccionados[x]].getParent() + separador + archivosRenombrados[indSeleccionados[x]].getName().substring(4) );
		  archivosCiclo.add(originales);
		  renombrados.renameTo(originales);
		  if (archivosCheck.contains(renombrados))
		      archivosCheck.set(archivosCheck.indexOf(renombrados), originales);
		  archivosOriginalesUndo[indSeleccionados[x]] = archivosOriginales[indSeleccionados[x]];
	      } else {
		  Boolean cicloDeshacer = false;
		  if (indicesCiclo.contains(indSeleccionados[x])) {
		      System.out.println(MessageFormat.format("UNDO -- Cycle renaming detected for {0}. Fixed", archivosOriginales[indSeleccionados[x]]));
		      File originales = new File ( archivosOriginales[indSeleccionados[x]].getParent() + separador + "vRTP" + archivosOriginales[indSeleccionados[x]].getName() );		    
		      archivosCiclo.add(originales);
		      archivosRenombradosUndo[indSeleccionados[x]].renameTo(originales);
		      if (archivosCheck.contains(archivosRenombradosUndo[indSeleccionados[x]]))
			  archivosCheck.set(archivosCheck.indexOf(archivosRenombradosUndo[indSeleccionados[x]]), originales);
		      cicloDeshacer = true;
		  }
		  if (indicesMarcar.contains(indSeleccionados[x]) && ! siTodo) {
                      if ( ! noTodo )
                          respuestaRenombra = yaExiste( archivosRenombradosUndo[indSeleccionados[x]].toString(), archivosOriginales[indSeleccionados[x]].toString() );
                      else
                          respuestaRenombra = 2;
                  }
		  if ( respuestaRenombra == 1 ) {
		      respuestaRenombra = 0;
		      siTodo = true;
                  } else if (respuestaRenombra == 4) {
                      respuestaRenombra = 2;
                      noTodo = true;
		  } else if ( respuestaRenombra == 2 ) {
		      archivosOriginalesUndo[indSeleccionados[x]] = archivosRenombradosUndo[indSeleccionados[x]];		    
		      continue;
		  } else if ( respuestaRenombra == 3 ) {
		      for (int n=x;n<indSeleccionados.length;n++) {
			  archivosOriginalesUndo[indSeleccionados[n]] = archivosRenombradosUndo[indSeleccionados[n]];		    			
		      }
		      break;
		  }
		  if ( ! cicloDeshacer && respuestaRenombra == 0 ) {
		      archivosRenombradosUndo[indSeleccionados[x]].renameTo(archivosOriginales[indSeleccionados[x]]);
		      if (archivosCheck.contains(archivosRenombradosUndo[indSeleccionados[x]]))
			  archivosCheck.set(archivosCheck.indexOf(archivosRenombradosUndo[indSeleccionados[x]]), archivosOriginales[indSeleccionados[x]]);
		      archivosOriginalesUndo[indSeleccionados[x]] = archivosOriginales[indSeleccionados[x]];		    
		  }
	      }
	      if (preguntaCancela()) break;
	  }
	  return null;
      }

      @Override
      protected void process(java.util.List<Integer> chunksDes) {
	  jProgreso.setValue(chunksDes.get(chunksDes.size() -1 ));
	  muestraBarra(true,deshacerActual.getName() + " --" + getUndo());
      }

      @Override
      protected void done() {
	  if (!archivosCiclo.isEmpty()) {
	      for(int x=0;x<archivosCiclo.size();x++) {
		  File ficheroCiclo = new File ( archivosCiclo.get(x).getParent() + separador + archivosCiclo.get(x).getName().substring(4) );
		  archivosCiclo.get(x).renameTo(ficheroCiclo);
		  if (archivosCheck.contains(archivosCiclo.get(x)))
		      archivosCheck.set(archivosCheck.indexOf(archivosCiclo.get(x)), ficheroCiclo);
	      }
	  }
	  if (directoriosDeshacer.length > 0) {
              for (File directoriosDeshacer1 : directoriosDeshacer) {
                  deleteDirectory(directoriosDeshacer1);
              }
	  }
	  jProgreso.setValue(0);
	  jProgreso = new JProgressBar();
	  btnPreview.setEnabled(true);
	  btnLimpiar.setEnabled(true);
	  btnActualizar.setEnabled(true);
	  comboSelecAplica.setEnabled(true);
	  m15.setEnabled(true);
	  if (modoDrop) {
	      setDropOriginales(archivosOriginalesUndo);
	      actualizaDespuesDrop();
	  }
	  else {
	      actualizaDespuesAplicar(ruta);
	  }
      }

  }

  class Rehaciendo extends SwingWorker<Void, Integer> {

    @Override
    protected Void doInBackground() throws Exception {
	Boolean siTodo = false;
	Boolean noTodo = false;
        java.util.List<Integer> indicesCiclo;
	java.util.List<Integer> indicesMarcar;
	archivosCiclo = new ArrayList<>();
	mBusca.checkRepetidos(RenombradosUndo, archivosOriginalesUndo, getSistema());
	indicesCiclo = mBusca.getIndicesCiclo();
	indicesMarcar = mBusca.getIndicesMarcar();
        OUTER:
        for (int x = 0; x<indSeleccionados.length; x++) {
            rehacerActual = archivosOriginalesUndo[indSeleccionados[x]];
            publish(x + 1);
            int respuestaRenombra = 0;
            Boolean ciclo = false;
            if (archivosRenombrados[indSeleccionados[x]].getName().startsWith("vRTP")) {
                archivosCiclo.add(archivosRenombrados[indSeleccionados[x]]);
                ciclo = true;
                System.out.println(MessageFormat.format("REDO -- Cycle renaming detected for {0}. Fixed", archivosRenombrados[indSeleccionados[x]].getParent() + separador + archivosRenombrados[indSeleccionados[x]].getName().substring(4)));
            }
            if (indicesCiclo.contains(indSeleccionados[x])) {
                System.out.println(MessageFormat.format("REDO -- Cycle renaming detected for {0}. Fixed", archivosRenombrados[indSeleccionados[x]]));
                File renombrados = new File ( archivosRenombrados[indSeleccionados[x]].getParent() + separador + "vRTP" + archivosRenombrados[indSeleccionados[x]].getName() );
                archivosCiclo.add(renombrados);
                archivosOriginalesUndo[indSeleccionados[x]].renameTo(renombrados);
                if (archivosCheck.contains(archivosOriginalesUndo[indSeleccionados[x]]))
                    archivosCheck.set(archivosCheck.indexOf(archivosOriginalesUndo[indSeleccionados[x]]), renombrados);
                archivosRenombradosUndo[indSeleccionados[x]] = archivosRenombrados[indSeleccionados[x]];
                ciclo = true;
            }
            if (indicesMarcar.contains(indSeleccionados[x]) && ! siTodo) {
                if ( ! noTodo )
                    respuestaRenombra = yaExiste( archivosOriginalesUndo[indSeleccionados[x]].toString(), archivosRenombrados[indSeleccionados[x]].toString() );
                else
                    respuestaRenombra = 2;
            }
            switch (respuestaRenombra) {
                case 1 -> {
                    respuestaRenombra = 0;
                    siTodo = true;
                }
                case 4 -> {
                    respuestaRenombra = 2;
                    noTodo = true;
                }
                case 2 -> {
                    archivosRenombradosUndo[indSeleccionados[x]] = archivosOriginalesUndo[indSeleccionados[x]];
                    continue;
                }
                case 3 -> {
                    for (int n=x;n<indSeleccionados.length;n++) {
                        archivosRenombradosUndo[indSeleccionados[n]] = archivosOriginalesUndo[indSeleccionados[n]];
                    }   break OUTER;
                }
                default -> {
                }
            }
            if ( ! ciclo && respuestaRenombra == 0 ) {
                Boolean estadoAplicar = archivosOriginalesUndo[indSeleccionados[x]].renameTo(archivosRenombrados[indSeleccionados[x]]);
                if (!estadoAplicar) {
                    Boolean creaDir = new File (archivosRenombrados[indSeleccionados[x]].getParent()).mkdirs();
                    if (creaDir) {
                        estadoAplicar = archivosOriginalesUndo[indSeleccionados[x]].renameTo(archivosRenombrados[indSeleccionados[x]]);
                        if (estadoAplicar)
                            if (archivosCheck.contains(archivosOriginalesUndo[indSeleccionados[x]]))
                                archivosCheck.set(archivosCheck.indexOf(archivosOriginalesUndo[indSeleccionados[x]]), archivosRenombrados[indSeleccionados[x]]);
                    }
                } else {
                    if (archivosCheck.contains(archivosOriginalesUndo[indSeleccionados[x]]))
                        archivosCheck.set(archivosCheck.indexOf(archivosOriginalesUndo[indSeleccionados[x]]), archivosRenombrados[indSeleccionados[x]]);
                }
                archivosRenombradosUndo[indSeleccionados[x]] = archivosRenombrados[indSeleccionados[x]];
            }
            if (preguntaCancela()) break;
        }
	return null;
    }

    @Override
    protected void process(java.util.List<Integer> chunksRe) {
	jProgreso.setValue(chunksRe.get(chunksRe.size() -1 ));
	muestraBarra(true,rehacerActual.getName() + " --" + getRedo());
    }

    @Override
    protected void done() {
      if (!archivosCiclo.isEmpty()) {
	  for(int x=0;x<archivosCiclo.size();x++) {
	      File ficheroCiclo = new File ( archivosCiclo.get(x).getParent() + separador + archivosCiclo.get(x).getName().substring(4) );
	      archivosCiclo.get(x).renameTo(ficheroCiclo);
	      if (archivosCheck.contains(archivosCiclo.get(x)))
		  archivosCheck.set(archivosCheck.indexOf(archivosCiclo.get(x)), ficheroCiclo);

	  }
      }
      jProgreso.setValue(0);
      btnPreview.setEnabled(true);
      btnLimpiar.setEnabled(true);
      btnActualizar.setEnabled(true);
      comboSelecAplica.setEnabled(true);
      m15.setEnabled(true);
      if (modoDrop) {
	  setDropOriginales(archivosRenombradosUndo);
	  actualizaDespuesDrop();
      } else {
	  actualizaDespuesAplicar(ruta);
      }
   }

  }

}

class MoverEdit extends AbstractUndoableEdit {

  private int[] indSeleccionados, indSeleccionadosRe;
  private File[] archivosOriginales, archivosRenombrados, directoriosDeshacer;
  private idiomas Idioma;
  private File deshacerActual, rehacerActual;

  public MoverEdit( int[] indSeleccionados, int[] indSeleccionadosRe, File[] archivosOriginales, File[] archivosRenombrados, File[] directoriosDeshacer, idiomas Idioma ) {
     this.indSeleccionados = indSeleccionados;
     this.indSeleccionadosRe = indSeleccionadosRe;
     this.archivosOriginales = archivosOriginales;
     this.archivosRenombrados = archivosRenombrados;
     this.directoriosDeshacer = directoriosDeshacer;
     this.Idioma = Idioma;
//     setDropOriginales(new File[0]);
  }

  @Override
  public void undo() throws CannotUndoException {
      btnAplicar.setEnabled(false);
      btnAplicar.setIcon(aplicarBigBWOk);
      btnPreview.setEnabled(false);
      btnLimpiar.setEnabled(false);
      btnActualizar.setEnabled(false);
      comboSelecAplica.setEnabled(false);
      m15.setEnabled(false);
      m16.setEnabled(false);
      jProgreso.setStringPainted(true);
      jProgreso.setValue(0);
      jProgreso.setMinimum(0);
      jProgreso.setMaximum(indSeleccionados.length);
      muestraBarra(true,Idioma.getBarApply());
      new DeshaciendoMover().execute();
  }

  @Override
  public void redo() throws CannotRedoException {
      btnAplicar.setEnabled(false);
      btnAplicar.setIcon(aplicarBigBWOk);
      btnPreview.setEnabled(false);
      btnLimpiar.setEnabled(false);
      btnActualizar.setEnabled(false);
      comboSelecAplica.setEnabled(false);
      m15.setEnabled(false);
      m16.setEnabled(false);
      jProgreso = new JProgressBar(0,archivosOriginales.length);
      jProgreso.setStringPainted(true);
      muestraBarra(true,Idioma.getBarApply());
      new RehaciendoMover().execute();
  }
  
  @Override
  public boolean canUndo() {
     return true;
  }
           
  @Override
  public boolean canRedo() {
     return true;
  }
  
  @Override
  public String getPresentationName() {
     return Idioma.getUnoMove();
  }

  public boolean deleteDirectory(File path) {
    if( path.exists() ) {
      File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                deleteDirectory(file);
            } else {
                return false;
            }
        }
    }
    return( path.delete() );
  }

  class DeshaciendoMover extends SwingWorker<Void, Integer> {

      @Override
      protected Void doInBackground() throws Exception {
	  Boolean siTodo = false;
	  Boolean noTodo = false;
          OUTER:
          for (int x = 0; x<indSeleccionados.length; x++) {
              deshacerActual = archivosOriginales[indSeleccionados[x]];
              publish(x + 1);
              int respuestaMover = 0;
              File[] listaCheck = new File (archivosOriginales[indSeleccionados[x]].getParent()).listFiles();
              if ( ! siTodo ) {
                  try {
                      for (File listaCheck1 : listaCheck) {
                          if (archivosOriginales[indSeleccionados[x]].getName().equals(listaCheck1.getName())) {
                              if (archivosRenombrados[indSeleccionadosRe[x]].hashCode() != listaCheck1.hashCode()) {
                                  if ( ! noTodo )
                                      respuestaMover = yaExiste( archivosRenombrados[indSeleccionadosRe[x]].toString(), archivosOriginales[indSeleccionados[x]].toString() );
                                  else
                                      respuestaMover = 2;
                              }
                          }
                      }
                  }
                  catch (NullPointerException ne) {
                  }
              }
              switch (respuestaMover) {
                  case 1 -> {
                      respuestaMover = 0;
                      siTodo = true;
                  }
                  case 4 -> {
                      noTodo = true;
                      continue;
                  }
                  case 2 -> {
                      continue;
                  }
                  case 3 -> {
                      break OUTER;
                  }
                  default -> {
                  }
              }
              if ( respuestaMover == 0 ) {
                  int len;
                  try {
                      OutputStream out;
                      try (InputStream in = new FileInputStream(archivosRenombrados[indSeleccionadosRe[x]])) {
                          out = new FileOutputStream(archivosOriginales[indSeleccionados[x]]);
                          byte[] buf = new byte[1024];
                          while ((len = in.read(buf)) > 0){
                              out.write(buf, 0, len);
                          }
                      }
                      out.close();
                      archivosRenombrados[indSeleccionadosRe[x]].delete();
                  }
                  catch (IOException xe) {
                  }
              }
              if (preguntaCancela()) break;
          }

	  return null;
      }

      @Override
      protected void process(java.util.List<Integer> chunksDes) {
	  jProgreso.setValue(chunksDes.get(chunksDes.size() -1 ));
	  muestraBarra(true,deshacerActual.getName() + " --" + getUndo());
      }
                
      @Override
      protected void done() {
	  if (directoriosDeshacer.length > 0) {
	      for(int x=0;x<directoriosDeshacer.length;x++) {
		  deleteDirectory(directoriosDeshacer[x]);
	      }
	  }
	  jProgreso.setValue(0);
	  jProgreso = new JProgressBar();
	  btnPreview.setEnabled(true);
	  btnLimpiar.setEnabled(true);
	  btnActualizar.setEnabled(true);
	  comboSelecAplica.setEnabled(true);
	  m15.setEnabled(true);
	  if (modoDrop) {
	      actualizaDespuesDrop();
	  }
	  else {
	      actualizaDespuesAplicar(ruta);
	  }
      }

  }

  class RehaciendoMover extends SwingWorker<Void, Integer> {

    @Override
    protected Void doInBackground() throws Exception {
	  Boolean siTodo = false;
	  Boolean noTodo = false;
        OUTER:
        for (int x = 0; x<indSeleccionados.length; x++) {
            rehacerActual = archivosOriginales[indSeleccionados[x]];
            publish(x + 1);
            int respuestaMover = 0;
            File[] listaCheck = new File (archivosRenombrados[indSeleccionadosRe[x]].getParent()).listFiles();
            if ( ! siTodo ) {
                try {
                    for (int z=0;z<listaCheck.length;z++) {
                        if (archivosRenombrados[indSeleccionadosRe[x]].getName().equals(listaCheck[z].getName())){
                            if (archivosOriginales[indSeleccionados[x]].hashCode() != listaCheck[z].hashCode()) {
                                if ( ! noTodo )
                                    respuestaMover = yaExiste( archivosOriginales[indSeleccionados[x]].toString(), archivosRenombrados[indSeleccionadosRe[x]].toString() );
                                else
                                    respuestaMover = 2;
                            }
                        }
                    }
                } catch (NullPointerException ne) {
                }
            }
            switch (respuestaMover) {
                case 1 -> {
                    respuestaMover = 0;
                    siTodo = true;
                  }
                case 4 -> {
                    noTodo = true;
                    continue;
                  }
                case 2 -> {
                    continue;
                  }
                case 3 -> {
                    break OUTER;
                  }
                default -> {
                  }
            }
            if ( respuestaMover == 0 ) {
                int len;
                try {
                    OutputStream out;
                    try (InputStream in = new FileInputStream(archivosOriginales[indSeleccionados[x]])) {
                        out = new FileOutputStream(archivosRenombrados[indSeleccionadosRe[x]]);
                        byte[] buf = new byte[1024];
                        while ((len = in.read(buf)) > 0){
                            out.write(buf, 0, len);
                        }
                    }
                    out.close();
                    archivosOriginales[indSeleccionados[x]].delete();
                } catch (IOException xe) {
                    Boolean creaDir = new File (archivosRenombrados[indSeleccionadosRe[x]].getParent()).mkdirs();
                    if (creaDir) {
                        try {
                            OutputStream out;
                            try (InputStream in = new FileInputStream(archivosOriginales[indSeleccionados[x]])) {
                                out = new FileOutputStream(archivosRenombrados[indSeleccionadosRe[x]]);
                                byte[] buf = new byte[1024];
                                while ((len = in.read(buf)) > 0){
                                    out.write(buf, 0, len);
                                }
                            }
                            out.close();
                            archivosOriginales[indSeleccionados[x]].delete();
                        }
                        catch (IOException xee) {
                            System.err.println("Cannot recover " + archivosOriginales[indSeleccionados[x]]);
                        }
                    }
                    else System.err.println("Cannot recover " + archivosOriginales[indSeleccionados[x]]);
                }
            }
            if (preguntaCancela()) break;
        }
	  return null;
    }

    @Override
    protected void process(java.util.List<Integer> chunksRe) {
	jProgreso.setValue(chunksRe.get(chunksRe.size() -1 ));
	muestraBarra(true,rehacerActual.getName() + " --" + getRedo());
    }

    @Override
    protected void done() {
      jProgreso.setValue(0);
      btnPreview.setEnabled(true);
      btnLimpiar.setEnabled(true);
      btnActualizar.setEnabled(true);
      comboSelecAplica.setEnabled(true);
      m15.setEnabled(true);
      if (modoDrop) {
	  compruebaExisten();
	  if (ckCopiaCarpeta.isSelected())
	      pasaCopia();
	  else
	      actualizaDespuesDrop();
      } else {
	  actualizaDespuesAplicar(ruta);
      }
   }

  }

}

class MyDragListener implements DragSourceListener, DragGestureListener {
  JTable list;

  DragSource ds = new DragSource();

  public MyDragListener(JTable list) {
    this.list = list;
    DragGestureRecognizer dgr = ds.createDefaultDragGestureRecognizer(list,
        DnDConstants.ACTION_MOVE, this);

  }

  @Override
  public void dragGestureRecognized(DragGestureEvent dge) {
      StringSelection transferable = new StringSelection(Integer.toString(list.getSelectedRow()));
      try {
	  ds.startDrag(dge, DragSource.DefaultMoveDrop, transferable, this);
            try {
                list.setRowSelectionInterval(okSeleccion[0],okSeleccion[okSeleccion.length -1]);
                for (int i : okSeleccion)
                    listaSeleccion.add(i);
            } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                okSeleccion = list.getSelectedRows();
            }      
          
      } catch (InvalidDnDOperationException | NullPointerException e) {
      }
  }

  @Override
  public void dragEnter(DragSourceDragEvent dsde) {
    try {
        list.setRowSelectionInterval(okSeleccion[0],okSeleccion[okSeleccion.length -1]);
    } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
        okSeleccion = list.getSelectedRows();
    }      
      
  }

  @Override
  public void dragExit(DragSourceEvent dse) {
  }

  @Override
  public void dragOver(DragSourceDragEvent dsde) {
    try {
        list.setRowSelectionInterval(okSeleccion[0],okSeleccion[okSeleccion.length -1]);
    } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
        okSeleccion = list.getSelectedRows();
    }      
  }

  @Override
  public void dragDropEnd(DragSourceDropEvent dsde) {
      listaSeleccion.clear();
  }

  @Override
  public void dropActionChanged(DragSourceDragEvent dsde) {
      
  }
}

class DropTargetBarra implements DropTargetListener {
          BarraRenombra pnl;

        public DropTargetBarra(BarraRenombra pnl) {
            this.pnl = pnl;
        }
        @Override
        public void dragEnter(DropTargetDragEvent dtde) {
        }

        @Override
        public void dragOver(DropTargetDragEvent dtde) {
            DataFlavor[] data = dtde.getCurrentDataFlavors();            
            if (!data[0].isFlavorSerializedObjectType()) {
                dtde.rejectDrag();
                return;
            }
            dtde.acceptDrag(dtde.getDropAction());            
        }

        @Override
        public void dropActionChanged(DropTargetDragEvent dtde) {
            DataFlavor[] data = dtde.getCurrentDataFlavors();            
            if (!data[0].isFlavorSerializedObjectType()) {
                dtde.rejectDrag();
                return;
            }            
            dtde.acceptDrag(dtde.getDropAction());            
        }

        @Override
        public void dragExit(DropTargetEvent dte) {
        }

        @Override
        public void drop(DropTargetDropEvent dtde) {
            Transferable transferable = dtde.getTransferable();   
            DataFlavor[] data = dtde.getCurrentDataFlavors();            
            boolean canImport = (transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor) || transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) && data[0].isFlavorSerializedObjectType();            
            if ( ! canImport ) {
                dtde.rejectDrop();
                return;         
            }
            dtde.acceptDrop(dtde.getDropAction());                        
            int destino = BarraRenombra.getComponenteIndex(pnl);
            pnlBuscaTotal.remove(panelDragged);
            pnlBuscaTotal.add(panelDragged, destino);
            pnlBuscaTotal.updateUI();
            if (automaticPreview) {
                seleccionadosNuevo();
            }
            dtde.dropComplete(true);
        }
    
}    
    public static class ValueExportTransferHandler extends TransferHandler {
        private final String value;

        public ValueExportTransferHandler(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return DnDConstants.ACTION_COPY_OR_MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            Transferable t = new StringSelection(getValue());
            return t;
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            super.exportDone(source, data, action);
        }
    }                


//class ListDropHandler implements DropTargetListener {
//          JTable list;
//
//        public ListDropHandler(JTable list) {
//            this.list = list;
//        }
//        @Override
//        public void dragEnter(DropTargetDragEvent dtde) {
//        }
//
//        @Override
//        public void dragOver(DropTargetDragEvent dtde) {
//        }
//
//        @Override
//        public void dropActionChanged(DropTargetDragEvent dtde) {
//        }
//
//        @Override
//        public void dragExit(DropTargetEvent dte) {
//        }
//
//        @Override
//        public void drop(DropTargetDropEvent dtde) {
//            dtde.acceptDrop(dtde.getDropAction());                        
//            Transferable transferable = dtde.getTransferable();    
//            boolean canImport = transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor) || transferable.isDataFlavorSupported(DataFlavor.stringFlavor);            
//            JTable.DropLocation dl = (JTable.DropLocation) transferable.getDropLocation();
//            if (dl.getRow() == -1) {
//                canImport = false;
//            } else {
//                canImport = true;
//            }
//            
//        }
//    
//}

class MyListDropHandler extends TransferHandler {
  JTable list;

    public MyListDropHandler(JTable list) {
      this.list = list;
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
      if (!support.isDataFlavorSupported(DataFlavor.stringFlavor) && !support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
          return false;
      }

      JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
      return dl.getRow() != -1;
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport support) {
      if (!canImport(support)) {
        return false;
      }
      Transferable transferable = support.getTransferable();
      JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
      int dropTargetIndex = dl.getRow();
      if (support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
          try {
              ficherosImportados = (java.util.List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
              dropExterno(dropTargetIndex, true, true, false);
          } catch (UnsupportedFlavorException | IOException | NullPointerException e) {
              return false;
          }
      } else if (support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
          try {
              String stringImportados = (String) transferable.getTransferData(DataFlavor.stringFlavor);	
              if (stringImportados.startsWith("file:/")) {
                  String[] arrayImportados = stringImportados.split("\n");
                  for (int x=0;x<arrayImportados.length;x++) {
                      if ( ! arrayImportados[x].equals("") ) {
                          ficherosImportados.add(new File(arrayImportados[x].replace("file:","")));
                      }
                  }
                  dropExterno(dropTargetIndex, true, true, false);
                  ficherosImportados = new ArrayList<>();
              } else if (archivosOriginales.length > 0 && listArchivos.getSelectedRows().length > 0) {
                  reordena(dropTargetIndex, okSeleccion, true);
              }
          } catch (UnsupportedFlavorException | IOException | NullPointerException e) {
              return false;
          }
      }
      return true;
    }
  
}

class populateTableMp3 extends SwingWorker<Void, Void> {
    
    @Override
    protected Void doInBackground() throws Exception {
	if (leeDatos) {
	    tablaMp3OriginalesList = new ArrayList<>();
	    tablaMp3TagList = new ArrayList<>();
	    String key = "721a881d82c1531c3eabfe56bf3c9173"; // DEVELOPER: Get your own api key at www.last.fm/api
	    switch (comboEnable.getSelectedIndex()) {
		case 0 -> {
                    for (int x=0; x<archivosOriginales.length; x++) {
                        if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                            tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                            String originalAceptado = archivosOriginales[x].getName();
                            tablaMp3TagList.add(originalAceptado.substring(0, originalAceptado.lastIndexOf('.')));
                        }
                        if (cancelarMp3) {
                            break;
                        }
                    }
                }
		case 1 -> {
                    for (int x=0; x<archivosOriginales.length; x++) {
                        if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                            tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                            tablaMp3TagList.add(new File (archivosOriginales[x].getParent()).getName());
                        }
                        if (cancelarMp3) {
                            break;
                        }
                    }
                }
		case 2 -> {
                    metaMp3 tagArchivo = new metaMp3(Idioma);
                    for (int x=0; x<archivosOriginales.length; x++) {
                        if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                            tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                            tablaMp3TagList.add(tagArchivo.getMp3(archivosOriginales[x].toString(), campoMp3, "0"));
                        }
                        if (cancelarMp3) {
                            break;
                        }
                    }
                }
		case 3 -> {
                    // 		    Caller.getInstance().setDebugMode(true);
                    Caller.getInstance().setUserAgent("vRenamer/" + Version);
                    metaMp3 tagArchivo = new metaMp3(Idioma);
                    switch(indiceConfigMp3Global) {
                        case 0:
                            for (int x=0; x<archivosOriginales.length; x++) {
                                String artist;
                                String track;
                                if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                                    artist = getTagSiguientePopulate(txtArtista, tablaMp3OriginalesList.size());
                                    if (artist.equals("")) {
                                        artist = tagArchivo.getMp3(archivosOriginales[x].toString(), "0", "0");
                                    }
                                    track = getTagSiguientePopulate(txtCancion, tablaMp3OriginalesList.size());
                                    if (track.equals("")) {
                                        track = tagArchivo.getMp3(archivosOriginales[x].toString(), "1", "0");
                                    }
                                    if (artist.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        continue;
                                    } else if (track.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        continue;
                                    } else {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        String pista;
                                        try {
                                            Track esteAlbum = Track.getInfo(artist, track, key);
                                            if (Caller.getInstance().getLastResult().isSuccessful()) {
                                                try {
                                                    pista = esteAlbum.getPosition() +"";
                                                    if (pista.equals("-1")) {
                                                        pista = "";
                                                    }
                                                    tablaMp3TagList.add(pista);
                                                } catch(Exception e) {
                                                    tablaMp3TagList.add("");
                                                }
                                            } else {
                                                tablaMp3TagList.add("");
                                            }
                                        } catch(CallException c) {
                                            tablaMp3TagList.add("");
                                        }
                                    }
                                }
                                if (cancelarMp3) {
                                    break;
                                }
                            }
                            break;
                        case 1:
                            int x = 0;
                            while (x < archivosOriginales.length) {
                                String artist;
                                String album;
                                if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                                    artist = getTagSiguientePopulate(txtArtista, tablaMp3OriginalesList.size());
                                    if (artist.equals("")) {
                                        artist = tagArchivo.getMp3(archivosOriginales[x].toString(), "0", "0");
                                    }
                                    album = getTagSiguientePopulate(txtAlbum, tablaMp3OriginalesList.size());
                                    if (album.equals("")) {
                                        album = tagArchivo.getMp3(archivosOriginales[x].toString(), "3", "0");
                                    }
                                    Track[] pistas;
                                    if (artist.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        x++;
                                        continue;
                                    } else if (album.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        x++;
                                        continue;
                                    } else {
                                        java.util.Collection<Track> tracks;
                                        try {
                                            Album esteAlbum = Album.getInfo(artist, album, key);
                                            if (Caller.getInstance().getLastResult().isSuccessful()){
                                                tracks = esteAlbum.getTracks();
                                            } else {
                                                tracks = null;
                                            }
                                        } catch(CallException c) {
                                            tracks = null;
                                        } catch(Exception e) {
                                            tracks = null;
                                        }
                                        if (tracks == null || tracks.isEmpty()) {
                                            pistas = new Track[0];
                                            tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                            tablaMp3TagList.add("");
                                            x++;
                                        } else {
                                            pistas = new Track[tracks.size()];
                                            int z = 0;
                                            for (Track track : tracks) {
                                                pistas[z] = track;
                                                z++;
                                            }
                                        }
                                        for (int y=0; y<pistas.length; y++) {
                                            if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                                                String albumCompara = getTagSiguientePopulate(txtAlbum, tablaMp3OriginalesList.size());
                                                if (albumCompara.equals("")) {
                                                    albumCompara = tagArchivo.getMp3(archivosOriginales[x].toString(), "3", "0");
                                                }
                                                if (albumCompara.equals(album)) {
                                                    tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                                    String pistaTagString = getTagSiguientePopulate(txtPista, tablaMp3TagList.size());
                                                    if (pistaTagString.equals("")) {
                                                        pistaTagString = tagArchivo.getMp3(archivosOriginales[x].toString(), "2", "0");
                                                    }
                                                    if (pistaTagString.matches("^[0-9]+$")) {
                                                        int p = Integer.parseInt(pistaTagString);
                                                        if (p <= pistas.length && p > 0) {
                                                            tablaMp3TagList.add(pistas[p-1].getName());
                                                            x++;
                                                        } else {
                                                            tablaMp3TagList.add(pistas[y].getName());
                                                            x++;
                                                        }
                                                    } else {
                                                        tablaMp3TagList.add(pistas[y].getName());
                                                        x++;
                                                    }
                                                    if (x >= archivosOriginales.length) break;
                                                } else {
                                                    break;
                                                }
                                            }
                                            if (x >= archivosOriginales.length) break;
                                            if (cancelarMp3) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    x++;
                                }
                                if (cancelarMp3) {
                                    break;
                                }
                            }
                            break;
                        case 2:
                            for (x=0; x<archivosOriginales.length; x++) {
                                String album;
                                if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                                    album = getTagSiguientePopulate(txtAlbum, tablaMp3OriginalesList.size());
                                    if (album.equals("")) {
                                        album = tagArchivo.getMp3(archivosOriginales[x].toString(), "3", "0");
                                    }
                                    String artist;
                                    if (album.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        continue;
                                    } else {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        java.util.Collection<Album> Albumes;
                                        try {
                                            Albumes = Album.search(album, key);
                                            if (Caller.getInstance().getLastResult().isSuccessful()){
                                                try {
                                                    Album albumLast = Albumes.iterator().next();
                                                    artist = albumLast.getArtist();
                                                    if (Caller.getInstance().getLastResult().isSuccessful()){
                                                        tablaMp3TagList.add(artist);
                                                    } else {
                                                        tablaMp3TagList.add("");
                                                    }
                                                } catch(CallException c) {
                                                    tablaMp3TagList.add("");
                                                } catch (Exception e) {
                                                    tablaMp3TagList.add("");
                                                }
                                            } else {
                                                tablaMp3TagList.add("");
                                            }
                                        } catch(CallException c) {
                                            tablaMp3TagList.add("");
                                        } catch (Exception e) {
                                            tablaMp3TagList.add("");
                                        }
                                    }
                                }
                                if (cancelarMp3) {
                                    break;
                                }
                            }
                            break;
                        case 3:
                            for (x=0; x<archivosOriginales.length; x++) {
                                String artist;
                                String track;
                                if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                                    artist = getTagSiguientePopulate(txtArtista, tablaMp3OriginalesList.size());
                                    if (artist.equals("")) {
                                        artist = tagArchivo.getMp3(archivosOriginales[x].toString(), "0", "0");
                                    }
                                    track = getTagSiguientePopulate(txtCancion, tablaMp3OriginalesList.size());
                                    if (track.equals("")) {
                                        track = tagArchivo.getMp3(archivosOriginales[x].toString(), "1", "0");
                                    }
                                    if (artist.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        continue;
                                    } else if (track.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        continue;
                                    } else {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        String album;
                                        try {
                                            Track estaPista = Track.getInfo(artist, track, key);
                                            if (Caller.getInstance().getLastResult().isSuccessful()){
                                                try {
                                                    album = estaPista.getAlbum();
                                                    if (album.equals("null")) {
                                                        album = "";
                                                    }
                                                    tablaMp3TagList.add(album);
                                                } catch(Exception e) {
                                                    tablaMp3TagList.add("");
                                                }
                                            } else {
                                                tablaMp3TagList.add("");
                                            }
                                        } catch(CallException c) {
                                            tablaMp3TagList.add("");
                                        }
                                    }
                                }
                                if (cancelarMp3) {
                                    break;
                                }
                            }
                            break;
                        case 4:
                            for (x=0; x<archivosOriginales.length; x++) {
                                String artist;
                                String album;
                                if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                                    artist = getTagSiguientePopulate(txtArtista, tablaMp3OriginalesList.size());
                                    if (artist.equals("")) {
                                        artist = tagArchivo.getMp3(archivosOriginales[x].toString(), "0", "0");
                                    }
                                    album = getTagSiguientePopulate(txtAlbum, tablaMp3OriginalesList.size());
                                    if (album.equals("")) {
                                        album = tagArchivo.getMp3(archivosOriginales[x].toString(), "3", "0");
                                    }
                                    if (artist.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        continue;
                                    } else if (album.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        continue;
                                    } else {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        Date fecha;
                                        try {
                                            Album esteAlbum = Album.getInfo(artist, album, key);
                                            if (Caller.getInstance().getLastResult().isSuccessful()){
                                                try {
                                                    fecha = esteAlbum.getReleaseDate();
                                                    SimpleDateFormat df = new SimpleDateFormat("yyyy");
                                                    tablaMp3TagList.add(df.format(fecha));
                                                } catch(Exception e) {
                                                    tablaMp3TagList.add("");
                                                }
                                            } else {
                                                tablaMp3TagList.add("");
                                            }
                                        } catch(CallException c) {
                                            tablaMp3TagList.add("");
                                        }
                                    }
                                }
                                if (cancelarMp3) {
                                    break;
                                }
                            }
                            break;
                        case 5:
                            for (x=0; x<archivosOriginales.length; x++) {
                                String artist;
                                if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
                                    artist = getTagSiguientePopulate(txtArtista, tablaMp3OriginalesList.size());
                                    if (artist.equals("")) {
                                        artist = tagArchivo.getMp3(archivosOriginales[x].toString(), "0", "0");
                                    }
                                    if (artist.equals("")) {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        tablaMp3TagList.add("");
                                        continue;
                                    } else {
                                        tablaMp3OriginalesList.add(archivosOriginales[x].getName());
                                        java.util.Collection<Tag> Tags;
                                        try {
                                            Tags = de.umass.lastfm.Artist.getTopTags(artist, key);
                                            if (Caller.getInstance().getLastResult().isSuccessful()){
                                                tablaMp3TagList.add(Tags.iterator().next().getName());
                                            } else {
                                                tablaMp3TagList.add("");
                                            }
                                        } catch(CallException c) {
                                            tablaMp3TagList.add("");
                                        } catch(Exception e) {
                                            tablaMp3TagList.add("");
                                        }
                                    }
                                }
                                if (cancelarMp3) {
                                    break;
                                }
                            }
                            break;
                    }
                }
	    }
	}

	return null;
    }

    @Override
    protected void done() {
      if (arrayTablaMp3 == null) {
	  arrayTablaMp3 = new String[6][tablaMp3OriginalesList.size()];
      }
      if (leeDatos) {
	  if (cancelarMp3) {
	      tablaMp3OriginalesList = new ArrayList<>();
	      tablaMp3TagList = new ArrayList<>();
	      arrayTablaMp3[indiceConfigMp3Global][0] = null;
	      for (int x=0; x<archivosOriginales.length; x++) {
		  if (archivosOriginales[x].isFile() && checkAudio(archivosOriginales[x].toString())) {
		      tablaMp3OriginalesList.add(archivosOriginales[x].getName());
		      tablaMp3TagList.add("");
		  }
	      }

	  }
	  tablaMp3Originales = new String[tablaMp3OriginalesList.size()][2];
	  nombreColumnasMp3[1] = Idioma.getTagFor() + " " + txtTextoGlobal.getName();
	  tablaMp3Model = new DefaultTableModel (tablaMp3Originales, nombreColumnasMp3);
  	  tablaMp3.setModel(tablaMp3Model);
 	  tablaMp3.getColumnModel().getColumn(0).setCellRenderer(new MyCellTablaMp3NoEdit());
/*	  TableRowSorter sorter = new TableRowSorter(tablaMp3Model);
	  tablaMp3.setRowSorter(sorter);*/
      }
      if (arrayTablaMp3[indiceConfigMp3Global].length > 0) {
	  if (arrayTablaMp3[indiceConfigMp3Global][0] == null || leeDatos) {
	      for (int x=0; x<tablaMp3OriginalesList.size(); x++) {
		  tablaMp3Originales[x][0] = tablaMp3OriginalesList.get(x);
		  tablaMp3Model.setValueAt(tablaMp3Originales[x][0], x, 0);
		  tablaMp3Originales[x][1] = tablaMp3TagList.get(x);
		  tablaMp3Model.setValueAt(tablaMp3Originales[x][1], x, 1);
	      }
	  } else {
	      if (arrayTablaMp3[indiceConfigMp3Global][0] != null) {
		  for (int x=0; x<tablaMp3Originales.length; x++) {
		      tablaMp3Originales[x][0] = tablaMp3OriginalesList.get(x);
		      tablaMp3Model.setValueAt(tablaMp3Originales[x][0], x, 0);
		      tablaMp3Originales[x][1] = arrayTablaMp3[indiceConfigMp3Global][x];
		      tablaMp3Model.setValueAt(tablaMp3Originales[x][1], x, 1);
		  }
	      }
	  }
      } else {
	  tablaMp3Originales = new String[0][2];
      }
      arrayTablaRecoge = new String[arrayTablaMp3[indiceConfigMp3Global].length];
      for (int x=0;x<arrayTablaRecoge.length;x++) {
	  arrayTablaRecoge[x] = "" + tablaMp3Model.getValueAt(x,1);
      }
      if (leeDatos) {
	  recogeConfigMp3();
      }
      leeDatos = false;
      pnlDialgMp3Sur.removeAll();
      if (comboEnable.getSelectedIndex() == 3) {
	  pnlDialgMp3Sur.add(btnLast, "West");
      }
      pnlDialgMp3Sur.updateUI();
      if (ckEnable.isSelected()) {
	  pnlCkEnable.setEnabled(true);
      } 
    }
}

class checkeaVersionWorker extends SwingWorker<Void, Void> {
    String textVersion;

    @Override
    protected Void doInBackground() throws Exception {
	try {
	    String webname = "https://vrenamer.com/version/";
	    URL web = new URL(webname);
	    URLConnection url = web.openConnection();
	    url.setUseCaches(false);
            StringBuilder builder;
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(url.getInputStream(), "UTF8"))) {
                builder = new StringBuilder();
                int byteRead;
                while ((byteRead = buffer.read()) != -1) {
                    builder.append((char) byteRead);
                }
            }
	    textVersion = builder.toString();
	    int indiceVersion = textVersion.indexOf("<meta name=\"description\" content=");
	    textVersion = textVersion.substring(indiceVersion+34, indiceVersion+39).replaceAll("[^0-9]","");
	} catch (IOException e) {
	    textVersion = "";
	}
	return null;
    }

    @Override
    protected void done() {
	jProgreso.setIndeterminate(false);
	jProgreso.setStringPainted(true);
	muestraInfo(false,false);
	if ( ! textVersion.equals("") ) {
	    int versionNueva = Integer.parseInt(textVersion);
	    int versionActual = Integer.parseInt(Version.replaceAll("[^0-9]",""));
	    if (versionNueva > versionActual) {
		JOptionPane optionVersion = new JOptionPane();
		String versionNuevaPuntos = textVersion.replaceAll("([0-9])([0-9])([0-9]+)","$1"+"."+"$2"+"."+"$3");
		optionVersion.setMessage(Idioma.getVersionAvailable() + versionNuevaPuntos);
		optionVersion.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JButton botonDescargar = getButtonOption(optionVersion, Idioma.getVersionDownload(), aplicarOk);
		JButton botonDismiss = getButtonOption(optionVersion, Idioma.getVersionDismiss(), cancelOk);
		JCheckBox checkNever = new JCheckBox(Idioma.getVersionNever());
		setFont(checkNever, 9, Font.PLAIN);
		optionVersion.setOptions(new Object[] { botonDescargar, botonDismiss, checkNever });
		optionVersion.setInitialValue(botonDescargar);
		optionVersion.setIcon(infoOk);
		JDialog dialogVersion = optionVersion.createDialog(pnlPrincipal, Idioma.getVersion());
		dialogVersion.setVisible(true);
		if (optionVersion.getValue() != null) {
		    if (optionVersion.getValue().equals(Idioma.getVersionDownload())) {
			try {
			    Desktop.getDesktop().browse(new URI ("https://vrenamer.com/download/") );
			} catch (URISyntaxException | IOException z) {
			    System.err.println("vRenamer couldn't open download page");
			}
		    } else if (optionVersion.getValue().equals(Idioma.getVersionDismiss())) {
			System.out.println("Declined");
		    }
		    if (checkNever.isSelected() && optionVersion.getValue().equals(Idioma.getVersionDismiss())) {
			prefs.put(prefVersion, "false" + "," + Version.replace(".",""));	      
		    }
		} else {
		    System.out.println("Declined");
		}
	    } else {
		System.out.println("vRenamer is up to date");
	    }
	} else {
	    System.err.println("vRenamer couldn't check new version");
	}
    }
}


class reordenaAutoWorker extends SwingWorker<Void, Void> {
    Boolean reordenaOk;

    @Override
    protected Void doInBackground() throws Exception {
	tomaTodos();
	reordenaOk = oArchivos.reordenaAuto(archivosOriginales, okSeleccion, ckCopiaCarpeta.isSelected(), opcionOrdena, posicion, Idioma);
	if (reordenaOk) {
	    Archivos = oArchivos.getArchReordenados();
	    Renombrados = oArchivos.getRenomReordenados();
	    archivosOriginales = oArchivos.getAbstractFiltrado();
	    regeneraCheck();
	    panelModelo();
	}
	return null;
    }

    @Override
    protected void done() {
	setCursor(new Cursor(Cursor.WAIT_CURSOR));
	if (reordenaOk) {
	    setPanelArchivos();
	    listArchivos.setModel(listArchivosModel);
	    if (!ckCopiaCarpeta.isSelected()) {
		RenombradosCopia = Arrays.copyOf(Archivos,Renombrados.length);
		reseteaRenombrados = false;
		modeloRenombrados();
		panelRenombrados();
	    }
	    if (automaticPreview) {
		primero = false;
		seleccionadosNuevo();
		primero = true;
	    }
	    posicion = 1;
	} else {
	    ckRecursivo.setSelected(false);
	    navega(ruta);
	}
	jProgreso.setIndeterminate(false);
	jProgreso.setStringPainted(true);
	muestraInfo(false,false);
	SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	      
	    }
	});
    }
}

class cargaImagen extends SwingWorker<Void, Void> {

    @Override  
    protected Void doInBackground() throws Exception {
	newimg = null;
	try {
	    rotacion = 0;
	    if (mBusca.endsWithIgnoreCase(fotoArchivo.toString(),".jpg") || mBusca.endsWithIgnoreCase(fotoArchivo.toString(),".jpeg") ) {
		rotacion = Integer.parseInt(mBusca.getCamara(fotoArchivo.toString(),"11"));
	    }
	} catch (NumberFormatException io) {
	    System.err.println("Image not accesible. Maybe permission problems");
	}

	if (fotoArchivo.length() < 524288) {
	    fotoImagen = getReader(1);
	} else {
	    fotoImagen = getReader(25);
	}
	if (anchuraP > 1900) {
	    newimg = Thumbnails.of(fotoImagen)
		.size(90, 90)
		.rotate(rotacion)
		.asBufferedImage();
	} else {
	    newimg = Thumbnails.of(fotoImagen)
		.size(60, 60)
		.rotate(rotacion)
		.asBufferedImage();
	}
	return null;
    }

    @Override
    protected void done() {
	if ( newimg != null ) {
	    try {
		pnlInfoImagen.removeAll();
		pnlInfoImagen.setBorder(BorderFactory.createLineBorder(Color.red));
		JButton btnImage = new JButton(new ImageIcon(newimg)) {
                    @Override
                    protected void processMouseEvent(MouseEvent e) {
			super.processMouseEvent(e);
			if (e.getID() == MouseEvent.MOUSE_ENTERED) {
			    this.setContentAreaFilled(true);
			    this.setBackground(Color.PINK);
			}
			if (e.getID() == MouseEvent.MOUSE_EXITED) {
			    this.setContentAreaFilled(false);
			}
		    }
		};
		btnImage.setName("labelImage");
		btnImage.setBorder(null);
		btnImage.setOpaque(false);
		btnImage.setContentAreaFilled(false);
		if (anchuraP > 1900) {
		    btnImage.setPreferredSize(new Dimension(90,90));
	      	} else {
		    btnImage.setPreferredSize(new Dimension(60,60));
		}
		btnImage.addActionListener(cc);
		pnlInfoImagen.add(btnImage,"Center");

		pnlInfoLeft.updateUI();
		labelImage = null;
		pnlInfoDatos = null;
	    } catch (NullPointerException ne) {
		System.err.println("User seems to be impatient. Trying to show last image clicked");
		muestraInfo(false,true);
	    }
	} else {
		System.err.println("Image format not supported or damaged");
		pnlInfoImagen.removeAll();
		pnlInfoImagen.setBorder(BorderFactory.createLineBorder(Color.red));
		pnlInfoImagen.add(new JLabel(imageWarningOk),"Center");
		pnlInfoImagen.updateUI();
	}
    }

}

class cargaImagenMarco extends SwingWorker<Void, Void> {

    @Override
      protected Void doInBackground() throws Exception {
	newimg = null;
	try {
	    if (fotoArchivo.length() < 1048576) fotoImagen = getReader(1);
	    else fotoImagen = getReader(2);
	    alturaImagen = fotoImagen.getHeight();
	    anchuraImagen = fotoImagen.getWidth();
	    GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice devicel = g.getDefaultScreenDevice();
	    int alturaPantalla = devicel.getDisplayMode().getHeight() -200;
	    int anchuraPantalla = devicel.getDisplayMode().getWidth() -600;

	    if ( rotacion != 0 ) {
		alturaImagen = fotoImagen.getWidth();
		anchuraImagen = fotoImagen.getHeight();
	    }
	    if (  ( anchuraImagen  >= alturaImagen ) && (anchuraImagen > anchuraPantalla) ) {
		float nuevaAnchuraImagen =  anchuraPantalla;
		float widthRatio = nuevaAnchuraImagen * 100 / (float) anchuraImagen;
		anchuraImagen = (int) nuevaAnchuraImagen;
		float nuevaAlturaImagen = widthRatio * alturaImagen / 100 ;
		alturaImagen = (int) nuevaAlturaImagen;
	    } else if ( ( alturaImagen >= anchuraImagen ) && (alturaImagen > alturaPantalla) ) {
		float nuevaAlturaImagen =  alturaPantalla;
		float heightRatio = nuevaAlturaImagen * 100 / (float) alturaImagen;
		alturaImagen = (int) nuevaAlturaImagen;
		float nuevaAnchuraImagen = heightRatio * anchuraImagen / 100 ;
		anchuraImagen = (int) nuevaAnchuraImagen;
	    }
	    newimg = Thumbnails.of(fotoImagen)
		.size(anchuraImagen, alturaImagen)
		.watermark(Positions.BOTTOM_RIGHT, vrlogoBuff, 0.5f)
		.rotate(rotacion)
		.asBufferedImage();
	} catch (HeadlessException | IOException io) {
	}
	return null;
    }

    @Override
    protected void done() {
	try {
	    if ( DialogFotoPrevio != null ) {
		JLabel imageBig = new JLabel(new ImageIcon(newimg));
		JPanel jMuestraFoto = new JPanel(new BorderLayout(1, 1));
		jMuestraFoto.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(fotoArchivoActual.getName()),new EmptyBorder(10,10,10,10)));
		DialogFoto = new JDialog(DialogFotoPrevio, "vRenamer", false);
		DialogFoto.addMouseListener(new MouseAdapter() {
                    @Override
		    public void mouseClicked(MouseEvent e) {
			JDialog dPicture = (JDialog) e.getSource();
			dPicture.dispose();
		    }
		});
		DialogFoto.setUndecorated(true);
		DialogFoto.setName("dialogo foto");
		DialogFoto.addFocusListener(cc);
		
		DialogFotoPrevio.dispose();

		jMuestraFoto.add(imageBig, "Center");

		DialogFoto.add(jMuestraFoto);    
		DialogFoto.setSize(anchuraImagen + 40,alturaImagen + 40);
		DialogFoto.setLocationRelativeTo(DialogFotoPrevio);
		DialogFoto.setVisible(true);
		newimg = null;
	    }
	} catch (NullPointerException ne) {
	    System.err.println("Too many picture instances. Can't handle them");
	}
    }
}


class Blink extends SwingWorker<Void, Integer> {
  
  @Override
  protected Void doInBackground() throws Exception {
      Thread.sleep(200);
      publish(0);
      Thread.sleep(200);      
      publish(1);
      Thread.sleep(200);      
      publish(0);
      Thread.sleep(200);      
      return null;
  }

  @Override
  protected void process(java.util.List<Integer> chunksBl) {
      switch (chunksBl.get(chunksBl.size() -1 )) {
	  case 0 -> {
              btnAplicar.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
          }
	  case 1 -> {
              btnAplicar.setBorder(BorderFactory.createLineBorder(Color.RED, 1));              
          }
      }
  }
   
  @Override
   protected void done() {
        btnAplicar.setBorder(BorderFactory.createLineBorder(Color.RED, 1));              
   }
}

class Navegando extends SwingWorker<Void, Void> {
  
  @Override
  protected Void doInBackground() throws Exception {
      fotoArchivo = new File (ruta);
      Archivos = new StringBuffer[0];
      Renombrados = new StringBuffer[0];
      archivosOriginales = new File[0];
      archivosRenombrados = new File[0];
      tomaFicheros(filtrado, m42.isSelected(), ckCase.isSelected(), ckExcluye.isSelected(), ckRecursivo.isSelected(), Idioma);
      return null;
  }
   
  @Override
   protected void done() {
	btnLimpiar.setEnabled(true);
	okSeleccion = new int[0];
	jProgreso.setIndeterminate(false);
	jProgreso.setStringPainted(true);
	if (Archivos.length > 1 && !Archivos[1].toString().equals("busquedaCancelada")) {
	    if (oArchivos.getCuentaArchivos() > 10000) {
		autoDespuesReset = automaticPreview;
		automaticPreview = false;
	    } else 
                automaticPreview = autoDespuesReset;
	    comienzaCarga();
	} else {
	    jProgreso.setIndeterminate(false);
	    jProgreso.setStringPainted(true);
	    atributos();
	    ckRecursivo.setSelected(false);
	    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	    actualizaDespuesAplicar(ruta);
	}
	jCancel.setEnabled(true);
   }

}

class Cargando extends SwingWorker<Void, Void> {
   
  @Override
  protected Void doInBackground() throws Exception {
      eligeSeleccionCheck();
      panelModelo();
      return null;
  }
   
  @Override
  protected void done() {
      setPanelArchivos();
      listArchivos.setModel(listArchivosModel);
      if (!ckCopiaCarpeta.isSelected()) {
	rutaRenombrados=ruta;
	tomaRenombrados();
	modeloRenombrados();
	renombrados();
      }
      muestraInfo(false, false);
      atributos();
      actualizaNavegador();
      jProgreso.setIndeterminate(false);
      jProgreso.setStringPainted(true);

      Runnable doScroll = new Runnable() {
        @Override
	public void run() {
	  if (cambiaFoco) {
	      cambiaFoco();
	      cambiaFoco = false;
	  }
	  setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	      
	}
      };
      SwingUtilities.invokeLater(doScroll);
      if (automaticPreview) {
	  primero = false;
	  seleccionadosNuevo();
	  primero = true;
      }
   }	
}

class Filtrando extends SwingWorker<Void, Void> {
  
  @Override
  protected Void doInBackground() throws Exception {
      noPasarFiltro = true;
      try {
	  Thread.sleep(1000);
      }
      catch(InterruptedException e){
      }
      return null;
  }
   
  @Override
   protected void done() {
      filtrado = jFiltro.getText();
      if (filtrado.equals(" ")) {
	  filtrado = "";
	  jFiltro.setText("");
      }
  //	      if (filtrado.equals("") && ckRecursivo.isSelected()) ckRecursivo.setSelected(false);
      reseteaRenombrados = true;
      navega(ruta);
      noPasarFiltro = false;
   }

}

class ActualizaMp3 extends SwingWorker<Void, Void> {
  
  @Override
  protected Void doInBackground() throws Exception {
      tagMp3Pista = mBusca.insertaMp3(okSeleccion,archivosOriginales,"2");
      tagMp3Artista = mBusca.insertaMp3(okSeleccion,archivosOriginales,"0");
      tagMp3Cancion = mBusca.insertaMp3(okSeleccion,archivosOriginales,"1");
      tagMp3Album = mBusca.insertaMp3(okSeleccion,archivosOriginales,"3");
      tagMp3Anyo = mBusca.insertaMp3(okSeleccion,archivosOriginales,"4");
      tagMp3Genero = mBusca.insertaMp3(okSeleccion,archivosOriginales,"5");
      return null;
  }
   
  @Override
  protected void done() {
      pistaInfo.setText(tagMp3Pista);
      artistaInfo.setText(tagMp3Artista);
      cancionInfo.setText(tagMp3Cancion);
      albumInfo.setText(tagMp3Album);
      anyoInfo.setText(tagMp3Anyo);
      generoInfo.setText(tagMp3Genero);
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      jProgreso.setIndeterminate(false);
      jProgreso.setStringPainted(true);
      muestraInfo(false, true);
   }

}

class EscribeMp3 extends SwingWorker<Void, Void> {
    @Override  
    protected Void doInBackground() throws Exception {
	Boolean incPista = false;
	String[] pista = mBusca.insertaMp3Array(okSeleccion,archivosOriginales,"2");
	String[] cancion = mBusca.insertaMp3Array(okSeleccion,archivosOriginales,"1");
	String[] artista = mBusca.insertaMp3Array(okSeleccion,archivosOriginales,"0");
	String[] album = mBusca.insertaMp3Array(okSeleccion,archivosOriginales,"3");
	String[] anyo = mBusca.insertaMp3Array(okSeleccion,archivosOriginales,"4");
	String[] genero = mBusca.insertaMp3Array(okSeleccion,archivosOriginales,"5");
	String[] pistaSiguiente = getTagSiguiente(txtPista);
	String[] cancionSiguiente = getTagSiguiente(txtCancion);
	String[] artistaSiguiente = getTagSiguiente(txtArtista);
	String[] albumSiguiente = getTagSiguiente(txtAlbum);
	String[] anyoSiguiente = getTagSiguiente(txtAnyo);
	String[] generoSiguiente = getTagSiguiente(txtGenero);
	if (ckPista.isSelected() && txtPista.isEnabled()) {
	    incPista = true;
	}
	edit = new mp3Edit(okSeleccion, archivosOriginales, incPista, pistaSiguiente, cancionSiguiente, artistaSiguiente, albumSiguiente, anyoSiguiente, generoSiguiente, pista, cancion, artista, album, anyo, genero, Idioma);
	mBusca.ponMp3(okSeleccion, archivosOriginales, incPista, pistaSiguiente, cancionSiguiente, artistaSiguiente, albumSiguiente, anyoSiguiente, generoSiguiente, pista, cancion, artista, album, anyo, genero, vrenamerFolder);
	undoSupport_.postEdit( edit );
	okSeleccion=new int[0];
	actualizaMp3();
	return null;
    }

    @Override   
    protected void done() {
    }

}

class ConmutaEspera extends SwingWorker<Void, Void> {

  @Override
  protected Void doInBackground() throws Exception {
      try {
	Thread.sleep(500);
      }
      catch(InterruptedException e){
      }
      return null;
  }
   
  @Override
   protected void done() {
      conmutaSeparadores();
      if (automaticPreview) {
	  seleccionadosNuevo();
      }
   }

}

class Aplicado extends SwingWorker<Void, Integer> {
  
  @Override
  protected Void doInBackground() throws Exception {
	directoriosCreados = new ArrayList<>();
	directoriosProvisionalCreados = new ArrayList<>();
	archivosCiclo = new ArrayList<>();
	indicesMarcar = mBusca.getIndicesMarcar();
	indicesCiclo = mBusca.getIndicesCiclo();
	if (comboCarpeta.getSelectedIndex() == 1) {
	    archivosRenombradosMover = new File[Renombrados.length];
	}
	rutaRe = rutaRenombrados;
	Boolean siTodo = false;
        Boolean noTodo = false;
	PrintWriter pwLog = null;
	if (!ckCopiaCarpeta.isSelected()) {
	    operacionAplicada = Idioma.getMainRenamed();
	}
	else {
	    operacionAplicada = Idioma.getMainCopied();
	}
	try {
	    String logName = mBusca.getLogName(vrenamerFolder);
	    if ( ! new File (rutaHome + separador + vrenamerFolder + separador + logName).exists() ) {
//		pwLog = new PrintStream(new FileOutputStream(rutaHome + separador + vrenamerFolder + separador + logName), true, "UTF-8");
		pwLog = new PrintWriter(new OutputStreamWriter(new FileOutputStream(rutaHome + separador + vrenamerFolder + separador + logName), "UTF-8"));

	    } else {
//		pwLog = new PrintStream(new FileOutputStream(rutaHome + separador + vrenamerFolder + separador + logName, true));
		pwLog = new PrintWriter(new OutputStreamWriter(new FileOutputStream(rutaHome + separador + vrenamerFolder + separador + logName, true), "UTF-8"));
	    }
	    if (ckCopiaCarpeta.isSelected()) {
		if (comboCarpeta.getSelectedIndex() == 0) {
		    pwLog.println("Start Copy Date: " + mBusca.getFecha() + "  " + mBusca.getHora());
		} else {
		    pwLog.println("Start Move Date: " + mBusca.getFecha() + "  " + mBusca.getHora());
		}
	    } else {
		pwLog.println("Start Rename Date: " + mBusca.getFecha() + "  " + mBusca.getHora());
	    }
	} catch (FileNotFoundException | UnsupportedEncodingException e) {
	} 
	for (int ex=0;ex<indSeleccionados.length;ex++) {
	    publish(ex + 1);
	    Boolean ciclo = false;
	    Boolean creaDir = false;
	    Boolean existeCopiarLinux = false;
	    Boolean exitoCopia = true;
            respuestaOpcion = 0;
            cancelarCopia = false;
	    if (copia) { //copiar
	      String rutaCrear;
	      Boolean creaRuta = false;
	      if (new File (FicherosComp[indSeleccionadosRe[ex]].toString()).getParent() != null) {
		  creaRuta = true;
	      }
	      if (modoLog)
		  rutaRe = archivosRenombradosAplicar[indSeleccionadosRe[ex]].getParent() + separador;
	      mArchivoDest = new File(rutaRe + listRenombradosModel.getValueAt(indSeleccionadosRe[ex], 0));
	      rutaCrear = new File (FicherosComp[indSeleccionadosRe[ex]].toString()).getParent();
	      if (creaRuta) {
		  rutaCrear = rutaCrear.replaceAll(":","");
		  rutaCrear = rutaCrear.replaceAll("\\*","");
		  rutaCrear = rutaCrear.replaceAll("\\?","");
		  rutaCrear = rutaCrear.replaceAll("\\¿","");
		  rutaCrear = rutaCrear.replaceAll("\\\"","");
		  rutaCrear = rutaCrear.replaceAll("<","");
		  rutaCrear = rutaCrear.replaceAll(">","");
		  rutaCrear = rutaCrear.replaceAll("\\|","");
		  mArchivoDest = new File(rutaRe + rutaCrear + listRenombradosModel.getValueAt(indSeleccionadosRe[ex], 0).toString().substring(listRenombradosModel.getValueAt(indSeleccionadosRe[ex], 0).toString().lastIndexOf(separador)));
	      }

	      if (comboCarpeta.getSelectedIndex() == 1) {
		  archivosRenombradosMover[indSeleccionadosRe[ex]] = mArchivoDest;
	      }
	      /** COMPRUEBA SI EXISTE
	      *
	      */
	      File[] listaCheck = new File (mArchivoDest.getParent()).listFiles();
	      if ( ! siTodo ) {
		  try {
		      for (int z=0;z<listaCheck.length;z++) {
			  if (mArchivoDest.getName().equals(listaCheck[z].getName())) {
			      existeCopiarLinux = true;
                              if ( ! noTodo )
                                  respuestaOpcion = yaExiste(archivosOriginalesAplicar[indSeleccionados[ex]].toString(), mArchivoDest.toString());
                              else
                                  respuestaOpcion = 2;
                          }
		      }
		  }
		  catch (NullPointerException ne) {
		  }
		  if ( ! existeCopiarLinux && mArchivoDest.exists() ) 
                      yaExiste(archivosOriginalesAplicar[indSeleccionados[ex]].toString(), mArchivoDest.toString());
	      }
	      /**
	      *
	      */

	      if (respuestaOpcion == 1) {
		  siTodo = true;
		  respuestaOpcion = 0;
              } else if (respuestaOpcion == 4) {
                  noTodo = true;
                  respuestaOpcion = 2;
	      } 
	      if (respuestaOpcion == 0) {
		int len;
		try {
                    OutputStream out;
                    try (InputStream in = new FileInputStream(archivosOriginalesAplicar[indSeleccionados[ex]])) {
                        out = new FileOutputStream(mArchivoDest);
                        byte[] buf = new byte[1024];
                        while ((len = in.read(buf)) > 0){
                          out.write(buf, 0, len);
                        }
                    }
		    out.close();
		    if (comboCarpeta.getSelectedIndex() == 1) {
			archivosOriginalesAplicar[indSeleccionados[ex]].delete();
		    }
		    try {
			pwLog.println(archivosOriginalesAplicar[indSeleccionados[ex]] + "-->" + mArchivoDest);
		    } catch (Exception e) {
		    } 
		} catch (IOException e) {
		      Boolean existeDir = new File (rutaRe + rutaCrear).exists();
		      if (!existeDir && rutaCrear != null) {
			  File directorioNo = new File (rutaRe + rutaCrear);
			  while (!existeDir){
			      directoriosProvisionalCreados.add(directorioNo);
			      existeDir = new File (directorioNo.getParent()).exists();
			      if (!existeDir) directorioNo = new File (directorioNo.getParent());
			  }
			  creaDir = new File (rutaRe + rutaCrear).mkdirs();
		      } else creaDir = true;
		      if (creaDir) {
			  try {
                              OutputStream out;
                              try (InputStream in = new FileInputStream(archivosOriginalesAplicar[indSeleccionados[ex]])) {
                                  out = new FileOutputStream(mArchivoDest);
                                  byte[] buf = new byte[1024];
                                  while ((len = in.read(buf)) > 0){
                                    out.write(buf, 0, len);
                                  }
                              }
			      out.close();
			      if (comboCarpeta.getSelectedIndex() == 1) {
				  archivosOriginalesAplicar[indSeleccionados[ex]].delete();
			      }
			      try {
				  pwLog.println(archivosOriginalesAplicar[indSeleccionados[ex]] + "-->" + mArchivoDest);
			      } catch (Exception z) {
			      } 
			  } catch (IOException xe) {
			      exitoCopia = false;
			      directoriosProvisionalCreados = new ArrayList<>();
			      if ( !archivosOriginalesAplicar[indSeleccionados[ex]].canRead() ) {
				  sinPermiso(archivosOriginalesAplicar[indSeleccionados[ex]].toString());
				  cantidadRenombrados = 0;
				  continue;
			      } else {
				  sinPermiso(rutaRe);
				  cantidadRenombrados = 0;
				  break;
			      }
			  }
		      } else {
			  exitoCopia = false;
			  directoriosProvisionalCreados = new ArrayList<>();
			  if ( ! new File (rutaRe).canWrite() ) {
			      sinPermiso(rutaRe);
			      cantidadRenombrados = 0;
			      break;
			  } else {
			      sinPermiso(mArchivoDest.toString());
			      cantidadRenombrados--;
			      continue;
			  }
		      }
		  }
		  if (exitoCopia) {
		      for (int x=0;x<directoriosProvisionalCreados.size();x++) 
			  directoriosCreados.add(directoriosProvisionalCreados.get(x));
		      iSeleccionadosOk.add(indSeleccionados[ex]);
		  }
	      } else if (respuestaOpcion == 3) {
		  cantidadRenombrados = ex;
		  break;
	      } else cantidadRenombrados--;
	    } else { //renombrar
	      mArchivoDest = archivosRenombradosAplicar[indSeleccionados[ex]];
	      String rutaCrear = mArchivoDest.getParent().replace(archivosOriginalesAplicar[indSeleccionados[ex]].getParent(),"");
	      if (rutaCrear != null) {
		rutaCrear = rutaCrear.replaceAll(":","");
		rutaCrear = rutaCrear.replaceAll("\\*","");
		rutaCrear = rutaCrear.replaceAll("\\?","");
		rutaCrear = rutaCrear.replaceAll("\\¿","");
		rutaCrear = rutaCrear.replaceAll("\\\"","");
		rutaCrear = rutaCrear.replaceAll("<","");
		rutaCrear = rutaCrear.replaceAll(">","");
		rutaCrear = rutaCrear.replaceAll("\\|","");
		mArchivoDest = new File ( archivosOriginalesAplicar[indSeleccionados[ex]].getParent() + rutaCrear + separador + archivosRenombradosAplicar[indSeleccionados[ex]].getName() );
		archivosRenombradosAplicar[indSeleccionados[ex]] = mArchivoDest;

	    }
	      /** COMPRUEBA SI EXISTE Y DETECTA PROBLEMA DE CICLO
	      *
	      */
	    if ( ! siTodo && indicesMarcar.contains(indSeleccionados[ex])) {
                if ( ! noTodo )
                    respuestaOpcion = yaExiste(archivosOriginalesAplicar[indSeleccionados[ex]].toString(), mArchivoDest.toString());
                else
                    respuestaOpcion = 2;
            } else if (indicesCiclo.contains(indSeleccionados[ex])) {
		ciclo = true;
		System.out.println(MessageFormat.format("Cycle renaming detected for {0}. Fixed", mArchivoDest));
		mArchivoDest = new File (mArchivoDest.getParent() + separador + "vRTP" + mArchivoDest.getName());
	    }
	    if (respuestaOpcion == 1) {
		siTodo = true;
		respuestaOpcion = 0;
	    } else if (respuestaOpcion == 4) {
                noTodo = true;
                respuestaOpcion = 2;
            }
	    if (respuestaOpcion == 0) {
		estadoAplicar = archivosOriginalesAplicar[indSeleccionados[ex]].renameTo(mArchivoDest);
		if (!estadoAplicar) {
		    Boolean existeDir = new File (mArchivoDest.getParent()).exists();
		    if (!existeDir) {
			File directorioNo = new File (mArchivoDest.getParent());
			while (!existeDir){
			    directoriosProvisionalCreados.add(directorioNo);
			    existeDir = new File (directorioNo.getParent()).exists();
			    if (!existeDir) 
				directorioNo = new File (directorioNo.getParent());
			}
			creaDir = new File (mArchivoDest.getParent()).mkdirs();
		    } else 
			creaDir = true;
		    if (creaDir) {
			estadoAplicar = archivosOriginalesAplicar[indSeleccionados[ex]].renameTo(mArchivoDest);
		    } else {
			directoriosProvisionalCreados = new ArrayList<>();
		    }
		    if (!estadoAplicar) {
			System.err.println("Cannot rename " + mArchivoDest.toString());
			cantidadRenombrados--;
			continue;
		    } else {
			for (int x=0;x<directoriosProvisionalCreados.size();x++) {
			    directoriosCreados.add(directoriosProvisionalCreados.get(x));
			}
			iSeleccionadosOk.add(indSeleccionados[ex]);
		    }
		}
		if (estadoAplicar) {
		    archivosCheck.set(archivosCheck.indexOf(archivosOriginalesAplicar[indSeleccionados[ex]]), mArchivoDest);
		    if (!creaDir) {
			iSeleccionadosOk.add(indSeleccionados[ex]);
		    }
		    if (ciclo) {
			archivosCiclo.add(mArchivoDest);
		    }
		    try {
			pwLog.println(archivosOriginalesAplicar[indSeleccionados[ex]] + "-->" + archivosRenombradosAplicar[indSeleccionados[ex]]);
		    } catch (Exception e) {
		    } 
		}
	    } else if (respuestaOpcion == 3) {
		cantidadRenombrados = ex;
		for (int z=ex;z<indSeleccionados.length;z++) {
		    archivosRenombrados[indSeleccionados[z]] = archivosOriginales[indSeleccionados[z]];
		}
		break;
	    } else {
		cantidadRenombrados--;
		archivosRenombrados[indSeleccionados[ex]] = archivosOriginales[indSeleccionados[ex]];
	    }
	  }
	  if (preguntaCancela()) {
	      try {
		  pwLog.println("End Date (CANCELLED): " + mBusca.getFecha() + "  " + mBusca.getHora());
		  pwLog.println("");
	      } catch (Exception e) {
	      } finally {
		  try {
		      if (null != pwLog) {
			  pwLog.close();
			  pwLog.flush();
		      }
		  } catch (Exception e2) {
		  }
	      }
	      cantidadRenombrados = ex +1;
	      break;
	  }
	  directoriosProvisionalCreados = new ArrayList<>();
      }
      try {
	  pwLog.println("End Date: " + mBusca.getFecha() + "  " + mBusca.getHora());
	  pwLog.println("");
      } catch (Exception e) {
      } finally {
	  try {
	      if (null != pwLog) {
		  pwLog.close();
		  pwLog.flush();
	      }
	  } catch (Exception e2) {
	  }
      }
      directoriosDeshacer = new File [directoriosCreados.size()];
      if (directoriosDeshacer.length > 0) {
	for (int x=0;x<directoriosDeshacer.length;x++) {
	  directoriosDeshacer[x] = directoriosCreados.get(x);
	}
	directoriosCreados = new ArrayList<>();
      }
      if (!archivosCiclo.isEmpty()) {
	  for (int x=0;x<archivosCiclo.size();x++) {
	      File ficheroCiclo = new File ( archivosCiclo.get(x).getParent() + separador + archivosCiclo.get(x).getName().substring(4) );
	      archivosCiclo.get(x).renameTo(ficheroCiclo);
	      archivosCheck.set(archivosCheck.indexOf(archivosCiclo.get(x)), ficheroCiclo);

	  }
      }
      indSeleccionadosOk = new int [iSeleccionadosOk.size()];
      for (int x=0;x<iSeleccionadosOk.size();x++) {
	  indSeleccionadosOk[x]=iSeleccionadosOk.get(x);    
      }
      if ( cantidadRenombrados > 0 ) {
	  if (!ckCopiaCarpeta.isSelected()) { 
	      edit = new AddEdit(indSeleccionadosOk, archivosOriginalesAplicar, archivosRenombrados, Archivos, Renombrados, directoriosDeshacer, modoDrop, Idioma);
	      undoSupport_.postEdit( edit );
	  }
	  else if (comboCarpeta.getSelectedIndex() == 1) {
	      edit = new MoverEdit(indSeleccionadosOk, indSeleccionadosRe, archivosOriginalesAplicar, archivosRenombradosMover, directoriosDeshacer, Idioma);
	      undoSupport_.postEdit( edit );
	  }
      }
      indicesMarcar = new ArrayList<>();
      return null;
  }

   @Override
    protected void process(java.util.List<Integer> chunksAp) {
	jProgreso.setValue(chunksAp.get(chunksAp.size() -1 ));
	if (mArchivoDest != null)
	    muestraBarra(true,mArchivoDest.getName());
   }

  @Override
   protected void done() {
      btnPreview.setEnabled(true);
      btnLimpiar.setEnabled(true);
      btnActualizar.setEnabled(true);
      comboSelecAplica.setEnabled(true);
      m15.setEnabled(true);
      listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererRenom(rutaRe, okSeleccion, indicesMarcar, 0));
      jProgreso.setValue(0);
      jProgreso = new JProgressBar();
      limpia(true);
      ckRecursivo.setSelected(false);
      jCancel.setEnabled(true);
      if ( ! modoDrop ) {
	  actualizaDespuesAplicar(ruta);
      } else {
	  if (ckCopiaCarpeta.isSelected() && comboCarpeta.getSelectedIndex() == 1) {
	      int[] seleccionArray = new int[seleccionCheck.size()];
	      for (int x=0;x<seleccionArray.length;x++)
		  seleccionArray[x] = seleccionCheck.get(x);
	      if (seleccionArray.length == archivosOriginales.length)
		  pulsaDrop();
	      else
		  limpiaArchivosDrop(seleccionArray);
	      muestraInfo(false,false);
	  } else {
	      actualizaDespuesDrop();
	  }
      }
      if (opAtributos.isSelected() && pestPanel.getSelectedIndex() == 1) {
	  aplicaAtributos();
      }
      if (cantidadRenombrados > 0) {
	  JOptionPane.showMessageDialog(pnlPrincipal, cantidadRenombrados + " " + Idioma.getInfoFile() + " " + operacionAplicada, Idioma.getMainDone(), JOptionPane.INFORMATION_MESSAGE, infoOk);
      } else {
	  JOptionPane.showMessageDialog(pnlPrincipal, "No file " + operacionAplicada, Idioma.getMainDone(), JOptionPane.INFORMATION_MESSAGE, infoOk);
      }
   }

}

class SeleccionadosNuevo extends SwingWorker<Void, Void> {
  
  @Override
  protected Void doInBackground() throws Exception {
	seleccionCancelada = false;
	try {
	  Thread.sleep(150);
	}
	catch (InterruptedException e) {
	}
	RenombradosEstructura = new String[Renombrados.length];
	if (ckCopiaCarpeta.isSelected() && ckRecursivo.isSelected() && copiarEstructura) {
	    for (int x=0;x<okSeleccionRe.length;x++) {
		if ( ! archivosOriginales[okSeleccion[x]].getParent().replace(ruta,"").equals(archivosOriginales[okSeleccion[x]].getParent()) ) {
		    RenombradosEstructura[okSeleccionRe[x]] = archivosOriginales[okSeleccion[x]].getParent().replace(ruta,"");
		}
	    }
	}
        int seleccionFinal = 0;
        String[] separaTextLocal = new String[pnlBuscaTotal.getComponentCount()];

        for (int x=0; x<pnlBuscaTotal.getComponentCount(); x++) {
            BarraRenombra barra = (BarraRenombra) pnlBuscaTotal.getComponent(x);
            if (barra.getCkEnabled().isSelected()) {
                seleccionFinal ++;
            }
        }
        seleccionFinal--;
        int indexBusca = 0;            
	if (opSustituciones.isSelected()) {            
	    String[][] ordenBusca = new String[seleccionFinal+1][9];            
	    for (Component cBarra : pnlBuscaTotal.getComponents()) {
                BarraRenombra barra = (BarraRenombra) cBarra;
                if ( ! barra.getCkEnabled().isSelected() ) {
                    continue;
                }
		switch (barra.getComboBusca().getSelectedIndex()) {
		    case 0: // TEXT                        
			ordenBusca[indexBusca][0] = "0";
			ordenBusca[indexBusca][1] = barra.getText();   
		    break;
		    case 1: // SEQUENCE
			String indiceNumeracion;
			if (barra.getSecuenciaTipo().getSelectedIndex() == 0) {
			    indiceNumeracion = barra.getNumeracionTexto().getValue().toString();
			} else {
			    SpinnerListModel modeloNumeracion = (SpinnerListModel) barra.getNumeracionTexto().getModel();
			    java.util.List<String> listaModeloNumeracion = (java.util.ArrayList<String>) modeloNumeracion.getList();
			    indiceNumeracion = listaModeloNumeracion.indexOf(barra.getNumeracionTexto().getValue().toString()) + "";
			    if (barra.getSecuenciaTipo().getSelectedIndex() == 1 || barra.getSecuenciaTipo().getSelectedIndex() == 2) {
				int parseIndice = Integer.parseInt(indiceNumeracion) + 1;
				indiceNumeracion = parseIndice + "";
			    }
			}
			ordenBusca[indexBusca][0] = "1";
			ordenBusca[indexBusca][1] = barra.getJNumeracion().getSelectedIndex() + "";
			ordenBusca[indexBusca][2] = indiceNumeracion;
			ordenBusca[indexBusca][3] = barra.getNumeracionSalto().getValue().toString();
			ordenBusca[indexBusca][4] = barra.getResetNumera().getSelectedIndex() + "";
			ordenBusca[indexBusca][5] = barra.getSecuenciaTipo().getSelectedIndex() + "";
			ordenBusca[indexBusca][6] = barra.getSecuenciaTipoCase().getSelectedIndex() + "";
		    break;
		    case 2: // FILENAME
			ordenBusca[indexBusca][0] = "2";
			ordenBusca[indexBusca][1] = barra.getJArchivo().getSelectedIndex() + "";
			ordenBusca[indexBusca][2] = barra.getJCorte().getText();
			ordenBusca[indexBusca][3] = barra.getNumeracionCorte().getValue().toString();
			ordenBusca[indexBusca][4] = barra.getHastaFinal().getSelectedIndex() + "";
			ordenBusca[indexBusca][5] = barra.getArchivoDesde().getValue().toString();
			ordenBusca[indexBusca][6] = barra.getArchivoHasta().getValue().toString();
			ordenBusca[indexBusca][7] = barra.getArchivoTextoDesde().getText();
			ordenBusca[indexBusca][8] = barra.getArchivoTextoHasta().getText();
		    break;
		    case 3: // FOLDER
			ordenBusca[indexBusca][0] = "3";
			ordenBusca[indexBusca][1] = barra.getJCarpeta().getSelectedIndex() + "";
		    break;
		    case 4: // DATE
			ordenBusca[indexBusca][0] = "4";
			ordenBusca[indexBusca][1] = barra.getJFecha().getSelectedIndex() + "";
			ordenBusca[indexBusca][2] = barra.getSeparaFecha().getSelectedIndex() + "";
			ordenBusca[indexBusca][3] = diasMes + "";
			ordenBusca[indexBusca][4] = iniciaModified;
		    break;
		    case 5: // METADATA DATE
			ordenBusca[indexBusca][0] = "5";
			ordenBusca[indexBusca][1] = barra.getJMetadata().getSelectedIndex() + "";
			ordenBusca[indexBusca][2] = barra.getSeparaFecha().getSelectedIndex() + "";
			ordenBusca[indexBusca][3] = diasMes + "";
		    break;
		    case 6: // METADATA CAMERA
			ordenBusca[indexBusca][0] = "6";
			ordenBusca[indexBusca][1] = barra.getJMetadataCamara().getSelectedIndex() + "";
		    break;
		    case 7: // METADATA SOUND
			ordenBusca[indexBusca][0] = "7";
			ordenBusca[indexBusca][1] = barra.getJMp3().getSelectedIndex() + "";
			ordenBusca[indexBusca][2] = barra.getJNumeracion().getSelectedIndex() + "";
		    break;

		}

		JTextField jtSepara = (JTextField)barra.getJSeparaCampos().getEditor().getEditorComponent();
		separaTextLocal[indexBusca] = jtSepara.getText();
                indexBusca ++;
	    }
            
            BarraRenombra barra = (BarraRenombra) pnlBuscaTotal.getComponent(0);
	    if(barra.getComboBusca().getSelectedIndex()==0 && barra.getText().equals("")) {
		  ordenBusca[0][0] = "2";
		  ordenBusca[0][1] = " ";
	    }

	    seleccionCancelada = mBusca.recogeSeleccion(indicesSeleccion, Renombrados, ordenBusca, ckOpcionDos.isSelected(), txtExtension.getText(), separaTextLocal, ckCopiaCarpeta.isSelected(), rutaRenombrados, opcionSelec, datoCalendario, RenombradosEstructura, getSistema());
	} else if (opInserta.isSelected()){            
	    seleccionCancelada = mBusca.recogeInsertar(indicesSeleccion, Renombrados, txtInsertar.getText(), spnInsertar.getValue().toString(), desdeDerechaInserta.isSelected(), ckOpcionDos.isSelected(), txtExtension.getText(), opcionSelec);
	} else if (opElimina.isSelected()){
	    seleccionCancelada = mBusca.recogeEliminar(indicesSeleccion, Renombrados, spnDesde.getValue().toString(), spnHasta.getValue().toString(), desdeDerecha.isSelected(), ckOpcionDos.isSelected(), txtExtension.getText(), opcionSelec);
	}
	if (opNumeros.isSelected()){
	    seleccionCancelada = mBusca.recogeNumeros(indicesSeleccion, Renombrados, jNumeros.getSelectedIndex(), normaPosicion.getValue().toString(), normaCeros.getValue().toString(), numerosEn.getValue().toString(), numerosSalto.getValue().toString(), numerosPosicion.getValue().toString(), ckCopiaCarpeta.isSelected(), ckOpcionDos.isSelected(), txtExtension.getText(), rutaRenombrados, opcionSelec);
	}
	if (opReemplaza.isSelected()){
	    seleccionCancelada = mBusca.recogeReemplaza(indicesSeleccion, Renombrados, txtReemplazaUno.getText(), txtReemplazaDos.getText(), ckOpcionDos.isSelected(), txtExtension.getText(), cMode.getSelectedIndex(), opcionSelec);
	}
	if (opNormaliza.isSelected()){
	    seleccionCancelada = mBusca.recogeNormaliza(indicesSeleccion, Renombrados, jNormaliza.getSelectedIndex(), ckOpcionDos.isSelected(), iniciaBasura, normalizaTrim.getValue().toString(), desdeDerechaTrim.isSelected(), txtExtension.getText(), opcionSelec);
	}
	if (opAleatorio.isSelected()){
	    seleccionCancelada = mBusca.recogeAleatorio(indicesSeleccion, Renombrados, opAleatorioLong.isSelected(), opAleatorioOrig.isSelected(), AleatorioLong.getValue().toString(), ckOpcionDos.isSelected(), txtExtension.getText(), opcionSelec);
	}
	if (opCapitaliza.isSelected()){
	    seleccionCancelada = mBusca.recogeCapitaliza(indicesSeleccion, Renombrados, jCapitaliza.getSelectedIndex(), txtSymbols.getText(), ckOpcionDos.isSelected(), txtExtension.getText(), opcionSelec);
	}
	if (ckCopiaCarpeta.isSelected()) {
	    if (ckRecursivo.isSelected() && copiarEstructura) {
		for (int x=0;x<okSeleccionRe.length;x++) {
		    if ( ! archivosOriginales[okSeleccion[x]].getParent().replace(ruta,"").equals(archivosOriginales[okSeleccion[x]].getParent()) ) {
			Renombrados[okSeleccionRe[x]] = new StringBuffer().append(RenombradosEstructura[okSeleccionRe[x]]).append(separador).append(Renombrados[okSeleccionRe[x]].toString());
		    }
		}
	    }
	    seleccionCancelada = mBusca.checkRepetidosCopia(rutaRenombrados, okSeleccionRe, okSeleccion, Renombrados, RenombradosEstructura, Archivos, getSistema());
	}
	if (ckCopiaCarpeta.isSelected()) {
	    indicesCambiados = mBusca.getIndicesCambiados();
	    indicesMarcar = mBusca.getIndicesMarcar();
	    if (copiarRenombrados) {
		int i=0, z=0;
		int[] okSeleccionCopia = Arrays.copyOf(okSeleccion, okSeleccion.length);
		java.util.List<StringBuffer> renombradosList = new LinkedList<>(Arrays.asList(Renombrados));
		okSeleccion = new int[indicesCambiados.size()];
		okSeleccionRe = new int[okSeleccion.length];
		for (int x=0;x<okSeleccionCopia.length;x++) {
		    if (!indicesCambiados.contains(okSeleccionCopia[x])) {
			int eliminaRenom = renombradosList.indexOf(Renombrados[(oRenombrados.getUltimaCarpeta() + 1) + x]);
			renombradosList.remove(eliminaRenom);
			i++;
		    } else {
			okSeleccion[z] = indicesCambiados.get(z);		    
			okSeleccionRe[z] = (oRenombrados.getUltimaCarpeta() + 1) + z;
			z++;
		    }
		}
		if (okSeleccionRe.length == 0) {
		    indicesMarcar = new ArrayList<>();
		}
		Renombrados = new StringBuffer[renombradosList.size()];
		renombradosList.toArray(Renombrados);
		seleccionCancelada = mBusca.checkRepetidosCopia(rutaRenombrados, okSeleccionRe, okSeleccion, Renombrados, new String[0], Archivos, getSistema());
		indicesMarcar = mBusca.getIndicesMarcar();
		indicesSeleccion = okSeleccionRe;
	    }
	} else {
	    seleccionCancelada = mBusca.checkRepetidos(Renombrados, archivosOriginales, getSistema());
	    indicesMarcar = mBusca.getIndicesMarcar();
	    indicesCambiados = mBusca.getIndicesCambiados();
	    oArchivos.setRenombrados(Renombrados);
	}
	return null;
   }

   @Override
   protected void done() {
      renderizaDos = new MyCellRendererDos(archivosOriginales, indicesMarcar, indicesCambiados, 0);
      jProgreso.setIndeterminate(false);
      jProgreso.setStringPainted(true);
      comienzaPreview();
   }

 }

class Visualizando extends SwingWorker<Void, Void> {
  
    @Override
    protected Void doInBackground() throws Exception {
	return null;
    }   
    
    @Override
    protected void done() {
	if (ckCopiaCarpeta.isSelected()) {
 	    modeloRenombrados();
	    renombrados();
	    listRenombrados.getColumnModel().getColumn(0).setCellRenderer(new MyCellRendererRenom(rutaRenombrados, okSeleccionRe, indicesMarcar, 0));
	    if (indicesSeleccion.length > 0) {
		Rectangle rect = listRenombrados.getCellRect(oRenombrados.getUltimaCarpeta()+1, 0, true);
		listRenombrados.scrollRectToVisible(rect);
		if ( ! btnAplicar.isEnabled() ) {
		    btnAplicar.setEnabled(true);
                    btnAplicar.setIcon(aplicarBigOk);
		    m16.setEnabled(true);
		    new Blink().execute();
		}
	    } else {
		btnAplicar.setEnabled(false);
                btnAplicar.setIcon(aplicarBigBWOk);
		m16.setEnabled(false);
	    }
	} else {
	    listRenombrados.getColumnModel().getColumn(0).setCellRenderer(renderizaDos);
	    if ( ! indicesCambiados.isEmpty() ) {
		if ( ! btnAplicar.isEnabled() ) {
		    btnAplicar.setEnabled(true);
                    btnAplicar.setIcon(aplicarBigOk);
		    m16.setEnabled(true);
		    new Blink().execute();
		} 
	    } else if ( ! opAtributos.isSelected() ) {
		btnAplicar.setEnabled(false);
                btnAplicar.setIcon(aplicarBigBWOk);
		m16.setEnabled(false);
	    }
	}
	if (listArchivos.getSelectedRows().length > 0) {
	    muestraInfo(false, true);
	} else {
	    muestraInfo(false, false);
	}
	jCancel.setEnabled(true);
	if (seleccionCancelada) {
	    actualizaDespuesAplicar(ruta);
	}
	if (ckCopiaCarpeta.isSelected()) {
// 	    indicesMarcar = new ArrayList<Integer>();
	} else {
	    limpiaRenombrados();
	}
	SwingUtilities.invokeLater(new Runnable() {
          @Override
	  public void run() {
	      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	  }
	});
    }

}

 public static void main(String args[]){
    System.out.println("vRenamer - Easy-to-use mass renamer");
    System.setProperty("apple.laf.useScreenMenuBar", "true");
    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "vRenamer");
    System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
    System.setProperty ("jayatana.force", "true");
    SwingUtilities.invokeLater(() -> {
    try {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            UIManager.setLookAndFeel(new FlatMacLightLaf());	
//        } else if (os.contains("linux")) {
//            try {
//                PlasticLookAndFeel.setPlasticTheme(new LightGray());
//                PlasticLookAndFeel.setHighContrastFocusColorsEnabled(true);
//                UIManager.setLookAndFeel(new Plastic3DLookAndFeel());	
//            } catch (UnsupportedLookAndFeelException j) {
//            }            
        } else {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (UnsupportedLookAndFeelException j) {
            }
        }
        
    } catch (UnsupportedLookAndFeelException e) {
        try {
            PlasticLookAndFeel.setPlasticTheme(new LightGray());
            PlasticLookAndFeel.setHighContrastFocusColorsEnabled(true);
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());	
        } catch (UnsupportedLookAndFeelException j) {
        }
    }
    UIManager.put( "TabbedPane.selectedBackground", Color.white );
    RenombraControl RC = new RenombraControl();
    });
 }

}              
