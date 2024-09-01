package vrenamer;

import javax.swing.undo.*;
import javax.swing.*;
import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;


/**
* The Add Edit class record the changes occured to the
* list after performing an add action. The add edit support
* undo / redo of add action.
*
* @author Tomer Meshorer
*/

public class AttributesEdit extends AbstractUndoableEdit {

    private int[] seleccion, iAtributos;
    private File[] archivosOriginales;
    private int atributo, atributoEstado, cAtributos;
    private String separador;
    private idiomas Idioma;
    private Boolean[][] seleccionDoble;
    private java.util.List<FileTime> tiempoActual;
    private FileTime[][] tiempoAnterior;
    private String fechaAtributoSelec;
    public AttributesEdit( Boolean[][] seleccionDoble, int[] seleccion, File[] archivosOriginales, int atributo, int atributoEstado, int cAtributos, int[] iAtributos, FileTime[][] tiempoAnterior, java.util.List<FileTime> tiempoActual, String fechaAtributoSelec, String separador, idiomas Idioma ) {
      this.seleccion = seleccion;
      this.archivosOriginales = archivosOriginales;
      this.atributo = atributo;
      this.atributoEstado = atributoEstado;
      this.cAtributos = cAtributos;
      this.iAtributos = iAtributos;
      this.seleccionDoble = seleccionDoble;
      this.tiempoAnterior = tiempoAnterior;
      this.tiempoActual = tiempoActual;
      this.fechaAtributoSelec = fechaAtributoSelec;
      this.separador = separador;
      this.Idioma = Idioma;
    }

    @Override
    public void undo() throws CannotUndoException {
	if (separador.equals("/")) {  //nix
	    for(int x=0;x<seleccion.length;x++){
		if (cAtributos == 0) {
		    switch(atributo) {
			case 0:
			    if (atributoEstado == 0) {
				archivosOriginales[seleccion[x]].setReadable(false, false);
			    } else {
				archivosOriginales[seleccion[x]].setReadable(true, false);
			    }
			break;
			case 1:
			    if (atributoEstado == 0) {
				archivosOriginales[seleccion[x]].setWritable(false, false);
			    } else {
				archivosOriginales[seleccion[x]].setWritable(true, false);
			    }
			break;
			case 2:
			    if (atributoEstado == 0) {
				archivosOriginales[seleccion[x]].setExecutable(false, false);
			    } else {
				archivosOriginales[seleccion[x]].setExecutable(true, false);
			    }
			break;
			case 3:
			    if (atributoEstado == 0) {
				new File (archivosOriginales[seleccion[x]].getParent() + separador + "." + archivosOriginales[seleccion[x]].getName()).renameTo(archivosOriginales[seleccion[x]]);
			    } else {
				new File (archivosOriginales[seleccion[x]].getParent() + separador + archivosOriginales[seleccion[x]].getName().substring(1,archivosOriginales[seleccion[x]].getName().length())).renameTo(archivosOriginales[seleccion[x]]);
			    }
			break;
			case 4:
			    try {
				if (fechaAtributoSelec.contains("last"))
				    Files.setLastModifiedTime(archivosOriginales[seleccion[x]].toPath(), tiempoAnterior[x][0]);
				if (fechaAtributoSelec.contains("creation"))
				    Files.setAttribute(archivosOriginales[seleccion[x]].toPath(), "basic:creationTime", tiempoAnterior[x][1]); 
				if (fechaAtributoSelec.contains("access"))
				    Files.setAttribute(archivosOriginales[seleccion[x]].toPath(), "basic:lastAccessTime", tiempoAnterior[x][2]); 
			    } catch (Exception c) {
			    }
			break;
		    }
		} else {
		      if (seleccionDoble[x][3]) {
			  if (iAtributos[3] == 0) {
			      new File (archivosOriginales[seleccion[x]].getParent() + separador + "." + archivosOriginales[seleccion[x]].getName()).renameTo(archivosOriginales[seleccion[x]]);
			  } else {
			      new File (archivosOriginales[seleccion[x]].getParent() + separador + archivosOriginales[seleccion[x]].getName().substring(1,archivosOriginales[seleccion[x]].getName().length())).renameTo(archivosOriginales[seleccion[x]]);
			  }
		      }
		      if (seleccionDoble[x][0]) {
			  if (iAtributos[0] == 0) {
			      archivosOriginales[seleccion[x]].setReadable(false, false);
			  } else {
			      archivosOriginales[seleccion[x]].setReadable(true, false);
			  }
		      }
		      if (seleccionDoble[x][1]) {
			  if (iAtributos[1] == 0) {
			      archivosOriginales[seleccion[x]].setWritable(false, false);
			  } else {
			      archivosOriginales[seleccion[x]].setWritable(true, false);
			  }
		      }
		      if (seleccionDoble[x][2]) {
			  if (iAtributos[2] == 0) {
			      archivosOriginales[seleccion[x]].setExecutable(false, false);
			  } else {
			      archivosOriginales[seleccion[x]].setExecutable(true, false);
			  }
		      }
		}
	    }
	} else {  //Windows
	    for(int x=0;x<seleccion.length;x++){
		if (cAtributos == 0) {
		    switch(atributo) {
			case 0:
			    if (atributoEstado == 0) {
				archivosOriginales[seleccion[x]].setWritable(true, false);
			    } else {
				archivosOriginales[seleccion[x]].setWritable(false, false);
			    }
			break;
			case 1:
			    if (atributoEstado == 0) {
				try {
				    Process p = Runtime.getRuntime().exec("attrib -H " + "\"" + archivosOriginales[seleccion[x]] + "\"");
				    try {
					p.waitFor();
				    } catch (Exception i) {
				    }
				} catch (IOException e) {
				}   
			    } else {
				try {
				    Process p = Runtime.getRuntime().exec("attrib +H " + "\"" + archivosOriginales[seleccion[x]] + "\"");
				    try {
					p.waitFor();
				    } catch (Exception i) {
				    }
				} catch (IOException e) {
				}
			    }
			break;
			case 2:
			    Path path = archivosOriginales[seleccion[x]].toPath();
			    DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class); 
			    if (atributoEstado == 0) {
				try {
				    DosFileAttributes dos = dosView.readAttributes();
				    if ( dos.isSystem() )
					dosView.setSystem(false);
				} catch (IOException io) {
				}
			    } else {
				try {
				    DosFileAttributes dos = dosView.readAttributes();
				    if ( ! dos.isSystem() )
					dosView.setSystem(true);
				} catch (IOException io) {
				}
			    }
			break;
			case 3:
			    path = archivosOriginales[seleccion[x]].toPath();
			    dosView = Files.getFileAttributeView(path, DosFileAttributeView.class); 
			    if (atributoEstado == 0) {
				try {
				    DosFileAttributes dos = dosView.readAttributes();
				    if ( dos.isArchive() )
					dosView.setArchive(false);
				} catch (IOException io) {
				}
			    } else {
				try {
				    DosFileAttributes dos = dosView.readAttributes();
				    if ( ! dos.isArchive() )
					dosView.setArchive(true);
				} catch (IOException io) {
				}
			    }
			break;
			case 4:
			    try {
				if (fechaAtributoSelec.contains("last"))
				    Files.setLastModifiedTime(archivosOriginales[seleccion[x]].toPath(), tiempoAnterior[x][0]);
				if (fechaAtributoSelec.contains("creation"))
				    Files.setAttribute(archivosOriginales[seleccion[x]].toPath(), "basic:creationTime", tiempoAnterior[x][1]); 
				if (fechaAtributoSelec.contains("access"))
				    Files.setAttribute(archivosOriginales[seleccion[x]].toPath(), "basic:lastAccessTime", tiempoAnterior[x][2]); 
			    } catch (Exception c) {
			    }
			break;
		    }
		} else {
		    if (seleccionDoble[x][1]) {
			if (iAtributos[1] == 0) {
			    try {
				Process p = Runtime.getRuntime().exec("attrib -H " + "\"" + archivosOriginales[seleccion[x]] + "\"");
				try {
				    p.waitFor();
				} catch (Exception i) {
				}
			    } catch (IOException e) {
			    }
			}
			else {
			    try {
				Process p = Runtime.getRuntime().exec("attrib +H " + "\"" + archivosOriginales[seleccion[x]] + "\"");
				try {
				    p.waitFor();
				} catch (Exception i) {
				}
			    } catch (IOException e) {
			    }
			}
		    }
		    Path path = archivosOriginales[seleccion[x]].toPath();
		    DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class); 
		    if (seleccionDoble[x][2]) {
			if (iAtributos[2] == 0) {
			    try {
				DosFileAttributes dos = dosView.readAttributes();
				if ( dos.isSystem() )
				    dosView.setSystem(false);
			    } catch (IOException io) {
			    }
			} else {
			    try {
				DosFileAttributes dos = dosView.readAttributes();
				if ( ! dos.isSystem() )
				    dosView.setSystem(true);
			    } catch (IOException io) {
			    }
			}
		    }
		    if (seleccionDoble[x][3]) {
			if (iAtributos[3] == 0) {
			    try {
				DosFileAttributes dos = dosView.readAttributes();
				if ( dos.isArchive() )
				    dosView.setArchive(false);
			    } catch (IOException io) {
			    }
			} else {
			    try {
				DosFileAttributes dos = dosView.readAttributes();
				if ( ! dos.isArchive() )
				    dosView.setArchive(true);
			    } catch (IOException io) {
			    }
			}
		    }
		    if (seleccionDoble[x][0]) {
			if (iAtributos[0] == 0) {
			    archivosOriginales[seleccion[x]].setWritable(true, false);
			} else {
			    archivosOriginales[seleccion[x]].setWritable(false, false);
			}
		    }
		}
	    }
	}
    }

    @Override
    public void redo() throws CannotRedoException {
	if (separador.equals("/")) { //nix
	    for(int x=0;x<seleccion.length;x++){
		if (cAtributos == 0) {
		    switch(atributo) {
			case 0:
			    if (atributoEstado == 0) {
				archivosOriginales[seleccion[x]].setReadable(true, false);
			    } else {
				archivosOriginales[seleccion[x]].setReadable(false, false);
			    }
			break;
			case 1:
			    if (atributoEstado == 0) {
				archivosOriginales[seleccion[x]].setWritable(true, false);
			    } else {
				archivosOriginales[seleccion[x]].setWritable(false, false);
			    }
			break;
			case 2:
			    if (atributoEstado == 0) {
				archivosOriginales[seleccion[x]].setExecutable(true, false);
			    } else {
				archivosOriginales[seleccion[x]].setExecutable(false, false);
			    }
			break;
			case 3:
			    if (atributoEstado == 0) {
				archivosOriginales[seleccion[x]].renameTo( (archivosOriginales[seleccion[x]].getName().substring(0,1).equals(".")) ? archivosOriginales[seleccion[x]] : new File (archivosOriginales[seleccion[x]].getParent() + separador + "." + archivosOriginales[seleccion[x]].getName() ));
			    } else {
				archivosOriginales[seleccion[x]].renameTo( (archivosOriginales[seleccion[x]].getName().substring(0,1).equals(".")) ? new File (archivosOriginales[seleccion[x]].getParent() + separador + archivosOriginales[seleccion[x]].getName().substring(1,archivosOriginales[seleccion[x]].getName().length() )) : archivosOriginales[seleccion[x]] );
			    }
			break;
			case 4:
			    try {
				if (fechaAtributoSelec.contains("last"))
				    Files.setLastModifiedTime(archivosOriginales[seleccion[x]].toPath(), tiempoActual.get(x));
				if (fechaAtributoSelec.contains("creation"))
				    Files.setAttribute(archivosOriginales[seleccion[x]].toPath(), "basic:creationTime", tiempoActual.get(x)); 
				if (fechaAtributoSelec.contains("access"))
				    Files.setAttribute(archivosOriginales[seleccion[x]].toPath(), "basic:lastAccessTime", tiempoActual.get(x)); 
			    } catch (Exception c) {
			    }
			break;
		    }
		} else {
		      if (seleccionDoble[x][3]) {
			  if (iAtributos[3] == 0) {
				archivosOriginales[seleccion[x]].renameTo( (archivosOriginales[seleccion[x]].getName().substring(0,1).equals(".")) ? archivosOriginales[seleccion[x]] : new File (archivosOriginales[seleccion[x]].getParent() + separador + "." + archivosOriginales[seleccion[x]].getName() ));
			  } else {
				archivosOriginales[seleccion[x]].renameTo( (archivosOriginales[seleccion[x]].getName().substring(0,1).equals(".")) ? new File (archivosOriginales[seleccion[x]].getParent() + separador + archivosOriginales[seleccion[x]].getName().substring(1,archivosOriginales[seleccion[x]].getName().length() )) : archivosOriginales[seleccion[x]] );
			  }
		      }
		      if (seleccionDoble[x][0]) {
			  if (iAtributos[0] == 0) {
			      archivosOriginales[seleccion[x]].setReadable(true, false);
			  } else {
			      archivosOriginales[seleccion[x]].setReadable(false, false);
			  }
		      }
		      if (seleccionDoble[x][1]) {
			  if (iAtributos[1] == 0) {
			      archivosOriginales[seleccion[x]].setWritable(true, false);
			  } else {
			      archivosOriginales[seleccion[x]].setWritable(false, false);
			  }
		      }
		      if (seleccionDoble[x][2]) {
			  if (iAtributos[2] == 0) {
			      archivosOriginales[seleccion[x]].setExecutable(true, false);
			  } else {
			      archivosOriginales[seleccion[x]].setExecutable(false, false);
			  }
		      }
		}
	    }
	}
	else {  //Windows
	    for(int x=0;x<seleccion.length;x++){
		if (cAtributos == 0) {
		    switch(atributo) {
			case 0:
			    if (atributoEstado == 0) {
				archivosOriginales[seleccion[x]].setWritable(false, false);
			    } else {
				archivosOriginales[seleccion[x]].setWritable(true, false);
			    }
			break;
			case 1:
			    if (atributoEstado == 0) {
				try {
				    Process p = Runtime.getRuntime().exec("attrib +H " + "\"" + archivosOriginales[seleccion[x]] + "\"");
				    try {
					p.waitFor();
				    } catch (Exception i) {
				    }
				} catch (IOException e) {
				}
			    } else {
				try {
				    Process p = Runtime.getRuntime().exec("attrib -H " + "\"" + archivosOriginales[seleccion[x]] + "\"");
				    try {
					p.waitFor();
				    } catch (Exception i) {
				    }
				} catch (IOException e) {
				}
			    }
			break;
			case 2:
			    Path path = archivosOriginales[seleccion[x]].toPath();
			    DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class); 
			    if (atributoEstado == 0) {
				try {
				    DosFileAttributes dos = dosView.readAttributes();
				    if ( ! dos.isSystem() )
					dosView.setSystem(true);
				} catch (IOException io) {
				}
			    } else {
				try {
				    DosFileAttributes dos = dosView.readAttributes();
				    if ( dos.isSystem() )
					dosView.setSystem(false);
				} catch (IOException io) {
				}
			    }
			break;
			case 3:
			    path = archivosOriginales[seleccion[x]].toPath();
			    dosView = Files.getFileAttributeView(path, DosFileAttributeView.class); 
			    if (atributoEstado == 0) {
				try {
				    DosFileAttributes dos = dosView.readAttributes();
				    if ( ! dos.isArchive() )
					dosView.setArchive(true);
				} catch (IOException io) {
				}
			    } else {
				try {
				    DosFileAttributes dos = dosView.readAttributes();
				    if ( dos.isArchive() )
					dosView.setArchive(false);
				} catch (IOException io) {
				}
			    }
			break;
			case 4:
			    try {
				if (fechaAtributoSelec.contains("last"))
				    Files.setLastModifiedTime(archivosOriginales[seleccion[x]].toPath(), tiempoActual.get(x));
				if (fechaAtributoSelec.contains("creation"))
				    Files.setAttribute(archivosOriginales[seleccion[x]].toPath(), "basic:creationTime", tiempoActual.get(x)); 
				if (fechaAtributoSelec.contains("access"))
				    Files.setAttribute(archivosOriginales[seleccion[x]].toPath(), "basic:lastAccessTime", tiempoActual.get(x)); 
			    } catch (Exception c) {
			    }
			break;
		    }
		} else {
		    if (seleccionDoble[x][1]) {
			if (iAtributos[1] == 0) {
			    try {
				Process p = Runtime.getRuntime().exec("attrib +H " + "\"" + archivosOriginales[seleccion[x]] + "\"");
				try {
				    p.waitFor();
				} catch (Exception i) {
				}
			    } catch (IOException e) {
			    }
			} else {
			    try {
				Process p = Runtime.getRuntime().exec("attrib -H " + "\"" + archivosOriginales[seleccion[x]] + "\"");
				try {
				    p.waitFor();
				} catch (Exception i) {
				}
			    } catch (IOException e) {
			    }
			}
		    }
		    Path path = archivosOriginales[seleccion[x]].toPath();
		    DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class); 
		    if (seleccionDoble[x][2]) {
			if (iAtributos[2] == 0) {
			    try {
				DosFileAttributes dos = dosView.readAttributes();
				if ( ! dos.isSystem() )
				    dosView.setSystem(true);
			    } catch (IOException io) {
			    }
			} else {
			    try {
				DosFileAttributes dos = dosView.readAttributes();
				if ( dos.isSystem() )
				    dosView.setSystem(false);
			    } catch (IOException io) {
			    }
			}
		    }
		    if (seleccionDoble[x][3]) {
			if (iAtributos[3] == 0) {
			    try {
				DosFileAttributes dos = dosView.readAttributes();
				if ( ! dos.isArchive() )
				    dosView.setArchive(true);
			    } catch (IOException io) {
			    }
			} else {
			    try {
				DosFileAttributes dos = dosView.readAttributes();
				if ( dos.isArchive() )
				    dosView.setArchive(false);
			    } catch (IOException io) {
			    }
			}
		    }
		    if (seleccionDoble[x][0]) {
			if (iAtributos[0] == 0) {
			    archivosOriginales[seleccion[x]].setWritable(false, false);
			} else {
			    archivosOriginales[seleccion[x]].setWritable(true, false);
			}
		    }
		}
	    }
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
      if (Idioma instanceof idiomasEsp) return "atributos";
      else return "attributes";
    }
}

