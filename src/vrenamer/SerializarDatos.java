package vrenamer;

import java.io.*;
import java.beans.XMLEncoder;

public class SerializarDatos {

 public boolean xmlEnconder(String rutaIn, vDatos datosIn)
   throws FileNotFoundException {

    FileOutputStream fileOutputStream;
    XMLEncoder encoder;
    fileOutputStream = new FileOutputStream(rutaIn);
    encoder = new XMLEncoder(fileOutputStream);
    encoder.writeObject(datosIn);
    encoder.close();

    return true;
 }
}