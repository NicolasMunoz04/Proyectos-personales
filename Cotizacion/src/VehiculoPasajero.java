public abstract class VehiculoPasajero extends Vehiculo {
    private int plazas;

    // Constructor vacío
    public VehiculoPasajero(){
    }

    // Constructor con parámetros
    public VehiculoPasajero(String patente, int plazas) {
        super(patente);
        this.plazas = plazas;
    }

    public int getPlazas(){
        return plazas;
    }

    public void setPlazas(int plazas){
        this.plazas = plazas;
    }
}

