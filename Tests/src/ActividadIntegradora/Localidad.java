package ActividadIntegradora;

import java.util.Objects;

public class Localidad extends Ubicacion {
    //Fields
    public static int idActual = 1;
    private Provincia provincia;

    //Constructores
    public Localidad() {
    	super();
    	this.provincia = new Provincia();
        this.id = idActual;
        idActual++;
    }
    public Localidad(String nombre, Provincia provincia) {
    	super(nombre);
        this.provincia = provincia;
        this.id = idActual;
        idActual++;
    }

    //Getters
    public Provincia getProvincia() {
        return provincia;
    }

    //Util
	@Override
	public int hashCode() {
		return Objects.hash(provincia,this.getNombre());
	}
    @Override
    public boolean equals (Object o) {
        if (o instanceof Localidad) {
            Localidad oCast = (Localidad) o;
            return
                this.getNombre().equals(oCast.getNombre()) &&
                this.getProvincia().equals(oCast.getProvincia());
        }
        return false;
    }
}
