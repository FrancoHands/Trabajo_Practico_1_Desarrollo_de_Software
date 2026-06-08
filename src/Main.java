import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Paquete p1 = new Paquete(1, "Ropa");
        Paquete p2 = new Paquete(2, "Electrónicos");
        Paquete p3 = new Paquete(3, "Perfume");
        Paquete p4 = new Paquete(4, "Libros");
        Paquete p5 = new Paquete(5, "Zapatos");
        Paquete p6 = new Paquete(6, "Juguetes");

        Envio e1 = new EnvioEstandar(p1);
        e1.agregarPaquete(p4);
        Envio e2 = new EnvioExpress(p2);
        Envio e3 = new EnvioInternacional(p3);
        e3.agregarPaquete(p5);
        e3.agregarPaquete(p6);

        List<Envio> envios = new ArrayList<>();
        envios.add(e1);
        envios.add(e2);
        envios.add(e3);

        e1.iniciarEnvio();
        e2.iniciarEnvio();

        e2.getPaquetes().get(0).avanzarEstado();
        e3.iniciarEnvio();

        e3.finalizarEnvio();

        e1.calcularCosto(13);
        e2.calcularCosto(17);
        e3.calcularCosto(21);

        for (Envio envio : envios) {
            System.out.println("Tipo de envío: " + envio.getClass().getSimpleName());
            System.out.println("Paquetes: " + envio.getPaquetes().size());
            for (Paquete paquete : envio.getPaquetes()) {
                System.out.println(" - Paquete " + paquete.getId() + " (" + paquete.getDescripcion() + ") - " + paquete.getEstado());
            }
            System.out.println("Costo aproximado: $" + envio.getCosto());
            System.out.println("-------------------");
        }
    }
}


