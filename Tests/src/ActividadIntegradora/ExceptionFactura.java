package ActividadIntegradora;

public class ExceptionFactura extends Exception {
    //Fields
    protected int idFacturaError;

    //Constructores
    public ExceptionFactura (int idfactura) {
        this.idFacturaError = idfactura;
    }

    //Getters
    public int getIdFacturaError() {
        return idFacturaError;
    }
    //Ultil
}
