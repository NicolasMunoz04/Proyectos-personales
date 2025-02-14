public class VehiculoItem {
    private int id;
    private String descripcion;

    public VehiculoItem (int id, String descrpcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return descripcion; // Se muestra en el JComboBox
    }
}
