public abstract class Vehiculo {
    private String patente;
    private final double PRECIO_BASE_DIARIO = 2000.0;

    // Constructor Vacío
    public Vehiculo(){
    }

    // Constructor con parámetros
    public Vehiculo(String patente){
        this.patente = patente;
    }

    // Getters y Setters

    public String getPatente(){
        return patente;
    }

    public void setPatente(String patente){
        this.patente = patente;
    }

    // Método para obtener el precio base (2000 por día)
    public double getPrecioBase() {
        return PRECIO_BASE_DIARIO;
    }

    // Método abstracto para calcular el precio total, sobrescrito por las subclases
    public abstract double calcularPrecio(int dias_alquiler);
    
}
