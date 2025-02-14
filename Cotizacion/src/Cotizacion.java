import java.time.LocalDate;

public class Cotizacion {
    public int idCotizacion;
    public String marca;
    public String modelo;
    public int cantidadDias;
    public float precioCotizacion;
    public LocalDate fechaCreacion;
    
    // Constructor, getters y setters
    public Cotizacion(int idCotizacion, String marca, String modelo, int cantidadDias, float precioCotizacion, LocalDate fechaCreacion) {
        this.idCotizacion = idCotizacion;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadDias = cantidadDias;
        this.precioCotizacion = precioCotizacion;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters
    public int getIdCotizacion (){
        return idCotizacion;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getCantidadDias(){
        return cantidadDias;
    }

    public float getPrecioCotizacion(){
        return precioCotizacion;
    }

    public LocalDate getFechaCreacion(){
        return fechaCreacion;
    }

    // Setters
    public void setIdCotizacion(int idCotizacion){
        this.idCotizacion = idCotizacion;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setCantidadDias(int cantidadDias){
        this.cantidadDias = cantidadDias;
    }

    public void setPrecioCotizacion(float precioCotizacion){
        this.precioCotizacion = precioCotizacion;
    }

    public void setFechaCreacion(LocalDate fecha_Creacion){
        this.fechaCreacion = fecha_Creacion;
    }
}
