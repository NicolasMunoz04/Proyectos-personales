public class Auto extends VehiculoPasajero {
    public Auto(){
    }

    public Auto(String patente, int plazas){
        super(patente, plazas);
    }
    
    @Override
    public double calcularPrecio(int dias_alquiler){
        return (getPrecioBase() * dias_alquiler) + 100 * (dias_alquiler + getPlazas());
    }
    
}
