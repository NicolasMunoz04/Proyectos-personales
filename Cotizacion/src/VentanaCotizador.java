import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.sql.Statement;


public class VentanaCotizador extends JFrame {
    private JComboBox<VehiculoItem> comboVehiculos;
    private JSpinner spinnerDias;
    private JButton botonCotizar;
    private JTable tablaCotizaciones;
    private DefaultTableModel modeloTabla;

    private cotizacionDAO cotizacionDAO;

    public VentanaCotizador() {
        setTitle("Sistema de Cotización de Vehículos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cotizacionDAO = new cotizacionDAO();

        comboVehiculos = new JComboBox<>();
        spinnerDias = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        botonCotizar = new JButton("Realizar Cotización");

        JPanel panelFormulario = new JPanel(new FlowLayout());
        panelFormulario.add(new JLabel("Vehículo:"));
        panelFormulario.add(comboVehiculos);
        panelFormulario.add(new JLabel("Días:"));
        panelFormulario.add(spinnerDias);
        panelFormulario.add(botonCotizar);

        add(panelFormulario, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Marca", "Modelo", "Días", "Precio", "Fecha"}, 0);
        tablaCotizaciones = new JTable(modeloTabla);
        add(new JScrollPane(tablaCotizaciones), BorderLayout.CENTER);

        cargarVehiculos();
        cargarCotizaciones();

        botonCotizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCotizacion();
            }
        });
    }

    private void cargarVehiculos() {
        try (Connection conn = new AccesoDatos().conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idVehiculo, Marca, Modelo FROM vehiculo")) {
    
            comboVehiculos.removeAllItems();
            while (rs.next()) {
                int idVehiculo = rs.getInt("idVehiculo");
                String descripcion = rs.getString("Marca") + " " + rs.getString("Modelo");
                comboVehiculos.addItem(new VehiculoItem(idVehiculo, descripcion));
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    private void cargarCotizaciones() {
        List<Cotizacion> cotizaciones = cotizacionDAO.obtenerCotizaciones();
        modeloTabla.setRowCount(0);
        for (Cotizacion cotizacion : cotizaciones) {
            modeloTabla.addRow(new Object[]{
                    cotizacion.getIdCotizacion(),
                    cotizacion.getMarca(),
                    cotizacion.getModelo(),
                    cotizacion.getCantidadDias(),
                    cotizacion.getPrecioCotizacion(),
                    cotizacion.getFechaCreacion()
            });
        }
    }

    private void realizarCotizacion() {
        VehiculoItem vehiculoSeleccionado = (VehiculoItem) comboVehiculos.getSelectedItem();
        if(vehiculoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Porfavor, seleccione un vehiculo");
            return;
        }
        
        int idVehiculo = vehiculoSeleccionado.getId();
        int dias = (int) spinnerDias.getValue();
        float precio = dias * 1000; // tarifa de prueba
        LocalDate fecha = LocalDate.now();

        Cotizacion cotizacion = new Cotizacion(idVehiculo, vehiculoSeleccionado.toString(), " ", dias, precio, fecha);

        boolean exito = cotizacionDAO.insertarCotizacion(cotizacion);
        if (exito){
            JOptionPane.showMessageDialog(this, "Cotizacion realizada.");
            cargarCotizaciones();
        } else{
            JOptionPane.showMessageDialog(this, "Error al realizar la cotizacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaCotizador().setVisible(true));
    }
}
