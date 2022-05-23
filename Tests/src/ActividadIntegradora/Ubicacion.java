package ActividadIntegradora;

public abstract class Ubicacion {
    //Fields
    protected String nombre;
    protected int id;

    //Constructores
    public Ubicacion() {
    	super();
    	this.nombre = new String();
    }
    public Ubicacion(String nombre) {
    	super();
        this.nombre = nombre;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    //Util
}
