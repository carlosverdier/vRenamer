package vrenamer;

import java.util.*;
import java.io.File;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParsePosition;
import java.io.*;
import com.drew.metadata.*;
import com.drew.imaging.*;
import java.util.regex.*;
import java.util.GregorianCalendar;
import java.nio.charset.Charset;
import java.net.URLDecoder;

public class MotorBusca {
  final static String separador = System.getProperty("file.separator");
  final static String rutaHome = System.getProperty("user.home");
  final static String codificacion = Charset.defaultCharset().toString();

  private File[] archivosOriginales;
  private int [] indSeleccionados;
  private StringBuffer[] FicherosComp, motorArchivos;
  private String extensionAnterior, sinExtension, rutaRE;
  private int indice, diasMes;
  private Boolean cancelaCopia = false; 
  private metaMp3 datosMp3;
  private metaMp3Escribe inMp3;
  private idiomas Idioma;
  private Locale locale;
  private java.util.List<Integer> indicesMarcar;
  private java.util.List<Integer> indicesCambiados;
  private java.util.List<Integer> indicesCiclo;
  private static String letters;
  private String binary;

  @SuppressWarnings("unchecked")
  private Hashtable<String, Integer>[] ht = (Hashtable<String,Integer>[])new Hashtable<?,?>[15];
  @SuppressWarnings("unchecked")
  private Hashtable<String, Integer>[] nd = (Hashtable<String,Integer>[])new Hashtable<?,?>[15];

  public MotorBusca(idiomas Idioma) {
      this.binary = "";
      this.letters = "";
      this.indicesCiclo = new ArrayList<>();
      this.indicesCambiados = new ArrayList<>();
      this.indicesMarcar = new ArrayList<>();
      this.Idioma = Idioma;
      datosMp3 = new metaMp3(Idioma);
      inMp3 = new metaMp3Escribe();
      if (Idioma instanceof idiomasEsp) {
	  locale = new Locale("es", "ES");
      } else {
	  locale = new Locale("en", "US");
      }
  }
  public StringBuffer[] reformaRenombrados(String rutaRE, File[] archivosOriginales, StringBuffer[] motorArchivos, StringBuffer[] FicherosComp, int[] indSeleccionados, int indice) { // Crea lista de archivos en vista previa con la opción de copiar
      this.indice = indice;
      this.archivosOriginales = archivosOriginales;
      this.indSeleccionados = indSeleccionados;
      this.FicherosComp = FicherosComp;
      this.motorArchivos = motorArchivos;
      StringBuffer[] FicherosLocal = new StringBuffer[indSeleccionados.length + FicherosComp.length];
      File [] archivosOriginalesTemp = new File[indSeleccionados.length + FicherosComp.length];
      for(int x=0;x<=indice;x++) {
	FicherosLocal[x]= new StringBuffer().append(FicherosComp[x]);
	archivosOriginalesTemp[x] = new File(rutaRE + FicherosComp[x]);
      }
      for(int x=(indice+1);x<(indice+1+indSeleccionados.length);x++) { 
	FicherosLocal[x]=new StringBuffer().append(motorArchivos[indSeleccionados[x-(indice+1)]]);
	archivosOriginalesTemp[x] = archivosOriginales[indSeleccionados[x-(indice+1)]];
      }
      for(int x=(indice+1+indSeleccionados.length);x<(indSeleccionados.length+FicherosComp.length);x++) { 
	FicherosLocal[x]=new StringBuffer().append(FicherosComp[(x-indSeleccionados.length)]);
	archivosOriginalesTemp[x] = new File(rutaRE + FicherosComp[(x-indSeleccionados.length)]);
      }
      archivosOriginales = Arrays.copyOf(archivosOriginalesTemp,archivosOriginalesTemp.length);
      setArchivosOriginales(archivosOriginales);
      return FicherosLocal;
  }
  public void setArchivosOriginales(File[] archivosOriginales) {
    this.archivosOriginales = archivosOriginales;
  }
  public String getExtension(String ruta, String completo, Boolean bolExtension, String usrExtension){
      int ultimoPunto = completo.lastIndexOf('.');
      String extension;
      if (ultimoPunto > 0 && ultimoPunto < completo.length() -1) 
          extension = completo.substring(ultimoPunto);
      else 
          extension = "";
      if (new File(ruta+separador+completo).isDirectory()) 
          extension = "";
      sinExtension = extension.equals("") ? completo : completo.substring(0, ultimoPunto);
      extensionAnterior = extension;
      if (bolExtension) {
	  if (usrExtension.equals("")) 
              extension = "";
	  else extension = 
              "." + usrExtension;
      }
      return extension;
  }
  public String getLogName(String vrenamerFolder) {
      if ( ! new File (rutaHome + separador + vrenamerFolder + separador + "renamed.log").exists() || new File (rutaHome + separador + vrenamerFolder + separador + "renamed.log").length() < 307200) 
          return "renamed.log"; 
      else {
	  int contaLog = 1;
	  while (contaLog < 3000) {
	      if ( ! new File (rutaHome + separador + vrenamerFolder + separador + "renamed.log." + contaLog).exists() || new File (rutaHome + separador + vrenamerFolder + separador + "renamed.log." + contaLog).length() < 307200) 
                  return "renamed.log." + contaLog; 
	      contaLog++;
	  }
      }
      return "renamed.log." + 3000;
  }
  public String insertaMp3 (int[] indSeleccionados, File[] archivosOriginales, String valorTag) {
      this.indSeleccionados=indSeleccionados;
      this.archivosOriginales=archivosOriginales;
      String resultadoTag = datosMp3.getMp3(archivosOriginales[indSeleccionados[0]].toString(),valorTag,"0");
        for (int x=1; x<indSeleccionados.length;x++) {
            if (!resultadoTag.equals(datosMp3.getMp3(archivosOriginales[indSeleccionados[x]].toString(),valorTag,"0"))) {
                return "";
            }
        }
      return resultadoTag;
  }
  public String[] insertaMp3Array (int[] indSeleccionados, File[] archivosOriginales, String valorTag) {
      this.indSeleccionados=indSeleccionados;
      this.archivosOriginales=archivosOriginales;
      String[] resultadoTagArray = new String[indSeleccionados.length];
      for (int x=0; x<indSeleccionados.length;x++) {
	  resultadoTagArray[x] = datosMp3.getMp3(archivosOriginales[indSeleccionados[x]].toString(),valorTag,"0");
      }
      return resultadoTagArray;
  }
  public void ponMp3(int[] indSeleccionados, File[] archivosOriginales, Boolean incrementa, String[] pista, String[] cancion, String[] artista, String[] album, String[] anyo, String[] genero, String[] pistaActual, String[] cancionActual, String[] artistaActual, String[] albumActual, String[] anyoActual, String[] generoActual, String vrenamerFolder){
      this.indSeleccionados=indSeleccionados;
      this.archivosOriginales=archivosOriginales;
      int incrementaInt = 0;
      if (incrementa) {
	  incrementaInt = Integer.parseInt(pista[0]);
      }
      PrintStream pwLog = null;
      try {
	  String logName = getLogName(vrenamerFolder);
	  if ( ! new File (rutaHome + separador + vrenamerFolder + separador + logName).exists() ) pwLog = new PrintStream(new FileOutputStream(rutaHome + separador + vrenamerFolder + separador + logName), true, codificacion);
	  else pwLog = new PrintStream(new FileOutputStream(rutaHome + separador + vrenamerFolder + separador + logName, true));
	  pwLog.println("Start Mp3 Date: " + getFecha() + "  " + getHora());
      }
      catch (FileNotFoundException | UnsupportedEncodingException e) {
      } 
      for (int x=0; x<indSeleccionados.length; x++) {
	try {
	    pwLog.println(archivosOriginales[indSeleccionados[x]]);
	}
	catch (Exception e) {
	}
	if (incrementa) {
	  pista[x] = incrementaInt+"";
	  incrementaInt++;
	}
	if (!pista[x].equals("")) {
	    inMp3.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"0",pista[x]);
	    try {
		pwLog.println("    Track: " + pistaActual[x] + "-->" + pista[x]);
	    }
	    catch (Exception e) {
	    }
	}
	if (!cancion[x].equals("")) {
	    inMp3.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"1",cancion[x]);
	    try {
		pwLog.println("    Tittle: " + cancionActual[x] + "-->" + cancion[x]);
	    }
	    catch (Exception e) {
	    }
	}
	if (!artista[x].equals("")) {
	    inMp3.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"2",artista[x]);
	    try {
		pwLog.println("    Artist: " + artistaActual[x] + "-->" + artista[x]);
	    }
	    catch (Exception e) {
	    }
	}
	if (!album[x].equals("")) { 
	    try {
		pwLog.println("    Album: " + albumActual[x] + "-->" + album[x]);
	    }
	    catch (Exception e) {
	    }
	    inMp3.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"3",album[x]);
	}
	if (!anyo[x].equals("")) {
	    try {
		pwLog.println("    Year: " + anyoActual[x] + "-->" + anyo[x]);
	    }
	    catch (Exception e) {
	    }
	    inMp3.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"4",anyo[x]);
	}
	if (!genero[x].equals("")) {
	    try {
		pwLog.println("    Genre: " + generoActual[x] + "-->" + genero[x]);
	    }
	    catch (Exception e) {
	    }
	    inMp3.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"5",genero[x]);
	}
      }
      try {
	  pwLog.println("End Date: " + getFecha() + "  " + getHora());
	  pwLog.println("");
      }
      catch (Exception e) {
      } 
      finally {
	  try {
	      if (null != pwLog) pwLog.close();
	  } 
	  catch (Exception e2) {
	  }
      }
  }
  private Boolean preguntaCancela() {
      return cancelaCopia;
  }
  public void cancelarCopia() {
      cancelaCopia = true;
  }
  public Boolean recogeSeleccion (int[] indSeleccionados, StringBuffer[] FicherosComp, String[][] ordenBusca, Boolean bolExtension, String usrExtension, String[] separaText, Boolean copiaCarpeta, String rutaRenombrados, int opcionSelec, Date datoCalendario, String[] rutaEstructuraArray, String sistema) {
      this.indSeleccionados = indSeleccionados;
      this.FicherosComp = FicherosComp;
      String rutaNumeros;
      String completo;
      String[] textoCorte;
      Boolean bolSepara = true;
      Boolean append = true;
      Boolean separaElminado = false;
      cancelaCopia = false;
      String separa;
      String separaEliminar = "";
	for(int z=0;z<15;z++) ht[z] = new Hashtable<>();
	for(int z=0;z<15;z++) nd[z] = new Hashtable<>();
	for(int x=0;x<indSeleccionados.length;x++){
	    String ruta = archivosOriginales[indSeleccionados[x]].getParent();
	    if (FicherosComp[indSeleccionados[x]].toString().equals("..")) continue;
	    completo=FicherosComp[indSeleccionados[x]].toString();
	    String extension = "";
	    extensionAnterior = "";
	    String separaAnterior = "";
	    String cadenaModifica = "";
	    switch (opcionSelec) {
		case 1:
		    extension = getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, bolExtension, usrExtension);
		    cadenaModifica = sinExtension;
		break;
		case 2:
		    extension = getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, false, "");
		    if ( ! extension.equals("") ) {
			cadenaModifica = extension.substring(1,extension.length());
		    }
		break;
		case 3:
		    if (bolExtension &&  ! usrExtension.equals("")) {
			extension = "." + usrExtension;
		    }
		    cadenaModifica = completo;
		break;
	    }
	    FicherosComp[indSeleccionados[x]] = new StringBuffer().append("");
	    String rutaEstructura = separador;
	    if (rutaEstructuraArray[indSeleccionados[x]] != null) {
		rutaEstructura = rutaEstructuraArray[indSeleccionados[x]] + separador;
	    }            

	    for(int z=0;z<ordenBusca.length;z++) {
		if (separaText[z].equals("off")) {
		    bolSepara = false;
		    separa = "";
		} else {
		    separa = separaText[z];
		}
		if (separa.equals("{ }")) {
		    separa=" ";
		}
		switch(ordenBusca[z][0].charAt(0)) {
		    case '0' -> // TEXT
			FicherosComp[indSeleccionados[x]].append(ordenBusca[z][1]);
		    case '1' -> {
                        // SEQUENCE
                        int mNumero=Integer.parseInt(ordenBusca[z][2]);
                        int mSalto = Integer.parseInt(ordenBusca[z][3]);
                        int mCuantos=Integer.parseInt(ordenBusca[z][1]);
                        switch (ordenBusca[z][4].charAt(0)) {
                            case '1' -> {
                                if (copiaCarpeta) {
                                    rutaNumeros = rutaRenombrados + rutaEstructura + FicherosComp[indSeleccionados[x]].toString();
                                } else {
                                    rutaNumeros = ruta + separador + FicherosComp[indSeleccionados[x]].toString();
                                }
                                int ultimoPunto = rutaNumeros.lastIndexOf(separador);
                                if (ultimoPunto >= 0 && ultimoPunto < rutaNumeros.length() -1) {
                                    rutaNumeros = rutaNumeros.substring(0,ultimoPunto);
                                }
                                mNumero = getNumera(rutaNumeros, mNumero, mSalto, z);
                            }
                            case '2' -> mNumero = getNumera(FicherosComp[indSeleccionados[x]].toString(), mNumero, mSalto, z);
                            case '3' -> {
                                if (copiaCarpeta) {
                                    rutaNumeros = rutaRenombrados + rutaEstructura + FicherosComp[indSeleccionados[x]].toString();
                                } else {
                                    rutaNumeros = ruta + separador + FicherosComp[indSeleccionados[x]].toString();
                                }
                                if (opcionSelec == 2) {
                                    rutaNumeros = new File(rutaNumeros).getParent() + separador + sinExtension + FicherosComp[indSeleccionados[x]].toString();
                                } else {
                                    rutaNumeros += extension;
                                }
                                mNumero = getIfNeeded(rutaNumeros, mNumero, mSalto, z, x, mCuantos, separa, separaAnterior, opcionSelec, ordenBusca, separaElminado, sistema);
                            }
                            case '4' -> {
                                if (copiaCarpeta) {
                                    rutaNumeros = rutaRenombrados + rutaEstructura + FicherosComp[indSeleccionados[x]].toString();
                                } else {
                                    rutaNumeros = ruta + separador + FicherosComp[indSeleccionados[x]].toString();
                                }
                                int ultimoPunto = rutaNumeros.lastIndexOf(separador);
                                if (ultimoPunto >= 0 && ultimoPunto < rutaNumeros.length() -1) {
                                    rutaNumeros = rutaNumeros.substring(0,ultimoPunto);
                                }
                                if ( ! ht[z].containsKey(rutaNumeros) ) {
                                    ListArchivos archivosMotor = new ListArchivos(rutaNumeros);
                                    ArrayList<File> originalesList = new ArrayList<>(Arrays.asList(archivosOriginales));
                                    if (archivosMotor.getFicheros("", false, false, false, false, false, Idioma) != null) {
                                        File[] archivosList = archivosMotor.getAbstractFiltrado();
                                        int[] seleccionList = new int[archivosList.length];
                                        for(int y=0;y<archivosList.length;y++) {
                                            if ( ! originalesList.contains(archivosList[y]) ) {
                                                seleccionList[y] = y;
                                            }
                                        }
                                        archivosMotor.reordenaAuto(archivosList, seleccionList, false, "order-numberNormal", 1, Idioma);
                                        mNumero=archivosMotor.getNumeroDetecta() + 1;
                                    }
                                }
                                mNumero = getNumera(rutaNumeros, mNumero, mSalto, z);
                            }
                            default -> mNumero = getNumera("sinCambios", mNumero, mSalto, z);
                        }
                        if (ordenBusca[z][5].equals("1") && mNumero != -1) {
                            String roman = toRomanNuevo(mNumero);
                            if (ordenBusca[z][6].equals("0")) {
                                roman = roman.toUpperCase(locale);
                            } else {
                                roman = roman.toLowerCase(locale);
                            }
                            FicherosComp[indSeleccionados[x]].append(roman);
                        } else if (ordenBusca[z][5].equals("2") && mNumero != -1) {
                            String letters = toLetters(mNumero);
                            if (ordenBusca[z][6].equals("0")) {
                                letters = letters.toUpperCase(locale);
                            } else {
                                letters = letters.toLowerCase(locale);
                            }
                            FicherosComp[indSeleccionados[x]].append(letters);
                        } else if (ordenBusca[z][5].equals("3") && mNumero != -1) {
                            FicherosComp[indSeleccionados[x]].append(Integer.toBinaryString(mNumero));
                        } else if (ordenBusca[z][5].equals("4") && mNumero != -1) {
                            String hex = Integer.toHexString(mNumero);
                            if (ordenBusca[z][6].equals("0")) {
                                hex = hex.toUpperCase(locale);
                            } else {
                                hex = hex.toLowerCase(locale);
                            }
                            FicherosComp[indSeleccionados[x]].append(hex);
                        } else if (ordenBusca[z][5].equals("5") && mNumero != -1) {
                            String octal = Integer.toOctalString(mNumero);
                            mNumero = Integer.parseInt(octal);
                            FicherosComp[indSeleccionados[x]].append(addCeros(mNumero,mCuantos));
                        } else if ( mNumero != -1 ) {
                            FicherosComp[indSeleccionados[x]].append(addCeros(mNumero,mCuantos));
                        } else {
                            if ( (bolSepara || separaText[z].equals("off")) && append && z>0 ) {
                                separaEliminar = separaText[z-1];
                                if (separaEliminar.equals("{ }")) {
                                    separaEliminar=" ";
                                }
                            }
                            append = false;
                        }
                    }

		    case '2' -> {
                        int mNumero;
                        // FILENAME
                        switch (ordenBusca[z][1].charAt(0)) {
                            case '0':
                                mNumero=Integer.parseInt(ordenBusca[z][3]);
                                String literal = ordenBusca[z][2];
                                if (ordenBusca[z][2].contains(".")) {
                                    literal = Pattern.quote(ordenBusca[z][2]);
                                    literal = literal.replace(".","\\.");
                                }
                                try {
                                    textoCorte=cadenaModifica.split(literal);
                                }
                                catch (PatternSyntaxException e) {
                                    try {
                                        literal = Pattern.quote(ordenBusca[z][2]);
                                        textoCorte=cadenaModifica.split(literal);
                                    }
                                    catch (PatternSyntaxException d) {
                                        System.out.println("regex error");
                                        textoCorte=cadenaModifica.split("");
                                    }
                                }
                                if (ordenBusca[z][2].equals("")) {
                                    FicherosComp[indSeleccionados[x]].append(cadenaModifica);
                                } else {
                                    if (mNumero >= textoCorte.length) mNumero = textoCorte.length;
                                    switch (ordenBusca[z][4].charAt(0)) {
                                        case '0':
                                            FicherosComp[indSeleccionados[x]].append(textoCorte[mNumero-1]);
                                            break;
                                        case '1':
                                            for (int p=mNumero;p<=textoCorte.length;p++) {
                                                FicherosComp[indSeleccionados[x]].append((p < textoCorte.length) ? textoCorte[p-1]+ordenBusca[z][2] : textoCorte[p-1]);
                                            }
                                            break;
                                        case '2':
                                            for (int p=0;p<=textoCorte.length-mNumero;p++) {
                                                FicherosComp[indSeleccionados[x]].append((p < (textoCorte.length-mNumero) ) ? textoCorte[p]+ordenBusca[z][2] : textoCorte[p]);
                                            }
                                            break;
                                    }
                                }
                                break;
                            case '1':
                                int iDesde=Integer.parseInt(ordenBusca[z][5]);
                                int iHasta=Integer.parseInt(ordenBusca[z][6]);
                                if (iHasta > cadenaModifica.length()) {
                                    iHasta = cadenaModifica.length();
                                }
                                if (iDesde <= iHasta) {
                                    FicherosComp[indSeleccionados[x]].append(cadenaModifica.substring(iDesde -1,iHasta));
                                }
                                break;
                            case '2':
                                if ( ! ordenBusca[z][7].equals("") || ! ordenBusca[z][8].equals("") ) {
                                    literal = ordenBusca[z][7];
                                    if (ordenBusca[z][7].contains(".")) {
                                        literal = Pattern.quote(ordenBusca[z][7]);
//                                        literal.replace(".","\\.");
                                    }
                                    try {
                                        textoCorte = cadenaModifica.split(literal,2);
                                    } catch (PatternSyntaxException e) {
                                        try {
                                            literal = Pattern.quote(ordenBusca[z][7]);
                                            textoCorte = cadenaModifica.split(literal,2);
                                        } catch (PatternSyntaxException d) {
                                            System.err.println("regex error");
                                            textoCorte = cadenaModifica.split("");
                                        }
                                    }
                                    if (textoCorte[0].length() < cadenaModifica.length()) {
                                        if (ordenBusca[z][8].equals("")) {
                                            FicherosComp[indSeleccionados[x]].append(textoCorte[1]);
                                        } else {
                                            literal = ordenBusca[z][8];
                                            if (ordenBusca[z][8].contains(".")) {
                                                literal = Pattern.quote(ordenBusca[z][8]);
//                                                literal.replace(".","\\.");
                                            }
                                            try {
                                                textoCorte=textoCorte[1].split(literal,2);
                                            } catch (PatternSyntaxException e) {
                                                try {
                                                    literal = Pattern.quote(ordenBusca[z][8]);
                                                    textoCorte=textoCorte[1].split(literal,2);
                                                } catch (PatternSyntaxException d) {
                                                    System.err.println("regex error");
                                                    textoCorte=cadenaModifica.split("");
                                                }
                                            }
                                            FicherosComp[indSeleccionados[x]].append(textoCorte[0]);
                                        }
                                    }
                                } else {
                                    FicherosComp[indSeleccionados[x]].append(cadenaModifica);
                                }
                                break;
                            default:
                                FicherosComp[indSeleccionados[x]].append(cadenaModifica);
                                break;
                        }
                    }
		    case '3' -> {
                        // FOLDER
                        File fArchivo=new File(ruta);
                        String carpet = fArchivo.getName();
                        switch (ordenBusca[z][1].charAt(0)) {
                            case '0':
                                FicherosComp[indSeleccionados[x]].append(carpet);
                                break;
                            case '1':
                                FicherosComp[indSeleccionados[x]].append(carpet.toUpperCase(locale));
                                break;
                            case '2':
                                FicherosComp[indSeleccionados[x]].append(carpet.toLowerCase(locale));
                                break;
                        }
                    }
		    case '4' -> {
                        // DATE
                        char separaFecha = ordenBusca[z][2].charAt(0);
                        int cFecha= Integer.parseInt(ordenBusca[z][1]);
                        int diasMes = Integer.parseInt(ordenBusca[z][3]);
                        String modified = ordenBusca[z][4];
                        FicherosComp[indSeleccionados[x]].append(getFecha(ruta+separador+completo, cFecha, separaFecha, diasMes, modified, datoCalendario));
                    }
		    case '5' -> {
                        // METADATA DATE
                        int opcion = Integer.parseInt(ordenBusca[z][1]);
                        char separaFecha = ordenBusca[z][2].charAt(0);
                        int diasMes = Integer.parseInt(ordenBusca[z][3]);
                        FicherosComp[indSeleccionados[x]].append(getFechaMeta(ruta+separador+completo, opcion, separaFecha, diasMes).replace("File:",""));
                    }
		    case '6' -> // METADATA CAMERA
			FicherosComp[indSeleccionados[x]].append(getCamara(ruta+separador+completo, ordenBusca[z][1]));
		    case '7' -> {
                        // METADATA SOUND
                        metaMp3 datoMp3 = new metaMp3(Idioma);
                        FicherosComp[indSeleccionados[x]].append(datoMp3.getMp3(ruta+separador+completo, ordenBusca[z][1], ordenBusca[z][2]));
                    }
		}
		if ("null".equals(ordenBusca[z][0])) {
		    FicherosComp[indSeleccionados[x]].append("");
		}
		if ( bolSepara && z < (ordenBusca.length -1) && append ) {
		    Boolean extraSepara = false;
		    if (z < ordenBusca.length) {
			if (ordenBusca[z+1][0].charAt(0) == '0' && ordenBusca[z+1][1].equals("")) {
			  extraSepara = true;
			}
		    }
		    if (! extraSepara) {
			FicherosComp[indSeleccionados[x]].append(separa);
		    }
		} else {
		    append = true;
		}
		if ((bolSepara || separaText[z].equals("off")) && z >= (ordenBusca.length -1) && FicherosComp[indSeleccionados[x]].toString().endsWith(separaEliminar)) {
		    FicherosComp[indSeleccionados[x]].delete((FicherosComp[indSeleccionados[x]].toString().length() - separaEliminar.length()), FicherosComp[indSeleccionados[x]].toString().length());
		    separaElminado = true;
		}
		bolSepara = true;
		separaAnterior = separa;
	    } //FOR Z
	    if (FicherosComp[indSeleccionados[x]].toString().equals("")) {
		FicherosComp[indSeleccionados[x]].append(sinExtension);
	    }
	    FicherosComp[indSeleccionados[x]].append(extension);
	    if (opcionSelec == 2) {
		if (FicherosComp[indSeleccionados[x]].toString().replace(extension,"").equals(sinExtension)) {
		    continue;
		}
		extension = "." + FicherosComp[indSeleccionados[x]].toString().replace(extension,"");
		FicherosComp[indSeleccionados[x]] = new StringBuffer().append("");
		FicherosComp[indSeleccionados[x]].append(sinExtension);
		FicherosComp[indSeleccionados[x]].append(extension);
	    }
	    if (preguntaCancela()) {
		return true;
	    }
	}
	return false;
  }
  public Boolean recogeInsertar (int[] indSeleccionados, StringBuffer[] FicherosComp, String txtInsertar, String spnInsertar, Boolean desdeDerechaInserta, Boolean bolExtension, String usrExtension, int opcionSelec) {
     this.indSeleccionados=indSeleccionados;
     cancelaCopia = false;
     String completo;
     for(int x=0;x<indSeleccionados.length;x++){
	indice = Integer.parseInt(spnInsertar);
	if (FicherosComp[indSeleccionados[x]].toString().equals("..")) continue;
	completo=FicherosComp[indSeleccionados[x]].toString();
	FicherosComp[indSeleccionados[x]] = new StringBuffer().append("");
	String extension = "";
	String cadenaModifica = "";
	switch (opcionSelec) {
	    case 1:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, bolExtension, usrExtension);
		cadenaModifica = sinExtension;
	    break;
	    case 2:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, false, "");
		if ( ! extension.equals("") ) {
		    cadenaModifica = extension.substring(1,extension.length());
		}
	    break;
	    case 3:
		if (bolExtension &&  ! usrExtension.equals("")) {
		    extension = "." + usrExtension;
		}
		cadenaModifica = completo;
	    break;
	}
	if ( ! cadenaModifica.equals("") ) {
	    if (indice>cadenaModifica.length()+1) indice=cadenaModifica.length()+1;
	    FicherosComp[indSeleccionados[x]].append(cadenaModifica);
	    if (desdeDerechaInserta) FicherosComp[indSeleccionados[x]].insert(cadenaModifica.length()-(indice-1),txtInsertar);
	    else FicherosComp[indSeleccionados[x]].insert(indice-1,txtInsertar);
	}
	if ( opcionSelec == 1  || opcionSelec == 3 ) FicherosComp[indSeleccionados[x]].append(extension);
	else {
	    if ( ! FicherosComp[indSeleccionados[x]].toString().equals("") ) FicherosComp[indSeleccionados[x]].insert(0,sinExtension + ".");
	    else FicherosComp[indSeleccionados[x]].append(sinExtension);
	}
	if (preguntaCancela()) {
	    return true;
	}
     }
     return false;
  }
  public Boolean recogeEliminar (int[] indSeleccionados, StringBuffer[] FicherosComp, String spnDesde, String spnHasta, Boolean desdeDerecha, Boolean bolExtension, String usrExtension, int opcionSelec) {
     this.indSeleccionados=indSeleccionados;
     cancelaCopia = false;
     String completo;
     for(int x=0;x<indSeleccionados.length;x++){
	indice = Integer.parseInt(spnDesde);
	int indice2 = Integer.parseInt(spnHasta);
	if (FicherosComp[indSeleccionados[x]].toString().equals("..")) continue;
	completo=FicherosComp[indSeleccionados[x]].toString();
	FicherosComp[indSeleccionados[x]] = new StringBuffer().append("");
	String extension = "";
	String cadenaModifica = "";
	switch (opcionSelec) {
	    case 1:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, bolExtension, usrExtension);
		cadenaModifica = sinExtension;
	    break;
	    case 2:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, false, "");
		if ( ! extension.equals("") ) {
		    cadenaModifica = extension.substring(1,extension.length());
		}
	    break;
	    case 3:
		if (bolExtension &&  ! usrExtension.equals("")) {
		    extension = "." + usrExtension;
		}
		cadenaModifica = completo;
	    break;
	}
	if ( ! cadenaModifica.equals("") ) {
	    if (indice > cadenaModifica.length()-1) indice = cadenaModifica.length()-1;
	    if (indice2 > cadenaModifica.length()-1) indice2 = cadenaModifica.length();
	    if (indice >= indice2) indice = indice2;
	    FicherosComp[indSeleccionados[x]].append(cadenaModifica);
	    if (desdeDerecha) FicherosComp[indSeleccionados[x]].delete(cadenaModifica.length()-indice2,cadenaModifica.length()-(indice-1));
	    else FicherosComp[indSeleccionados[x]].delete(indice-1,indice2);
	}
	if ( opcionSelec == 1 || opcionSelec == 3 ) FicherosComp[indSeleccionados[x]].append(extension);
	else {
	    if ( ! FicherosComp[indSeleccionados[x]].toString().equals("") ) FicherosComp[indSeleccionados[x]].insert(0,sinExtension + ".");
	    else FicherosComp[indSeleccionados[x]].append(sinExtension);
	}
	if (preguntaCancela()) {
	    return true;
	}
     }
     return false;
  }
  public Boolean recogeNumeros (int[] indSeleccionados, StringBuffer[] FicherosComp, int numerosSel, String normaPosicion, String normaCeros, String numerosEn, String numerosSalto, String numerosPosicion, Boolean copiaCarpeta, Boolean bolExtension, String usrExtension, String rutaRenombrados, int opcionSelec) {
     this.indSeleccionados=indSeleccionados;
     cancelaCopia = false;
     String completo;
     String rutaNumeros;
     ht[0] = new Hashtable<>();
     for(int x=0;x<indSeleccionados.length;x++){
	if (FicherosComp[indSeleccionados[x]].toString().equals("..")) continue;	
	completo=FicherosComp[indSeleccionados[x]].toString();
	FicherosComp[indSeleccionados[x]] = new StringBuffer().append("");
	if (bolExtension && usrExtension.equals("")) completo = completo + extensionAnterior;
	String extension = "";
	String cadenaModifica = "";
	switch (opcionSelec) {
	    case 1:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, bolExtension, usrExtension);
		cadenaModifica = sinExtension;
	    break;
	    case 2:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, false, "");
		if ( ! extension.equals("") ) {
		    cadenaModifica = extension.substring(1,extension.length());
		}
	    break;
	    case 3:
		cadenaModifica = completo;
	    break;
	}
	switch(numerosSel) {
	    case 0:
		int posicion = Integer.parseInt(normaPosicion);
		int cerosInt = Integer.parseInt(normaCeros);
		int cuentaPosicion = 1;
		int indiceDetectado = 5000;
		int indiceLongitud = 0;
		String numeroResultado;
		Boolean numeroDetectado = false;
		Boolean numeroNoValido = false;
		String numeroPosicionString = "";
		for (int z=0;z<cadenaModifica.length();z++) {
		    if (cadenaModifica.substring(z,z+1).matches("[0-9]")) {
			numeroNoValido = true;
			if (posicion == cuentaPosicion) {
			    numeroPosicionString = numeroPosicionString + cadenaModifica.substring(z,z+1);				
			    numeroDetectado = true;
			    if (indiceDetectado == 5000) indiceDetectado = z;
			    indiceLongitud = z+1;
			}
		    }
		    else {
			if (numeroDetectado) break;
			if (numeroNoValido) {
			    cuentaPosicion++;
			    numeroNoValido = false;
			}
		    }
		}
		if ( ! numeroPosicionString.equals("")) {                     
		    long numeroPosicionInt = Long.parseLong(numeroPosicionString);                    
		    numeroResultado = addCeros(numeroPosicionInt, cerosInt-1);
		    String parteFinal = (indiceLongitud < cadenaModifica.length()) ? cadenaModifica.substring(indiceLongitud,cadenaModifica.length()) : "";                    
		    cadenaModifica = cadenaModifica.substring(0,indiceDetectado) + numeroResultado + parteFinal;
		}
	    break;
	    case 1:
		posicion = Integer.parseInt(numerosPosicion);
		int En = Integer.parseInt(numerosEn);
		int Salto = Integer.parseInt(numerosSalto);
		if (copiaCarpeta) rutaNumeros = rutaRenombrados + separador + new File (completo).getParent();
		else {
		    String ruta = archivosOriginales[indSeleccionados[x]].getParent();
		    rutaNumeros = ruta + separador + new File (completo).getParent();
		}
		cuentaPosicion = 1;
		indiceDetectado = 5000;
		indiceLongitud = 0;
		numeroDetectado = false;
		numeroNoValido = false;
		numeroPosicionString = "";
		for (int z=0;z<cadenaModifica.length();z++) {
		    if (cadenaModifica.substring(z,z+1).matches("[0-9]")) {
			numeroNoValido = true;
			if (posicion == cuentaPosicion) {
			    numeroPosicionString = numeroPosicionString + cadenaModifica.substring(z,z+1);				
			    numeroDetectado = true;
			    if (indiceDetectado == 5000) indiceDetectado = z;
			    indiceLongitud = z+1;
			}
		    }
		    else {
			if (numeroDetectado) break;
			if (numeroNoValido) {
			    cuentaPosicion++;
			    numeroNoValido = false;
			}
		    }
		}
		if ( ! numeroPosicionString.equals("")) { 
		    int mNumero=getNumera(rutaNumeros, En, Salto, 0);                    
		    numeroResultado = addCeros(mNumero, numeroPosicionString.length()-1);
		    String parteFinal = (indiceLongitud < cadenaModifica.length()) ? cadenaModifica.substring(indiceLongitud,cadenaModifica.length()) : "";
		    cadenaModifica = cadenaModifica.substring(0,indiceDetectado) + numeroResultado + parteFinal;
		}

	    break;
	}
	if ( opcionSelec == 1  || opcionSelec == 3 ) sinExtension = cadenaModifica;
	else {
	    if ( ! cadenaModifica.equals("") ) extension = "." + cadenaModifica;
	    else extension = "";
	}
	FicherosComp[indSeleccionados[x]].append(sinExtension);
	FicherosComp[indSeleccionados[x]].append(extension);
	if (preguntaCancela()) {
	    return true;
	}
     }
     return false;
  }
  public Boolean recogeReemplaza (int[] indSeleccionados, StringBuffer[] FicherosComp, String reemplazaOrigen, String reemplazaFinal, Boolean bolExtension, String usrExtension, int modoReemplaza, int opcionSelec) {        
     this.indSeleccionados=indSeleccionados;
     String completo;
     cancelaCopia = false;
     for(int x=0;x<indSeleccionados.length;x++){
	if (FicherosComp[indSeleccionados[x]].toString().equals("..")) continue;
	completo=FicherosComp[indSeleccionados[x]].toString();
	FicherosComp[indSeleccionados[x]] = new StringBuffer().append("");
	if (bolExtension && usrExtension.equals("")) completo = completo + extensionAnterior;
	String extension = "";
	String cadenaModifica = "";
	switch (opcionSelec) {
	    case 1:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, bolExtension, usrExtension);
		cadenaModifica = sinExtension;
	    break;
	    case 2:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, false, "");
		if ( ! extension.equals("") ) {
		    cadenaModifica = extension.substring(1,extension.length());
		}
	    break;
	    case 3:
		cadenaModifica = completo;
	    break;
	}
	String cadenaCopia = cadenaModifica;
	if (modoReemplaza == 0) {
	  if (cadenaModifica.contains(reemplazaOrigen) || reemplazaFinal.endsWith("$") || reemplazaFinal.endsWith("\\")) {
	      cadenaModifica=cadenaModifica.replace(reemplazaOrigen,reemplazaFinal);
	  }
	  else {
	    try {
	      cadenaModifica=cadenaModifica.replaceAll(reemplazaOrigen,reemplazaFinal);
	    }
	    catch (PatternSyntaxException e) {
	      cadenaModifica=cadenaModifica.replace(reemplazaOrigen,reemplazaFinal);
	    }
	  }
	}
	else if (modoReemplaza == 1) {	  
	  String literal = Pattern.quote(reemplazaOrigen);
	  if (cadenaModifica.contains(reemplazaOrigen) || reemplazaFinal.endsWith("$") || reemplazaFinal.endsWith("\\")){
	    cadenaModifica=cadenaModifica.replaceFirst(literal, reemplazaFinal);
	  }
	  else {
	    try {
	      cadenaModifica=cadenaModifica.replaceFirst(reemplazaOrigen,reemplazaFinal);
	    }
	    catch (PatternSyntaxException e) {
	      cadenaModifica=cadenaModifica.replaceFirst(literal, reemplazaFinal);
	    }
	  }
	}
	if (cadenaModifica.equals("")) {
	    cadenaModifica = cadenaCopia;
	}
	if ( opcionSelec == 1  || opcionSelec == 3 ) sinExtension = cadenaModifica;
	else {
	    if ( ! cadenaModifica.equals("") ) extension = "." + cadenaModifica;
	    else extension = "";
	}
	FicherosComp[indSeleccionados[x]].append(sinExtension);
	FicherosComp[indSeleccionados[x]].append(extension);
	if (preguntaCancela()) {
	    return true;
	}
     }
     return false;
  }
  public Boolean recogeNormaliza (int[] indSeleccionados, StringBuffer[] FicherosComp, int normaSel, Boolean bolExtension, String normalizaBasura, String normalizaTrim, Boolean desdeDerechaTrim, String usrExtension, int opcionSelec) {        
     this.indSeleccionados=indSeleccionados;
     cancelaCopia = false;
     String completo;
     for(int x=0;x<indSeleccionados.length;x++){
	if (FicherosComp[indSeleccionados[x]].toString().equals("..")) continue;
	completo=FicherosComp[indSeleccionados[x]].toString();
	FicherosComp[indSeleccionados[x]] = new StringBuffer().append("");
	if (bolExtension && usrExtension.equals("")) completo = completo + extensionAnterior;
	String extension = "";
	String cadenaModifica = "";
	switch (opcionSelec) {
	    case 1:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, bolExtension, usrExtension);
		cadenaModifica = sinExtension;
	    break;
	    case 2:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, false, "");
		if ( ! extension.equals("") ) {
		    cadenaModifica = extension.substring(1,extension.length());
		}
	    break;
	    case 3:
		cadenaModifica = completo;
	    break;
	}
	switch(normaSel) {
	    case 0:
		cadenaModifica=cadenaModifica.replaceAll("[á]","a");
		cadenaModifica=cadenaModifica.replaceAll("[é]","e");
		cadenaModifica=cadenaModifica.replaceAll("[í]","i");
		cadenaModifica=cadenaModifica.replaceAll("[ó]","o");
		cadenaModifica=cadenaModifica.replaceAll("[ú]","u");
		cadenaModifica=cadenaModifica.replaceAll("[Á]","A");
		cadenaModifica=cadenaModifica.replaceAll("[É]","E");
		cadenaModifica=cadenaModifica.replaceAll("[Í]","I");
		cadenaModifica=cadenaModifica.replaceAll("[Ó]","O");
		cadenaModifica=cadenaModifica.replaceAll("[Ú]","U");

		cadenaModifica=cadenaModifica.replaceAll("[â]","a");
		cadenaModifica=cadenaModifica.replaceAll("[ê]","e");
		cadenaModifica=cadenaModifica.replaceAll("[î]","i");
		cadenaModifica=cadenaModifica.replaceAll("[ô]","o");
		cadenaModifica=cadenaModifica.replaceAll("[û]","u");
		cadenaModifica=cadenaModifica.replaceAll("[Â]","A");
		cadenaModifica=cadenaModifica.replaceAll("[Ê]","E");
		cadenaModifica=cadenaModifica.replaceAll("[Î]","I");
		cadenaModifica=cadenaModifica.replaceAll("[Ô]","O");
		cadenaModifica=cadenaModifica.replaceAll("[Û]","U");

		cadenaModifica=cadenaModifica.replaceAll("[à]","a");
		cadenaModifica=cadenaModifica.replaceAll("[è]","e");
		cadenaModifica=cadenaModifica.replaceAll("[ì]","i");
		cadenaModifica=cadenaModifica.replaceAll("[ò]","o");
		cadenaModifica=cadenaModifica.replaceAll("[ù]","u");
		cadenaModifica=cadenaModifica.replaceAll("[À]","A");
		cadenaModifica=cadenaModifica.replaceAll("[È]","E");
		cadenaModifica=cadenaModifica.replaceAll("[Ì]","I");
		cadenaModifica=cadenaModifica.replaceAll("[Ò]","O");
		cadenaModifica=cadenaModifica.replaceAll("[Ù]","U");

		cadenaModifica=cadenaModifica.replaceAll("[ä]","a");
		cadenaModifica=cadenaModifica.replaceAll("[ë]","e");
		cadenaModifica=cadenaModifica.replaceAll("[ï]","i");
		cadenaModifica=cadenaModifica.replaceAll("[ö]","o");
		cadenaModifica=cadenaModifica.replaceAll("[ü]","u");
		cadenaModifica=cadenaModifica.replaceAll("[Ä]","A");
		cadenaModifica=cadenaModifica.replaceAll("[Ë]","E");
		cadenaModifica=cadenaModifica.replaceAll("[Ï]","I");
		cadenaModifica=cadenaModifica.replaceAll("[Ö]","O");
		cadenaModifica=cadenaModifica.replaceAll("[Ü]","U");
	    break;
	    case 1:
		try {
		    cadenaModifica=cadenaModifica.replaceAll(normalizaBasura,"");
		} catch (PatternSyntaxException e) {
		    cadenaModifica=cadenaModifica.replace(normalizaBasura,"");
		}
//		URLDecoder decodificaCadena = new URLDecoder();
		try {
		    cadenaModifica = URLDecoder.decode(cadenaModifica, codificacion);
		} catch (IllegalArgumentException e) {
		    System.out.println("Illegal argument");
		} catch (UnsupportedEncodingException e) {
		    System.out.println("Unsopported");
		}

	    break;
	    case 2:
		cadenaModifica = cadenaModifica
		    .replaceAll("[ ][ ]+"," ")
		    .trim();
	    break;
	    case 3:
		int trim = Integer.parseInt(normalizaTrim);
		if (trim < cadenaModifica.length()) {
		    if ( ! desdeDerechaTrim) {
			cadenaModifica=cadenaModifica.substring(0,trim);
		    }
		    else {
			cadenaModifica=cadenaModifica.substring(cadenaModifica.length()-trim,cadenaModifica.length());
		    }
		}
	    break;
	}
	if ( opcionSelec == 1  || opcionSelec == 3 ) sinExtension = cadenaModifica;
	else {
	    if ( ! cadenaModifica.equals("") ) extension = "." + cadenaModifica;
	    else extension = "";
	}
	FicherosComp[indSeleccionados[x]].append(sinExtension);
	FicherosComp[indSeleccionados[x]].append(extension);
	if (preguntaCancela()) {
	    return true;
	}
     }
     return false;
  }
  public Boolean recogeCapitaliza (int[] indSeleccionados, StringBuffer[] FicherosComp, int capitaSel, String simbolos, Boolean bolExtension, String usrExtension, int opcionSelec) {        
     this.indSeleccionados=indSeleccionados;
     String completo;
     cancelaCopia = false;
     for(int x=0;x<indSeleccionados.length;x++){
	if (FicherosComp[indSeleccionados[x]].toString().equals("..")) continue;
	completo=FicherosComp[indSeleccionados[x]].toString();
	FicherosComp[indSeleccionados[x]] = new StringBuffer().append("");
	if (bolExtension && usrExtension.equals("")) completo = completo + extensionAnterior;
	String extension = "";
	String cadenaModifica = "";
	switch (opcionSelec) {
	    case 1:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, bolExtension, usrExtension);
		cadenaModifica = sinExtension;
	    break;
	    case 2:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, false, "");
		if ( ! extension.equals("") ) {
		    cadenaModifica = extension.substring(1,extension.length());
		}
	    break;
	    case 3:
		cadenaModifica = completo;
	    break;
	}
	switch(capitaSel) {
	      case 0:
		cadenaModifica=cadenaModifica.toUpperCase(locale);
		break;
	      case 1:
		cadenaModifica=cadenaModifica.toLowerCase(locale);
		break;	      
	      case 2:
		cadenaModifica=cadenaModifica.toLowerCase(locale);
		String primera = cadenaModifica.substring(0,1).toUpperCase(locale);
		cadenaModifica=primera+cadenaModifica.substring(1,cadenaModifica.length());
		break;	      
	      case 3:
		cadenaModifica=cadenaModifica.toLowerCase(locale);
		String[] palabras = cadenaModifica.split(" ");
		cadenaModifica="";
		for(int z=0;z<palabras.length;z++) {
		    if (palabras[z].length() < 1) continue;
		    primera = palabras[z].substring(0,1).toUpperCase(locale);		    
		    cadenaModifica=(!cadenaModifica.equals("")) ? cadenaModifica+" "+primera+palabras[z].substring(1,palabras[z].length()) : primera+palabras[z].substring(1,palabras[z].length());
		}
		break;
	      case 4:
		cadenaModifica=cadenaModifica.toLowerCase(locale);
		for (int y=0;y<simbolos.length();y++) {
		    char simbolo = simbolos.charAt(y);
		    String literal = Pattern.quote(new String().valueOf(simbolo));
		    palabras = cadenaModifica.split(literal);
		    cadenaModifica="";
		    for(int z=0;z<palabras.length;z++) {
			if (palabras[z].length() < 1) continue;
			primera = palabras[z].substring(0,1).toUpperCase(locale);		    
			cadenaModifica=(!cadenaModifica.equals("")) ? cadenaModifica + simbolo + primera + palabras[z].substring(1,palabras[z].length()) : primera + palabras[z].substring(1,palabras[z].length());
		    }
		}
		break;
	}
	if ( opcionSelec == 1  || opcionSelec == 3 ) sinExtension = cadenaModifica;
	else {
	    if ( ! cadenaModifica.equals("") ) extension = "." + cadenaModifica;
	    else extension = "";
	}
	FicherosComp[indSeleccionados[x]].append(sinExtension);
	FicherosComp[indSeleccionados[x]].append(extension);
	if (preguntaCancela()) {
	    return true;
	}
     }
     return false;
  }
  public Boolean recogeAleatorio (int[] indSeleccionados, StringBuffer[] FicherosComp, Boolean longDeterminada, Boolean longOriginal, String sLongitud, Boolean bolExtension, String usrExtension, int opcionSelec) {        
     this.indSeleccionados=indSeleccionados;
     cancelaCopia = false;
     String completo;
     for(int x=0;x<indSeleccionados.length;x++){
	if (FicherosComp[indSeleccionados[x]].toString().equals("..")) continue;
	completo=FicherosComp[indSeleccionados[x]].toString();
	FicherosComp[indSeleccionados[x]] = new StringBuffer().append("");
	if (bolExtension && usrExtension.equals("")) completo = completo + extensionAnterior;
	String extension = "";
	String cadenaModifica = "";
	switch (opcionSelec) {
	    case 1:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, bolExtension, usrExtension);
		cadenaModifica = sinExtension;
	    break;
	    case 2:
		extension=getExtension(archivosOriginales[indSeleccionados[x]].getParent(), completo, false, "");
		if ( ! extension.equals("") ) {
		    cadenaModifica = extension.substring(1,extension.length());
		}
	    break;
	    case 3:
		cadenaModifica = completo;
	    break;
	}
	String cadenaAleatoria = "";
	int longFinal;
	int longitud = Integer.parseInt(sLongitud);
	if (longDeterminada) longFinal = longitud;
	else longFinal = cadenaModifica.length();
	long milis = new GregorianCalendar().getTimeInMillis();
	Random r = new Random(milis);
	int i = 0;
	while (i < longFinal) {
	  char c = (char)r.nextInt(255);
	  if ( (c >= '0' && c <=9) || (c >='a' && c <='z') ){
	    cadenaAleatoria += c;
	    i++;
	  }
	}
	try {
	  Thread.sleep(50);
	}
	catch (InterruptedException e) {
	}
	if ( opcionSelec == 1  || opcionSelec == 3 ) sinExtension = cadenaAleatoria;
	else {
	    if ( ! cadenaModifica.equals("") ) extension = "." + cadenaAleatoria;
	    else extension = "";
	}
	FicherosComp[indSeleccionados[x]].append(sinExtension);
	FicherosComp[indSeleccionados[x]].append(extension);
	if (preguntaCancela()) {
	    return true;
	}
     }
     return false;
  }
  public Boolean checkRepetidos(StringBuffer[] Renombrados, File[] archivosOriginales, String sistema) {
	indicesMarcar = new ArrayList<>();
	indicesCambiados = new ArrayList<>();
	indicesCiclo = new ArrayList<>();
	ArrayList<String> archivosMarcar = new ArrayList<>();
	Hashtable<String, Integer> entradas = new Hashtable<>();
	for (int x=0;x<archivosOriginales.length;x++) {
	    String archivoCheck = (archivosOriginales[x].getParent() + separador + new File (Renombrados[x].toString()).getParent() + separador + new File (Renombrados[x].toString()).getName())
		.replace("null" + separador,"");
		if ( ! sistema.equals("windows") ) {
		    archivoCheck =  archivoCheck.replace(separador+separador,separador);
		}
	    if ( ! archivoCheck.equals(archivosOriginales[x].toString()) ) {
		indicesCambiados.add(x);
	    }
	    if (entradas.containsKey(archivoCheck)) {
//		if (indicesCambiados.contains(entradas.get(archivoCheck.replace("null" + separador,"")))) indicesMarcar.add(entradas.get(archivoCheck.replace("null" + separador,"")));
		if (indicesCambiados.contains(x)) {
		    indicesMarcar.add(x);
		    archivosMarcar.add(new File (archivoCheck).getParent() + separador + new File(archivoCheck).getName().replaceAll("[0-9]+",""));
		}
	    }
	    entradas.put(archivoCheck,x);
	    if (indicesCambiados.contains(x)) {
		if ( new File (archivoCheck).exists() && ! new File (archivoCheck).getName().equals("..") && ! new File (archivoCheck).getName().toLowerCase().equals(archivosOriginales[x].getName().toLowerCase())) {
		    if ( ! indicesMarcar.contains(x) ) {
			indicesMarcar.add(x);
			archivosMarcar.add(new File (archivoCheck).getParent() + separador + new File(archivoCheck).getName().replaceAll("[0-9]+",""));
		    }
		}
	    }
	    if (preguntaCancela()) {
		return true;
	    }
	}
	for (int x=0;x<archivosOriginales.length;x++) {
	    String archivoCheck = (archivosOriginales[x].getParent() + separador + new File (Renombrados[x].toString()).getParent() + separador + new File (Renombrados[x].toString()).getName())
                    .replace("null"+separador,"");
	    if (entradas.containsKey(archivosOriginales[x].toString()) && indicesCambiados.contains(x) ) {
		indicesMarcar.remove(entradas.get(archivosOriginales[x].toString()));
		indicesCiclo.add(entradas.get(archivosOriginales[x].toString()));
		archivosMarcar.remove(new File (archivoCheck).getParent() + separador + new File(archivoCheck).getName().replaceAll("[0-9]+",""));
	    }
	    if (preguntaCancela()) {
		return true;
	    }
	}
        for (int x=0;x<indicesCiclo.size();x++) {
	    String archivoCheck = (archivosOriginales[indicesCiclo.get(x)].getParent() + separador + new File (Renombrados[indicesCiclo.get(x)].toString()).getParent() + separador + new File (Renombrados[indicesCiclo.get(x)].toString()).getName().replaceAll("[0-9]+",""))
                    .replace("null" + separador,"");
            if ( archivosMarcar.contains(archivoCheck) ) {
		indicesMarcar.add(indicesCiclo.get(x));
		indicesCiclo.remove(indicesCiclo.get(x));
                x--;
	    }
        }
        /*	for (int x=0;x<indicesCambiados.size();x++) {
	    System.out.println("Cambiar: " + indicesCambiados.get(x));
	}
	for (int x=0;x<indicesMarcar.size();x++) {
	    System.out.println("Marcar: " + indicesMarcar.get(x));
	}
	for (int x=0;x<indicesCiclo.size();x++) {
	    System.out.println("Ciclo: " + indicesCiclo.get(x));
	}
	    System.out.println("...........");
	    System.out.println("");
*/
	return false;
  }
  public Boolean checkRepetidosCopia(String rutaRenombrados, int[] okSeleccionRe, int[] okSeleccion, StringBuffer[] Renombrados, String[] RenombradosEstructura, StringBuffer[] Originales, String sistema){
	indicesMarcar = new ArrayList<>();
	indicesCambiados = new ArrayList<>();
	Hashtable<String, Integer> entradas = new Hashtable<>();
	String archivoCheck;
	String archivoCheckCambiados;
	for (int x=0;x<okSeleccionRe.length;x++) {
	    archivoCheck = Renombrados[okSeleccionRe[x]].toString();
	    if (sistema.equals("windows")) {
		archivoCheck = archivoCheck.toLowerCase(locale);
	    }
	    archivoCheckCambiados = Renombrados[okSeleccionRe[x]].toString();
	    if (RenombradosEstructura.length > 0 && RenombradosEstructura[okSeleccionRe[x]] != null) {
		archivoCheckCambiados = archivoCheckCambiados.replace(RenombradosEstructura[okSeleccionRe[x]] + separador,"");
	    }
	    if ( ! archivoCheckCambiados.equals(Originales[okSeleccion[x]].toString()) ) {
		indicesCambiados.add(okSeleccion[x]);
	    }
	    if (entradas.containsKey(archivoCheck)) {
		if ( ! indicesMarcar.contains(entradas.get(archivoCheck)) )
		  indicesMarcar.add(entradas.get(archivoCheck));
		if (entradas.get(archivoCheck) != okSeleccionRe[x])
		    indicesMarcar.add(okSeleccionRe[x]);
	    }
	    entradas.put(archivoCheck,okSeleccionRe[x]);
	    if (preguntaCancela()) {
		return true;
	    }
	}
	for (int x=0;x<okSeleccionRe.length;x++) {
	    if ( new File (rutaRenombrados + separador + Renombrados[okSeleccionRe[x]].toString()).exists()  && ! new File (rutaRenombrados + separador + Renombrados[okSeleccionRe[x]].toString()).getName().equals("..")) {
		if ( ! indicesMarcar.contains(okSeleccionRe[x]) )
		    indicesMarcar.add(okSeleccionRe[x]);      
	    }
	    if (preguntaCancela())
		return true;
	}
/*	for (int x=0;x<indicesCambiados.size();x++) {
	    System.out.println("Cambiar: " + indicesCambiados.get(x));
	}
	for (int x=0;x<indicesMarcar.size();x++) {
	    System.out.println("Marcar: " + indicesMarcar.get(x));
	}
	    System.out.println("...........");
	    System.out.println("");
*/
	return false;
  }
  public java.util.List<Integer> getIndicesMarcar(){
      return indicesMarcar;
  }
  public java.util.List<Integer> getIndicesCambiados(){
      return indicesCambiados;
  }
  public java.util.List<Integer> getIndicesCiclo(){
      return indicesCiclo;
  }
  public int[] getIndicesCambiadosArray() {
      int[] cambiados = new int[indicesCambiados.size()];
      for (int x=0;x<cambiados.length;x++) {
	  cambiados[x] = indicesCambiados.get(x);
      }
      return cambiados;
  }
  public int[] apruebaSeleccion (File[] archivosOriginales, int[] indSeleccionados) {
     this.archivosOriginales=archivosOriginales;
      File mArchivo;
      List<Integer> iSeleccionadosOk = new ArrayList<>();
      for (int x=0;x<indSeleccionados.length;x++) {
	  mArchivo = archivosOriginales[indSeleccionados[x]];
	  if (mArchivo.isFile()) iSeleccionadosOk.add(indSeleccionados[x]);	  
      }
      int[] indSeleccionadosOk = new int [iSeleccionadosOk.size()];
      for (int x=0;x<iSeleccionadosOk.size();x++) indSeleccionadosOk[x]=iSeleccionadosOk.get(x);
      return indSeleccionadosOk;
  }

  public String[] unidades(String sistema) {
    String[] unidadesTotal = new String[0];
    File[] fUnidades;
    java.util.List<String> unidadesBruto = new ArrayList<>();
    switch (sistema) {
        case "windows":
            fUnidades = File.listRoots();
            for (File fUnidad : fUnidades) {
                if (fUnidad.exists()) {
                    unidadesBruto.add(fUnidad.getAbsolutePath().toString());
                }
            }
            unidadesBruto.add(System.getProperty("user.home") + separador);
            unidadesTotal = new String [unidadesBruto.size()];
            for (int x=0;x<unidadesTotal.length;x++) unidadesTotal[x]=unidadesBruto.get(x);
            break;
        case "linux":
            fUnidades = new File ("/media").listFiles();
            for (File fUnidad : fUnidades) {
                if ( ! fUnidad.isHidden()) {
                    unidadesBruto.add(fUnidad.getAbsolutePath().toString() + separador);
                }
            }
            unidadesBruto.add(System.getProperty("user.home") + separador);
            unidadesTotal = new String[unidadesBruto.size()];
            for (int x=0;x<unidadesTotal.length;x++) unidadesTotal[x] = unidadesBruto.get(x);
            break;
        case "mac":
            fUnidades = new File ("/Volumes").listFiles();
            for (File fUnidad : fUnidades) {
                if ( ! fUnidad.isHidden() && ! fUnidad.toString().endsWith("Backups") ) {
                    unidadesBruto.add(fUnidad.getAbsolutePath().toString() + separador);
                }
            }
            unidadesBruto.add(System.getProperty("user.home") + separador);
            unidadesTotal = new String[unidadesBruto.size()];
            for (int x=0;x<unidadesTotal.length;x++) unidadesTotal[x] = unidadesBruto.get(x);
            break;
    }
    return unidadesTotal;
  }
  public String getFechaMeta(String entraArchivo, int opcion, char separaFecha){
      return getFechaMeta(entraArchivo, opcion, separaFecha, 0);
  }
  public String getFechaMeta(String entraArchivo, int opcion, char separaFecha, int diasMes){
    this.diasMes = diasMes;
    String fechaMeta = null;
    Date fechaCamara;
    String separadorFecha = "";
    String formatoMes = "MM";
    String miFecha = null;
    File fArchivo=new File(entraArchivo);
    switch(separaFecha){
	case '0':
	  separadorFecha = "";
	break;  
	case '1':
	  separadorFecha = "-";
	break;
	case '2':
	  separadorFecha = "_";
	break;
	case '3':
	  separadorFecha = ".";
	break;
	case '4':
	  separadorFecha = " ";
	break;
    }
    switch(diasMes){
	case 0:
	  formatoMes = "MM";
	break;  
	case 1:
	  formatoMes = "MMM";
	break;
	case 2:
	  formatoMes = "MMMM";
	break;
    }

    try {
        Metadata metadata = ImageMetadataReader.readMetadata(fArchivo);
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {        
                Pattern patron = Pattern.compile("Date/Time Original");
                Matcher fOriginal = patron.matcher(tag.toString());
                if (fOriginal.find()){
                  miFecha = tag.toString().replaceAll("\\[.*\\] Date/Time Original - ","");
                  if (!miFecha.equals("")) {
                    if (opcion < 11) {
                        String[] campoFecha = miFecha.split(":",3);
                        switch(opcion){
                            case 0:
                              fechaMeta = campoFecha[2].substring(0,2)+ separadorFecha +campoFecha[1]+ separadorFecha +campoFecha[0];
                              SimpleDateFormat d1 = new SimpleDateFormat("dd" + separadorFecha + "MM" + separadorFecha + "yyyy");
                              fechaCamara = d1.parse( fechaMeta, new ParsePosition(0) );
                              d1 = new SimpleDateFormat("dd" + separadorFecha + formatoMes + separadorFecha + "yyyy", locale);
                              fechaMeta = d1.format(fechaCamara);
                            break;  
                            case 1:
                              fechaMeta = campoFecha[2].substring(0,2)+ separadorFecha +campoFecha[1]+ separadorFecha +campoFecha[0].substring(2,4);
                              SimpleDateFormat d2 = new SimpleDateFormat("dd" + separadorFecha + "MM" + separadorFecha + "yy");
                              fechaCamara = d2.parse( fechaMeta, new ParsePosition(0) );
                              d2 = new SimpleDateFormat("dd" + separadorFecha + formatoMes + separadorFecha + "yy", locale);
                              fechaMeta = d2.format(fechaCamara);

                            break;
                            case 2:
                              fechaMeta = campoFecha[1]+ separadorFecha +campoFecha[0];
                              SimpleDateFormat d3 = new SimpleDateFormat("MM" + separadorFecha + "yyyy");
                              fechaCamara = d3.parse( fechaMeta, new ParsePosition(0) );
                              d3 = new SimpleDateFormat(formatoMes + separadorFecha + "yyyy", locale);
                              fechaMeta = d3.format(fechaCamara);
                            break;
                            case 3:
                              fechaMeta = campoFecha[1]+ separadorFecha +campoFecha[0].substring(2,4);
                              SimpleDateFormat d4 = new SimpleDateFormat("MM" + separadorFecha + "yy");
                              fechaCamara = d4.parse( fechaMeta, new ParsePosition(0) );
                              d4 = new SimpleDateFormat(formatoMes + separadorFecha + "yy", locale);
                              fechaMeta = d4.format(fechaCamara);
                            break;
                            case 4:
                              fechaMeta = campoFecha[0]+ separadorFecha +campoFecha[1]+ separadorFecha +campoFecha[2].substring(0,2);
                              SimpleDateFormat d5 = new SimpleDateFormat("yyyy" + separadorFecha + "MM" + separadorFecha + "dd");
                              fechaCamara = d5.parse( fechaMeta, new ParsePosition(0) );
                              d5 = new SimpleDateFormat("yyyy" + separadorFecha + formatoMes + separadorFecha + "dd", locale);
                              fechaMeta = d5.format(fechaCamara);
                            break;  
                            case 5:
                              fechaMeta = campoFecha[0].substring(2,4)+ separadorFecha +campoFecha[1]+ separadorFecha +campoFecha[2].substring(0,2);
                              SimpleDateFormat d6 = new SimpleDateFormat("yy" + separadorFecha + "MM" + separadorFecha + "dd");
                              fechaCamara = d6.parse( fechaMeta, new ParsePosition(0) );
                              d6 = new SimpleDateFormat("yy" + separadorFecha + formatoMes + separadorFecha + "dd", locale);
                              fechaMeta = d6.format(fechaCamara);
                            break;
                            case 6:
                              fechaMeta = campoFecha[0]+ separadorFecha +campoFecha[1];
                              SimpleDateFormat d7 = new SimpleDateFormat("yyyy" + separadorFecha + "MM");
                              fechaCamara = d7.parse( fechaMeta, new ParsePosition(0) );
                              d7 = new SimpleDateFormat("yyyy" + separadorFecha + formatoMes, locale);
                              fechaMeta = d7.format(fechaCamara);
                            break;
                            case 7:
                              fechaMeta = campoFecha[0].substring(2,4)+ separadorFecha +campoFecha[1];
                              SimpleDateFormat d8 = new SimpleDateFormat("yy" + separadorFecha + "MM");
                              fechaCamara = d8.parse( fechaMeta, new ParsePosition(0) );
                              d8 = new SimpleDateFormat("yy" + separadorFecha + formatoMes, locale);
                              fechaMeta = d8.format(fechaCamara);
                            break;
                            case 8:
                              fechaMeta = campoFecha[1] + separadorFecha + campoFecha[2].substring(0,2) + separadorFecha + campoFecha[0];
                              SimpleDateFormat d9 = new SimpleDateFormat("MM" + separadorFecha + "dd" + separadorFecha + "yyyy");
                              fechaCamara = d9.parse( fechaMeta, new ParsePosition(0) );
                              d9 = new SimpleDateFormat(formatoMes + separadorFecha + "dd" + separadorFecha + "yyyy", locale);
                              fechaMeta = d9.format(fechaCamara);
                            break;
                            case 9:
                              fechaMeta = campoFecha[1] + separadorFecha + campoFecha[2].substring(0,2) + separadorFecha +campoFecha[0].substring(2,4);
                              SimpleDateFormat d10 = new SimpleDateFormat("MM" + separadorFecha + "dd" + separadorFecha + "yy");
                              fechaCamara = d10.parse( fechaMeta, new ParsePosition(0) );
                              d10 = new SimpleDateFormat(formatoMes + separadorFecha + "dd" + separadorFecha + "yy", locale);
                              fechaMeta = d10.format(fechaCamara);
                            break;
                            case 10:
                              fechaMeta = campoFecha[0];
                            break;
                        }
                    }
                    else { 
                      String[] campoFecha = miFecha.split(":",5);
                      switch(opcion){
                          case 11:
                            fechaMeta = campoFecha[2].substring(3,5)+ separadorFecha +campoFecha[3]+ separadorFecha +campoFecha[4];
                          break;  
                          case 12:
                            fechaMeta = campoFecha[2].substring(3,5)+ separadorFecha +campoFecha[3];
                          break;
                      }
                    }
                 }
                 else fechaMeta = null;
               }
            }
         }
      }
      catch (ImageProcessingException | IOException e){
	System.err.println("Image no longer avialable");
      }
      catch (NoClassDefFoundError df) {
      }
      if (fechaMeta == null || miFecha.equals("0000:00:00 00:00:00") || miFecha.matches("    :  :     :  :.*")) {
	  if (opcion < 11) {
	      System.out.println("No metadata date for " + entraArchivo + ". Using file date instead");
	      return "File:" + getFecha(entraArchivo, opcion, separaFecha, diasMes, "modified", null);
	  }
	  else {
	      if (opcion >= 11) 
                  return getFecha(entraArchivo, opcion, separaFecha);
	  }
      }
     return fechaMeta;
  }
  public String getHora() {
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
  }
  public String getFecha() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	return dateFormat.format(date);
  }
  public String getFecha(String entraArchivo, int opcion, char separaFecha){
      return getFecha(entraArchivo, opcion, separaFecha, 0, "modified", null);
  }
  public String getFecha(String entraArchivo, int opcion, char separaFecha, int diasMes, String modified, Date datoCalendario){
	this.diasMes = diasMes;
	String fecha = "";
	String separadorFecha = "";
	String formatoMes = "MM";
	File fArchivo=new File(entraArchivo);
	Long ultModificado=fArchivo.lastModified();
	switch(separaFecha){
	    case '0':
	      separadorFecha = "";
	    break;  
	    case '1':
	      separadorFecha = "-";
	    break;
	    case '2':
	      separadorFecha = "_";
	    break;
	    case '3':
	      separadorFecha = ".";
	    break;
	    case '4':
	      separadorFecha = " ";
	    break;
	}
	switch(diasMes){
	    case 0:
	      formatoMes = "MM";
	    break;  
	    case 1:
	      formatoMes = "MMM";
	    break;
	    case 2:
	      formatoMes = "MMMM";
	    break;
	}
	SimpleDateFormat d1 = new SimpleDateFormat("dd" + separadorFecha + formatoMes + separadorFecha + "yyyy", locale);
	SimpleDateFormat d2 = new SimpleDateFormat("dd" + separadorFecha + formatoMes + separadorFecha + "yy", locale);
	SimpleDateFormat d3 = new SimpleDateFormat(formatoMes + separadorFecha + "yyyy", locale);
	SimpleDateFormat d4 = new SimpleDateFormat(formatoMes + separadorFecha + "yy", locale);
	SimpleDateFormat d5 = new SimpleDateFormat("yyyy" + separadorFecha + formatoMes + separadorFecha + "dd", locale);
	SimpleDateFormat d6 = new SimpleDateFormat("yy" + separadorFecha + formatoMes + separadorFecha + "dd", locale);
	SimpleDateFormat d7 = new SimpleDateFormat("yyyy" + separadorFecha + formatoMes, locale);
	SimpleDateFormat d8 = new SimpleDateFormat("yy" + separadorFecha + formatoMes, locale);
	SimpleDateFormat d9 = new SimpleDateFormat(formatoMes + separadorFecha + "dd" + separadorFecha + "yyy", locale);
	SimpleDateFormat d10 = new SimpleDateFormat(formatoMes + separadorFecha + "dd" + separadorFecha + "yy", locale);
	SimpleDateFormat d11 = new SimpleDateFormat("yyyy", locale);
	SimpleDateFormat d12 = new SimpleDateFormat("HH" + separadorFecha + "mm" + separadorFecha + "ss", locale);
	SimpleDateFormat d13 = new SimpleDateFormat("HH" + separadorFecha + "mm", locale);
	Date dateFecha = new Date(ultModificado);
	if (modified.equals("manual") && datoCalendario != null) {
	    dateFecha = datoCalendario;
	} else if (modified.equals("creation")) {
	    try {
		BasicFileAttributes attributes = Files.readAttributes(fArchivo.toPath(), BasicFileAttributes.class);
		long creationTime = attributes.creationTime().toMillis();
		dateFecha = new Date(creationTime);	    
	    } catch (IOException i) {
	    }
	} else if (modified.equals("accessed")) {
	    try {
		BasicFileAttributes attributes = Files.readAttributes(fArchivo.toPath(), BasicFileAttributes.class);
		long accessTime = attributes.lastAccessTime().toMillis();
		dateFecha = new Date(accessTime);	    
	    } catch (IOException i) {
	    }
	}
	switch(opcion) {
	  case 0:
	    fecha = d1.format(dateFecha);
	    break;
	  case 1:
	    fecha = d2.format(dateFecha);
	    break;
	  case 2:
	    fecha = d3.format(dateFecha);
	    break;
	  case 3:
	    fecha = d4.format(dateFecha);
	    break;
	  case 4:
	    fecha = d5.format(dateFecha);
	    break;
	  case 5:
	    fecha = d6.format(dateFecha);
	    break;
	  case 6:
	    fecha = d7.format(dateFecha);
	    break;
	  case 7:
	    fecha = d8.format(dateFecha);
	    break;
	  case 8:
	    fecha = d9.format(dateFecha);
	    break;
	  case 9:
	    fecha = d10.format(dateFecha);
	    break;
	  case 10:
	    fecha = d11.format(dateFecha);
	    break;
	  case 11:
	    fecha = d12.format(dateFecha);
	    break;
	  case 12:
	    fecha = d13.format(dateFecha);
	    break;
	}
	return fecha;
  }
  public String getCamara(String entraArchivo, String recibeStringCamara){
    File fArchivo=new File(entraArchivo);
    String miCamara="";
    try {
        Metadata metadata = ImageMetadataReader.readMetadata(fArchivo);
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {        
                switch (recibeStringCamara) {
                    case "0":
                        {
                            Pattern patron = Pattern.compile("Make");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString().replaceAll("\\[.*\\] Make - ","");
                              miCamara = miCamara.replaceAll(" "+".++$","");
                              miCamara = miCamara.replaceAll("\\[","");
                            }
                            break;
                        }
                    case "1":
                        {
                            Pattern patron = Pattern.compile("Model");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString().replaceAll("\\[.*\\] Model - ","");
                              miCamara = miCamara.replaceAll("[ ]++$","");
                              miCamara = miCamara.replaceAll("\\[","");
                            }
                            break;
                        }
                    case "2":
                        {
                            Pattern patron = Pattern.compile("Width");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()) miCamara = tag.toString().replaceAll("[^0-9]","");
                            break;
                        }
                    case "3":
                        {
                            Pattern patron = Pattern.compile("Height");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()) miCamara = tag.toString().replaceAll("[^0-9]","");
                            break;
                        }
                    case "4":
                        {
                            Pattern patron = Pattern.compile("Max Aperture");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString().replaceAll("\\[.*\\] Max Aperture Value - ","");
                              miCamara = miCamara.replaceAll("[ ]++$","");
                              miCamara = miCamara.replaceAll("\\[","");
                            }
                            break;
                        }
                    case "5":
                        {
                            Pattern patron = Pattern.compile("Exposure Time");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString().replaceAll("\\[.*\\] Exposure Time - ","");
                              miCamara = miCamara.replaceAll("[ ]++$","");
                              miCamara = miCamara.replaceAll("\\[","");
                            }
                            break;
                        }
                    case "6":
                        {
                            Pattern patron = Pattern.compile("Exposure Bias");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString().replaceAll("\\[.*\\] Exposure Bias Value - ","");
                              miCamara = miCamara.replaceAll("[ ]++$","");
                              miCamara = miCamara.replaceAll("\\[","");
                            }
                            break;
                        }
                    case "7":
                        {
                            Pattern patron = Pattern.compile("ISO Speed");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString().replaceAll("\\[.*\\] ISO Speed Ratings - ","");
                              miCamara = miCamara.replaceAll("[ ]++$","");
                              miCamara = miCamara.replaceAll("\\[","");
                            }
                            break;
                        }
                    case "8":
                        {
                            Pattern patron = Pattern.compile("Brightness Value");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString().replaceAll("\\[.*\\] Brightness Value - ","");
                              miCamara = miCamara.replaceAll("[ ]++$","");
                              miCamara = miCamara.replaceAll("\\[","");
                            }
                            break;
                        }
                    case "9":
                        {
                            Pattern patron = Pattern.compile("Focal Length");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString().replaceAll("\\[.*\\] Focal Length - ","");
                              miCamara = miCamara.replaceAll("[ ]++$","");
                              miCamara = miCamara.replaceAll("\\[","");
                            }
                            break;
                        }
                    case "10":
                        {
                            Pattern patron = Pattern.compile("Color Space");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString().replaceAll("\\[.*\\] Color Space - ","");
                              miCamara = miCamara.replaceAll("[ ]++$","");
                              miCamara = miCamara.replaceAll("\\[","");
                            }
                            break;
                        }
                    case "11":
                        {
                            Pattern patron = Pattern.compile("Orientation");
                            Matcher fOriginal = patron.matcher(tag.toString());
                            if (fOriginal.find()){
                              miCamara = tag.toString();
                              if (miCamara.contains("Rotate")) {
                                  String [] miCamaraSplit = miCamara.split("Rotate ");
                                  String [] miCamaraSplitFinal = miCamaraSplit[1].split(" ");
                                  miCamara = miCamaraSplitFinal[0];
                              }
                              else miCamara = "";
                            }
                            if (miCamara.equals("")) miCamara = "0";
                            break;
                        }
                }
            }
        }
      }
      catch (Exception e){
      }
      catch (NoClassDefFoundError df) {
      }
     return miCamara.replace("/","-");
  }
  public String addCeros(long numero, int cuantos){
      String Cadena;
      long patronNum = (long) Math.pow(10, cuantos + 1);
      if ( numero < (patronNum / 10) ) {
	  patronNum += numero;
	  Cadena = patronNum + "";
      } else {
	  return numero + "";
      }
      return Cadena.substring(1);
  }
  public int getNumera(String pathActual, int numeroComienza, int salta, int z) {
    int numeroActual;
    if (ht[z].containsKey(pathActual)) {
	numeroActual = ht[z].get(pathActual);
	numeroActual += salta;
	ht[z].put(pathActual,numeroActual);
    } else {
	ht[z].put(pathActual,numeroComienza);
	numeroActual = numeroComienza;
    }
    return numeroActual;
  }
  public int getIfNeeded(String pathActual, int numeroComienza, int salta, int z, int x, int mCuantos, String separaActual, String separa, int opcionSelec, String[][] ordenBusca, Boolean separaElminado, String sistema) {
    int numeroActual;
    if (sistema.equals("windows")) {
	pathActual = pathActual.toLowerCase(locale);
    }
    if (ht[z].containsKey(pathActual)) {
	numeroActual = ht[z].get(pathActual);
	numeroActual += salta;
	if (numeroActual == numeroComienza && ! FicherosComp[indSeleccionados[x]].toString().equals("")) {
	    int insertaEn;
	    int tamFichero;
	    if (opcionSelec == 1 || opcionSelec == 3) {
		insertaEn = FicherosComp[indSeleccionados[x]].length();
	    } else {
		insertaEn = FicherosComp[nd[z].get(pathActual)].toString().substring(0,FicherosComp[nd[z].get(pathActual)].toString().lastIndexOf('.')).length() + FicherosComp[indSeleccionados[x]].length() + 1;
	    }
	    if (z + 1 == ordenBusca.length && ! separa.equals("")) {
		FicherosComp[nd[z].get(pathActual)].insert(insertaEn - separa.length(), separa);
	    }

	    if ( FicherosComp[nd[z].get(pathActual)].toString().contains(".") && FicherosComp[nd[z].get(pathActual)].toString().lastIndexOf('.') > 0 ) {
		tamFichero = FicherosComp[nd[z].get(pathActual)].substring(0,FicherosComp[nd[z].get(pathActual)].toString().lastIndexOf('.')).length();
	    } else {
		tamFichero = FicherosComp[nd[z].get(pathActual)].length();
	    }
	    if ( ( insertaEn > FicherosComp[nd[z].get(pathActual)].length() &&  opcionSelec == 2 ) || ( insertaEn > tamFichero &&  opcionSelec != 2 ) ) {
		FicherosComp[nd[z].get(pathActual)].insert(insertaEn - separa.length(), separa);
            }
            switch (ordenBusca[z][5]) {
                case "1" -> {
                    String roman = toRomanNuevo(numeroActual);
                    if (ordenBusca[z][6].equals("0")) {
                        roman = roman.toUpperCase(locale);
                    } else {
                        roman = roman.toLowerCase(locale);
                    }   FicherosComp[nd[z].get(pathActual)].insert(insertaEn, roman);
                    insertaEn += roman.length();
                }
                case "2" -> {
                    String letters = toLetters(numeroActual);
                    if (ordenBusca[z][6].equals("0")) {
                        letters = letters.toUpperCase(locale);
                    } else {
                        letters = letters.toLowerCase(locale);
                    }   FicherosComp[nd[z].get(pathActual)].insert(insertaEn, letters);
                    insertaEn += letters.length();
                }
                case "3" -> {
                    String binario = Integer.toBinaryString(numeroActual);
                    FicherosComp[nd[z].get(pathActual)].insert(insertaEn, binario);
                    insertaEn += binario.length();
                }
                case "4" -> {
                    String hex = Integer.toHexString(numeroActual);
                    if (ordenBusca[z][6].equals("0")) {
                        hex = hex.toUpperCase(locale);
                    } else {
                        hex = hex.toLowerCase(locale);
                    }   FicherosComp[nd[z].get(pathActual)].insert(insertaEn, hex);
                    insertaEn += hex.length();
                }
                case "5" -> {
                    String octal = Integer.toOctalString(numeroActual);
                    numeroActual = Integer.parseInt(octal);
                    String octalCeros = addCeros(numeroActual,mCuantos);
                    FicherosComp[nd[z].get(pathActual)].insert(insertaEn, octalCeros);
                    insertaEn += octalCeros.length();
                }
                default -> {
                    String numeralCeros = addCeros(numeroActual,mCuantos);
                    FicherosComp[nd[z].get(pathActual)].insert(insertaEn, numeralCeros);
                    insertaEn += numeralCeros.length();
                }
            }
	    if ( z + 1 < ordenBusca.length && ! separaActual.equals("") && !separaElminado ) {
		FicherosComp[nd[z].get(pathActual)].insert(insertaEn, separaActual);
	    }
	    numeroActual += salta;
	}
	ht[z].put(pathActual,numeroActual);
    } else {
	ht[z].put(pathActual,numeroComienza-salta);
	nd[z].put(pathActual,indSeleccionados[x]);
	return -1;
    }

    return numeroActual;
  }
  public static java.util.List<String> getListaModeloNumeracion(int valorNum) {
      java.util.List<String> listaModelo = new ArrayList<>();
      switch (valorNum) {
	  case 1 -> {
              for (int x=1;x<2999;x++) {
                  listaModelo.add(toRomanNuevo(x));
              }
          }
	  case 2 -> {
              for (int x=1;x<2999;x++) {
                  listaModelo.add(toLetters(x));
              }
          }
	  case 3 -> {
              for (int x=0;x<2999;x++) {
                  listaModelo.add(Integer.toBinaryString(x));
              }
          }
	  case 4 -> {
              for (int x=0;x<2999;x++) {
                  listaModelo.add(Integer.toHexString(x).toUpperCase());
              }
          }
	  case 5 -> {
              for (int x=0;x<2999;x++) {
                  listaModelo.add(Integer.toOctalString(x));
              }
          }
      }
      return listaModelo;
  }
  public static String toRoman(int num) {
        String Roman = "";
        if (num > 3999 ||num < 1) {
            return num + "";
        }
        String onesArray[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String tensArray[] = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String hundredsArray[] = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        //	  Get the ones in the number
        int ones = num % 10;

        //	  Get the tens
        num = (num - ones) / 10;
        int tens = num % 10;

        //	  Get the hundreds
        num = (num - tens) / 10;
        int hundreds = num % 10;

        //	  Get and write the thousands in the number to our string
        num = (num - hundreds) / 10;
        for (int i = 0; i < num; i++) {
                Roman += "M";
        }

        //	  Write the hundreds
        if (hundreds >= 1) {
                Roman += hundredsArray[hundreds - 1];
        }

        //	  Write the tens
        if (tens >= 1) {
                Roman += tensArray[tens - 1];
        }

        //	  And finally, write the ones
        if (ones >= 1) {
                Roman += onesArray[ones - 1];
        }

        //	  Return our string.
        return String.valueOf(Roman);
  }
    public static String toRomanNuevo(int num) throws IndexOutOfBoundsException {
        if (num < 1 || num > 3999) {
            throw new IndexOutOfBoundsException("Número fuera de rango");
        }

        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] intValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder roman = new StringBuilder();
        int i = 12; // Comenzamos desde el valor más grande de intValues

        while (num > 0) {
            int div = num / intValues[i];
            num %= intValues[i];
            while (div > 0) {
                roman.append(romanSymbols[i]);
                div--;
            }
            i--;
        }

        return roman.toString();
    }
  
  public static String toLetters (int num) {
      if (num <= 0) {
          return num + "";
      }
      letters = "";
      String lettersArray[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W" ,"X", "Y", "Z"};      
      return toLetters(num, lettersArray);
  }
  public static String toLetters(int num, String[] lettersArray) {
      if ((num -1) / 26 >= 1) {
          toLetters ((num -1) / 26, lettersArray);
      }
      letters += lettersArray[(num - 1) % 26];
      return letters;
  }

  public static boolean endsWithIgnoreCase(String str, String suffix) {
      return endsWith(str, suffix, true);
  }
  private static boolean endsWith(String str, String suffix, boolean ignoreCase) {
      if (str == null || suffix == null) {
          return (str == null && suffix == null);
      }
      if (suffix.length() > str.length()) {
          return false;
      }
      int strOffset = str.length() - suffix.length();
      return str.regionMatches(ignoreCase, strOffset, suffix, 0, suffix.length());
  }
}