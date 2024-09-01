package vrenamer;
import java.io.File;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.Arrays;
import org.apache.commons.io.comparator.*;


public class FicherosRecursivo {
    private List<File> ficherosTemporal;
    private File[] ficherosTotal;
    private String filtrado;
    private String[] Filtro;
    private Boolean oculto, Case, excluye;
    private Boolean Coincide = true;
    private Boolean cancelarCopia = false;
    private Boolean recorreDirectorio;
    private int cuentaArchivos;
    private idiomas Idioma;

    public FicherosRecursivo (String filtrado, Boolean oculto, Boolean Case, Boolean excluye, Boolean recorreDirectorio, idiomas Idioma) {
      this.filtrado = filtrado;
      this.oculto = oculto;
      this.Case = Case;
      this.excluye = excluye;
      this.recorreDirectorio = recorreDirectorio;
      this.Idioma = Idioma;
      ficherosTemporal = new ArrayList<>();
    }

    public java.util.List<File> recorre( String path ) {
	  File root = new File( path );
	  File[] list = root.listFiles();
	  Arrays.sort(list, NameFileComparator.NAME_INSENSITIVE_COMPARATOR);
	  String filtradoCopia = filtrado;
	  String filtroMin;
	  String filtro = ".*"+filtrado+".*";
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
	  for ( File fichero : list ) {
	      filtrado = filtradoCopia;
	      filtroMin = filtrado.toLowerCase();
	      filtroMin = ".*"+filtroMin+".*";
	      filtro = ".*"+filtrado+".*";
	      if (filtrado.matches("\\.\\{[0-9]+\\}")) {
		  int ultimoPunto = fichero.getName().lastIndexOf('.');
		  if (ultimoPunto > 0 && ultimoPunto < fichero.getName().length() -1 && ! fichero.isDirectory()) {
		      int longExtension = fichero.getName().substring(ultimoPunto).length();
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
	      if ( fichero.isDirectory() && !isSymlink(fichero) && (oculto || !fichero.isHidden()) ) {
//			     System.out.println(fichero);
		  try {
		    recorre( fichero.getAbsolutePath() );
		  }
		  catch (NullPointerException np) {
		    continue;
		  }
	      }
	      if (((recorreDirectorio && fichero.isDirectory()) || (!recorreDirectorio && !fichero.isDirectory())) && (oculto || !fichero.isHidden())) {
		  if (!filtrado.equals("")) {
		    if (excluye) {
			if (Case) {
			    try {
				Coincide = !fichero.getName().matches(filtro);
			    }
			    catch (PatternSyntaxException e) {
				Coincide = !fichero.getName().contains(filtrado);
			    }
			}
			else {
			  try {
			    if (Filtro.length == 1) Coincide = !fichero.getName().toLowerCase().matches(filtroMin);
			    else {
				for (int y=0;y<Filtro.length;y++) {
				    if (fichero.getName().toLowerCase().endsWith(Filtro[y])) {
					Coincide = false;
					break;
				    }
				    else Coincide = true;
				}
			    }
			  }
			  catch (PatternSyntaxException e) {
			      Coincide = !fichero.getName().toLowerCase().contains(filtrado.toLowerCase());
			  }
			}
		    }
		    else {
			if (Case) {
			    try {
				Coincide = fichero.getName().matches(filtro);
			    }
			    catch (PatternSyntaxException e) {
				Coincide = fichero.getName().contains(filtrado);
			    }
			}
			else {   
			    try {
			      if (Filtro.length == 1) Coincide = fichero.getName().toLowerCase().matches(filtroMin);
			      else {
				  for (int y=0;y<Filtro.length;y++) {
				      if (fichero.getName().toLowerCase().endsWith(Filtro[y])) {
					  Coincide = true;
					  break;
				      }
				      else Coincide = false;
				  }
			      }
			    }
			    catch (PatternSyntaxException e) {
				Coincide = fichero.getName().toLowerCase().contains(filtrado.toLowerCase());
			    }
			}
		    }
		  }
		  if (Coincide) {
		      cuentaArchivos++;
		      ficherosTemporal.add(fichero);
		  }
	    }
	    if (preguntaCancela()) {
	      ficherosTemporal = new ArrayList<>();
	      ficherosTemporal.add(new File("busquedaCancelada"));
	      return ficherosTemporal;
	    }
	  }
/*	  ficherosTotal = new File [ficherosTemporal.size()];
	  for (int x=0;x<ficherosTotal.length;x++) ficherosTotal[x] = ficherosTemporal.get(x);*/
	  return ficherosTemporal;
    }
    public void cancelaCopia() {
      cancelarCopia = true;
    }
    public Boolean preguntaCancela() {
      return cancelarCopia;
    }

    public int getCuentaArchivos() {
      ficherosTemporal.clear();
      return cuentaArchivos;
    }
    public static boolean isSymlink(File file) {
      File canon = file;
      Boolean checkFile = false;
      if (file.getParent() == null) {
	canon = file;
      } 
      else {
	try {
	  File canonDir = file.getParentFile().getCanonicalFile();
	  canon = new File(canonDir, file.getName());
	}
	catch (IOException io) {
	}
      }
      try {
	checkFile = !canon.getCanonicalFile().equals(canon.getAbsoluteFile());
      }
      catch (IOException io) {
      }
      return checkFile;
    }

}
