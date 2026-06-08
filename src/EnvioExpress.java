public class EnvioExpress extends Envio {
    public EnvioExpress(Paquete paquete) {
        super(paquete);
    }

    @Override
    protected double tarifa() {
        return 15;
    }
}

