package ActividadIntegradora;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class Empresa {
	private ArrayList<Responsable> responsables;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Factura> facturas;
	private ArrayList<Bien> bienes;
	private static Empresa empresaInstancia;
	private Empresa() { 
		super();
		responsables = new ArrayList<Responsable>();
		proveedores = new ArrayList<Proveedor>();
		facturas = new ArrayList<Factura>();
		bienes = new ArrayList<Bien>();
	}
	public static Empresa getEmpresa() {
		if(empresaInstancia == null) 
			empresaInstancia = new Empresa();
		return empresaInstancia;
	}
	// Lista todas las facturas que cumplan el predicado
	private ArrayList<Factura> listarFacturasFiltradas(Predicate<Factura> pred){
		return  (ArrayList<Factura>) facturas.stream().filter(pred).collect(Collectors.toList());
	}
	// Lista todas las facturas de un proveedor especificado. 
	public ArrayList<Factura> listarFacturaByProveedor(Proveedor p){
		return listarFacturasFiltradas((f) -> f.getProveedor().equals(p));
	}
	// Lista todas las facturas de un responsable especificado.
	public ArrayList<Factura> listarFacturaByResponsable(Responsable r){ 
		return listarFacturasFiltradas((f) -> f.getResponsable().equals(r));
	}
	/* Lista todos los nombres de los proveedores por
	 *  una determinada Localidad, ordenado de forma ascendente por nombre	*/
	public ArrayList<String> listarNombresProveedores(Localidad l){
		return (ArrayList<String>) proveedores.stream()
				.filter((p) -> p.esDeLocalidad(l))
				.map((p) -> p.getNombre())
				.sorted()
				.collect(Collectors.toList());
	}
	private ArrayList<Bien> listarBienesFiltrados(Predicate<Bien> pred){
		return (ArrayList<Bien>) bienes.stream().filter(pred).collect(Collectors.toList());
	}
	// Lista todos los bienes solicitados por los responsables que residen en una Localidad especificada.
	public ArrayList<Bien> listarBienesByLocalidad(Localidad l){
		return listarBienesFiltrados((b) -> b.getResponsable().getLocalidad().equals(l));
	}
	// Lista todos los bienes con un precio mayor a un valor pasado por par�metros.
	public ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor){
		return listarBienesFiltrados((b) -> b.getPrecio() > precioMayor);
	}
	/*  Lista todas las facturas realizadas por un proveedor p,
	 *  ordenado por fecha de forma Descendente en formato DIA/MES/A�O	*/
	public ArrayList<String> listarFacturasPorProveedor(Proveedor p){
		Collections.sort(facturas,				
				new Comparator<Factura>(){
					@Override
					public int compare(Factura f1, Factura f2) {
						if(f1.getFecha().isBefore(f2.getFecha()))
							return -1;
						else if(f1.getFecha().isEqual(f2.getFecha()))
							return 0;
						else
							return 1;
					}
				}
		);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/y");
		return (ArrayList<String>) facturas.stream()
				.filter((f) -> f.getProveedor().equals(p))
				.map((f) -> String.format("En la fecha %h, %h factur� con un total de $%f con %d",
				dtf.format(f.getFecha()),p.getNombre(),f.getMonto_total(),f.getCantidadBienes()))
				.collect(Collectors.toList());
	}
	public void agregarResponsable(Responsable r) {
		responsables.add(r);
	}
	public void agregarProveedor(Proveedor p) {
		proveedores.add(p);
	}
	public void agregarFactura(Factura f) {
		facturas.add(f);
	}
	public void agregarBienes(Bien b) {
		bienes.add(b);
	}
}
