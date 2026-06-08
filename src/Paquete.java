public class Paquete {
  private int id;
  private String descripcion;
  private String estado;

  public Paquete(int id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
    this.estado = "Recibido";
  }

  public Paquete(int id) {
    this(id, "Sin descripción");
  }

  public void avanzarEstado() {
    if (estado.equals("Recibido")) estado = "En preparación";
    else if (estado.equals("En preparación")) estado = "En distribución";
    else if (estado.equals("En distribución")) estado = "Entregado";
  }

  public int getId() { return id; }
  public String getDescripcion() { return descripcion; }
  public String getEstado() { return estado; }
}




