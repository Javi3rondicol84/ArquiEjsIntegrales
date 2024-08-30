package integrador1.main;

import integrador1.daos.DaoCliente;
import integrador1.daos.DaoFactura;
import integrador1.daos.DaoFacturaProducto;
import integrador1.daos.DaoProducto;
import integrador1.entities.Cliente;
import integrador1.entities.Factura;
import integrador1.entities.FacturaProducto;
import integrador1.entities.Producto;
import integrador1.factories.Factory;
import integrador1.factories.FactoryMySQL;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		Factory factory = FactoryMySQL.getFactory("MySQL");
		factory.beginConnection();
		DaoCliente daoCliente = factory.getDaoCliente();
		DaoFactura daoFactura = factory.getDaoFactura();
		DaoProducto daoProducto = factory.getDaoProducto();
		DaoFacturaProducto daoFacturaProducto = factory.getDaoFacturaProducto();
		inicialice(daoCliente, daoFactura, daoProducto, daoFacturaProducto);
		daoProducto.deleteTable();
		factory.closeConnection();

	}

	public static void inicialice(DaoCliente daoCliente,DaoFactura daoFactura , DaoProducto daoProducto, DaoFacturaProducto daoFacturaProducto) {
		daoCliente.createTable();
		daoFactura.createTable();
		daoProducto.createTable();
		daoFacturaProducto.createTable();
		insertDatas(daoCliente,daoFactura,daoProducto,daoFacturaProducto);
	}

	public static void insertDatas(DaoCliente daoCliente,DaoFactura daoFactura, DaoProducto daoProducto, DaoFacturaProducto daoFacturaProducto) {
		insertClientData(daoCliente);
		insertProductData(daoProducto);
		insertFacturaData(daoFactura);
	}

	public static void insertFacturaData(DaoFactura daoFactura) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new
					FileReader("src/main/resources/facturas.csv"));
			for(CSVRecord row: parser) {
				int idFactura = Integer.parseInt(row.get("idFactura"));
				int idCliente = Integer.parseInt(row.get("idCliente"));
				Factura factura = new Factura(idFactura, idCliente);
				daoFactura.insert(factura);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	public static void insertProductData(DaoProducto daoProducto){
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new
					FileReader("src/main/resources/productos.csv"));
			for(CSVRecord row: parser) {
				int idProdcuto = Integer.parseInt(row.get("idProducto"));
				String nombre = row.get("nombre");
				Float valor = Float.parseFloat(row.get("valor"));
				Producto producto = new Producto(idProdcuto,nombre,valor);
				daoProducto.insert(producto);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void insertClientData(DaoCliente daocliente) {
		CSVParser parser = null;
		try {
			// a mi en esta parte me anda con una ruta absoluta :,((o poniendo integrador1 al frente)
			parser = CSVFormat.DEFAULT.withHeader().parse(new
					FileReader("src/main/resources/clientes.csv"));
			for(CSVRecord row: parser) {
				int idCliente = Integer.parseInt(row.get("idCliente"));
				String nombre = row.get("nombre");
				String email  = row.get("email");
				Cliente cliente = new Cliente(idCliente,nombre,email);
				daocliente.insert(cliente);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
