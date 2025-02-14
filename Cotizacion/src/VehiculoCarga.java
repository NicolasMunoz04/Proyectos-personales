public abstract class VehiculoCarga extends Vehiculo {
    private double PMA;

    // Constructor vacío
    public VehiculoCarga() {}

    // Constructor con parámetros
    public VehiculoCarga(String patente, double PMA) {
        super(patente);
        this.PMA = PMA;
    }

    // Getters y Setters
    public double getPMA() {
        return PMA;
    }

    public void setPMA(double PMA) {
        this.PMA = PMA;
    }
}

