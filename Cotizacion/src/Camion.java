public class Camion extends VehiculoCarga {
    public Camion(){
    }

    public Camion(String patente, double PMA){
        super(patente, PMA); 
    }

    @Override
    public double calcularPrecio(int dias_alquiler){
        return (getPrecioBase() * dias_alquiler) + (getPMA() * 800) + 1600;
    }

    
}
