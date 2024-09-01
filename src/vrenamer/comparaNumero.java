package vrenamer;

public class comparaNumero {

  private String archivo;
  private long numero;

  public comparaNumero(String archivo, long numero) {
    this.archivo = archivo;
    this.numero = numero;
  }

  public String getArchivo() {
    return archivo;
  }

  public long getNumero() {
    return numero;
  }

  @Override
  public String toString() {
    return String.format("comparaNumero{archivo:%1s,numero:%2s}", archivo, numero);
  }
}