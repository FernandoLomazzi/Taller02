package ActividadIntegradora;

public class Bien {
    //Fields
    public static int idActual = 1;
    private int id;
    private String alias;
    private String descripcion;
    private double precio;
    private Responsable responsable;

    //Constructor
    public Bien() {
        super();
        this.alias = new String();
        this.descripcion = new String();
        this.responsable = new Responsable();
    	this.id = idActual;
        idActual++;
    }
    public Bien(String alias, String descripcion, double precio, Responsable responsable) {
        super();
        this.alias = alias;
        this.descripcion = descripcion;
        this.precio = precio;
        this.responsable = responsable;
    	this.id = idActual;
        idActual++;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    //Util
    public String toString() {
    	return "Bien "+this.id;
    }
}
