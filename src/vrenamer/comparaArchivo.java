package vrenamer;

public class comparaArchivo {

  private String archivo;
  private long fecha;

  public comparaArchivo(String archivo, long fecha) {
    this.archivo = archivo;
    this.fecha = fecha;
  }

  public String getArchivo() {
    return archivo;
  }

  public long getFecha() {
    return fecha;
  }

  @Override
  public String toString() {
    return String.format("comparaArchivo{archivo:%1s,fecha:%2s}", archivo, fecha);
  }
}