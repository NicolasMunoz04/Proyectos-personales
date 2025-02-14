import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDatos {
    private String maquina = "localhost";
    private String usuario = "root";
    private String clave = "24140401nN_2004";
    private int puerto = 3306;
    private String bd = "cotizador";
    private String servidor;
    
    public AccesoDatos() {
        this.servidor = "jdbc:mysql://" + this.maquina + ":" + this.puerto + "/" + this.bd;
        cargarDriver();
    }

    private void cargarDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver JDBC cargado exitosamente.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver JDBC.");
            e.printStackTrace();
            throw new RuntimeException("No se pudo cargar el driver JDBC.", e);
        }
    }

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(this.servidor, this.usuario, this.clave);
    }
}

