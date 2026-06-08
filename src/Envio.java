import java.util.ArrayList;
import java.util.List;

public abstract class Envio {
    private static final int CANTIDAD_MINIMA = 1;
    private static final int CANTIDAD_MAXIMA = 3;

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
            paquete.avanzarEstado();
        }
    }

    public void finalizarEnvio() {
        chequearEnvioValido();
        for (Paquete paquete : paquetes) {
            while (!"Entregado".equals(paquete.getEstado())) {
                paquete.avanzarEstado();
            }
        }
    }

    public void calcularCosto(double peso) {
        chequearPeso(peso);
        costo = peso * tarifa();
    }

    protected abstract double tarifa();

    private void chequearPeso(double peso) {
        if (peso <= 0 || peso >= 100) {
            throw new IllegalArgumentException("El peso debe estar entre 0 y 100.");
        }
    }

    private void chequearEnvioValido() {
        if (paquetes.size() < CANTIDAD_MINIMA) {
            throw new IllegalStateException("El envío debe tener al menos " + CANTIDAD_MINIMA + " paquete.");
        }
    }
}


