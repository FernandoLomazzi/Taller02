package ActividadIntegradora;

public abstract class Persona implements CriterioBusqueda<Localidad> {
    //Fields
    protected int id;
    protected Localidad localidad;
    protected String nombre;

    //Constructores
    public Persona() {
    	super();
        this.localidad = new Localidad();
        this.nombre = new String();
    }
    public Persona(Localidad localidad, String nombre) {
    	super();
        this.localidad = localidad;
        this.nombre = nombre;
    }

    //Getters
    public Localidad getLocalidad() {
        return localidad;
    }

    public String getNombre() {
        return nombre;
    }

    //Util
    public boolean esDeLocalidad(Localidad l) {
        return localidad.equals(l);
    }
}
