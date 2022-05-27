package ActividadIntegradora;

import java.util.Objects;

public class Provincia extends Ubicacion {
    //Fields
    public static int idActual = 1;
    private Pais pais;

    //Constructores
    public Provincia() {
    	super();
    	this.pais = new Pais();
    	this.id = idActual;
    	idActual++;
    }
    public Provincia(String nombre, Pais pais) {
        super(nombre);
        this.pais = pais;
        this.id = idActual;
        idActual++;
    }

    //Getters
    public Pais getPais() {
        return pais;
    }

    //Util
    @Override
	public int hashCode() {
		return Objects.hash(this.getNombre(),this.getPais());
	}
    @Override
     public boolean equals(Object o) {
        if (o instanceof Provincia) {
            Provincia oCast = (Provincia) o;
            return
                this.getNombre().equals(oCast.getNombre()) &&
                this.getPais().equals(oCast.getPais());
        }
        return false;
    }
}

