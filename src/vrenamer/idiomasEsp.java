package vrenamer;

import java.awt.event.*;

public class idiomasEsp implements idiomas {

  public String getMainRenamed() {
    return "renombrados";    
  }
  public String getMainCopied() {
    return "copiados";    
  }
  public String getMainChanged() {
    return "cambiados";    
  }
  public String getMainDone() {
    return "TERMINADO";    
  }

  public String getCheckVersion() {
    return "Comprobando versión";    
  }
  public String getVersionAvailable() {
    return "Nueva versión disponible: ";    
  }
  public String getVersion() {
    return "Nueva versión";    
  }
  public String getVersionDownload() {
    return "Descargar";    
  }
  public String getVersionDismiss() {
    return "Omitir";    
  }
  public String getVersionNever() {
    return "No me preguntes de nuevo";    
  }

  public String getMenuNew() {
    return "Nuevo";
  }
  public String getMenuFile() {
    return "Archivo";
  }
  public String getMenuEdit() {
    return "Editar";
  }  
  public String getMenuPrefs() {
    return "Ver";
  }

  public String getMenuOpen() {
    return "Abrir archivo";
  }
  public String getMenuOpenRecent() {
    return "Abrir reciente";
  }
  public String getMenuSave() {
    return "Guardar";
  }
  public String getMenuSaveAs() {
    return "Guardar como";
  }

  public String getMenuIdioma() {
    return "Elige idioma:";
  }
  public String getMenuSpanish() {
    return "Español";
  }
  public String getMenuEnglish() {
    return "Inglés";
  }
  public String getMenuOptions() {
    return "Opciones";
  }

  public String getMenuSesion() {
    return "Al iniciar vRenamer:";
  }
  public String getMenuSesionClean() {
    return "Comenzar con una sesión limpia";
  }
  public String getMenuSesionLast() {
    return "Restaurar sesión previa";
  }

  public String getMenuAuto() {
    return "Vista previa automática";
  }
  
  public String getMenuDate() {
    return "Fechas";
  }

  public String getMenuDayMonth() {
    return "Formato para los meses";
  }
  public String getMenuDayOne() {
    return "01, 02, 03...";
  }
  public String getMenuDayTwo() {
    return "ene, feb, mar...";
  }
  public String getMenuDayThree() {
    return "enero, febrero, marzo...";
  }

  public String getMenPickDate() {
    return "Elige fecha";
  }

  public String getMenPickModified() {
    return "Última modificación";
  }
  public String getMenPickCreation() {
    return "Fecha de creación";
  }
  public String getMenPickAccessed() {
    return "Último acceso";
  }
  public String getMenPickManual() {
    return "Elegir de forma manual";
  }
  public String getMenPickStamp() {
    return "Escribir fecha";
  }

  public String getCalendarReload() {
    return "Actualiza el calendario";
  }

  public String getMenuRenaming() {
    return "Renombrado";
  }
  public String getMenuRenamingLbl() {
    return "Al soltar una carpeta: ";
  }
  public String getMenuRenamingUno() {
    return "Volcar la carpeta tal cual";
  }
  public String getMenuRenamingDos() {
    return "Volcar el contenido de la carpeta";
  }
  public String getMenuTrash() {
    return "Definir caracteres basura:";
  }

  public String getMenuEstructuraLbl() {
    return "Al copiar recursivamente: ";
  }
  public String getMenuEstructuraUno() {
    return "Copiar solamente los archivos";
  }
  public String getMenuEstructuraDos() {
    return "Copiar con la estructura de carpetas";
  }

  public String getMenuCarpetaRecursivaLbl() {
    return "Modo de búsqueda recursiva: ";
  }
  public String getMenuCarpetaRecursivaUno() {
    return "Buscar y añadir archivos";
  }
  public String getMenuCarpetaRecursivaDos() {
    return "Buscar y añadir carpetas";
  }
  public String getMenuCopiarRenombradosLbl() {
    return "Modo de copia: ";
  }
  public String getMenuCopiarRenombradosUno() {
    return "Copiar todos los archivos seleccionados";
  }
  public String getMenuCopiarRenombradosDos() {
    return "Copiar solo los que vayan a renombrarse";
  }

  public String getMenuTituloCarpeta() {
    return "Comportamiento de archivos y carpetas";
  }
  public String getMenuTituloNormaliza() {
    return "Patrones Normaliza";
  }

  public String getMenuHelp() {
    return "Ayuda";
  }  
  public String getMenuPreview() {
    return "Vista previa";
  }  
  public String getMenuApply() {
    return "Aplicar";
  } 
  public String getMenuDefault() {
    return "Por defecto";
  }

  public String getSelectFile() {
    return "Renombra archivo";
  }  
  public String getSelectExtension() {
    return "Renombra extensión";
  }  
  public String getSelectWhole() {
    return "Renombra todo";
  }  

  public String getMenuLog() {
    return "Importar fichero log";
  }  
  public String getMenuImport() {
    return "Renombrar desde lista";
  }  
  public String getMenuExit() {
    return "Salir";
  }  
  public String getMenuHidden() {
    return "Mostrar ocultos";
  }  
  public String getMenuDrop() {
    return "Modo Drop";
  }
  public String getMenuTipDrop() {
    return "Borrar elementos de la lista";
  }
  public String getMenuSalirDrop() {
    return "Salir";
  }
  public String getTipMenuSalirDrop() {
    return "Salir del Modo Drop";
  }

  public String getMenuUndo() {
    return "Deshacer";
  }  
  public String getMenuRedo() {
    return "Rehacer";
  } 
  public String getMenuSelectAll() {
    return "Selecciona todo";
  }  
  public String getMenuInvSel() {
    return "Invertir selección";
  }   
  public String getMenuSelFile() {
    return "Selecciona archivos";
  }  
  public String getMenuSelFolder() {
    return "Selecciona carpetas";
  }  
  public String getMenuAbout() {
    return "Acerca de vRenamer";
  }

/** 
 * letras subrayadas en el menú
 */

  public int getMenuMaskOpen() {
    return KeyEvent.VK_B;
  }
  public int getMenuMaskSave() {
    return KeyEvent.VK_G;
  }
  public int getMenuMaskSaveAs() {
    return KeyEvent.VK_C;
  }

  public int getMenuMaskFile() {
    return KeyEvent.VK_A;
  }
  public int getMenuMaskHelp() {
    return KeyEvent.VK_Y;
  }
  public int getMenuMaskExit() {
    return KeyEvent.VK_S;
  }
  public int getMenuMaskAbout() {
    return KeyEvent.VK_C;
  }
  public int getMenuMaskUndo() {
    return KeyEvent.VK_D;
  }
  public int getMenuMaskIdioma() {
    return KeyEvent.VK_E;
  }
  public int getMenuMaskSpanish() {
    return KeyEvent.VK_S;
  }
  public int getMenuMaskEnglish() {
    return KeyEvent.VK_N;
  }

  public int getMenuMaskSesion() {
    return KeyEvent.VK_S;
  }
  public int getMenuMaskSesionClean() {
    return KeyEvent.VK_L;
  }
  public int getMenuMaskSesionLast() {
    return KeyEvent.VK_T;
  }
  public int getMenuMaskLog() {
    return KeyEvent.VK_I;
  }
  public int getMenuMaskImport() {
    return KeyEvent.VK_P;
  }
  public int getMenuMaskSettings() {
    return KeyEvent.VK_V;
  }
  public int getMenuMaskSorting() {
    return KeyEvent.VK_R;
  }

  public int getMenuMaskByName() {
    return KeyEvent.VK_N;
  }
  public int getMenuMaskByDate() {
    return KeyEvent.VK_D;
  }
  public int getMenuMaskByPictureDate() {
    return KeyEvent.VK_P;
  }
  public int getMenuMaskBySize() {
    return KeyEvent.VK_T;
  }
  public int getMenuMaskByExtension() {
    return KeyEvent.VK_E;
  }
  public int getMenuMaskByNumber() {
    return KeyEvent.VK_I;
  }

/**
 *
 */

  public String getPath() {
    return "Ruta";
  }
  public String getFiltro() {
    return "Filtro";
  }
  public String getExclude() {
    return "Excluye";
  }

  public String getTipReload() {
    return "Actualizar";
  }
  public String getTipClean() {
    return "Limpiar";
  }  
  public String getTipPreview() {
    return "Vista previa";
  }  
  public String getTipApply() {
    return "Aplicar";
  }
  public String getTipCase() {
    return "Distingue entre mayúsculas y minúsculas";
  }
  public String getTipExclude() {
    return "Busca archivos que no contengan la expresión";
  }
  public String getTipRecursive() {
    return "Busca en subcarpetas";
  }

  public String getTitleOriginals() {
    return "Archivos originales";
  }
  public String getTitlePreviews() {
    return "Vista previa";
  }

  public String getCopyFolder() {
    return "Copiar a carpeta";
  }
  public String getMoveFolder() {
    return "Mover a carpeta";
  }
  public String getExtension() {
    return "Extensión";
  }
  public String getSeparator() {
    return "Separador";
  }

  public String getTabBasic() {
    return "Operaciones básicas";
  }
  public String getTabOther() {
    return "Otras sustituciones";
  }
  public String getTabMp3() {
    return "Etiqueta archivo de audio";
  }

  public String getTitleRename() {
    return "Renombrar";
  }
  public String getTitleRemove() {
    return "Insertar/Eliminar";
  }
  public String getTitleMp3() {
    return "Escribe archivo de audio";
  }

  public String getTagTrack() {
    return "Pista";
  }
  public String getTagTitle() {
    return "Canción";
  }
  public String getTagArtist() {
    return "Artista";
  }
  public String getTagAlbum() {
    return "Álbum";
  }
  public String getTagYear() {
    return "Año";
  }
  public String getTagGenre() {
    return "Género";
  }

  public String getBtnGet() {
    return "Datos";
  }
  public String getBtnClean() {
    return "Limpia";
  }
  public String getBtnSet() {
    return "Escribe";
  }
  public String getBtnIncrease() {
    return "Incrementa";
  }

  public String getOpCombina() {
    return "Combinadas";
  }
  public String getOpInserta() {
    return "Inserta";
  }
  public String getOpElimina() {
    return "Elimina";
  }
  public String getOpAcentos() {
    return "Elimina acentos";
  }
  public String getOpReemplaza() {
    return "Reemplaza";
  }
  public String getOpNormaliza() {
    return "Normaliza";
  }
  public String getOpBasura() {
    return "Elimina caracteres basura";
  }
  public String getOpCapitaliza() {
    return "Capitalización";
  }
  public String getOpEspacios() {
    return "Normaliza espacios repetidos";
  }
  public String getOpTrim() {
    return "Recorta nombre";
  }

  public String getOpNumeros() {
    return "Números";
  }  
  public String getOpNormaCeros() {
    return "Arregla";
  }
  public String getOpRenumber() {
    return "Renumerar";
  }
  public String getNormaPosition() {
    return "Posición";
  }
  public String getNormaCeros() {
    return "Ceros";
  }

  public String getOpAleatorio() {
    return "Nombre aleatorio";
  }
  public String getOpAtributos() {
    return "Atributos de archivo";
  }

  public String getExecute() {
    return "Ejecutable";
  }
  public String getReadable() {
    return "Lectura";
  }
  public String getWritable() {
    return "Escritura";
  }
  public String getHidden() {
    return "Oculto";
  }

  public String getReadOnly() {
    return "Sólo lectura";
  }

  public String getActivated() {
    return "Activado";
  }
  public String getDeactivated() {
    return "Desactivado";
  }
  public String getApplyAll() {
    return "Aplicar todos";
  }
  public String getApplySelected() {
    return "Aplicar seleccionado";
  }

  public String getMainIn() {
    return "en";
  }
  public String getMainRight() {
    return "Desde derecha";
  }
  public String getMainPosition() {
    return "Desde posición";
  }
  public String getMainThrough() {
    return "hasta";
  } 

  public String getLengthOne() {
    return "con longitud";
  }
  public String getLengthTwo() {
    return "Longitud original";
  }
  public String getWith() {
    return "con";
  }

  public String getCaseUp() {
    return "Todo en mayúsculas";
  }
  public String getCaseLow() {
    return "Todo en minúsculas";
  }
  public String getCaseFirst() {
    return "Primera en mayúsculas";
  }
  public String getCaseAll() {
    return "Primera de cada palabra en mayúsculas";
  }
  public String getCaseSymbol() {
    return "Después de cada símbolo";
  }

  public String getComboText() {
    return "Texto";
  }
  public String getComboNumber() {
    return "Secuencia";
  }
  public String getComboFile() {
    return "Nombre de archivo";
  }
  public String getComboFolder() {
    return "Nombre de carpeta";
  }
  public String getComboDate() {
    return "Fecha";
  }
  public String getComboDatePicture() {
    return "Fecha imagen";
  }
  public String getComboCamera() {
    return "Cámara";
  }
  public String getComboMusic() {
    return "Música";
  }

  public String getSeqArab() {
    return "Numeración";
  }
  public String getSeqRoman() {
    return "Romano";
  }
  public String getSeqLetters() {
    return "Letras";
  }
  public String getSeqBinary() {
    return "Binario";
  }
  public String getSeqHex() {
    return "Hexadecimal";
  }
  public String getSeqOc() {
    return "Octal";
  }

  public String getSeqUpp() {
    return "May";
  }
  public String getSeqLow() {
    return "Min";
  }

  public String getNumberLabel() {
    return "En";
  }
  public String getNumberSkip() {
    return "Salto";
  }
  public String getNumberOptionsUno() {
    return "Mantener siempre";
  }
  public String getNumberOptionsDos() {
    return "Reiniciar en cada carpeta";
  }
  public String getNumberOptionsTres() {
    return "Reiniciar en cada cambio de nombre";
  }
  public String getNumberOptionsCuatro() {
    return "Sólo si es necesario";
  }
  public String getNumberOptionsCinco() {
    return "Detecta y continúa";
  }

  public String getFileCut() {
    return "Corte";
  }
  public String getFileFrom() {
    return "Desde";
  }
  public String getFileTo() {
    return "Hasta";
  }
  public String getFileSection() {
    return "Sección";
  }
  public String getFileOnly() {
    return "Sólo sección";
  }
  public String getFileEnd() {
    return "Hasta final del texto";
  }
  public String getFileBeginning() {
    return "Hasta principio del texto";
  }

  public String getFileBetween() {
    return "Entre";
  }
  public String getFileAnd() {
    return " y ";
  }

  public String getFolderSame() {
    return "Sin cambios";
  }
  public String getFolderUpper() {
    return "Mayúsculas";
  }
  public String getFolderLower() {
    return "Minúsculas";
  }

  public String getDateOne() {
    return "DDMMAAAA";
  }
  public String getDateTwo() {
    return "DDMMAA";
  }
  public String getDateThree() {
    return "MMAAAA";
  }
  public String getDateFour() {
    return "MMAA";
  }
  public String getDateFive() {
    return "AAAAMMDD";
  }
  public String getDateSix() {
    return "AAMMDD";
  }
  public String getDateSeven() {
    return "AAAAMM";
  }
  public String getDateEight() {
    return "AAMM";
  }
  public String getDateNine() {
    return "MMDDAAAA";
  }
  public String getDateTen() {
    return "MMDDAA";
  }
  public String getDateEleven() {
    return "AAAA";
  }

  public String getCamMake() {
    return "Marca";
  }
  public String getCamModel() {
    return "Modelo";

  }
  public String getCamWidth() {
    return "Ancho";
  }
  public String getCamHeight() {
    return "Alto";
  }
  public String getCamAperture() {
    return "Valor Apertura";
  }
  public String getCamExposure() {
    return "Tiempo Exposición";
  }
  public String getCamExposureBias() {
    return "Compensación de exposición";
  }
  public String getCamIso() {
    return "Velocidad ISO";
  }
  public String getCamBrightness() {
    return "Valor Brillo";
  }
  public String getCamFocal() {
    return "Longitud Foco";
  }
  public String getCamColor() {
    return "Espacio Color";
  }

  public String getTipCut() {
    return "<html>Patrón a partir del cual se dividirá el texto seleccionado.<br> Si se deja vacío, recoge todo el texto.<br> Admite expresiones regulares.<br><br>Algunos ejemplos:<br><br><b>[0-9]+</b> Corta por todos los grupos de números<br><b>[0-9]</b> Corta por cada dígito por separado<br><b>[a-zA-Z]+</b> Corta por cada grupo de cadena alfabética<br><b>[^abc]</b> Corta por todos los caracteres excepto 'a', 'b' y 'c'<br><b>\\(.*\\)</b> Corta por todo lo que se encuentre entre paréntesis (incluidos estos)<br><b>_|-</b> Corta por los caracteres '_' o '-'<br><b>[0-9]|M</b> Corta por cada dígito o por la letra 'M'</html>";
  }
  public String getTipSection() {
    return "<html>Fragmento del texto cortado que se usará para renombrar.<br>Empezará a contar desde el final si se selecciona la opción 'Hasta principio del texto'</html>";
  }
  public String getTipReplace() {
    return "<html>Admite <b>expresiones regulares.</b><br><br>Algunos ejemplos:<br><br><b>[0-9]+</b> Selecciona todos los grupos de números<br><b>[0-9]</b> Selecciona cada dígito por separado<br><b>[a-zA-Z]+</b> Selecciona todas las cadenas alfabéticas<br><b>[^abc]</b> Selecciona todos los caracteres excepto a, b y c<br><b>^casa</b> Busca archivos con la palabra casa al principio<br><b>casa$</b> Busca archivos con la palabra casa si está al final<br><br><b>Capturar grupos:</b><br><br>Se pueden capturar patrones encerrando entre paréntesis cada grupo.<br>A través del signo $ se puede hacer referencia a cada grupo capturado. $1 es el primer grupo, $2 el segundo, etc.<br><br>Ejemplo:<br><br><b>Nombre de archivo:</b> Foto_001<br><b>Patrón:</b> ([a-zA-Z]+)(_)([0-9]+)<br><b>Referencia:</b> $3-$1<br><b>Resultado:</b> 001-Foto</html>";
  }
  public String getTipFilter() {
    return "<html>Admite expresiones regulares.<br><br>Algunos ejemplos:<br><br><b>.{20}</b> Busca todos los archivos con nombres de 20 caracteres o más<br><b>[0-9]</b> Busca todos los archivos que contengan números<br><b>[-?_]</b> Busca archivos que contengan al menos uno de los caracteres entre corchetes<br><b>^casa</b> Busca archivos con la palabra casa al principio<br><b>casa$</b> busca archivos con la palabra casa al final<br><b>.jpg$</b> busca archivos con la extensión jpg</html>";
  }
  public String getTipCapture() {
    return "<html>Admite <b>expresiones regulares</b>.<br><br>Escribe aquí la referencia a los grupos capturados<br><br>$1 es el primer grupo, $2 el segundo, etc.</html>";
  }

  public String getCopiaOk() {
    return "Aceptar";
  }
  public String getCopiaTitle() {
    return "Selecciona carpeta";
  }

  public String getLicenseTitle() {
    return "Acuerdo de licencia";
  }

  public String getAboutTitle() {
    return "Acerca de";
  }
  public String getAboutLabel() {
    return "Versión";
  }
  public String getAboutLicense() {
    return "Licencia";
  }

  public String getWarningFile() {
    return "El archivo ";
  }
  public String getWarningExists() {
    return "Ya existe";
  }
  public String getWarningWarning() {
    return "El archivo destino ya existe";
  }
  public String getWarningAction() {
    return "Por favor, elija una acción";
  }
  public String getWarningSource() {
    return "Archivo origen:";
  }
  public String getWarningTarget() {
    return "Archivo destino:";
  }
  public String getWarningOverwrite() {
    return "Sobreescribir";
  }
  public String getWarningSkip() {
    return "Omitir";
  }
  public String getWarningLabelAction() {
    return "Acción";
  }
  public String getWarningAlways() {
    return "Ejecuta siempre esta acción";
  }

  public String getForbiddenWindows() {
    return "Operación de copia prohibida en Windows";
  }

  public String getErrorLabel() {
    return "Sin acceso a ";
  }
  public String getCopyLabel() {
    return "Copia:";
  }
  public String getMoveLabel() {
    return "Mover:";
  }

  public String getInfoFolder() {
    return "carpetas";
  }
  public String getInfoFile() {
    return "archivos";
  }
  public String getInfoLoading() {
    return "Cargando";
  }
  public String getFilechanged() {
    return "cambiados";
  }

  public String getFiltroOn() {
    return "Filtro activado";
  }
  public String getError() {
    return "Error";
  }
  public String getErrors() {
    return "Errores";
  }

  public String getModoAll() {
    return "Reemplaza todo";
  }
  public String getModoFirst() {
    return "Reemplaza primera";
  }

  public String getOptionYes() {
    return "Sí";
  }
  public String getOptionYesAll() {
    return "Sí a todo";
  }
  public String getOptionCancel() {
    return "Cancelar";
  }

  public String getManualOrder() {
    return "Ordenación manual";
  }
  public String getNameOrder() {
    return "Ordenar por nombre";
  }
  public String getCameraDateOrder() {
    return "Ordenar por fecha de imagen";
  }
  public String getLastOrder() {
    return "Ordenar por fecha";
  }
  public String getExtensionOrder() {
    return "Ordenar por extensión";
  }
  public String getSizeOrder() {
    return "Ordenar por tamaño de archivo";
  }
  public String getNumberOrder() {
    return "Ordenación inteligente por números";
  }

  public String getSorting() {
    return "Reordenar";
  }

  public String getPopUp() {
    return "Sube";
  }
  public String getPopDown() {
    return "Baja";
  }
  public String getPopTop() {
    return "Arriba";
  }
  public String getPopBottom() {
    return "Abajo";
  }
  public String getNormal() {
    return "Orden normal";
  }
  public String getReverse() {
    return "Orden inverso";
  }

  public String getLogFile() {
    return "fichero log";
  }
  public String getChooseLogFile() {
    return "Elige fichero log";
  }
  public String getChooseDateFile() {
    return "Elige fecha log";
  }

  public String getLogCurrent() {
    return "Archivos actuales";
  }
  public String getLogRecover() {
    return "Archivos por recuperar";
  }

  public String getFilterImg() {
    return "-- Imagen";
  }
  public String getFilterAudio() {
    return "-- Audio";
  }
  public String getFilterVideo() {
    return "-- Vídeo";
  }

  public String getName() {
    return "Nombre: ";
  }
  public String getLength() {
    return "Tamaño: ";
  }
  public String getModified() {
    return "Modificado: ";
  }

  public String getOpcionPreview() {
    return "Previsualizar imágenes";
  }
  public String getOpcionSolo() {
    return "Sólo en el panel info";
  }
  public String getOpcionAmbos() {
    return "En panel info y ventana de archivos";
  }

  public String getBarMp3() {
    return "Actualizando archivo de audio";
  }
  public String getBarBrowse() {
    return "Navegando";
  }
  public String getBarMp3Write() {
    return "Escribiendo archivo de audio";
  }
  public String getBarPreview() {
    return "Creando vista previa";
  }
  public String getBarApply() {
    return "Aplicando cambios";
  }
  public String getBarSort() {
    return "Reordenando archivos";
  }
  public String getDescription() {
    return "Renombrador masivo fácil de usar con multitud de opciones";
  }

  public String getPanelText() {
    return "Lista personalizada";
  }
  public String getTextHelp() {
    return "Escribe o suelta nombres personalizados, uno por línea";
  }
  public String getTextApply() {
    return "Aplicar sobre: ";
  }
  public String getTextFiles() {
    return "Archivo";
  }
  public String getTextFolders() {
    return "Carpetas";
  }
  public String getTextExtension() {
    return "Añadir extensión de archivos originales";
  }

  public String getUnoMove() {
    return "Mover";
  }

  public String getInfoRenamed() {
    return "R = Renombrados";
  }
  public String getInfoMoved() {
    return "M = Movidos";
  }

  public String getDropHere() {
    return "Arrastra y suelta archivos aquí";
  }
  public String getDropNot() {
    return "O sal del Modo Drop para navegar dentro de la aplicación";
  }

  public String getDropRepetidos() {
    return "No se permiten ficheros o carpetas repetidos";
  }
  public String getDropMixtos() {
    return "No se permiten ficheros y carpetas al mismo tiempo";
  }

  public String getFromFile() {
    return "Etiqueta desde nombre de archivo";
  }
  public String getFromFolder() {
    return "Desde nombre de carpeta";
  }
  public String getFromTag() {
    return "Desde etiquetas actuales";
  }
  public String getFromLast() {
    return "Desde Last.fm";
  }

  public String getMp3Modify() {
    return "Modifica";
  }

  public String getMp3Keep() {
    return "Mantener";
  }
  public String getMp3Upper() {
    return "Mayúsculas";
  }
  public String getMp3Lower() {
    return "Minúsculas";
  }
  public String getMp3First() {
    return "Solo primera";
  }
  public String getMp3Title() {
    return "Tipo Título";
  }

  public String getTagFor() {
    return "Escribe etiqueta para";
  }

  public String getCredits() {
    return "Créditos";
  }

}
