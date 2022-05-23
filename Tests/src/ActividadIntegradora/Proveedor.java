package ActividadIntegradora;

import java.util.ArrayList;

public class Proveedor extends Persona {
    //Fields
    public static int idActual = 0;
    private ArrayList<Bien> bienes;

    //Constructor
    public Proveedor() {
    	super();
    	bienes = new ArrayList<>();
    	this.id = idActual;
        idActual++;
    }
    public Proveedor(Localidad localidad, String nombre) {
        super(localidad, nombre);
        bienes = new ArrayList<>();
        this.id = idActual;
        idActual++;
    }

    //Getters
    public ArrayList<Bien> getBienes() {
        return bienes;
    }

    //Util
    public void agregarBien(Bien bien) {
        bienes.add(bien);
    }
}
