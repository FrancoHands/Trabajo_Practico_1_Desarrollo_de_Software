import java.util.ArrayList;
import java.util.List;

public abstract class Envio {
    private static final int CANTIDAD_MINIMA = 1;
    private static final int CANTIDAD_MAXIMA = 3;
    private static final double PESO_MAXIMO = 100;

    private final List<Paquete> paquetes = new ArrayList<>();
    private double costo;

    public Envio() {
    }

    public Envio(Paquete paquete) {
        agregarPaquete(paquete);
    }

    public Envio(List<Paquete> paquetesIniciales) {
        if (paquetesIniciales == null || paquetesIniciales.isEmpty()) {
            throw new IllegalArgumentException("Un envío debe tener al menos un paquete.");
        }
        for (Paquete paquete : paquetesIniciales) {
            agregarPaquete(paquete);
        }
    }

    public void agregarPaquete(Paquete paquete) {
        if (paquete == null) {
            throw new IllegalArgumentException("El paquete no puede ser nulo.");
        }
        if (paquetes.size() >= CANTIDAD_MAXIMA) {
            throw new IllegalStateException("No se pueden agregar más de " + CANTIDAD_MAXIMA + " paquetes.");
        }
        paquetes.add(paquete);
    }

    public List<Paquete> getPaquetes() {
        return new ArrayList<>(paquetes);
    }

    public double getCosto() {
        return costo;
    }

    public void iniciarEnvio() {
        chequearEnvioValido();
        for (Paquete paquete : paquetes) {
            paquete.prepararParaEnvio();
        }
    }

    public void iniciarDistribucion() {
        chequearEnvioValido();
        for (Paquete paquete : paquetes) {
            paquete.marcarEnDistribucion();
        }
    }

    public void finalizarEnvio() {
        chequearEnvioValido();
        for (Paquete paquete : paquetes) {
            if ("Recibido".equals(paquete.getEstado())) paquete.prepararParaEnvio();
            if ("En preparación".equals(paquete.getEstado())) paquete.marcarEnDistribucion();
            if ("En distribución".equals(paquete.getEstado())) paquete.entregar();
        }
    }

    public void calcularCosto() {
        double pesoTotal = 0;
        for (Paquete paquete : paquetes) {
            pesoTotal += paquete.getPeso();
        }
        chequearPeso(pesoTotal);
        costo = pesoTotal * tarifa();
    }

    protected abstract double tarifa();

    private void chequearPeso(double peso) {
        if (peso <= 0 || peso >= PESO_MAXIMO) {
            throw new IllegalArgumentException("El peso total debe estar entre 0 y " + PESO_MAXIMO + "kg.");
        }
    }

    private void chequearEnvioValido() {
        if (paquetes.size() < CANTIDAD_MINIMA) {
            throw new IllegalStateException("El envío debe tener al menos " + CANTIDAD_MINIMA + " paquete.");
        }
    }
}
