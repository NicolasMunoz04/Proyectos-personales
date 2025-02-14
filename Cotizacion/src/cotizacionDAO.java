import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cotizacionDAO implements icotizacionDAO {
    private Connection connection;

    // Constructor: inicializa la conexión a la base de datos
    public cotizacionDAO() {
        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            this.connection = accesoDatos.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para insertar una cotización
    @Override
    public boolean insertarCotizacion(Cotizacion cotizacion) {
        String sql = "INSERT INTO cotizacion (idVehiculo, cantidadDias, precioCotizacion, fecha_Creacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cotizacion.getIdCotizacion()); // idVehiculo (ajustar según lógica)
            stmt.setInt(2, cotizacion.getCantidadDias());
            stmt.setFloat(3, cotizacion.getPrecioCotizacion());
            stmt.setDate(4, Date.valueOf(cotizacion.getFechaCreacion()));

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para obtener todas las cotizaciones
    @Override
    public List<Cotizacion> obtenerCotizaciones() {
        List<Cotizacion> cotizaciones = new ArrayList<>();
        String sql = "SELECT c.idCotizacion, v.Marca, v.Modelo, c.cantidadDias, c.precioCotizacion, c.fecha_Creacion " +
                     "FROM cotizacion c " +
                     "INNER JOIN vehiculo v ON c.idVehiculo = v.idVehiculo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Crear objeto Cotizacion a partir de los datos de la BD
                Cotizacion cotizacion = new Cotizacion(
                        rs.getInt("idCotizacion"),
                        rs.getString("Marca"),
                        rs.getString("Modelo"),
                        rs.getInt("cantidadDias"),
                        rs.getFloat("precioCotizacion"),
                        rs.getDate("fecha_Creacion").toLocalDate()
                );
                cotizaciones.add(cotizacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotizaciones;
    }
}
