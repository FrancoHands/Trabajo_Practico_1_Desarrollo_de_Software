public class EnvioEstandar extends Envio {
    public EnvioEstandar(Paquete paquete) {
        super(paquete);
    }

    @Override
    protected double tarifa() {
        return 10;
    }
}
