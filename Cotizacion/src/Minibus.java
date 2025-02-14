public class Minibus extends VehiculoPasajero {
    public Minibus(){
    }

    public Minibus(String patente){
        super(patente, 19);
    }

    @Override
    public double calcularPrecio(int dias_alquiler){
        return (getPrecioBase() * dias_alquiler) + (getPlazas() * 120);
    }
    
}
