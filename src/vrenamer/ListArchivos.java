package vrenamer;

import java.io.File;
import java.util.*;
import java.util.regex.*;
import java.util.Arrays;
import org.apache.commons.io.comparator.*;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;
import java.util.Date;

public class ListArchivos{
  private File[] ficherosAbstractFiltrado, renombradosAbstractFiltrado;
  private String ruta;
  private FicherosRecursivo fichRecursivos;
  private StringBuffer[] FicherosCompleto, Renombrados;
  private int [] okSeleccion;
  private int cuentaArchivos, cuentaCarpetas;
  private int numeroDetecta;
  private Boolean cancelarCopia;
  private Boolean recorreDirectorio;
  private final static String separador = System.getProperty("file.separator");

  public ListArchivos(String ruta){
    this.ruta=ruta;
  }

  public StringBuffer[] getFicheros(String filtrado, Boolean oculto, Boolean Case, Boolean excluye, Boolean recursivo, Boolean recorreDirectorio, idiomas Idioma){
    cancelarCopia = false;
    List<File> ficherosAbstractInter = new ArrayList<>();
    fichRecursivos = new FicherosRecursivo(filtrado, oculto, Case, excluye, recorreDirectorio, Idioma);
    if (!recursivo) {
      Boolean Coincide = true;
      File archiv = new File(ruta);
      ficherosAbstractFiltrado = archiv.listFiles();
      if (ficherosAbstractFiltrado != null) {
	Arrays.sort(ficherosAbstractFiltrado, NameFileComparator.NAME_INSENSITIVE_COMPARATOR);
	ficherosAbstractInter.add(new File(ruta+".."));
          for (File ficherosAbstractFiltrado1 : ficherosAbstractFiltrado) {
              if (ficherosAbstractFiltrado1.isDirectory() && ficherosAbstractFiltrado1.listFiles() != null && (oculto || !ficherosAbstractFiltrado1.isHidden())) {
                  ficherosAbstractInter.add(ficherosAbstractFiltrado1);
                  cuentaCarpetas++;
              }
          }
	String filtradoCopia = filtrado;
	String filtroMin;
	String filtro = ".*"+filtrado+".*";
	String[] Filtro;
	if (filtrado.equals(Idioma.getFilterImg())) {
	    Filtro = new String[] {".jpg", ".jpeg", ".tif", ".tiff", ".gif", ".png", ".bmp"};
	    Case = false;
	}
	else if (filtrado.equals(Idioma.getFilterAudio())) {
	    Filtro = new String[] {".aac", ".mp3", ".ogg", ".ra", ".wma", ".wav", ".flac", ".mid", ".mka", ".m3u"};
	    Case = false;
	}
	else if (filtrado.equals(Idioma.getFilterVideo())) {
	    Filtro = new String[] {".asf", ".avi", ".mov", ".mp4", ".asx", ".ogv", ".ogm", ".mkv", ".3gp", ".mpg", ".mpeg", ".flv", ".wmv"};
	    Case = false;
	}
	else if (filtrado.equals("-- Office")) {
	    Filtro = new String[] {".doc", ".docx", ".odt", ".rtf", ".txt", ".sxw", ".ods", ".xls", ".csv", ".odp", ".ppt", ".pps"};
	    Case = false;
	}
	else {
	    Filtro = new String[1];
	    Filtro[0] = filtro;
	}

	for (int x=0;x<ficherosAbstractFiltrado.length;x++) {
	  filtrado = filtradoCopia;
	  filtroMin = filtrado.toLowerCase();
	  filtroMin = ".*"+filtroMin+".*";
	  filtro = ".*"+filtrado+".*";
	  if (filtrado.matches("\\.\\{[0-9]+\\}")) {
	      int ultimoPunto = ficherosAbstractFiltrado[x].getName().lastIndexOf('.');
	      if (ultimoPunto > 0 && ultimoPunto < ficherosAbstractFiltrado[x].getName().length() -1 && ! ficherosAbstractFiltrado[x].isDirectory()) {
		  int longExtension = ficherosAbstractFiltrado[x].getName().substring(ultimoPunto).length();
		  int longOriginal = Integer.parseInt(filtrado.substring(2,filtrado.lastIndexOf('}')));
		  int nuevoLong = longOriginal + longExtension;
		  if (nuevoLong > 0 ) {
		      filtrado = ".{" + nuevoLong + "}";
		      filtroMin = filtrado.toLowerCase();
		      filtroMin = ".*"+filtroMin+".*";
		      filtro = ".*"+filtrado+".*";
		  }
	      }
	  }

	  if (!ficherosAbstractFiltrado[x].isDirectory() && (oculto || !ficherosAbstractFiltrado[x].isHidden())) {
	    if (!filtrado.equals("")) {
	      if (excluye) {
		if (Case) {
		  try {
		    Coincide = !ficherosAbstractFiltrado[x].getName().matches(filtro);
		  }
		  catch (PatternSyntaxException e) {
		    Coincide = !ficherosAbstractFiltrado[x].getName().contains(filtrado);
		  }
		}
		else {
		  try {
		     if (Filtro.length == 1) Coincide = !ficherosAbstractFiltrado[x].getName().toLowerCase().matches(filtroMin);
		     else {
			for (int y=0;y<Filtro.length;y++) {
			    if (ficherosAbstractFiltrado[x].getName().toLowerCase().endsWith(Filtro[y])) {
				Coincide = false;
				break;
			    }
			    else Coincide = true;
			}
		     }
		  }
		  catch (PatternSyntaxException e) {
		    Coincide = !ficherosAbstractFiltrado[x].getName().toLowerCase().contains(filtrado.toLowerCase());
		  }
		}
	      }
	      else {
		if (Case) {
		  try {
		     Coincide = ficherosAbstractFiltrado[x].getName().matches(filtro);
		  }
		  catch (PatternSyntaxException e) {
		    Coincide = ficherosAbstractFiltrado[x].getName().contains(filtrado);
		  }
		}
		else {   
		  try {
		    if (Filtro.length == 1) Coincide = ficherosAbstractFiltrado[x].getName().toLowerCase().matches(filtroMin);
		     else {
			for (int y=0;y<Filtro.length;y++) {
			    if (ficherosAbstractFiltrado[x].getName().toLowerCase().endsWith(Filtro[y])) {
				Coincide = true;
				break;
			    }
			    else Coincide = false;
			}
		      }

		  }
		  catch (PatternSyntaxException e) {
		    Coincide = ficherosAbstractFiltrado[x].getName().toLowerCase().contains(filtrado.toLowerCase());
		  }
		}
	      }
	    }
	    if (Coincide) {
	      ficherosAbstractInter.add(ficherosAbstractFiltrado[x]);
	      cuentaArchivos++;
	    }
	  }
	}
	FicherosCompleto = new StringBuffer[ficherosAbstractInter.size()];
	Renombrados = new StringBuffer[ficherosAbstractInter.size()];
	ficherosAbstractFiltrado = new File[ficherosAbstractInter.size()];
	renombradosAbstractFiltrado = new File[ficherosAbstractInter.size()];
	for (int x=0;x<FicherosCompleto.length;x++) {
	  FicherosCompleto[x] = new StringBuffer().append(ficherosAbstractInter.get(x).getName());
	  Renombrados[x] = new StringBuffer().append(ficherosAbstractInter.get(x).getName());
	  ficherosAbstractFiltrado[x] = ficherosAbstractInter.get(x);
	  renombradosAbstractFiltrado[x] = ficherosAbstractInter.get(x);
	}
       } else FicherosCompleto = null;
      } else {
	java.util.List<File> recursivosFile = fichRecursivos.recorre(ruta);
	recursivosFile.add(0, new File(ruta+".."));
	ficherosAbstractFiltrado = new File[recursivosFile.size()];
	ficherosAbstractFiltrado = recursivosFile.toArray(ficherosAbstractFiltrado);
	FicherosCompleto = new StringBuffer[ficherosAbstractFiltrado.length];
	Renombrados = new StringBuffer[ficherosAbstractFiltrado.length];
	renombradosAbstractFiltrado = new File[ficherosAbstractFiltrado.length];
	for (int x=0;x<ficherosAbstractFiltrado.length;x++) {
	  FicherosCompleto[x] = new StringBuffer().append(ficherosAbstractFiltrado[x].getName());
	  Renombrados[x] = new StringBuffer().append(ficherosAbstractFiltrado[x].getName());
	  renombradosAbstractFiltrado[x] = ficherosAbstractFiltrado[x];
	  if ( ! recorreDirectorio) {
	      cuentaCarpetas = 0;
	      cuentaArchivos = fichRecursivos.getCuentaArchivos();
	  } else {
	      cuentaCarpetas = fichRecursivos.getCuentaArchivos();
	      cuentaArchivos = 0;
	  }
	}
	fichRecursivos = null;
      }
      return FicherosCompleto;
  }
  public void cancelaCopia() {
    if (fichRecursivos != null) fichRecursivos.cancelaCopia();
    cancelarCopia = true;
  }

    public Boolean reordenaAuto (File[] ficherosAbstractFiltrado, int[] okSeleccion, Boolean copia, String opcion, int posicion, idiomas Idioma) {
	this.ficherosAbstractFiltrado = ficherosAbstractFiltrado;
	this.okSeleccion = okSeleccion;
	int i = 0;
	cancelarCopia = false;
	File [] ficherosProvisional = new File[okSeleccion.length];
	for (int x=0;x<okSeleccion.length;x++) {
	    ficherosProvisional[x] = ficherosAbstractFiltrado[okSeleccion[x]];
	}
	if (opcion.equals("order-nameNormal")) Arrays.sort(ficherosProvisional, NameFileComparator.NAME_INSENSITIVE_COMPARATOR );
	else if (opcion.equals("order-nameReverse")) Arrays.sort(ficherosProvisional, NameFileComparator.NAME_INSENSITIVE_REVERSE );
	else if (opcion.equals("order-lastNormal")) Arrays.sort(ficherosProvisional, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
	else if (opcion.equals("order-lastReverse")) Arrays.sort(ficherosProvisional, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
	else if (opcion.equals("order-extensionNormal")) Arrays.sort(ficherosProvisional, ExtensionFileComparator.EXTENSION_INSENSITIVE_COMPARATOR);
	else if (opcion.equals("order-extensionReverse")) Arrays.sort(ficherosProvisional, ExtensionFileComparator.EXTENSION_INSENSITIVE_REVERSE);
	else if (opcion.equals("order-sizeNormal")) Arrays.sort(ficherosProvisional, SizeFileComparator.SIZE_COMPARATOR);
	else if (opcion.equals("order-sizeReverse")) Arrays.sort(ficherosProvisional, SizeFileComparator.SIZE_REVERSE);
	else if (opcion.startsWith("order-dateCamera")) {
	    MotorBusca MB = new MotorBusca(Idioma);
	    List<comparaArchivo> fechasPorOrdenar = new ArrayList<>();
	    for (int x=0;x<okSeleccion.length;x++) {
		String fechaFormateada = MB.getFechaMeta(ficherosProvisional[x].toString(), 0, '1').replace("File:","") + "-" + MB.getFechaMeta(ficherosProvisional[x].toString(), 11, '1').replace("File:","");
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date fechaCamara = formatoFecha.parse( fechaFormateada, new ParsePosition(0) );
		long fechaLong = fechaCamara.getTime();
		fechasPorOrdenar.add( new comparaArchivo(ficherosProvisional[x].toString(), fechaLong) ); 
		if (cancelarCopia) return false;
	    }
	    Collections.sort(fechasPorOrdenar, new FechaComparator());
            switch (opcion) {
                case "order-dateCameraNormal":
                    for (int x=0;x<fechasPorOrdenar.size();x++) {
                        ficherosProvisional[x] = new File ( fechasPorOrdenar.get(x).getArchivo() );
                    }
                    break;
                case "order-dateCameraReverse":
                    int c = 0;
                    for (int x=fechasPorOrdenar.size() -1 ;x>=0;x--) {
                      ficherosProvisional[x] = new File ( fechasPorOrdenar.get(c).getArchivo() );
                      c++;
                  } break;
            }
	} else if (opcion.startsWith("order-number")) {
	    String numeroOrdenString = "";
	    long numeroOrden;
	    long numeroMaximo = 0;
	    List<comparaNumero> numeroPorOrdenar = new ArrayList<>();
	    List<File> sinNumero = new ArrayList<>();
	    Arrays.sort(ficherosProvisional, NameFileComparator.NAME_INSENSITIVE_COMPARATOR );
	    for (int x=0;x<okSeleccion.length;x++) {
		if (new File(ficherosProvisional[x].toString().replaceAll("\\.\\.$","")).isDirectory()) {
		    continue;
		}
		int cuentaPosicion = 1;
		Boolean numeroNoValido = false;
		Boolean numeroDetectado = false;
		String ficheroActual = new File (ficherosProvisional[x].toString()).getName();
		int ultimoPunto = ficheroActual.lastIndexOf('.');
		if (ultimoPunto > 0 && ultimoPunto < ficheroActual.length() -1) {
		    ficheroActual = ficheroActual.substring(0, ultimoPunto);
		}
		for (int z=0;z<ficheroActual.length();z++) {
		    if (ficheroActual.substring(z,z+1).matches("[0-9]")) {
			numeroNoValido = true;
			if (posicion == cuentaPosicion) {
			    numeroOrdenString = numeroOrdenString + ficheroActual.substring(z,z+1);				
			    numeroDetectado = true;
			}
		    } else {
			if (numeroDetectado) break;
			if (numeroNoValido) {
			    cuentaPosicion++;
			    numeroNoValido = false;
			}
		    }
		}
		if ( ! numeroOrdenString.equals("") ) {
		    numeroOrden = Long.parseLong(numeroOrdenString);
		    if (numeroOrden > numeroMaximo) numeroMaximo = numeroOrden;
		    numeroPorOrdenar.add( new comparaNumero(ficherosProvisional[x].toString(), numeroOrden) ); 		
		} else {
		    sinNumero.add(ficherosProvisional[x]);
		}
		numeroOrdenString = "";
		if (cancelarCopia) return false;
	    }
	    numeroDetecta = (int) numeroMaximo;
	    for (int x=0;x<sinNumero.size();x++) numeroPorOrdenar.add( new comparaNumero(sinNumero.get(x).toString(), numeroMaximo + x ) );
	    Collections.sort(numeroPorOrdenar, new numeroComparator());
            switch (opcion) {
                case "order-numberNormal":
                    for (int x=0;x<numeroPorOrdenar.size();x++) {
                        ficherosProvisional[x] = new File ( numeroPorOrdenar.get(x).getArchivo() );
                    }
                    break;
                case "order-numberReverse":
                    int c = 0;
                    for (int x=numeroPorOrdenar.size() -1 ;x>=0;x--) {
                      ficherosProvisional[x] = new File ( numeroPorOrdenar.get(c).getArchivo() );
                      c++;
                    }
                    break;
            }
	}
	for (int x=0;x<okSeleccion.length;x++) 
	    ficherosAbstractFiltrado[okSeleccion[x]] = ficherosProvisional[x];
	FicherosCompleto = new StringBuffer[ficherosAbstractFiltrado.length];
	Renombrados = new StringBuffer[ficherosAbstractFiltrado.length];
	renombradosAbstractFiltrado = new File[ficherosAbstractFiltrado.length];
	for (int x=0;x<ficherosAbstractFiltrado.length;x++) {
	    FicherosCompleto[x] = new StringBuffer().append(ficherosAbstractFiltrado[x].getName());
	    Renombrados[x] = new StringBuffer().append(ficherosAbstractFiltrado[x].getName());
	    renombradosAbstractFiltrado[x] = ficherosAbstractFiltrado[x];
	}
	return true;
    }
    public void reordena (int indiceFinal, int[] indicesOrigen, Boolean copia) {
	java.util.List<File> archivosList = new LinkedList<>(Arrays.asList(ficherosAbstractFiltrado));
	java.util.List<File> archivosListCopia = new ArrayList<>();
	okSeleccion = Arrays.copyOf(indicesOrigen, indicesOrigen.length);
	if ( ! (indicesOrigen[indicesOrigen.length - 1] < indiceFinal || indicesOrigen[0] > indiceFinal) )
	    return;
	for (int x=0;x<indicesOrigen.length;x++)
	    archivosListCopia.add(archivosList.get(indicesOrigen[x]));
	archivosList.removeAll(archivosListCopia);
	if (indicesOrigen[indicesOrigen.length - 1] < indiceFinal)
	    indiceFinal -= indicesOrigen.length;
	for (int x=0;x<archivosListCopia.size();x++) {
	    archivosList.add(indiceFinal, archivosListCopia.get(x));
	    okSeleccion[x] = indiceFinal;
	    indiceFinal++;
	}
	ficherosAbstractFiltrado = new File[archivosList.size()];
	archivosList.toArray(ficherosAbstractFiltrado);
	setOriginales(ficherosAbstractFiltrado);
	if ( ! copia )	
	    setRenombrados(ficherosAbstractFiltrado);
    }
    public void setRenombrados(StringBuffer[] RenombradosProv) {
      renombradosAbstractFiltrado = new File [RenombradosProv.length];
      for (int x=0;x<renombradosAbstractFiltrado.length;x++) 
	  renombradosAbstractFiltrado[x] = new File (ficherosAbstractFiltrado[x].getParent() + separador + RenombradosProv[x].toString());
    }
    public void setRenombrados(File[] renombradosAbstractFiltrado) {
      this.renombradosAbstractFiltrado = renombradosAbstractFiltrado;
      Renombrados = new StringBuffer[renombradosAbstractFiltrado.length];
      for (int x=0;x<renombradosAbstractFiltrado.length;x++) {
	  Renombrados[x] = new StringBuffer().append(renombradosAbstractFiltrado[x].getName());
      }
    }
    public void setOriginales(File[] ficherosAbstractFiltrado) {
      this.ficherosAbstractFiltrado = ficherosAbstractFiltrado;
      FicherosCompleto = new StringBuffer[ficherosAbstractFiltrado.length];
      for (int x=0;x<ficherosAbstractFiltrado.length;x++) {
	  FicherosCompleto[x] = new StringBuffer().append(ficherosAbstractFiltrado[x].getName());
      }
    }
    public StringBuffer[] getArchReordenados() {
      return FicherosCompleto;
    }
    public StringBuffer[] getRenomReordenados() {
      return Renombrados;
    }
    public File[] getRenombradosFinal() {
      return renombradosAbstractFiltrado;
    }
    public int[] getOkSeleccion() {
      return okSeleccion;
    }
    public File[] getAbstractFiltrado() {
      return ficherosAbstractFiltrado;
    }
    public int getCuentaCarpetas() {
      return cuentaCarpetas;
    }
    public int getCuentaArchivos() {
      return cuentaArchivos;
    }
    public void setCuentaArchivos(int cuentaArchivos) {
      this.cuentaArchivos = cuentaArchivos;
    }
    public void setCuentaCarpetas(int cuentaCarpetas) {
      this.cuentaCarpetas = cuentaCarpetas;
    }
    public int getUltimaCarpeta(){
	int z=0;
	File archiv;
	if (FicherosCompleto == null)
	    return 0;
	for (int x=0;x<FicherosCompleto.length;x++){
	    archiv = ficherosAbstractFiltrado[x];
	    if (archiv.isFile()) {
		z=x-1;
		break;
	    }
	}
	if (ficherosAbstractFiltrado.length > 0) {
	    archiv = ficherosAbstractFiltrado[ficherosAbstractFiltrado.length-1];
	    if (archiv.isDirectory()) z=FicherosCompleto.length-1;
	} else return 0;
	return z;
    }
    public int getNumeroDetecta() {
      return numeroDetecta;
    }
}
