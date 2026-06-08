public class EnvioInternacional extends Envio {
    public EnvioInternacional(Paquete paquete) {
        super(paquete);
    }

    @Override
    protected double tarifa() {
        return 20;
    }
}
