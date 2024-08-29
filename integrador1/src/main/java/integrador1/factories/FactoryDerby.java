package integrador1.factories;

import java.sql.DriverManager;
import java.sql.SQLException;

import integrador1.daos.DaoCliente;
import integrador1.daos.DaoFactura;
import integrador1.daos.DaoFacturaProducto;
import integrador1.daos.DaoProducto;
import integrador1.daosImplementationDerby.DaoClienteImplDerby;
import integrador1.daosImplementationDerby.DaoFacturaImplDerby;
import integrador1.daosImplementationDerby.DaoFacturaProductoImplDerby;
import integrador1.daosImplementationDerby.DaoProductoImplDerby;

public class FactoryDerby extends Factory{
	private static FactoryDerby instance;
	
	public FactoryDerby() {
		driver =  "org.apache.derby.jdbc.EmbeddedDriver";
		uri =  "jdbc:derby:MyDerbyDb;create=true";
	}

	@Override
	public void beginConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conex = DriverManager.getConnection(uri);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void closeConnection() {
		try {
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public DaoCliente getDaoCliente() {
		return new DaoClienteImplDerby(conex);
	}

	@Override
	public DaoProducto getDaoProducto() {
		return new DaoProductoImplDerby(conex);
	}

	@Override
	public DaoFactura getDaoFactura() {
		return new DaoFacturaImplDerby(conex);
	}

	@Override
	public DaoFacturaProducto getDaoFacturaProducto() {
		return new DaoFacturaProductoImplDerby(conex);
	}
	
	public static FactoryDerby getInstance() {
		if(instance == null) {
			instance = new FactoryDerby();
		}
		return instance;
	}
	
}
