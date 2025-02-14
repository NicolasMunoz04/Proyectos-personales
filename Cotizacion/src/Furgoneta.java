public class Furgoneta extends VehiculoCarga {
    public Furgoneta(){
    }

    public Furgoneta(String patente, double PMA){
        super(patente, PMA);
    }

    @Override
    public double calcularPrecio(int dias_alquiler){
        return (getPrecioBase() * dias_alquiler) + (800 * getPMA());
    }
    
}
