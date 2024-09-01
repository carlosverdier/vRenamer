package vrenamer;

import javax.swing.undo.*;
import java.io.File;


/**
* The Add Edit class record the changes occured to the
* list after performing an add action. The add edit support
* undo / redo of add action.
*
* @author Tomer Meshorer
*/

public class mp3Edit extends AbstractUndoableEdit {

  private int[] indSeleccionados;
  private File[] archivosOriginales;
  private String[] pista, cancion, artista, album, anyo, genero; 
  private String[] pistaAnt, cancionAnt, artistaAnt, albumAnt, anyoAnt, generoAnt; 
  private Boolean incrementa;
  private idiomas Idioma;
  private metaMp3 datosMp3;
  private metaMp3Escribe datosMp3Escribe;


  public mp3Edit( int[] indSeleccionados, File[] archivosOriginales, Boolean incrementa, String[] pista, String[] cancion, String[] artista, String[] album, String[] anyo, String[] genero, String[] pistaAnt, String[] cancionAnt, String[] artistaAnt, String[] albumAnt, String[] anyoAnt, String[] generoAnt, idiomas Idioma ) {
     this.indSeleccionados = indSeleccionados;
     this.archivosOriginales = archivosOriginales;
     this.incrementa = incrementa;
     this.pista = pista;
     this.cancion = cancion;
     this.artista = artista;
     this.album = album;
     this.anyo = anyo;
     this.genero = genero;
     this.pistaAnt = pistaAnt;
     this.cancionAnt = cancionAnt;
     this.artistaAnt = artistaAnt;
     this.albumAnt = albumAnt;
     this.anyoAnt = anyoAnt;
     this.generoAnt = generoAnt;
     this.Idioma = Idioma;

     datosMp3 = new metaMp3(Idioma);
     datosMp3Escribe = new metaMp3Escribe();
  }

  @Override
  public void undo() throws CannotUndoException {
     for(int x=0;x<indSeleccionados.length;x++){	
	datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"0",pistaAnt[x]);
	datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"1",cancionAnt[x]);
	datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"2",artistaAnt[x]);
	datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"3",albumAnt[x]);
	datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"4",anyoAnt[x]);
	datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"5",generoAnt[x]);
     } 
  }

  @Override
  public void redo() throws CannotRedoException {
      int incrementaInt = 0;
      if (incrementa) {
	  incrementaInt = Integer.parseInt(pista[0]);
      }
      for (int x=0; x<indSeleccionados.length; x++) {
	if (incrementa) {
	  pista[x] = incrementaInt+"";
	  incrementaInt++;
	}
	if (!pista[x].equals("")) datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"0",pista[x]);
	if (!cancion[x].equals("")) datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"1",cancion[x]);
	if (!artista[x].equals("")) datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"2",artista[x]);
	if (!album[x].equals("")) datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"3",album[x]);
	if (!anyo[x].equals("")) datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"4",anyo[x]);
	if (!genero[x].equals("")) datosMp3Escribe.setMp3(archivosOriginales[indSeleccionados[x]].toString(),"5",genero[x]);
      }
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
     return "mp3";
  }

}
