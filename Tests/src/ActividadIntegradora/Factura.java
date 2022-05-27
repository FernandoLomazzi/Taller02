package ActividadIntegradora;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Factura {
    //Fields
    public static int idActual = 1;
    private int id;
    private double monto_total;
    private ArrayList<Bien> bienes;
    private Responsable responsable;
    private Proveedor proveedor;
    private LocalDateTime fecha;
    
    //Constructores
    public Factura() {
    	super();
        this.responsable = new Responsable();
        this.proveedor = new Proveedor();
        this.bienes = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.id = idActual;
        idActual++;
    }
    public Factura(Responsable responsable, Proveedor proveedor) throws ExceptionDistintoPais {
        super();
        //Obtener los paises de los responsables y proveedores
        Pais paisResponsable = responsable.getLocalidad().getProvincia().getPais();
        Pais paisProveedor = proveedor.getLocalidad().getProvincia().getPais();
        //Setear
        this.responsable = responsable;
        this.proveedor = proveedor;
        this.bienes = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.id = idActual;
        idActual++;
        //Si estan en distintos paises
        if (!paisResponsable.equals(paisProveedor)) {
            throw new ExceptionDistintoPais(this.id);
        }
    }
    
    //Getters
    public int getCantidadBienes() {
    	return bienes.size();
    }
    
    public int getId() {
        return id;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public ArrayList<Bien> getBienes() {
        return bienes;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    //Util
    @Override
    public String toString() {
    	return "Factura "+this.id;
    }
    //Setea la variable monto_total
    public double setearMonto() {
        //Devuelve el nuevo monto_total de la factura

       double montoTotalAux = 0;
       Localidad localidadResponsable = this.responsable.getLocalidad();
       Provincia provinciaResponsable = this.responsable.getLocalidad().getProvincia();
       Pais paisResponsable = this.responsable.getLocalidad().getProvincia().getPais();
       Provincia provinciaProveedor = this.proveedor.getLocalidad().getProvincia();
       Pais paisProveedor = this.proveedor.getLocalidad().getProvincia().getPais();

       //Suma montos
       for (Bien bien : bienes) {
            montoTotalAux +=  bien.getPrecio();
       }

        //Si el proveedor es de la misma localidad que el responsable
       if (this.proveedor.esDeLocalidad(localidadResponsable)) {
           montoTotalAux = montoTotalAux + 0.1*montoTotalAux;
       }

       //Si el proveedor es de la misma provincia que el responsable
       else if (provinciaProveedor.equals(provinciaResponsable)) {
           montoTotalAux = montoTotalAux + 0.3*montoTotalAux;
       }

       //Si el proveedor es del mismo pais que el responsable
       else if (paisProveedor.equals(paisResponsable)) {
           montoTotalAux = montoTotalAux + 0.7*montoTotalAux;
       }

       //Descuento sobre el monto total
       double descuento = 0;

       //La cantidad de bienes es mayor a 5
        if (this.bienes.size() > 5) {
            descuento = montoTotalAux*0.1;
        }

        //La cantidad de bienes es mayor a 10
        else if (this.bienes.size() > 10) {
            descuento = montoTotalAux*0.2;
        }

        //Settear monto_total
        this.monto_total = montoTotalAux-descuento;
        return monto_total;
    }

    //Permite agregar un bien a la factura
    public void agregarBien (Bien bien) throws ExceptionMaximoFactura{
        //Si no se supera la cantidad maxima
        if (this.bienes.size() < 20) {
           this.bienes.add(bien);
        }
        //Si se supera la cantidad maxima
        else {
            throw new ExceptionMaximoFactura(this.id);
        }
    }
}

