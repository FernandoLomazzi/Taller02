package ActividadIntegradora;

public class App {
	public static void main(String[] arg) {
		Pais argentina = new Pais("Argentina");
		Pais uruguay = new Pais("Uruguay");
		Provincia santaFe = new Provincia("Santa Fe",argentina);
		Provincia buenosAires = new Provincia("Buenos Aires",argentina);
		Provincia colonias = new Provincia("Colonias",uruguay);
		Localidad localidad1 = new Localidad("localidad1",santaFe);
		Localidad localidad2 = new Localidad("localidad2",santaFe);
		Localidad localidad3 = new Localidad("localidad3",buenosAires);
		Localidad localidad4 = new Localidad("localidad4",colonias);
		Responsable responsable1 = new Responsable(localidad1,"pedro","of1");
		Responsable responsable2 = new Responsable(localidad2,"juan","of1");
		Responsable responsable3 = new Responsable(localidad3,"rodrigo","of1");
		Bien bien1 = new Bien("bien1","Es el bien1",1,responsable1);
		Bien bien2 = new Bien("bien2","Es el bien2",0.5,responsable2);
		Bien bien3 = new Bien("bien3","Es el bien3",1.25,responsable3);
		Bien bien4 = new Bien("bien4","Es el bien4",0.3,responsable1);
		Proveedor proveedor1 = new Proveedor(localidad1,"proveedor1");
		Proveedor proveedor2 = new Proveedor(localidad2,"proveedor2");
		Proveedor proveedor3 = new Proveedor(localidad3,"proveedor3");
		Proveedor proveedor4 = new Proveedor(localidad4,"proveedor4");
		try {
			//Descomentar para generar la excepcion ExceptionDistintoPais
			//Factura factura6 = new Factura(responsable1,proveedor4);
			//Descomentar para generar la excepcion ExceptionMaximoFactura
			/*Factura factura7 = new Factura(responsable1,proveedor1);
			for(int i=0;i<21;i++){
			    factura7.agregarBien(bien1);
			}*/
			Factura factura1 = new Factura(responsable1,proveedor1);
			factura1.agregarBien(bien1);
			factura1.agregarBien(bien2);
			factura1.agregarBien(bien3);
			factura1.agregarBien(bien4);
			System.out.println("Responsable y Proveedor de la misma Localidad, Provincia y Pais: $"+String.format("%.2f",factura1.setearMonto()));
			Factura factura2 = new Factura(responsable1,proveedor2);
			factura2.agregarBien(bien1);
			factura2.agregarBien(bien2);
			factura2.agregarBien(bien3);
			factura2.agregarBien(bien4);
			System.out.println("Responsable y Proveedor de la misma Provincia y Pais: $"+String.format("%.2f", factura2.setearMonto()));
			Factura factura3 = new Factura(responsable1,proveedor3);
			factura3.agregarBien(bien1);
			factura3.agregarBien(bien2);
			factura3.agregarBien(bien3);
			factura3.agregarBien(bien4);
			System.out.println("Responsable y Proveedor de la mismo Pais: $"+String.format("%.2f",factura3.setearMonto()));
			Factura factura4 = new Factura(responsable2,proveedor3);
			for(int i=0;i<6;i++) {
				factura4.agregarBien(bien1);
			}
			System.out.println("Mas de 5 productos: $"+String.format("%.2f",factura4.setearMonto()));
			Factura factura5 = new Factura(responsable2,proveedor3);
			for(int i=0;i<11;i++) {
				factura5.agregarBien(bien1);
			}
			System.out.println("Mas de 10 productos: $"+String.format("%.2f",factura5.setearMonto()));
			Empresa Serenisima = Empresa.getEmpresa();
			Serenisima.agregarBienes(bien1);
			Serenisima.agregarBienes(bien2);
			Serenisima.agregarBienes(bien3);
			Serenisima.agregarBienes(bien4);
			Serenisima.agregarResponsable(responsable1);
			Serenisima.agregarResponsable(responsable2);
			Serenisima.agregarResponsable(responsable3);
			Serenisima.agregarProveedor(proveedor1);
			Serenisima.agregarProveedor(proveedor2);
			Serenisima.agregarProveedor(proveedor3);
			Serenisima.agregarProveedor(proveedor4);
			Serenisima.agregarFactura(factura1);
			Serenisima.agregarFactura(factura2);
			Serenisima.agregarFactura(factura3);
			Serenisima.agregarFactura(factura4);
			Serenisima.agregarFactura(factura5);
			System.out.println("Facturas para proveedor 3: \n"+Serenisima.listarFacturaByProveedor(proveedor3));
			System.out.println("Facturas para responsable 1: \n"+Serenisima.listarFacturaByResponsable(responsable1));
			System.out.println("Nombre de Proveedores de localidad 1: \n"+Serenisima.listarNombresProveedores(localidad1));
			System.out.println("Bienes solicitados por responsables de localidad1 : \n"+Serenisima.listarBienesByLocalidad(localidad1));
			System.out.println("Bienes con precio mayor a $0.4: \n"+Serenisima.listarBienesByPrecioMayor(0.4));
			System.out.println("Facturas con monto mayor a $5: \n"+Serenisima.listarFacturasByMontoMayor(5.0));
			System.out.println("Facturas realizadas por proveedor 3: \n"+Serenisima.listarFacturasPorProveedor(proveedor3));
		}
		catch(ExceptionDistintoPais e) {
			System.out.println("Error Factura "+e.getIdFacturaError()+": Responsable y proveedor son de países distintos");
		}
		catch(ExceptionMaximoFactura e) {
			System.out.println("Error Factura "+e.getIdFacturaError()+": Factura llena");
		}
	}
}
