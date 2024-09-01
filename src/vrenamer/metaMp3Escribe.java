package vrenamer;

import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.*;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.*;

public class metaMp3Escribe {
  AudioHeader audio;
  public void setMp3(String entraArchivo, String campo, String etiqueta){
    File fArchivo=new File(entraArchivo);
    try{
      AudioFile f = AudioFileIO.read(fArchivo);
      Tag tag = f.getTagOrCreateAndSetDefault();
        switch (campo) {
            case "0":
                tag.setField(FieldKey.TRACK,etiqueta);
                break;
            case "1":
                tag.setField(FieldKey.TITLE,etiqueta);
                break;
            case "2":
                tag.setField(FieldKey.ARTIST,etiqueta);
                break;
            case "3":
                tag.setField(FieldKey.ALBUM,etiqueta);
                break;
            case "4":
                tag.setField(FieldKey.YEAR,etiqueta);
                break;
            case "5":
                tag.setField(FieldKey.GENRE,etiqueta);
                break;
        }
      f.commit();
    }
    catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException | KeyNotFoundException | CannotWriteException e) {
    }
  }
}