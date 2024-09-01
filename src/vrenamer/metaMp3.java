package vrenamer;

import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.*;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.*;

public class metaMp3 {
  private AudioFile f;
  private Tag tag;
  private AudioHeader audio;
  private String etiqueta;
  private idiomas Idioma;
  
  public metaMp3 (idiomas Idioma) {
    this.Idioma = Idioma;
  }
  public String getMp3(String entraArchivo, String campo, String cuantos){
    File fArchivo=new File(entraArchivo);
    try{
      f = AudioFileIO.read(fArchivo);
      tag = f.getTag();
      audio = f.getAudioHeader();
        switch (campo) {
            case "0":
                etiqueta=tag.getFirst(FieldKey.ARTIST);
                break;
            case "1":
                etiqueta=tag.getFirst(FieldKey.TITLE);
                break;
            case "2":
                etiqueta=tag.getFirst(FieldKey.TRACK);
                int ceros = Integer.parseInt(cuantos);
                int nEtiqueta = Integer.parseInt(etiqueta);
                etiqueta=new MotorBusca(Idioma).addCeros(nEtiqueta, ceros);
                break;
            case "3":
                etiqueta=tag.getFirst(FieldKey.ALBUM);
                break;
            case "4":
                etiqueta=tag.getFirst(FieldKey.YEAR);
                break;
            case "5":
                etiqueta=tag.getFirst(FieldKey.GENRE);
                break;
        }
    }
    catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException | KeyNotFoundException | NumberFormatException e){
    }
    if (etiqueta == null) 
        etiqueta = "";
    return etiqueta;
  }
}