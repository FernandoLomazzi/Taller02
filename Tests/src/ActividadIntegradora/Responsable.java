package ActividadIntegradora;

public class Responsable extends Persona {
    //Fields
    public static int idActual = 0;
    private String oficina;

    //Constructores
    public Responsable() {
    	super();
        this.oficina = new String();
        this.id = idActual;
        idActual++;
    }
    public Responsable(Localidad localidad, String nombre, String oficina) {
        super(localidad, nombre);
        this.oficina = oficina;
        this.id = idActual;
        idActual++;
    }

    //Getters
    public String getOficina() {
        return oficina;
    }

    //Util
}
