package ActividadIntegradora;

import java.util.Objects;

public class Pais extends Ubicacion{
    //Fields
    public static int idActual = 0;

    //Constructores
    public Pais() {
    	super();
    	this.id = idActual;
        idActual++;
    }
    public Pais(String nombre) {
        super(nombre);
        this.id = idActual;
        idActual++;
    }

    //Getters

    //Util
    @Override
	public int hashCode() {
		return Objects.hash(this.getNombre());
	}
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pais) {
        	Pais oCast = (Pais) o; 
            return this.getNombre().equals(oCast.getNombre());
        }
        else {
            return false;
        }
    }
}
