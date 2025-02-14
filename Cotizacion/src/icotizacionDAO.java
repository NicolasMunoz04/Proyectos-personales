import java.util.List;

public interface icotizacionDAO {
    boolean insertarCotizacion(Cotizacion cotizacion); // Inserta una nueva cotización en la BD
    List<Cotizacion> obtenerCotizaciones(); // Obtiene todas las cotizaciones de la BD
}

